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
		
		//������ð��ʽ��ȡֵ��Cap.ROUND(Բ����ð)��Cap.SQUARE(������ð)��Paint.Cap.BUTT(����ð) 
		//paint.setStrokeCap(Cap.BUTT);
		//canvas.drawLine(100,100,100,300, paint);
		//paint.setStrokeCap(Cap.ROUND);
		//canvas.drawLine(200,100,200,300, paint);
		//paint.setStrokeCap(Cap.SQUARE);
		//canvas.drawLine(300,100,300,300, paint);
		
		
		//�����߶����Ӵ���ʽ��ȡֵ�У�Join.MITER����ϴ�Ϊ��ǣ���Join.Round(��ϴ�ΪԲ��)��Join.BEVEL(��ϴ�Ϊֱ��)
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
		//����·����ʽ;ȡֵ����������������PathEffect������
		//��1����CornerPathEffect����Բ�ιս�Ч�� 
		//��2����DashPathEffect��������Ч��(��������������)
		//��3����DiscretePathEffect������ɢ·��Ч��
		//��4����PathDashPathEffect����ӡ��·��Ч�� 
		//��5����ComposePathEffect��SumPathEffect 
		
		//������
		//paint.setStrokeWidth(2);
		//path.moveTo(100, 100);
		//path.lineTo(600, 100);
		//paint.setPathEffect(new DashPathEffect(new float[]{10f,5f} ,0));
		//canvas.drawPath(path, paint);
		

		//ӡ��·��Ч�� 
		//����ԭʼ·��
		paint.setStrokeWidth(2);
		path.moveTo(100,100);
		path.lineTo(600,100);
		//canvas.drawPath(path, paint);
		//����ӡ��·��
		Path stampPath=new Path();
		stampPath.moveTo(0,20);  
		stampPath.lineTo(10,0);  
		stampPath.lineTo(20,20);  
		stampPath.close();  
		stampPath.addCircle(0,0,3, Path.Direction.CCW);
		//ʹ��ӡ��·��Ч��
		paint.setPathEffect(new PathDashPathEffect(stampPath, 35, 20,Style.TRANSLATE));
		canvas.drawPath(path, paint);
	}
	
}
