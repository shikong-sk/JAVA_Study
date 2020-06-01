package cn.skcks.server.core.user;

import cn.skcks.server.core.Request;
import cn.skcks.server.core.Response;
import cn.skcks.server.core.Servlet;

public class LoginServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        System.out.println("执行：cn.skcks.server.LoginServlet.service()\n");
        response.addContentWithCRLF("        <h3> Servlet 脚本解析 </h3>");
        response.addContentWithCRLF("        <h5> LoginServlet </h5>");
        String user = request.getParameter("user");
        if (user != null) {
            response.addContentWithCRLF("        <h5>欢迎回来：" + user + "</h5>");
        }
    }
}
