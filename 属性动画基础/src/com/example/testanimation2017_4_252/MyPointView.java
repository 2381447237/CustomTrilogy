package com.example.testanimation2017_4_252;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyPointView extends View{

	private Point mPoint=new Point(50);
	private Paint mPaint;
	
	public MyPointView(Context context) {
		this(context,null);
	}

	public MyPointView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		if(mPoint!=null){
			mPaint=new Paint();
		}
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
	
		mPaint.setAntiAlias(true);
		mPaint.setColor(Color.RED);
		mPaint.setStyle(Paint.Style.FILL);
		canvas.drawCircle(getWidth()/2,100,mPoint.getmRadius(), mPaint);
		
	}
	
	public void setPointRadius(int radius){
		mPoint.setmRadius(radius);
		invalidate();
	}
	
}
