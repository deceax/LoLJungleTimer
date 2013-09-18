package com.fb.lol.jungle.timer;

import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class BuffTimer {
	private final ImageButton imgButton;
	private final TextView buffTimer;
	private final Handler mHandler = new Handler();
	private long mStartTime = 0;
	private int mDuration = 0;
	private int activeImage = 0;
	private int inactiveImage = 0;
	private boolean isRunning = false;
	
	public BuffTimer(ImageButton imgButton, TextView buffTimer, int duration, int inactiveImage, int activeImage)
	{
		this.imgButton = imgButton;
		this.buffTimer = buffTimer;
		this.mDuration = duration;
		this.activeImage = activeImage;
		this.inactiveImage = inactiveImage;
    	buffTimer.setTextSize(55);
	}
	
    public void addBuff()
    {
    	imgButton.setOnClickListener(new OnClickListener()
    	{
    	    @Override
    		public void onClick(View v)
    		{
    	    	if (isRunning)
    	    	{
    	    		resetTimer();
    	    	}
    	    	else
    	    	{
    	    		isRunning = true;
    	    		mStartTime = System.currentTimeMillis();
    	    		mHandler.removeCallbacks(mUpdateTimeTask);
    	    		imgButton.setImageResource(activeImage);
    	    		mHandler.postDelayed(mUpdateTimeTask, 100);
    	    	}
    		}
    	});
    }
    
    private void resetTimer()
    {
    	buffTimer.setText("");
    	buffTimer.setTextColor(Color.WHITE);
    	buffTimer.setTextSize(55);
    	imgButton.setImageResource(inactiveImage);
    	mHandler.removeCallbacks(mUpdateTimeTask);
    	isRunning = false;
    }
    
    private final Runnable mUpdateTimeTask = new Runnable() {
    	public void run() {
    		final long start = mStartTime;
    		final int duration = mDuration;
    		long curr = System.currentTimeMillis();
    		long diff = curr - start;
    		
    		int seconds = (int) (diff / 1000);
    		int time_left = duration - seconds;
    		
    		int minutes = time_left/60;
    		seconds = time_left % 60;
    		
    		if (minutes == 0)
    		{
    			buffTimer.setText("" + seconds);
    			if (seconds < 10)
    			{
    				buffTimer.setTextColor(Color.RED);
    				buffTimer.setTextSize(105);
    			}
    		}
    		else if (seconds < 10)
    		{
    			buffTimer.setText(minutes + ":0" + seconds);
    		}
    		else
    		{
    			buffTimer.setText(minutes + ":" + seconds);
    		}
    	    mHandler.postDelayed(this, 1000);
    	    
    	    if (time_left <= 0)
    	    {
    	    	resetTimer();
    	    }
    	   }
    	};
}
