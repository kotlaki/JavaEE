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
        // тут как правило делают проверку авторизации с последующим редиректом
        servletResponse.getWriter().println("<h1>HEADER</h1>");
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.getWriter().println("<h1>FOOTER</h1>");
    }

    @Override
    public void destroy() {

    }
}
