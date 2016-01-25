package com.mycatisnot.circlessqares;

import android.app.Activity;
import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class YOUR_Drawing extends Activity implements View.OnTouchListener {

	private String colorCode;
	private int shape;
	private ImageView image;
	private Bitmap bitmap;
	private Canvas canvas;
	private Paint paint;
	int xbegin, xend, ybegin, yend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_your_drawing);
		image = (ImageView) findViewById(R.id.imageView);

		colorCode = getIntent().getStringExtra("color");
		shape = getIntent().getIntExtra("shape", -1);
		System.out.print("Color: " + colorCode + " Shape: " + shape + "\n");

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		System.out.print("W" + width + " H" + height + "\n");

		bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		canvas = new Canvas(bitmap);
		paint = new Paint();
		paint.setColor(Color.parseColor("#" + colorCode));
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		paint.setStrokeCap(Paint.Cap.ROUND);
		image.setImageBitmap(bitmap);

		image.setOnTouchListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.your__drawing, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_back) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int action = event.getAction();
		switch (action) {
			case MotionEvent.ACTION_DOWN:
				xbegin = (int) event.getX();
				ybegin = (int) event.getY();
				paint.setStrokeWidth(0);
				drawInstance(xbegin, ybegin);
				break;
			case MotionEvent.ACTION_MOVE:
				drawInstance(xend, yend);
				xend = (int) event.getX();
				yend = (int) event.getY();
				paint.setStrokeWidth(60);
				canvas.drawLine(xbegin, ybegin, xend + 10, yend + 10, paint);
				paint.setStrokeWidth(0);
				drawInstance(xend, yend);
				xbegin = xend;
				ybegin = yend;



				break;
			case MotionEvent.ACTION_UP:
				xend = (int) event.getX();
				yend = (int) event.getY();
				paint.setStrokeWidth(0);
				drawInstance(xend, yend);


				break;
		}
		image.invalidate();
		return true;
	}

//	private void drawMultiple (int xstart, int xend, int ystart, int yend) {
//		int x = xend - xstart, y = yend - ystart;
//		float xstep = x / 50, ystep = y / 50, distance = Math.abs(x) + Math.abs(y);
//		for (int i = 1; distance > 0; i++, distance -= xstep + ystep) {
//			drawInstance((float)xstart + (xstep * i), (float)ystart + (ystep * i));
//			System.out.print(xstart + " : " + ystart);
//
//		}
//	}

	private void drawInstance(float x, float y) {
		switch (shape) {
			case 0:
				canvas.drawCircle(x, y, 30, paint);
				break;
			case 1:
				canvas.drawRect(x, y, 50 + x, 50 + y, paint);
				break;
			case 2:
				canvas.drawLine(x, y, 50 + x, 50 + y, paint);
				break;
		}
	}

}
