package jmc.android_course.intents;

//import jmc.android_course.activity_assignment.R;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
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

	   final Button mdata_btn = (Button) findViewById(R.id.data_intent_btn);
		mdata_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				Uri uri = Uri.parse("android.resource://"+getPackageName()+"/drawable/ic_launcher");
				intent.setData(uri);
				intent.setAction(Intent.ACTION_CALL);
				 PackageManager pm = getPackageManager();
			        List<ResolveInfo> list = pm.queryIntentActivities(intent,
			                PackageManager.MATCH_DEFAULT_ONLY);
			        if (list.size() > 0){
			        	startActivity(intent);
			        }
			        else{
			        	Log.i(TAG,"No intent found.");			        	
			        }
			}
		});		
		
		 final Button mcall_btn = (Button) findViewById(R.id.call_intent_btn);
		 mcall_btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_PICK);
					intent.addCategory(Intent.CATEGORY_APP_CALENDAR);
					
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

	


}
