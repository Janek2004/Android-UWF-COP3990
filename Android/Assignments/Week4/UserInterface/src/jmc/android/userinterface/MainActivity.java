package jmc.android.userinterface;

import android.support.v7.app.ActionBarActivity;

import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	public EditText number1;
	public EditText number2;
	public TextView result;
	public AlertDialog alertDialog;
	public Context mContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button addBtn = (Button) findViewById(R.id.add);
		final Button eraseBtn = (Button) findViewById(R.id.erase);
		result = (TextView) findViewById(R.id.result);
		number1 = (EditText) findViewById(R.id.number1);
		number2 = (EditText) findViewById(R.id.number2);	
		mContext = this;
		
		addBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int n1 = Integer.parseInt(number1.getText().toString());
				int n2 = Integer.parseInt(number2.getText().toString());
				showResult(add(n1,n2));
			}
		});
		
		eraseBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
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
				
				alertDialog =	builder.create();	
				alertDialog.show();

			}
		});
		
		
	}

	//Mathematical Operations

	public int add(int n1, int n2){
		
		
		return -1;
	}
	
	public int subtract(int n1, int n2){
		
		return -1;
	}
	
	public int multiply(int n1, int n2){
		
		return -1;
	}
	
	public int divide(int n1, int n2){
		
		return -1;
	}
	
	//showing the result using Toast
	public void showToastMessage(String message){
		
		Toast t = Toast.makeText(mContext,message , Toast.LENGTH_LONG);
		t.setGravity(Gravity.CENTER,0,0);
		t.show();				
	}
	
	public void showResult(int _result){
		String string_result = Integer.toString(_result);
		result.setText(string_result);	
		showToastMessage(string_result);
	}
	
	//Erasing the fields
	public void eraseAll(){
		//confirm that you really want to erase the UI			
		number1.setText("");
		number2.setText("");
		result.setText("");
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
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
}
