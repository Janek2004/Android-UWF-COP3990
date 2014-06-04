package jmc.android_course.intents.test;

import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import jmc.android_course.intents.ImplicitActivity;
import jmc.android_course.intents.MainActivity;

public class MainTest extends ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;
	private static int timeout = 5000;
	//Default Constructor
	public MainTest(){
		super(MainActivity.class);
	}
	
	
	@Override
	  protected void setUp() throws Exception {
	    super.setUp();
	    setActivityInitialTouchMode(true);
	    solo = new Solo(getInstrumentation(), getActivity());
	  } 
	
	public void testImplicitIntent() throws InterruptedException{

		
			assertTrue("Main Activity  is not found!",
			solo.waitForActivity(MainActivity.class));	
			solo.clickOnView(solo.getView(jmc.android_course.intents.R.id.implicit_intent_btn));
			assertTrue("Implicit Activity  is not found!",
					 solo.waitForActivity(ImplicitActivity.class));
			assertTrue("Expected Message: ",
					 solo.waitForLogMessage(ImplicitActivity.IMPLICIT_MESSAGE,timeout));
						
	}
}
