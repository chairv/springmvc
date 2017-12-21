package ognl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlException;

import ognl.testbean.KeepAlive;
import ognl.testbean.Person;
import ognl.testbean.Team;

public class OgnlBaseTest {

    public static void main(String[] args) throws OgnlException {
        Map m = new HashMap();
        Team t1 = new Team();
        t1.setTeamname("team1");
        Person p1 = new Person();
        p1.setName("p1");
        t1.setPerson(p1);
        m.put("t1", t1);
        System.out.println(Ognl.getValue("t1.teamname", m));

        KeepAlive keepAlive = new KeepAlive();
        keepAlive.setKeep(KeepAlive.Keep.REG);
        System.out.println(Ognl.getValue("keep",keepAlive));
        System.out.println(Ognl.getValue("#keep == \"REG\"",keepAlive));

    }
}
