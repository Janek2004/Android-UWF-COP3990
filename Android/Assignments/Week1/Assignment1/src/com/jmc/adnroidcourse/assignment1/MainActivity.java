package com.jmc.adnroidcourse.assignment1;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private final static String TAG = "Android-Assignent 1";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(TAG, "Info Hello Android!");
		Log.v(TAG, "Verbose Hello Android!");
		Log.e(TAG, "Error Hello Android!");
		Log.d(TAG, "Debug Hello Android!");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}