package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

// Imports pour le dessin seulement
import android.graphics.*;
import android.view.MotionEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.Math.min;

//---------------------------------


public class Tracelalettre_facile extends AppCompatActivity
{

    DrawingView dv;
    private Paint mPaint;
    FrameLayout fl;
    View view;
    // View view = (View) findViewById(R.layout.layout_trace_lettre_facile);
    // LinearLayout picLL = new LinearLayout(CurrentActivity.this);


    // ImageView myImage = new ImageView(this);
    // picLL.addView(myImage);


    // On prend des tableaux de 100*100 cases pour avoir de la marge.
    // On prend toujours x+10 et y+10 pour ne pas avoir de valeurs negatives
    // dans les tableaux
    boolean tableResults[][] = new boolean[25][25];
    boolean tableUser[][] = new boolean[25][25];

    private static final String SAVE_FILE_PATH = "data/save";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_trace_la_lettre_facile);

        fl = new FrameLayout(this);
        dv = new DrawingView(this);
        view = new View(this);

//		Arrays.fill(tableResults, Boolean.FALSE);
//		Arrays.fill(tableUser, Boolean.FALSE);

        // On prend des tableaux de 25*25 cases pour avoir de la marge.
        for (int i=0; i <25; i++)
        {
            for (int j=0; j<25; j++)
            {
                tableUser[i][j] = FALSE;
                tableResults[i][j] = FALSE;
            }
        }
        System.out.print("\n------------------------------\n");


        String test = readFromFile(this);

        System.out.print(test);
        System.out.print("\n------------------------------\n");

        // Mise en mémoire du tableau pour A

        tableResults[ 2 ][ 18 ] = TRUE;
        tableResults[ 2 ][ 18 ] = TRUE;
        tableResults[ 1 ][ 18 ] = TRUE;
        tableResults[ 1 ][ 19 ] = TRUE;
        tableResults[ 1 ][ 19 ] = TRUE;
        tableResults[ 1 ][ 19 ] = TRUE;
        tableResults[ 1 ][ 19 ] = TRUE;
        tableResults[ 2 ][ 19 ] = TRUE;
        tableResults[ 2 ][ 19 ] = TRUE;
        tableResults[ 2 ][ 19 ] = TRUE;
        tableResults[ 2 ][ 19 ] = TRUE;
        tableResults[ 2 ][ 19 ] = TRUE;
        tableResults[ 2 ][ 20 ] = TRUE;
        tableResults[ 3 ][ 20 ] = TRUE;
        tableResults[ 3 ][ 20 ] = TRUE;
        tableResults[ 3 ][ 20 ] = TRUE;
        tableResults[ 3 ][ 20 ] = TRUE;
        tableResults[ 3 ][ 20 ] = TRUE;
        tableResults[ 3 ][ 20 ] = TRUE;
        tableResults[ 4 ][ 20 ] = TRUE;
        tableResults[ 4 ][ 20 ] = TRUE;
        tableResults[ 4 ][ 20 ] = TRUE;
        tableResults[ 4 ][ 20 ] = TRUE;
        tableResults[ 4 ][ 20 ] = TRUE;
        tableResults[ 5 ][ 20 ] = TRUE;
        tableResults[ 5 ][ 20 ] = TRUE;
        tableResults[ 5 ][ 20 ] = TRUE;
        tableResults[ 5 ][ 20 ] = TRUE;
        tableResults[ 5 ][ 20 ] = TRUE;
        tableResults[ 6 ][ 20 ] = TRUE;
        tableResults[ 6 ][ 19 ] = TRUE;
        tableResults[ 6 ][ 19 ] = TRUE;
        tableResults[ 6 ][ 19 ] = TRUE;
        tableResults[ 6 ][ 19 ] = TRUE;
        tableResults[ 6 ][ 19 ] = TRUE;
        tableResults[ 7 ][ 19 ] = TRUE;
        tableResults[ 7 ][ 19 ] = TRUE;
        tableResults[ 7 ][ 19 ] = TRUE;
        tableResults[ 7 ][ 18 ] = TRUE;
        tableResults[ 7 ][ 18 ] = TRUE;
        tableResults[ 7 ][ 18 ] = TRUE;
        tableResults[ 7 ][ 18 ] = TRUE;
        tableResults[ 7 ][ 18 ] = TRUE;
        tableResults[ 7 ][ 18 ] = TRUE;
        tableResults[ 7 ][ 18 ] = TRUE;
        tableResults[ 7 ][ 18 ] = TRUE;
        tableResults[ 7 ][ 17 ] = TRUE;
        tableResults[ 7 ][ 17 ] = TRUE;
        tableResults[ 8 ][ 17 ] = TRUE;
        tableResults[ 8 ][ 17 ] = TRUE;
        tableResults[ 8 ][ 17 ] = TRUE;
        tableResults[ 8 ][ 17 ] = TRUE;
        tableResults[ 8 ][ 16 ] = TRUE;
        tableResults[ 8 ][ 16 ] = TRUE;
        tableResults[ 8 ][ 16 ] = TRUE;
        tableResults[ 8 ][ 16 ] = TRUE;
        tableResults[ 8 ][ 16 ] = TRUE;
        tableResults[ 8 ][ 16 ] = TRUE;
        tableResults[ 8 ][ 15 ] = TRUE;
        tableResults[ 8 ][ 15 ] = TRUE;
        tableResults[ 8 ][ 15 ] = TRUE;
        tableResults[ 8 ][ 15 ] = TRUE;
        tableResults[ 8 ][ 15 ] = TRUE;
        tableResults[ 8 ][ 15 ] = TRUE;
        tableResults[ 8 ][ 14 ] = TRUE;
        tableResults[ 8 ][ 14 ] = TRUE;
        tableResults[ 8 ][ 14 ] = TRUE;
        tableResults[ 8 ][ 14 ] = TRUE;
        tableResults[ 8 ][ 14 ] = TRUE;
        tableResults[ 8 ][ 14 ] = TRUE;
        tableResults[ 8 ][ 13 ] = TRUE;
        tableResults[ 8 ][ 13 ] = TRUE;
        tableResults[ 9 ][ 13 ] = TRUE;
        tableResults[ 9 ][ 13 ] = TRUE;
        tableResults[ 9 ][ 12 ] = TRUE;
        tableResults[ 9 ][ 12 ] = TRUE;
        tableResults[ 9 ][ 12 ] = TRUE;
        tableResults[ 9 ][ 12 ] = TRUE;
        tableResults[ 9 ][ 12 ] = TRUE;
        tableResults[ 9 ][ 12 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 10 ] = TRUE;
        tableResults[ 9 ][ 10 ] = TRUE;
        tableResults[ 9 ][ 10 ] = TRUE;
        tableResults[ 9 ][ 10 ] = TRUE;
        tableResults[ 9 ][ 9 ] = TRUE;
        tableResults[ 9 ][ 9 ] = TRUE;
        tableResults[ 9 ][ 9 ] = TRUE;
        tableResults[ 9 ][ 9 ] = TRUE;
        tableResults[ 9 ][ 9 ] = TRUE;
        tableResults[ 9 ][ 9 ] = TRUE;
        tableResults[ 9 ][ 8 ] = TRUE;
        tableResults[ 9 ][ 8 ] = TRUE;
        tableResults[ 9 ][ 8 ] = TRUE;
        tableResults[ 9 ][ 8 ] = TRUE;
        tableResults[ 9 ][ 8 ] = TRUE;
        tableResults[ 9 ][ 8 ] = TRUE;
        tableResults[ 9 ][ 7 ] = TRUE;
        tableResults[ 9 ][ 7 ] = TRUE;
        tableResults[ 9 ][ 7 ] = TRUE;
        tableResults[ 9 ][ 7 ] = TRUE;
        tableResults[ 10 ][ 6 ] = TRUE;
        tableResults[ 10 ][ 6 ] = TRUE;
        tableResults[ 10 ][ 6 ] = TRUE;
        tableResults[ 10 ][ 6 ] = TRUE;
        tableResults[ 10 ][ 6 ] = TRUE;
        tableResults[ 10 ][ 5 ] = TRUE;
        tableResults[ 10 ][ 5 ] = TRUE;
        tableResults[ 10 ][ 5 ] = TRUE;
        tableResults[ 10 ][ 4 ] = TRUE;
        tableResults[ 10 ][ 4 ] = TRUE;
        tableResults[ 10 ][ 4 ] = TRUE;
        tableResults[ 10 ][ 4 ] = TRUE;
        tableResults[ 10 ][ 4 ] = TRUE;
        tableResults[ 10 ][ 4 ] = TRUE;
        tableResults[ 10 ][ 3 ] = TRUE;
        tableResults[ 10 ][ 3 ] = TRUE;
        tableResults[ 10 ][ 3 ] = TRUE;
        tableResults[ 10 ][ 3 ] = TRUE;
        tableResults[ 10 ][ 3 ] = TRUE;
        tableResults[ 10 ][ 3 ] = TRUE;
        tableResults[ 11 ][ 2 ] = TRUE;
        tableResults[ 11 ][ 1 ] = TRUE;
        tableResults[ 11 ][ 1 ] = TRUE;
        tableResults[ 11 ][ 0 ] = TRUE;
        tableResults[ 11 ][ 0 ] = TRUE;
        tableResults[ 11 ][ 0 ] = TRUE;
        tableResults[ 11 ][ 1 ] = TRUE;
        tableResults[ 12 ][ 1 ] = TRUE;
        tableResults[ 12 ][ 1 ] = TRUE;
        tableResults[ 12 ][ 1 ] = TRUE;
        tableResults[ 12 ][ 1 ] = TRUE;
        tableResults[ 12 ][ 1 ] = TRUE;
        tableResults[ 12 ][ 1 ] = TRUE;
        tableResults[ 12 ][ 2 ] = TRUE;
        tableResults[ 12 ][ 2 ] = TRUE;
        tableResults[ 12 ][ 2 ] = TRUE;
        tableResults[ 12 ][ 2 ] = TRUE;
        tableResults[ 12 ][ 2 ] = TRUE;
        tableResults[ 12 ][ 2 ] = TRUE;
        tableResults[ 12 ][ 3 ] = TRUE;
        tableResults[ 12 ][ 3 ] = TRUE;
        tableResults[ 12 ][ 3 ] = TRUE;
        tableResults[ 12 ][ 3 ] = TRUE;
        tableResults[ 12 ][ 3 ] = TRUE;
        tableResults[ 12 ][ 3 ] = TRUE;
        tableResults[ 12 ][ 4 ] = TRUE;
        tableResults[ 12 ][ 4 ] = TRUE;
        tableResults[ 12 ][ 4 ] = TRUE;
        tableResults[ 12 ][ 4 ] = TRUE;
        tableResults[ 12 ][ 4 ] = TRUE;
        tableResults[ 12 ][ 4 ] = TRUE;
        tableResults[ 12 ][ 5 ] = TRUE;
        tableResults[ 12 ][ 5 ] = TRUE;
        tableResults[ 12 ][ 5 ] = TRUE;
        tableResults[ 12 ][ 5 ] = TRUE;
        tableResults[ 12 ][ 5 ] = TRUE;
        tableResults[ 12 ][ 6 ] = TRUE;
        tableResults[ 12 ][ 6 ] = TRUE;
        tableResults[ 12 ][ 6 ] = TRUE;
        tableResults[ 12 ][ 6 ] = TRUE;
        tableResults[ 12 ][ 7 ] = TRUE;
        tableResults[ 12 ][ 7 ] = TRUE;
        tableResults[ 12 ][ 7 ] = TRUE;
        tableResults[ 12 ][ 7 ] = TRUE;
        tableResults[ 12 ][ 7 ] = TRUE;
        tableResults[ 12 ][ 7 ] = TRUE;
        tableResults[ 12 ][ 8 ] = TRUE;
        tableResults[ 12 ][ 8 ] = TRUE;
        tableResults[ 12 ][ 8 ] = TRUE;
        tableResults[ 12 ][ 8 ] = TRUE;
        tableResults[ 12 ][ 8 ] = TRUE;
        tableResults[ 12 ][ 9 ] = TRUE;
        tableResults[ 12 ][ 9 ] = TRUE;
        tableResults[ 12 ][ 9 ] = TRUE;
        tableResults[ 12 ][ 9 ] = TRUE;
        tableResults[ 12 ][ 9 ] = TRUE;
        tableResults[ 12 ][ 9 ] = TRUE;
        tableResults[ 12 ][ 10 ] = TRUE;
        tableResults[ 12 ][ 10 ] = TRUE;
        tableResults[ 12 ][ 10 ] = TRUE;
        tableResults[ 12 ][ 10 ] = TRUE;
        tableResults[ 12 ][ 10 ] = TRUE;
        tableResults[ 12 ][ 11 ] = TRUE;
        tableResults[ 13 ][ 11 ] = TRUE;
        tableResults[ 13 ][ 11 ] = TRUE;
        tableResults[ 13 ][ 11 ] = TRUE;
        tableResults[ 13 ][ 11 ] = TRUE;
        tableResults[ 13 ][ 12 ] = TRUE;
        tableResults[ 13 ][ 12 ] = TRUE;
        tableResults[ 13 ][ 12 ] = TRUE;
        tableResults[ 13 ][ 12 ] = TRUE;
        tableResults[ 13 ][ 12 ] = TRUE;
        tableResults[ 13 ][ 12 ] = TRUE;
        tableResults[ 13 ][ 13 ] = TRUE;
        tableResults[ 13 ][ 13 ] = TRUE;
        tableResults[ 13 ][ 13 ] = TRUE;
        tableResults[ 13 ][ 13 ] = TRUE;
        tableResults[ 13 ][ 13 ] = TRUE;
        tableResults[ 13 ][ 13 ] = TRUE;
        tableResults[ 13 ][ 14 ] = TRUE;
        tableResults[ 13 ][ 14 ] = TRUE;
        tableResults[ 13 ][ 14 ] = TRUE;
        tableResults[ 13 ][ 14 ] = TRUE;
        tableResults[ 13 ][ 14 ] = TRUE;
        tableResults[ 13 ][ 15 ] = TRUE;
        tableResults[ 13 ][ 15 ] = TRUE;
        tableResults[ 13 ][ 15 ] = TRUE;
        tableResults[ 13 ][ 15 ] = TRUE;
        tableResults[ 13 ][ 15 ] = TRUE;
        tableResults[ 13 ][ 16 ] = TRUE;
        tableResults[ 13 ][ 16 ] = TRUE;
        tableResults[ 13 ][ 16 ] = TRUE;
        tableResults[ 13 ][ 16 ] = TRUE;
        tableResults[ 13 ][ 16 ] = TRUE;
        tableResults[ 13 ][ 16 ] = TRUE;
        tableResults[ 13 ][ 17 ] = TRUE;
        tableResults[ 13 ][ 17 ] = TRUE;
        tableResults[ 13 ][ 17 ] = TRUE;
        tableResults[ 13 ][ 17 ] = TRUE;
        tableResults[ 13 ][ 17 ] = TRUE;
        tableResults[ 13 ][ 17 ] = TRUE;
        tableResults[ 13 ][ 18 ] = TRUE;
        tableResults[ 14 ][ 18 ] = TRUE;
        tableResults[ 14 ][ 18 ] = TRUE;
        tableResults[ 14 ][ 19 ] = TRUE;
        tableResults[ 14 ][ 19 ] = TRUE;
        tableResults[ 14 ][ 19 ] = TRUE;
        tableResults[ 15 ][ 19 ] = TRUE;
        tableResults[ 15 ][ 19 ] = TRUE;
        tableResults[ 15 ][ 19 ] = TRUE;
        tableResults[ 16 ][ 19 ] = TRUE;
        tableResults[ 16 ][ 19 ] = TRUE;
        tableResults[ 16 ][ 19 ] = TRUE;
        tableResults[ 17 ][ 19 ] = TRUE;
        tableResults[ 17 ][ 20 ] = TRUE;
        tableResults[ 18 ][ 20 ] = TRUE;
        tableResults[ 18 ][ 20 ] = TRUE;
        tableResults[ 18 ][ 20 ] = TRUE;
        tableResults[ 18 ][ 20 ] = TRUE;
        tableResults[ 18 ][ 20 ] = TRUE;
        tableResults[ 18 ][ 20 ] = TRUE;
        tableResults[ 19 ][ 20 ] = TRUE;
        tableResults[ 19 ][ 20 ] = TRUE;
        tableResults[ 19 ][ 20 ] = TRUE;
        tableResults[ 19 ][ 20 ] = TRUE;
        tableResults[ 19 ][ 20 ] = TRUE;
        tableResults[ 20 ][ 20 ] = TRUE;
        tableResults[ 20 ][ 19 ] = TRUE;
        tableResults[ 20 ][ 19 ] = TRUE;
        tableResults[ 20 ][ 19 ] = TRUE;
        tableResults[ 20 ][ 19 ] = TRUE;
        tableResults[ 20 ][ 19 ] = TRUE;
        tableResults[ 20 ][ 19 ] = TRUE;
        tableResults[ 20 ][ 19 ] = TRUE;
        tableResults[ 21 ][ 19 ] = TRUE;
        tableResults[ 21 ][ 19 ] = TRUE;
        tableResults[ 21 ][ 19 ] = TRUE;
        tableResults[ 21 ][ 18 ] = TRUE;
        tableResults[ 21 ][ 18 ] = TRUE;
        tableResults[ 21 ][ 18 ] = TRUE;
        tableResults[ 21 ][ 18 ] = TRUE;
        tableResults[ 21 ][ 18 ] = TRUE;
        tableResults[ 21 ][ 17 ] = TRUE;
        tableResults[ 22 ][ 17 ] = TRUE;
        tableResults[ 22 ][ 17 ] = TRUE;
        tableResults[ 22 ][ 17 ] = TRUE;
        tableResults[ 22 ][ 17 ] = TRUE;
        tableResults[ 22 ][ 17 ] = TRUE;
        tableResults[ 22 ][ 17 ] = TRUE;
        tableResults[ 22 ][ 16 ] = TRUE;
        tableResults[ 22 ][ 16 ] = TRUE;
        tableResults[ 22 ][ 16 ] = TRUE;
        tableResults[ 22 ][ 16 ] = TRUE;
        tableResults[ 22 ][ 16 ] = TRUE;
        tableResults[ 22 ][ 15 ] = TRUE;
        tableResults[ 22 ][ 15 ] = TRUE;
        tableResults[ 22 ][ 15 ] = TRUE;
        tableResults[ 22 ][ 15 ] = TRUE;
        tableResults[ 22 ][ 15 ] = TRUE;
        tableResults[ 22 ][ 15 ] = TRUE;
        tableResults[ 22 ][ 15 ] = TRUE;
        tableResults[ 22 ][ 14 ] = TRUE;
        tableResults[ 22 ][ 14 ] = TRUE;
        tableResults[ 22 ][ 14 ] = TRUE;
        tableResults[ 22 ][ 14 ] = TRUE;
        tableResults[ 21 ][ 14 ] = TRUE;
        tableResults[ 21 ][ 14 ] = TRUE;
        tableResults[ 21 ][ 13 ] = TRUE;
        tableResults[ 21 ][ 13 ] = TRUE;
        tableResults[ 21 ][ 13 ] = TRUE;
        tableResults[ 21 ][ 13 ] = TRUE;
        tableResults[ 21 ][ 13 ] = TRUE;
        tableResults[ 21 ][ 13 ] = TRUE;
        tableResults[ 20 ][ 13 ] = TRUE;
        tableResults[ 20 ][ 12 ] = TRUE;
        tableResults[ 20 ][ 12 ] = TRUE;
        tableResults[ 20 ][ 12 ] = TRUE;
        tableResults[ 20 ][ 12 ] = TRUE;
        tableResults[ 20 ][ 12 ] = TRUE;
        tableResults[ 19 ][ 12 ] = TRUE;
        tableResults[ 19 ][ 12 ] = TRUE;
        tableResults[ 19 ][ 12 ] = TRUE;
        tableResults[ 19 ][ 12 ] = TRUE;
        tableResults[ 19 ][ 12 ] = TRUE;
        tableResults[ 19 ][ 12 ] = TRUE;
        tableResults[ 18 ][ 12 ] = TRUE;
        tableResults[ 18 ][ 12 ] = TRUE;
        tableResults[ 18 ][ 12 ] = TRUE;
        tableResults[ 18 ][ 12 ] = TRUE;
        tableResults[ 18 ][ 12 ] = TRUE;
        tableResults[ 18 ][ 12 ] = TRUE;
        tableResults[ 17 ][ 12 ] = TRUE;
        tableResults[ 17 ][ 13 ] = TRUE;
        tableResults[ 17 ][ 13 ] = TRUE;
        tableResults[ 17 ][ 13 ] = TRUE;
        tableResults[ 17 ][ 13 ] = TRUE;
        tableResults[ 17 ][ 13 ] = TRUE;
        tableResults[ 17 ][ 14 ] = TRUE;
        tableResults[ 17 ][ 14 ] = TRUE;
        tableResults[ 17 ][ 14 ] = TRUE;
        tableResults[ 17 ][ 14 ] = TRUE;
        tableResults[ 17 ][ 14 ] = TRUE;
        tableResults[ 17 ][ 14 ] = TRUE;
        tableResults[ 17 ][ 15 ] = TRUE;
        tableResults[ 17 ][ 15 ] = TRUE;
        tableResults[ 16 ][ 15 ] = TRUE;
        tableResults[ 16 ][ 15 ] = TRUE;
        tableResults[ 16 ][ 15 ] = TRUE;
        tableResults[ 16 ][ 16 ] = TRUE;
        tableResults[ 16 ][ 16 ] = TRUE;
        tableResults[ 16 ][ 16 ] = TRUE;
        tableResults[ 16 ][ 16 ] = TRUE;
        tableResults[ 16 ][ 16 ] = TRUE;
        tableResults[ 16 ][ 16 ] = TRUE;
        tableResults[ 3 ][ 12 ] = TRUE;
        tableResults[ 3 ][ 12 ] = TRUE;
        tableResults[ 3 ][ 12 ] = TRUE;
        tableResults[ 4 ][ 12 ] = TRUE;
        tableResults[ 4 ][ 12 ] = TRUE;
        tableResults[ 4 ][ 11 ] = TRUE;
        tableResults[ 4 ][ 11 ] = TRUE;
        tableResults[ 5 ][ 11 ] = TRUE;
        tableResults[ 5 ][ 11 ] = TRUE;
        tableResults[ 5 ][ 11 ] = TRUE;
        tableResults[ 5 ][ 11 ] = TRUE;
        tableResults[ 5 ][ 11 ] = TRUE;
        tableResults[ 6 ][ 11 ] = TRUE;
        tableResults[ 6 ][ 11 ] = TRUE;
        tableResults[ 6 ][ 11 ] = TRUE;
        tableResults[ 6 ][ 11 ] = TRUE;
        tableResults[ 7 ][ 11 ] = TRUE;
        tableResults[ 7 ][ 11 ] = TRUE;
        tableResults[ 7 ][ 11 ] = TRUE;
        tableResults[ 8 ][ 11 ] = TRUE;
        tableResults[ 8 ][ 11 ] = TRUE;
        tableResults[ 8 ][ 11 ] = TRUE;
        tableResults[ 8 ][ 11 ] = TRUE;
        tableResults[ 8 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 9 ][ 11 ] = TRUE;
        tableResults[ 10 ][ 11 ] = TRUE;
        tableResults[ 10 ][ 11 ] = TRUE;
        tableResults[ 10 ][ 11 ] = TRUE;
        tableResults[ 10 ][ 11 ] = TRUE;
        tableResults[ 10 ][ 11 ] = TRUE;
        tableResults[ 11 ][ 11 ] = TRUE;
        tableResults[ 11 ][ 11 ] = TRUE;
        tableResults[ 11 ][ 11 ] = TRUE;
        tableResults[ 11 ][ 11 ] = TRUE;
        tableResults[ 11 ][ 11 ] = TRUE;
        tableResults[ 12 ][ 11 ] = TRUE;
        tableResults[ 12 ][ 11 ] = TRUE;
        tableResults[ 12 ][ 11 ] = TRUE;
        tableResults[ 13 ][ 11 ] = TRUE;
        tableResults[ 13 ][ 11 ] = TRUE;
        tableResults[ 13 ][ 11 ] = TRUE;
        tableResults[ 14 ][ 11 ] = TRUE;
        tableResults[ 14 ][ 11 ] = TRUE;
        tableResults[ 14 ][ 11 ] = TRUE;
        tableResults[ 15 ][ 11 ] = TRUE;
        tableResults[ 15 ][ 11 ] = TRUE;
        tableResults[ 15 ][ 11 ] = TRUE;
        tableResults[ 15 ][ 11 ] = TRUE;
        tableResults[ 16 ][ 11 ] = TRUE;
        tableResults[ 16 ][ 11 ] = TRUE;
        tableResults[ 17 ][ 11 ] = TRUE;
        tableResults[ 19 ][ 11 ] = TRUE;
        tableResults[ 19 ][ 11 ] = TRUE;
        tableResults[ 19 ][ 11 ] = TRUE;
        tableResults[ 19 ][ 11 ] = TRUE;
        tableResults[ 19 ][ 11 ] = TRUE;
        tableResults[ 19 ][ 10 ] = TRUE;
        tableResults[ 19 ][ 10 ] = TRUE;
        tableResults[ 19 ][ 10 ] = TRUE;
        tableResults[ 20 ][ 10 ] = TRUE;
        tableResults[ 20 ][ 10 ] = TRUE;
        tableResults[ 20 ][ 10 ] = TRUE;
        tableResults[ 19 ][ 10 ] = TRUE;
        tableResults[ 19 ][ 10 ] = TRUE;
        tableResults[ 19 ][ 10 ] = TRUE;
        tableResults[ 19 ][ 10 ] = TRUE;
        tableResults[ 19 ][ 10 ] = TRUE;
        tableResults[ 18 ][ 10 ] = TRUE;
        tableResults[ 18 ][ 10 ] = TRUE;
        tableResults[ 18 ][ 10 ] = TRUE;
        tableResults[ 18 ][ 10 ] = TRUE;
        tableResults[ 18 ][ 10 ] = TRUE;
        tableResults[ 18 ][ 11 ] = TRUE;
        tableResults[ 17 ][ 11 ] = TRUE;
        tableResults[ 17 ][ 11 ] = TRUE;
        tableResults[ 17 ][ 11 ] = TRUE;
        tableResults[ 17 ][ 11 ] = TRUE;
        tableResults[ 17 ][ 11 ] = TRUE;



        /////////////////////////////////////////////////////









        System.out.println("compter à partir de là");
