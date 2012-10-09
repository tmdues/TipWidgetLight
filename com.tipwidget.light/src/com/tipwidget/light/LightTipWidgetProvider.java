package com.tipwidget.light;

import com.tipwidget.light.LightApp;
import com.tipwidget.light.R;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class LightTipWidgetProvider extends AppWidgetProvider {

	public static String AMOUNT_WIDGET_RECEIVER = "AmountReceiverWidget";
	public static String TIP_WIDGET_RECEIVER = "TipReceiverWidget";	
	public static String SPLIT_WIDGET_RECEIVER = "SplitReceiverWidget";
	public static String UPDATE_AMOUNT_WIDGET = "UpdateAmountReceiver";
	public static String UPDATE_TIP_WIDGET = "UpdateTipReceiver";	
	public static String UPDATE_SPLIT_WIDGET = "UpdateSplitReceiver";
	public static String tip_string = "15%";
	public static String split_string = "1";
	public static String amount_string = "$0.00";
	public static String total_string = "";
	public static String total_split_string = "";
	public static String totalTip_string = "";
	public static String totalTip_split_string = "";
	public RemoteViews views =  new RemoteViews(LightApp.appContext.getPackageName(), R.layout.light_widget);
	public static int i = 0;
	
	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		super.onEnabled(context);
		Log.e("LightWidget","Widget onEnabled");
	}
	
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
		Log.e("LightWidget","Widget onDeleted");
	}
	
	@Override
	public void onDisabled(Context context) {
		// TODO Auto-generated method stub
		super.onDisabled(context);
		Log.e("LightWidget","Widget onDisabled");
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
		Log.e("LightWidget","Widget onReceive");
		//Amount Action
		if (intent.getAction().equals(UPDATE_AMOUNT_WIDGET)) {
			String amount = "null";
			try {
				amount = intent.getStringExtra("amount");
			} catch (NullPointerException e) {
			Log.e("Error", "amount = null");
			}		
			views.setTextViewText(R.id.etv_amount, amount);
			try {
				amount_string = amount;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CalculateTotals();
	        views.setTextViewText(R.id.etv_total, total_string);
	        views.setTextViewText(R.id.etv_total_split, total_split_string);
	        views.setTextViewText(R.id.etv_tip_total, totalTip_string);
	        views.setTextViewText(R.id.etv_total_tip_split, totalTip_split_string);
			ComponentName widget = new ComponentName(context, LightTipWidgetProvider.class);
	        AppWidgetManager.getInstance(context).updateAppWidget(widget, views);
			Toast.makeText(context, amount, Toast.LENGTH_SHORT).show();
		}
		//Tip Action
		else if (intent.getAction().equals(UPDATE_TIP_WIDGET)) {
			String new_tip = "null";
			new_tip = intent.getStringExtra("new_tip");
			try {
			} catch (NullPointerException e) {
			Log.e("Error", "new_tip = null");
			}		
			views.setTextViewText(R.id.etv_tip, new_tip); 
			tip_string = new_tip;
			CalculateTotals();
	        views.setTextViewText(R.id.etv_total, total_string);
	        views.setTextViewText(R.id.etv_total_split, total_split_string);
	        views.setTextViewText(R.id.etv_tip_total, totalTip_string);
	        views.setTextViewText(R.id.etv_total_tip_split, totalTip_split_string);
			ComponentName widget = new ComponentName(context, LightTipWidgetProvider.class);
	        AppWidgetManager.getInstance(context).updateAppWidget(widget, views);
			Toast.makeText(context, new_tip, Toast.LENGTH_SHORT).show();
		}			
		//Split Action
		else if (intent.getAction().equals(UPDATE_SPLIT_WIDGET)) {
			String new_split = "null";
			new_split = intent.getStringExtra("new_split");
			try {
			} catch (NullPointerException e) {
			Log.e("Error", "new_split = null");
			}
			views.setTextViewText(R.id.etv_split, new_split); 
			split_string = new_split;
			CalculateTotals();
	        views.setTextViewText(R.id.etv_total, total_string);
	        views.setTextViewText(R.id.etv_total_split, total_split_string);
	        views.setTextViewText(R.id.etv_tip_total, totalTip_string);
	        views.setTextViewText(R.id.etv_total_tip_split, totalTip_split_string);
			ComponentName widget = new ComponentName(context, LightTipWidgetProvider.class);
	        AppWidgetManager.getInstance(context).updateAppWidget(widget, views);
			Toast.makeText(context, new_split, Toast.LENGTH_SHORT).show();
		}
		 else {
             super.onReceive(context, intent);
         }
	}
	private void CalculateTotals(){
		
		totalCalculation();
		
		total_splitCalculation();
		
		tipCalculation();
		tip_splitCalculation();
	}
	private void totalCalculation(){
		Double amount = Double.parseDouble(amount_string.substring(1, amount_string.length()));
		Double tip = Double.parseDouble(tip_string.substring(0, tip_string.length()-1));
		Double total = 0.0;
		try {
			total = (amount * (tip/100)) + amount;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		total_string = "$"+String.format("%.2f", total);
		
	}
	private void total_splitCalculation(){
		Double amount = Double.parseDouble(amount_string.substring(1, amount_string.length()));
		Double tip = Double.parseDouble(tip_string.substring(0, tip_string.length()-1));
		Double split = Double.parseDouble(split_string);
		Double total = 0.0;
		try {
			total = (amount * (tip/100)) + amount;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		total_split_string = "$"+String.format("%.2f", total/split);
		
	}
	private void tipCalculation(){
		Double amount = Double.parseDouble(amount_string.substring(1, amount_string.length()));
		Double tip = Double.parseDouble(tip_string.substring(0, tip_string.length()-1));
		tip  = amount * (tip/100);
		totalTip_string = "$" + String.format("%.2f", tip);
		
	}
	private void tip_splitCalculation(){
		Double amount = Double.parseDouble(amount_string.substring(1, amount_string.length()));
		Double tip = Double.parseDouble(tip_string.substring(0, tip_string.length()-1));
		Double split = Double.parseDouble(split_string);
		tip  = amount * (tip/100);
		split = tip / split;
		totalTip_split_string = "$"+String.format("%.2f", split);
		
	}
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		Log.e("LightWidget","Widget onUpdate");
		//Update tip
		views.setTextViewText(R.id.etv_tip, tip_string);
		//Update split
		views.setTextViewText(R.id.etv_split, split_string);
		//Update amount
		views.setTextViewText(R.id.etv_amount, amount_string);
		//Update total
		views.setTextViewText(R.id.etv_total, total_string);
		//Update total split
		views.setTextViewText(R.id.etv_total_split, total_split_string);
		//Update tip total
		views.setTextViewText(R.id.etv_tip_total, totalTip_string); 
		//Update total tip split
		views.setTextViewText(R.id.etv_total_tip_split, totalTip_split_string);		
		

		//Set Amount OnClickPendingIntent
		Intent amount = new Intent(context, MainActivity.class);
		amount.setAction(AMOUNT_WIDGET_RECEIVER);
		amount.putExtra("msg", "Message for Amount Click");
		PendingIntent amountPendingIntent = PendingIntent.getActivity(context, 0, amount, 0);
		views.setOnClickPendingIntent(R.id.etv_amount, amountPendingIntent);
		//Set Tip OnClickPendingIntent
		Intent tip = new Intent(context, MainActivity.class);
		tip.setAction(TIP_WIDGET_RECEIVER);
		PendingIntent tipPendingIntent = PendingIntent.getActivity(context, 0, tip, 0);
		views.setOnClickPendingIntent(R.id.etv_tip, tipPendingIntent);
		//Set Split OnClickPendingIntent
		Intent split = new Intent(context, MainActivity.class);
		split.setAction(SPLIT_WIDGET_RECEIVER);
		PendingIntent splitPendingIntent = PendingIntent.getActivity(context, 0, split, 0);
		views.setOnClickPendingIntent(R.id.etv_split, splitPendingIntent);
		//Set AppWidgetManager
		appWidgetManager.updateAppWidget(appWidgetIds, views);   

		
	}	
}