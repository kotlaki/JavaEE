package ru.kurganov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kurganov.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CatalogServlet", urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(CatalogServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet CatalogServlet");

        List<Products> products = new ArrayList<>();
        products.add(new Products(-1L, "Product1", "Описание", new BigDecimal(100)));
        products.add(new Products(-1L, "Product2", "Desc2", new BigDecimal(235)));
        products.add(new Products(-1L, "Product3", "Desc3", new BigDecimal(564)));
        products.add(new Products(-1L, "Product4", "Desc4", new BigDecimal(5641)));
        products.add(new Products(-1L, "Product5", "Desc5", new BigDecimal(1200)));
        products.add(new Products(-1L, "Product6", "Desc6", new BigDecimal(400)));
        products.add(new Products(-1L, "Product7", "Desc7", new BigDecimal(676)));
        products.add(new Products(-1L, "Product8", "Desc8", new BigDecimal(150)));
        products.add(new Products(-1L, "Product9", "Desc9", new BigDecimal(600)));
        req.setAttribute("products", products);

        getServletContext().getRequestDispatcher("/WEB-INF/catalog.jsp").include(req, resp);
    }
}
