package jmc.android.userinterface;

import android.support.v7.app.ActionBarActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	
	public static final String TAG = "User Interface Assignment";
	public Context mContext;	
	public TextView resultTextView;
	public EditText number1Text;
	public EditText number2Text; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button addBtn = (Button) findViewById(R.id.add);
		final Button multiplyBtn = (Button) findViewById(R.id.multiply);
		final Button divide = (Button) findViewById(R.id.divide);
		final Button eraseBtn = (Button) findViewById(R.id.erase);
		final Button subtractBtn = (Button) findViewById(R.id.subtract);
		
		
		number1Text = (EditText) findViewById(R.id.number1);
		number2Text = (EditText) findViewById(R.id.number2);
		resultTextView = (TextView) findViewById(R.id.result);
		mContext = this;
		
		 subtractBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int n1 = Integer.parseInt(number1Text.getText().toString());
				int n2 = Integer.parseInt(number2Text.getText().toString());
				String string_result = Integer.toString(subtract(n1,n2));
				
				showResult(string_result);
			}
		});
		
		
		multiplyBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int n1 = Integer.parseInt(number1Text.getText().toString());
				int n2 = Integer.parseInt(number2Text.getText().toString());
				
				String string_result = Integer.toString(multiply(n1,n2));
				showResult(string_result);
			}
		});
		
		
		divide.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int n1 = Integer.parseInt(number1Text.getText().toString());
				int n2 = Integer.parseInt(number2Text.getText().toString());
				String string_result = Double.toString(divide(n1,n2));	
				showResult(string_result);
			}
		});
		
		
		addBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int n1 = Integer.parseInt(number1Text.getText().toString());
				int n2 = Integer.parseInt(number2Text.getText().toString());
				String string_result = Integer.toString(add(n1,n2));
				showResult(string_result);
			}
		});
		
		eraseBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
								
				AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
				builder.setTitle("Alert");
				builder.setMessage("Do you want to proceed?");
				builder.setNegativeButton("NO", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}		
				});
				builder.setPositiveButton("YES", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						eraseAll();
					}		
				});
				
				AlertDialog alertDialog =	builder.create();	
				alertDialog.show();

			}
		});
		
		
		
		
		
	}

//Mathematical Operations
	public int add(int n1, int n2){
		
		
		return n1+n2;
	}
	
	public int subtract(int n1, int n2){
		
		return n1-n2;
	}
	
	public int multiply(int n1, int n2){
		
		return n1*n2;
	}
	
	public double divide(int n1, int n2){
		if(n2==0)	return -1;
		double _n1=n1*1.0;
		double _n2=n2*1.0;

		return _n1/_n2;
	}
	
	//showing the result using Toast
	public void showToastMessage(String message){
		
		Toast t = Toast.makeText(mContext,message , Toast.LENGTH_LONG);
		t.setGravity(Gravity.CENTER,0,0);
		t.show();				
	}
	
	public void showResult(String result){
		resultTextView.setText(result);	
		showToastMessage(result);
	}
	
	//Erasing the fields
	public void eraseAll(){
		//confirm that you really want to erase the UI			
		number1Text.setText("");
		number2Text.setText("");
		resultTextView.setText("");
	}
	
	
//Action Bar
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
				
		if (id == R.id.action_settings) {
			Intent i = new Intent(this, HelpActivity.class);
			startActivity(i);
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
}
