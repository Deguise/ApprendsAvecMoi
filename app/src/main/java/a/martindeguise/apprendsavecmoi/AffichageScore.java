package a.martindeguise.apprendsavecmoi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.io.EOFException;;
import android.widget.ListView;

/**
 * Created by martin on 11/03/2018.
 */

public class AffichageScore extends AppCompatActivity {

    private List<Score> scores = null;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_score);

        //mListView = (ListView) findViewById(R.id.listView);

        //ScoresAdaptateur adapter = new ScoresAdaptateur(AffichageScore.this, scores);
        //mListView.setAdapter(adapter);
    }

    public List<Score> getAllScores() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("score.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        while (true) {
            try {
                Score o = (Score) ois.readObject();
                scores.add(o);
        }
        catch(EOFException  e) {
                break;
            }
    }
        return scores;
    }
}
