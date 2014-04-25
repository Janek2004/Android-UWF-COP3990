/**
 * @author Janusz Chudzynski
 * 
 * */
package jmc.android_course.activity_assignment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {
	private static final String TAG = "Activity Assignment";
	
	public final static String mOnCreate = "OnCreate Second Activity";
	public final static String mOnStart = "OnStart Second Activity";
	public final static String mOnResume = "OnResume Second Activity";
	public final static String mOnPause = "OnPause Second Activity";
	public final static String mOnStop = "OnStop Second Activity";
	public final static String mOnDestroy = "OnDestroy Second Activity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		//call super 
		super.onCreate(savedInstanceState);
		Log.i(TAG,mOnCreate);
		setContentView(R.layout.second_activity);
		//instantiate UI elements
		final Button mreturn_button = (Button) findViewById(R.id.return_btn);
		final Button ok_results_button = (Button)findViewById(R.id.return_results_ok_btn);
		final Button cancelled_results_button = (Button)findViewById(R.id.return_results_cancelled_btn);
		
		//set action listeners
		mreturn_button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			// TODO Auto-generated method stub
				finish();
				
			}
		});
	
		ok_results_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
			// TODO Auto-generated method stub
				setResult(Activity.RESULT_OK);
				finish();
			}
		});	
		
		cancelled_results_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
			// TODO Auto-generated method stub
				setResult(Activity.RESULT_CANCELED);
				finish();
			}
		});		
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
	
	
}
