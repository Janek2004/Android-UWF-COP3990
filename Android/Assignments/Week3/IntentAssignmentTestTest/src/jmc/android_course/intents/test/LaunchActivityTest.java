package jmc.android_course.intents.test;

import java.util.ArrayList;
import java.util.Calendar;

import jmc.android_course.intents.MainActivity;
import android.content.Intent;
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
}
