package model.util;

import com.mashape.unirest.http.HttpResponse;
import model.bl.PostManager;
import model.bl.PostManagerImpl;
import model.to.TagTo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.mainForms.UploadForm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ali on 4/5/16.
 */
public class TagUtil {
    private static TagUtil tagUtil = new TagUtil();
    public static TagUtil getTagUtil() {
        return tagUtil;
    }
    public TagUtil() {
    }

    public HttpResponse<String> MakeTagForSend() throws Exception {

        PostManager postManager = PostManagerImpl.getPostManager();
        List jsonto_tag = new ArrayList();
        List jsonto_id = new ArrayList();

        List tags = null;
        String s = UploadForm.getTaglabel().getText();
        List list = new ArrayList();
        tags = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                list.add(i);
            }
        }
        list.add(s.length());
        for (int j = 0; j < list.size() - 1; j++) {
            tags.add(s.substring(1 + Integer.valueOf((Integer) list.get(j)), Integer.valueOf((Integer) list.get(j + 1))));
        }

/////////////////////////
        HttpResponse<String> tagsResponse = postManager.getTags();
        JSONParser jsonParser = new JSONParser();
        if (!tagsResponse.getBody().equals("[]")) {

            System.out.println("injaaaa");
            JSONArray jsonArray = (JSONArray) jsonParser.parse(tagsResponse.getBody());
            Iterator<JSONObject> jsonObjectIterator = jsonArray.iterator();
            while (jsonObjectIterator.hasNext()) {
                JSONObject jsonObject = jsonObjectIterator.next();
                jsonto_id.add(jsonObject.get("id"));
                jsonto_tag.add(jsonObject.get("tagName"));
            }
/////////////////////////////////////////////
            List idhaa = new ArrayList();
            List finalTags = new ArrayList();
            for (int b = 0; b < tags.size(); b++) {
                for (int a = 0; a < jsonto_tag.size(); a++) {
                    if (jsonto_tag.get(a) != tags.get(b)) {
                        finalTags.add(b);
                    }
                }
            }

            for (int k = 0; k < finalTags.size(); k++) {
                String t = (String) tags.get(Integer.valueOf((Integer) finalTags.get(k)));
                JSONObject tagJson = new JSONObject();
                tagJson.put("id", null);
                tagJson.put("tagName", t);
                HttpResponse<String> tasgResponse = postManager.registerTags(tagJson.toJSONString());
                JSONParser jsonParser5 = new JSONParser();
                JSONObject jsonObject5 = (JSONObject) jsonParser5.parse(tasgResponse.getBody());
                idhaa.add((Long) jsonObject5.get("id"));
            }

            TagTo.setIdForPost(idhaa);
            TagTo.setTags_id_list(jsonto_id);
            TagTo.setTags_name_list(jsonto_tag);
            return tagsResponse ;
        } else {

            List idhaa = new ArrayList();
            for (int k = 0; k < tags.size(); k++) {
                String t = (String) tags.get(k);
                JSONObject tagJson = new JSONObject();
                tagJson.put("id", null);
                tagJson.put("tagName", t);
                HttpResponse<String> tasgResponse = postManager.registerTags(tagJson.toJSONString());
                JSONParser jsonParser5 = new JSONParser();
                JSONObject jsonObject5 = (JSONObject) jsonParser5.parse(tasgResponse.getBody());
                idhaa.add((Long) jsonObject5.get("id"));
            }
            TagTo.setIdForPost(idhaa);
        }

        return tagsResponse;
    }
}
