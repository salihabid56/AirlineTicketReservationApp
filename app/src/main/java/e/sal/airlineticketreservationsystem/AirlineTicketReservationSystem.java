package e.sal.airlineticketreservationsystem;

import android.content.Context;

import java.util.List;

import e.sal.airlineticketreservationsystem.Database.AtrsHelper;

public class AirlineTicketReservationSystem {
    private static AirlineTicketReservationSystem AtrSystem;
    private Context mContext;
    private AtrsHelper mAtrsHelper;



    public static AirlineTicketReservationSystem get(Context context){
    if(AtrSystem == null){
        AtrSystem = new AirlineTicketReservationSystem(context);
    }
    return AtrSystem;

    }
    private AirlineTicketReservationSystem(Context context) {
        mContext = context.getApplicationContext();
        mAtrsHelper = new AtrsHelper(mContext);
    }

    public long addLogTransaction(LogTransaction log) {
        return mAtrsHelper.addLogTransaction(log);
    }

    public String getLogStringTransaction(){
        StringBuilder sb = new StringBuilder();
        List<LogTransaction> logs = mAtrsHelper.getLogTransaction();

        if(logs == null){
            return "Airline Ticket Reservation System\n";
        }
        sb.append("Airline Ticket Reservation System\n");

        for(LogTransaction log : logs){
            sb.append(log.toString());
        }
        return sb.toString();
    }

    public long addLogUsername(LogUsername log) {
        return mAtrsHelper.addLogUsername(log);
    }

    public String getLogStringUsername(){
        StringBuilder sb = new StringBuilder();
        List<LogUsername> logs = mAtrsHelper.getLogForUsername();


        if(logs == null){
            return "Username logs are null\n";
        }
        sb.append("Airline Ticket Reservation System\n");

        for(LogUsername log : logs){
            sb.append(log.toString());
        }
        return sb.toString();
    }

    public long addLogReserveSeat(LogReserveSeat log) {
        return mAtrsHelper.addLogReserveSeat(log);
    }

    public String getLogStringResrveSeat(){
        StringBuilder sb = new StringBuilder();
        List<LogReserveSeat> logs = mAtrsHelper.getLogForReserveSeat();

        if(logs == null){
            return "Airline Ticket Reservation System\n";
        }
        sb.append("Airline Ticket Reservation System\n");

        for(LogReserveSeat log : logs){
            sb.append(log.toString());
        }
        return sb.toString();
    }


}
