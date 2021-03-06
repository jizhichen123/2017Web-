package com.nicehiro;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet implements javax.servlet.Servlet {

    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest rq = (HttpServletRequest)servletRequest;
        HttpServletResponse rs = (HttpServletResponse)servletResponse;
        doPost(rq, rs);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 构建数据库对象
        DBUtil db = new DBUtil();
        Roles role = db.loginSuccess(username, password);

        if (role.equals(Roles.Student)) {
            response.sendRedirect("backend_student.html");
        } else if (role.equals(Roles.Teacher)) {
            response.sendRedirect("backend_teacher.html");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
