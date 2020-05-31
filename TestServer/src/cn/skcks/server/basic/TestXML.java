package cn.skcks.server.basic;

import cn.skcks.server.basic.xml.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
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
            PersonalHandler personalHandler = new PersonalHandler();
            // 使用解析器解析
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/skcks/server/basic/xml/Personal.xml"),personalHandler);
//            saxParser.parse("xml/Personal.xml",personalHandler);
            System.out.println("解析：" + Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("cn/skcks/server/basic/xml/Personal.xml")).getPath());
            personalHandler.getPersonList();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class PersonalHandler extends DefaultHandler{
        private List<Person> personList;
        private Person person;
        private String tmpTag;
        private StringBuilder data;

        @Override
        public void startDocument() throws SAXException {
            personList = new ArrayList<>();
//            System.out.println("========== 开始解析 ==========");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//            System.out.println("开始解析 => " + qName);
            if(qName.equals("person"))
            {
                person = new Person();
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
//            if(!data.isEmpty())
//                System.out.println(data);

            switch (tmpTag){
                case "name":
                    person.setName(data);break;
                case "age":
                    person.setAge(Integer.parseInt(data.isEmpty()?"-1":data));break;
            }

//            System.out.println("解析完成 => " + qName);
            if(qName.equals("person"))
            {
                personList.add(person);
            }
            tmpTag = "";
        }

        @Override
        public void endDocument() throws SAXException {
//            System.out.println("========== 解析完成 ==========");
        }

        public void getPersonList() {
            for(Person person:personList)
            {
                System.out.println("name => " + person.getName() + "\t age => " + person.getAge());
            }
        }
    }
}
