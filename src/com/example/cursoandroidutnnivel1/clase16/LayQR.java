package com.example.cursoandroidutnnivel1.clase16;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LayQR extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		  IntentIntegrator integrator = new  IntentIntegrator(LayQR.this);
		  integrator.initiateScan();

		  Intent intento = new Intent (LayQR.this,CaptureActivity.class);
		  intento.putExtra(com.google.zxing.client.android.Intents.Scan.MODE,com.google.zxing.client.android.Intents.Scan.QR_CODE_MODE);
		  startActivity(intento);
	}
}
