package com.test.util;

import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Test {
    
    public static void main(String[] args) throws Exception {
        String xml = Tools.createXML();
        Document document = DocumentHelper.parseText(xml);
//        XMLWriter write = new XMLWriter(new FileWriter("D://output.xml"));  
//        write.write(document);  
//        write.close();  
        
        OutputFormat format = OutputFormat.createPrettyPrint();  
        format.setEncoding("UTF-8");  
        XMLWriter writer = new XMLWriter(new FileWriter("D://output2.xml"),format);
        writer.write(document);
        writer.close();
    }

}
