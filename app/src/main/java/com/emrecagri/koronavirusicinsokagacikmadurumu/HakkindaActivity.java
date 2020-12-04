package com.emrecagri.koronavirusicinsokagacikmadurumu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HakkindaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkinda);

        Button btn_geri_don = (Button) findViewById(R.id.btn_geri_don); //tasarımdaki butonu tanıttık

        btn_geri_don.setOnClickListener(new View.OnClickListener() { //butonu aktif hale getirip tıklanınca neler olacağını kodun içinde belirttik
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HakkindaActivity.this, MainActivity.class); //Bu sınıf HakkindaActivity dedik ve MainActivity sınıfına git dedik
                startActivity(intent); //intent ile geçiş işlemini çalıştırdık
            }
        });






        ImageView img = (ImageView)findViewById(R.id.img_tablo);
        img.setImageResource(R.drawable.tablo);
    }
}
