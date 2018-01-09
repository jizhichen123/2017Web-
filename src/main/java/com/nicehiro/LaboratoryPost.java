package com.nicehiro;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LaboratoryPost implements javax.servlet.Servlet{
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }

    private void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String principal = request.getParameter("principal");
        String apparatus = request.getParameter("apparatus");
        int number = Integer.parseInt(request.getParameter("number"));
        String email = request.getParameter("Email");
        String phone = request.getParameter("Phone");

    }
}
