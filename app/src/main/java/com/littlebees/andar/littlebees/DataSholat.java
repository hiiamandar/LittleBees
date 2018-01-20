package com.littlebees.andar.littlebees;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.littlebees.andar.littlebees.databasehelper.DatabaseHelper;

import java.util.Calendar;


public class DataSholat extends AppCompatActivity {

    DatabaseHelper myDatabase;


    Spinner spinnerNama_sholat;
    TextInputEditText  edittanggalSholat, editjamSholat, edittempatSholat, editKeterangan;
    RadioButton rbDikerjakan, rbDitinggalkan;
    RadioGroup rgstatus;
    Button btSimpan;

    int date,month,year,hour,minute;


    String getket,gettime,getdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_sholat);

        myDatabase = new DatabaseHelper(this);

        //set arrow on tolbar

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinnerNama_sholat = (Spinner) findViewById(R.id.spinnerSholat);
        edittanggalSholat = (TextInputEditText) findViewById(R.id.tanggal_sholat);
        editjamSholat = (TextInputEditText) findViewById(R.id.jam_sholat);
        edittempatSholat = (TextInputEditText) findViewById(R.id.tempat_sholat);
        editKeterangan = (TextInputEditText) findViewById(R.id.keterangan_sholat);
        rgstatus = (RadioGroup) findViewById(R.id.rgStatus);
        rbDikerjakan = (RadioButton) findViewById(R.id.radioButtonDikerjakan);
        rbDitinggalkan = (RadioButton) findViewById(R.id.radioButtonTidakDikerjakan);
        btSimpan = (Button) findViewById(R.id.buttonSimpan);


        //get calender values.
        Calendar calendar=Calendar.getInstance();
        date=calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH);
        minute=calendar.get(Calendar.MINUTE);
        year=calendar.get(Calendar.YEAR);
        hour=calendar.get(Calendar.HOUR);


        //get datepicker dialog.
        edittanggalSholat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog=new DatePickerDialog(DataSholat.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        edittanggalSholat.setText(i2+"/"+(i1+1)+"/"+i);
                        getdate=i2+"/"+i1+"/"+i;
                    }
                },year,month,date);
                datePickerDialog.show();
            }
        });



        //time picker dialog.
        editjamSholat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog=new TimePickerDialog(DataSholat.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        editjamSholat.setText(i+" : "+i1);
                        gettime=i+" : "+i1;
                    }
                },hour,minute,false);
                dialog.show();
            }
        });



        //create spinner

        Spinner spinnersholat = (Spinner) findViewById(R.id.spinnerSholat);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(DataSholat.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinner_sholat_items));

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnersholat.setAdapter(spinnerAdapter);


        addDataTbSholat();
    }

    public void addDataTbSholat(){
        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama_sholat = spinnerNama_sholat.getSelectedItem().toString();
                String tanggal = edittanggalSholat.getText().toString();
                String pukul = editjamSholat.getText().toString();
                String tempat = edittempatSholat.getText().toString();
                String keterangan = editKeterangan.getText().toString();
                String kualitas = "";
                RadioButton selectedRB;

                if (rgstatus.getCheckedRadioButtonId()==-1) {
                    Toast.makeText(getApplicationContext(), "Pilih status sholat", Toast.LENGTH_SHORT).show();
                } else {
                    int nilai;
                    int idRG = rgstatus.getCheckedRadioButtonId();

                    selectedRB = (RadioButton)findViewById(idRG);
                    String status = selectedRB.getText().toString();

                    int indexRG = rgstatus.indexOfChild(selectedRB);

                    if (indexRG == 0) {
                        nilai = 1;
                    } else  {
                        nilai = 0;
                    }

                    boolean insertData = myDatabase.addDataTbSholat(nama_sholat, status, nilai, tanggal, pukul, tempat, kualitas, keterangan);

                    if (insertData == true) {
                        Toast.makeText(getApplicationContext(), "Data telah disimpan!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan...", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
