package ru.kurganov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CompanyServlet", urlPatterns = "/company")
public class CompanyServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(CompanyServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet CompanyServlet");
        getServletContext().getRequestDispatcher("/WEB-INF/company.jsp").include(req, resp);
    }
}
