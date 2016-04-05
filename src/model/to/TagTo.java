package model.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 4/4/16.
 */
public class TagTo implements Serializable{
        private static List tags_id_list;
        private static List tags_name_list;
        private static List idForPost;

    public TagTo() {
    }

    public static List getTags_id_list() {
        return tags_id_list;
    }

    public static void setTags_id_list(List tags_id_list) {
        TagTo.tags_id_list = tags_id_list;
    }

    public static List getTags_name_list() {
        return tags_name_list;
    }

    public static void setTags_name_list(List tags_name_list) {
        TagTo.tags_name_list = tags_name_list;
    }

    public static List getIdForPost() {
        return idForPost;
    }

    public static void setIdForPost(List idForPost) {
        TagTo.idForPost = idForPost;
    }
}
