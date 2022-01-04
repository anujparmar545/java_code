package first;

public class StringCall {
    public static void main(String[] args) {
        m("sds");

        print(new Integer(1));
    }
    public static void m(String s){
        System.out.println("String");
    }
    public static void m(StringBuffer s){
        System.out.println("StringBuffer");
    }
    public static void m(StringBuilder s){
        System.out.println("StringBuilder");
    }
    public static void m(Object s){
        System.out.println("Object");
    }
    public static void print(int s){
        System.out.println("int");
    }

    public static void print(Integer s){
        System.out.println("Integer");
    }
    public static void print(Object s){
        System.out.println("Object");
    }
}
