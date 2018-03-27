package com.test.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class Tools {
    
    //生成案件信息
    public static String createXML() {
        String picData = GetImageStr();
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<cases>");
        sb.append("<case>");
        sb.append("<CASENO>xxxxxxxxxx</CASENO>");
        sb.append("<JOINNO>12341</JOINNO>");
        sb.append("<HANDOVER>adf</HANDOVER>");
        sb.append("<JOINNO>12121</JOINNO>");
        sb.append("<ESCORT>asd</ESCORT>");
        sb.append("<ESCORTNO>12132</ESCORTNO>");
        //sb.append("<LAWNO>123413</LAWNO>");
        sb.append("<LAWADDR>qqq</LAWADDR>");
        sb.append("<LAWGROUP>1110</LAWGROUP>");
        sb.append("<LAWUSER>asdfa</LAWUSER>");
        sb.append("<LAWUSERNO>11234</LAWUSERNO>");
        sb.append("<LAWTIME>20170909</LAWTIME>");
        sb.append("<CARPARK>14123</CARPARK>");
        sb.append("<SYSUSER>asdfa</SYSUSER>");
        sb.append("<PNAME>asdfa</PNAME>");
        sb.append("<PIC1>"+"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"+"</PIC1>");
        sb.append("<PNTYPE>112</PNTYPE>");
        sb.append("<PNUMBER>12412</PNUMBER>");
        sb.append("<PPHION>131423412</PPHION>");
        sb.append("<PECTYPE>233</PECTYPE>");
        sb.append("<PECCAUSE>adfa</PECCAUSE>");
        sb.append("<CARTYPE>555</CARTYPE> ");
        sb.append("</case>");
        sb.append("</cases>");
        return sb.toString();
    }
    
    //生成放车通知单信息
    public static String createXML2() {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<infos>");
        sb.append("<info>");
        sb.append("<CASENO>xxxxxxxxxxxxx</CASENO>");
        sb.append("<CAR_OWNER>sssss</CAR_OWNER>");
        sb.append("<TIME_DETAIN>20180122</TIME_DETAIN>");
        sb.append("<CARPARKNO>10001</CARPARKNO>");
        sb.append("<CARREGNO>12121</CARREGNO>");
        sb.append("<CARTYPE>1</CARTYPE>");
        sb.append("<CARCOLOR>eee</CARCOLOR>");
        sb.append("<JOINNO>123413</JOINNO>");
        sb.append("<TIME_RELEASE>20180121</TIME_RELEASE>");
        sb.append("<RELEASETYPE>kkkkk</RELEASETYPE>");
        sb.append("<RELEASENO>12341234</RELEASENO>");
        sb.append("</info>");
        sb.append("</infos>");
        return sb.toString();
    }
    
    //生成etc信息
    public static String createXML3() {
        String picData = GetImageStr();
        StringBuffer sb = new StringBuffer();
        //sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<etcdatas>");
        sb.append("<etcdata>");
        sb.append("<CARNO>777</CARNO>");
        sb.append("<PICTIME>20180808</PICTIME>");
        sb.append("<INOUTTYPE>1</INOUTTYPE>");
        sb.append("<PIC>"+picData+"</PIC>");
        sb.append("<CARPARKNO>12121</CARPARKNO>");
        sb.append("<ETCID>1</ETCID>");
        sb.append("<SYSTIME>20180123</SYSTIME>");
        sb.append("</etcdata>");
        sb.append("</etcdatas>");
        return sb.toString();
    }
    
    //图片转化成base64字符串  
    public static String GetImageStr()  
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        String imgFile = "C:\\Users\\Justyn\\Desktop\\1.jpg";//待处理的图片  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();
        //System.out.println(encoder.encode(data));
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }
    
    
    //base64字符串转化成图片  
    public static boolean GenerateImage(String imgStr)  
    {   //对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成jpeg图片  
            String imgFilePath = "d://222.jpg";//新生成的图片  
            OutputStream out = new FileOutputStream(imgFilePath);      
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        }   
        catch (Exception e)   
        {  
            return false;  
        }  
    }
    
    
    public static void strChangetoXML(String xml) throws Exception {
        Document document = DocumentHelper.parseText(xml); //解析xml字符串为Document对象
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileWriter("D://test.xml"),format);
        
    }

}
