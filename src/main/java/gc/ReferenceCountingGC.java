package gc;

/**
 * Created by tancw on 2017/8/24.
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final  int _1MB = 1024*1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假设在这行发生GC,那么objectA与objectB是否能被回收
        System.gc();
        System.out.println("over");
    }

    public static void main(String[] args) {
        testGC();
    }
}
