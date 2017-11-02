package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextPrice, editTextDownpayment,editTextInterest,editTextRepayment,editTextSalary;

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        editTextDownpayment = (EditText)findViewById(R.id.editTextDownpayment);
        editTextInterest = (EditText)findViewById(R.id.editTextInterest);
        editTextRepayment = (EditText)findViewById(R.id.editTextRepayment);
        editTextSalary = (EditText)findViewById(R.id.editTextSalary);
    }

    public void calculation(View view){
        //TODO: calculate monthly payment and determine the loan start
        double montlypayment = 0;
        String status = "Approved";

        montlypayment = ((Double.parseDouble(editTextPrice.getText().toString())-Double.parseDouble(editTextDownpayment.getText().toString()))
                +(Double.parseDouble(editTextPrice.getText().toString())-Double.parseDouble(editTextDownpayment.getText().toString()))
                *(Double.parseDouble(editTextInterest.getText().toString())/100)*
                (Double.parseDouble(editTextRepayment.getText().toString())/12))
                /Double.parseDouble(editTextRepayment.getText().toString());

        if(montlypayment>Double.parseDouble(editTextSalary.getText().toString())*0.3)
            status = "Rejected";
        //Create an Intent
        Intent intent = new Intent(this, ResultActivity.class);
        //TODO: passing data using putExtra method
        //format:putExtra(TAG, value)
        intent.putExtra(MONTHLY_PAYMENT,montlypayment);
        intent.putExtra(LOAN_STATUS, status);

        startActivity(intent);
    }

    public void reset(View view){
        editTextPrice.setText("");
        editTextDownpayment.setText("");
        editTextInterest.setText("");
        editTextRepayment.setText("");
        editTextSalary.setText("");
    }
}
