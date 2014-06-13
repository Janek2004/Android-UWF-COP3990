package jmc.android_course.intents.test;

import java.util.ArrayList;
import java.util.Calendar;

import jmc.android_course.intents.MainActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.test.ActivityUnitTestCase;

public class LaunchActivityTest extends ActivityUnitTestCase<MainActivity> {
	
	public LaunchActivityTest() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	public Intent launchIntent;  
	public MainActivity activity;
	
	
	@Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        launchIntent = new Intent(getInstrumentation()
	                .getTargetContext(), MainActivity.class);
	        startActivity(launchIntent, null, null);
	        activity = getActivity();	        
	}
	
	public void testAlarmIntent(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(Calendar.MONDAY);
		list.add(Calendar.FRIDAY);
		
		Intent intent  = activity.createAlarmIntent( MainActivity.MESSAGE, list, MainActivity.HOUR,  MainActivity.MINUTES);
		assertTrue("Expected "+ MainActivity.MESSAGE, intent.getExtras().get(AlarmClock.EXTRA_MESSAGE).equals( MainActivity.MESSAGE));
		assertTrue("Expected days: "+ list.toString(), intent.getExtras().get(AlarmClock.EXTRA_DAYS).equals( list));
		assertTrue("Expected hour: "+ MainActivity.HOUR, intent.getExtras().getInt(AlarmClock.EXTRA_HOUR)== MainActivity.HOUR);
		assertTrue("Expected minutes: "+ MainActivity.HOUR, intent.getExtras().getInt(AlarmClock.EXTRA_MINUTES)== MainActivity.MINUTES);
	}
	
	public void testWebSearchIntent()
	{
		Intent intent  = activity.createSearchIntent();
		assertTrue("Expected "+ Intent.ACTION_WEB_SEARCH +" action received: "+intent.getAction(), intent.getAction().equals(Intent.ACTION_WEB_SEARCH));
		
		Bundle b = intent.getExtras();
		String query =	(String) b.get(SearchManager.QUERY);
		assertTrue(" Expected "+MainActivity.UWF_URL+ " received "+query, query.equals(MainActivity.UWF_URL));
		
		
		
	}
	
	public void testImplicitIntent(){
		Intent intent  = activity.createImplicitIntent();
		assertTrue("Expected "+ MainActivity.ACTION_CUSTOM +" action received: "+intent.getAction(), intent.getAction().equals(MainActivity.ACTION_CUSTOM));
		
		Bundle b = intent.getExtras();
		String query =	(String) b.get(MainActivity.EXTRA_CUSTOM_MESSAGE_TAG);
		assertTrue(" Expected "+MainActivity.EXTRA_CUSTOM_MESSAGE+ " received "+query, query.equals(MainActivity.EXTRA_CUSTOM_MESSAGE));
		
	}
}
