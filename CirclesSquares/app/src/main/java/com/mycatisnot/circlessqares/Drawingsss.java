package com.mycatisnot.circlessqares;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class Drawingsss extends View {
	
	private Paint paint;
	private int shape, x, y;
	
	public Drawingsss(Context context, String color, int shape, int x, int y) {
		super(context);
		this.shape = shape;
		this.x = x;
		this.y = y;
		
		paint = new Paint();
		paint.setColor(Color.parseColor("#" + color));
		paint.setStyle(Style.FILL_AND_STROKE);
		
		//tool type
//		paint.setStyle(Paint.Style.FILL);
//		paint.setStyle(Paint.Style.STROKE);
//		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		
		//color
//		paint.setColor(Color.parseColor("#FF3030"));
//		paint.setColor(Color.rgb(0, 0, 0));
//		paint.setColor(Color.parseColor("#000000"));
		
	}
	

	@Override
	public void onDraw(Canvas canvas) {
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
