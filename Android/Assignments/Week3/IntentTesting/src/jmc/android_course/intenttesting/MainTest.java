package jmc.android_course.intenttesting;
import android.test.ActivityInstrumentationTestCase2;
import jmc.android_course.intents.MainActivity;

import com.robotium.solo.*;


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
}
