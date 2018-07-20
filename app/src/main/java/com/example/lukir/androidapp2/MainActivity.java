package com.example.lukir.androidapp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SendMessage(View view)
    {
        EditText edittext1 = (EditText)findViewById(R.id.editText);
        String message=edittext1.getText().toString();
        Intent intent=new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("message",message);
        startActivity(intent);
    }
}
