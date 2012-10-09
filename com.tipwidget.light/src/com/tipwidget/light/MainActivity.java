package com.tipwidget.light;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Calling the Dialogs...
		TipActivity();
		SplitActivity();
		CalculatorActivity();
	}

	public void CalculatorActivity() {

		if (getIntent().getAction().equals(
				LightTipWidgetProvider.AMOUNT_WIDGET_RECEIVER)) {
			Intent i = new Intent(this, CalculatorActivity.class);
			startActivity(i);
			finish();

		}
	}

	public void TipActivity() {

		if (getIntent().getAction().equals(
				LightTipWidgetProvider.TIP_WIDGET_RECEIVER)) {
			Intent i = new Intent(this, TipActivity.class);
			startActivity(i);
			finish();

		}
	}

	public void SplitActivity() {

		if (getIntent().getAction().equals(
				LightTipWidgetProvider.SPLIT_WIDGET_RECEIVER)) {
			Intent i = new Intent(this, SplitActivity.class);
			startActivity(i);
			finish();

		}
	}

}
