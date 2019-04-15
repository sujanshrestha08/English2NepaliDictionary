package com.example.englishnepalidictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MeaningActivity extends AppCompatActivity {

    private TextView tvMeaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null) {
            String convert = bundle.getString("convert");
            tvMeaning = findViewById(R.id.tvMeaning);
            tvMeaning.setText(convert);
        }
        else
        {
            Toast.makeText(this, "No Meaning", Toast.LENGTH_SHORT).show();
        }
    }
}
