package com.example.cursoandroidutnnivel1.clase13;

import java.util.ArrayList;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cursoandroidutnnivel1.R;

public class AdaptadorPaginas extends PagerAdapter 
{	
	
	Context ctx;
	public AdaptadorPaginas(Context ctx)
	{
		this.ctx = ctx;
	}
	
//	ArrayList<Casa>casas; 
//	public AdaptadorPaginas(ArrayList<Casa>casas)
//	{
//		this.casas = casas;
//	}
    public int getCount() 
    {
    	return 5;
    	//establezco la cantidad de paginas
      //  return casas.size();
    }
    
    public Object instantiateItem(View collection, int position) 
    {
        LayoutInflater inflater = (LayoutInflater) collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);        
        //inflo la plantilla del paginado
        View view = inflater.inflate(R.layout.row_pager, null);
        //levanto los componentes de esa plantilla
        ImageView imageView = (ImageView)view.findViewById(R.id.image_row_pager);
        TextView text_row_pager = (TextView)view.findViewById(R.id.text_row_pager);
        //asigno a un textview un texto cualquiera
        text_row_pager.setText("Pos: "+position); 
        //agrego al paginador este renglon con el addView
        switch (position)
		{
		case 0:
			imageView.setImageDrawable(ctx.getResources().getDrawable(R.drawable.arg));
			break;
		case 1:
			imageView.setImageDrawable(ctx.getResources().getDrawable(R.drawable.bar));
			break;

		default:
			break;
		}
       
        ((ViewPager) collection).addView(view, 0);
        return view;
    }
    
    
    //sin uso
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) 
    {
        ((ViewPager) arg0).removeView((View) arg2);
    }
    
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) 
    {
        return arg0 == ((View) arg1);
    }
    
    @Override
    public Parcelable saveState() 
    {
        return null;
    }
}