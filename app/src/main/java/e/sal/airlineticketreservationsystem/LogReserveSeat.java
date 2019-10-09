package e.sal.airlineticketreservationsystem;

import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.Date;

public class LogReserveSeat {
    private UUID uuid;
    private int flightNo;
    private String departure;
    private String arrival;
    private int numberOfTickets;
    private int reservationNumber;
    private String departureTime;
    private double price;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy @ HH:mm:ss");
    private int flightCapacity;

    public LogReserveSeat() {
        uuid = UUID.randomUUID();
        Date date = new Date();
    }

    public LogReserveSeat(UUID Id) {
        uuid = Id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setFlightCapacity(int flightCapacity) {
        this.flightCapacity = flightCapacity;
    }

    public int getFlightCapacity() {
        return flightCapacity;
    }


    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    // public String getDateString(){return dateFormat.format(date);}

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("=-=-=-=-=-=-\n");
        sb.append(flightNo).append("\n");
        sb.append(flightCapacity).append("\n");
        sb.append(departure).append("\n");
        sb.append(arrival).append("\n");
        sb.append(departureTime).append("\n");
        sb.append(numberOfTickets).append("\n");
        sb.append(reservationNumber).append("\n");
        sb.append(price).append("\n");
        sb.append("=-=-=-=-=-=-=-\n");
        return sb.toString();

    }

}


