package com.example.testcustomview2017_5_2;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

public class RippleView extends Button{

	private int mX,mY;
	private ObjectAnimator mAnimator;
	private int DEFAULT_RADIUS=50;
	private int mCurRadius=0;
	private RadialGradient mRadialGradient;
	private Paint mPaint;
	
	public RippleView(Context context) {
		super(context);
		init();
	}
	
	public RippleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

    @SuppressLint("NewApi") private void init(){
    	
    	setLayerType(LAYER_TYPE_SOFTWARE, null);
    	mPaint=new Paint();
    }
	
    @SuppressLint("NewApi") @Override
    public boolean onTouchEvent(MotionEvent event) {
    	
    	if(mX!=event.getX()||mY!=mY){
    		mX=(int) event.getX();
    		mY=(int) event.getY();
    		
    		setRadius(DEFAULT_RADIUS);
    	}
    	
    	if(event.getAction()==MotionEvent.ACTION_DOWN){
    		return true;
    	}else if(event.getAction()==MotionEvent.ACTION_UP){
    		
    		if(mAnimator!=null&&mAnimator.isRunning()){
    			mAnimator.cancel();
    		}
    		
    		if(mAnimator==null){
    			mAnimator=ObjectAnimator.ofInt(this,"radius",DEFAULT_RADIUS,getWidth());
    		}
    		mAnimator.setInterpolator(new AccelerateInterpolator());
    		mAnimator.addListener(new AnimatorListener() {
				
				@Override
				public void onAnimationStart(Animator arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationRepeat(Animator arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationEnd(Animator arg0) {
					setRadius(0);
				}
				
				@Override
				public void onAnimationCancel(Animator arg0) {
					// TODO Auto-generated method stub
					
				}
			});
    		mAnimator.start();
    	}
    	
    	return super.onTouchEvent(event);
    }
    
    public void setRadius(int radius){
    	
    	mCurRadius=radius;
    	if(mCurRadius>0){
    		mRadialGradient=new RadialGradient(mX, mY, mCurRadius, 0x00ffffff,0xFF58FAAC,TileMode.CLAMP);
    		mPaint.setShader(mRadialGradient);
    	}
    	
    	postInvalidate();
    }
    
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawCircle(mX, mY, mCurRadius, mPaint);
	}
}
