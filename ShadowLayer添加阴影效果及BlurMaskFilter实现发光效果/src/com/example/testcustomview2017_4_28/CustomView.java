package com.example.testcustomview2017_4_28;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View{

	private Paint mPaint;
	
	public CustomView(Context context) {
		this(context,null);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		setLayerType(LAYER_TYPE_SOFTWARE, null);
		mPaint=new Paint();
		mPaint.setColor(Color.RED);
		mPaint.setAntiAlias(true);
		mPaint.setTextSize(35);
		
	}

    @SuppressLint("DrawAllocation") @Override
    protected void onDraw(Canvas canvas) {
    	
    	canvas.drawCircle(100,100,50, mPaint);
    	mPaint.setMaskFilter(new BlurMaskFilter(50,Blur.INNER));//Blur.INNER——内发光
    	canvas.drawCircle(100,220,50, mPaint);
    	mPaint.setMaskFilter(new BlurMaskFilter(50,Blur.SOLID));//Blur.SOLID——外发光
    	canvas.drawCircle(100,340,50, mPaint);
    	mPaint.setMaskFilter(new BlurMaskFilter(50,Blur.NORMAL));//Blur.NORMAL——内外发光
    	canvas.drawCircle(100,460,50, mPaint);
    	mPaint.setMaskFilter(new BlurMaskFilter(50,Blur.OUTER));//Blur.OUTER——仅显示发光效果
    	canvas.drawCircle(100,580,50, mPaint);
    	
    	mPaint.setMaskFilter(null);
    	canvas.drawText("正常效果",200,100, mPaint);
    	canvas.drawText("Blur.INNER——内发光",200,220, mPaint);
    	canvas.drawText("Blur.SOLID——外发光",200,340, mPaint);
    	canvas.drawText("Blur.NORMAL——内外发光",200,460, mPaint);
    	canvas.drawText("Blur.OUTER——仅显示发光效果",200,580, mPaint);
    }
}
