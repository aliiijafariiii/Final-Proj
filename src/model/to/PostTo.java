package model.to;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ali on 2/22/2016.
 */
public class PostTo implements Serializable {
    private long id;
    private String content;
    private Date publishDate;
    private String picAddress;
    private long userID;

    public PostTo() {
    }

    public PostTo(long id, String content, Date publishDate, String picAddress, long userID) {
        this.id = id;
        this.content = content;
        this.publishDate = publishDate;
        this.picAddress = picAddress;
        this.userID = userID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }


    public String getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
