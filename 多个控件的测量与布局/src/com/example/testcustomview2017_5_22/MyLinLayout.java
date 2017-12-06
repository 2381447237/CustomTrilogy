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
			//测量子控件
			View child=getChildAt(i);
			measureChild(child, widthMeasureSpec, heightMeasureSpec);
			//通过 child.getLayoutParams()获取child对应的LayoutParams实例，将其强转成MarginLayoutParams
			MarginLayoutParams lp=(MarginLayoutParams) child.getLayoutParams();
			//获得子控件的高度和宽度
			int childHeight=child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;
			int childWidth=child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
			//得到最大宽度，并且累加高度
			height+=childHeight;
			width=Math.max(childWidth, width);
		}
		//setMeasuredDimension()提供的测量结果只是为布局提供建议，最终的取用与否要看layout()函数
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
			
			//调用layout()函数设置子控件所在的位置
			//child.layout(0,top,childWidth,top+childHeight);
			child.layout(lp.leftMargin,top+lp.topMargin,child.getMeasuredWidth()+lp.leftMargin,top+child.getMeasuredHeight()+lp.topMargin);
			top+=childHeight;
		}
		
		//getMeasuredWidth()与getWidth()的区别
		// 1、getMeasureWidth()方法在measure()过程结束后就可以获取到了，而getWidth()方法要在layout()过程结束后才能获取到。
		//2、 getMeasureWidth()方法中的值是通过setMeasuredDimension()方法来进行设置的，而getWidth()方法中的值则是通过layout(left,top,right,bottom)方法设置的。
	}


	
	
}
