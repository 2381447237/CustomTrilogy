package com.example.testcustomview2017_4_28;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Activity3 extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity3);
	}
	
}
