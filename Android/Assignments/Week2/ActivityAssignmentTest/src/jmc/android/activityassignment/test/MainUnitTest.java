package jmc.android.activityassignment.test;

import jmc.android_course.activity_assignment.MainActivity;
import android.app.Instrumentation;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class MainUnitTest extends InstrumentationTestCase {

	private static final String LOG_TAG = MainActivity.class.getSimpleName();
	private Instrumentation instr;
	public MainUnitTest() {
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void setUp() throws Exception {
	    instr = getInstrumentation();
	    Log.d(LOG_TAG, "setUp instrumentation: " + instr);

	    super.setUp();

	    instr = getInstrumentation();
	    Log.d(LOG_TAG, "setUp instrumentation: " + instr);
	}

	public void testInstrumentation() {
	    Log.d(LOG_TAG, "testInstrumentation instrumentation: " + instr);
	}

}



