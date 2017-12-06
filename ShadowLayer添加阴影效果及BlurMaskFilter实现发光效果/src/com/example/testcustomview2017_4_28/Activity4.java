package com.example.testcustomview2017_4_28;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Activity4 extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity4);
	}
	
}
