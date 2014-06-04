package jmc.android_course.intents;

import java.util.ArrayList;
import java.util.Calendar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	public final static String TAG = "Intents and Permissions Assignment"; //Main Activity TAG
	public final static String MESSAGE = "Intent and Permissions Assignment Alarm";
	static final String ACTION_CUSTOM = "jmc.android_course.intents.CUSTOM";
	static final String EXTRA_CUSTOM_MESSAGE_TAG="EXTRA_CUSTOM_MESSAGE"; 
	static final String EXTRA_CUSTOM_MESSAGE= "Starting Implicit Intent";
	
	
	public final static int MINUTES = 30;
	public final static int HOUR = 14;
	public final static int DAY =Calendar.MONDAY;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button msearch_btn = (Button) findViewById(R.id.search_intent_btn);
		msearch_btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				 Intent intent = createSearchIntent();
			     if(canBeResolved(intent)){
			    
			    	 startActivity(Intent.createChooser(intent, "Web Search"));
			        }
		        else{
		        	Log.i(TAG,"No intent found.");				        	
	 	         }
				}
			});				
		
		final Button malarm_btn = (Button) findViewById(R.id.set_alarm_intent_btn);
		malarm_btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(Calendar.MONDAY);
				list.add(Calendar.FRIDAY);

				 Intent intent = createAlarmIntent(TAG,list, 14,30);
    			
			     if(canBeResolved(intent)){
			        	startActivity(intent);
			        }
		        else{
		        	Log.i(TAG,"No intent found.");				        	
	 	         }
				}
			});				
		
		
		
		final Button implicitButton = (Button) findViewById(R.id.implicit_intent_btn);
		implicitButton.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = createImplicitIntent();
				
			     if(canBeResolved(intent)){
			        	startActivity(intent);
			        	Log.i(TAG,"Implicit Start");		
			        }
			     else{
			        	Log.i(TAG,"No intent found.");				        	
			    	 
			     }
			}
		});
		
		
		final Button explicitButton = (Button) findViewById(R.id.explicit_intent_btn);
		explicitButton.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, ImplicitActivity.class);
			     if(canBeResolved(intent)){
			        	startActivity(intent);
			        	Log.i(TAG,"Explicit Start");		
			        }
			     else{
			        	Log.i(TAG,"No intent found.");				        	
			    	 
			     }
			}
		});
		
		
	}
	/** Examines the intent */
	public boolean canBeResolved(Intent intent){
    	 PackageManager pm = getPackageManager();
	    return intent.resolveActivity(pm) != null;		
	}
	
	
	/**
	 * Create a Search Intent, in our case it will display uwf.edu page
	 * */
	public Intent createSearchIntent()
	{
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_WEB_SEARCH);	
		intent.putExtra(SearchManager.QUERY, "http:\\uwf.edu");
		return intent;
	}
	
	
	/**
	 * Create Custom Implicit Intent 
	 * */
	public Intent createImplicitIntent()
	{
		Intent intent = new Intent();
		intent.setAction(ACTION_CUSTOM);
		intent.putExtra(EXTRA_CUSTOM_MESSAGE_TAG, EXTRA_CUSTOM_MESSAGE);
		
		return intent;
	}

	/**
	 * Creates Intent that sets alarm clock
	 * */
	public Intent createAlarmIntent(String message,ArrayList<Integer>days,int hour, int minutes)
	{
		 Intent intent = new Intent();
		 intent.setAction(AlarmClock.ACTION_SET_ALARM);
		 intent.putExtra(AlarmClock.EXTRA_DAYS, days);
		 intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
         intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
         intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
                           
         return intent;
	}
}
