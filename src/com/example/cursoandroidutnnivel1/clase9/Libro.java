package com.example.cursoandroidutnnivel1.clase9;

public class Libro
{
	int cantidadHojas;
	String nombre;
	String autor;
	int precio;
	String codigo;
	boolean activo;
	
	public String getActivo(boolean activo)
	{
		if (activo) return "1"; else return "0";
	}
	
	public Libro()
	{
		// TODO Auto-generated constructor stub
	}
	
	public Libro(String Nnombre)
	{
		this.nombre = Nnombre;
	}
	
	public int getCantidadHojas()
	{
		return cantidadHojas;
	}
	public void setCantidadHojas(int cantidadHojas)
	{
		this.cantidadHojas = cantidadHojas;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getAutor()
	{
		return autor;
	}
	public void setAutor(String autor)
	{
		this.autor = autor;
	}
	public int getPrecio()
	{
		return precio;
	}
	public void setPrecio(int precio)
	{
		this.precio = precio;
	}
	public String getCodigo()
	{
		return codigo;
	}
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

}
