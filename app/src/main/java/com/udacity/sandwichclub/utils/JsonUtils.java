package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static final String KEY_NAME = "name";
    public static final String KEY_ALSO_KNOW_AS = "alsoKnownAs";
    public static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String KEY_MAIN_NAME = "mainName";
    public static final String KEY_INGREDIENTS = "ingredients";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";


    public static Sandwich parseSandwichJson(String json) {
        String mainName, placeOfOrigin, description, image;
        List<String> alsoKnownAs= new ArrayList<>(), ingredients= new ArrayList<>();
        JSONObject JSOONSandwitch;
        JSONArray JSONOtherNames,JSONIngredients;
        try {
            JSOONSandwitch = new JSONObject(json);
            JSONOtherNames = JSOONSandwitch.getJSONObject(KEY_NAME).getJSONArray(KEY_ALSO_KNOW_AS);
            JSONIngredients= JSOONSandwitch.getJSONArray(KEY_INGREDIENTS);
            mainName= JSOONSandwitch.getJSONObject(KEY_NAME).getString(KEY_MAIN_NAME);
            placeOfOrigin= JSOONSandwitch.getString(KEY_PLACE_OF_ORIGIN);
            description=JSOONSandwitch.getString(KEY_DESCRIPTION);
            image=JSOONSandwitch.getString(KEY_IMAGE);
            for(int i=0 ; i<JSONOtherNames.length();i++){
                alsoKnownAs.add(JSONOtherNames.getString(i));
            }
            for(int i=0; i<JSONIngredients.length();i++){
                ingredients.add(JSONIngredients.getString(i));
            }

        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
        return  new Sandwich( mainName, alsoKnownAs, placeOfOrigin, description, image,  ingredients);
        }
}
