package com.example.cursoandroidutnnivel1.clase12;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cursoandroidutnnivel1.R;

public class lay_camara  extends Activity
{
	//defino constantes para los intentos de camara o galeria. uno para cada uno
	 static final int CAMERA_REQUEST = 0;
	 static final int PICKER_GALLERY = 1;
	 //defino variables de los componentes XML
	 ImageView imageView_result;
	 Button btn_camara;
	 Button btn_galeria;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.lay_camara);
		levantarXML();
		asignarEventos();
		super.onCreate(savedInstanceState);
	}

	private void asignarEventos()
	{
		btn_camara.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//defino el action para capturar una imagen y donde se va a guardar 
				 Intent action = new Intent("android.media.action.IMAGE_CAPTURE");
                 action.putExtra(MediaStore.EXTRA_OUTPUT,MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());
                 //le paso la constante para luego saber de donde volvio el intent
                 startActivityForResult(action, CAMERA_REQUEST);

			}
		});
		btn_galeria.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				//defino el action para capturar contenido
				Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
				//defino el tipo de contenido
    			photoPickerIntent.setType("image/*");
    			startActivityForResult(photoPickerIntent, PICKER_GALLERY);

			}
		});
	}

	private void levantarXML()
	{
		imageView_result = (ImageView) findViewById(R.id.imageView_result);
		btn_camara = (Button) findViewById(R.id.btn_camara);
		btn_galeria = (Button) findViewById(R.id.btn_galeria);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{  
		try
		{
			//si vino de la camara y el resultado fue OK
			if ((requestCode == CAMERA_REQUEST) && (resultCode== RESULT_OK))
	        {          	
	        	try
		        {
	        		//levanto el bitmap de los extras del intent
  		        	Bitmap photo = (Bitmap) data.getExtras().get("data");
  		        	//llamo al garbage colector para optimizar la memoria
           	        System.gc();
           	        //comprimo y bajo la calidad del bitmap
		        	ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
			        photo.compress(Bitmap.CompressFormat.JPEG, 70, baos); //bm is the bitmap object
			        //se la asigno al imageview
			        imageView_result.setImageBitmap(photo);
			        //guardo la imagen
			        guardarImagen(photo);
			      //llamo al garbage colector para optimizar la memoria
		            System.gc();			       
		            //cierro el ByteArrayOutputStream
			        baos.close();
			        //le asigno null para limpiar la memoria
			        baos=null;
		        }
	        	catch (IllegalArgumentException e)
	        	{
	        		e.printStackTrace();
	        	}
	        	catch (Error e)
		        {
	        		e.printStackTrace();
		        }
		        catch (Exception ex)
		        {
	        	   ex.printStackTrace();
		        }	            
	        }
			
			//si vino de la galeria y el resultado fue OK
	        if ((requestCode == PICKER_GALLERY) && (resultCode== RESULT_OK))
	        {      	
	            try
		        {
	            	//levanto del intent el data que tiene un uri (es una especie de URL o path) que tiene la imagen
	            	Uri chosenImageUri = data.getData();
	            	// URI to bitmap a través de un método de android
		            Bitmap photoBitMap = Media.getBitmap(getContentResolver(), chosenImageUri);
	       		 	System.gc();		  			            
           	        //comprimo y bajo la calidad del bitmap
			        ByteArrayOutputStream baos = new ByteArrayOutputStream();
			        photoBitMap.compress(Bitmap.CompressFormat.JPEG, 70, baos);
			        //se la asigno al imageview
			        imageView_result.setImageBitmap(photoBitMap);	
			        guardarImagen(photoBitMap);
				      //llamo al garbage colector para optimizar la memoria

			        System.gc();	
		            //cierro el ByteArrayOutputStream
			        baos.close();
			        //le asigno null para limpiar la memoria
			        baos=null;
		           
		        }
	            catch (Error e)
		        {
	        	   e.printStackTrace();
		        }
		        catch (Exception ex)
		        {
		        	ex.printStackTrace();
		        }
	        }	       
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
	
	void asignarImagen()
	{
		//busco el root de la tarjeta de memoria
		 String root = Environment.getExternalStorageDirectory().toString();
		 //levanto mi directorio
		 File myDir = new File(root + "/saved_images");
		 //busco mi nombre de archivo
		 String fname = "nombreArchivo";
		 //creo un File de acuerdo al nombre y al path
		 File file = new File (myDir, fname);
		 //si existe y si pesa > 0
		 if (file.exists()&&file.length()>0)
		 {
			 //gracias a un meto de android decodifico a un bitmap
			 BitmapFactory.Options options = new BitmapFactory.Options();
			 options.inPreferredConfig = Bitmap.Config.ARGB_8888;
			 Bitmap bitmap = BitmapFactory.decodeFile(fname, options);
			 //asigno bitmap a imageview
			 imageView_result.setImageBitmap(bitmap);	 
		 }	 
	}
	

	private void guardarImagen(Bitmap photo)
	{
		//busco el root de la tarjeta de memoria
		String root = Environment.getExternalStorageDirectory().toString();
		 //levanto mi directorio

		 File myDir = new File(root + "/saved_images");
//si el directorio existe, no hago nada
         if (myDir.exists())
         {
        	 
         }
         else
         {
        	 //si no existe, lo creo
        	 myDir.mkdirs();	 
         }
         //asigno un nombre para un archivo. puede ser un random o un timestamp
         Random generator = new Random();
         int n = 10000;
         n = generator.nextInt(n);
         String fname = "Image-"+ n +".jpg";
         
         //timestamp
         Long tsLong = System.currentTimeMillis()/1000;
         String ts = tsLong.toString();      
         
         //creo el archivo con el nombre y el path
         File file = new File (myDir, fname);
         //si existe lo borro
         if (file.exists ())
         {
        	 file.delete ();
         }
        	  
         try 
         {
        	 //guardo el bitmap con una calidad 90 de los 70 originales
                FileOutputStream out = new FileOutputStream(file);
                photo.compress(Bitmap.CompressFormat.JPEG, 90, out);
                out.flush();
                out.close();

         } 
         catch (Exception e)
         {
                e.printStackTrace();
         }		
	}
}