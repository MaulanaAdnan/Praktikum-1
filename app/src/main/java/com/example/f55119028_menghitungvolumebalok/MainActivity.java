package com.example.f55119028_menghitungvolumebalok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editpanjang;
    private EditText editlebar;
    private EditText edittinggi;
    private Button btnhitung;
    private TextView tvhasil;

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvhasil.getText().toString());
    }

    private static final  String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editpanjang = findViewById(R.id.edit_panjang);
        editlebar =  findViewById(R.id.edit_lebar);
        edittinggi = findViewById(R.id.edit_tinggi);
        btnhitung = findViewById(R.id.btn_hitung);
        tvhasil = findViewById(R.id.tv_hasil);

        btnhitung.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasil = savedInstanceState.getString(STATE_RESULT);
            tvhasil.setText(hasil);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_hitung) {
            String inputLength = editpanjang.getText().toString().trim();
            String inputWidth = editlebar.getText().toString().trim();
            String inputHeight = edittinggi.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                editpanjang.setError("Silahkan Masukkan Nilai Panjang.");
                tvhasil.setText("Error!");
            }
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                editlebar.setError("Silahkan Masukkan Nilai Lebar.");
                tvhasil.setText("Error!");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edittinggi.setError("Silahkan Masukkan Nilai Tinggi.");
                tvhasil.setText("Error!");
            }
            if(!isEmptyFields) {
            Double volume = Double.parseDouble(inputLength) * Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight);
            tvhasil.setText(String.valueOf(volume));
            }
        }
    }
}