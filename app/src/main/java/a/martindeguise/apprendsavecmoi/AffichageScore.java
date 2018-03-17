package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.io.EOFException;;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by martin on 11/03/2018.
 */

public class AffichageScore extends AppCompatActivity {

    private List<Score> scores = null;
    ListView vue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_score);

        vue = (ListView) findViewById(R.id.listView);
        Score score = new Score();

        try {
            scores =  score.getAllScores();
        }
        catch (IOException e){
            System.out.println("probleme1");
        }
        catch (ClassNotFoundException e){
            System.out.println("probleme2");
        }

        if (scores != null) {

            List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();

            HashMap<String, String> element;

            for (int i = 0; i < scores.size(); i++) {

                element = new HashMap<String, String>();

                element.put("text1", scores.get(i).getEquation());

                element.put("text2", scores.get(i).getReussit());
                liste.add(element);
            }

            ListAdapter adapter = new SimpleAdapter(this,
                    liste,
                    android.R.layout.simple_list_item_2,
                    new String[]{"text1", "text2"},
                    new int[]{android.R.id.text1, android.R.id.text2});

            vue.setAdapter(adapter);
        }
        else {
            List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();

            HashMap<String, String> element;

            element = new HashMap<String, String>();

            element.put("text1", "NULL");

            element.put("text2", "NULL");
            liste.add(element);

            ListAdapter adapter = new SimpleAdapter(this,
                    liste,
                    android.R.layout.simple_list_item_2,
                    new String[]{"text1", "text2"},
                    new int[]{android.R.id.text1, android.R.id.text2});

            vue.setAdapter(adapter);
        }
    }
}
