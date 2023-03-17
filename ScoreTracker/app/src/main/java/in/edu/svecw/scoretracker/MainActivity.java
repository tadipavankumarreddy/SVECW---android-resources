package in.edu.svecw.scoretracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    TextView tv;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("KEY",count);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.result);

        if(savedInstanceState!=null && savedInstanceState.containsKey("KEY")){
            count = savedInstanceState.getInt("KEY");
            tv.setText(String.valueOf(count));
        }
    }

    // to increase the score
    public void incrementScore(View view) {
        count++;
        tv.setText(String.valueOf(count));
    }

    // to decrease the score
    public void decrementScore(View view) {
        count--;
        tv.setText(String.valueOf(count));
    }
}