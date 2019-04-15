package com.example.englishnepalidictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private TextView tvfirst;
    private Button btnclick;



    private ListView lstDictionary;

    public static  final String words[] = {
            "k xa", "How are you?",
            "Sanchai xu", "I am fine!",
            "k gardai", "What are you doing?",
            "jaum ghumna", "Let's go for visit!"
    };
    private Map<String,String> dictionary;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnclick = findViewById(R.id.btnclick);

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        lstDictionary = findViewById(R.id.lstDictionary);
        dictionary = new HashMap<>();

        for (int i=0; i<words.length; i +=2) {
            dictionary.put(words[i], words[i + 1]);
        }

        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<>(dictionary.keySet())
        );

        lstDictionary.setAdapter(adapter);

        lstDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = parent.getItemAtPosition(position).toString();
                String convert = dictionary.get(key);

                Intent intent = new Intent(MainActivity.this,MeaningActivity.class);
                intent.putExtra("convert",convert);
                startActivity(intent);
            }
        });

    }
}
