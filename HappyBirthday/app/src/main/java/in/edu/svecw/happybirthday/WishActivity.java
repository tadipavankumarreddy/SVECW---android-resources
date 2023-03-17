package in.edu.svecw.happybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WishActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish);

        tv = findViewById(R.id.name_tv);
        Intent i = getIntent();
        String n = i.getStringExtra("KEY");

        tv.setText(n);
    }
}