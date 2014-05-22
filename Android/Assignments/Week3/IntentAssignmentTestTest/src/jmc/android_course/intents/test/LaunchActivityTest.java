package jmc.android_course.intents.test;
import org.apache.http.protocol.HTTP;

import jmc.android_course.intents.MainActivity;
import android.content.Intent;
import android.os.Bundle;
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
	
	public void testSMS(){
		Intent intent=activity.createSMSIntent(MainActivity.TAG);
		Bundle b =  intent.getExtras();
		String message= (String) b.get("sms_body");
		assertTrue("Expected "+MainActivity.TAG, MainActivity.TAG.equals(message));
		assertTrue("Expected Action:"+Intent.ACTION_SEND, Intent.ACTION_SENDTO.equals(intent.getAction()));
		assertTrue("Expected Type "+ HTTP.PLAIN_TEXT_TYPE, intent.getType().equals(HTTP.PLAIN_TEXT_TYPE));	
	}
	
	public void testCalandar(){
		Intent intent=activity.createSMSIntent(MainActivity.TAG);
		Bundle b =  intent.getExtras();
		String message= (String) b.get("sms_body");
		assertTrue("Expected "+MainActivity.TAG, MainActivity.TAG.equals(message));
		assertTrue("Expected Action:"+Intent.ACTION_SEND, Intent.ACTION_SENDTO.equals(intent.getAction()));
		assertTrue("Expected Type "+ HTTP.PLAIN_TEXT_TYPE, intent.getType().equals(HTTP.PLAIN_TEXT_TYPE));	
		
		
	
	}
	
	
}
