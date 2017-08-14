package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.testng.annotations.Test;

/**
 * Created by tancw on 2017/8/14.
 * http://lgbolgger.iteye.com/blog/2180251
 */
public class JdbcTest {

	@Test
	public void test() {
		Connection conn = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/api?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
            String username = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(false);
            PreparedStatement ps =conn.prepareStatement(" INSERT INTO  `test`  (`name`) VALUES ('3');");
            ps.execute();
            conn.commit();
        } catch (SQLException e) {
          e.printStackTrace();
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
