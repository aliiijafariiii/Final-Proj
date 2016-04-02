package model.to;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ali on 2/11/2016.
 */
public class UserTo implements Serializable {
    private long id;
    private String username;
    private String authToken;
    private Long lastSeen;
    private String email;
    private String password;
    private String picAddress;


    public UserTo() {
    }

    public UserTo(long id, String username, String authToken, Long lastSeen, String email, String password, String picAddress) {
        this.id = id;
        this.username = username;
        this.authToken = authToken;
        this.lastSeen = lastSeen;
        this.email = email;
        this.password = password;
        this.picAddress = picAddress;
    }

    public Long getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Long lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress;
    }
}
