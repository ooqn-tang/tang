package cn.ttcxy.core.security;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.util.StreamUtils;
import org.springframework.web.util.HtmlUtils;

import cn.hutool.core.util.StrUtil;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    
    private final byte[] body;
    private Map<String, String[]> parameterMap;

    public XssHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        parameterMap = request.getParameterMap();
        body = StreamUtils.copyToByteArray(request.getInputStream());
        System.out.println(new String(body,Charset.forName("UTF-8")));
    }
 
    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (StrUtil.isEmpty(value)) {
            return value;
        }
        return HtmlUtils.htmlEscape(value);
    }
 
    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if(value == null){
            return value;
        }
        return HtmlUtils.htmlEscape(value);
    }
 
    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if(values == null){
            return values;
        }
        for (int i = 0; i < values.length; i++) {
            values[i] = HtmlUtils.htmlEscape(values[i]);
        }
        return values;
    }

    @Override public Enumeration<String> getParameterNames(){
        Vector<String> vector = new Vector<String>(); 
        return vector.elements(); 
    }

    public String getBodyString(){
        return new String(body,Charset.forName("UTF-8"));
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };
    }


 
} 
