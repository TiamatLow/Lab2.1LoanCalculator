package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView textViewPayment,textViewStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        textViewPayment = (TextView)findViewById(R.id.textViewPayment);
        textViewStatus = (TextView)findViewById(R.id.textViewStatus);

        //To receive data from another Activity
        Intent intent = getIntent();//Asking "who called me?"
        double payment = intent.getDoubleExtra(MainActivity.MONTHLY_PAYMENT , 0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);


        textViewPayment.setText("Monthly Payment:" + payment);
        textViewStatus.setText("Status:" + status);
    }

    public void closeActivity(View view){
        finish();
    }
}
