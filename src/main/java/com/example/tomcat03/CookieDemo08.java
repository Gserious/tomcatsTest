package com.example.tomcat03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieDemo08")
public class CookieDemo08 extends HelloServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset = utf-8");

        Cookie[] cookies = req.getCookies();
        boolean flag  = false;//没有cookie为lasttime

        if (cookies != null & cookies.length>0){

            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lasttime".equals(name)) {
                    flag = true;
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    String str_date = sdf.format(date);


                        String value = cookie.getValue();
                        resp.getWriter().write("<h1>欢迎回来，您上次访问时间是："+value+"</h1>");
                }
            }

        }


        /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Cookie c = new Cookie("lasttime",df.format(new Date()));
        resp.addCookie(c);
        c.setMaxAge(600);*/

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}
