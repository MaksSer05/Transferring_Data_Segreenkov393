package com.example.transferring_data_sergeenkov;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Sergeenkov Maksiv393 Transferring Data
    EditText editText;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Создание экземпляра класса Activity

        editText = findViewById(R.id.editTextActivity_1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        Log.e("TEST", " Method onActivity result initializing");
        if (requestCode == 1) {
            if (data !=null) {
                //stringTo - название передаваемой строки для дальнейшего извлекания, s - сами данные
                String s = data.getStringExtra("stringTo");
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                editText.setText(s);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onDialog_Click(View v)
    {
        String s = editText.getText().toString(); // получаем текст из поля editTextActivity_1

        intent = new Intent(this, MainActivity2.class);
        intent.putExtra("transmittedString",s);

        startActivityForResult(intent, 1); // передаем второй activity данные и ждем от нее код 1
    }
    public void OnExit_Click (View v)
    {
        finish();
    }
}