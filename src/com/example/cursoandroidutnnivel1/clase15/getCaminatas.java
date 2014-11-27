package com.example.cursoandroidutnnivel1.clase15;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

public class getCaminatas
{
	public static String host = "http://ushuaiamovil.com.ar";
	public static String devolverCaminatas = host + "/api/devolverCaminatas.php";

	public static ArrayList<Caminata> devolverCaminatas()
	{
		String URL = devolverCaminatas;
		ArrayList<Caminata>caminatas = new ArrayList<Caminata>();
		try
		{
			StringBuilder builder = new StringBuilder();
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(URL);
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200)
			{
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null)
				{
					builder.append(line);
				}
				if (builder.toString().length() > 0)
				{
					JSONArray objectoResponse = new JSONArray(builder.toString());
					Log.d("Curso", "Cantidad de caminatas: " + objectoResponse.length());
					for (int i = 0; i < objectoResponse.length(); i++)
					{
						Caminata oCaminata = new Caminata();
						JSONObject jsonCaminata = objectoResponse.getJSONObject(i);

						oCaminata.setIdCaminata(objectoResponse.getJSONObject(i).getInt("idCaminata"));

						oCaminata.setDescripcionES(objectoResponse.getJSONObject(i).getString("descripcionES").replace("'", "#"));
						oCaminata.setDescripcionEN(objectoResponse.getJSONObject(i).getString("descripcionEN").replace("'", "#"));
						oCaminata.setDescripcionPT(objectoResponse.getJSONObject(i).getString("descripcionPT").replace("'", "#"));

						oCaminata.setDuracion(objectoResponse.getJSONObject(i).getString("duracion").replace("'", "#"));
						oCaminata.setDistancia(objectoResponse.getJSONObject(i).getString("distancia").replace("'", "#"));
						oCaminata.setInicio(objectoResponse.getJSONObject(i).getString("inicio").replace("'", "#"));
						oCaminata.setEpoca(objectoResponse.getJSONObject(i).getString("epoca").replace("'", "#"));

						oCaminata.setRecomendacionES(objectoResponse.getJSONObject(i).getString("recomendacionES").replace("'", "#"));
						oCaminata.setRecomendacionEN(objectoResponse.getJSONObject(i).getString("recomendacionEN").replace("'", "#"));
						oCaminata.setRecomendacionPT(objectoResponse.getJSONObject(i).getString("recomendacionPT").replace("'", "#"));

						oCaminata.setMovil(objectoResponse.getJSONObject(i).getString("movil").replace("'", "#"));

						oCaminata.setPrevisionesES(objectoResponse.getJSONObject(i).getString("previsionesES").replace("'", "#"));
						oCaminata.setPrevisionesEN(objectoResponse.getJSONObject(i).getString("previsionesEN").replace("'", "#"));
						oCaminata.setPrevisionesPT(objectoResponse.getJSONObject(i).getString("previsionesPT").replace("'", "#"));

						oCaminata.setPrecuacionesES(objectoResponse.getJSONObject(i).getString("precuacionesES").replace("'", "#"));
						oCaminata.setPrecuacionesEN(objectoResponse.getJSONObject(i).getString("precuacionesEN").replace("'", "#"));
						oCaminata.setPrecuacionesPT(objectoResponse.getJSONObject(i).getString("precuacionesPT").replace("'", "#"));

						oCaminata.setPuntosdeinteres(objectoResponse.getJSONObject(i).getString("puntosdeinteres").replace("'", "#"));
						oCaminata.setDesnivel(objectoResponse.getJSONObject(i).getString("desnivel").replace("'", "#"));

						oCaminata.setNombreES(objectoResponse.getJSONObject(i).getString("nombreES").replace("'", "#"));
						oCaminata.setNombreEN(objectoResponse.getJSONObject(i).getString("nombreEN").replace("'", "#"));
						oCaminata.setNombrePT(objectoResponse.getJSONObject(i).getString("nombrePT").replace("'", "#"));

						JSONObject jsonDificultad = objectoResponse.getJSONObject(i).getJSONObject("dificultad");

						oCaminata.setDificultad_descripcionEN(jsonDificultad.getString("descripcionEN").replace("'", "#"));
						oCaminata.setDificultad_descripcionES(jsonDificultad.getString("descripcionES").replace("'", "#"));
						oCaminata.setDificultad_descripcionPT(jsonDificultad.getString("descripcionPT").replace("'", "#"));
						oCaminata.setDificultad_icono(jsonDificultad.getString("icono").replace("'", "#"));

						oCaminata.setIdayvueltaES(objectoResponse.getJSONObject(i).getString("idayvueltaES").replace("'", "#"));
						oCaminata.setIdayvueltaEN(objectoResponse.getJSONObject(i).getString("idayvueltaEN").replace("'", "#"));
						oCaminata.setIdayvueltaPT(objectoResponse.getJSONObject(i).getString("idayvueltaPT").replace("'", "#"));

						oCaminata.setLatitud(objectoResponse.getJSONObject(i).getString("latitud").replace("'", "#"));
						oCaminata.setLongitud(objectoResponse.getJSONObject(i).getString("longitud").replace("'", "#"));
						oCaminata.setDireccion(objectoResponse.getJSONObject(i).getString("direccion").replace("'", "#"));
						oCaminata.setPortada(objectoResponse.getJSONObject(i).getString("portada").replace("'", "#"));
						oCaminata.setPortada_descripcion(objectoResponse.getJSONObject(i).getString("portada_descripcion").replace("'", "#"));

						ArrayList<Foto> fotos = new ArrayList<Foto>();
						JSONArray fotosJSON = jsonCaminata.getJSONArray("fotos");
						Log.d("Curso", "Cantidad de fotos caminatas: " + fotosJSON.length());
						for (int x = 0; x < fotosJSON.length(); x++)
						{
							Foto foto = new Foto();
							foto.setURL(fotosJSON.getJSONObject(x).getString("URL"));

							fotos.add(foto);

						}

						oCaminata.setFotos(fotos);
					}
				}
			}
		}
		catch (Exception ex)
		{
			Log.e("Curso","Error Devolver caminatas >> " + ex.getMessage());
			ex.printStackTrace();
		}
		return caminatas;
	}

}