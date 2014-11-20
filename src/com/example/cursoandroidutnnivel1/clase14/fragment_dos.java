package com.example.cursoandroidutnnivel1.clase14;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.cursoandroidutnnivel1.R;

public class fragment_dos extends Fragment
{
	private View rootView;
	CheckBox checkBox1;
	private int pos;
	private String titulo;

	public fragment_dos()
	{
		// Empty constructor required for fragment subclasses
	}

	// newInstance constructor para crear fragmentos con argumentos
	public static fragment_dos newInstance(int page, String title)
	{
		fragment_dos fragmentFirst = new fragment_dos();
		Bundle args = new Bundle();
		args.putInt("pos", page);
		args.putString("titulo", title);
		fragmentFirst.setArguments(args);
		return fragmentFirst;
	}

	// guardamos las variables basados en los argumentos pasados
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		pos = getArguments().getInt("pos", 0);
		titulo = getArguments().getString("titulo");
	}
	
	@Override
	public void onResume()
	{
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	 @Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	 @Override
	public void onDestroyView()
	{
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView = inflater.inflate(R.layout.fragment_dos, container, false);
		findViews();
		checkBox1.setText(titulo);
		return rootView;
	}

	void findViews()
	{
		checkBox1 = (CheckBox) rootView.findViewById(R.id.checkBox1);
	}

}