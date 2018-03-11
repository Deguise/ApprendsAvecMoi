package a.martindeguise.apprendsavecmoi;

import android.widget.ArrayAdapter;
import java.util.List;
import 	android.content.Context;

/*
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.ObjectInputStream;
    import java.io.EOFException;;
    import android.widget.ListView;
    import android.view.*;
    import 	android.widget.TextView;
    import android.widget.ImageView;
*/

/**
 * Created by martin on 11/03/2018.
 */

public class ScoresAdaptateur extends ArrayAdapter<Score> {

    public ScoresAdaptateur(Context context, List<Score> scores) {
        super(context, 0, scores);
    }
}
