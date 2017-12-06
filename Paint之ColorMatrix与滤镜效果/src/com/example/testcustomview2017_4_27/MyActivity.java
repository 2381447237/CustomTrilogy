package com.example.testcustomview2017_4_27;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MyActivity extends Activity{

	private SeekBar mSeekBar;
	private ImageView mImageView;
	private Bitmap mOriginBmp,mTempBmp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		mImageView=(ImageView) findViewById(R.id.img);
		mSeekBar=(SeekBar) findViewById(R.id.seekbar);
		mOriginBmp=BitmapFactory.decodeResource(getResources(), R.drawable.tangyan);
		mTempBmp=Bitmap.createBitmap(mOriginBmp.getWidth(),mOriginBmp.getHeight(),Bitmap.Config.ARGB_8888);
		
		mSeekBar.setMax(20);
		mSeekBar.setProgress(1);
		mSeekBar.setProgress(10);
		
		mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
				Bitmap bitmap=handleColorMatrixBmp(progress);
				mImageView.setImageBitmap(bitmap);
				
			}
		});
	}

	protected Bitmap handleColorMatrixBmp(int progress) {
		 // ����һ����ͬ�ߴ�Ŀɱ��λͼ��,���ڻ��Ƶ�ɫ���ͼƬ
        Canvas canvas = new Canvas(mTempBmp); // �õ����ʶ���
        Paint paint = new Paint(); // �½�paint
        paint.setAntiAlias(true); // ���ÿ����,Ҳ���Ǳ�Ե��ƽ������
        ColorMatrix mSaturationMatrix = new ColorMatrix();

        mSaturationMatrix.setSaturation(progress);

        paint.setColorFilter(new ColorMatrixColorFilter(mSaturationMatrix));// ������ɫ�任Ч��
        canvas.drawBitmap(mOriginBmp, 0, 0, paint); // ����ɫ�仯���ͼƬ������´�����λͼ��
        // �����µ�λͼ��Ҳ����ɫ������ͼƬ
		return mTempBmp;
	}
	private Bitmap handleColorRotateBmp(int progress){
        // ����һ����ͬ�ߴ�Ŀɱ��λͼ��,���ڻ��Ƶ�ɫ���ͼƬ
        Canvas canvas = new Canvas(mTempBmp); // �õ����ʶ���
        Paint paint = new Paint(); // �½�paint
        paint.setAntiAlias(true); // ���ÿ����,Ҳ���Ǳ�Ե��ƽ������
        ColorMatrix mSaturationMatrix = new ColorMatrix();

        mSaturationMatrix.setSaturation(progress);

        paint.setColorFilter(new ColorMatrixColorFilter(mSaturationMatrix));// ������ɫ�任Ч��
        canvas.drawBitmap(mOriginBmp, 0, 0, paint); // ����ɫ�仯���ͼƬ������´�����λͼ��
        // �����µ�λͼ��Ҳ����ɫ������ͼƬ
        return mTempBmp;
    }
}
