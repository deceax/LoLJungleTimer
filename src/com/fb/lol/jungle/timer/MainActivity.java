package com.fb.lol.jungle.timer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	BuffTimer blueBuff1;
	BuffTimer blueBuff2;
	BuffTimer redBuff1;
	BuffTimer redBuff2;
	BuffTimer dragon;
	BuffTimer baron;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blueBuff1 = new BuffTimer((ImageButton) findViewById(R.id.blue_buff1),
        						 (TextView) findViewById(R.id.blue_buff_timer1),
        						 300, R.drawable.blue_buff_1, R.drawable.blue_buff_1_grey);
        blueBuff1.addBuff();
        
        blueBuff2 = new BuffTimer((ImageButton) findViewById(R.id.blue_buff2),
        						  (TextView) findViewById(R.id.blue_buff_timer2),
        						  300, R.drawable.blue_buff_2, R.drawable.blue_buff_2_grey);
        
        blueBuff2.addBuff();
        
        redBuff1 = new BuffTimer((ImageButton) findViewById(R.id.red_buff1),
				 				 (TextView) findViewById(R.id.red_buff_timer1),
				 				 300, R.drawable.red_buff_1, R.drawable.red_buff_1_grey);
        redBuff1.addBuff();
        
        redBuff2 = new BuffTimer((ImageButton) findViewById(R.id.red_buff2),
				 				 (TextView) findViewById(R.id.red_buff_timer2),
				 				 300, R.drawable.red_buff_2, R.drawable.red_buff_2_grey);
        redBuff2.addBuff();
        
        dragon = new BuffTimer((ImageButton) findViewById(R.id.dragon),
				 			   (TextView) findViewById(R.id.dragon_timer),
				 			   360, R.drawable.dragon, R.drawable.dragon_grey);
        dragon.addBuff();
        
        baron = new BuffTimer((ImageButton) findViewById(R.id.baron),
				 			  (TextView) findViewById(R.id.baron_timer),
				 			  420, R.drawable.baron, R.drawable.baron_grey);
        baron.addBuff();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
