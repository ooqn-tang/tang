package cn.ttcxy.core.security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.extra.servlet.ServletUtil;
import cn.ttcxy.util.XssUtil;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    
    HttpServletRequest orgRequest = null;
 
    private String body;
 
    public XssHttpServletRequestWrapper(HttpServletRequest request) throws UnsupportedEncodingException {
        super(request);
        request.setCharacterEncoding("UTF-8");
        body = ServletUtil.getBody(request);
    }
 
    @Override
    public ServletInputStream getInputStream() throws IOException {
        JSONObject parseObject = JSONObject.parseObject(body);
        XssUtil.analysisJson(parseObject);
        body = parseObject.toJSONString();
        final ByteArrayInputStream bais = new ByteArrayInputStream(body.getBytes());
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public int read() {
                return bais.read(); 
            }

            @Override
            public void setReadListener(ReadListener listener) {
              
            }
        };
    }
} 
