package a.martindeguise.apprendsavecmoi;



/**
 * Created by martin on 11/03/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

public class ScoresBDD {

    private static final String TABLE_SCORES = "table_score";

    // ID
    private static final String COLUMN_ID = "ID";
    private static final int NUM_COLUMN_ID = 0;

    // DATA
    private static final String COLUMN_DATE = "date_exo";
    private static final int NUM_COLUMN_DATE = 1;

    // RESULTATS
    private static final String COLUMN_RESULTAT = "Resultat";
    private static final int NUM_COLUMN_RESULTAT = 1;

    // RESULTATS USER
    private static final String COLUMN_RESULTATUSER = "ResultatUser";
    private static final int NUM_COLUMN_RESULTATUSER = 1;

    // EQUATION
    private static final String COLUMN_EQUATION = "Equation";
    private static final int NUM_COLUMN_EQUATION = 1;

    // REUSSIT
    private static final String COLUMN_REUSSIT = "Reussit";
    private static final int NUM_COLUMN_REUSSIT  = 1;


    private SQLiteDatabase bdd;

    private BaseDeDonnees maBaseSQLite;

    public ScoresBDD(Context context){
        //On crée la BDD et sa table
        maBaseSQLite = new BaseDeDonnees(context);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertScore(String resultat, String resultatUser, String equation, boolean reussit){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COLUMN_RESULTAT, resultat);
        values.put(COLUMN_RESULTATUSER, resultatUser);
        values.put(COLUMN_EQUATION, equation);
        values.put(COLUMN_REUSSIT, reussit);
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_SCORES, null, values);
    }


    public String[] getScoreReussit(){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_SCORES, new String[] {COLUMN_ID, COLUMN_DATE, COLUMN_RESULTAT, COLUMN_RESULTATUSER, COLUMN_EQUATION, COLUMN_REUSSIT},COLUMN_REUSSIT + " LIKE \"" + true +"\"", null, null, null, null);
        return cursorToScore(c);
    }

    public String[] getScoreNonReussit(){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_SCORES, new String[] {COLUMN_ID, COLUMN_DATE, COLUMN_RESULTAT, COLUMN_RESULTATUSER, COLUMN_EQUATION, COLUMN_REUSSIT},COLUMN_REUSSIT + " LIKE \"" + false +"\"", null, null, null, null);
        return cursorToScore(c);
    }

    public String[] getScoreDate(Date date){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_SCORES, new String[] {COLUMN_ID, COLUMN_DATE, COLUMN_RESULTAT, COLUMN_RESULTATUSER, COLUMN_EQUATION, COLUMN_REUSSIT},COLUMN_DATE + " LIKE \"" + date +"\"", null, null, null, null);
        return cursorToScore(c);
    }

    //Cette méthode permet de convertir un cursor en un tableau de score
    private String[] cursorToScore(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un tableau des scores
        String[] score = {
                c.getString(NUM_COLUMN_DATE),
                c.getString(NUM_COLUMN_RESULTAT),
                c.getString(NUM_COLUMN_RESULTATUSER),
                c.getString(NUM_COLUMN_EQUATION),
                c.getString(NUM_COLUMN_REUSSIT)
        };

        //On ferme le cursor
        c.close();

        //On retourne le tableau
        return score;
    }
}
