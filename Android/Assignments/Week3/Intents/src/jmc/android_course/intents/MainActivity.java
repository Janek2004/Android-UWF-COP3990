package jmc.android_course.intents;

//import jmc.android_course.activity_assignment.R;
import java.util.List;

import org.apache.http.protocol.HTTP;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	public final static String TAG = "Intent and Permissions Assignment"; //Main Activity TAG
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	 			
		 final Button msearch_btn = (Button) findViewById(R.id.search_intent_btn);
		 msearch_btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_SEARCH);
					
					
					 PackageManager pm = getPackageManager();
				        List<ResolveInfo> list = pm.queryIntentActivities(intent,
				                PackageManager.MATCH_DEFAULT_ONLY);
				        if (list.size() > 0){
				        	startActivity(intent);
				        	Log.i(TAG, "List of intents found: "+list.toString());
				   
				        }
				        else{
				        	Log.i(TAG,"No intent found.");
				        	
				        }
				}
				
			});		
			
	}
	
	/**
	 * Creates Intent that starts camera
	 * */
	public Intent createCameraIntent()
	{
		Intent intent = new Intent();
		
		return intent;
	}

	/**
	 * Creates Intent that starts web search 
	 * */
	public Intent createAlarmIntent(String message,int hour, int minutes)
	{
		 Intent intent = new Intent();
		 intent.setAction(AlarmClock.ACTION_SET_ALARM);
		 intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
         intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
         intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
         intent.putExtra(AlarmClock.EXTRA_SKIP_UI, false);
         
         
         
         
         return intent;
	}

	/**
	 * Creates Intent that sends a text message
	 * */
	
	public Intent createSMSIntent(String message)
	{
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_SENDTO);
		intent.setType(HTTP.PLAIN_TEXT_TYPE);
		intent.putExtra("sms_body", message);
				
		return intent;
	}

	/**
	 * Creates Intent that sends a text message
	 * */
	public Intent createSettingsIntent()
	{
		Intent intent = new Intent();
		intent.putExtra("sms_body", "Mobile Programming");
				
		return intent;
	}



}
