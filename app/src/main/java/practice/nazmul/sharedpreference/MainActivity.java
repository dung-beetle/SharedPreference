package practice.nazmul.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    EditText inputData;
    EditText inputData1;
    TextView showData;

    String firstData,seconddata;
    MyPreference myPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputData=(EditText)findViewById(R.id.inputData);
        inputData1=(EditText)findViewById(R.id.inputData1);
        showData=(TextView)findViewById(R.id.showdata);
        myPreference=new MyPreference(MainActivity.this);


    }
    public void saveData(View view){
      firstData=inputData.getText().toString();
        seconddata=inputData1.getText().toString();
        myPreference.saveData(firstData,seconddata);
        inputData.getText().clear();
        inputData1.getText().clear();
    }
    public void retriveData(View view){

       HashMap myMap= myPreference.retriveData();
        String name=myMap.get("name").toString();
        String pass=myMap.get("pass").toString();
       showData.setText(name+" "+pass);


        }


    public void deleteData(View view){
        myPreference.delete();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
