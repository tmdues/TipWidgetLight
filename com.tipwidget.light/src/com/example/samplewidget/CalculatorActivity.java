package com.example.samplewidget;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends Activity {
	String r1 = "";
	String r2 = "";
	String resultOnSubmit ="";
	Boolean plus_clicked = false;
	Boolean minus_clicked = false;
	Boolean divide_clicked = false;
	Boolean multiply_clicked = false;
	Boolean equal_clicked = false;
	Boolean first_pass = true;
	Boolean onStart = false;
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.calculatoractivity);
	
	final TextView results = (TextView) findViewById(R.id.results);
	Button zero = (Button) findViewById(R.id.btn_0);
	Button one = (Button) findViewById(R.id.btn_1);
	Button two = (Button) findViewById(R.id.btn_2);
	Button three = (Button) findViewById(R.id.btn_3);
	Button four = (Button) findViewById(R.id.btn_4);
	Button five = (Button) findViewById(R.id.btn_5);
	Button six = (Button) findViewById(R.id.btn_6);
	Button seven = (Button) findViewById(R.id.btn_7);
	Button eight = (Button) findViewById(R.id.btn_8);
	Button nine = (Button) findViewById(R.id.btn_9);
	Button pM = (Button) findViewById(R.id.btn_pm);
	Button clear = (Button) findViewById(R.id.btn_clear);
	Button back = (Button) findViewById(R.id.btn_back);
	Button dot = (Button) findViewById(R.id.btn_dot);
	Button divide = (Button) findViewById(R.id.btn_divide);
	Button multiply = (Button) findViewById(R.id.btn_multiply);
	Button plus = (Button) findViewById(R.id.btn_plus);
	Button minus = (Button) findViewById(R.id.btn_minus);
	Button equal = (Button) findViewById(R.id.btn_equal);
	Button close = (Button) findViewById(R.id.btn_close);
	Button update = (Button) findViewById(R.id.btn_update);
	String current = TipWidgetProvider.amount_string.substring(1, TipWidgetProvider.amount_string.length());
	onStart = true;
	if (TipWidgetProvider.amount_string=="$0.00"){
		results.setText("0");
	}
	else{
		results.setText(current);
	}
	pM.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			results.setText(ChangeSign(results.getText().toString()));
		}
		});
	clear.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			results.setText("0");
			Clear();
		}
		});
	back.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (results.getText().toString().length() == 0){
				results.setText("0");
			}
			else if (results.getText().toString().length() == 1){
				results.setText("0");
				}			
			else {	
				results.setText((results.getText().toString().substring(0, results.getText().toString().length()-1)));
			}
		}
		});
	plus.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (plus_clicked == true){
				if (r1==""){
					r1 = results.getText().toString();
				}
				else {
					r2 = results.getText().toString();	
					calculator(r1,r2);
					results.setText(r1);
				}
			}
			else {
				if (r1 != ""){
					r2 = results.getText().toString();	
					if(minus_clicked == true || divide_clicked == true || multiply_clicked == true){
						calculator(r1,r2);
						results.setText(r1);
					}
				}
				else{
				r1 = results.getText().toString();
				}
			}
			resetBools();
			plus_clicked = true;
		}
		});
	minus.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (minus_clicked == true){
				if (r1==""){
					r1 = results.getText().toString();
				}
				else {
					r2 = results.getText().toString();	
					calculator(r1,r2);
					results.setText(r1);
				}
			}
			else {
				if (r1 != ""){
					r2 = results.getText().toString();	
					if(plus_clicked == true || divide_clicked == true || multiply_clicked == true){
						calculator(r1,r2);
						results.setText(r1);
					}
				}
				else{
				r1 = results.getText().toString();
				}
			}
			resetBools();
			minus_clicked = true;
		}
		});
	divide.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (divide_clicked == true){
				if (r1==""){
					r1 = results.getText().toString();
				}
				else {
					r2 = results.getText().toString();	
					calculator(r1,r2);
					results.setText(r1);
				}
			}
			else {
				if (r1 != ""){
					r2 = results.getText().toString();	
					if(plus_clicked == true || minus_clicked == true || multiply_clicked == true){
						calculator(r1,r2);
						results.setText(r1);
					}
				}
				else{
				r1 = results.getText().toString();
				}
			}
			resetBools();
			divide_clicked = true;
		}
		});
	multiply.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (multiply_clicked == true){
				if (r1==""){
					r1 = results.getText().toString();
				}
				else {
					r2 = results.getText().toString();	
					calculator(r1,r2);
					results.setText(r1);
				}
			}
			else {
				if (r1 != ""){
					r2 = results.getText().toString();	
					if(plus_clicked == true || minus_clicked == true || divide_clicked == true){
						calculator(r1,r2);
						results.setText(r1);
					}
				}
				else{
				r1 = results.getText().toString();
				}
			}
			resetBools();
			multiply_clicked = true;
		}
		});
	zero.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (results.getText().toString().contains(".")){
				if (results.getText().toString().indexOf(".") + 2 >= results.getText().toString().length()){
			results.setText(results.getText().toString()+"0");	
				}
			}
		}
		});
	dot.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (!results.getText().toString().contains(".")){
			
			results.setText(results.getText().toString() + ".");
			
			}
		}
		});
	one.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {			
			
			if (onStart == true){
				onStart = false;
				Clear();
				results.setText("0");
			}
			results.setText(numberClick(results.getText().toString(),"1"));	
		}
		});
	two.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (onStart == true){
				onStart = false;
				Clear();
				results.setText("0");
			}
			
			results.setText(numberClick(results.getText().toString(),"2"));	
			
		}
		});
	three.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (onStart == true){
				onStart = false;
				Clear();
				results.setText("0");
			}
			
			results.setText(numberClick(results.getText().toString(),"3"));	
			
		}
		});
	four.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (onStart == true){
				onStart = false;
				Clear();
				results.setText("0");
			}
			
			results.setText(numberClick(results.getText().toString(),"4"));	
			
		}
		});
	five.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (onStart == true){
				onStart = false;
				Clear();
				results.setText("0");
			}
			
			results.setText(numberClick(results.getText().toString(),"5"));	
			
		}
		});
	six.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (onStart == true){
				onStart = false;
				Clear();
				results.setText("0");
			}
			
			results.setText(numberClick(results.getText().toString(),"6"));	
			
		}
		});
	seven.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (onStart == true){
				onStart = false;
				Clear();
				results.setText("0");
			}
			
			results.setText(numberClick(results.getText().toString(),"7"));	
			
		}
		});
	eight.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (onStart == true){
				onStart = false;
				Clear();
				results.setText("0");
			}
			
			results.setText(numberClick(results.getText().toString(),"8"));	
			
		}
		});
	nine.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (onStart == true){
				onStart = false;
				Clear();
				results.setText("0");
			}
			
			results.setText(numberClick(results.getText().toString(),"9"));	
			
		}
		});
	close.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			finish();
		}
		});
	update.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
            
			Intent i = new Intent(CalculatorActivity.this, TipWidgetProvider.class);
            i.setAction(TipWidgetProvider.UPDATE_AMOUNT_WIDGET);
            i.putExtra("amount", "$" + String.format("%.2f", Double.parseDouble(results.getText().toString())));
        //    Log.e("t",String.valueOf(Double.parseDouble(formatResult(results.getText().toString(),2))));
            sendBroadcast(i); 
			finish();
		}
		});
	equal.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			if (equal_clicked == false){
				resultOnSubmit = results.getText().toString();
			}
			else {
				r2 = results.getText().toString();
			}
			
			
			
			
			
			
			equal_clicked = true;
			if (r1 != "" & resultOnSubmit != ""){
			results.setText(calculator(r1,resultOnSubmit));
			}

		}
		});
	}
	
	public String calculator(String res1, String res2){
		String answer = "";
		Log.e("res1",res1);
		Log.e("res2",res2);
		Log.e("answer",answer);
		if (equal_clicked = true){
			if (plus_clicked == true){
				answer = String.valueOf(Double.parseDouble(res1) + Double.parseDouble(res2));
				r1 = answer;
				r2 = "";
			}
			else if (minus_clicked == true){
				answer = String.valueOf(Double.parseDouble(res1) - Double.parseDouble(res2));
				r1 = answer;
				r2 = "";
			}
			else if (divide_clicked == true){
				double t = Double.parseDouble(res1) / Double.parseDouble(res2);
				if (String.valueOf(t).contains("."))
				{
					if (String.valueOf(t).substring(String.valueOf(t).indexOf("."), String.valueOf(t).length()).length() >= 2)
					{
						answer = String.format("%.2f", t);
						r1 = answer;
						r2 = "";
					}
					else if (String.valueOf(t).substring(String.valueOf(t).indexOf("."), String.valueOf(t).length()).length() >= 1){
						answer = String.format("%.1f", t);
						r1 = answer;
						r2 = "";
					}
					else {
						answer = String.valueOf(t);
						r1 = answer;
						r2 = "";
					}
				}
				


			}
			else if (multiply_clicked == true){
				double t = Double.parseDouble(res1) * Double.parseDouble(res2);
				if (String.valueOf(t).contains("."))
				{
					if (String.valueOf(t).substring(String.valueOf(t).indexOf("."), String.valueOf(t).length()).length() >= 2)
					{
						answer = String.format("%.2f", t);
						r1 = answer;
						r2 = "";
					}
					else if (String.valueOf(t).substring(String.valueOf(t).indexOf("."), String.valueOf(t).length()).length() >= 1){
						answer = String.format("%.1f", t);
						r1 = answer;
						r2 = "";
					}
					else {
						answer = String.valueOf(t);
						r1 = answer;
						r2 = "";
					}
				}
			}
		}
		else{
					Log.e("res1",res1);
			Log.e("res2",res2);
			Log.e("answer",answer);
			if (plus_clicked == true){
				answer = String.valueOf(Double.parseDouble(res1) + Double.parseDouble(res2));
				r1 = answer;
				r2 = "";				
			}
			else if (minus_clicked == true){
				
			}
			else if (divide_clicked == true){
				
			}
			else if (multiply_clicked == true){
				
			}
		}
		Log.e("res1",res1);
		Log.e("res2",res2);
		Log.e("answer",answer);
		return formatResult(answer,2);
	}
	
	public String numberClick(String results, String num){
		if (equal_clicked == true){
			Clear();
		}
		if (plus_clicked == false & minus_clicked == false & divide_clicked == false & multiply_clicked == false){
				
			if (results == "0"){
			results = num;
			}
			else if (results == TipWidgetProvider.amount_string.substring(1, TipWidgetProvider.amount_string.length())){
				results = num;
			}
			else{
				results = results + num;
			}
		}
		else if (first_pass == true){
			first_pass = false;
			results = num;
		}
		else {
			results = results + num;
		}
			
		return formatResult(results,2);
	}
	public String ChangeSign(String results){
		results = String.valueOf(Double.parseDouble(results)* -1);
		return results;
	}
	void resetBools(){
		plus_clicked = false;
		minus_clicked = false;
		divide_clicked = false;
		multiply_clicked = false;
		equal_clicked = false;
		first_pass = true;
	}
	void Clear(){
		r1 = "";
		r2 = "";
		resultOnSubmit = "";
		resetBools();
	}
	final public static String formatResult(String result,int d){
		if (d==4){
		DecimalFormat dec = new DecimalFormat("#.####");
		result=String.valueOf(dec.format(Double.parseDouble(result)));
		}
		if (d==2){
			DecimalFormat dec = new DecimalFormat("#.##");
			result=String.valueOf(dec.format(Double.parseDouble(result)));
//			if (result.contains(".00") == true){
//				result = String.format("%.2f", Double.parseDouble(result));
//			}
//			else if (result.contains(".0") == true){
//				result = String.format("%.1f", Double.parseDouble(result));
//			}
//			else {
//			result=String.valueOf(dec.format(Double.parseDouble(result)));		
//			}
		}
		if (d==-1){
			DecimalFormat dec = new DecimalFormat("#.0");
			result=String.valueOf(dec.format(Double.parseDouble(result)));				
		}
		return result;
		}
}
