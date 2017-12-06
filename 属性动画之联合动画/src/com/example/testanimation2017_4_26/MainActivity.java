package com.example.testanimation2017_4_26;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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


//在AnimatorSet中直接给为我们提供了两个方法playSequentially和playTogether，
//playSequentially表示所有动画依次播放，playTogether表示所有动画一起开始
public class MainActivity extends Activity {

	private Button btn;
	private TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        tv1=(TextView) findViewById(R.id.tv_1);
        tv2=(TextView) findViewById(R.id.tv_2);
        
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				doPlaySequentiallyAnimator();
				
			}
		});
    }
    
    @SuppressLint("NewApi") private void doPlaySequentiallyAnimator(){
    	
    	ObjectAnimator tv1BgAnimator=ObjectAnimator.ofInt(tv1, "BackgroundColor",0xffff00ff, 0xffffff00, 0xffff00ff);
        //开始延迟1秒开始
    	//	tv1BgAnimator.setStartDelay(1000);
    	ObjectAnimator tv1TranslateY=ObjectAnimator.ofFloat(tv1, "translationY", 0, 300, 0);
    	//tv1TranslateY.setStartDelay(1000);
    	ObjectAnimator tv2TranslateY=ObjectAnimator.ofFloat(tv2, "translationY", 0, 400, 0);
    	//tv2TranslateY.setStartDelay(1000);
    	//设置无限循环
    	tv2TranslateY.setRepeatCount(ValueAnimator.INFINITE);
    	
    	AnimatorSet animatorSet=new AnimatorSet();
    	//playSequentially表示所有动画依次播放，playTogether表示所有动画一起开始
    	//animatorSet.playSequentially(tv1BgAnimator,tv1TranslateY,tv2TranslateY);
    	animatorSet.playTogether(tv1BgAnimator,tv1TranslateY,tv2TranslateY);
    	animatorSet.setDuration(3000);
    	animatorSet.start();
    }
    
}
