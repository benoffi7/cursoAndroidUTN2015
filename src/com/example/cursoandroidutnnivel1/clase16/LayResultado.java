package com.example.cursoandroidutnnivel1.clase16;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class LayResultado extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Toast.makeText(getApplicationContext(), getIntent().getExtras().getString("resultado"), Toast.LENGTH_SHORT).show();
	}
}
