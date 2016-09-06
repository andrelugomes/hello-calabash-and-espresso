package com.xamarin.testcloud.simplecreditcardvalidator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText creditCardNumber = (EditText) findViewById(R.id.creditCardNumberText);
        final TextView errorMessage =(TextView) findViewById(R.id.errorMessagesText);

        Button validate = (Button) findViewById(R.id.validateButton);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = creditCardNumber.getText().toString();
                boolean isValid = true;
                String errMsg = "";
                if (TextUtils.isEmpty(number)) {
                    isValid = false;
                    errMsg = "This is not a credit card number.";
                }
                else if (number.length() < 16) {
                    isValid = false;
                    errMsg = "Credit card number is too short.";
                }
                else if (number.length() > 16) {
                    isValid = false;
                    errMsg = "Credit card number is too long.";
                }

                errorMessage.setText(errMsg);

                if (isValid) {
                    Intent i = new Intent(MainActivity.this, CreditCardValidationSuccess.class);
                    startActivity(i);
                }
            }
        });

    }


}
