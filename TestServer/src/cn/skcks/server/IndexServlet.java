package cn.skcks.server;

public class IndexServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        System.out.println("执行：cn.skcks.server.IndexServlet.service()\n");
        response.addContentWithCRLF("        <h1> Servlet 脚本首页 </h1>");
    }
}
