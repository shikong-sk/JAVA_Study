package cn.skcks.server.servlet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
    SAX 解析 XML
 */
public class TestXML {
    public static void main(String[] args) {
        // SAX 解析
        try {
            // 创建解析工厂
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            // 从解析工厂获取解析器
            SAXParser saxParser = saxParserFactory.newSAXParser();
            // 编写处理器
            // 加载处理器
            ServletHandler servletHandler = new ServletHandler();
            // 使用解析器解析
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/skcks/server/servlet/xml/servlet.xml"), servletHandler);
//            saxParser.parse("xml/Personal.xml",personalHandler);
            System.out.println("解析：" + Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("cn/skcks/server/servlet/xml/servlet.xml")).getPath());

            servletHandler.showEntityList();
            servletHandler.showMappingList();
            System.out.println();

            DataContext dataContext = new DataContext(servletHandler.getEntityList(), servletHandler.getMappingList());

            String className = dataContext.getClz("/reg");
            System.out.println(className);
            if (className != null) {
                // 获取 Class 对象
                Class clz = Class.forName(className);
                // 动态创建对象
                Servlet servlet = (Servlet) clz.getConstructor().newInstance();
                servlet.service();
            }


        } catch (ParserConfigurationException | SAXException | IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static class ServletHandler extends DefaultHandler {
        private List<Entity> entityList;
        private List<Mapping> mappingList;
        private Entity entity;
        private Mapping mapping;

        private String tmpTag;
        private boolean isMapping = false;
        private StringBuilder data;

        @Override
        public void startDocument() throws SAXException {
            entityList = new ArrayList<>();
            mappingList = new ArrayList<>();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("servlet")) {
                entity = new Entity();
            } else if (qName.equals("servlet-mapping")) {
                isMapping = true;
                mapping = new Mapping();
            }
            tmpTag = qName;
            data = new StringBuilder();
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            String data = this.data.toString().trim();

            if (isMapping) {
                switch (tmpTag) {
                    case "servlet-name":
                        mapping.setName(data);
                        break;
                    case "url-pattern":
                        mapping.addPattern(data);
                        break;
                }
            } else {
                switch (tmpTag) {
                    case "servlet-name":
                        entity.setName(data);
                        break;
                    case "servlet-class":
                        entity.setClz(data);
                        break;
                }
            }

            switch (qName) {
                case "servlet":
                    entityList.add(entity);
                    break;
                case "servlet-mapping":
                    mappingList.add(mapping);
                    isMapping = false;
                    break;
            }

            tmpTag = "";
        }

        @Override
        public void endDocument() throws SAXException {
        }

        public void showEntityList() {
            for (Entity entity : entityList) {
                System.out.println("servlet-name => " + entity.getName() + "\r\n\t servlet-class => " + entity.getClz());
            }
        }

        public List<Entity> getEntityList() {
            return entityList;
        }

        public void showMappingList() {
            for (Mapping mapping : mappingList) {
                System.out.println("servlet-name => " + mapping.getName() + "\r\n\t url-pattern => " + mapping.getPatternSet());
            }
        }

        public List<Mapping> getMappingList() {
            return mappingList;
        }
    }
}
