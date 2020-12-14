package com.audioappraiser.audioapp.old_db_classes;

import java.sql.*;
import java.util.HashMap;

public class DAL {

    //data for the database
    public static HashMap<String, String> credentials = new HashMap<String, String>(){{
       put("Server_Name", "localhost");
       put("Port", "3307");
       put("Database_Name", "dbi425575");
       put("Username", "root");
       put("Password", "12345");
    }};

    //method to create a connection with the database. REMINDER: use conn.close(); at the end of all methods that use
    //this method to close the connection
    private static Connection EstablishDBConnection(){
        try{

            Connection dbConnection = DriverManager.getConnection(
                    "jdbc:mysql://"+ credentials.get("Server_Name")
                            +":"+ credentials.get("Port")
                            +"/"+ credentials.get("Database_Name")
                            +"?useSSL=true",
                    credentials.get("Username"),
                    credentials.get("Password")
            );
            return dbConnection;
        }
        catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }

    public static String CreateUpdateDelete_Object(int selector,String query, String[] args) {
        Connection conn = EstablishDBConnection();
        if (conn == null) return "-1";
        if (args == null || args.length == 0) return "-2";
        if (query == null || query.isBlank()) return "-3";
        try {
            for (int i = 0; i < args.length; i++){
                query = query.replace("@"+i, args[i]);
            }
            Statement stmt = conn.createStatement();

            var response = stmt.executeUpdate(query);
            conn.close(); // check for catching this specific exception for closing the connection
            return String.valueOf(response);

        } catch (SQLException e) {
            e.printStackTrace();
            return "0";
        }
    }


    //TO REFACTOR
    public static HashMap<String, String[]> Read_Object(String query, String[] args){
        Connection conn = EstablishDBConnection();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id, username, real_name, private_account from user");

            HashMap<String, String[]> tempHashMap = new HashMap<String, String[]>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String real_name = rs.getString("real_name");
//                String email = rs.getString("email");
                Boolean private_acc = rs.getBoolean("private_account");
                tempHashMap.put(String.valueOf(id), new String[]{username, real_name, String.valueOf(private_acc)});
                //System.out.println(id + "," + username + "," + real_name + "," + private_acc);
            }
            //System.out.println(tempHashMap.size());
            return tempHashMap;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

