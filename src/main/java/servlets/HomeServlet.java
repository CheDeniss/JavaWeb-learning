package servlets;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import itstep.learning.services.hash.HashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class HomeServlet extends HttpServlet {
    private final HashService hashService;

    @Inject
    public HomeServlet(@Named("digest") HashService hashService) {
        this.hashService = hashService;
        //this.userDao = userDao;
    }

    public HomeServlet() {
        this.hashService = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("page", "home");

        if ("passed".equals(req.getAttribute("control"))) {
            req.setAttribute("OTK", "OTK passed!");

        } else {
            req.setAttribute("OTK", "OTK not passed!");
        }

        req.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(req, resp);
    }
    }
/*
Д.З. Після надсилання форми реєстрації користувача вивести (замість
порожньої сторінки) передані дані (для файлу - ім'я та *розмір)
 */