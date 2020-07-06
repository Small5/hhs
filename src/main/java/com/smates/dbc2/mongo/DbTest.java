package com.smates.dbc2.mongo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest {


        public static void main(String[] args) {
            // TODO Auto-generated method stub

            System.out.print("Connect PostgreSQL: \n\n");
            try {
                Class.forName("org.postgresql.Driver").newInstance();

                String url = "jdbc:postgresql://http://210.77.79.201:5432/hhs_backup";

                Connection con = DriverManager.getConnection(url, "postgre", "");
                Statement st = con.createStatement();

                //检索表： user_info
                String sql = "SELECT * FROM a_watershed";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    System.out.print(rs.getString(2) + "\t");
                }

                rs.close();
                st.close();
                con.close();




            } catch (Exception e) {
                System.out.print(e.toString());
            }
        }


}
