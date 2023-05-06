package io.how2coder.demo.web.servlet;

import io.how2coder.demo.model.Department;
import io.how2coder.demo.services.DepartmentService;
import io.how2coder.demo.services.DepartmentServiceImpl;
import io.how2coder.demo.web.converter.DepartmentConverter;
import io.how2coder.demo.web.converter.WebConverter;
import jakarta.servlet.ServletException;
import jakarta.servlet.UnavailableException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "DepartmentsServlet", displayName = "DepartmentsServlet", urlPatterns = "/departments")
public class DepartmentsServlet extends HttpServlet {

    private final DepartmentService departmentService = DepartmentServiceImpl.getInstance();
    private final WebConverter<Department> departmentConverter = DepartmentConverter.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> departments = departmentService.getAllDepartments()
                .orElseThrow(() -> new UnavailableException("Unable to read information about departments"));

        req.setAttribute("departments", departments);
        req.getRequestDispatcher("/departments.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department department = departmentConverter.toObject(p -> Optional.ofNullable(req.getParameter(p)));
        departmentService.saveDepartment(department);
        resp.sendRedirect("departments");
    }
}
