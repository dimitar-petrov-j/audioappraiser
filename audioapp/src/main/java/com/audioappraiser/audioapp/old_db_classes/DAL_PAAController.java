package com.audioappraiser.audioapp.old_db_classes;

import java.util.HashMap;

public class DAL_PAAController {

    //Method to check if the incoming query is for an album or artist
    //0 - error/null; 1 - artist; 2 - project
    protected static int ProjectOrArtist(String[] args)
    {

        return 0;
    }

    public static void main(String[] args) {
        //query will be coming from the object class files in order to have custom 'sentences' for them

        int res = ProjectOrArtist(args);

        String queryIns = "insert into projects (name, artist, artist_id, rating, reviews, release_date, type) value ('@0', '@1', @2, @3, @4, '@5', '@6')";
        String queryDel = "delete from projects where id = @0";
        String queryUp = "update projects set name = '@0' where id = @1";
        String queryRead = "select * from projects";

        String[] statsIns = new String[]{"Flower Boy", "Tyler the Creator", "1", "3,89", "165", "2017-07-21", "ALBUM"};
        String[] statsDel = new String[]{"3"};
        String[] statsUp = new String[]{"Flower Boy", "13"};
        String[] statsRead = new String[0];

        //0 - insert, 1 - update, 2 - delete
        System.out.println(DAL_ProjectsAndArtists.CreateUpdateDelete_Object(1, queryUp, statsUp));
        HashMap<String, String[]> temp = DAL_ProjectsAndArtists.Read_Object_Project(queryRead, statsRead);

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
