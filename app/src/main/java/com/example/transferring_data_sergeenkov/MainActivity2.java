package com.example.transferring_data_sergeenkov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity2 extends AppCompatActivity {

    // Sergeenkov Maksiv393 Transferring Data
    EditText editText_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText_2 = findViewById(R.id.editTextActivity_2);


        Intent intentFromActivity1 = getIntent();//Получаем передаваемый в эту Activity Intent

        String strActivity = intentFromActivity1.getStringExtra("transmittedString");//Вытаскиваем данные из посылки по имени
        editText_2.setText(strActivity);

    }

    public void OnOk_Click(View v)
    {
        Intent intent = new Intent(); //this - экземпляр данного класса MainActivity

        String s = editText_2.getText().toString();

        intent.putExtra("stringTo", s); //string - название передаваемой строки для дальнейшего извлекания, s - сами данные
        setResult(RESULT_OK, intent);//Вернуть в ответ новый intent с данными
        finish();
    }

    public void OnCancel_Click(View v)
    {
        setResult(RESULT_CANCELED);
        finish(); //Закрываем вторую Activity
    }
}