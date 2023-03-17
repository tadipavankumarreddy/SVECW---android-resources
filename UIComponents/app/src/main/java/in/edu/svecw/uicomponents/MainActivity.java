package in.edu.svecw.uicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name, age;
    RadioGroup gender;
    Spinner countries;
    TextView result;

    String g = "default";

    String c = "Not Selected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.person_name);
        age = findViewById(R.id.person_age);
        gender = findViewById(R.id.gender);
        countries = findViewById(R.id.countries);
        result = findViewById(R.id.result);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getCheckedRadioButtonId() == R.id.male){
                    g = "Male";
                }else{
                    g = "Female";
                }
            }
        });

        countries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void submit(View view) {
        if(name.getText().toString().equals("")){
            name.setError("Enter your name");
        }
        String n = name.getText().toString();

        int a = Integer.parseInt(age.getText().toString());
        result.setText(n+"\n"+a+"\n"+g+"\n"+c);
    }
}