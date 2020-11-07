package net.ttcxy.tang.gateway.entity;

import javax.validation.constraints.NotBlank;

/**
 * @author huanglei
 */
public class Po{

    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "姓名不能为空")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Po{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
