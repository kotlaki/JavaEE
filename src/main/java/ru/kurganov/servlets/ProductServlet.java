package ru.kurganov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kurganov.Products;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "product", urlPatterns = "catalog/product")
public class ProductServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet ProductServlet");
        getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").include(req, resp);
    }
}
