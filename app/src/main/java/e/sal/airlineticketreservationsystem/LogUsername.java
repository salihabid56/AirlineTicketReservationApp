package e.sal.airlineticketreservationsystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class LogUsername {
    private UUID uuid;
    private String username;
    private String password;
    private Date date;
    private String transactionType;
    private String transactionDate;
    private String transactionTime;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy @ HH:mm:ss");

    public LogUsername() {
        uuid = UUID.randomUUID();
        date = new Date();
    }
    public LogUsername(UUID Id){
        uuid = Id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getDateString(){ return dateFormat.format(date);}

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=-=-=-=-=-=-=\n");
        sb.append(uuid).append("\n");
        sb.append(transactionType).append(("\n"));
        sb.append(username).append("\n");
        //sb.append(date).append("\n");

        sb.append(dateFormat.format(date)).append("\n");


        //sb.append(transactionDate).append("\n");
        //sb.append(transactionTime).append("\n");
        sb.append("=-=-=-=-=-=-=\n");
        return sb.toString();
    }
}

