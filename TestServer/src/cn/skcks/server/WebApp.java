package cn.skcks.server;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.util.Objects;

public class WebApp {
    private static DataContext dataContext;

    static {
        try {
            // 创建解析工厂
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            // 从解析工厂获取解析器
            SAXParser saxParser = saxParserFactory.newSAXParser();
            // 编写处理器
            // 加载处理器
            ServletHandler servletHandler = new ServletHandler();
            // 使用解析器解析
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/skcks/server/WebApp.xml"), servletHandler);
            System.out.println("解析：" + Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("cn/skcks/server/WebApp.xml")).getPath());
//
//            servletHandler.showEntityList();
//            servletHandler.showMappingList();
//            System.out.println();

            dataContext = new DataContext(servletHandler.getEntityList(), servletHandler.getMappingList());

//            String url = dataContext.getClz("reg");
//            System.out.println(url);

        } catch (Exception e) {
            System.out.println("配置文件解析失败");
        }
    }

    /*
        通过 url 获取对应的 servlet
     */
    public static cn.skcks.server.Servlet getServlet(String url) {
        try {
            url = dataContext.getClz(url);
            System.out.println("获取：" + url);
            if (url != null) {
                // 获取 Class 对象
                Class clz = Class.forName(url);
                // 动态创建对象
                return (cn.skcks.server.Servlet) clz.getConstructor().newInstance();
            }
        } catch (Exception e) {
            System.out.println("对应的 servlet 不存在");
        }
        return null;
    }

}

