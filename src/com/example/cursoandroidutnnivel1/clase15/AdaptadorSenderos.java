package com.example.cursoandroidutnnivel1.clase15;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cursoandroidutnnivel1.R;

public class AdaptadorSenderos extends ArrayAdapter<Caminata>
{
	Context context;
	LayoutInflater inflater;
	List<Caminata> caminatas;

	public AdaptadorSenderos(Context context, ArrayList<Caminata> caminatas)
	{
		super(context, R.layout.row_senderos, caminatas);
		this.context = context;
		this.caminatas = caminatas;
		inflater = LayoutInflater.from(context);
	}

	private class ViewHolder
	{
		TextView textView_nombreCircuito;
		TextView textView_bajadaCircuito;
		LinearLayout ll_row_circuito;
	}

	public View getView(final int position, View view, ViewGroup parent)
	{
		final ViewHolder holder;
		if (view == null)
		{
			holder = new ViewHolder();
			LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = li.inflate(R.layout.row_senderos, parent, false);
			holder.textView_nombreCircuito = (TextView) view.findViewById(R.id.textView_nombreCircuito);
			holder.textView_bajadaCircuito = (TextView) view.findViewById(R.id.textView_bajadaCircuito);
			holder.ll_row_circuito = (LinearLayout) view.findViewById(R.id.ll_row_circuito);

			view.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) view.getTag();
		}


		holder.textView_nombreCircuito.setText(getItem(position).getNombreES());
		String aux = context.getResources().getString(R.string.legend_distancia) + " "+getItem(position).getDistancia().trim()+" "+context.getResources().getString(R.string.legend_dificultad) + " "+getItem(position).getDificultad_descripcionES();
		
		holder.textView_bajadaCircuito.setText(aux);
		
		holder.ll_row_circuito.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				
			}
		});

		return view;
	}

	@Override
	public int getCount()
	{
		return caminatas.size();
	}

	@Override
	public Caminata getItem(int position)
	{
		return caminatas.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return 0;
	}

}