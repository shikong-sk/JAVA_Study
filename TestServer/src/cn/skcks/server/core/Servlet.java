package cn.skcks.server.core;

/*
    服务器脚本接口
 */
public interface Servlet {
    void service(Request request, Response response);
}
