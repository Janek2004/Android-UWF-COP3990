/**
 * @author Janusz Chudzynski
 * 
 * */
package jmc.android_course.activity_assignment;
//import com.example.activityassignment.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	public final static int MAIN_ACTIVITY_REQUEST_CODE = 0;
	public final static String TAG = "Activity Assignment"; //Main Activity TAG
	
	//lifecycle
	public final static String mOnCreate = "OnCreate Main Activity";
	public final static String mOnStart = "OnStart Main Activity";
	public final static String mOnResume = "OnResume Main Activity";
	public final static String mOnPause = "OnPause Main Activity";
	public final static String mOnStop = "OnStop Main Activity";
	public final static String mOnDestroy = "OnDestroy Main Activity";

	//activity results
	public final static String mResultOk = "Main Activity Result OK";
	public final static String mResultCancelled = "Main Activity Result Cancelled";
	
	
	//Life Cycle Methods	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		//call super 
		super.onCreate(savedInstanceState);
		Log.i(TAG, mOnCreate);
		setContentView(R.layout.main_activity);
		
		//instantiate UI elements
		final Button mstart_activity_button = (Button) findViewById(R.id.activity_button);
		final Button mstart_activity_for_results_button = (Button)findViewById(R.id.activity_for_results_button);
		
		//set action listeners
		mstart_activity_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Create an intent and display second activity
				Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
				startActivity(intent);
			}
		});
		
		mstart_activity_for_results_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Creating intent and display second activity using startActivityForResult method
				Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
				 startActivityForResult(intent, MAIN_ACTIVITY_REQUEST_CODE);
				 
			}});
	}	
	
	//Lifecycle methods
	
	@Override
	protected void onStart(){
		super.onStart();
		Log.i(TAG,mOnStart);
	}
	
	@Override
	protected void onStop(){
		super.onStop();
		Log.i(TAG,mOnStop);	
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		Log.i(TAG,mOnPause);		
	}
	@Override
	protected void onResume(){
		super.onResume();
		Log.i(TAG,mOnResume);		
	}	
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		Log.i(TAG,mOnDestroy);		
	}
	
	//Receives results from Activities
	@Override 
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		//Check request code
		if(requestCode == MAIN_ACTIVITY_REQUEST_CODE){
			//check for result 
			if(resultCode == Activity.RESULT_OK){
				Log.i(TAG, mResultOk);	
			}
			else if(resultCode == Activity.RESULT_CANCELED){
				Log.i(TAG, mResultCancelled);				
			}
		}
	}	
}
