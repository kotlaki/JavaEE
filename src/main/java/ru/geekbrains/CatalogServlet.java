package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.ProductRepository;
import ru.geekbrains.persist.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@WebServlet(name = "CatalogServlet", urlPatterns = {"/", "", "/catalog"})
public class CatalogServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(CatalogServlet.class);
    private ProductRepository productRepository;
    @Override
    public void init() throws ServletException {
        this.productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");

        if (productRepository == null) {
            throw new ServletException("ProductRepository not created");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if(req.getServletPath().equals("/")) {
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            } else if (req.getServletPath().equals("/catalog")) {
                req.setAttribute("products", productRepository.findAll());
                getServletContext().getRequestDispatcher("/catalog.jsp").forward(req, resp);
            } else if (req.getServletPath().equals("/create")) {
                showCreateProductPage(req, resp);
            } else if (req.getServletPath().equals("/edit")) {
                showEditProductPage(req, resp);
            } else if (req.getServletPath().equals("/delete")) {
                deleteProduct(req, resp);
            }
        } catch (SQLException e) {
            logger.error("", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getServletPath().equals("/update")) {
            updateProduct(req, resp);
        } else if (req.getServletPath().equals("/create")) {
            createProduct(req, resp);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            productRepository.insert(new Products(
                    -1L,
                    req.getParameter("name"),
                    req.getParameter("description"),
                    new BigDecimal(req.getParameter("price"))
            ));
            resp.sendRedirect(getServletContext().getContextPath());
        } catch (SQLException ex) {
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (NumberFormatException ex) {
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            productRepository.update(new Products(
                    Long.parseLong(req.getParameter("id")),
                    req.getParameter("name"),
                    req.getParameter("description"),
                    new BigDecimal(req.getParameter("price"))
            ));
            resp.sendRedirect(getServletContext().getContextPath());
        } catch (SQLException ex) {
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (NumberFormatException ex) {
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            productRepository.delete(Long.parseLong(req.getParameter("id")));
            resp.sendRedirect(getServletContext().getContextPath());
        } catch (SQLException ex) {
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (NumberFormatException ex) {
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void showEditProductPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception ex) {
            logger.error("", ex);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Products product;
        try {
            product = productRepository.findById(id);
        } catch (SQLException ex) {
            logger.error("", ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        req.setAttribute("product", product);
        req.setAttribute("action", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(req, resp);
    }

    private void showCreateProductPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", new Products());
        req.setAttribute("action", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(req, resp);
    }
}
