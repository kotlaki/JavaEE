package ru.kurganov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;

public class FirstServlet implements Servlet, Serializable {

    private Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    private transient ServletConfig servletConfig;

    @java.lang.Override
    public void init(ServletConfig servletConfig) throws ServletException {
        logger.info("Init servlet");

        this.servletConfig = servletConfig;
    }

    @java.lang.Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @java.lang.Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request");

        servletResponse.getWriter().println("<h1>Hello world from firstservlet</h1>");
        servletResponse.getWriter().println("<p>attrib2 = " + servletRequest.getAttribute("attr1") + "</p>");
    }

    @java.lang.Override
    public java.lang.String getServletInfo() {
        return "Hello world firstservlet from getServletInfo()";
    }

    @java.lang.Override
    public void destroy() {
        logger.info("FirstServlet class destroy");
    }
}
