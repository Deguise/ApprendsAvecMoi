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
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.Math.min;

//---------------------------------


public class Tracelalettre_difficile extends AppCompatActivity
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
    boolean tableResults[][] = new boolean[50][50];
    boolean tableUser[][] = new boolean[50][50];



    String filepath="maj_A.txt";
    int darkPixels;


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


        darkPixels=0;
        tableResults = readFromFile(this);
        // Mise en mémoire du tableau pour A

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

            mBitmap = BitmapFactory.decodeResource(getResources(),randomLetter());
            Drawable d = getResources().getDrawable(randomLetter());
            d.setBounds(0, 0, 0, 0);

        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh)
        {
            super.onSizeChanged(w, h, oldw, oldh);
            Resources res = getResources();

            // Nécessaire pour mettre l'image bitmap en arrière-plan du canvas
            //mBitmap = BitmapFactory.decodeResource(res, R.drawable.min_z);



            rescale(mBitmap);
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


                //System.out.print(caseX+"-"+caseY+"\n");
                tableUser[caseX][caseY]=TRUE;
            }
            else
            {

                int score = (int)results(tableUser,tableResults);
                Intent i = new Intent(getApplicationContext(), TraceLettreResultat.class);
                i.putExtra("SCORE", score);
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

                //System.out.print(caseX+"-"+caseY+"\n");

                circlePath.reset();
                circlePath.addCircle(mX,mY, 30, Path.Direction.CW);
            }
        }

        private void touch_up()
        {
            mPath.lineTo(mX,mY);
            circlePath.reset();

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


    /**
     * Prend une lettre aléatoire
     * et associe les .txt et
     * image corerspondants.
     */
    public int randomLetter()
    {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 52 + 1);
        switch (randomNum) {
            case 1:
                filepath = "durmaj_a.txt";
                return R.drawable.durmaj_a;
            case 2:
                filepath = "durmaj_b.txt";
                return R.drawable.durmaj_b;
            case 3:
                filepath = "durmaj_c.txt";
                return R.drawable.durmaj_c;
            case 4:
                filepath = "durmaj_d.txt";
                return R.drawable.durmaj_d;
            case 5:
                filepath = "durmaj_e.txt";
                return R.drawable.durmaj_e;
            case 6:
                filepath = "durmaj_f.txt";
                return R.drawable.durmaj_f;
            case 7:
                filepath = "durmaj_g.txt";
                return R.drawable.durmaj_g;
            case 8:
                filepath = "durmaj_h.txt";
                return R.drawable.durmaj_h;
            case 9:
                filepath = "durmaj_i.txt";
                return R.drawable.durmaj_i;
            case 10:
                filepath = "durmaj_j.txt";
                return R.drawable.durmaj_j;
            case 11:
                filepath = "durmaj_k.txt";
                return R.drawable.durmaj_k;
            case 12:
                filepath = "durmaj_l.txt";
                return R.drawable.durmaj_l;
            case 13:
                filepath = "durmaj_m.txt";
                return R.drawable.durmaj_m;
            case 14:
                filepath = "durmaj_n.txt";
                return R.drawable.durmaj_n;
            case 15:
                filepath = "durmaj_o.txt";
                return R.drawable.durmaj_o;
            case 16:
                filepath = "durmaj_p.txt";
                return R.drawable.durmaj_p;
            case 17:
                filepath = "durmaj_q.txt";
                return R.drawable.durmaj_q;
            case 18:
                filepath = "durmaj_r.txt";
                return R.drawable.durmaj_r;
            case 19:
                filepath = "durmaj_s.txt";
                return R.drawable.durmaj_s;
            case 20:
                filepath = "durmaj_t.txt";
                return R.drawable.durmaj_t;
            case 21:
                filepath = "durmaj_u.txt";
                return R.drawable.durmaj_u;
            case 22:
                filepath = "durmaj_v.txt";
                return R.drawable.durmaj_v;
            case 23:
                filepath = "durmaj_w.txt";
                return R.drawable.durmaj_w;
            case 24:
                filepath = "durmaj_x.txt";
                return R.drawable.durmaj_x;
            case 25:
                filepath = "durmaj_y.txt";
                return R.drawable.durmaj_y;
            case 26:
                filepath = "durmaj_z.txt";
                return R.drawable.durmaj_z;


            case 27:
                filepath = "durmin_a.txt";
                return R.drawable.durmin_a;
            case 28:
                filepath = "durmin_b.txt";
                return R.drawable.durmin_b;
            case 29:
                filepath = "durmin_c.txt";
                return R.drawable.durmin_c;
            case 30:
                filepath = "durmin_d.txt";
                return R.drawable.durmin_d;
            case 31:
                filepath = "durmin_e.txt";
                return R.drawable.durmin_e;
            case 32:
                filepath = "durmin_f.txt";
                return R.drawable.durmin_f;
            case 33:
                filepath = "durmin_g.txt";
                return R.drawable.durmin_g;
            case 34:
                filepath = "durmin_h.txt";
                return R.drawable.durmin_h;
            case 35:
                filepath = "durmin_i.txt";
                return R.drawable.durmin_i;
            case 36:
                filepath = "durmin_j.txt";
                return R.drawable.durmin_j;
            case 37:
                filepath = "durmin_k.txt";
                return R.drawable.durmin_k;
            case 38:
                filepath = "durmin_l.txt";
                return R.drawable.durmin_l;
            case 39:
                filepath = "durmin_m.txt";
                return R.drawable.durmin_m;
            case 40:
                filepath = "durmin_n.txt";
                return R.drawable.durmin_n;
            case 41:
                filepath = "durmin_o.txt";
                return R.drawable.durmin_o;
            case 42:
                filepath = "durmin_p.txt";
                return R.drawable.durmin_p;
            case 43:
                filepath = "durmin_q.txt";
                return R.drawable.durmin_q;
            case 44:
                filepath = "durmin_r.txt";
                return R.drawable.durmin_r;
            case 45:
                filepath = "durmin_s.txt";
                return R.drawable.durmin_s;
            case 46:
                filepath = "durmin_t.txt";
                return R.drawable.durmin_t;
            case 47:
                filepath = "durmin_u.txt";
                return R.drawable.durmin_u;
            case 48:
                filepath = "durmin_v.txt";
                return R.drawable.durmin_v;
            case 49:
                filepath = "durmin_w.txt";
                return R.drawable.durmin_w;
            case 50:
                filepath = "durmin_x.txt";
                return R.drawable.durmin_x;
            case 51:
                filepath = "durmin_y.txt";
                return R.drawable.durmin_y;
            case 52:
                filepath = "durmin_z.txt";
                return R.drawable.durmin_z;
            default:
                filepath = "durmaj_a.txt";
                return R.drawable.durmin_a;
        }
    }




    /**
     * Fonction qui calcule
     * le score en fonction des cases
     * touchées sur les cases de tableResults.
     * @param tableUser
     * @param tableResults
     * @return le score sur 100.
     */
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
        if (score<0) {
            score = 0;
        }

        if (darkPixels!=0)
        {
            score=score/darkPixels;
        }
        else
        {
            score=score/200;
        }

        // System.out.print("\n"+score+"\n");
        return score;
    }

    /**
     * A method that
     * reads a file and
     * fills tableResults[][]
     * according to it
     * @param context
     * @return table of blacked pixels
     */
    private boolean[][] readFromFile(Context context)
    {

        String ret = "";

        //////////////////////////////////////////////////////
        //System.out.print("\n\n"+filepath+"\n\n");
        //////////////////////////////////////////////////

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filepath)));

            // do reading, usually loop until end of file reading
            String mLine;
            int compteur = 0;
            int case1 =0;
            int case2=0;
            darkPixels=0;
            while ((mLine = reader.readLine()) != null)
            {
                String line = reader.readLine();

                if (line!=null) {
                    String[] parts = line.split("-");
                    case1 = Integer.parseInt(parts[0]);
                    case2 = Integer.parseInt(parts[1]);
                    darkPixels++;

                    tableResults[case1][case2] = TRUE;
                }
            }
            System.out.println(darkPixels);
        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                }        catch (FileNotFoundException e) {
                    Log.e("login activity", "File not found: " + e.toString());
                } catch (IOException e) {
                    Log.e("login activity", "Can not read file: " + e.toString());
                }
            }
        }

        return tableUser;
    }
}

