package com.example.feedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class feedbackactivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nameText, messageText;
    private Button sendButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackactivity);

        nameText = findViewById(R.id.nametextID);
        messageText = findViewById(R.id.feedbacktextID);

        sendButton = findViewById(R.id.sendButtonId);
        clearButton = findViewById(R.id.ClearButtonId);


        nameText.setOnClickListener(this);
        messageText.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        sendButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        try {
            //receive of a user value
            String name = nameText.getText().toString();
            String message = messageText.getText().toString();

            if (v.getId() == R.id.sendButtonId) {

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("type/email");

                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"phparvez71@gamil.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"FeedBack from Apps");
                intent.putExtra(Intent.EXTRA_TEXT,"name:"+name +"\n"+"message:"+message );
                startActivity(Intent.createChooser(intent,"Feedback with"));

            }
            else if (v.getId() == R.id.ClearButtonId) {

                nameText.setText("");
                messageText.setText("");

            }

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"Exception:"+e,Toast.LENGTH_SHORT).show();
        }


    }
}