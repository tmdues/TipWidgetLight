package com.example.samplewidget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	
	//Calling the Dialogs...
	TipActivity();
	SplitActivity();
	CalculatorActivity();
	}
//	public void TipDialog() {
//
//		if (getIntent().getAction().equals(SampleWidgetProvider.TIP_WIDGET_RECEIVER)) {
//			
//			 //set up dialog
//			final Dialog dialog = new Dialog(MainActivity.this);
//			dialog.setContentView(R.layout.tipactivity);
//			dialog.setTitle("Enter Tip:");
//			dialog.setCancelable(true);
//			dialog.show();
//			final TextView current_tip = (TextView) dialog.findViewById(R.id.tv_current_tip);
//			Button up = (Button) dialog.findViewById(R.id.btn_up);
//			Button down = (Button) dialog.findViewById(R.id.btn_down);		
//			Button cancel = (Button) dialog.findViewById(R.id.btn_cancel);		
//			Button save = (Button) dialog.findViewById(R.id.btn_save);	
//			current_tip.setText(SampleWidgetProvider.tip_string);
//			cStringTip = current_tip.getText().toString();
//			up.setOnClickListener(new OnClickListener() {
//				public void onClick(View v) {
//					cTip =  Integer.parseInt(cStringTip.substring(0, cStringTip.length()-1));
//					cTip = cTip + 1;
//					current_tip.setText(cTip + "%");
//					cStringTip = current_tip.getText().toString();
//				}
//				});
//			down.setOnClickListener(new OnClickListener() {
//				public void onClick(View v) {
//					cTip =  Integer.parseInt(cStringTip.substring(0, cStringTip.length()-1));
//					cTip = cTip - 1;
//					current_tip.setText(cTip + "%");
//					cStringTip = current_tip.getText().toString();
//				}
//				});
//			cancel.setOnClickListener(new OnClickListener() {
//				public void onClick(View v) {
//					dialog.cancel();
//					finish();
//				}
//				});
//			save.setOnClickListener(new OnClickListener() {
//				public void onClick(View v) { 	
//		                Intent i = new Intent(dialog.getContext(), SampleWidgetProvider.class); 
//		                i.setAction(SampleWidgetProvider.UPDATE_TIP_WIDGET);
//		                i.putExtra("new_tip", cStringTip);
//		                sendBroadcast(i); 
//					dialog.cancel();
//					finish();
//				}
//				});
//		} 
//	}
//	
//	
//	public void SplitDialog() {
//
//		if (getIntent().getAction().equals(SampleWidgetProvider.SPLIT_WIDGET_RECEIVER)) {
//			
//			 //set up dialog
//			final Dialog dialog = new Dialog(MainActivity.this);
//			dialog.setContentView(R.layout.splitactivity);
//			dialog.setTitle("# of people splitting bill:");
//			dialog.setCancelable(true);
//			dialog.show();
//			final TextView current_split = (TextView) dialog.findViewById(R.id.tv_current_split);
//			Button up = (Button) dialog.findViewById(R.id.btn_up);
//			Button down = (Button) dialog.findViewById(R.id.btn_down);		
//			Button cancel = (Button) dialog.findViewById(R.id.btn_cancel);		
//			Button save = (Button) dialog.findViewById(R.id.btn_save);
//			current_split.setText(SampleWidgetProvider.split_string);
//			cStringSplit = current_split.getText().toString();
//			up.setOnClickListener(new OnClickListener() {
//				public void onClick(View v) {
//					cSplit =  Integer.parseInt(cStringSplit);
//					cSplit = cSplit + 1;
//					current_split.setText(String.valueOf(cSplit));
//					cStringSplit = current_split.getText().toString();
//				}
//				});
//			down.setOnClickListener(new OnClickListener() {
//				public void onClick(View v) {
//					cSplit =  Integer.parseInt(cStringSplit);
//					cSplit = cSplit - 1;
//					current_split.setText(String.valueOf(cSplit));
//					cStringSplit = current_split.getText().toString();
//				}
//				});
//			cancel.setOnClickListener(new OnClickListener() {
//				public void onClick(View v) {
//					finish();
//				}
//				});
//			save.setOnClickListener(new OnClickListener() {
//				public void onClick(View v) { 	
//						Log.e("MainSplit", cStringSplit);
//		                Intent i = new Intent(dialog.getContext(), SampleWidgetProvider.class); 
//		                i.setAction(SampleWidgetProvider.UPDATE_SPLIT_WIDGET);
//		                i.putExtra("new_split", cStringSplit);
//		                sendBroadcast(i); 
//					dialog.cancel();
//					finish();
//				}
//				});
//		} 
//	}
	
	
	public void CalculatorActivity() {

		if (getIntent().getAction().equals(TipWidgetProvider.AMOUNT_WIDGET_RECEIVER)) {
            Intent i = new Intent(this, CalculatorActivity.class); 
            startActivity(i);
            finish();
		
		} 
	}
	public void TipActivity() {

		if (getIntent().getAction().equals(TipWidgetProvider.TIP_WIDGET_RECEIVER)) {
            Intent i = new Intent(this, TipActivity.class); 
            startActivity(i);
            finish();
		
		} 
	}
	public void SplitActivity() {

		if (getIntent().getAction().equals(TipWidgetProvider.SPLIT_WIDGET_RECEIVER)) {
            Intent i = new Intent(this, SplitActivity.class); 
            startActivity(i);
            finish();
		
		} 
	}
	
	
}


