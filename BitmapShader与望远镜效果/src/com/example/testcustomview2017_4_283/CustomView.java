package com.example.testcustomview2017_4_283;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.graphics.Shader.TileMode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View{

	private Paint mPaint;
	private Bitmap mBitmap,mBitmapBG;
	private int mDx=-1,mDy=-1;
	
	public CustomView(Context context) {
		this(context,null);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mPaint=new Paint();
		mBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.bg);
	}

     
	@Override
	protected void onDraw(Canvas canvas) {
		
		if(mBitmapBG==null){
			//�½�һ���հ׵�bitmap�����bitmap�Ĵ�С��ؼ�һ����Ȼ������ǵı���ͼ�������죬��������հ׵�bitmap��
			mBitmapBG=Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
			Canvas canvasbg=new Canvas(mBitmapBG);
			canvasbg.drawBitmap(mBitmap, null,new Rect(0, 0,getWidth(),getHeight()), mPaint);
		}
		
		if(mDx!=-1&&mDy!=-1){
			//���û���ָ�°�ʱ������ָλ�û�һ���뾶Ϊ150��Բ�Σ��Ѷ�Ӧ��λ�õ�ͼ����ʾ����
			mPaint.setShader(new BitmapShader(mBitmapBG,TileMode.REPEAT,TileMode.REPEAT));
			canvas.drawCircle(mDx, mDy, 150, mPaint);
		}
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mDx=(int) event.getX();
			mDy=(int) event.getY();
			invalidate();
			return true;

case MotionEvent.ACTION_MOVE:
			mDx=(int) event.getX();
			mDy=(int) event.getY();
			
			break;

case MotionEvent.ACTION_CANCEL:
	mDx=-1;
	mDy=-1;
	break;
		default:
			break;
		}
		invalidate();
		return super.onTouchEvent(event);
	}
	
}
