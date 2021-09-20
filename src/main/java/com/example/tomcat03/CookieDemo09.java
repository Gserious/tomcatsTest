package com.example.tomcat03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieDemo09")
public class CookieDemo09 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println();// new Date()为获取当前系统时间
        Cookie c1 = new Cookie("lasttime",df.format(new Date()));
        resp.addCookie(c1);

        Cookie[] cs = req.getCookies();
        if (cs != null){
            for (Cookie c: cs) {
            if(c.getName().equals("lasttime")){
                System.out.println("欢迎回来上次访问时间是："+c.getValue());
            }else {
                System.out.println("您好，欢迎您首次访问！");
            }
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
