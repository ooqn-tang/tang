import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * created by huanglei on 2020/9/15
 */
public class MyBatisJavaTypeResolver extends JavaTypeResolverDefaultImpl {
    public MyBatisJavaTypeResolver() {
        super();
        /*typeMap.put(Types.TINYINT,
                new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TINYINT",new FullyQualifiedJavaType(Integer.class.getName()))
        );*/
    }
}
