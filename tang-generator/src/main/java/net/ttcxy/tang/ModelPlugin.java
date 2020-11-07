package net.ttcxy.tang;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class ModelPlugin extends PluginAdapter {
    public ModelPlugin() {
    }

    public boolean validate(List<String> list) {
        return true;
    }

    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType("java.io.Serializable");
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * @author huanglei");
        topLevelClass.addJavaDocLine(" */");
        topLevelClass.addSuperInterface(new FullyQualifiedJavaType("java.io.Serializable"));
        topLevelClass.addSuperInterface(new FullyQualifiedJavaType("net.ttcxy.tang.ModelBase"));

        return true;
    }
}
