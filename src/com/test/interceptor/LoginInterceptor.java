package com.test.interceptor;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

//客户端输出拦截器，用于在请求头信息中加入认证信息
public class LoginInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
    
    private String username;  
    private String password;  
    public void setUsername(String username) {  
        this.username = username;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }
    public LoginInterceptor() {  
        super(Phase.PREPARE_SEND); //请求消息发送之前
    }
    /** 
     * 创建一个新的实例 ClientLoginInterceptor. 
     * 
     * @param username 
     * @param password 
     */  
    public LoginInterceptor(String username, String password) {  
        super(Phase.PREPARE_SEND); //请求消息发送之前
        this.username = username;  
        this.password = password;  
    }
    
    //处理消息头
    public void handleMessage(SoapMessage soap) throws Fault {  
        // TODO Auto-generated method stub  
        List<Header> headers = soap.getHeaders();  
          
        Document doc = DOMUtils.createDocument();  
          
        Element auth = doc.createElement("authrity");  
        Element username = doc.createElement("username");  
        Element password = doc.createElement("password");  
        
        username.setTextContent(this.username);  
        password.setTextContent(this.password);  
          
        auth.appendChild(username);  
        auth.appendChild(password);  
        //doc.appendChild(auth);  
          
        headers.add(0, new Header(new QName("tiamaes"),auth));  
    }  

}
