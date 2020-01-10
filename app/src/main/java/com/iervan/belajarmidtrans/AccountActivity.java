package com.iervan.belajarmidtrans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ((com.kodetr.transaksi.widgets.WidgetsTextView)findViewById(R.id.tv_name)).setText(DataCustomer.NAME);
        ((com.kodetr.transaksi.widgets.WidgetsTextView)findViewById(R.id.tv_email)).setText(DataCustomer.EMAIL);
        ((com.kodetr.transaksi.widgets.WidgetsTextView)findViewById(R.id.tv_phone)).setText(DataCustomer.PHONE);
        ((com.kodetr.transaksi.widgets.WidgetsTextView)findViewById(R.id.tv_address)).setText(DataCustomer.ADDRESS);
    }
}
