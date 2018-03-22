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


        tableResults = readFromFile(this);
        // Mise en mémoire du tableau pour A


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

            Drawable d = getResources().getDrawable(R.drawable.maj_z);
            d.setBounds(0, 0, 0, 0);

        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh)
        {
            super.onSizeChanged(w, h, oldw, oldh);
            Resources res = getResources();

            // Nécessaire pour mettre l'image bitmap en arrière-plan du canvas
            mBitmap = BitmapFactory.decodeResource(res, R.drawable.min_z);

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


                System.out.print(caseX+"-"+caseY+"\n");
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

                //System.out.print(caseX+"-"+caseY+"\n");

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
        String filepath="maj_A.txt";


        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filepath)));

            // do reading, usually loop until end of file reading
            String mLine;
            int compteur = 0;
            int case1 =0;
            int case2=0;
            while ((mLine = reader.readLine()) != null)
            {
                if (reader.readLine()!=null) {
                    String[] parts = reader.readLine().split("-");
                    case1 = Integer.parseInt(parts[0]);
                    case2 = Integer.parseInt(parts[1]);

                    tableResults[case1][case2] = TRUE;
                }
            }
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

