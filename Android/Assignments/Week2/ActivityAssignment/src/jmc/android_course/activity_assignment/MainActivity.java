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
				// TODO Create an intent and display second activity
				
			}
		});
		
		mstart_activity_for_results_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//TODO: Create an intent and display second activity using startActivityForResult method
				// use MAIM_ACTIVITY_REQUEST_CODE as request code
				 
			}});
	}	
	
	//TODO Add Lifecycle methods and appropriate log statements, use onStart method overriden below as an example
	
	@Override
	protected void onStart(){
		super.onStart();
		Log.i(TAG,mOnStart);
	}
	
	//Receives results from Activities
	@Override 
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);

		//Check request code
		if(requestCode == MAIN_ACTIVITY_REQUEST_CODE){
			//TODO: Check activity resultCode: use if-else statement to log content of the mResultOK if the returned value is equal to Activity.RESULT_OK, 
			//and  log content of the mResultCancelled if the returned value is equal to Activity.RESULT_CANCELLED

		}
	}	
}
