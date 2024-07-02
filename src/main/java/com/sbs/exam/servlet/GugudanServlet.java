package com.sbs.exam.servlet;

import com.sbs.exam.Rq;
import jakarta.servlet.RequestDispatcher;
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


        //request에 정보를 담는다.
        //왜냐하면 나중에 gugudan2.jsp에서 해당 내용을 꺼낼 수 있기 때문에
       req.setAttribute("dan" ,dan);
       req.setAttribute("limit" , limit);
       //gugudan2.jsp에게 나머지를 작업을 토스한다.
        RequestDispatcher requestDispatcher =req.getRequestDispatcher("/gugudan2.jsp");
        requestDispatcher.forward(req,resp);


    }
}
