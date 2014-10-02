package com.example.cursoandroidutnnivel1.clase9;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.cursoandroidutnnivel1.R;

public class lay_libros extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.activity_empty);
		DAO_Libros dao = new DAO_Libros(lay_libros.this, getString(R.string.librosdb), null, 1);
		//me traigo los libros
		Log.d("Curso", "Cantidad de libros:"+dao.recuperarDatos().size());
		//agrego los libros
		Libro oLibro = new Libro();
		oLibro.setAutor("George RR Martin");
		oLibro.setCantidadHojas(1000);
		oLibro.setCodigo("CDHYF");
		oLibro.setNombre("La Montaña vs la Vibora");
		oLibro.setPrecio(100);
		dao.insertarDatos(oLibro);
		
		Libro oLibro2 = new Libro();
		oLibro2.setAutor("Walter Isaacson");
		oLibro2.setCantidadHojas(5000);
		oLibro2.setCodigo("SJ");
		oLibro2.setNombre("Steve Jobs");
		oLibro2.setPrecio(70);
		dao.insertarDatos(oLibro2);
		
		//me traigo los libros
		Log.d("Curso", "Cantidad de libros:"+dao.recuperarCantidad());
		//borro uno
		dao.borrarLibro(oLibro);
		//me traigo los libros
		Log.d("Curso", "Cantidad de libros:"+dao.recuperarDatos().size());
		ArrayList<Libro>libros = dao.recuperarDatos();
		for (Libro libro_aux : libros)
		{
			Log.d("Curso", "Libro: "+libro_aux.getNombre());
		}
		
		
		super.onCreate(savedInstanceState);
	}
}
