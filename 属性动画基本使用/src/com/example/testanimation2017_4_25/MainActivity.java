package com.example.testanimation2017_4_25;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn1,btn2;
	private TextView tv1,tv2;
	
    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        btn1=(Button) findViewById(R.id.btn1);
        tv1=(TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Toast.makeText(MainActivity.this,tv1.getText().toString(),0).show();
				
			}
		});
        
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				TranslateAnimation animation=new TranslateAnimation
			(Animation.ABSOLUTE,0,Animation.ABSOLUTE,400,Animation.ABSOLUTE,0,Animation.ABSOLUTE,400);
				animation.setFillAfter(true);
				animation.setDuration(1000);
				tv1.startAnimation(animation);
				
			}
		});
        
        btn2=(Button) findViewById(R.id.btn2);
        tv2=(TextView) findViewById(R.id.tv2);
        tv2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Toast.makeText(MainActivity.this,tv2.getText().toString(),0).show();
				
			}
		});
        
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				doAnimation(); 
			}
		});
        
    }
    
    @SuppressLint("NewApi") private void doAnimation(){
    	
    	 ValueAnimator animator=ValueAnimator.ofInt(0,800,0,800,0,500);
         animator.setDuration(5000);
         animator.addUpdateListener(new AnimatorUpdateListener() {
 			
 			@Override
 			public void onAnimationUpdate(ValueAnimator arg0) {
 				        //监听动画变化时的实时值 
 				
 				int curValue=(Integer) arg0.getAnimatedValue();
 				//tv2.layout(curValue, curValue,curValue+tv2.getWidth(), curValue+tv2.getHeight());
 				tv2.layout(0, curValue,0+tv2.getWidth(), curValue+tv2.getHeight());
 				
 			}
 		});
         animator.start();
    	animator.addListener(new AnimatorListener() {
    		//监听动画变化时四个状态
			@Override
			public void onAnimationStart(Animator arg0) {
			Toast.makeText(MainActivity.this,"动画开始", 0).show();	
			}
			
			@Override
			public void onAnimationRepeat(Animator arg0) {
				Toast.makeText(MainActivity.this,"动画重复", 0).show();	
			}
			
			@Override
			public void onAnimationEnd(Animator arg0) {
				Toast.makeText(MainActivity.this,"动画结束", 0).show();	
			}
			
			@Override
			public void onAnimationCancel(Animator arg0) {
				Toast.makeText(MainActivity.this,"动画取消", 0).show();	
			}
		});
    }
    
}
