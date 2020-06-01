package cn.skcks.server.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*
    封装请求协议

    获取 Method URI 请求参数
 */
public class Request {
    // 公用常量定义
    static private final String CRLF = "\r\n";
    // 请求信息
    private String request;
    // 请求方式
    private String method;
    // 请求URL
    private String url;
    // 请求参数 字符串
    private String queryString;
    // 请求参数 Map
    private Map<String, List<String>> query;


    public Request(InputStream inputStream) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            byte[] flush = new byte[1024];
            int len;
            while ((len = inputStream.read(flush)) != -1) {
                stringBuilder.append(new String(flush, 0, len));
                if (len < flush.length) break;
            }
            request = stringBuilder.toString();
            this.query = new HashMap<>();
            parseRequest();
        } catch (Exception e) {
            System.out.println("客户端连接失败");
        }
    }

    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }

    private void parseRequest() {
        System.out.println(request);

        // 定位 URL 参数开始位置
        int separator1 = request.indexOf("/");

        this.method = this.request.substring(0, separator1 - 1).toUpperCase();
        System.out.println("请求方式:" + method);

        // 定位 URL 参数结束位置
        int separator2 = request.indexOf(" HTTP/");


        // 定位参数起始位置 ? 若为 -1 则无参数
        int separator3;

        // 当请求类型为 GET
        if (this.method.equals("GET")) {
            // 若 URL 起始位置 +1 与 URL 结束位置相同 说明 URL请求为 /
            if ((separator1 + 1) != separator2) {
                // 根据是否存在参数 以及 参数起始位置截取 请求资源 和 请求参数
                if ((separator3 = request.indexOf("?")) == -1) {
                    this.url = request.substring(separator1 + 1, separator2);
                    this.queryString = "";
                } else {
                    this.url = request.substring(separator1 + 1, separator3);
                    this.queryString = request.substring(separator3 + 1, separator2);
                }
            }
            else{
                this.queryString = "";
                this.url = "";
            }
        }
        // 当请求类型为 POST
        else if (this.method.equals("POST")) {
            // 定位是否存在 ? 分离多余的 GET 参数
            separator3 = request.indexOf("?");
            // 获取 请求资源
            this.url = request.substring(separator1 + 1, separator3 == -1 ? separator2 : separator3);
            // 获取 请求参数
            this.queryString = this.request.substring(request.lastIndexOf(CRLF) + 1).trim();
        }

        if(queryString != null)
        {
            try {
                queryString = decode(queryString,StandardCharsets.UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        System.out.println("请求资源：" + url);
        System.out.println("请求参数：" + queryString);
        try {
            extractQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String key : query.keySet()) {
            System.out.print(key + " => ");
            for (String value : query.get(key)) {

                System.out.print(value + "、");
            }
            System.out.println("\b");
        }
    }

    // 解析请求参数内容
    private void extractQuery() {
        if (queryString != null && !queryString.isEmpty()) {
            String[] queryArray = queryString.split("&");
            String key;
            for (String parameter : queryArray) {
                String[] tmp = parameter.split("=");
                if (tmp.length < 2) {
                    tmp = new String[]{tmp[0], ""};
                }

                if (tmp[0].endsWith("[]")) {
                    key = tmp[0].substring(0, tmp[0].length() - 2);

                } else {
                    key = tmp[0];
                }

                if (!query.containsKey(key)) {
                    this.query.put(key, new ArrayList<>(Collections.singletonList(tmp[1])));
                } else {
                    this.query.get(key).add(tmp[1]);
                }
            }
        }
    }

    // 获取请求参数 对应的键值数组
    public String[] getParameterValue(String key) {
        List<String> valueList = this.query.get(key);
        if (valueList == null || valueList.size() < 1) {
            return null;
        } else {
            return valueList.toArray(new String[0]);
        }
    }

    // 获取请求参数 对应的键值
    public String getParameter(String key) {
        String[] data = getParameterValue(key);
        return data == null ? null : data[0];
    }

    // 获取请求参数 对应的键名
    public String[] getParameterKey() {
        if (query.size() != 0) {
            return query.keySet().toArray(new String[0]);
        } else {
            return null;
        }
    }

    // URL解码
    public String decode(String string,String charsetName) throws UnsupportedEncodingException {
        return URLDecoder.decode(string,charsetName);
    }

    public String decode(String string, Charset charset) throws UnsupportedEncodingException {
        return URLDecoder.decode(string, charset.name());
    }

    public String getUrl() {
        return url;
    }
}
