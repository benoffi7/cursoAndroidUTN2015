package com.example.cursoandroidutnnivel1.clase15;


public class Foto
{
	int id_comercio;
	String URL;
	
	public Foto()
	{
		// TODO Auto-generated constructor stub
	}

	public int getIdComercio()
	{
		return id_comercio;
	}

	public String getURL()
	{
		return URL;
	}

	public void setIdComercio(int id)
	{
		this.id_comercio = id;
	}

	public void setURL(String uRL)
	{
		URL = uRL;
	}

	public Foto(int id_comercio, String uRL)
	{
		super();
		this.id_comercio = id_comercio;
		URL = uRL;
	}

}
