package e.sal.airlineticketreservationsystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReserveSeat extends AppCompatActivity {
    public static final String TAG = "AirLine_Reservation";

    EditText Departure;
    EditText Arrival;
    EditText NumOfTickets;
    Button SEARCH;

    AirlineTicketReservationSystem atrs;
    LogReserveSeat logReserveSeat;

    String departureInput;
    String arrivalInput;
    Integer numOfTicketInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_seat);

        Arrival = findViewById(R.id.arrival_et);
        Departure = findViewById(R.id.departure_et);
        NumOfTickets =  findViewById(R.id.numOfTraveler_et);
        SEARCH = findViewById(R.id.search_Btn);

       atrs = AirlineTicketReservationSystem.get(this.getApplicationContext());



        SEARCH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                departureInput  = Departure.getEditableText().toString().trim();
                arrivalInput = Arrival.getEditableText().toString().trim();
                numOfTicketInput = NumOfTickets.getInputType();

                if (!(validateNumberOfTickets())) {
                    return;
                } else if (departureInput.contentEquals(Otter101().getDeparture()) & arrivalInput.contentEquals(Otter101().getArrival())) {

                    logReserveSeat = Otter101();
                    atrs.addLogReserveSeat(Otter101());
                    Intent startIntent = new Intent(getApplicationContext(), ReserveSeatDisplay.class);

                    startActivity(startIntent);


                } else if (departureInput.contentEquals(Otter102().getDeparture()) & arrivalInput.contentEquals(Otter102().getArrival())) {

                    logReserveSeat = Otter102();
                    atrs.addLogReserveSeat(Otter102());
                    Intent startIntent = new Intent(getApplicationContext(), ReserveSeatDisplay.class);

                    startActivity(startIntent);


                } else if (departureInput.contentEquals(Otter201().getDeparture()) & arrivalInput.contentEquals(Otter201().getArrival())&& numOfTicketInput <=5) {

                    logReserveSeat = Otter201();
                    logReserveSeat = Otter205();
                    atrs.addLogReserveSeat(Otter201());
                    atrs.addLogReserveSeat(Otter205());
                    Intent startIntent = new Intent(getApplicationContext(), ReserveSeatDisplay.class);

                    startActivity(startIntent);


                } else if (departureInput.contentEquals(Otter205().getDeparture()) & arrivalInput.contentEquals(Otter205().getArrival()) && numOfTicketInput > 5 && numOfTicketInput< 16) {

                    logReserveSeat = Otter205();
                    atrs.addLogReserveSeat(Otter205());
                    Intent startIntent = new Intent(getApplicationContext(), ReserveSeatDisplay.class);

                    startActivity(startIntent);


                } else if (departureInput.contentEquals(Otter202().getDeparture()) & arrivalInput.contentEquals(Otter202().getArrival())) {

                    logReserveSeat = Otter202();
                    atrs.addLogReserveSeat(Otter202());
                    Intent startIntent = new Intent(getApplicationContext(), ReserveSeatDisplay.class);
                    startActivity(startIntent);

                }
                else{
                    showAlert();
                }
            }
        });



    }

    private boolean validateNumberOfTickets() {
        String numOfTravlerInput = NumOfTickets.getEditableText().toString().trim();
        int numberofTackets = Integer.parseInt(numOfTravlerInput);

        if (numberofTackets > 7) {
            NumOfTickets.setError("We don't offer more than 7 tickets to a single customer");
            return false;
        }
        return true;
    }


    private LogReserveSeat Otter101(){
        LogReserveSeat log  = new LogReserveSeat();
        log.setFlightNo(101);
        log.setDeparture("Monterey");
        log.setArrival("Los Angeles");
        log.setDepartureTime("10:00(AM)");
        //log.setFlightCapacity(10);
        log.setPrice(150.00);

        atrs.getLogStringResrveSeat();

        return log;
    }
    private LogReserveSeat Otter102(){
        LogReserveSeat log  = new LogReserveSeat();
        log.setFlightNo(102);
        log.setDeparture("Los Angeles");
        log.setArrival("Monterey");
        log.setDepartureTime("1:00(PM)");
        //log.setFlightCapacity(10);
        log.setPrice(150.00);

        atrs.getLogStringResrveSeat();

        return log;
    }

    private LogReserveSeat Otter201(){
        LogReserveSeat log  = new LogReserveSeat();
        log.setFlightNo(201);
        log.setDeparture("Monterey");
        log.setArrival("Seattle");
        log.setDepartureTime("11:00(AM)");
        //log.setFlightCapacity(5);
        log.setPrice(200.50);

        atrs.getLogStringResrveSeat();

        return log;
    }

    private LogReserveSeat Otter205(){
        LogReserveSeat log  = new LogReserveSeat();
        log.setFlightNo(205);
        log.setDeparture("Monterey");
        log.setArrival("Seattle");
        log.setDepartureTime("3:00(PM)");
        //log.setFlightCapacity(15);
        log.setPrice(150.00);

        atrs.getLogStringResrveSeat();

        return log;
    }

    private LogReserveSeat Otter202(){
        LogReserveSeat log  = new LogReserveSeat();
        log.setFlightNo(202);
        log.setDeparture("Seattle");
        log.setArrival("Monterey");
        log.setDepartureTime("2:00(PM)");
        //log.setFlightCapacity(5);
        log.setPrice(200.50);

        atrs.getLogStringResrveSeat();

        return log;
    }

    public void showAlert(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(ReserveSeat.this);
        alert.setTitle("Reserve Seat");
        alert.setMessage("Sorry! No Flights were found");
        alert.setNegativeButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ReserveSeat.this, MainActivity.class);
                startActivity(intent);
            }
        });
        alert.create().show();

    }


}
