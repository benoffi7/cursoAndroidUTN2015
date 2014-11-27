package com.example.cursoandroidutnnivel1.clase15;

import java.util.ArrayList;

public class Caminata
{
	int idCaminata;
	String nombreES;
	String nombreEN;
	String nombrePT;
	String descripcionES;
	String descripcionEN;
	String descripcionPT;
	String duracion;
	String distancia;
	String inicio;
	String epoca;
	String recomendacionES;
	String recomendacionEN;
	String recomendacionPT;
	String movil;
	String previsionesES;
	String previsionesEN;
	String previsionesPT;
	String precuacionesES;
	String precuacionesEN;
	String precuacionesPT;
	String puntosdeinteres;
	String desnivel;
	String dificultad_descripcionES;
	String dificultad_descripcionEN;
	String dificultad_descripcionPT;
	
	String dificultad_icono;

	ArrayList<Foto> fotos;
	
	String idayvueltaES;
	String idayvueltaPT;
	String idayvueltaEN;
	
	String latitud;
	String longitud;
	String direccion;
	String portada;
	String portada_descripcion;
	
	public String getPortada_descripcion()
	{
		return portada_descripcion;
	}
	
	public void setPortada_descripcion(String portada_descripcion)
	{
		this.portada_descripcion = portada_descripcion;
	}
	
	public String getPortada()
	{
		return portada;
	}
	
	public String getDificultad_icono()
	{
		return dificultad_icono;
	}
	
	public void setDificultad_icono(String dificultad_icono)
	{
		this.dificultad_icono = dificultad_icono;
	}
	
	public String getDireccion()
	{
		return direccion;
	}
	
	public String getLatitud()
	{
		return latitud;
	}
	
	public String getLongitud()
	{
		return longitud;
	}
	
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	public void setLatitud(String latitud)
	{
		this.latitud = latitud;
	}
	
	public void setPortada(String portada)
	{
		this.portada = portada;
	}
	
	public void setLongitud(String longitud)
	{
		this.longitud = longitud;
	}
	
	public String getIdayvueltaEN()
	{
		return idayvueltaEN;
	}
	
	public String getIdayvueltaES()
	{
		return idayvueltaES;
	}
	
	public String getIdayvueltaPT()
	{
		return idayvueltaPT;
	}
	
	public void setIdayvueltaEN(String idayvueltaEN)
	{
		this.idayvueltaEN = idayvueltaEN;
	}
	
	public void setIdayvueltaES(String idayvueltaES)
	{
		this.idayvueltaES = idayvueltaES;
	}
	
	public void setIdayvueltaPT(String idayvueltaPT)
	{
		this.idayvueltaPT = idayvueltaPT;
	}

	/*
	 * Category restaurants = new Category(); restaurants.name = "Restaurants";
	 * restaurants.save();
	 * 
	 * Item item = new Item(); item.category = restaurants; item.name =
	 * "Outback Steakhouse"; item.save();
	 * 
	 * 
	 * ActiveAndroid.beginTransaction(); try { for (int i = 0; i < 100; i++) {
	 * Item item = new Item(); item.name = "Example " + i; item.save(); }
	 * ActiveAndroid.setTransactionSuccessful(); } finally {
	 * ActiveAndroid.endTransaction(); }
	 * 
	 * new Delete().from(Item.class).where("Id = ?", 1).execute();
	 * 
	 * return new Select().from(Item.class).orderBy("RANDOM()").execute();
	 */

	public String getNombre(String idioma)
	{
		if (idioma.contains("en"))
		{
			return getNombreEN();
		}
		else
			if (idioma.contains("pt"))
			{
				return getNombrePT();
			}
			else
			{
				return getNombreES();
			}
	}

	public String getBajada(String idioma)
	{
		if (idioma.contains("en"))
		{
			return getDescripcionEN();
		}
		else
			if (idioma.contains("pt"))
			{
				return getDescripcionPT();
			}
			else
			{
				return getDescripcionES();
			}
	}

	

	public ArrayList<Foto> getFotos()
	{
		return fotos;
	}

	public void setFotos(ArrayList<Foto> fotos)
	{
		this.fotos = fotos;
	}

	public int getIdCaminata()
	{
		return idCaminata;
	}

	public void setIdCaminata(int idCaminata)
	{
		this.idCaminata = idCaminata;
	}

	public String getNombreES()
	{
		return nombreES;
	}

	public void setNombreES(String nombreES)
	{
		this.nombreES = nombreES;
	}

	public String getNombreEN()
	{
		return nombreEN;
	}

	public void setNombreEN(String nombreEN)
	{
		this.nombreEN = nombreEN;
	}

	public String getNombrePT()
	{
		return nombrePT;
	}

	public void setNombrePT(String nombrePT)
	{
		this.nombrePT = nombrePT;
	}

	public String getDescripcionES()
	{
		return descripcionES;
	}

	public void setDescripcionES(String descripcionES)
	{
		this.descripcionES = descripcionES;
	}

	public String getDescripcionEN()
	{
		return descripcionEN;
	}

	public void setDescripcionEN(String descripcionEN)
	{
		this.descripcionEN = descripcionEN;
	}

