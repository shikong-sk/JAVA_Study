package cn.skcks.server.core;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class Dispatcher implements Runnable {
    private Socket client;
    private Request request;
    private Response response;

    @Override
    public void run() {

        try{
            // 写入响应内容
            response.addContentWithCRLF("<html>");
            response.addContentWithCRLF("    <head>");
            response.addContentWithCRLF("        <meta charset='utf-8'>");
            response.addContentWithCRLF("        <title> Sk Web Server </title>");
            response.addContentWithCRLF("    </head>");
            response.addContentWithCRLF("    <body>");
            Servlet servlet = WebApp.getServlet(request.getUrl());
            if (servlet != null) {
                String[] keys = request.getParameterKey();
                response.addContentWithCRLF("        <h3> Hello World </h3>");
                response.addContentWithCRLF("        <h5> 时空 Web 服务器 </h5>");
                if (keys != null) {
                    response.addContentWithCRLF("        <h5>");
                    response.addContent("您请求的参数为：<br>");
                    for (String key : keys) {
                        response.addContent(key + " => ");
                        response.addContent(Arrays.deepToString(request.getParameterValue(key)));
                        response.addContent("<br>");
                    }
                    response.addContentWithCRLF("        </h5>");
                }

                // 执行 servlet 内容
                servlet.service(request, response);
            }
            else{
                if(request.getUrl().startsWith(".") || request.getUrl().startsWith(".."))
                {
                    response.addContentWithCRLF("<h1>403 Forbidden - 访问被拒绝</h1>");
                    response.response(403);
                    release();
                    return;
                }
                else{
                    File file = new File(request.getUrl());
                    if(!file.exists())
                    {
                        response.addContentWithCRLF("<h1>404 Not Found - 请求的资源不存在</h1>");
                        response.response(404);
                        release();
                        return;
                    }
                    else{
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] flush = new byte[1024 * 512];
                        int len;
                        while((len = bufferedInputStream.read(flush)) != -1)
                        {
                            outputStream.write(flush,0,len);
                            if(len<flush.length)
                            {
                                break;
                            }
                        }
                        outputStream.flush();
                        response.responseByte(outputStream.toByteArray());

                        release();
                        return;
                    }
                }
            }

            response.addContentWithCRLF("    </body>");
            response.addContentWithCRLF("</html>");

            // 指定状态码 返回响应请求
            response.response(200);
        }catch (Exception e){
            response.addContentWithCRLF("<h1>服务器内部错误</h1>");
            response.response(500);
            return;
        }
        release();
    }

    public Dispatcher(Socket client) {
        this.client = client;
        try {
            // 获取请求协议
            this.request = new Request(client);
            this.response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
            release();
        }
    }

    private void release() {
        try {
            client.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
