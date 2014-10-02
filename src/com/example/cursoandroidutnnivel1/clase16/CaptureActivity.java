package com.example.cursoandroidutnnivel1.clase16;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.zxing.Result;
import com.google.zxing.client.android.result.ResultHandler;

public class CaptureActivity extends com.google.zxing.client.android.CaptureActivity 
{
	boolean scan = false;
	
	@Override
	public void handleDecodeInternally(Result rawResult, ResultHandler resultHandler, Bitmap barcode) 
	{
		scan = true;
		Intent intento = new Intent(CaptureActivity.this,LayResultado.class);
		intento.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intento.putExtra("resultado", resultHandler.getDisplayContents().toString());
		startActivity(intento);
	}
	
	@Override
	public void onCreate(Bundle icicle)
	{
		scan = false;
		super.onCreate(icicle);
	}
	
	@Override
	protected void onResume()
	{
		if (scan)
		{
			finish();
		}
		super.onResume();
	}
}
