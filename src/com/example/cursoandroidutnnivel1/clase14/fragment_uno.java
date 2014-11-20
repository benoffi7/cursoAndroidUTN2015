package com.example.cursoandroidutnnivel1.clase14;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cursoandroidutnnivel1.R;

public class fragment_uno extends Fragment
{
	private View rootView;
	Button button1;
	private int pos;
	private String titulo;

	public fragment_uno()
	{

	}

	// newInstance constructor para crear fragmentos con argumentos
	public static fragment_uno newInstance(int page, String title)
	{
		fragment_uno fragmentFirst = new fragment_uno();
		Bundle args = new Bundle();
		args.putInt("pos", page);
		args.putString("titulo", title);
		fragmentFirst.setArguments(args);
		return fragmentFirst;
	}

	//guardamos las variables basados en los argumentos pasados
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		pos = getArguments().getInt("pos", 0);
		titulo = getArguments().getString("titulo");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView = inflater.inflate(R.layout.fragment_uno, container, false);
		findViews();
		button1.setText(titulo);
		return rootView;
	}

	void findViews()
	{
		button1 = (Button) rootView.findViewById(R.id.button1);
	}

}