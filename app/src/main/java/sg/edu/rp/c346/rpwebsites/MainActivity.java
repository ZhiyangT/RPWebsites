package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnGo;

    ArrayList<String> alWebSite;
    ArrayAdapter<String> aaWebSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGo);

        alWebSite = new ArrayList<>();

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        alWebSite.clear();

                        String[] category = getResources().getStringArray(R.array.sub_RP);

                        alWebSite.addAll(Arrays.asList(category));

                        break;

                    case 1:
                        alWebSite.clear();

                        String[] category1 = getResources().getStringArray(R.array.sub_SOI);

                        alWebSite.addAll(Arrays.asList(category1));

                        break;

                }
                aaWebSite.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        aaWebSite = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alWebSite);

        spn2.setAdapter(aaWebSite);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][]sites = {
                        {
                                "https://www.rp.edu.sg/",
                                "https://www.rp.edu.sg/student-life",
                        },
                        {
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12",
                        }
                };
                //String url = "https://www.facebook.com/";
                String url = sites[spn1.getSelectedItemPosition()][spn2.getSelectedItemPosition()];
                startActivity(new Intent(MainActivity.this,Web_page.class).putExtra("URL",url));
            }
        });

    }
}
