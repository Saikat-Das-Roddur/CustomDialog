package com.saikat.customdiialognlibrary;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.saikat.customdialoglibrary.CustomDialog;

public class MainActivity extends AppCompatActivity {

    CustomDialog customDialog;
    EditText editTextTitle, editTextDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextDesc = findViewById(R.id.descEt);
        editTextTitle = findViewById(R.id.titleEt);
    }


    public void setBothButton(View view) {
        customDialog = new CustomDialog(this)
                .setTitle(editTextTitle.getText().toString().trim())
                .setDescription(editTextDesc.getText().toString().trim())
                .setDescriptionColor(R.color.colorAccent)
                .setTitleBackgroundColor(Color.YELLOW)
                .setTitleColor(Color.BLUE)
                .setPositiveButtonColor(Color.RED)
                .setNegativeButtonColor(Color.BLUE)
                .setNegativeButton("Cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customDialog.dismiss();
                    }
                })
                .setPositiveButton("Save", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customDialog.dismiss();
                    }
                });
        customDialog.show();
    }
}
