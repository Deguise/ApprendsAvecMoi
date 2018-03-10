package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

// Imports pour le dessin seulement
import android.graphics.*;
import android.view.MotionEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;

import java.io.FileInputStream;

//---------------------------------


public class TraceLettreFacile extends AppCompatActivity 
{

	DrawingView dv;
	private Paint mPaint;

	// View view = (View) findViewById(R.layout.layout_trace_lettre_facile);
	// LinearLayout picLL = new LinearLayout(CurrentActivity.this);


	// ImageView myImage = new ImageView(this);
	// picLL.addView(myImage);



	@Override
	protected void onCreate(Bundle savedInstanceState)
	{


		super.onCreate(savedInstanceState);
		//setContentView(R.layout.layout_trace_lettre_facile);

        dv = new DrawingView(this);
		setContentView(new DrawingView(this));




		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setDither(true);
		mPaint.setColor(Color.BLUE);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setStrokeWidth(12);

	//	TextView textView = findViewById(R.id.textView30);
	//	textView.setText("Trace la lettre dans la zone ci-dessous !");

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

			canvas.drawBitmap( mBitmap, 0,0, mBitmapPaint);
			canvas.drawPath(mPath, mPaint);
			canvas.drawPath(circlePath, circlePaint);


		}

		private float mX, mY;
		private static final float TOUCH_TOLERANCE  = 4;

		private void touch_start(float x, float y)
		{
			mPath.reset();
			mPath.moveTo(x,y);
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
			// kill this so we don't double draw
			mPath.reset();
		}

		@Override
		public boolean onTouchEvent(MotionEvent event)
		{
			float x = event.getX();
			float y = event.getY();

			switch (event.getAction())
			{
				case MotionEvent.ACTION_DOWN:
					touch_start(x,y);
					invalidate();
					break;
				case MotionEvent.ACTION_MOVE:
					touch_move(x,y);
					invalidate();
					break;
				case MotionEvent.ACTION_UP:
					touch_up();
					invalidate();
					break;
			}
			return true;
		}

        // @Override
        // public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when)
        // {
        //     super.draw(canvas, mapView, shadow);

        //     // convert point to pixels
        //     Point screePts = new Point();
        //     mapView.getProjection().toPixels(pointToDraw, screePts);
        //     Bitmap bmp = BitmapFactory.decodeResource(getResource(), R.drawable.marker);
        //     canvas.drawBitmap(bmp, screePts.x, screePts.y-24, null); 
        //     return true;

        // }

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
}