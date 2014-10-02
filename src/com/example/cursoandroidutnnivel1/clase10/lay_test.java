package com.example.cursoandroidutnnivel1.clase10;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.cursoandroidutnnivel1.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class lay_test extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.test);
		ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);

		DisplayImageOptions options = new DisplayImageOptions.Builder()
		.showImageOnLoading(R.drawable.ic_launcher)
		.showImageForEmptyUri(R.drawable.ic_launcher)
		.showImageOnFail(R.drawable.ic_launcher)
		.displayer(new RoundedBitmapDisplayer(10))
		.cacheInMemory(false)
		.build();

		ImageLoader.getInstance()
		.displayImage("http://bucket3.clanacion.com.ar/anexos/fotos/45/mundial-brasil-2014-1897745w620.jpg", imageView1,options);
		

		super.onCreate(savedInstanceState);
	}
}
