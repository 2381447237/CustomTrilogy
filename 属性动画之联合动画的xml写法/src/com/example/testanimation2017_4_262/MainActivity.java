package com.example.testanimation2017_4_262;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btn;
	private TextView tv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        tv=(TextView) findViewById(R.id.tv);
        
        btn=(Button) findViewById(R.id.btn);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				//doAnimator();
				//doObjectAnimator();
				//doObjectAnimator2();
				setAnimator();
			}
		});
    }
    
    private void doAnimator(){
    	
    	ValueAnimator valueAnimator=(ValueAnimator) AnimatorInflater.loadAnimator(this,R.animator.animator);

    	valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator arg0) {
				
				int offset=(Integer) arg0.getAnimatedValue();
				tv.layout(offset, offset, offset+tv.getWidth(), offset+tv.getHeight());
				
			}
		});
    	
    	valueAnimator.start();
    }
    
    private void doObjectAnimator(){
    	
    	ObjectAnimator animator=(ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.object_animator);
    	animator.setTarget(tv);
    	animator.start();
    }
    
    private void doObjectAnimator2(){
    	
    	ObjectAnimator animator=(ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.object_animator2);
    	animator.setTarget(tv);
    	animator.start();
    	
    }
    
   private void  setAnimator(){
	   
	   AnimatorSet set=(AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.set_animator);
	   set.setTarget(tv);
	   set.start();
	   
   }
}
