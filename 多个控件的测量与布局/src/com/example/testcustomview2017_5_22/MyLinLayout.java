package com.example.testcustomview2017_5_22;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyLinLayout extends ViewGroup{

	public MyLinLayout(Context context) {
		super(context);
	}
	
	
	public MyLinLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}


	@Override
	protected LayoutParams generateLayoutParams(LayoutParams p) {
		return new MarginLayoutParams(p);
	}
	
	@Override
	public LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new MarginLayoutParams(getContext(), attrs);
	}
	
	@Override
	protected LayoutParams generateDefaultLayoutParams() {
		return new MarginLayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		int measureWidth=MeasureSpec.getSize(widthMeasureSpec);
		int measureHeight=MeasureSpec.getSize(heightMeasureSpec);
		int measureWidthMode=MeasureSpec.getMode(widthMeasureSpec);
		int measureHeightMode=MeasureSpec.getMode(heightMeasureSpec);
		
		int height=0;
		int width=0;
		int count=getChildCount();
		for(int i=0;i<count;i++){
			//�����ӿؼ�
			View child=getChildAt(i);
			measureChild(child, widthMeasureSpec, heightMeasureSpec);
			//ͨ�� child.getLayoutParams()��ȡchild��Ӧ��LayoutParamsʵ��������ǿת��MarginLayoutParams
			MarginLayoutParams lp=(MarginLayoutParams) child.getLayoutParams();
			//����ӿؼ��ĸ߶ȺͿ��
			int childHeight=child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;
			int childWidth=child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
			//�õ�����ȣ������ۼӸ߶�
			height+=childHeight;
			width=Math.max(childWidth, width);
		}
		//setMeasuredDimension()�ṩ�Ĳ������ֻ��Ϊ�����ṩ���飬���յ�ȡ�����Ҫ��layout()����
		setMeasuredDimension((measureWidthMode==MeasureSpec.EXACTLY?measureWidth:width),(measureHeightMode==MeasureSpec.EXACTLY)?measureHeight:height);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		
		int top=0;
		int count=getChildCount();
		
		for(int i=0;i<count;i++){
			
			View child=getChildAt(i);
			
			MarginLayoutParams lp=(MarginLayoutParams) child.getLayoutParams();
			
			int childHeight=child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;
			int childWidth=child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
			
			//����layout()���������ӿؼ����ڵ�λ��
			//child.layout(0,top,childWidth,top+childHeight);
			child.layout(lp.leftMargin,top+lp.topMargin,child.getMeasuredWidth()+lp.leftMargin,top+child.getMeasuredHeight()+lp.topMargin);
			top+=childHeight;
		}
		
		//getMeasuredWidth()��getWidth()������
		// 1��getMeasureWidth()������measure()���̽�����Ϳ��Ի�ȡ���ˣ���getWidth()����Ҫ��layout()���̽�������ܻ�ȡ����
		//2�� getMeasureWidth()�����е�ֵ��ͨ��setMeasuredDimension()�������������õģ���getWidth()�����е�ֵ����ͨ��layout(left,top,right,bottom)�������õġ�
	}


	
	
}