	public String getDescripcionPT()
	{
		return descripcionPT;
	}

	public void setDescripcionPT(String descripcionPT)
	{
		this.descripcionPT = descripcionPT;
	}

	public String getDuracion()
	{
		return duracion;
	}

	public void setDuracion(String duracion)
	{
		this.duracion = duracion;
	}

	public String getDistancia()
	{
		return distancia;
	}

	public void setDistancia(String distancia)
	{
		this.distancia = distancia;
	}

	public String getInicio()
	{
		return inicio;
	}

	public void setInicio(String inicio)
	{
		this.inicio = inicio;
	}

	public String getEpoca()
	{
		return epoca;
	}

	public void setEpoca(String epoca)
	{
		this.epoca = epoca;
	}

	public String getRecomendacionES()
	{
		return recomendacionES;
	}

	public void setRecomendacionES(String recomendacionES)
	{
		this.recomendacionES = recomendacionES;
	}

	public String getRecomendacionEN()
	{
		return recomendacionEN;
	}

	public void setRecomendacionEN(String recomendacionEN)
	{
		this.recomendacionEN = recomendacionEN;
	}

	public String getRecomendacionPT()
	{
		return recomendacionPT;
	}

	public void setRecomendacionPT(String recomendacionPT)
	{
		this.recomendacionPT = recomendacionPT;
	}

	public String getMovil()
	{
		return movil;
	}

	public void setMovil(String movil)
	{
		this.movil = movil;
	}

	public String getPrevisionesES()
	{
		return previsionesES;
	}

	public void setPrevisionesES(String previsionesES)
	{
		this.previsionesES = previsionesES;
	}

	public String getPrevisionesEN()
	{
		return previsionesEN;
	}

	public void setPrevisionesEN(String previsionesEN)
	{
		this.previsionesEN = previsionesEN;
	}

	public String getPrevisionesPT()
	{
		return previsionesPT;
	}

	public void setPrevisionesPT(String previsionesPT)
	{
		this.previsionesPT = previsionesPT;
	}

	public String getPrecuacionesES()
	{
		return precuacionesES;
	}

	public void setPrecuacionesES(String precuacionesES)
	{
		this.precuacionesES = precuacionesES;
	}

	public String getPrecuacionesEN()
	{
		return precuacionesEN;
	}

	public void setPrecuacionesEN(String precuacionesEN)
	{
		this.precuacionesEN = precuacionesEN;
	}

	public String getPrecuacionesPT()
	{
		return precuacionesPT;
	}

	public void setPrecuacionesPT(String precuacionesPT)
	{
		this.precuacionesPT = precuacionesPT;
	}

	public String getPuntosdeinteres()
	{
		return puntosdeinteres;
	}

	public void setPuntosdeinteres(String puntosdeinteres)
	{
		this.puntosdeinteres = puntosdeinteres;
	}

	public String getDesnivel()
	{
		return desnivel;
	}

	public void setDesnivel(String desnivel)
	{
		this.desnivel = desnivel;
	}

	public String getDificultad_descripcionES()
	{
		return dificultad_descripcionES;
	}

	public void setDificultad_descripcionES(String dificultad_descripcionES)
	{
		this.dificultad_descripcionES = dificultad_descripcionES;
	}

	public String getDificultad_descripcionEN()
	{
		return dificultad_descripcionEN;
	}

	public void setDificultad_descripcionEN(String dificultad_descripcionEN)
	{
		this.dificultad_descripcionEN = dificultad_descripcionEN;
	}

	public String getDificultad_descripcionPT()
	{
		return dificultad_descripcionPT;
	}

	public void setDificultad_descripcionPT(String dificultad_descripcionPT)
	{
		this.dificultad_descripcionPT = dificultad_descripcionPT;
	}

	public String getDificultad(String idioma)
	{
		if (idioma.contains("en"))
		{
			return getDificultad_descripcionEN();
		}
		else
			if (idioma.contains("pt"))
			{
				return getDificultad_descripcionPT();
			}
			else
			{
				return getDificultad_descripcionES();
			}
	}

	public String getRecomendaciones(String idioma)
	{
		if (idioma.contains("en"))
		{
			return getRecomendacionEN();
		}
		else
			if (idioma.contains("pt"))
			{
				return getRecomendacionPT();
			}
			else
			{
				return getRecomendacionES();
			}
	}

	public String getPrecauciones(String idioma)
	{
		if (idioma.contains("en"))
		{
			return getPrecuacionesEN();
		}
		else
			if (idioma.contains("pt"))
			{
				return getPrecuacionesPT();
			}
			else
			{
				return getPrecuacionesES();
			}
	}

	public CharSequence getDescripcion(String idioma)
	{
		if (idioma.contains("en"))
		{
			return getDescripcionEN();
		}
		else
			if (idioma.contains("pt"))
			{
				return getDescripcionPT();
			}
			else
			{
				return getDescripcionES();
			}
	}
	
	public String getIda(String idioma)
	{
		if (idioma.contains("en"))
		{
			return getIdayvueltaEN();
		}
		else
			if (idioma.contains("pt"))
			{
				return getIdayvueltaPT();
			}
			else
			{
				return getIdayvueltaES();
			}
	}

}
