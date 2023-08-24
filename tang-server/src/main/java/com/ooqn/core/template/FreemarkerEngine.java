package com.ooqn.core.template;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerEngine {

    public static Configuration configuration;

    static {
        configuration = new Configuration(Configuration.VERSION_2_3_32);
    }

    public static String run(String templateStr, Map<String, Object> params) {
        Template template;
        try {
            template = new Template("stringTemplate", templateStr, configuration);
            Writer writer = new StringWriter();
            template.process(params, writer);
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return "";
    }

}
