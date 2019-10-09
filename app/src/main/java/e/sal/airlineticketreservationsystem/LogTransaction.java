package e.sal.airlineticketreservationsystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class LogTransaction {
    private UUID uuid;
    private String transactionType;

   private String departure;
   private String departureTime;
    private String arrival;
    private int flightNo;
    private String username;
    private int numberofTickets;
    private int reservationNumber;
    private String transactionDate;
    private String transactionTime;



    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy @ HH:mm:ss");


    public LogTransaction(){
        uuid = UUID.randomUUID();
        //date = new Date();
    }
    public LogTransaction(UUID Id){
        uuid = Id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public String getTransactionType(){return transactionType;}

    public void setTransactionType(String transactionType){ this.transactionType = transactionType;}

    public String getDepartureTime() { return departureTime; }

    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
//
//    public int getFlightCapacity() {
//       return flightCapacity;
//    }
//
//    public void setFlightCapacity(int flightCapacity) {
//       this.flightCapacity = flightCapacity;
//    }

//   public double getPrice() {
//       return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }



    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }


    public int getNumberofTickets() { return numberofTickets; }

    public void setNumberofTickets(int numberofTickets) { this.numberofTickets = numberofTickets; }

    public int getReservationNumber() { return reservationNumber;}

    public void setReservationNumber(int reservationNumber) { this.reservationNumber = reservationNumber; }

    public String getTransactionDate() { return transactionDate; }

    public void setTransactionDate(String transactionDate) { this.transactionDate = transactionDate; }

    public String getTransactionTime() { return transactionTime; }

    public void setTransactionTime(String transactionTime) { this.transactionTime = transactionTime; }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=-=-=-=-=-=-=\n");
        sb.append(flightNo).append("\n");
        sb.append(departure).append("\n");
        sb.append(arrival).append("\n");


        sb.append(username).append("\n");
        sb.append(departureTime).append("\n");

        sb.append(numberofTickets).append("\n");
        sb.append(reservationNumber).append("\n");
        sb.append(transactionDate).append("\n");
        sb.append(transactionTime).append("\n");
        sb.append(transactionType).append("\n");
        sb.append("=-=-=-=-=-=-=-\n");
        return sb.toString();
    }
}
