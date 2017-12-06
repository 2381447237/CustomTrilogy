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
		//path.quadTo(200,200,300,300);//参数中(x1,y1)是控制点坐标，(x2,y2)是终点坐标
		//canvas.drawPath(path, paint);
		
		//path.quadTo(400,400,500,300);//参数中(400,400)是控制点坐标，(500,300)是终点坐标
		//canvas.drawPath(path, paint);
		
		//paint.setColor(Color.RED);
		//canvas.drawPoint(200,200,paint);
		//canvas.drawPoint(300,300,paint);
		//canvas.drawPoint(400,400,paint);
		//canvas.drawPoint(500,300,paint);
		//整条线的起始点是通过Path.moveTo(x,y)来指定的，如果初始没有调用Path.moveTo(x,y)来指定起始点，则默认以控件左上角(0,0)为起始点；
		//而如果我们连续调用quadTo()，前一个quadTo()的终点，就是下一个quadTo()函数的起点；
			
		
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
			//区别是Invalidate()一定要在UI线程执行，如果不是在UI线程就会报错。
			//而postInvalidate()则没有那么多讲究，它可以在任何线程中执行，而不必一定要是主线程。
			break;

		case MotionEvent.ACTION_DOWN:
			path.moveTo(event.getX(),event.getY());
			mPreX=event.getX();
			mPreY=event.getY();
			return true;
			//return true表示当前控件已经消费了下按动作，之后的ACTION_MOVE、ACTION_UP动作也会继续传递到当前控件中；
			//如果我们在case MotionEvent.ACTION_DOWN时return false，那么后序的ACTION_MOVE、ACTION_UP动作就不会再传到这个控件来了
			
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
