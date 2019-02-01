package com.concordia.cejv669.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = findViewById(R.id.btn1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivityForResult(i, 1);
            }

        });

        Button bt2 = findViewById(R.id.btn2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivityForResult(i, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data.hasExtra("Message")) {
                Toast.makeText(this, data.getExtras().getString("Message"), Toast.LENGTH_LONG).show();
                tv1.setText(data.getExtras().getString("Message"));
                tv2.setText("");
            }
        }
        if (requestCode == 2 && resultCode == RESULT_OK) {

            if (data.hasExtra("Message")) {
                Toast.makeText(this, data.getExtras().getString("Message"), Toast.LENGTH_LONG).show();
                tv2.setText(data.getExtras().getString("Message"));
                tv1.setText("");
            }

        }
    }
}
