package com.example.cursoandroidutnnivel1.clase8;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cursoandroidutnnivel1.Configuracion;
import com.example.cursoandroidutnnivel1.R;

public class lay_set_prefs extends Activity
{
	private SeekBar seekBar_edad;
	private EditText editText_nombre;
	private RatingBar ratingBar_calificacion;
	private Spinner spinner_equipo;
	private RadioGroup radioGroup_genero;
	private CheckBox checkBox_trabajo;
	private CheckBox checkBox_estudio;
	private Button button_save;
	private SharedPreferences mSharedPreferences;
	private TextView text_edad;
	private String[] equipos;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.lay_set_prefs);
		mSharedPreferences = getApplicationContext().getSharedPreferences(Configuracion.misprefs, 0);
		findViews();
		setUI();
		setupEvents();
		super.onCreate(savedInstanceState);
	}
	
	private void findViews()
	{
		seekBar_edad = (SeekBar) findViewById(R.id.seekBar_edad);
		editText_nombre = (EditText) findViewById(R.id.editText_nombre);
		ratingBar_calificacion = (RatingBar) findViewById(R.id.ratingBar_calificacion);
		spinner_equipo = (Spinner) findViewById(R.id.spinner_equipo);
		radioGroup_genero = (RadioGroup) findViewById(R.id.radioGroup_genero);
		checkBox_trabajo = (CheckBox) findViewById(R.id.checkBox_trabajo);
		checkBox_estudio = (CheckBox) findViewById(R.id.checkBox_estudio);
		text_edad = (TextView) findViewById(R.id.text_edad);
		button_save = (Button) findViewById(R.id.button_save);
	}

	private void setUI()
	{
		//combo equipo
		switch (radioGroup_genero.getCheckedRadioButtonId())
		{
			case R.id.radio_hombre:
				spinner_equipo.setEnabled(true);
				break;
			case R.id.radio_mujer:
				spinner_equipo.setEnabled(false);
				break;
			default:
				break;
		}
		//calificacion
		ratingBar_calificacion.setEnabled(checkBox_estudio.isChecked());
		
		//equipos - datos		
		equipos = new String[]{"Velez","Boca","River","Otro"};
//	    equipos = getResources().getStringArray(R.array.equipos);
		 
		//adapter
        ArrayAdapter<String> adaptador_elementos = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,equipos);
        spinner_equipo.setAdapter(adaptador_elementos);        
        spinner_equipo.setSelection(3);
	}

	private void setupEvents()
	{
		//tiene que importar de android.widget.CompoundButton
		checkBox_estudio.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				//la clasificacion depende del check de estudio
				ratingBar_calificacion.setEnabled(isChecked);
			}
		});
		
		ratingBar_calificacion.setOnRatingBarChangeListener(new OnRatingBarChangeListener()
		{			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
			{
				//muestro un toast con el valor de las estrellas
				Toast.makeText(getApplicationContext(), ""+rating, Toast.LENGTH_SHORT).show();				
			}
		});
		
//		int varaible = 3;
//		text_edad.setText(""+varaible);
		
		
		seekBar_edad.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{
			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{
				// TODO Auto-generated method stub
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar)
			{
				// TODO Auto-generated method stub
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				//cambio el label indicando la edad seleccionada
				text_edad.setText(getResources().getString(R.string.edad) + ":" + progress);
			}
		});

		radioGroup_genero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				//si es hombe, habilito la seleccion de equipo, sino no
				switch (checkedId)
				{
					case R.id.radio_hombre:
						spinner_equipo.setEnabled(true);
						break;
					case R.id.radio_mujer:
						spinner_equipo.setEnabled(false);
						break;
					default:
						break;
				}
			}
		});
		
		spinner_equipo.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{
				switch (position)
				{
					case 0:
						Toast.makeText(getApplicationContext(), equipos[position]+" El mejor", Toast.LENGTH_SHORT).show();
						break;
					case 1:
						Toast.makeText(getApplicationContext(), equipos[position]+" Cebollita subcampeon", Toast.LENGTH_SHORT).show();
						break;
					case 2:
						Toast.makeText(getApplicationContext(), equipos[position]+" Y ramon? Y la moto?", Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
				// TODO Auto-generated method stub				
			}
		});

		button_save.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				SharedPreferences.Editor editor = mSharedPreferences.edit();
				editor.putInt(getResources().getString(R.string.edad), seekBar_edad.getProgress());
				editor.putInt(getResources().getString(R.string.calificacion), ratingBar_calificacion.getProgress());
				editor.putString(getResources().getString(R.string.nombre), editText_nombre.getText().toString());
				editor.putBoolean(getResources().getString(R.string.trabajo), checkBox_trabajo.isChecked());
				editor.putBoolean(getResources().getString(R.string.estudio), checkBox_estudio.isChecked());
				editor.putInt(getResources().getString(R.string.genero), radioGroup_genero.getCheckedRadioButtonId());
				editor.putInt(getResources().getString(R.string.equipo), spinner_equipo.getSelectedItemPosition());
				editor.commit();
			}
		});
	}
}
