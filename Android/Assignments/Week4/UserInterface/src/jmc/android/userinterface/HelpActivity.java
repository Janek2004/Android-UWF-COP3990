package jmc.android.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelpActivity extends Activity {
	public static final String TAG = "User Interface Assignment";
	public static final String onCreateMessage = "Inside onCreate method in Help Activity";
	public static final String onClickMessage = "Inside the onClick in  Help Activity";
	
	
	public HelpActivity() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help_layout);		
		Log.i(TAG, onCreateMessage);

		final Button button = (Button)findViewById(R.id.dismissBtn);
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {

 				Log.i(TAG, onClickMessage);
				finish();
			}
				
			
		});
		
	}

}
