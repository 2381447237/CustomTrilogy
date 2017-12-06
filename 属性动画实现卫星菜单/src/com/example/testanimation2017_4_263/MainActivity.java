package com.example.testanimation2017_4_263;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

@SuppressLint("NewApi") public class MainActivity extends Activity implements OnClickListener{

	private Button mMenuButton;
	private Button mItemButton1,mItemButton2,mItemButton3,mItemButton4,mItemButton5;
	private boolean mIsMenuOpen=false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        mMenuButton=(Button) findViewById(R.id.menu);
        mItemButton1=(Button) findViewById(R.id.item1);
        mItemButton2=(Button) findViewById(R.id.item2);
        mItemButton3=(Button) findViewById(R.id.item3);
        mItemButton4=(Button) findViewById(R.id.item4);
        mItemButton5=(Button) findViewById(R.id.item5);
        
        mMenuButton.setOnClickListener(this);
        mItemButton1.setOnClickListener(this);
        mItemButton2.setOnClickListener(this);
        mItemButton3.setOnClickListener(this);
        mItemButton4.setOnClickListener(this);
        mItemButton5.setOnClickListener(this);
        
    }

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.menu:
			if(!mIsMenuOpen){
				mIsMenuOpen=true;
				doAnimateOpen(mItemButton1,0,5,300);
				doAnimateOpen(mItemButton2,1,5,300);
				doAnimateOpen(mItemButton3,2,5,300);
				doAnimateOpen(mItemButton4,3,5,300);
				doAnimateOpen(mItemButton5,4,5,300);
			}else{
				mIsMenuOpen=false;
				doAnimateClose(mItemButton1,0,5,300);
				doAnimateClose(mItemButton2,1,5,300);
				doAnimateClose(mItemButton3,2,5,300);
				doAnimateClose(mItemButton4,3,5,300);
				doAnimateClose(mItemButton5,4,5,300);
			}
			
			break;

		case R.id.item1:
			
			Toast.makeText(this,"������item1",0).show();
			
			break;
			
	case R.id.item2:
			
			Toast.makeText(this,"������item2",0).show();
			
			break;
	case R.id.item3:
		
		Toast.makeText(this,"������item3",0).show();
		
		break;
	case R.id.item4:
		
		Toast.makeText(this,"������item4",0).show();
		
		break;
	case R.id.item5:
		
		Toast.makeText(this,"������item5",0).show();
		
		break;
		default:
			break;
		}
		
	}
	
	/**
     * �򿪲˵��Ķ���
     * @param view ִ�ж�����view
     * @param index view�ڶ��������е�˳��,��0��ʼ
     * @param total �������еĸ���
     * @param radius �����뾶
     *
     *  Math.sin(x):x -- Ϊnumber���͵Ļ��ȣ��Ƕȳ���0.017(2��/360)����ת��Ϊ����
     */
	private void doAnimateOpen(View view,int index,int total,int radius){
		
		if(view.getVisibility()!=View.VISIBLE){
			view.setVisibility(View.VISIBLE);
		}
		
		double degree=Math.toRadians(90)/(total-1)*index;
		int translationX=-(int)(radius*Math.sin(degree));
		int translationY=-(int) (radius*Math.cos(degree));
		
		AnimatorSet set=new AnimatorSet();
		 //����ƽ�ơ����ź�͸���ȶ���
		set.playTogether(ObjectAnimator.ofFloat(view, "translationX", 0,translationX),
				ObjectAnimator.ofFloat(view, "translationY",0,translationY),
				ObjectAnimator.ofFloat(view, "scaleX",0f,1f),
				ObjectAnimator.ofFloat(view, "scaleY",0f,1f),
				ObjectAnimator.ofFloat(view, "alpha",0f,1));
		set.setDuration(500);
		set.start();
		
	}
	
	/**
     * �رղ˵��Ķ���
     * @param view ִ�ж�����view
     * @param index view�ڶ��������е�˳��
     * @param total �������еĸ���
     * @param radius �����뾶
     */
	private void doAnimateClose(View view,int index,int total,int radius){
		
		if(view.getVisibility()!=View.VISIBLE){
			view.setVisibility(View.VISIBLE);
		}
		
		double degree=Math.PI*index/((total-1)*2);
		int translationX=-(int) (radius*Math.sin(degree));
        int translationY=-(int) (radius*Math.cos(degree));	
        
        AnimatorSet set=new AnimatorSet();
        //����ƽ�ơ����ź�͸���ȶ���
        set.playTogether(ObjectAnimator.ofFloat(view,"translationX",translationX,0),
        		ObjectAnimator.ofFloat(view, "translationY",translationY,0),
        		ObjectAnimator.ofFloat(view, "scaleX",1f,0.01f),//ע�����һ��������0.01f��������0�������ڵ����ʱ�����bug
        		ObjectAnimator.ofFloat(view, "scaleY", 1f,0.01f),//ע�����һ��������0.01f��������0�������ڵ����ʱ�����bug
        		ObjectAnimator.ofFloat(view, "alpha",1f,0f));
        
        set.setDuration(500);
        
        set.start();
	}
	
}
