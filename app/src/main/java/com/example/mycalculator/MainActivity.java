package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<value> extends AppCompatActivity {
    EditText editTemp;
    RadioButton radioButton_Cel;
    RadioButton radioButton_Far;
    Button calbutton;
    TextView textviewanswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar*/


        editTemp = findViewById(R.id.editTemp);
        radioButton_Cel = findViewById(R.id.radioButton_Cel);
        radioButton_Far = findViewById(R.id.radioButton_Far);
        calbutton = findViewById(R.id.calbutton);
        textviewanswer = findViewById(R.id.textviewanswer);

    }
/*Menu*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }


    //protected void onResume() {
    //   super.onResume();
    //   calculatebutn.setOnClickListener(new View.OnClickListener() {

    //      public void onClick(View view) {
    //         calculateAnswer();
   //         }
     //   });
   // }
    public void calculateAnswer(View view) {
        Calculations cal = new Calculations();
        String value = editTemp.getText().toString();

        if (TextUtils.isEmpty(value)) {
            Toast.makeText(this, "Enter the temperature", Toast.LENGTH_SHORT).show();
        } else {
            Float temp = Float.parseFloat(value);
            if (radioButton_Cel.isChecked()) {
                temp = cal.convertCelciusToFahrenheit(temp);
            } else if (radioButton_Far.isChecked()) {
                temp = cal.convertFahrenheitToCelcius(temp);
            } else {
                Toast.makeText(this, "Select the Temperature mode", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }
            textviewanswer.setText(new Float(temp).toString());


        }

    }
}





