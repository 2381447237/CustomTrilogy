package com.example.testcustomview2017_4_27;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.PathDashPathEffect;
import android.graphics.PathDashPathEffect.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View{

	private Paint paint;
	private Bitmap bitmap;
	private Options ops;
	
	public CustomView(Context context) {
		this(context,null);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		paint=new Paint();
		ops=new Options();
		ops.inSampleSize=2;
	    bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.tangyan,null);
	}

  
	@SuppressLint("DrawAllocation") @Override
	protected void onDraw(Canvas canvas) {
		
	paint.setAntiAlias(true);
	paint.setARGB(255, 200, 100, 100);
	 // ����ԭʼλͼ 
	//canvas.drawRect(0, 0, 200, 600, paint);
	//canvas.translate(250,0);
	// ����ɫ�ʾ���	
   // ColorMatrix colorMatrix=new ColorMatrix(new float[]{
    //	0,0,0,0,0,
    //	0,0,0,0,0,
    //	0,0,1,0,0,
    //	0,0,0,1,0
    //});	
    //paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
   // canvas.drawRect(0,0,500,600, paint);
	

	
	// ����ԭʼλͼ
	//canvas.drawBitmap(bitmap,null, new Rect(0, 0,bitmap.getWidth(), bitmap.getHeight()), paint);
	//canvas.translate(0, bitmap.getHeight());
	// ����ɫ�ʾ���
	//ColorMatrix colorMatrix=new ColorMatrix(new float[]{
		//0,0,0,0,0,
		//0,0,0,0,0,
		//0,0,1,0,0,
		//0,0,0,1,0
	//});
	//paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
	//canvas.drawBitmap(bitmap,null, new Rect(0, 0,bitmap.getWidth(), bitmap.getHeight()), paint);
	
	
	//ɫ�ʵļ������㷽ʽ
	//1��ɫ�ʵ�ƽ������
	//ɫ�ʵ�ƽ�����㣬ʵ���Ͼ���ɫ�ʵļӷ����㡣��ʵ������ɫ�ʱ任��������һ�м���ĳ��ֵ���������������ض�ɫ�ʵı��Ͷ�
		 //����ɫ�ʾ���
		ColorMatrix colorMatrix=new ColorMatrix(new float[]{
			1,0,0,0,0,
			0,1,0,0,0,
			0,0,1,0,0,
			0,0,0,1,0
		});
		paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
		canvas.drawBitmap(bitmap,null, new Rect(0, 0,bitmap.getWidth(), bitmap.getHeight()), paint);
		canvas.translate(0, bitmap.getHeight());
		ColorMatrix colorMatrix2=new ColorMatrix(new float[]{
				1,0,0,0,0,
				0,1,0,0,0,
				0,0,1,0,50,
				0,0,0,1,0
			});
			paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix2));
		canvas.drawBitmap(bitmap,null, new Rect(0, 0,bitmap.getWidth(), bitmap.getHeight()), paint);
	
		//ɫ�ʷ�ת/���๦��
		//ɫ�ʷ�ת�������ÿ��ɫ�ʵĲ�ֵ����ΪĿ��ͼ��Ķ�Ӧ��ɫֵ
		canvas.translate(0, bitmap.getHeight());
		ColorMatrix colorMatrix3=new ColorMatrix(new float[]{
				-1,0,0,0,255,
				0,-1,0,0,255,
				0,0,-1,0,255,
				0,0,0,1,0
			});
			paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix3));
		canvas.drawBitmap(bitmap,null, new Rect(0, 0,bitmap.getWidth(), bitmap.getHeight()), paint);
		//2��ɫ�ʵ���������
		//ɫ�ʵ�����������ʵ����ɫ�ʵĳ˷����㡣��ɫ�ʾ���Խ����ϵķֱ����R��G��B��A�ļ���ֵ������ֱ����ָ����ֵ���������ν�����ű任
	    //3��ɫ�ʵ���ת����
		//4��ɫ�ʵ�Ͷ������
	
	}
	
	
}
