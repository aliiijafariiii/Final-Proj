package model.to;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ali on 2/22/2016.
 */
public class PostTo implements Serializable {
    private static long id;
    private static String content;
    private static Long publishDate;
    private static String picAddress;
    private static long index;

    public PostTo() {
    }

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        PostTo.id = id;
    }

    public static String getContent() {
        return content;
    }

    public static void setContent(String content) {
        PostTo.content = content;
    }

    public static Long getPublishDate() {
        return publishDate;
    }

    public static void setPublishDate(Long publishDate) {
        PostTo.publishDate = publishDate;
    }

    public static String getPicAddress() {
        return picAddress;
    }

    public static void setPicAddress(String picAddress) {
        PostTo.picAddress = picAddress;
    }

    public static long getIndex() {
        return index;
    }

    public static void setIndex(long index) {
        PostTo.index = index;
    }
}
