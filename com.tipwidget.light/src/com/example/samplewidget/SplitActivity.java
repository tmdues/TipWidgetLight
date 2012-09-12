package com.example.samplewidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SplitActivity extends Activity {
	
	public static int i = 0;
	String cStringSplit = "";
	int cSplit = 0;
	
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.splitactivity);
	
	final TextView current_split = (TextView) findViewById(R.id.tv_current_split);
	Button up = (Button) findViewById(R.id.btn_up);
	Button down = (Button) findViewById(R.id.btn_down);		
	Button cancel = (Button) findViewById(R.id.btn_cancel);		
	Button save = (Button) findViewById(R.id.btn_save);
	current_split.setText(TipWidgetProvider.split_string);
	cStringSplit = current_split.getText().toString();
	up.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			cSplit =  Integer.parseInt(cStringSplit);
			if (cSplit < 100){
			cSplit = cSplit + 1;
			}
			current_split.setText(String.valueOf(cSplit));
			cStringSplit = current_split.getText().toString();
		}
		});
	down.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			cSplit =  Integer.parseInt(cStringSplit);
			if (cSplit > 1){
			cSplit = cSplit - 1;
			}
			current_split.setText(String.valueOf(cSplit));
			cStringSplit = current_split.getText().toString();
		}
		});
	cancel.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			finish();
		}
		});
	save.setOnClickListener(new OnClickListener() {
		public void onClick(View v) { 	
				Log.e("MainSplit", cStringSplit);
                Intent i = new Intent(SplitActivity.this, TipWidgetProvider.class); 
                i.setAction(TipWidgetProvider.UPDATE_SPLIT_WIDGET);
                i.putExtra("new_split", cStringSplit);
                sendBroadcast(i); 
			finish();
		}
		});
	
	}
}