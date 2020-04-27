package com.grady.firstCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ValicodeServlet")
public class ValicodeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 得到数据
        String inCode = request.getParameter("inCode").toString().toLowerCase();
        String valicode = request.getSession().getAttribute("valiCode").toString().toLowerCase();
        //2 验证是否正确
        if (inCode.equals(valicode)){
            response.sendRedirect("index.jsp");
        }else {
            request.getSession().setAttribute("err","输入验证码错误,请重新输入");
            String url = request.getHeader("Referer");
            response.sendRedirect(url);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
