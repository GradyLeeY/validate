package com.grady.firstCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "FirstServlet")
public class FirstServlet extends HttpServlet {

    private Random random = new Random();
    private int width = 80;
    private int height = 30;
    private int fontsize = 12;
    private String str = "0123456789abcdefg";
    //随机颜色方法
    private Color randColor(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r,g,b);
    }

    //生成最少4个字符的随机字符串
    private String randCode(int len){
        if (len < 4){
            len = 4;
        }
        //更改宽度
        width = 5 + fontsize*len;
        //生成字符串
        String code = "";
        for (int i = 0; i < len; i++) {
            code +=  str.charAt(random.nextInt(str.length()));
        }
        return code;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建画板
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.创建画笔
        Graphics2D pen = img.createGraphics();
        //3.生成随机内容
        String code = randCode(4);
        request.getSession().setAttribute("valiCode",code);
        //4.绘制内容
        //  4.1设置绘制区域
        pen.fillRect(0, 0, width, height);
        //  4.2设置字体
        pen.setFont(new Font("微软雅黑", Font.BOLD, fontsize));
        //  4.3按顺序逐个绘制字符
        for (int i = 0; i < code.length(); i++) {
            pen.setColor(randColor());
            //绘制字符
            pen.drawString(code.charAt(i)+"", 5+i*fontsize, (fontsize+height)/2);
        }
        //  4.4绘制噪音线
        for (int i = 0; i < 2; i++) {
            pen.setColor(randColor());
            pen.setStroke(new BasicStroke(3));
            pen.drawLine(random.nextInt(width/2),random.nextInt(height),random.nextInt(width),random.nextInt(height));
        }
        //5.存为图片并发送
        ServletOutputStream out = response.getOutputStream();
        ImageIO.setUseCache(false);
        ImageIO.write(img, "png", out);
        out.flush();
        out.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
