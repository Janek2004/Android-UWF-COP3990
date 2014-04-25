package jmc.android.activityassignment.test;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;
import jmc.android_course.activity_assignment.MainActivity;


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
	    
	    
	  } // end of setUp() method definition

	
	 public void testOrientationChanges(){
		 assertTrue("Main Activity  is not found!",
		 solo.waitForActivity(jmc.android_course.activity_assignment.MainActivity.class));
		 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnCreate ,timeout); 
		 solo.setActivityOrientation(Solo.LANDSCAPE);
		 
		 assertTrue("Expected onPause",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnPause,timeout));
		 
		 assertTrue("Expected onStop",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnStop,timeout));
	
		 assertTrue("Expected onDestroy",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnDestroy,timeout));

		 assertTrue("Expected onCreate",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnCreate,timeout));
		 
		 assertTrue("Expected onStart",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnStart,timeout));
		 
		 assertTrue("Expected onResume",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnResume,timeout));
	 
		 solo.setActivityOrientation(Solo.PORTRAIT);
		 
		 assertTrue("Expected onPause",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnPause,timeout));
		 
		 assertTrue("Expected onStop",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnStop,timeout));
	
		 assertTrue("Expected onDestroy",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnDestroy,timeout));

		 assertTrue("Expected onCreate",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnCreate,timeout));
		 
		 assertTrue("Expected onStart",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnStart,timeout));
		 
		 assertTrue("Expected onResume",
				 solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mOnResume));
		 
	 
	 }
	 
	 @Override
	   public void tearDown() throws Exception {
	        solo.finishOpenedActivities();
	  } 
}
