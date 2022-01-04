package first;
// A Simple Java program to demonstrate
// Overriding and Access-Modifiers

class Parent {
    static int x=10;
      protected void m2()
    {
        System.out.println("From parent m2()");
    }
}

class Child extends Parent {
    static int x=20;
    @Override
    public void m2()
    {
        System.out.println("From child m2()");
    }
}

// Driver class
class Main {
    public static void main(String[] args)
    {
        Parent obj1 = new Parent();
        System.out.println(obj1.x);
        obj1.m2();
        Parent obj2 = new Child();
        obj2.m2();
        System.out.println(obj2.x);
    }
}
