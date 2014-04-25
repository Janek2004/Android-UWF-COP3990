package jmc.android.activityassignment.test;
import com.robotium.solo.*;

import android.test.ActivityInstrumentationTestCase2;
import jmc.android_course.activity_assignment.MainActivity;

public class ResultsTest extends ActivityInstrumentationTestCase2<MainActivity>{
	private Solo solo;
	private static int timeout = 5000;
	
	public ResultsTest() {
		super(MainActivity.class);
	}

	@Override
	  protected void setUp() throws Exception {
	    super.setUp();
	    setActivityInitialTouchMode(true);
	    solo = new Solo(getInstrumentation(), getActivity());
	    
	    
	  } // end of setUp() method definition
	
	public void testResults(){
		
		
		 assertTrue("Main Activity  is not found!",
				 solo.waitForActivity(jmc.android_course.activity_assignment.MainActivity.class));
		 
		solo.clickOnView(solo.getView(jmc.android_course.activity_assignment.R.id.activity_for_results_button));
		 assertTrue("Second Activity  is not found!",
				 solo.waitForActivity(jmc.android_course.activity_assignment.SecondActivity.class));
		 solo.clickOnView(solo.getView(jmc.android_course.activity_assignment.R.id.return_results_ok_btn));
		
		 assertTrue("Expected Result OK",
			solo.waitForLogMessage(jmc.android_course.activity_assignment.MainActivity.mResultOk,timeout));

		 
		 
		
	}
}
