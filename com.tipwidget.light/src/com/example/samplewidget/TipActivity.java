package com.example.samplewidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TipActivity extends Activity{
	
	public static int i = 0;
	String cStringTip = "";
	int cTip = 0;
	
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tipactivity);
	
	final TextView current_tip = (TextView) findViewById(R.id.tv_current_tip);
	Button up = (Button) findViewById(R.id.btn_up);
	Button down = (Button) findViewById(R.id.btn_down);		
	Button cancel = (Button) findViewById(R.id.btn_cancel);		
	Button save = (Button) findViewById(R.id.btn_save);	
	current_tip.setText(TipWidgetProvider.tip_string);
	cStringTip = current_tip.getText().toString();
	up.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			cTip =  Integer.parseInt(cStringTip.substring(0, cStringTip.length()-1));
			if (cTip < 100){
			cTip = cTip + 1;
			}
			current_tip.setText(cTip + "%");
			cStringTip = current_tip.getText().toString();
		}
		});
	down.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			cTip =  Integer.parseInt(cStringTip.substring(0, cStringTip.length()-1));
			if (cTip >= 1){
			cTip = cTip - 1;
			}
			current_tip.setText(cTip + "%");
			cStringTip = current_tip.getText().toString();
		}
		});
	cancel.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			finish();
		}
		});
	save.setOnClickListener(new OnClickListener() {
		public void onClick(View v) { 	
                Intent i = new Intent(TipActivity.this, TipWidgetProvider.class);
                i.setAction(TipWidgetProvider.UPDATE_TIP_WIDGET);
                i.putExtra("new_tip", cStringTip);
                sendBroadcast(i); 
			finish();
		}
		});
} 
}
