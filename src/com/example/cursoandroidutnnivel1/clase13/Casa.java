package com.example.cursoandroidutnnivel1.clase13;

public class Casa
{
	String direccion;
	int cantidadAmbientes;

	public Casa()
	{
	}

	public void setCantidadAmbientes(int cantidadAmbientes)
	{
		this.cantidadAmbientes = cantidadAmbientes;
	}

	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	public int getCantidadAmbientes()
	{
		return cantidadAmbientes;
	}

	public String getDireccion()
	{
		return direccion;
	}

}
