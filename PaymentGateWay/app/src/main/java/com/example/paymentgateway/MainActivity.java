package com.example.paymentgateway;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {
    String APIKEY="rzp_test_paoEKbKyiPfB5w";
    Checkout checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Checkout.preload(getApplicationContext());
    }

    public void payment(View view) {

        checkout=new Checkout();

        checkout.setKeyID(APIKEY);
        final Activity activity=this;


        try {
            JSONObject object=new JSONObject();
            object.put("Name","Vineetha");
            object.put("amount","10000");
            object.put("themecolor","#44BB04");
            object.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            object.put("currency","INR");
            checkout.open(activity,object);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Fail \n"+s, Toast.LENGTH_SHORT).show();

    }
}
