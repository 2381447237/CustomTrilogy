package com.example.testcustomview2017_4_28;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ShadowLayerView extends View{
	
	private boolean mSetShadow=true;
	private Paint mPaint;
	private Bitmap mBmp;
	private int mRadius=1,mDx=10,mDy=10;
	public ShadowLayerView(Context context) {
		this(context,null);
	}

	@SuppressLint("NewApi") public ShadowLayerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		setLayerType(LAYER_TYPE_SOFTWARE, null);//禁用硬件加速
		mPaint=new Paint();
		mPaint.setColor(Color.GREEN);
		mPaint.setTextSize(25);
		//mPaint.setShadowLayer(1,10,10,Color.GRAY);//阴影的颜色
		
		mBmp=BitmapFactory.decodeResource(getResources(), R.drawable.tangyan);
	}

     @Override
    protected void onDraw(Canvas canvas) {
    	 
    	// 从效果图中可以明显看到各个参数的区别，但正是通过效果图，我们可以明显得看出两个结论：
    	// 1、图片的阴影是不受阴影画笔颜色影响的，它是一张图片的副本；
    	 //2、无论是图片还是图形，模糊时，仅模糊边界部分，随着模糊半径的增大，向内、向外延伸；
    	 //其实很好理解这个问题：由于模糊半径的增大，高斯模糊向周边取值的范围在增大，所以向内、向外延伸的距离就会更大
    	 if(mSetShadow){
    	 mPaint.setShadowLayer(mRadius, mDx, mDy, Color.GRAY);
    	 }else{
    		 //清除ShadowLayer阴影
    		 mPaint.clearShadowLayer();
    	 }
    	canvas.drawText("测试", 50,100, mPaint);
    	canvas.drawCircle(50,200, 50, mPaint);
    	canvas.drawBitmap(mBmp, 50, 300, mPaint);
    }
     
     public void changeRadius(){
    	 mRadius+=5;
    	 invalidate();
     }
     
     public void changeDx(){
    	 mDx+=5;
    	 invalidate();
     }
     
     public void changeDy(){
    	 mDy+=5;
    	 invalidate();
     }
     
     public void clearShadow(){
    	 mSetShadow=false;
    	 invalidate();
     }
     
     public void showShadow(){
    	 mSetShadow=true;
    	 invalidate();
     }
}
