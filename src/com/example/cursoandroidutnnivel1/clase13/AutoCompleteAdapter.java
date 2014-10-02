package com.example.cursoandroidutnnivel1.clase13;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.cursoandroidutnnivel1.R;

public class AutoCompleteAdapter extends ArrayAdapter<Casa> implements Filterable 
{ 
	private LayoutInflater mInflater;
	
	public AutoCompleteAdapter(final Context context) 
	{
		//llamo al padre del adaptador, le paso el contexto y -1 como una vista xq la instancio dsp
		super(context,-1);		
		//instancio el inflador
		mInflater = LayoutInflater.from(context);
	}
 
	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) 
	{
		final TextView tv;
		//si es la segunda que paso por el renglo, asigno a tv el convertView
		if (convertView != null) 
		{
			tv = (TextView) convertView;
		} 
		else  // si es la primera vez, asigno a tv el layout. presenten atencion que el layout en si
			  // es un textview por lo cual no tengo que levantar el componente
		{
			tv = (TextView) mInflater.inflate(R.layout.row_autocomplete, parent, false);
		} 
		//le asigno la direccion como texto
		tv.setText(getItem(position).getDireccion());
		//y la cantidad de ambientes como tag (deberia ir un ID aca para identificar esa fila/resultado)
		tv.setTag(getItem(position).getCantidadAmbientes());
		return tv;
	}
	
	//la interfaz Filterable me pide implementar getFilter para que el autocomplete funcione
		//su unico metodo es getFilter() y debo devolver un Filter
		@Override
		public Filter getFilter() 
		{
			//cuando creo el Filter tengo que implementar tres metodos
			Filter myFilter = new Filter() 
			{
				//mientras estoy escribiendo...
				@Override
				protected FilterResults performFiltering(final CharSequence constraint) 
				{			
					//levanto un arreglo de casa
					ArrayList <Casa> addressList = null;
					//pregunto si hay texto ingreso y ese tiene + de 3 caracteres
					if ((constraint != null) && (constraint.length()>2))
					{
						//asigno a esa lista un metodo que me devuelva las casas basado en ese criterio
						addressList = devolverCasas(constraint);
					}
					
					//si no entro al if anterior y la lista es nula, la instacio (vacia)
					if (addressList == null)
					{
						addressList = new ArrayList<Casa>();
					}
					 
					//el metodo me pide devolver FilterResults asi que tengo que tomar mi arreglo (vacio o con resultados)
					//y crear una copia pero con otro tipo de objeto
					final FilterResults filterResults = new FilterResults();
					filterResults.values = addressList;
					filterResults.count = addressList.size();
	 
					return filterResults;
				}
	 
				//publicando resultados
				@SuppressWarnings("unchecked")
				@Override
				protected void publishResults(final CharSequence contraint, final FilterResults results) 
				{
					//limpio todo lo que haya antes
					clear();	
					//el metodo ya me devuelve los objetos filtrados...
					//por lo cual tengo que llamar a un metodo interno (el add) para agregarlos a la lista
					
					for (Casa aux : (ArrayList<Casa>) results.values) 
					{					
						add(aux);						
					} 
					/*
					for (int i=0;i<results.count;i++)
					{
						Casa aux = ((ArrayList<Casa>) results.values).get(i);
						aux.getCantidadAmbientes();
						add(aux);	
					}*/
					
					//si hay resultados, actualizo la vista del adaptador
					if (results.count > 0) 
					{					
						notifyDataSetChanged();
					} 
					else //si no hay resultado no muestro el desplegable
					{
						notifyDataSetInvalidated();
					}
				}
	 
				//este es otro metodo que me pide implementar. es convertir un objeto a string (utilizo alguna de sus propiedades)
				@Override
				public CharSequence convertResultToString(final Object resultValue) 
				{
					//es una version reducida del if
					//si es nulo, muestro "" sino la direccion
					return resultValue == null ? "" : ((Casa) resultValue).getDireccion();
				}
			};
			return myFilter;
		}

	protected ArrayList<Casa> devolverCasas(CharSequence direccion) 
	{		
		ArrayList<Casa> casas = new ArrayList<Casa>();
		ArrayList<Casa> resultados = new ArrayList<Casa>();
		
		//creo un arreglo de dos casas
		Casa oCasa = new Casa();
		oCasa.setCantidadAmbientes(30);
		oCasa.setDireccion("falucho");
		casas.add(oCasa);
		
		Casa oCasa1 = new Casa();
		oCasa1.setCantidadAmbientes(60);
		oCasa1.setDireccion("salta");
		casas.add(oCasa1);
		
	
		//recorro ese arreglo y si algun elemento en su campo direccion contiene los caracteres que estoy buscando
		//lo asigo a un arreglo de resultados
		for (int i = 0; i < casas.size(); i++)
		{
			if (casas.get(i).getDireccion().contains(direccion))
			{
				resultados.add(casas.get(i));
			}
		}
		
		return resultados;
	}
}