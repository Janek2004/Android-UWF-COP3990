package jmc.android.userinterface.test;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import jmc.android.userinterface.MainActivity;
import jmc.android.userinterface.HelpActivity;
import jmc.android.userinterface.R;

public class MainTest extends ActivityInstrumentationTestCase2<MainActivity> {

	public MainTest(Class<MainActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}
	
	private Solo solo;
	private static int timeout = 2000;
	
	Button addBtn;
	Button subtractBtn;
	Button multiplyBtn;
	Button divideBtn;
	
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
	
	 @Override
	    public void tearDown() throws Exception {
	        solo.finishOpenedActivities();
	    }
	
	
	public void testAddition() throws InterruptedException{
		//clear 
		solo.waitForActivity(MainActivity.class);
		EditText n1 = (EditText) solo.getView(R.id.number1);
		EditText n2 = (EditText) solo.getView(R.id.number2);
	
		solo.enterText(n1, "2");
		solo.enterText(n2, "3");
		
	    solo.clickOnView(solo.getView(R.id.add));	    
	    
	    TextView result = (TextView) solo.getView(R.id.result);
	   
	    solo.sleep(timeout);
	    
	    assertTrue("Wrong result! Expected 5 got "+result.getText().toString(), result.getText().toString().equals("5"));
	   
	}	
	
	
	public void testMultiplication() throws InterruptedException{
		TextView result = (TextView) solo.getView(R.id.result);
		
		
		solo.waitForActivity(MainActivity.class);
	
		EditText n1 = (EditText) solo.getView(R.id.number1);
		EditText n2 = (EditText) solo.getView(R.id.number2);
	
		solo.enterText(n1, "2");
		solo.enterText(n2, "3");
		
	    solo.clickOnView(solo.getView(R.id.multiply));	    
	    solo.sleep(timeout);
	    assertTrue("Wrong result! Expected 6 got "+result.getText().toString(), result.getText().toString().equals("6"));
	   
	}
	
	
	public void testDivision() throws InterruptedException{
		TextView result = (TextView) solo.getView(R.id.result);
			
		solo.waitForActivity(MainActivity.class);
	
		EditText n1 = (EditText) solo.getView(R.id.number1);
		EditText n2 = (EditText) solo.getView(R.id.number2);
	
		solo.enterText(n1, "2");
		solo.enterText(n2, "0");
		
	    solo.clickOnView(solo.getView(R.id.divide));	    
	    solo.sleep(timeout);
	    assertTrue("Wrong result! Expected -1.0 got "+result.getText().toString(), result.getText().toString().equals("-1.0"));
	   
	}
	
	
	public void testSubtraction() throws InterruptedException{
		TextView result = (TextView) solo.getView(R.id.result);
			
		solo.waitForActivity(MainActivity.class);
	
		EditText n1 = (EditText) solo.getView(R.id.number1);
		EditText n2 = (EditText) solo.getView(R.id.number2);
	
		solo.enterText(n1, "2");
		solo.enterText(n2, "1");
		
	    solo.clickOnView(solo.getView(R.id.subtract));	    
	    solo.sleep(timeout);
	    assertTrue("Wrong result! Expected 1 got "+result.getText().toString(), result.getText().toString().equals("1"));
	   	    
	}
	
	public void testActionButton(){
		
		solo.waitForActivity(MainActivity.class);		
		//R.menu.main;
		View action_settings = solo.getView(R.id.action_settings);
		solo.clickOnView(action_settings);
		solo.waitForActivity(HelpActivity.class);
		assertTrue("Expected different message", solo.waitForLogMessage(HelpActivity.onCreateMessage,timeout));
		solo.clickOnView(solo.getView(R.id.dismissBtn));	
		assertTrue("Expected different message", solo.waitForLogMessage(HelpActivity.onClickMessage,timeout));
		solo.waitForActivity(MainActivity.class);	
		assertTrue("Expected different message", solo.waitForLogMessage(MainActivity.onCreateMessage,timeout));
			
	}
	
	public void testClearAndDialog()
	{
		solo.waitForActivity(MainActivity.class);	
		EditText n1 = (EditText) solo.getView(R.id.number1);
		EditText n2 = (EditText) solo.getView(R.id.number2);
		TextView result = (TextView) solo.getView(R.id.result);
		
		solo.enterText(n1, "2");
		solo.enterText(n2, "1");
		
		solo.clickOnView(solo.getView(R.id.erase));
		solo.clickOnButton("YES");
		solo.waitForDialogToClose();
		assertTrue("Wrong result!", result.getText().toString().equals(""));
		assertTrue("Wrong result "+n1.getText().toString(), n1.getText().toString().equals(""));
		assertTrue("Wrong result!"+n2.getText().toString(), n2.getText().toString().equals(""));
	
		solo.enterText(n1, "2");
		solo.enterText(n2, "1");
		
		solo.clickOnView(solo.getView(R.id.erase));
		solo.clickOnButton("NO");
		solo.waitForDialogToClose();
		assertTrue("Wrong result!", n1.getText().toString().equals("2"));
		assertTrue("Wrong result!", n2.getText().toString().equals("1"));
		

	}
	
	
	
	
}
