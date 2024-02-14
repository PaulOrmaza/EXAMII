package com.spoj.examii;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.View;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView txtCalendar, textView2, textView3, textView4, textView5, textView6, textView7;
    private Button btnCalendar, btnEnviar;
    private EditText txtNombres, txtCedula, txtCorreo;
    private RadioGroup rdGenero;
    private RadioButton radioButtonM, radioButtonH;
    private ScrollView scrollSigno;
    private CheckBox caries, cTauro, cGeminis, cLibra, cEscorpio, cLeo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCalendar = findViewById(R.id.txtcalendar);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        btnCalendar = findViewById(R.id.btncalendar);
        btnEnviar = findViewById(R.id.btnenviar);
        txtNombres = findViewById(R.id.txtnombres);
        txtCedula = findViewById(R.id.txtcedula);
        txtCorreo = findViewById(R.id.txtcorreo);
        rdGenero = findViewById(R.id.RDGENERO);
        radioButtonM = findViewById(R.id.radioButtonM);
        radioButtonH = findViewById(R.id.radioButtonH);
        scrollSigno = findViewById(R.id.scrolsigno);
        caries = findViewById(R.id.caries);
        cTauro = findViewById(R.id.ctauro);
        cGeminis = findViewById(R.id.cgeminis);
        cLibra = findViewById(R.id.clibra);
        cEscorpio = findViewById(R.id.cescorpio);
        cLeo = findViewById(R.id.cleo);

        // Configuración del RadioGroup para el género
        rdGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonM) {
                    // Se seleccionó masculino
                } else if (checkedId == R.id.radioButtonH) {
                    // Se seleccionó femenino
                }
            }
        });

        // Configuración de los CheckBox para el signo zodiacal
        // Aquí asumimos que solo se puede seleccionar un signo zodiacal a la vez
        caries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caries.isChecked()) {
                    cTauro.setChecked(false);
                    cGeminis.setChecked(false);
                    cLibra.setChecked(false);
                    cEscorpio.setChecked(false);
                    cLeo.setChecked(false);
                }
            }
        });
        cTauro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cTauro.isChecked()) {
                    caries.setChecked(false);
                    cGeminis.setChecked(false);
                    cLibra.setChecked(false);
                    cEscorpio.setChecked(false);
                    cLeo.setChecked(false);
                }
            }
        });
        //

        // Configuración del botón para mostrar el calendario
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
    }

    // Función para mostrar el DatePickerDialog
    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Mostrar la fecha seleccionada en el TextView
                        txtCalendar.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }
}
