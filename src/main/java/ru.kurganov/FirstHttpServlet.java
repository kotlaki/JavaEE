package ru.kurganov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FirstHttpServlet", urlPatterns = "/httpservlet/*")
public class FirstHttpServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(FirstHttpServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>FirstHttpServlet</h1>");
        resp.getWriter().println("<p>getContentPath: " + req.getContextPath() + "</p>");
        resp.getWriter().println("<p>getServletPath: " + req.getServletPath() + "</p>");
        resp.getWriter().println("<p>getPathInfo: " + req.getPathInfo() + "</p>");
        resp.getWriter().println("<p>getQueryString: " + req.getQueryString() + "</p>");
        resp.getWriter().println("<p>getParameter1: " + req.getParameter("Param1") + "</p>");
        resp.getWriter().println("<p>getParameter2: " + req.getParameter("Param2") + "</p>");

        resp.setHeader("Content-type", "text/html; charset=utf8");
//        resp.sendRedirect("https://www.ya.ru");   // будет происходить переадресация на внешний ресурс
//        resp.sendRedirect(req.getContextPath() + "/"); // в данном случае задействуется браузер

        // переадресация с использованием сервера приложения
//        getServletContext().getRequestDispatcher("/").forward(req, resp);
        req.setAttribute("attr1", "value"); // передача параметров между сервлетами
        getServletContext().getRequestDispatcher("/firstservlet").include(req, resp);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").include(req, resp); // можно делать переадресацию на файлы в защищенных директориях
    }
}
