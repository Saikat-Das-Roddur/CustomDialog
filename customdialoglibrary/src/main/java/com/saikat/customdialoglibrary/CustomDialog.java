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
    private Activity activity;
    private LayoutInflater inflater;

    private View dialogView;
    private Button buttonSave, buttonCancel;
    private TextView textViewTitle, textViewDesc;
    private LinearLayout linearLayout;

    private AlertDialog alertDialog;

    public CustomDialog(Activity activity) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity);

        if (dialogView == null) {
            dialogView = inflater.inflate(R.layout.custom_layout, null);

            buttonSave = dialogView.findViewById(R.id.saveBtn);
            buttonCancel = dialogView.findViewById(R.id.cancelBtn);
            textViewTitle = dialogView.findViewById(R.id.titleTv);
            textViewDesc = dialogView.findViewById(R.id.descTv);
            linearLayout = dialogView.findViewById(R.id.titleLayout);

            alertDialog = new AlertDialog.Builder(activity)
                    .setView(dialogView)
                    .create();
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

    public CustomDialog setPositiveButtonColor(int color) {
        if (color > 0) {
            buttonSave.setTextColor(((Context) activity).getResources().getColor(color));
        } else
            buttonSave.setTextColor(color);
        return this;
    }

    public CustomDialog setPositiveButtonColor(String color) {
        buttonSave.setTextColor(Color.parseColor(color));
        return this;
    }

    public CustomDialog setNegativeButtonColor(int color) {
        if (color > 0) {
            buttonCancel.setTextColor(((Context) activity).getResources().getColor(color));
        } else
            buttonCancel.setTextColor(color);

        return this;
    }

    public CustomDialog setNegativeButtonColor(String color) {
        buttonCancel.setTextColor(Color.parseColor(color));
        return this;
    }

    public CustomDialog setTitleBackgroundColor(int color) {
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

    public CustomDialog setPositiveButton(String text, View.OnClickListener listener) {
        buttonSave.setVisibility(View.VISIBLE);
        buttonSave.setText(text);
        buttonSave.setOnClickListener(listener);
        return this;
    }

    public CustomDialog setNegativeButton(String text, View.OnClickListener listener) {
        buttonCancel.setVisibility(View.VISIBLE);
        buttonCancel.setText(text);
        buttonCancel.setOnClickListener(listener);
        return this;
    }

    public void dismiss() {
        if (alertDialog != null)
            alertDialog.dismiss();
    }


    public void show() {
        if (alertDialog != null)
            alertDialog.show();
    }
}
