package e.sal.airlineticketreservationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements OnClickListener {


    Button createAccountBtn, reserveSeatBtn, cancelReservationBtn, manageSystemBtn;

    StringBuilder sb = new StringBuilder();

    AirlineTicketReservationSystem AtrSystem;
   // LogTransaction logTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         createAccountBtn = findViewById(R.id.createAccountBtn);
        createAccountBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),CreateAccount.class);
                startActivity(startIntent);
            }
        });
        reserveSeatBtn = findViewById(R.id.reserveSeatBtn);
        reserveSeatBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent (getApplicationContext(),ReserveSeat.class);
                startActivity(startIntent);
            }
        });

        manageSystemBtn = findViewById(R.id.manageSystemBtn);
        manageSystemBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),ManagerLogin.class);
                startActivity(startIntent);
            }
        });

        cancelReservationBtn = findViewById(R.id.cancelReservationBtn);
        cancelReservationBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), CancelReservation.class);
                startActivity(startIntent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent startIntent = new Intent(getApplicationContext(), CreateAccount.class);
        startActivity(startIntent);
    }


}
