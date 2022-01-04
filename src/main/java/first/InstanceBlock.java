package first;
 class ParentClass{
    static{
        System.out.println("Parent static block");
    }
    {
        System.out.println("Parent instance");
    }
    ParentClass(){
        System.out.println("Parent constructor");
    }
}

public class InstanceBlock extends ParentClass{
    static{
        System.out.println("child static block");
    }
    {
        System.out.println("child instance");
    }
    InstanceBlock(){
        System.out.println("child constructor");
    }


}
class Test {
    public static void main(String[] args) {
        InstanceBlock i= new InstanceBlock();
    }
}


