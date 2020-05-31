package cn.skcks.server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/*
    响应信息
 */
public class Response {
    // 公用常量定义
    static private final String BLANK = " ";
    static private final String CRLF = "\r\n";
    static private final String SERVER_VERSION = "Sk Web Server/0.0.1 beta";
    static private final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    // 输出流
    private BufferedWriter bufferedWriter;
    // 返回的正文内容
    private StringBuilder contentBuilder;
    // 返回的协议头部信息
    private StringBuilder responseBuilder;
    // 内容长度 (字节数)
    private int len;

    private Response() {
        contentBuilder = new StringBuilder();
        responseBuilder = new StringBuilder();
        len = 0;
    }

    public Response(Socket client) {
        this();
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            responseBuilder = null;
        }
    }

    public Response(OutputStreamWriter outputStream) {
        this();
        bufferedWriter = new BufferedWriter(outputStream);
    }

    // 构造响应头
    private void responseHeader(int status) {
        responseBuilder.append("HTTP/1.1").append(BLANK).append(status).append(BLANK);
        switch (status) {
            case 100:
                responseBuilder.append("Continue");
                break;                                      //  继续,客户端应继续其请求
            case 101:
                responseBuilder.append("Switching Protocols");
                break;                                      //  切换协议,服务器根据客户端的请求切换协议,只能切换到更高级的协议，例如，切换到HTTP的新版本协议
            case 200:
                responseBuilder.append("OK");
                break;                                      //  请求成功,一般用于GET与POST请求
            case 201:
                responseBuilder.append("Created");
                break;                                      //  已创建,成功请求并创建了新的资源
            case 202:
                responseBuilder.append("Accepted");
                break;                                      //  已接受,已经接受请求，但未处理完成
            case 203:
                responseBuilder.append("Non-Authoritative Information");
                break;                                      //  非授权信息,请求成功,但返回的meta信息不在原始的服务器，而是一个副本
            case 204:
                responseBuilder.append("No Content");
                break;                                      //  无内容,服务器成功处理，但未返回内容,在未更新网页的情况下，可确保浏览器继续显示当前文档
            case 205:
                responseBuilder.append("Reset Content");
                break;                                      //  重置内容,服务器处理成功，用户终端（例如：浏览器）应重置文档视图,可通过此返回码清除浏览器的表单域
            case 206:
                responseBuilder.append("Partial Content");
                break;                                      //  部分内容,服务器成功处理了部分GET请求
            case 300:
                responseBuilder.append("Multiple Choices");
                break;                                      //  多种选择,请求的资源可包括多个位置，相应可返回一个资源特征与地址的列表用于用户终端（例如：浏览器）选择
            case 301:
                responseBuilder.append("Moved Permanently");
                break;                                      //  永久移动,请求的资源已被永久的移动到新URI，返回信息会包括新的URI，浏览器会自动定向到新URI,今后任何新的请求都应使用新的URI代替
            case 302:
                responseBuilder.append("Found");
                break;                                      //  临时移动,与301类似,但资源只是临时被移动,客户端应继续使用原有URI
            case 303:
                responseBuilder.append("See Other");
                break;                                      //  查看其它地址,与301类似,使用GET和POST请求查看
            case 304:
                responseBuilder.append("Not Modified");
                break;                                      //  未修改,所请求的资源未修改，服务器返回此状态码时，不会返回任何资源,客户端通常会缓存访问过的资源，通过提供一个头信息指出客户端希望只返回在指定日期之后修改的资源
            case 305:
                responseBuilder.append("Use Proxy");
                break;                                      //  使用代理,所请求的资源必须通过代理访问
            case 306:
                responseBuilder.append("Unused");
                break;                                      //  已经被废弃的HTTP状态码
            case 307:
                responseBuilder.append("Temporary Redirect");
                break;                                      //  临时重定向,与302类似,使用GET请求重定向
            case 400:
                responseBuilder.append("Bad Request");
                break;                                      //  客户端请求的语法错误，服务器无法理解
            case 401:
                responseBuilder.append("Unauthorized");
                break;                                      //  请求要求用户的身份认证
            case 402:
                responseBuilder.append("Payment Required");
                break;                                      //  保留，将来使用
            case 403:
                responseBuilder.append("Forbidden");
                break;                                      //  服务器理解请求客户端的请求，但是拒绝执行此请求
            case 404:
                responseBuilder.append("Not Found");
                break;                                      //  服务器无法根据客户端的请求找到资源（网页）,通过此代码，网站设计人员可设置"您所请求的资源无法找到"的个性页面
            case 405:
                responseBuilder.append("Method Not Allowed");
                break;                                      //  客户端请求中的方法被禁止
            case 406:
                responseBuilder.append("Not Acceptable");
                break;                                      //  服务器无法根据客户端请求的内容特性完成请求
            case 407:
                responseBuilder.append("Proxy Authentication Required");
                break;                                      //  请求要求代理的身份认证，与401类似，但请求者应当使用代理进行授权
            case 408:
                responseBuilder.append("Request Time-out");
                break;                                      //  服务器等待客户端发送的请求时间过长，超时
            case 409:
                responseBuilder.append("Conflict");
                break;                                      //  服务器完成客户端的 PUT 请求时可能返回此代码，服务器处理请求时发生了冲突
            case 410:
                responseBuilder.append("Gone");
                break;                                      //  客户端请求的资源已经不存在,410不同于404，如果资源以前有现在被永久删除了可使用410代码，网站设计人员可通过301代码指定资源的新位置
            case 411:
                responseBuilder.append("Length Required");
                break;                                      //  服务器无法处理客户端发送的不带Content-Length的请求信息
            case 412:
                responseBuilder.append("Precondition Failed");
                break;                                      //  客户端请求信息的先决条件错误
            case 413:
                responseBuilder.append("Request Entity Too Large");
                break;                                      //  由于请求的实体过大，服务器无法处理，因此拒绝请求,为防止客户端的连续请求，服务器可能会关闭连接,如果只是服务器暂时无法处理，则会包含一个Retry-After的响应信息
            case 414:
                responseBuilder.append("Request-URI Too Large");
                break;                                      //  请求的URI过长（URI通常为网址），服务器无法处理
            case 415:
                responseBuilder.append("Unsupported Media Type");
                break;                                      //  服务器无法处理请求附带的媒体格式
            case 416:
                responseBuilder.append("Requested range not satisfiable");
                break;                                      //  客户端请求的范围无效
            case 417:
                responseBuilder.append("Expectation Failed");
                break;                                      //  服务器无法满足Expect的请求头信息
            case 500:
                responseBuilder.append("Internal Server Error");
                break;                                      //  服务器内部错误，无法完成请求
            case 501:
                responseBuilder.append("Not Implemented");
                break;                                      //  服务器不支持请求的功能，无法完成请求
            case 502:
                responseBuilder.append("Bad Gateway");
                break;                                      //  作为网关或者代理工作的服务器尝试执行请求时，从远程服务器接收到了一个无效的响应
            case 503:
                responseBuilder.append("Service Unavailable");
                break;                                      //  由于超载或系统维护，服务器暂时的无法处理客户端的请求,延时的长度可包含在服务器的Retry
            default:
                responseBuilder.append("Unknown");
        }
        responseBuilder.append(CRLF);
        responseBuilder.append("Date:").append(new Date()).append(CRLF);
        responseBuilder.append("Server:").append(SERVER_VERSION).append(";").append("charset=utf-8").append(CRLF);
        responseBuilder.append("Content-Type:text/html").append(CRLF);
        responseBuilder.append("Content-Length:").append(this.len).append(CRLF);
        responseBuilder.append(CRLF);
    }

    // 动态生成响应内容
    public Response addContent(String content) {
        return this.addContent(content, DEFAULT_CHARSET);
    }

    public Response addContent(String content, Charset charset) {
        contentBuilder.append(content);
        len += content.getBytes(charset).length;
        return this;
    }

    public Response addContent(String content, String charsetName) {
        try {
            contentBuilder.append(content);
            len += content.getBytes(charsetName).length;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(new UnsupportedEncodingException("不支持的字符集:" + charsetName));
        }
        return this;
    }

    public Response addContentWithCRLF(String content) {
        return this.addContent(content + CRLF, DEFAULT_CHARSET);
    }

    public Response addContentWithCRLF(String content, Charset charset) {
        return this.addContent(content + CRLF, charset);
    }

    public Response addContentWithCRLF(String content, String charsetName) {
        return this.addContent(content + CRLF, charsetName);
    }


    public void response() {
        this.response(200);
    }

    public void response(int status) {
        try {
            if (responseBuilder != null) {
                responseHeader(status);
                bufferedWriter.append(responseBuilder);
                bufferedWriter.append(contentBuilder);
            }
            else{
                responseHeader(500);
                bufferedWriter.append(responseBuilder);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
