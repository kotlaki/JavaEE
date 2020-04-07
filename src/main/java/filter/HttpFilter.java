package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HeaderFooter", urlPatterns = "/*")
public class HttpFilter implements Filter {

    private transient FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // задаем кодировку глобально на все страницы
        servletResponse.setContentType("text/html; charset=UTF-8");
//        servletResponse.getWriter().println("<h1>Заголовок из фильтра</h1>");
        filterChain.doFilter(servletRequest,servletResponse);
//        servletResponse.getWriter().println("<h1>Подвал из фильтра</h1>");
    }

    @Override
    public void destroy() {

    }
}
