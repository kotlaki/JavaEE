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
        servletResponse.setCharacterEncoding("UTF-8");
        // тут как правило делают проверку авторизации с последующим редиректом
        servletResponse.getWriter().println("<a href=\"/GbJavaEeWebApp/index.jsp\">Главная</a>   " +
                "<a href=\"/GbJavaEeWebApp/catalog\">Каталог товаров</a>   " +
                "<a href=\"/GbJavaEeWebApp/cart\">Корзина</a>   " +
                "<a href=\"/GbJavaEeWebApp/order\">Оформление заказа</a> " +
                "<a href=\"/GbJavaEeWebApp/company\">О компании</a>");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
