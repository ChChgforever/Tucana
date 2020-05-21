package com.tucana;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TcExecutor {

    public <T> T query(String sql, Object parameter) {
        Connection conn = null;
        Statement stmt = null;
        Fee fee = new Fee();

        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 打开连接
            conn =
                    DriverManager.getConnection(
                            "jdbc:mysql://...", "user", "password");

            // 执行查询
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format(sql, parameter));

            // 获取结果集
            while (rs.next()) {
                Long id = rs.getLong("id");
                BigDecimal feeAmt = rs.getBigDecimal("fee_amt");
                Date feeDate = rs.getDate("fee_date");
                fee.setId(id);
                fee.setFeeAmt(feeAmt);
                fee.setFeeDate(feeDate);
            }
            System.out.println(fee);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T) fee;
    }
}
