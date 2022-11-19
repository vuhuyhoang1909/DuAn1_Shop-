/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

//import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ducit
 */
public class jdbcHelper1 {

//<<<<<<< HEAD
    static String user = "sa";
    static String pass = "dung8402";
    static String url = "jdbc:sqlserver://localhost:1433;database=DUAN1;" + 
                    "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
//=======
//     static String user = EnvUtil.get("DB_USER");
//    static String pass = EnvUtil.get("DB_PASSWORD");
//>>>>>>> origin/Minhvn
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
//    static String url = "jdbc:sqlserver://" + EnvUtil.get("DB_HOST") + ";databaseName=" + EnvUtil.get("DB_NAME");

    static {
        try {
            Class.forName(driver);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws Exception {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt;
        if (sql.trim().startsWith("{")) {
            stmt = con.prepareCall(sql);
        } else {
            stmt = con.prepareStatement(sql);
        }

        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }

    public static ResultSet query(String sql, Object... args) throws Exception {
        PreparedStatement stmt = jdbcHelper1.getStmt(sql, args);
        return stmt.executeQuery();
    }

    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = jdbcHelper1.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stmt = jdbcHelper1.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
}
