package com.audioappraiser.audioapp.old_db_classes;

import com.audioappraiser.audioapp.old_db_classes.DAL;

import java.util.HashMap;

public class DALUserController {
    public static void main(String[] args) {
        //query will be coming from the object class files in order to have custom 'sentences' for them

        String queryIns = "insert into users (username, real_name, private_account) value ('@0', @1, '@2')";
        String queryDel = "delete from users where id = @0";
        String queryUp = "update users set username = '@0' where id = @1";
        String queryRead = "select * from users";

        String[] statsIns = new String[]{"jimmy-petrov", "Dimitar Petrov", "false"};
        String[] statsDel = new String[]{"3"};
        String[] statsUp = new String[]{"NotIvan", "13"};
        String[] statsRead = new String[0];

        //0 - insert, 1 - update, 2 - delete
        System.out.println(DAL.CreateUpdateDelete_Object(1, queryUp, statsUp));
        HashMap<String, String[]> temp = DAL.Read_Object(queryRead, statsRead);

        //check the below for nullPointerException first
        for (String key: temp.keySet()){
            System.out.print("id: " + key + " -> ");
            for (String value: temp.get(key)){
                System.out.print("/" + value);
            }
            System.out.println();
        }
        //Creating an object
        //Return code 0 = unsuccessful /there may be errors
        //Return code 1 = successful
    }
}
