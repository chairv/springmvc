package jvm.load;

public class SubClass extends SuperClass {
    static {
        System.out.println("Subclass init");
    }
}
