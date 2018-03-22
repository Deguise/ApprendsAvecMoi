package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Clem on 20/03/2018.
 */

public class TraceLettreResultat extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_trace_lettre_resultat);

        Intent intent = getIntent();

        //TextView textView80 = findViewById(R.id.textView80); // Vrai resultat
        if (intent != null)
        {
          //  textView80.setText("Pas bon");
        }

    }
}
