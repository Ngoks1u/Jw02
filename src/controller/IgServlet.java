package controller;

import jdk.internal.util.xml.impl.Input;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name="ImgServlet",urlPatterns="/ig")
public class IgServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到上下文
        ServletContext application = getServletContext();
        //得到一个文件输入流
        InputStream in =application.getResourceAsStream("/WEB-INF/1.jpg");
        //得到某个资源的真实资源
        String realPath=application.getRealPath("/WEB-INF/1.jpg");
        //得到一个输出流
        OutputStream out = resp.getOutputStream();//字节流
        //设置响应头
        resp.setContentType("image/jpeg");
        //输出到浏览器上
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len=in.read(buf))!=-1){
            out.write(buf,0,len);
        }
        in.close();
        out.close();
    }
}
