package top.qianxinyao.dao;

import java.sql.*;

/**
 * @Author WCJ
 * @Description
 **/
public class JdbcUtil {
    private static final String url = "jdbc:mysql://localhost:3307/recom?useUnicode=true&characterEncoding=utf8";
    private static final String user = "root";
    private static final String password = "root";
    private static final String driver = "com.mysql.jdbc.Driver";

    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn){
        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if( rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

