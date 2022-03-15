package com.example.tippay;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexio {

    Connection con;
    String username, psw, bd, ip, puerto;

    public Connection connexioClass(){
        username = "tippay";
        psw = "T1pp@y2022!";
        bd = "2022dam2tippay";
        ip = "ellaboratori.cat";
        puerto = "3306";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            ConnectionURL= "jdbc:jtds:sqlserver://"+ ip + ":"+ puerto+";"+ "databasename="+ bd+";user="+username+";password="+psw+";";
            connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (Exception ex){
            Log.e("Error: ", ex.getMessage());
        }

        return connection;
    }
}
