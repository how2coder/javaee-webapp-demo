package io.how2coder.demo.web.servlet;

import io.how2coder.demo.services.EmployeeService;
import io.how2coder.demo.services.EmployeeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EmployeesServlet", displayName = "EmployeesServlet", urlPatterns = "/employees")
public class EmployeesServlet extends HttpServlet {

    private final EmployeeService employeeService = EmployeeServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/employees.jsp").forward(req, resp);
    }
}
