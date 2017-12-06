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
    	 
    	// ֱ��·��
         //void moveTo (float x1, float y1):ֱ�ߵĿ�ʼ�㣻����ֱ��·���Ļ��Ƶ㶨�ڣ�x1,y1����λ�ã�
         //void lineTo (float x2, float y2)��ֱ�ߵĽ����㣬������һ�λ���ֱ��·���Ŀ�ʼ�㣻lineTo��������һֱ�ã�
         //void close ():����������˼���ֱ�ߣ���û���γɱջ�������Close()�Ὣ·����β�������������γɱջ���
    	// path.moveTo(10,10);
    	 //path.lineTo(10,100);
    	 //path.lineTo(300, 100);
    	 //path.close();
    	 //canvas.drawPath(path, paint);
    	 
    	 
    	 //����·��
    	// Path.Direction������ֵ��
    	 //Path.Direction.CCW����counter-clockwise��д����ʱ�룻
    	 //Path.Direction.CW����clockwise����д��˳ʱ�룻
    	 
    	 
    //String a="�һ���֧��BM";
   //paint.setTextSize(80);
   //paint.setStyle(Style.FILL);
  //canvas.drawText(a,10,100, paint);	 
  //paint.setStyle(Style.STROKE);
  //canvas.drawText(a,10,200, paint);
  //paint.setStyle(Style.FILL_AND_STROKE);
  // canvas.drawText(a,10,300, paint);
  //    	 
  //paint.setFakeBoldText(true);//�����Ƿ�Ϊ��������
  //paint.setUnderlineText(true);//�����»���
  //paint.setStrikeThruText(true);//���ô���ɾ����Ч��
  //paint.setTextSkewX((float) -0.25);//��������ˮƽ��б�ȣ���ͨб������-0.25���ɼ�����б
  //canvas.drawText(a,10,400, paint);
  //paint.setTextSkewX((float) 0.25);
  //canvas.drawText(a,10,500, paint);
    	 
    	 
    	 //��·������
    	 String b="�һ���֧�ְ���Ľ���!!!";
    	 paint.setTextSize(45);
    	 path.addCircle(getWidth()/2,getHeight()/2,200,Path.Direction.CW);
    	 canvas.drawPath(path, paint);
    	 paint.setColor(Color.BLACK);
    	 canvas.drawTextOnPath(b, path, 200*(float) Math.PI, 0, paint);
    }
	
	
}
