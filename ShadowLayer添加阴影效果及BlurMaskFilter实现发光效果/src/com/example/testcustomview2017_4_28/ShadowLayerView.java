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
		
		setLayerType(LAYER_TYPE_SOFTWARE, null);//����Ӳ������
		mPaint=new Paint();
		mPaint.setColor(Color.GREEN);
		mPaint.setTextSize(25);
		//mPaint.setShadowLayer(1,10,10,Color.GRAY);//��Ӱ����ɫ
		
		mBmp=BitmapFactory.decodeResource(getResources(), R.drawable.tangyan);
	}

     @Override
    protected void onDraw(Canvas canvas) {
    	 
    	// ��Ч��ͼ�п������Կ����������������𣬵�����ͨ��Ч��ͼ�����ǿ������Եÿ����������ۣ�
    	// 1��ͼƬ����Ӱ�ǲ�����Ӱ������ɫӰ��ģ�����һ��ͼƬ�ĸ�����
    	 //2��������ͼƬ����ͼ�Σ�ģ��ʱ����ģ���߽粿�֣�����ģ���뾶���������ڡ��������죻
    	 //��ʵ�ܺ����������⣺����ģ���뾶�����󣬸�˹ģ�����ܱ�ȡֵ�ķ�Χ�������������ڡ���������ľ���ͻ����
    	 if(mSetShadow){
    	 mPaint.setShadowLayer(mRadius, mDx, mDy, Color.GRAY);
    	 }else{
    		 //���ShadowLayer��Ӱ
    		 mPaint.clearShadowLayer();
    	 }
    	canvas.drawText("����", 50,100, mPaint);
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
