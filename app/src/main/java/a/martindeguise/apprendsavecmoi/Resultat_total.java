package a.martindeguise.apprendsavecmoi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Martin on 19/03/2018.
 */

public class Resultat_total extends AppCompatActivity {

    String filepath = "score.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resultat_total);

        // String test = readFromFile(this);

        // Get reference of widgets from XML layout
        final ListView lv = (ListView) findViewById(R.id.listview);

        // Initializing a new String Array
        String[] scores = new String[] {};


        // Create a List from String Array elements
        final List<String> scores_list = new ArrayList<String>(Arrays.asList(scores));

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filepath)));

            // do reading, usually loop until end of file reading
            String mLine;

            while ((mLine = reader.readLine()) != null) {
                scores_list.add(mLine);
            }
        } catch (IOException e) {
            scores_list.add(e.toString());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    scores_list.add(e.toString());
                }
            }
        }

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, scores_list);

        // DataBind ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);


        // Création bouton retour accueil avec moi
        final ImageButton accueilButton = findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resultat_total.this, Acceuil.class);
                startActivity(intent);
            }
        });
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}
