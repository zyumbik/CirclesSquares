package com.mycatisnot.circlessqares;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {

	Button draw;
	EditText color;
	RadioButton circle, square, line;
	String colorCode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		draw = (Button) findViewById(R.id.buttonDraw);
		color = (EditText) findViewById(R.id.editColor);
		circle = (RadioButton) findViewById(R.id.figureCircle);
		square = (RadioButton) findViewById(R.id.figureSquare);
		line = (RadioButton) findViewById(R.id.figureLine);
		
		draw.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				colorCode = color.getText().toString();
				
				int shape = -1;
				if (circle.isChecked()) {
					shape = 0;
				} else if (square.isChecked()) {
					shape = 1;
				} else {
					shape = 2;
				}

				Intent i = new Intent (v.getContext(), YOUR_Drawing.class);
				i.putExtra("color", colorCode);
				i.putExtra("shape", shape);
				startActivity(i);
				
//				Drawingsss drawactivity = new Drawingsss(this);
//				drawactivity.setBackgroundColor(Color.parseColor("#" + colorCode));
//				setContentView(drawactivity); 
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		return super.onOptionsItemSelected(item);
	}
}
