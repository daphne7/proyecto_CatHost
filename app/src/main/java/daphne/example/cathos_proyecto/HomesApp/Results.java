package daphne.example.cathos_proyecto.HomesApp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import daphne.example.cathos_proyecto.CustomAdapter;
import daphne.example.cathos_proyecto.R;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
       loadComponents();
    }

    private void loadComponents() {
        ListView list = findViewById(R.id.casaList);
        if (Data.LISTINGS != null) {
            CustomAdapter adapter = new CustomAdapter(this,Data.LISTINGS);

            list.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }



    }

}
