package com.emrecagri.koronavirusicinsokagacikmadurumu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.edtyas);
        Button durumbtn = (Button) findViewById(R.id.buttondurum);
        final TextView sonuc = (TextView) findViewById(R.id.sonuctxt);
        ImageButton btn_hakkinda = (ImageButton) findViewById(R.id.btn_hakkinda);



        //btn_hakkinda butonuna basıldığında yapılacak işemler kodunun başı
        btn_hakkinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(MainActivity.this, HakkindaActivity.class);
                startActivity(intent);



            }
        });
         //btn_hakkinda butonuna basıldığında yapılacak işemler kodunun sonu








        durumbtn.setOnClickListener(new View.OnClickListener() { //sorgulama butonuna tıklayınca aşağıdaki işlemler gerçekleşecek
            @Override
            public void onClick(View v) {





                //Mesaj pencerisi kodunun başlangıcı

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Uyarı");

                builder.setMessage("Bu uygulama içinde yer alan tüm bilgi ve materyaller yalnızca bilgilendirme amaçlıdır. Resmi bir geçerliği yoktur.");

                builder.setCancelable(false); //açılan mesaj penceresini geri tuşuna basarak yada mesaj penceresinin dışında herhangi bir yere basık pencerenin kapanmasını engelleriz.

                builder.setPositiveButton("Anladım, sonucu göster",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();    //Mesaj penceresini kapatır

                            }
                        });


                builder.setNegativeButton("Uygulamadan çık",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                finish();
                                System.exit(0);      //Uygulamadan Çıkar.

                            }
                        });

                builder.show(); //Mesaj penceresini gösterir.

                //Mesaj pencerisi kodunun bitişi





                // Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show(); //Girilen yıl verisini alt mesaj baloncuğunda gösterir

                int yas = yashesapla(Integer.parseInt(editText.getText().toString()));
                int saat = CurrentHour();
                boolean haftasonumu = HaftaSonu();



                if (yas<20)
                {
                    if (saat>=13 && saat<16)
                    {
                        sonuc.setText("20 yaşından küçük olduğunuzdan ve\nşuan saat 13 ile 16 arası olduğundan\ndışarıya ÇIKABİLİRSİNİZ.");
                    }else
                    {
                        sonuc.setText("20 yaşından küçük olduğunuzdan ve\nşuan saat 13 ile 16 arası olmadığından\ndışarıya ÇIKAMAZSINIZ.");
                    }
                }
                else if (yas>20 && yas<65)
                {
                    if (haftasonumu)
                    {
                        if (saat<10 || saat>=20)
                        {
                            sonuc.setText("20 ile 65 yaş arasında olduğunuzdan ve\nşuan hafta sonu saat 10 ile 20 arası\nolmadığından dışarıya ÇIKAMAZSINIZ.");
                        }else
                        {
                            sonuc.setText("20 ile 65 yaş arasında olduğunuzdan ve\nşuan hafta sonu saat 10 ile 20 arası\nolduğundan dışarıya ÇIKABİLİRSİNİZ.");
                        }
                    }
                        else
                        {
                            sonuc.setText("20 ile 65 yaş arasında olduğunuzdan ve\nşuan hafta içi olduğundan hafta içi boyunca\nher saat dışarıya ÇIKABİLİRSİNİZ.");
                        }

                }
                else if (yas>65)
                {
                    if (saat>=10 && saat<13)
                    {
                        sonuc.setText("65 yaşından büyük olduğunuzdan ve\nşuan saat 10 ile 13 arası olduğundan\ndışarıya ÇIKABİLİRSİNİZ.");
                    }else
                    {
                        sonuc.setText("65 yaşından büyük olduğunuzdan ve\nşuan saat 10 ile 13 arası olmadığından\ndışarıya ÇIKAMAZSINIZ.");
                    }
                }





            }


        });





    }







    public int CurrentYear() //bu sınıf ile tarihint adlı değişkenine şuan ki yılı int veri tipinde döndürdüm
    {

     Date date = Calendar.getInstance().getTime();

     DateFormat dateFormat = new SimpleDateFormat("yyyy"); //yyyy yazarak şuan ki tarih formatını sadece yıl olarak isteyip dateFormat adlı değişkenine DateFormat veri türünde atadım. Örnek: 2020

     String tarih = dateFormat.format(date); //Üst satırda şuan ki yılı atadığım DateFormat veri türündeki dateFormat değişkenini String türündeki tarih adlı değişkenine atadım.

     int tarihint = Integer.parseInt(tarih);//String türündeki tarih adlı değişkendeki veriyi int veri türüne çevirerek tarihint adlı değişkenime atadım.


     return tarihint; //Sınıf dışında yukarıdaki ve aşağıdaki kodlarda kullanılması için tarihint değişkenini döndürdüm.

    }




    public int CurrentDay()
    {

        Date date = Calendar.getInstance().getTime();

        DateFormat dateFormat = new SimpleDateFormat("u");

        String tarih = dateFormat.format(date);

        int currentday = Integer.parseInt(tarih);


        return currentday;

    }




    public int CurrentHour()
    {

        Date date = Calendar.getInstance().getTime();

        DateFormat dateFormat = new SimpleDateFormat("k");

        String tarih = dateFormat.format(date);

        int currentday = Integer.parseInt(tarih);


        return currentday;

    }






    public boolean HaftaSonu() //bu sınıf ile şuan ki günün hafta sonu olup olmadığını belirledim.
    {
        if (CurrentDay()==6 || CurrentDay()==7)
        {
            return true; // Hafta sonudur.
        }
        else
        {
            return false; // Hafta sonu değildir.
        }
    }




    public int yashesapla(int yil) // Kullanıcının girdiği yılı şu an ki yıldan çıkararak kullanıcının yaşını hesaplayan sınıf.
    {
        return CurrentYear()-yil;
    }




//Geri tuşuna basında uygulamayı kapatmayıp uygulama kapatılsın mı? diye soran mesaj kutusu kodunun başlangıcı
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Uygulamadan çıkmak istiyor musunuz?");
        builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Evet'e basılınca aşağıdaki 2 satır ile uygulamayı kapatıp çıkacak.
                finish();
                System.exit(0);
            }
        });
        builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Hayır'a baslınca aşağıdaki satır ile soru kutucuğu kapatılacak
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    //Geri tuşuna basında uygulamayı kapatmayıp uygulama kapatılsın mı? diye soran mesaj kutusu kodunun sonu




}