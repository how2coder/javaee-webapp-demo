package io.how2coder.demo.web.servlet;

import io.how2coder.demo.services.ManagerService;
import io.how2coder.demo.services.ManagerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ManagerServlet", displayName = "ManagerServlet", urlPatterns = "/managers")
public class ManagerServlet extends HttpServlet {

    private final ManagerService managerService = ManagerServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("managers.jsp").forward(req, resp);
    }
}
