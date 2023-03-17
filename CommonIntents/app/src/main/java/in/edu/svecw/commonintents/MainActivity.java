package in.edu.svecw.commonintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_url = findViewById(R.id.et_url);
    }

    public void openBrowser(View view) {
        String u = et_url.getText().toString();
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+u));
        startActivity(i);
    }


    public void openMaps(View view) {
        EditText address = findViewById(R.id.editTextTextPersonName3);
        String a = address.getText().toString();
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+a));
        startActivity(i);
    }
}