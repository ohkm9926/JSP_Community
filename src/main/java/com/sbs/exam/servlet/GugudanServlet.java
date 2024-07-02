package com.sbs.exam.servlet;

import com.sbs.exam.Rq;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset-utf-8");
        Rq rp = new Rq(req, resp);


        int dan = rp.getIntParam("dan" , 0);
        int limit = rp.getIntParam("limit" , 0);

        rp.appendBody("<h1>%d단 </h1>".formatted(dan));

        for (int i =1; i <= limit; i++) {
            resp.getWriter().append("<div>%d * %d =%d</div>".formatted(dan, i, dan * i));
        }


    }
}
