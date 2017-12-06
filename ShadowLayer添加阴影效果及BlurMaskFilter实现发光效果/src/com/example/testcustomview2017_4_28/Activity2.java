package com.example.testcustomview2017_4_28;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class Activity2 extends Activity implements OnClickListener{
	
	private Button radius_btn,dx_btn,dy_btn,show_btn,clear_btn;
	private ShadowLayerView slv;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.activity2);
	
	slv=(ShadowLayerView) findViewById(R.id.slv);
	radius_btn=(Button) findViewById(R.id.radius_btn);
	dx_btn=(Button) findViewById(R.id.dx_btn);
	dy_btn=(Button) findViewById(R.id.dy_btn);
	show_btn=(Button) findViewById(R.id.show_btn);
	clear_btn=(Button) findViewById(R.id.clear_btn);
	radius_btn.setOnClickListener(this);
	dx_btn.setOnClickListener(this);
	dy_btn.setOnClickListener(this);
	show_btn.setOnClickListener(this);
	clear_btn.setOnClickListener(this);
	
}
@Override
public void onClick(View v) {
	
	switch (v.getId()) {
	case R.id.radius_btn:
		slv.changeRadius();
		break;
case R.id.dx_btn:
		slv.changeDx();
		break;
case R.id.dy_btn:
	slv.changeDy();
	break;
case R.id.show_btn:
	slv.showShadow();
	break;
case R.id.clear_btn:
	slv.clearShadow();
	break;
	default:
		break;
	}
	
}
}
