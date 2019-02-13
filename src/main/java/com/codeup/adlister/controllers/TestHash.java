package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.testHash", urlPatterns = "/hash")
public class TestHash extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pass = "dogs";
        System.out.println("pass = " + pass);
        String hash = BCrypt.hashpw(pass, BCrypt.gensalt());
        System.out.println("hash = " + hash);
        hash = BCrypt.hashpw(pass, BCrypt.gensalt());
        System.out.println("hash2 = " + hash);

        System.out.println(BCrypt.checkpw("dogs", hash));

//        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
//            .forward(request, response);
    }


}
