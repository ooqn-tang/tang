package net.ttcxy.tang.gateway.demo;

public enum Demo {

    DE("1","1","1"),
    BO("2","2","2");

    static{
        System.out.println("asdf");
    }
    public static String string = "";
    private final String str1;
    private final String str2;
    private final String str3;
    Demo(String str1,String str2,String str3){
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
    }

    public static void main(String[] args) {
        System.out.println(Demo.DE.getStr1());
    }

    public String getStr1() {
        return str1;
    }

    public String getStr2() {
        return str2;
    }

    public String getStr3() {
        return str3;
    }
}
