package com.saikat.customdialoglibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomDialog {
    LayoutInflater inflater;
    AlertDialog alertDialog;
    View view;
    Activity activity;
    Button buttonSave, buttonCancel;
    TextView textViewTitle, textViewDesc;
    LinearLayout linearLayout;

    public CustomDialog(Activity activity) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity);

        if (view == null) {
            view = inflater.inflate(R.layout.custom_layout, null);
            buttonSave = view.findViewById(R.id.saveBtn);
            buttonCancel = view.findViewById(R.id.cancelBtn);
            textViewTitle = view.findViewById(R.id.titleTv);
            textViewDesc = view.findViewById(R.id.descTv);
            linearLayout = view.findViewById(R.id.titleLayout);
            alertDialog = new AlertDialog.Builder(activity).setView(view).create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

    }

    public CustomDialog setTitle(String title) {
        textViewTitle.setText(title);// <- fix
        return this;
    }

    public CustomDialog setTitleColor(String color) {
        textViewTitle.setTextColor(Color.parseColor(color));
        return this;
    }

    public CustomDialog setTitleColor(int color) {
        if (color > 0) {
            textViewTitle.setTextColor(((Context) activity).getResources().getColor(color));
        } else
            textViewTitle.setTextColor(color);
        return this;
    }

    public CustomDialog setOkButtonColor(int color) {
        if (color > 0) {
            buttonSave.setTextColor(((Context) activity).getResources().getColor(color));
        } else
            buttonSave.setTextColor(color);
        return this;
    }

    public CustomDialog setOkButtonColor(String color) {
        buttonSave.setTextColor(Color.parseColor(color));
        return this;
    }

    public CustomDialog setCancelButtonColor(int color) {

        if (color > 0) {
            buttonCancel.setTextColor(((Context) activity).getResources().getColor(color));
        } else
            buttonCancel.setTextColor(color);

        return this;
    }

    public CustomDialog setCancelButtonColor(String color) {
        buttonCancel.setTextColor(Color.parseColor(color));
        return this;
    }

    public CustomDialog setTitleLayoutColor(int color){
        if (color > 0) {
            linearLayout.setBackgroundColor(((Context) activity).getResources().getColor(color));
        } else
            linearLayout.setBackgroundColor(color);
        return this;
    }


    public CustomDialog setDescription(String description) {
        textViewDesc.setText(description);
        return this;
    }

    public CustomDialog setDescriptionColor(String color) {
        textViewDesc.setTextColor(Color.parseColor(color));
        return this;
    }

    public CustomDialog setDescriptionColor(int color) {
        if (color > 0) {
            textViewDesc.setTextColor(((Context) activity).getResources().getColor(color));
        } else
            textViewDesc.setTextColor(color);
        return this;
    }

    public CustomDialog setOKButton(String text, View.OnClickListener listener) {
        buttonSave.setVisibility(View.VISIBLE);
        buttonSave.setText(text);
        buttonSave.setOnClickListener(listener);
        return this;
    }

    public CustomDialog setCancelButton(String text, View.OnClickListener listener) {

        buttonCancel.setVisibility(View.VISIBLE);
        buttonCancel.setText(text);
        buttonCancel.setOnClickListener(listener);
        return this;
    }

    public void hide() {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {

        }
    }


    public void show() {
        alertDialog.show();
    }
}
