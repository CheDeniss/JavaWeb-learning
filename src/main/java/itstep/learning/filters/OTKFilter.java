package itstep.learning.filters;

import com.google.inject.Singleton;

import javax.servlet.*;
import java.io.IOException;

@Singleton
public class OTKFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("control", "passed");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
