package jmc.android_course.intents;

//import jmc.android_course.activity_assignment.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;



public class ImplicitActivity extends Activity {
	public final static String TAG = "Intents and Permissions Assignment"; //Main Activity TAG
	public final static String IMPLICIT_MESSAGE ="Implicit Intent Detected";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.implicit_activity);
		//getting incoming intent
		Intent intent = getIntent();
		
		//checking if intent has extra field  MainActivity.EXTRA_CUSTOM_MESSAGE_TAG
		if(intent.hasExtra(MainActivity.EXTRA_CUSTOM_MESSAGE_TAG)){
			Bundle bundle = intent.getExtras();
			String message = (String) bundle.get(MainActivity.EXTRA_CUSTOM_MESSAGE_TAG);
			if(message!=null){
				Log.i(TAG, IMPLICIT_MESSAGE) ;			
			}
		}
	}
}
