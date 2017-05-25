package com.example.karshi.callerapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Add_a_contact_Activity extends AppCompatActivity {

    public static final String CONTACTTOKEN = "new";
    EditText mymessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_a_contact_);
        mymessage = (EditText)findViewById(R.id.txtname);
    }

    public void AddDetails(View view) {

        String displayText = mymessage.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(CONTACTTOKEN,displayText);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }


}
