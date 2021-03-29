package com.example.progectstep1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, onClick {

    Button button;
    EditText products;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = findViewById(R.id.button);
        this.products = findViewById(R.id.product);
        this.textView = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        textView.setText("Загрузка");
        String product = products.getText().toString();
        if (product == null){
            textView.setText("Пустая ячейка ввода");
        }
        else if (product != null){
            Document doc = null;
            try {
                doc = (Document) Jsoup.connect("https://5ka.ru/").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements doc2 = (Elements) doc.getElementsByTagName(product);
            if (doc2 == null){
                textView.setText("нет такого продукта");
            }
            else if(doc2 != null){
                textView.setText("Такой продукт есть");
            }
        }
    }
}