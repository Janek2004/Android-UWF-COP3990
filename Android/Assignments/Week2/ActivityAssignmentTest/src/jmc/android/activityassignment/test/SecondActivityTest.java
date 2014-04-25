package jmc.android.activityassignment.test;
import com.robotium.solo.*;

import android.test.ActivityInstrumentationTestCase2;
import jmc.android_course.activity_assignment.MainActivity;


public class SecondActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;
	private static int timeout = 5000;

	public SecondActivityTest() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
	    super.setUp();
	    setActivityInitialTouchMode(true);
	    solo = new Solo(getInstrumentation(), getActivity());	    
	  } // end of setUp() method definition
	
	public void testWithoutResults(){
		//Click on the start activity button: 
			solo.clickOnView(solo.getView(jmc.android_course.activity_assignment.R.id.activity_button));
			//second activity should be created
			assertTrue("Second Activity not found!", solo.waitForActivity(jmc.android_course.activity_assignment.SecondActivity.class));

			assertTrue("Expected onPause",
			solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnPause,timeout));

			assertTrue("Expected onCreate",
			solo.waitForLogMessage(jmc.android_course.activity_assignment.SecondActivity.mOnCreate,timeout));
			
			assertTrue("Expected onStart",
			solo.waitForLogMessage(jmc.android_course.activity_assignment.SecondActivity.mOnStart,timeout));

			assertTrue("Expected onResume",
					solo.waitForLogMessage(jmc.android_course.activity_assignment.SecondActivity.mOnResume,timeout));
			
			assertTrue("Expected onStop",
					solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnStop,timeout*50));

			// Return to the first activity
			solo.clickOnView(solo.getView(jmc.android_course.activity_assignment.R.id.return_btn));

			assertTrue("Expected onPause",
			solo.waitForLogMessage(jmc.android_course.activity_assignment.SecondActivity.mOnPause,timeout));
					
			assertTrue("Expected onStart",
			solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnStart,timeout));

			assertTrue("Expected onResume",
			solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnResume,timeout));
					
			assertTrue("Expected onStop",
			solo.waitForLogMessage(jmc.android_course.activity_assignment.SecondActivity.mOnStop,timeout));

			assertTrue("Expected onDestroy",
					solo.waitForLogMessage(jmc.android_course.activity_assignment.SecondActivity.mOnDestroy,timeout));				
	}
}