package com.example.tippay;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import java.util.Calendar;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import clases.Propina;

import clases.Propina;
import clases.Treballador;

public class PayPal extends AppCompatActivity {

    public static String treballador = "";
    public static String empresa = "";
    public static Float propina = 0f;
    public static final String clientKey = "AewBQqgAdj01PzIY8-9XdU9mtK6rEUPTld1jGAmXmQVWfslV0k2-3Gdeskn6C2q_mfxjpUM_x8QVTsTv";
    public static final int PAYPAL_REQUEST_CODE = 1;

    // Paypal Configuration Object
    private static PayPalConfiguration config = new PayPalConfiguration()
            // Start with mock environment. ENVIRONMENT_NO_NETWORK  When ready,
            // switch to sandbox (ENVIRONMENT_SANDBOX)
            // or live (ENVIRONMENT_PRODUCTION)
            .environment(PayPalConfiguration.ENVIRONMENT_NO_NETWORK)
            // on below line we are passing a client id.
            .clientId(clientKey);
    private EditText amountEdt;
    private TextView paymentTV;

    private View.OnClickListener PayPalListener = new View.OnClickListener(){
        public void onClick(View v) {
            // calling a method to get payment.
            getPayment();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_pal);

        // on below line we are initializing our variables.
        amountEdt = findViewById(R.id.idEdtAmount);

        // creating a variable for button, edit text and status tv.
        Button makePaymentBtn = (Button) findViewById(R.id.idBtnPay);


        // on below line adding click listener to our make payment button.
        makePaymentBtn.setOnClickListener(PayPalListener);
    }

    private void getPayment() {

        // Getting the amount from editText
        String amount = amountEdt.getText().toString();

        PayPal.propina = Float.parseFloat(amount);

        // Creating a paypal payment on below line.
        PayPalPayment payment = new PayPalPayment(new BigDecimal(String.valueOf(amount)), "EUR", "Propina",
                PayPalPayment.PAYMENT_INTENT_SALE);

        // Creating Paypal Payment activity intent
        Intent intent = new Intent(this, PaymentActivity.class);

        //putting the paypal configuration to the intent
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);

        // Putting paypal payment to the intent
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);

        // Starting the intent activity for result
        // the request code will be used on the method onActivityResult
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // If the result is from paypal
        if (requestCode == PAYPAL_REQUEST_CODE) {

            // If the result is OK i.e. user has not canceled the payment
            if (resultCode == Activity.RESULT_OK) {

                // Getting the payment confirmation
                PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);

                // if confirmation is not null
                if (confirm != null) {

                    try {

                        if(IniciarSessio.var == 'C') {
                            Propina propina = new Propina(IniciarSessio.clt.getDni(), PayPal.treballador, PayPal.empresa, PayPal.propina);
                            propina.insert(this);
                            Toast.makeText(PayPal.this, "Propina afegida ", Toast.LENGTH_SHORT).show();
                            Intent princi2 = new Intent(PayPal.this, principalClient.class);
                            startActivity(princi2);

                        }else if(IniciarSessio.var == 'T'){
                            Propina propina = new Propina(IniciarSessio.trb.getDni(), PayPal.treballador, PayPal.empresa, PayPal.propina);
                            propina.insert(this);
                            Toast.makeText(PayPal.this, "Propina afegida", Toast.LENGTH_SHORT).show();
                            Intent principalTreball = new Intent(PayPal.this, IniciarTreballador.class);
                            startActivity(principalTreball);


                        }else if(IniciarSessio.var == 'P'){
                            Propina propina = new Propina(IniciarSessio.prp.getDni(), PayPal.treballador, PayPal.empresa, PayPal.propina);
                            propina.insert(this);
                            Toast.makeText(PayPal.this, "Propina afegida", Toast.LENGTH_SHORT).show();
                            Intent principalPropie = new Intent(PayPal.this, iniciarEmpresa.class);
                            startActivity(principalPropie);

                        }

                    } catch (Exception e) {
                        // handling json exception on below line
                        Log.e("Error", "an extremely unlikely failure occurred: ", e);
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // on below line we are checking the payment status.
                Log.i("paymentExample", "The user canceled.");
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                // on below line when the invalid paypal config is submitted.
                Log.i("paymentExample", "An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
            }
        }
    }
}