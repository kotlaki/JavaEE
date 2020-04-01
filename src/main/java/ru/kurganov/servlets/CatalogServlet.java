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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CatalogServlet", urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(CatalogServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet CatalogServlet");

        List<Products> products = new ArrayList<>();
        products.add(new Products(1, "Product1", "Описание"));
        products.add(new Products(2, "Product2", "Desc2"));
        products.add(new Products(3, "Product3", "Desc3"));
        products.add(new Products(4, "Product4", "Desc4"));
        products.add(new Products(5, "Product5", "Desc5"));
        products.add(new Products(6, "Product6", "Desc6"));
        products.add(new Products(7, "Product7", "Desc7"));
        products.add(new Products(8, "Product8", "Desc8"));
        products.add(new Products(9, "Product9", "Desc9"));
        req.setAttribute("products", products);

        getServletContext().getRequestDispatcher("/WEB-INF/catalog.jsp").include(req, resp);
    }
}
