package com.example.tpnote1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button nextButton;
    private TextView textLabel;
    private EditText editText;
    private Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextButton = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        dropdown = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ressources_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                String activity = dropdown.getSelectedItem().toString();
                Integer revenue = Integer.parseInt(editText.getText().toString());
                Data d = new Data(activity, revenue);
                intent.putExtra("DATASEND",d);
                startActivity(intent);
            }
        });
    }
}