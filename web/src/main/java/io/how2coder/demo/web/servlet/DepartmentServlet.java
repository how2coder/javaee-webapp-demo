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

@WebServlet(name = "DepartmentServlet", displayName = "DepartmentServlet", urlPatterns = "/departments/*")
public class DepartmentServlet extends HttpServlet {

    private final DepartmentService departmentService = DepartmentServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        Long id = Long.parseLong(pathInfo.split("/")[1]);

        Department department = departmentService.getDepartmentById(id)
                .orElseThrow(() -> new UnavailableException("Unable to read information about department"));

        req.setAttribute("department", department);
        req.getRequestDispatcher("/department.jsp").forward(req, resp);
    }
}
