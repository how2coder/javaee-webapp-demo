package io.how2coder.demo.web.servlet;

import io.how2coder.demo.model.Department;
import jakarta.servlet.ServletException;
import jakarta.servlet.UnavailableException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentEditorServlet", displayName = "DepartmentEditorServlet", urlPatterns = "/departments/create")
public class DepartmentEditorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/department-editor.jsp").forward(req, resp);
    }
}
