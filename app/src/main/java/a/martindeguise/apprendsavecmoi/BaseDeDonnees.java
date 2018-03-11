package a.martindeguise.apprendsavecmoi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



/**
 * Created by martin on 11/03/2018.
 */

public class BaseDeDonnees extends SQLiteOpenHelper {
    public static final String TABLE_SCORES = "table_score";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_DATE = "date_exo";
    public static final String COLUMN_RESULTAT = "Resultat";
    public static final String COLUMN_RESULTATUSER = "ResultatUser";
    public static final String COLUMN_EQUATION = "Equation";
    public static final String COLUMN_REUSSIT = "Reussit";

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE = "create table "
            + TABLE_SCORES + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_DATE + " DEFAULT CURRENT_TIMESTAMP,"
            + COLUMN_RESULTAT + " text not null),"
            + COLUMN_RESULTATUSER + " text not null),"
            + COLUMN_EQUATION + " text not null),"
            + COLUMN_REUSSIT + " boolean not null);";

    public BaseDeDonnees(Context context) {
        super(context, "apprends.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(BaseDeDonnees.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
        onCreate(db);
    }
}
