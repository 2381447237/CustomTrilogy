package com.example.testcustomview2017_4_27;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.PathDashPathEffect;
import android.graphics.PathDashPathEffect.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View{

	private Paint paint;
	private Path path;
	
	public CustomView(Context context) {
		this(context,null);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		paint=new Paint();
		path=new Path();
	}

  
	@SuppressLint("DrawAllocation") @Override
	protected void onDraw(Canvas canvas) {
		
		paint.setStrokeWidth(20);
		paint.setColor(Color.GREEN);
		paint.setStyle(Paint.Style.STROKE);
		
		//设置线冒样式，取值有Cap.ROUND(圆形线冒)、Cap.SQUARE(方形线冒)、Paint.Cap.BUTT(无线冒) 
		//paint.setStrokeCap(Cap.BUTT);
		//canvas.drawLine(100,100,100,300, paint);
		//paint.setStrokeCap(Cap.ROUND);
		//canvas.drawLine(200,100,200,300, paint);
		//paint.setStrokeCap(Cap.SQUARE);
		//canvas.drawLine(300,100,300,300, paint);
		
		
		//设置线段连接处样式，取值有：Join.MITER（结合处为锐角）、Join.Round(结合处为圆弧)、Join.BEVEL(结合处为直线)
		//path.moveTo(100,100);
		//path.lineTo(450,100);
		//path.lineTo(100,300);
		//paint.setStrokeJoin(Join.MITER);
		//canvas.drawPath(path, paint);
		
		//path.moveTo(100,400);  
		//path.lineTo(450,400);  
		//path.lineTo(100,600);  
		//paint.setStrokeJoin(Paint.Join.BEVEL);  
		//canvas.drawPath(path,paint);  
		  
		//path.moveTo(100,700);  
		//path.lineTo(450,700);  
		//path.lineTo(100,900);  
		//paint.setStrokeJoin(Paint.Join.ROUND);  
		//canvas.drawPath(path,paint);  
		
		
		//setPathEffect(PathEffect effect)
		//设置路径样式;取值类型是所有派生自PathEffect的子类
		//（1）、CornerPathEffect——圆形拐角效果 
		//（2）、DashPathEffect——虚线效果(可以用来画虚线)
		//（3）、DiscretePathEffect——离散路径效果
		//（4）、PathDashPathEffect——印章路径效果 
		//（5）、ComposePathEffect与SumPathEffect 
		
		//画虚线
		//paint.setStrokeWidth(2);
		//path.moveTo(100, 100);
		//path.lineTo(600, 100);
		//paint.setPathEffect(new DashPathEffect(new float[]{10f,5f} ,0));
		//canvas.drawPath(path, paint);
		

		//印章路径效果 
		//画出原始路径
		paint.setStrokeWidth(2);
		path.moveTo(100,100);
		path.lineTo(600,100);
		//canvas.drawPath(path, paint);
		//构建印章路径
		Path stampPath=new Path();
		stampPath.moveTo(0,20);  
		stampPath.lineTo(10,0);  
		stampPath.lineTo(20,20);  
		stampPath.close();  
		stampPath.addCircle(0,0,3, Path.Direction.CCW);
		//使用印章路径效果
		paint.setPathEffect(new PathDashPathEffect(stampPath, 35, 20,Style.TRANSLATE));
		canvas.drawPath(path, paint);
	}
	
}
