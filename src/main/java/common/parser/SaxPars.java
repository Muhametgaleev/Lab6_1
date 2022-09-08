package common.parser;

import common.classes.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;


public class SaxPars {
    public static HashSet<Vehicle> vehicle = new HashSet<>();

    InputStream myFile = getFileFromResourceAsStream("xml_file1.xml");


    public SaxPars() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();

            parser.parse(myFile, handler);
        } catch (NumberFormatException |ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Неправильно составлен файл");
        }
    }

    /**
     * В данном отрывке кода расписано поведение парсера при разных обстоятельствах
     */
    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            // Тут будет логика реакции на начало документа
        }

        @Override
        public void endDocument() {
            // Тут будет логика реакции на конец документа
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // Тут будет логика реакции на начало элемента
            if (qName.equals("player")) {
                FuelType type;
                String name = attributes.getValue("name");
                Integer id = Integer.parseInt(attributes.getValue("id"));
                Coordinates coordinates = new Coordinates(Float.parseFloat(attributes.getValue("coordinateX")), Long.parseLong(attributes.getValue("coordinateY")));
                Integer capacity = Integer.parseInt(attributes.getValue("capacity"));
                Integer enginePower = Integer.parseInt(attributes.getValue("enginePower"));
                if (Objects.equals(attributes.getValue("FuelType"), "")) {
                    type = FuelType.valueOf("NULL");
                } else {
                    type = FuelType.valueOf(attributes.getValue("FuelType"));
                }
                LocalDateTime creationDate = LocalDateTime.now();
                vehicle.add(new Vehicle(id, name, coordinates, creationDate, enginePower, capacity, type));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Тут будет логика реакции на конец элемента
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // Тут будет логика реакции на текст между элементами
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) {
            // Тут будет логика реакции на пустое пространство внутри элементов (пробелы, переносы строчек и так далее).
        }
    }

    public HashSet<Vehicle> getVehicle() {
        return vehicle;
    }

    /**
     * Метод открытия файла не по URL-ссылке
     * @param fileName
     * @return
     */
    private InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
}
