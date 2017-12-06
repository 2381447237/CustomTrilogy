package com.example.testanimation2017_4_252;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi") public class MainActivity extends Activity {

	private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;
	private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
	private MyPointView mpv;
	ObjectAnimator animator;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        //1、要使用ObjectAnimator来构造对画，要操作的控件中，必须存在对应的属性的set方法 
        //2、setter 方法的命名必须以骆驼拼写法命名，即set后每个单词首字母大写，其余字母小写，即类似于setPropertyName所对应的属性为propertyName 
        btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				
				animator=ObjectAnimator.ofFloat(tv1,"alpha",1,0,1);
				animator.setDuration(3000);
				animator.start();
				
			}
		});
        
        tv1=(TextView) findViewById(R.id.tv1);
        
        btn2=(Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				
				animator.cancel();
				
			}
		});
        
        tv2=(TextView) findViewById(R.id.tv2);
        btn3=(Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				
				ObjectAnimator animator=ObjectAnimator.ofFloat(tv2,"rotation",0,180,0);
				animator.setDuration(1000);
				animator.start();
			}
		});
        tv3=(TextView) findViewById(R.id.tv3);
        btn4=(Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				
				ObjectAnimator animator=ObjectAnimator.ofFloat(tv3, "rotationX",0,270,0);
				animator.setDuration(1000);
				animator.start();
				
			}
		});
        
        tv4=(TextView) findViewById(R.id.tv4);
        btn5=(Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				
				ObjectAnimator animator=ObjectAnimator.ofFloat(tv4, "rotationY",0,180,0);
				animator.setDuration(1000);
				animator.start();
			}
		});
        
        tv5=(TextView) findViewById(R.id.tv5);
        btn6=(Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				
				ObjectAnimator animator=ObjectAnimator.ofFloat(tv5,"translationX",0,200,-200,0);
				animator.setDuration(1000);
				animator.start();
			}
		});
        
        tv6=(TextView) findViewById(R.id.tv6);
        btn7=(Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				ObjectAnimator animator=ObjectAnimator.ofFloat(tv6,"translationY",0,200,-100,0);
				animator.setDuration(1000);
				animator.start();
			}
		});
        tv7=(TextView) findViewById(R.id.tv7);
        btn8=(Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				ObjectAnimator animator=ObjectAnimator.ofFloat(tv7,"scaleX",0,3,1);
				animator.setDuration(1000);
				animator.start();
				
			}
		});
        tv8=(TextView) findViewById(R.id.tv8);
        btn9=(Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				ObjectAnimator animator=ObjectAnimator.ofFloat(tv8,"scaleY",0,3,1);
				animator.setDuration(1000);
				animator.start();
			}
		});
        tv9=(TextView) findViewById(R.id.tv9);
        btn11=(Button) findViewById(R.id.btn11);
        btn11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				ObjectAnimator animator=ObjectAnimator.ofInt(tv9, "BackgroundColor",0xffff00ff, 0xffffff00, 0xffff00ff);
				animator.setDuration(8000);
				animator.start();
				
			}
		});
        
        mpv=(MyPointView) findViewById(R.id.mpv);
        btn10=(Button) findViewById(R.id.btn10);
        btn10.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 doPointViewAnimation();  
			}
		});
    }
    
    private void doPointViewAnimation(){
    	
    	ObjectAnimator animator=ObjectAnimator.ofInt(mpv,"PointRadius",0,300,100);
    	animator.setDuration(1000);
    	animator.start();
    	
    }
    
}
