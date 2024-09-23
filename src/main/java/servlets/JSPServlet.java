package servlets;

import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/jsp")
@Singleton
public class JSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("page", "index");
        req.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(req, resp);
    }
}
