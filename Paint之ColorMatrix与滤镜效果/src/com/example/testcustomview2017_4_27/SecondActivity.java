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
import android.widget.TextView;

public class SecondActivity extends Activity{
	 private SeekBar mSeekBar;
	    private ImageView mImageView;
	    private Bitmap mOriginBmp,mTempBmp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		  mImageView = (ImageView) findViewById(R.id.img);
	        mSeekBar = (SeekBar)findViewById(R.id.seekbar);
	        mOriginBmp = BitmapFactory.decodeResource(getResources(), R.drawable.tangyan);
	        mTempBmp = Bitmap.createBitmap(mOriginBmp.getWidth(), mOriginBmp.getHeight(),
	                Bitmap.Config.ARGB_8888);
	        TextView tv = (TextView)findViewById(R.id.tv);
	        tv.setText("ɫ����ת(-180����180):");
	        mSeekBar.setMax(360);
	        mSeekBar.setProgress(180);

	        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
	            @Override
	            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

	                Bitmap bitmap = handleColorRotateBmp(progress);
	                mImageView.setImageBitmap(bitmap);
	            }

	            @Override
	            public void onStartTrackingTouch(SeekBar seekBar) {

	            }

	            @Override
	            public void onStopTrackingTouch(SeekBar seekBar) {

	            }
	        });
	}
	 private Bitmap handleColorRotateBmp(int progress){

	        // ����һ����ͬ�ߴ�Ŀɱ��λͼ��,���ڻ��Ƶ�ɫ���ͼƬ
	        Canvas canvas = new Canvas(mTempBmp); // �õ����ʶ���
	        Paint paint = new Paint(); // �½�paint
	        paint.setAntiAlias(true); // ���ÿ����,Ҳ���Ǳ�Ե��ƽ������
	        ColorMatrix colorMatrix = new ColorMatrix();

	        colorMatrix.setRotate(0,progress-180);

	        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));// ������ɫ�任Ч��
	        canvas.drawBitmap(mOriginBmp, 0, 0, paint); // ����ɫ�仯���ͼƬ������´�����λͼ��
	        // �����µ�λͼ��Ҳ����ɫ������ͼƬ
	        return mTempBmp;
	    }
}
