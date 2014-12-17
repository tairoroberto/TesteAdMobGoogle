package com.example.testeadmobgoogle;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class MainActivity extends ActionBarActivity {
	private AdView adView1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adView1 = new AdView(this);
		adView1.setAdUnitId("ca-app-pub-5552810602868197/8500276065");
		adView1.setAdSize(AdSize.BANNER);
		
		//Add o adview ao layout pai
		LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
		layout.addView(adView1);
		
		AdRequest adRequest = new AdRequest.Builder()		 //Add para teste, senão BLOQUEIA conta AdMOB
		.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // Todos os emuladores
	    .addTestDevice("17C60D1DCCB2F4989D9B40BA71B45761") // Meu telefone de teste Galaxy Nexus
	    .build();;
		adView1.loadAd(adRequest);
		
		// Consultar o AdView como um recurso e carregar uma solicitação.
	    AdView adView2 = (AdView)this.findViewById(R.id.adView);
	    
	    AdRequest request = new AdRequest.Builder()			 //Add para teste, senão BLOQUEIA conta AdMOB
	    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // Todos os emuladores
	    .addTestDevice("17C60D1DCCB2F4989D9B40BA71B45761") // Meu telefone de teste Galaxy Nexus
	    .build();
	    
	    adView2.loadAd(request);
	    
	    
	}

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
