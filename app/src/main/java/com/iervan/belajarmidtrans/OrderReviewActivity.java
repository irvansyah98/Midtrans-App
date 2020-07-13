package com.iervan.belajarmidtrans;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.midtrans.sdk.corekit.callback.TransactionCallback;
import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.core.PaymentMethod;
import com.midtrans.sdk.corekit.core.SdkCoreFlowBuilder;
import com.midtrans.sdk.corekit.core.themes.CustomColorTheme;
import com.midtrans.sdk.corekit.models.snap.TransactionResult;
import com.midtrans.sdk.uikit.SdkUIFlowBuilder;
import com.squareup.picasso.Picasso;

public class OrderReviewActivity extends AppCompatActivity implements TransactionFinishedCallback {

    private static final String TAG = OrderReviewActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_review);

        initMidtransSdk();
        init();
    }

    private void initMidtransSdk() {
        SdkUIFlowBuilder.init()
                .setContext(this)
                .setMerchantBaseUrl("url php")
                .setClientKey("Client Key Midtrans")
                .setTransactionFinishedCallback(this)
                .enableLog(true)
                .setColorTheme(new CustomColorTheme("#FFE51255","#B61548","FFE51255"))
                .buildSDK();
    }

    @SuppressLint("SetTextI18n")
    private void init(){
        ((TextView) findViewById(R.id.text_amount)).setText("Rp " + (getIntent().getIntExtra("qty",0) * getIntent().getIntExtra("price",0)));

        Picasso.with(this)
                .load(getIntent().getStringExtra("image"))
                .resize(100, 100)
                .into(((ImageView) findViewById(R.id.product_image)));

        ((TextView) findViewById(R.id.product_name)).setText(getIntent().getStringExtra("name"));
        ((TextView) findViewById(R.id.product_qty)).setText(getIntent().getStringExtra("qty"));
        ((TextView) findViewById(R.id.product_price_amount)).setText("Rp " + getIntent().getIntExtra("price",0));


        ((EditText) findViewById(R.id.edit_customer_name)).setText(DataCustomer.NAME);
        ((EditText) findViewById(R.id.edit_customer_email)).setText(DataCustomer.EMAIL);
        ((EditText) findViewById(R.id.edit_customer_phone)).setText(DataCustomer.PHONE);
        ((TextView) findViewById(R.id.delivery_address)).setText(DataCustomer.ADDRESS);

        findViewById(R.id.button_primary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionButton();
            }
        });
    }

    private void actionButton() {

            MidtransSDK.getInstance().setTransactionRequest(DataCustomer.transactionRequest(
                    "1",10000,
                    getIntent().getIntExtra("qty",0),
                    getIntent().getStringExtra("name")
            ));
        MidtransSDK.getInstance().setTransactionRequest(DataCustomer.transactionRequest(
                "2",20000,
                getIntent().getIntExtra("qty",0),
                getIntent().getStringExtra("name")
        ));
            MidtransSDK.getInstance().startPaymentUiFlow(this);

    }

    @Override
    public void onTransactionFinished(TransactionResult result) {
        if (result.getResponse() != null){
            switch (result.getSource()){
                case TransactionResult.STATUS_SUCCESS:
                    Toast.makeText(this, "Transaction Finished ID : " + result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
                case TransactionResult.STATUS_PENDING:
                    Toast.makeText(this, "Transaction Pending ID : " + result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
                case TransactionResult.STATUS_FAILED:
                    Toast.makeText(this, "Transaction Failed ID : " + result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
            }
            result.getResponse().getValidationMessages();
        }else if(result.isTransactionCanceled()){
            Toast.makeText(this, "Transaction Canceled", Toast.LENGTH_SHORT).show();
        }else{
            if (result.getStatus().equalsIgnoreCase(TransactionResult.STATUS_INVALID)){
                Toast.makeText(this, "Transaction Invalid", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Transaction Finish with failure", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
