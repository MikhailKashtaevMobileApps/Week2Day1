package com.example.mike.week1day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.nio.DoubleBuffer;

public class CalculateEMI extends AppCompatActivity {

    private SeekBar amount;
    private SeekBar interest;
    private SeekBar duration;
    private TextView amountDisplay;
    private TextView interestDisplay;
    private TextView durationDisplay;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_emi);

        amount = findViewById( R.id.amount );
        interest = findViewById( R.id.interest );
        duration = findViewById( R.id.duration );

        amountDisplay = findViewById( R.id.amountDisplay );
        interestDisplay = findViewById( R.id.interestDisplay );
        durationDisplay = findViewById( R.id.durationDisplay );

        result = findViewById( R.id.result );

        amount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                amountDisplay.setText(String.valueOf(progress*1000));
                evaluateEMI();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        interest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                interestDisplay.setText( String.valueOf( ((float)progress)/100 ) + "%");
                evaluateEMI();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        duration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                durationDisplay.setText( String.valueOf(progress*12) );
                evaluateEMI();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        evaluateEMI();

    }

    private void evaluateEMI(){
        String interestString = interestDisplay.getText().toString();
        Double r = Double.valueOf( interestString.substring(0, interestString.length()-1) )/100;
        Double P = Double.valueOf( amountDisplay.getText().toString() );
        Double N = Double.valueOf( durationDisplay.getText().toString() );

        Double res = ( r*P )/( 1 - Math.pow((1+r), (-N)) );

        result.setText( String.valueOf(Math.floor(res)) );
    }

}
