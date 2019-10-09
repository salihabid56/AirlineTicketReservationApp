package e.sal.airlineticketreservationsystem.Database;


public class AtrsSchema {
    public static final class ReserveSeatTable{
    public static final String NAME = "Reserve_Seat_Table";
    public static final class Cols {
        public static final String UUID = "uuid";
        public static final String FLIGHTNUMBER = "flightNo";
        public static final String DEPARTURE = "departure";
        public static final String ARRIVAL = "arrival";
        public static final String DEPARTURETIME = "departureTime";
        public static final String NUMBEROFTICKETS = "numberOfTickets";
        public static final String RESERVATIONNUMBER = "reservationNumber";
        public static final String PRICE = "price";
    }

    }
    public static final class UsernameTable{
       public static final String NAME = "Username_Table";
       public static final class Cols {
           public static final String UUID = "uuid";
           public static final String TRANSACTIONTYPE = "transactionType";
           public static final String USERNAME = "username";
           public static final String TRANSACTIONDATE = "transactionDate";
           public static final String TRANSACTIONTIME = "transactionTime";
           public static final String DATE = "date";
           public static final String PASSWORD = "password";
       }
   }

   public static final class TransactionLogTable{
        public static final String NAME = "Transaction_Log_Table";
        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TRANSACTIONTYPE = "transactionType";
            public static final String DEPARTURETIME = "departuretime";
            public static final String USERNAME = "username";
            public static final String FLIGHTNUMBER = "flighNo";
            public static final String DEPARTURE = "departure";
            public static final String ARRIVAL = "arrival";
            public static final String NUMBEROFTICKETS = "numberOfTickets";
            public static final String RESERVATIONNUMBER = "reservationNumber";
            public static final String  TRANSACTIONDATE = "transactionDate";
            public static final String TRANSACTIONTIME = "transactionTime";
        }
   }

}
