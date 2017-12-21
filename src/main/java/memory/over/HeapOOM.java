package memory.over;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    static class OOMOjbect {
    }

    public static void main(String[] args) {
        System.out.println("begin");
        List<OOMOjbect> list = new ArrayList<OOMOjbect>();
        while (true) list.add(new OOMOjbect());
    }
}
