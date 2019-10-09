package e.sal.airlineticketreservationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ManageSystem extends AppCompatActivity {
    AirlineTicketReservationSystem atrs;

    TextView userLog_tv;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        atrs = AirlineTicketReservationSystem.get(this.getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_system);
        userLog_tv = findViewById(R.id.userLog_tv);

//        st = getIntent().getExtras().getString("logs");
//        userLog_tv.setText(st);

        userLog_tv.setText(atrs.getLogStringUsername());
        userLog_tv.setMovementMethod(new ScrollingMovementMethod());



//
    }
//    private LogTransaction getLogTransactionFromDisplay(){
//        String  =
    //}
}
