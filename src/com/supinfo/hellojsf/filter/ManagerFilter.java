package com.supinfo.hellojsf.filter;

import com.supinfo.hellojsf.entity.EmployeeEntity;
import com.supinfo.hellojsf.entity.ManagerEntity;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexandre NGUYEN on 16/10/2014.
 */

@WebFilter(filterName = "ManagerFilter", urlPatterns = {"/manager_home.xhtml", "/add_client.xhtml", "/add_employee.xhtml"})
public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Object user = ((HttpServletRequest) servletRequest).getSession().getAttribute("UserSession");

        if (!(user instanceof ManagerEntity)) {
            String contextPath = ((HttpServletRequest) servletRequest).getContextPath();
            ((HttpServletResponse) servletResponse).sendRedirect(contextPath + "/login.xhtml");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
