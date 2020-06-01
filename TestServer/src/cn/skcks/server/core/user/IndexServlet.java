package cn.skcks.server.core.user;

import cn.skcks.server.core.Request;
import cn.skcks.server.core.Response;
import cn.skcks.server.core.Servlet;

public class IndexServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        System.out.println("执行：cn.skcks.server.IndexServlet.service()\n");
        response.addContentWithCRLF("        <h1> Servlet 脚本首页 </h1>");
    }
}
