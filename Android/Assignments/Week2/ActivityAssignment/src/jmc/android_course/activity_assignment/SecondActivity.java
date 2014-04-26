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
				// TODO finish the activity
				
			}
		});
	
		ok_results_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
			// TODO set the result to Activity.RESULT_OK and finish the activity
			
			}
		});	
		
		cancelled_results_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO set the result to Activity.RESULT_CANCELLED and finish the activity
				
			}
		});		
	}
	
	//TODO Add Lifecycle methods and appropriate log statements, use onStart method overriden below as an example
	@Override
	protected void onStart(){
		super.onStart();
		Log.i(TAG,mOnStart);
	}
	
}
