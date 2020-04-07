package ru.kurganov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kurganov.ProductRepository;
import ru.kurganov.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;


@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(ProductServlet.class);

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
//        logger.info("doGet ProductServlet");
//        getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").include(req, resp);
        if (req.getServletPath().equals("/")) {
            req.setAttribute("products", productRepository.findAll());
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else if (req.getServletPath().equals("/create")) {
            showCreateProductPage(req, resp);
        } else if (req.getServletPath().equals("/edit")) {
            showEditProductPage(req, resp);
        } else if (req.getServletPath().equals("/delete")) {
            deleteProduct(req, resp);
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
        } catch (NumberFormatException e) {
            logger.error("", e);
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
        } catch (NumberFormatException e) {
            logger.error("", e);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            productRepository.delete(Long.parseLong(req.getParameter("id")));
            resp.sendRedirect(getServletContext().getContextPath());
        } catch (NumberFormatException e) {
            logger.error("", e);
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
        product = productRepository.findById(id);
        req.setAttribute("product", product);
        req.setAttribute("action", "update");
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }

    private void showCreateProductPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", new Products());
        req.setAttribute("action", "create");
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }
}
