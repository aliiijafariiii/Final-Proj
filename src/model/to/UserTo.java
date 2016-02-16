package model.to;

import java.io.Serializable;

/**
 * Created by Ali on 2/11/2016.
 */
public class UserTo implements Serializable {
    private long id;
    private String username;
    private String authToken;
    private String picAddress;

    public UserTo() {
    }

    public UserTo(long id, String username, String authToken, String picAddress) {
        this.id = id;
        this.username = username;
        this.authToken = authToken;
        this.picAddress = picAddress;
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
