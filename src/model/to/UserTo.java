package model.to;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Ali on 2/11/2016.
 */
public class UserTo implements Serializable {

    private static long id;
    private static String username;
    private static String authToken;
    private static Long lastSeen;
    private static String email;
    private static String password;
    private static String picAddress;
    private static String details;
    //////////////////
    private static List user_id_list;
    private static List User_Username_list;



    public UserTo() {
    }

    public static String getDetails() {
        return details;
    }

    public static void setDetails(String details) {
        UserTo.details = details;
    }

    public static Long getLastSeen() {
        return lastSeen;
    }

    public static void setLastSeen(Long lastSeen) {
        UserTo.lastSeen = lastSeen;
    }

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        UserTo.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserTo.username = username;
    }

    public static String getAuthToken() {
        return authToken;
    }

    public static void setAuthToken(String authToken) {
        UserTo.authToken = authToken;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserTo.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserTo.password = password;
    }

    public static String getPicAddress() {
        return picAddress;
    }

    public static void setPicAddress(String picAddress) {
        UserTo.picAddress = picAddress;
    }

    ///////////////////////////

    public static List getUser_id_list() {
        return user_id_list;
    }

    public static void setUser_id_list(List user_id_list) {
        UserTo.user_id_list = user_id_list;
    }

    public static List getUser_Username_list() {
        return User_Username_list;
    }

    public static void setUser_Username_list(List user_Username_list) {
        User_Username_list = user_Username_list;
    }
}
