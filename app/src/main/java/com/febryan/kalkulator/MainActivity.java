package com.febryan.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.febryan.kalkulator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnTambah.setOnClickListener(v -> {
            String awal = binding.edtInputSatu.getText().toString();
            String akhir = binding.edtInputDua.getText().toString();

//            if (awal.isEmpty()){
//                binding.edtInputSatu.setError("Nilai awal harus di isi !");
//            }
//            if (akhir.isEmpty()){
//                binding.edtInputDua.setError("Nilai akhir harus di isi !");
//            }
//            if (!awal.isEmpty() && !akhir.isEmpty()){
//                double hasil = Double.parseDouble(awal) + Double.parseDouble(akhir);
//                binding.tvHasil.setText(String.valueOf(hasil));
//            }
            validasi(awal, akhir, '+');
        });

        binding.btnKurang.setOnClickListener(v -> {
            String awal = binding.edtInputSatu.getText().toString();
            String akhir = binding.edtInputDua.getText().toString();
            validasi(awal, akhir, '-');
        });

        binding.btnBagi.setOnClickListener(v -> {
            String awal = binding.edtInputSatu.getText().toString();
            String akhir = binding.edtInputDua.getText().toString();
            validasi(awal, akhir, '/');
        });

        binding.btnKali.setOnClickListener(v -> {
            String awal = binding.edtInputSatu.getText().toString();
            String akhir = binding.edtInputDua.getText().toString();
            validasi(awal, akhir, '*');
        });

    }

    private void validasi(String awal, String akhir, char operator) {
        if (awal.isEmpty()){
            binding.edtInputSatu.setError("Nilai awal harus di isi !");
        }
        if (akhir.isEmpty()){
            binding.edtInputDua.setError("Nilai akhir harus di isi !");
        }
        if (!awal.isEmpty() && !akhir.isEmpty()){
            kalkulasi(Double.parseDouble(awal), Double.parseDouble(akhir), operator);
        }
    }

    private void kalkulasi(double awal, double akhir, char operator) {
        double result;
        switch (operator){
            case '+':
            result = awal + akhir;
            break;

            case '-':
                result = awal - akhir;
                break;

            case '/':
                result = awal / akhir;
                break;

            case '*':
                result = awal * akhir;
                break;

            default:
            result = 0.0;
            break;
        }
        binding.tvHasil.setText(String.valueOf(result));
    }
}