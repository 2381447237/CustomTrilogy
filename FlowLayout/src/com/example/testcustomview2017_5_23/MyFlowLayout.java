package com.example.testcustomview2017_5_23;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class MyFlowLayout extends ViewGroup{
	
	public MyFlowLayout(Context context) {
		super(context);
	}
	
	public MyFlowLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	 @Override
	    protected LayoutParams generateLayoutParams(
	            LayoutParams p)
	    {
	        return new MarginLayoutParams(p);
	    }

	    @Override
	    public LayoutParams generateLayoutParams(AttributeSet attrs)
	    {
	        return new MarginLayoutParams(getContext(), attrs);
	    }

	    @Override
	    protected LayoutParams generateDefaultLayoutParams()
	    {
	        return new MarginLayoutParams(LayoutParams.MATCH_PARENT,
	                LayoutParams.MATCH_PARENT);
	    }

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		int measureWidth=MeasureSpec.getSize(widthMeasureSpec);
		int measureHeight=MeasureSpec.getSize(heightMeasureSpec);
		int measureWidthMode=MeasureSpec.getMode(widthMeasureSpec);
		int measureHeightMode=MeasureSpec.getMode(heightMeasureSpec);
		
		int lineWidth = 0;//��¼ÿһ�еĿ��  
		int lineHeight = 0;//��¼ÿһ�еĸ߶�  
		int height = 0;//��¼����FlowLayout��ռ�߶�  
		int width = 0;//��¼����FlowLayout��ռ���  
		int count=getChildCount();
		
		for(int i=0;i<count;i++){
			
			View child=getChildAt(i);
			measureChild(child, widthMeasureSpec, heightMeasureSpec);
			
			MarginLayoutParams lp=(MarginLayoutParams) child.getLayoutParams();
			int childWidth=child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
			int childHeight=child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;
			
			 if (lineWidth + childWidth > measureWidth){  
			        //��Ҫ����  
			        width = Math.max(lineWidth,childWidth);  
			        height += lineHeight;  
			        //��Ϊ����ʢ���µ�ǰ�ؼ��������˿ؼ�������һ�У����Խ��˿ؼ��ĸ߶ȺͿ�ȳ�ʼ����lineHeight��lineWidth  
			        lineHeight = childHeight;  
			        lineWidth = childWidth;  
			    }else{  
			        // �����ۼ�ֵlineWidth,lineHeightȡ���߶�  
			        lineHeight = Math.max(lineHeight,childHeight);  
			        lineWidth += childWidth;  
			    }  
			  
			    //���һ���ǲ��ᳬ��width��Χ�ģ�����Ҫ��������  
			    if (i == count -1){  
			        height += lineHeight;  
			        width = Math.max(width,lineWidth);  
			    }  
		}
		
		setMeasuredDimension((measureWidthMode==MeasureSpec.EXACTLY)?measureWidth:width, 
				(measureHeightMode==MeasureSpec.EXACTLY)?measureHeight:height);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		
		 int count = getChildCount();  
		   int lineWidth = 0;  
		   int lineHeight = 0;  
		   int top=0,left=0;  
		   for (int i=0; i<count;i++){  
		       View child = getChildAt(i);  
		       MarginLayoutParams lp = (MarginLayoutParams) child  
		               .getLayoutParams();  
		       int childWidth = child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;  
		       int childHeight = child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;  
		  
		       if (childWidth + lineWidth >getMeasuredWidth()){  
		           //�������,��ǰ�ؼ����ܵ���һ�У�������߿�ʼ������left����0����top����Ҫ������һ�е��иߣ���������ؼ���top��;  
		           top += lineHeight;  
		           left = 0;  
		           //ͬ�������³�ʼ��lineHeight��lineWidth  
		           lineHeight = childHeight;  
		           lineWidth = childWidth;  
		       }else{  
		           lineHeight = Math.max(lineHeight,childHeight);  
		           lineWidth += childWidth;  
		       }  
		       //����childView��left,top,right,bottom  
		       int lc = left + lp.leftMargin;  
		       int tc = top + lp.topMargin;  
		       int rc =lc + child.getMeasuredWidth();  
		       int bc = tc + child.getMeasuredHeight();  
		       child.layout(lc, tc, rc, bc);  
		       //��left��Ϊ��һ�ӿؼ�����ʼ��  
		       left+=childWidth;  
		   }  
		
		
	}


	
	
}
