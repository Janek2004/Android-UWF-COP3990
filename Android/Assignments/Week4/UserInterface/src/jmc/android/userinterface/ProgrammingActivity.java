package jmc.android.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProgrammingActivity extends Activity {

	public ProgrammingActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override 
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		LayoutParams layoutViewLayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT ) ;
		LayoutParams textViewLayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT ) ;
	
		LinearLayout ll = new LinearLayout(this);
		TextView tv = new TextView(this);

		ll.setId(View.generateViewId());
		ll.setLayoutParams(layoutViewLayoutParams);		
		
		tv.setLayoutParams(textViewLayoutParams);
		tv.setId(View.generateViewId());
		tv.setText("Mobile Programming");
		
		ll.addView(tv);
		setContentView(ll);
		
	}
}
