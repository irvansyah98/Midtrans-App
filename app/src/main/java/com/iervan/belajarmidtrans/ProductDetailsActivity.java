package com.iervan.belajarmidtrans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Picasso.with(this)
                .load(getIntent().getStringExtra("image"))
                .into(((ImageView) findViewById(R.id.image_product_main)));

        ((TextView) findViewById(R.id.product_name)).setText(getIntent().getStringExtra("name"));
        ((TextView) findViewById(R.id.product_price)).setText("Rp " + getIntent().getIntExtra("price",0));
        ((TextView) findViewById(R.id.product_rating)).setText(String.valueOf(getIntent().getDoubleExtra("rating",0)));

        findViewById(R.id.button_primary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailsActivity.this, OrderReviewActivity.class);
                intent.putExtra("image",getIntent().getStringExtra("image"));
                intent.putExtra("name",getIntent().getStringExtra("name"));
                intent.putExtra("price",getIntent().getIntExtra("price",0));
                intent.putExtra("qty",getIntent().getIntExtra("qty",0));
                startActivity(intent);
            }
        });
    }
}
