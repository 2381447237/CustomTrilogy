package com.example.testcustomview2017_5_2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class DoubleColorRadialGradientView extends View{

    private Paint mPaint;
	private RadialGradient mRadialGradient;
	private int mRadius=100;
    
	public DoubleColorRadialGradientView(Context context) {
		super(context);
		init();
	}

	public DoubleColorRadialGradientView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	@SuppressLint("NewApi") private void init(){
		setLayerType(LAYER_TYPE_SOFTWARE, null);
		mPaint=new Paint();
		mPaint.setAntiAlias(true);
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		//（1）、两色渐变构造函数使用实例
		//mRadialGradient=new RadialGradient(w/2,h/2, mRadius,0xffff0000,0xff00ff00,Shader.TileMode.REPEAT);
		
		//（2）、多色渐变构造函数使用实例
		//int [] colors=new int []{0xffff0000,0xff00ff00,0xff0000ff,0xffffff00};
		//float [] stops=new float[]{0f,0.2f,0.5f,1f};
		//mRadialGradient=new RadialGradient(w/2,h/2, mRadius, colors,stops,Shader.TileMode.REPEAT);
		//mPaint.setShader(mRadialGradient);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.drawCircle(getWidth()/2,getHeight()/2, mRadius, mPaint);
	}
	
}
