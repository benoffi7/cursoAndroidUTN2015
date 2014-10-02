package com.example.cursoandroidutnnivel1.clase9;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DAO_Libros extends SQLiteOpenHelper
{ 
	public DAO_Libros(Context contexto, String nombre, CursorFactory factory, int version) 
	{
	      super(contexto, nombre, factory, version);
	}
	
	/*
	 * int cantidadHojas;
	String nombre;
	String autor;
	int precio;
	String codigo;(non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL("CREATE TABLE libros (cantidadHojas INTEGER,nombre TEXT , autor TEXT, precio INTEGER, codigo TEXT)");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) 
	{
	     
	}
	
	public void insertarDatos(Libro oLibro)
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("INSERT INTO libros (cantidadHojas ,nombre  , autor , precio , codigo ) "
		 		+ "VALUES ("+oLibro.getCantidadHojas()+",'"+oLibro.getNombre()+"','"+oLibro.getAutor()+"'"
		 		+","+oLibro.getPrecio()+",'"+oLibro.getCodigo()+"'"
		 		+")");
		 baseDatos.close(); 
	}

	public ArrayList<Libro> recuperarDatos()
	{
		 SQLiteDatabase baseDatos = getWritableDatabase(); 
		 String sql = "SELECT * FROM libros"; 
		 Cursor cursor = baseDatos.rawQuery(sql, null); 
		 ArrayList<Libro >libros=new ArrayList<Libro>();  
		 while (cursor.moveToNext()) 
		 { 
			 Libro oLibro=new Libro(); 
			 oLibro.setCantidadHojas(cursor.getInt(0));
			 oLibro.setNombre(cursor.getString(1));
			 oLibro.setAutor(cursor.getString(2));
			 oLibro.setPrecio(cursor.getInt(3));
			 oLibro.setCodigo(cursor.getString(4));
			 libros.add(oLibro);
		 }       
		 cursor.close();
		 baseDatos.close();
		 return libros;
	}
	
	public int recuperarCantidad()
	{
		 SQLiteDatabase baseDatos = getWritableDatabase(); 
		 String sql = "SELECT * FROM libros"; 
		 Cursor cursor = baseDatos.rawQuery(sql, null); 
		 int cantidad = cursor.getCount();
		 cursor.close();
		 baseDatos.close();
		 return cantidad;
	}
	
	
	public void borrarLibro(Libro olibro) 
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("DELETE FROM libros where nombre ='"+olibro.getNombre()+"'");
		 baseDatos.close(); 	
	}

	public void actualizarLibro(Libro olibro)
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("UPDATE libros set precio ="+olibro.getPrecio()+", cantidadhojas ="+olibro.getCantidadHojas()+" where nombre = '"+olibro.getNombre()+"';" );
		 baseDatos.close(); 
	}
}
