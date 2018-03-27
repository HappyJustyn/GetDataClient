package com.test.clientTest;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.interceptor.LoginInterceptor;
import com.test.service.GetData;


public class ClientTest {
    
    public static void main(String[] args) throws Exception {
        //invokByJava();
        //invokBySpring();
        clientTest2();
    }
    
    /** 
     * use spring's application context method to obtain web service. 
     */  
    public static  void invokBySpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-client.xml");  
        GetData getData = context.getBean("getDataClient", GetData.class);  
    }  
      
    /** 
     * use original method to obtain web service. 
     */  
    public static void invokByJava(){  
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        factory.setServiceClass(GetData.class);  
        factory.setAddress("http://localhost/GetDataService/WS/getDataWS?wsdl");  
        GetData getData = (GetData)factory.create();  
    }
    
    // 1.使用spring框架
    public static void clientTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-client.xml");
        GetData getData = context .getBean("getDataClient",GetData.class);
        System.out.println(getData.getData());
    }
    
    // 2.使用传统方式
    public static void clientTest2() throws Exception {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        factory.setServiceClass(GetData.class);   
        factory.setAddress("http://localhost/GetDataService/WS/getDataWS?wsdl");
        // 添加用户名和密码
        factory.getOutInterceptors().add(new LoginInterceptor("admin","admin"));
        GetData getData = (GetData)factory.create();
        System.out.println(getData.getData());
    }
    
}
