package com.example.testcustomview2017_4_26;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
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

     @Override
    protected void onDraw(Canvas canvas) {
    	
    	 paint.setAntiAlias(true);
    	 paint.setColor(Color.RED);
    	 paint.setStyle(Paint.Style.STROKE);
    	 paint.setStrokeWidth(5);
    	 
    	// 直线路径
         //void moveTo (float x1, float y1):直线的开始点；即将直线路径的绘制点定在（x1,y1）的位置；
         //void lineTo (float x2, float y2)：直线的结束点，又是下一次绘制直线路径的开始点；lineTo（）可以一直用；
         //void close ():如果连续画了几条直线，但没有形成闭环，调用Close()会将路径首尾点连接起来，形成闭环；
    	// path.moveTo(10,10);
    	 //path.lineTo(10,100);
    	 //path.lineTo(300, 100);
    	 //path.close();
    	 //canvas.drawPath(path, paint);
    	 
    	 
    	 //矩形路径
    	// Path.Direction有两个值：
    	 //Path.Direction.CCW：是counter-clockwise缩写，逆时针；
    	 //Path.Direction.CW：是clockwise的缩写，顺时针；
    	 
    	 
    //String a="我还是支持BM";
   //paint.setTextSize(80);
   //paint.setStyle(Style.FILL);
  //canvas.drawText(a,10,100, paint);	 
  //paint.setStyle(Style.STROKE);
  //canvas.drawText(a,10,200, paint);
  //paint.setStyle(Style.FILL_AND_STROKE);
  // canvas.drawText(a,10,300, paint);
  //    	 
  //paint.setFakeBoldText(true);//设置是否为粗体文字
  //paint.setUnderlineText(true);//设置下划线
  //paint.setStrikeThruText(true);//设置带有删除线效果
  //paint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25，可见往右斜
  //canvas.drawText(a,10,400, paint);
  //paint.setTextSkewX((float) 0.25);
  //canvas.drawText(a,10,500, paint);
    	 
    	 
    	 //沿路径绘制
    	 String b="我还是支持拜仁慕尼黑!!!";
    	 paint.setTextSize(45);
    	 path.addCircle(getWidth()/2,getHeight()/2,200,Path.Direction.CW);
    	 canvas.drawPath(path, paint);
    	 paint.setColor(Color.BLACK);
    	 canvas.drawTextOnPath(b, path, 200*(float) Math.PI, 0, paint);
    }
	
	
}
