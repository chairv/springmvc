/**
 * Created by qiao on 2015/11/20.
 */
public class SubClass extends PClass {

    public SubClass() {
//        System.out.printf("s-c,");
    }

    @Override
    public void init() {
        System.out.printf("init b,");
    }


    public static void main(String[] args) {
        new SubClass();
    }
}
