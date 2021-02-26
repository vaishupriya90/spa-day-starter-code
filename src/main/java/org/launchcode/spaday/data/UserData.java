package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private static List<User> users = new ArrayList<>();

    public static void add(User user){
        users.add(user);
    }


    public static List<User> getAll(){
        return users;
    }

    public static User getById(int id){
        int index = 0;

        for(User item : users){
           if(item.getId() == id){
               index = users.indexOf(item);
           }
        }
       User user = users.get(index);
        return user;
    }

}
