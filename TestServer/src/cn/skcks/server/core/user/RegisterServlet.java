package cn.skcks.server.core.user;

import cn.skcks.server.core.Request;
import cn.skcks.server.core.Response;
import cn.skcks.server.core.Servlet;

public class RegisterServlet implements Servlet {

    @Override
    public void service(Request request, Response response) {
        System.out.println("执行：cn.skcks.server.RegisterServlet.service()\n");
        response.addContentWithCRLF("        <h3> Servlet 脚本解析 </h3>");
        response.addContentWithCRLF("        <h5> RegisterServlet </h5>");
        String user = request.getParameter("user");
        if (user != null) {
            response.addContentWithCRLF("        <h5>注册用户：" + user + "</h5>");
        }
    }
}
