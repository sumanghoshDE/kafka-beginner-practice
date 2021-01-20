package com.github.kafkabeginnerpractice.consumer;

import java.sql.Connection;
import java.sql.DriverManager;


public class OracleConnectorSink {

    public void run(){
        globalConnection = getOracleConnection();
        System.out.println(globalConnection);
    }

    public Connection getOracleConnection(){
        Connection localConnection = null;
        String connectionURL = "jdbc:oracle:thin:"+this.oracleUserName+"/"+this.oraclePassword+"@"+this.oracleHostName;

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //localConnection = DriverManager.getConnection(this.oracleHostName,properties);
            localConnection = DriverManager.getConnection(connectionURL);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return localConnection;
    }

    public static void main(String[] args) {
        new OracleConnectorSink("127.0.0.1:1521:xe", "SYSTEM", "123").run();
    }

    public OracleConnectorSink(){
        // Empty Constructor
    }

    public OracleConnectorSink(String oracleHostName, String oracleUserName, String oraclePassword){
        this.oracleHostName = oracleHostName;
        this.oracleUserName = oracleUserName;
        this.oraclePassword = oraclePassword;
    }

    private String oracleHostName;
    private String oracleUserName;
    private String oraclePassword;
    private  Connection globalConnection;
}
