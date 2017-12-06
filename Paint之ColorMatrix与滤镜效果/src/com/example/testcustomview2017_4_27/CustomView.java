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
	 // 绘制原始位图 
	//canvas.drawRect(0, 0, 200, 600, paint);
	//canvas.translate(250,0);
	// 生成色彩矩阵	
   // ColorMatrix colorMatrix=new ColorMatrix(new float[]{
    //	0,0,0,0,0,
    //	0,0,0,0,0,
    //	0,0,1,0,0,
    //	0,0,0,1,0
    //});	
    //paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
   // canvas.drawRect(0,0,500,600, paint);
	

	
	// 绘制原始位图
	//canvas.drawBitmap(bitmap,null, new Rect(0, 0,bitmap.getWidth(), bitmap.getHeight()), paint);
	//canvas.translate(0, bitmap.getHeight());
	// 生成色彩矩阵
	//ColorMatrix colorMatrix=new ColorMatrix(new float[]{
		//0,0,0,0,0,
		//0,0,0,0,0,
		//0,0,1,0,0,
		//0,0,0,1,0
	//});
	//paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
	//canvas.drawBitmap(bitmap,null, new Rect(0, 0,bitmap.getWidth(), bitmap.getHeight()), paint);
	
	
	//色彩的几种运算方式
	//1、色彩的平移运算
	//色彩的平移运算，实际上就是色彩的加法运算。其实就是在色彩变换矩阵的最后一行加上某个值；这样可以增加特定色彩的饱和度
		 //生成色彩矩阵
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
	
		//色彩反转/反相功能
		//色彩反转就是求出每个色彩的补值来做为目标图像的对应颜色值
		canvas.translate(0, bitmap.getHeight());
		ColorMatrix colorMatrix3=new ColorMatrix(new float[]{
				-1,0,0,0,255,
				0,-1,0,0,255,
				0,0,-1,0,255,
				0,0,0,1,0
			});
			paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix3));
		canvas.drawBitmap(bitmap,null, new Rect(0, 0,bitmap.getWidth(), bitmap.getHeight()), paint);
		//2、色彩的缩放运算
		//色彩的缩放运算其实就是色彩的乘法运算。在色彩矩阵对角线上的分别代表R、G、B、A的几个值，将其分别乘以指定的值。这就是所谓的缩放变换
	    //3、色彩的旋转运算
		//4、色彩的投射运算
	
	}
	
	
}
