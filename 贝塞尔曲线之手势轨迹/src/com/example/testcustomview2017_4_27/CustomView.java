package com.example.testcustomview2017_4_27;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View{

	private Paint paint;
	private Path path;
	private float mPreX,mPreY;
	
	public CustomView(Context context) {
		this(context,null);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		paint=new Paint();
		path=new Path();
	}

  
	@Override
	protected void onDraw(Canvas canvas) {
		
		paint.setStrokeWidth(5);
		paint.setColor(Color.GREEN);
		paint.setStyle(Paint.Style.STROKE);
		//path.moveTo(100,300);
		//path.quadTo(200,200,300,300);//������(x1,y1)�ǿ��Ƶ����꣬(x2,y2)���յ�����
		//canvas.drawPath(path, paint);
		
		//path.quadTo(400,400,500,300);//������(400,400)�ǿ��Ƶ����꣬(500,300)���յ�����
		//canvas.drawPath(path, paint);
		
		//paint.setColor(Color.RED);
		//canvas.drawPoint(200,200,paint);
		//canvas.drawPoint(300,300,paint);
		//canvas.drawPoint(400,400,paint);
		//canvas.drawPoint(500,300,paint);
		//�����ߵ���ʼ����ͨ��Path.moveTo(x,y)��ָ���ģ������ʼû�е���Path.moveTo(x,y)��ָ����ʼ�㣬��Ĭ���Կؼ����Ͻ�(0,0)Ϊ��ʼ�㣻
		//�����������������quadTo()��ǰһ��quadTo()���յ㣬������һ��quadTo()��������㣻
			
		
		canvas.drawPath(path, paint);
	}
	
	@SuppressLint("ClickableViewAccessibility") @Override
	public boolean onTouchEvent(MotionEvent event) {
		
		switch (event.getAction()) {
		
		case MotionEvent.ACTION_MOVE:
			float endX=(mPreX+event.getX())/2;
			float endY=(mPreY+event.getY())/2;
			path.quadTo(mPreX,mPreY,endX,endY);
			mPreX=event.getX();
			mPreY=event.getY();
			invalidate();
			//������Invalidate()һ��Ҫ��UI�߳�ִ�У����������UI�߳̾ͻᱨ��
			//��postInvalidate()��û����ô�ི�������������κ��߳���ִ�У�������һ��Ҫ�����̡߳�
			break;

		case MotionEvent.ACTION_DOWN:
			path.moveTo(event.getX(),event.getY());
			mPreX=event.getX();
			mPreY=event.getY();
			return true;
			//return true��ʾ��ǰ�ؼ��Ѿ��������°�������֮���ACTION_MOVE��ACTION_UP����Ҳ��������ݵ���ǰ�ؼ��У�
			//���������case MotionEvent.ACTION_DOWNʱreturn false����ô�����ACTION_MOVE��ACTION_UP�����Ͳ����ٴ�������ؼ�����
			
		default:
			break;
		}
		
		return super.onTouchEvent(event);
	}
	
	public void myReset(){
		path.reset();
		invalidate();
	}
	
}
