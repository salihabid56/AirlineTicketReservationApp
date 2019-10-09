package e.sal.airlineticketreservationsystem.Database;

import android.database.Cursor;
import android.database.CursorWrapper;
import java.util.Date;
import java.util.UUID;

import e.sal.airlineticketreservationsystem.LogReserveSeat;
import e.sal.airlineticketreservationsystem.LogTransaction;
import e.sal.airlineticketreservationsystem.LogUsername;
import e.sal.airlineticketreservationsystem.Database.AtrsSchema.UsernameTable;
import e.sal.airlineticketreservationsystem.Database.AtrsSchema.TransactionLogTable;
import e.sal.airlineticketreservationsystem.Database.AtrsSchema.ReserveSeatTable;



public class AtrscursorWrapper extends CursorWrapper {
    public AtrscursorWrapper(Cursor cursor) {
        super (cursor);
    }
    public LogTransaction getLogTransaction(){

        String uuidString = getString(getColumnIndex(TransactionLogTable.Cols.UUID));
        String transactiontype = getString(getColumnIndex(TransactionLogTable.Cols.TRANSACTIONTYPE));
        String username = getString(getColumnIndex(TransactionLogTable.Cols.USERNAME));
        int flightNo = getInt(getColumnIndex(TransactionLogTable.Cols.FLIGHTNUMBER));
        String departure = getString(getColumnIndex(TransactionLogTable.Cols.DEPARTURE));
        String arrival = getString(getColumnIndex(TransactionLogTable.Cols.ARRIVAL));

        int numberofTickets = getInt(getColumnIndex(TransactionLogTable.Cols.NUMBEROFTICKETS));
        int reservationNumber = getInt(getColumnIndex(TransactionLogTable.Cols.RESERVATIONNUMBER));
        String transactionDate = getString(getColumnIndex(TransactionLogTable.Cols.TRANSACTIONDATE));
        String transactionTime = getString(getColumnIndex(TransactionLogTable.Cols.TRANSACTIONTIME));


        LogTransaction log = new LogTransaction(UUID.fromString(uuidString));

        log.setTransactionType(transactiontype);
        log.setUsername(username);
        log.setFlightNo(flightNo);
        log.setDeparture(departure);
        log.setArrival(arrival);
        log.setNumberofTickets(numberofTickets);
        log.setReservationNumber(reservationNumber);
        log.setTransactionDate(transactionDate);
        log.setTransactionTime(transactionTime);

        return log;
    }

    public LogUsername getLogUsername() {

        String uuidString = getString(getColumnIndex(UsernameTable.Cols.UUID));
        String username = getString(getColumnIndex(UsernameTable.Cols.USERNAME));
        String password = getString(getColumnIndex(UsernameTable.Cols.PASSWORD));
        String transactionType = getString(getColumnIndex(UsernameTable.Cols.TRANSACTIONTYPE));
        String transactionDate = getString(getColumnIndex(UsernameTable.Cols.TRANSACTIONDATE));
        String transactionTime = getString(getColumnIndex(UsernameTable.Cols.TRANSACTIONTIME));
        Date date = new Date(getLong(getColumnIndex(UsernameTable.Cols.DATE)));

        LogUsername log = new LogUsername(UUID.fromString(uuidString));

        log.setUsername(username);
        log.setPassword(password);
        log.setTransactionType(transactionType);
        log.setTransactionDate(transactionDate);
        log.setTransactionTime(transactionTime);
        log.setDate(date);

        return log;

    }

    public LogReserveSeat getLogReserveSeat() {
        String uuidString = getString(getColumnIndex(ReserveSeatTable.Cols.UUID));
        int flightNo = getInt(getColumnIndex(ReserveSeatTable.Cols.FLIGHTNUMBER));
        String departure = getString(getColumnIndex(ReserveSeatTable.Cols.DEPARTURE));
        String arrival = getString(getColumnIndex(ReserveSeatTable.Cols.ARRIVAL));
        String departureTime = getString(getColumnIndex(ReserveSeatTable.Cols.DEPARTURETIME));
        int numberOfTickets = getInt(getColumnIndex(ReserveSeatTable.Cols.NUMBEROFTICKETS));
       int reservationNumber = getInt(getColumnIndex(ReserveSeatTable.Cols.RESERVATIONNUMBER));
        double price = getDouble(getColumnIndex(ReserveSeatTable.Cols.PRICE));

        LogReserveSeat log = new LogReserveSeat(UUID.fromString(uuidString));

        log.setFlightNo(flightNo);
        log.setDeparture(departure);
        log.setArrival(arrival);
        log.setDepartureTime(departureTime);
        log.setNumberOfTickets(numberOfTickets);
        log.setReservationNumber(reservationNumber);
        log.setPrice(price);

        return log;
    }
}

