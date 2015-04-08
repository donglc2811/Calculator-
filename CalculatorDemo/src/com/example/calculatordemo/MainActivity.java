package com.example.calculatordemo;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView;
 
public class MainActivity extends Activity implements OnClickListener {
	
	final static String LOG_TAG = MainActivity.class.getSimpleName();
	
	Button  mnine, meig, msev, msix, mfiv, mfour, 
			mthr, mtwo, mone, mzero, mdot, mplus,
			mmins, mdiv, mmul, meq, mcl;
	TextView met;
	String ms = "0";
	int mresult = 0;
	char mlO = ' ';
	 
	 
	// Call when activity start
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// set button map with layout
		mnine = (Button) findViewById(R.id.b9);
		meig = (Button) findViewById(R.id.b8);
		msev = (Button) findViewById(R.id.b7);
		msix = (Button) findViewById(R.id.b6);
		mfiv = (Button) findViewById(R.id.b5);
		mfour = (Button) findViewById(R.id.b4);
		mthr = (Button) findViewById(R.id.b3);
		mtwo = (Button) findViewById(R.id.b2);
		mone = (Button) findViewById(R.id.b1);
		mzero = (Button) findViewById(R.id.b0);
		mdot = (Button) findViewById(R.id.bd);
		mplus = (Button) findViewById(R.id.bpl);
		mmins = (Button) findViewById(R.id.bmin);
		mdiv = (Button) findViewById(R.id.bdiv);
		mmul = (Button) findViewById(R.id.bmul);
		meq = (Button) findViewById(R.id.beq);
		mcl = (Button) findViewById(R.id.bcl);
		met = (TextView) findViewById(R.id.tv);

		// set onlick listener
		mnine.setOnClickListener(this);
		meig.setOnClickListener(this);
		msev.setOnClickListener(this);
		msix.setOnClickListener(this);
		mfiv.setOnClickListener(this);
		mfour.setOnClickListener(this);
		mthr.setOnClickListener(this);
		mtwo.setOnClickListener(this);
		mone.setOnClickListener(this);
		mzero.setOnClickListener(this);
		mdot.setOnClickListener(this);
		mplus.setOnClickListener(this);
		mmins.setOnClickListener(this);
		mdiv.setOnClickListener(this);
		mmul.setOnClickListener(this);
		meq.setOnClickListener(this);
		mcl.setOnClickListener(this);
		met.setOnClickListener(this);
		
		Log.d(LOG_TAG, "Oncreate");
	}

	@Override
	public void onClick(View v) {
		// set id button for cases
		switch (v.getId()) {
		case R.id.b0:
		case R.id.b1:
		case R.id.b2:
		case R.id.b3:
		case R.id.b4:
		case R.id.b5:
		case R.id.b6:
		case R.id.b7:
		case R.id.b8:
		case R.id.b9:
		case R.id.bd:	
		 
			// get value from button and tranfer to string
			String inDigit = ((Button) v).getText().toString();
			if (ms.equals("0")) {
				ms = inDigit;
			} else {
				ms += inDigit;
			}
			met.setText(ms);
			if (mlO == '=') {
				mresult = 0;
				mlO = ' ';
			}
			break;
		case R.id.bpl:
			compute();
			mlO = '+';
			break;
		case R.id.bmin:
			compute();
			mlO = '-';
			break;
		case R.id.bdiv:
			
			compute();
			mlO = '/';
			Log.d("test_debug", "division");
			break;
		case R.id.bmul:
			compute();
			mlO = '*';
			break;
		case R.id.beq:
			compute();
			mlO = '=';
			break;
		case R.id.bcl:
			mresult = 0;
			ms = "0";
			mlO = ' ';
			met.setText("0");
			break;
		 
		}
		Log.d("test_debug","on click");
	}

	private void compute()  {
		// get the String in button to number value
		int inNum = Integer.parseInt(ms);
		ms = "0";
		if (mlO == ' ') {
			mresult = inNum;
		} else if (mlO == '+') {
			mresult += inNum;
		} else if (mlO == '-') {
			mresult -= inNum;
		} else if (mlO == '*') {
			mresult *= inNum;
		} else if (mlO == '/' && !ms.equals("0")) {
			mresult /= inNum;
		} else if (mlO == '=') {
			// Keep the result for the next operation
		}
		met.setText(String.valueOf(mresult));
		Log.d("test_debug", "value");
	}
}