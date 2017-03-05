package com.example.harshil.gallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnValider = (Button) findViewById(R.id.btnValider);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtNom = (EditText) findViewById(R.id.txtNom);
                Intent intentGallery = new Intent(MainActivity.this, GalleryAndroidActivity.class);
                if (txtNom.getText().toString().isEmpty()) {
                    txtNom.setError("Le nom de l'animal ne peut pas être vide !");
                    return;
                }
                if (txtNom.getText().toString().equals("dinosaure") || txtNom.getText().toString().equals("Dinosaure")) {
                    startActivity(intentGallery);
                }
                else {
                    txtNom.setError("Non, ce n'est pas un " + txtNom.getText().toString() + " !");
                }
            }
        });
    }
}
