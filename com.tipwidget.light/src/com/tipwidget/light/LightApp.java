package com.tipwidget.light;

import android.app.Application;
import android.content.Context;
import android.speech.tts.TextToSpeech.OnInitListener;

public class LightApp extends Application implements OnInitListener{

	public static Context appContext;
	
	   public void onCreate() {
	        super.onCreate();
	        appContext = this;
	    }

	/**
	 * @param args
	 */

	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	}
}
