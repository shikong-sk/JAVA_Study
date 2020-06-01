package cn.skcks.server.core;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/*
    XML 解析器
 */
class ServletHandler extends DefaultHandler {
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