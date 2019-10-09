package e.sal.airlineticketreservationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ReserveSeatDisplay extends AppCompatActivity {
    AirlineTicketReservationSystem atrs;

    TextView seat_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        atrs = AirlineTicketReservationSystem.get(this.getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_seat_display);

        seat_tv = findViewById(R.id.seat_tv);

        seat_tv.setText(atrs.getLogStringResrveSeat());
        seat_tv.setMovementMethod(new ScrollingMovementMethod());
    }
}
