package practice.nazmul.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import java.util.HashMap;

/**
 * Created by Mobile App Develop on 7-3-16.
 */
public class MyPreference {

   private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    Context context;
    static final String NAME="Nazmul";
    HashMap<String, String> meMap;

    public MyPreference(Context context) {
        sharedPreferences=context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        this.context=context;

    }



    public void saveData(String firstData,String secondData){

        editor.putString("name",firstData);
        editor.putString("pass",secondData);

        editor.commit();
    }
    public HashMap<String,String > retriveData(){
        meMap=new HashMap<String, String>();
        String name=sharedPreferences.getString("name","Name hase been Removed");
        String pass=sharedPreferences.getString("pass","pass hase been Removed");
        meMap.put("name",name);
        meMap.put("pass",pass);
       return meMap;
    }

public void delete(){
    editor.clear();
    editor.commit();
}


}
