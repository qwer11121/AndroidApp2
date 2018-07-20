package com.example.lukir.androidapp2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent=getIntent();

        String action=intent.getAction();
        String type = intent.getType();

        String message= intent.getStringExtra("message");
        TextView textview1 =(TextView)findViewById(R.id.textView);
        textview1.setText(message);

        if(Intent.ACTION_SEND.equals(action) && type != null) {
            if("text/plain".equals(type)){
                handleSendText(intent);
            }
            else if(type.startsWith("image/")){
                handleSendImage(intent);
            }
        }
    }

    void handleSendText(Intent intent){
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if(sharedText != null){
            TextView textview1 =(TextView)findViewById(R.id.textView);
            textview1.setText(sharedText);
        }
    }

    void handleSendImage(Intent intent)
    {
        Uri imageUri = (Uri)intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if(imageUri!= null){
            TextView textview1 =(TextView)findViewById(R.id.textView);
            textview1.setText("We received a picture!");
            ImageView imageview1 = (ImageView)findViewById(R.id.imageView);
            imageview1.setImageURI(imageUri);
        }
    }
}
