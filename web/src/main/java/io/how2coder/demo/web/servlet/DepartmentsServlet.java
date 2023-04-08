package io.how2coder.demo.web.servlet;

import io.how2coder.demo.model.Department;
import io.how2coder.demo.services.DepartmentService;
import io.how2coder.demo.services.DepartmentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.UnavailableException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentsServlet", displayName = "DepartmentsServlet", urlPatterns = "/departments")
public class DepartmentsServlet extends HttpServlet {

    private final DepartmentService departmentService = DepartmentServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> departments = departmentService.getAllDepartments()
                .orElseThrow(() -> new UnavailableException("Unable to read information about departments"));

        req.setAttribute("departments", departments);
        req.getRequestDispatcher("/departments.jsp").forward(req, resp);
    }
}
