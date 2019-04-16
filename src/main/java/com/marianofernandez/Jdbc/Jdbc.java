package com.marianofernandez.Jdbc;//STEP 1. Import required packages
import com.marianofernandez.Entidades.Humano;

import java.sql.*;
import java.util.Optional;

public class Jdbc {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/TP_1";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public void insertJdbc(Optional<Humano> humano) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            stmt = conn.prepareStatement("INSERT INTO ganadores(nombre, totalBebidas) "
                    + "VALUES(?,?)");

            ((PreparedStatement) stmt).setString(1, humano.get().getNombre());
            ((PreparedStatement) stmt).setInt(2, humano.get().getContBeber());
            ((PreparedStatement) stmt).executeUpdate();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end isertJdbc
}//end Jdbc
