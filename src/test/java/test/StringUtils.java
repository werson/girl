package test;

public class StringUtils {

    static {
        System.out.println("静态代码块");
    }

    public StringUtils(){
        System.out.println("构造函数");
    }

    public static void print() {
        System.out.println("print test");
    }

    public static void main(String[] args) {
        System.out.println("核心数：" + Runtime.getRuntime().availableProcessors());
        StringUtils.print();
    }
}
