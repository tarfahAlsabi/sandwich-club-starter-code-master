package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        String mainName, placeOfOrigin, description, image;
        List<String> alsoKnownAs= new ArrayList<>(), ingredients= new ArrayList<>();
        JSONObject JSOONSandwitch;
        JSONArray JSONOtherNames,JSONIngredients;
        try {
            JSOONSandwitch = new JSONObject(json);
            JSONOtherNames = JSOONSandwitch.getJSONObject("name").getJSONArray("alsoKnownAs");
            JSONIngredients= JSOONSandwitch.getJSONArray("ingredients");
            mainName= JSOONSandwitch.getJSONObject("name").getString("mainName");
            placeOfOrigin= JSOONSandwitch.getString("placeOfOrigin");
            description=JSOONSandwitch.getString("description");
            image=JSOONSandwitch.getString("image");
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