//		final ImageButton facileButton = findViewById(R.id.imageButton80);

        fl.addView(dv);
        fl.addView(view);
        setContentView(fl);
        //setContentView(new DrawingView(this));

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(12);

    }

    public class DrawingView extends View
    {
        public int width;
        public int height;
        private Bitmap mBitmap;
        private Canvas mCanvas;
        private Path mPath;
        private Paint mBitmapPaint;
        Context context;
        private Paint circlePaint;
        private Path circlePath;

        private int offsetArea;
        private int buttonArea;


        public DrawingView(Context c)
        {
            super(c);
            context=c;
            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
            circlePaint = new Paint();
            circlePath = new Path();
            circlePaint.setAntiAlias(true);
            circlePaint.setColor(Color.YELLOW);
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setStrokeJoin(Paint.Join.MITER);
            circlePaint.setStrokeWidth(4f);


            offsetArea = 500;
            buttonArea = offsetArea;

            Drawable d = getResources().getDrawable(R.drawable.maj_a);
            d.setBounds(0, 0, 0, 0);

        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh)
        {
            super.onSizeChanged(w, h, oldw, oldh);
            Resources res = getResources();

            // Nécessaire pour mettre l'image bitmap en arrière-plan du canvas
            mBitmap = BitmapFactory.decodeResource(res, R.drawable.maj_a);

            rescale(BitmapFactory.decodeResource(getResources(), R.drawable.maj_a));
            mCanvas = new Canvas (mBitmap.copy(Bitmap.Config.ARGB_8888, true));
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);

            int x = getWidth();
            int y = getHeight();

            // Position de l'image sur le canvas
            canvas.drawBitmap( mBitmap, null, new RectF(50,50, x-offsetArea, y-50),  mBitmapPaint);

            buttonArea = x-offsetArea;

            canvas.drawPath(mPath, mPaint);
            canvas.drawPath(circlePath, circlePaint);


        }

        private float mX, mY;
        private static final float TOUCH_TOLERANCE  = 4;

        private void touch_start(float x, float y)
        {

            //  Décommenter pour que le path reset au toucher
            //mPath.reset();

            if (x < buttonArea)
            {
                mPath.moveTo(x,y);

                int caseX = (int)(x/32);
                int caseY = (int)(y/32);
                if (caseX <=0)
                {
                    caseX = 0;
                }
                if (caseY <=0)
                {
                    caseY = 0;
                }
                tableUser[caseX][caseY]=TRUE;
            }
            else
            {
                results(tableUser,tableResults);

                Intent i = new Intent(getApplicationContext(), TraceLettreResultat.class);
                startActivity(i);
            }

            mX = x;
            mY = y;
        }

        private void touch_move(float x, float y)
        {
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);

            if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE)
            {
                mPath.quadTo(mX,mY, (x+mX)/2, (y+mY)/2);
                mX = x;
                mY = y;

                int caseX = (int)(x/32);
                int caseY = (int)(y/32);
                if (caseX <=0)
                {
                    caseX = 0;
                }
                if (caseY <=0)
                {
                    caseY = 0;
                }

                tableUser[caseX][caseY]=TRUE;

                circlePath.reset();
                circlePath.addCircle(mX,mY, 30, Path.Direction.CW);
            }
        }

        private void touch_up()
        {
            mPath.lineTo(mX,mY);
            circlePath.reset();

            // Commit the path to our offscreen
            mCanvas.drawPath(mPath, mPaint);

            //  Décommenter pour que le path reset au toucher
            //mPath.reset();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event)
        {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN:

                    touch_start(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (x < buttonArea) {
                        touch_move(x, y);
                    }
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    touch_up();
                    invalidate();
                    break;
            }
            return true;
        }

        public Bitmap rescale(Bitmap originalImage)
        {
            float originalWidth = originalImage.getWidth();
            float originalHeight = originalImage.getHeight();

            Canvas canvas = new Canvas(mBitmap.copy(Bitmap.Config.ARGB_8888, true));

            float scale = width / originalWidth;

            float xTranslation = 0.0f;
            float yTranslation = (height - originalHeight * scale) / 2.0f;

            Matrix transformation = new Matrix();
            transformation.postTranslate(xTranslation, yTranslation);
            transformation.preScale(scale, scale);

            Paint paint = new Paint();
            paint.setFilterBitmap(true);

            canvas.drawBitmap(originalImage, transformation, paint);

            return mBitmap.copy(Bitmap.Config.ARGB_8888, true);
        }
    }


    // Calcul du score
    public float results(boolean tableUser[][], boolean tableResults[][])
    {
        int score=0;
        for (int i=0;i<25; i++)
        {
            for (int j=0;j<25;j++)
            {
                if ((tableResults[i][j]==TRUE)&&(tableUser[i][j]==TRUE))
                {
                    // On donne 20 points de plus !
                    score = score+20;
                    //System.out.print("\n : "+i+ " | " + j + "\n");
                }
                else if (tableUser[i][j] == TRUE)
                {
                    // On enl-ve seulement un point par un point pour pas
                    // que ce soit trop punitif
                    score --;
                }
            }
        }
        if (score<0)
        {
            score=0;
        }
        System.out.print("\n"+score+"\n");
        return score;
    }

/*	public void loadData() throws FileNotFoundException {
		File file = new File(SAVE_FILE_PATH);

		Scanner scanner;

		if (file.exists())
		{
			scanner = new Scanner(new FileInputStream(file));
			try
			{
				while (scanner.hasNextLine())
				{
					allPlayers.add(new Player(scanner.nextLine()));
				}
			}
			finally
			{
				scanner.close();
			}
		}
		else
		{
			System.out.println("No file found");
		}
	}*/

    private String readFromFile(Context context)
    {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("maj_A.txt");

            if ( inputStream != null )
            {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null )
                {
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

