package com.evon.amitrai.readcsv;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.evon.amitrai.readcsv.databinding.ActivityMainBinding;
import com.evon.amitrai.readcsv.modals.CSVModal;
import com.opencsv.CSVReader;

import java.io.FileReader;

public class MainActivity extends AppCompatActivity {
    CSVModal modal = null;
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        modal = new CSVModal();
        modal.setFile_name("file 1");
        binding.setCSVModal(modal);

        openCsvFile();


        modal.setFile_name("file 2");
    }



    public void openCsvFile(){
        try {

            CSVReader reader = new CSVReader(new FileReader());
            String [] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Log.e(TAG, "data is "+nextLine[0] + nextLine[1]);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }

    }
}
