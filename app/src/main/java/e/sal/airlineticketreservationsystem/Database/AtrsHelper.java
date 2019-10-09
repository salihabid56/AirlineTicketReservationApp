package e.sal.airlineticketreservationsystem.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import e.sal.airlineticketreservationsystem.LogReserveSeat;
import e.sal.airlineticketreservationsystem.LogTransaction;
import e.sal.airlineticketreservationsystem.Database.AtrsSchema.ReserveSeatTable;
import e.sal.airlineticketreservationsystem.Database.AtrsSchema.TransactionLogTable;
import e.sal.airlineticketreservationsystem.LogUsername;

import static e.sal.airlineticketreservationsystem.Database.AtrsSchema.UsernameTable;

public class AtrsHelper extends SQLiteOpenHelper {
    private static final String TAG = "AirLine_Reservation";
    private static final int VERSION = 1;
    public static final String DATABASE_NAME = "AtrsDatabase.db";

    private SQLiteDatabase db;

    public AtrsHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ReserveSeatTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                ReserveSeatTable.Cols.UUID + "," +
                ReserveSeatTable.Cols.DEPARTURE + "," +
                ReserveSeatTable.Cols.ARRIVAL + "," +
                ReserveSeatTable.Cols.DEPARTURETIME + "," +
                ReserveSeatTable.Cols.FLIGHTNUMBER + "," +
                ReserveSeatTable.Cols.NUMBEROFTICKETS+ "," +
                ReserveSeatTable.Cols.RESERVATIONNUMBER+ ","+
                ReserveSeatTable.Cols.PRICE +
                ")"
        );

        db.execSQL("create table " + UsernameTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                UsernameTable.Cols.UUID + "," +
                UsernameTable.Cols.TRANSACTIONTYPE + ","+
                UsernameTable.Cols.USERNAME + "," +
                UsernameTable.Cols.PASSWORD + ","+
                UsernameTable.Cols.TRANSACTIONDATE + ","+
                UsernameTable.Cols.TRANSACTIONTIME + ","+
                UsernameTable.Cols.DATE +
                ")"
        );

        db.execSQL("create table " + TransactionLogTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                TransactionLogTable.Cols.UUID + "," +
                TransactionLogTable.Cols.TRANSACTIONTYPE + "," +
                TransactionLogTable.Cols.DEPARTURETIME + ","+
                TransactionLogTable.Cols.USERNAME + "," +
                TransactionLogTable.Cols.FLIGHTNUMBER + "," +
                TransactionLogTable.Cols.DEPARTURE + "," +
                TransactionLogTable.Cols.ARRIVAL + "," +
                TransactionLogTable.Cols.NUMBEROFTICKETS + "," +
                TransactionLogTable.Cols.RESERVATIONNUMBER + "," +
                TransactionLogTable.Cols.TRANSACTIONDATE + "," +
                TransactionLogTable.Cols.TRANSACTIONTIME  +
                ")"

        );

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private long insertLog() {
        return insertLog();
    }

    private long insertLog(LogTransaction log){
        if(this.getLogTransaction(log.getUuid()) == null ){
            return insertLog(log);
        }
        else {
            return updateLogTransaction(log);
        }
    }

    private int updateLogTransaction(LogTransaction log){
        db = this.getWritableDatabase();
        ContentValues cv = getContentValues(log);
        String whereClause = TransactionLogTable.Cols.UUID + " = ? ";
        String[] whereArgs = {log.getUuid().toString()};
        try {
            return db.update(TransactionLogTable.NAME, cv, whereClause, whereArgs);
        }
        catch (Exception e){
            Log.d(TAG, "something is wrong in updateLogTransaction");
            return -1;
        }

    }

    public long addLogTransaction(LogTransaction log) {
        ContentValues cv = getContentValues(log);
        db = this.getWritableDatabase();
        return db.insert(TransactionLogTable.NAME, null, cv);
    }


    private LogTransaction getLogTransaction(UUID logUUID){
        String whereClause = TransactionLogTable.Cols.UUID + " = ? ";
        String[] whereArgs = {logUUID.toString()};

        AtrscursorWrapper cursor = new AtrscursorWrapper(this.queryDB(TransactionLogTable.NAME,whereClause,whereArgs));
        try {
            if (cursor.getCount() == 0) {
                Log.d(TAG, "No results from getLogTransaction");
                return null;
            }
            cursor.moveToFirst();
            return cursor.getLogTransaction();
        }finally {
            cursor.close();
        }
    }

    public List<LogTransaction> getLogTransaction(){
        List<LogTransaction> logs = new ArrayList<>();

        AtrscursorWrapper cursor = new AtrscursorWrapper(this.queryDB(AtrsSchema.TransactionLogTable.NAME,null,null));
        try{
            if(cursor.getCount() == 0){
                Log.d(TAG, "getLogTransaction returned nothing...");
                return null;
            }
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                logs.add(cursor.getLogTransaction());
                cursor.moveToNext();
            }
        }finally {

            cursor.close();
        }

        return logs;
    }

    private Cursor queryDB(String DBName, String whereClause, String[] whereArgs){
        db = this.getWritableDatabase();

        try{
            return db.query(DBName,
                    null,
                    whereClause,
                    whereArgs,
                    null,
                    null,
                    null);
        }catch (Exception e){
            Log.d(TAG, "Problem in queryDB!!");
            return null;
        }
    }




    private long insertLog(LogUsername log){

        if(this.getLogUsername(log.getUuid()) == null) {
            return insertLog(log);
        }
        else{
            return updateLogUsername(log);
        }
    }


    private int updateLogUsername(LogUsername log){
        db = this.getWritableDatabase();
        ContentValues cv = getContentValues(log);
        String whereClause = UsernameTable.Cols.UUID + " = ? ";
        String[] whereArgs = {log.getUuid().toString()};



        try {
            return db.update(UsernameTable.NAME, cv, whereClause, whereArgs);
        }
        catch (Exception e){
            Log.d(TAG, "something is wrong in updateLogUsername");
            return -1;
        }

    }


    public long addLogUsername(LogUsername log) {

        ContentValues cv = getContentValues(log);
        db = this.getWritableDatabase();
        return db.insert(UsernameTable.NAME, null, cv);

    }

    private LogUsername getLogUsername(UUID logUUID) {
        String whereClause = UsernameTable.Cols.UUID + " = ? ";
        String[] whereArgs = {
                logUUID.toString()
        };

        AtrscursorWrapper cursor = new AtrscursorWrapper(this.queryDBforUsername(UsernameTable.NAME, whereClause, whereArgs));
        try {
            if (cursor.getCount() == 0) {
                Log.d(TAG, "No results from getLogUsername");
                return null;
            }
            cursor.moveToFirst();
            return cursor.getLogUsername();
        } finally {
            cursor.close();
        }

    }
    public List<LogUsername> getLogForUsername(){
        List<LogUsername> logs = new ArrayList<>();
        //logs.;


        AtrscursorWrapper cursor = new AtrscursorWrapper(this.queryDB(AtrsSchema.UsernameTable.NAME,null,null));
        try{
            if(cursor.getCount() == 0){
                Log.d(TAG, "getLogUsername returned nothing...");
                return null;
            }
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                logs.add(cursor.getLogUsername());
                cursor.moveToNext();
            }
        }finally {

            cursor.close();
        }

        return logs;
    }

    private Cursor queryDBforUsername(String DBName, String whereClause, String[] whereArgs){
        db = this.getWritableDatabase();

        try{
            return db.query(DBName,
                    null,
                    whereClause,
                    whereArgs,
                    null,
                    null,
                    null);
        }catch (Exception e){
            Log.d(TAG, "Problem in queryDB!!");
            return null;
        }
    }






    private long insertLog(LogReserveSeat log){
        if(this.getLogReserveSeat(log.getUuid()) == null) {
            return insertLog(log);
        }
        else{
            return updateLogReserveSeat(log);
        }
    }


    private int updateLogReserveSeat(LogReserveSeat log){
        db = this.getWritableDatabase();
        ContentValues cv = getContentValues(log);
        String whereClause = ReserveSeatTable.Cols.UUID + " = ? ";
        String[] whereArgs = {log.getUuid().toString()};
        try {
            return db.update(ReserveSeatTable.NAME, cv, whereClause, whereArgs);
        }
        catch (Exception e){
            Log.d(TAG, "something is wrong in updateLogUsername");
            return -1;
        }

    }


    public long addLogReserveSeat(LogReserveSeat log) {

        ContentValues cv = getContentValues(log);
        db = this.getWritableDatabase();
        return db.insert(ReserveSeatTable.NAME, null, cv);
    }

    private LogReserveSeat getLogReserveSeat(UUID logUUID) {
        String whereClause = ReserveSeatTable.Cols.UUID + " = ? ";
        String[] whereArgs = {
                logUUID.toString()
        };

        AtrscursorWrapper cursor = new AtrscursorWrapper(this.queryDBForReserveSeat(ReserveSeatTable.NAME, whereClause, whereArgs));
        try {
            if (cursor.getCount() == 0) {
                Log.d(TAG, "No results from getLogUsername");
                return null;
            }
            cursor.moveToFirst();
            return cursor.getLogReserveSeat();
        } finally {
            cursor.close();
        }

    }
    public List<LogReserveSeat> getLogForReserveSeat(){
        List<LogReserveSeat> logs = new ArrayList<>();

        AtrscursorWrapper cursor = new AtrscursorWrapper(this.queryDB(AtrsSchema.ReserveSeatTable.NAME,null,null));
        try{
            if(cursor.getCount() == 0){
                Log.d(TAG, "getLogUsername returned nothing...");
                return null;
            }
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                logs.add(cursor.getLogReserveSeat());
                cursor.moveToNext();
            }
        }finally {

            cursor.close();
        }

        return logs;
    }

    private Cursor queryDBForReserveSeat(String DBName, String whereClause, String[] whereArgs){
        db = this.getWritableDatabase();

        try{
            return db.query(DBName,
                    null,
                    whereClause,
                    whereArgs,
                    null,
                    null,
                    null);
        }catch (Exception e){
            Log.d(TAG, "Problem in queryDB!!");
            return null;
        }
    }




    private static ContentValues getContentValues(LogTransaction log){
        ContentValues cv = new ContentValues();
        cv.put(TransactionLogTable.Cols.UUID,log.getUuid().toString());
        cv.put(TransactionLogTable.Cols.TRANSACTIONTYPE, log.getTransactionType());
        cv.put(TransactionLogTable.Cols.DEPARTURETIME, log.getDepartureTime());
        cv.put(TransactionLogTable.Cols.USERNAME, log.getUsername());
        cv.put(TransactionLogTable.Cols.FLIGHTNUMBER, log.getFlightNo());
        cv.put(TransactionLogTable.Cols.DEPARTURE, log.getDeparture());
        cv.put(TransactionLogTable.Cols.ARRIVAL, log.getArrival());
        cv.put(TransactionLogTable.Cols.NUMBEROFTICKETS, log.getNumberofTickets());
        cv.put(TransactionLogTable.Cols.RESERVATIONNUMBER, log.getReservationNumber());
        cv.put(TransactionLogTable.Cols.TRANSACTIONDATE, log.getTransactionDate());
        cv.put(TransactionLogTable.Cols.TRANSACTIONTIME, log.getTransactionTime());
        return cv;
    }

    private static ContentValues getContentValues(LogUsername log){
        ContentValues cv = new ContentValues();
        cv.put(UsernameTable.Cols.UUID, log.getUuid().toString());
        cv.put(UsernameTable.Cols.TRANSACTIONTYPE, log.getTransactionType());
        cv.put(UsernameTable.Cols.PASSWORD, log.getPassword());
        cv.put(UsernameTable.Cols.USERNAME, log.getUsername());
        cv.put(UsernameTable.Cols.TRANSACTIONDATE, log.getTransactionDate());
        cv.put(UsernameTable.Cols.TRANSACTIONTIME, log.getTransactionTime());
        cv.put(UsernameTable.Cols.DATE, log.getDate().getTime());

        return cv;
    }

    private static ContentValues getContentValues (LogReserveSeat log){
        ContentValues cv = new ContentValues();
        cv.put(ReserveSeatTable.Cols.UUID, log.getUuid().toString());
        cv.put(ReserveSeatTable.Cols.FLIGHTNUMBER, log.getFlightNo());
        cv.put(ReserveSeatTable.Cols.DEPARTURE, log.getDeparture());
        cv.put(ReserveSeatTable.Cols.ARRIVAL, log.getArrival());
        cv.put(ReserveSeatTable.Cols.DEPARTURETIME, log.getDepartureTime());
        cv.put(ReserveSeatTable.Cols.NUMBEROFTICKETS,log.getReservationNumber());
        cv.put(ReserveSeatTable.Cols.RESERVATIONNUMBER,log.getReservationNumber());
        cv.put(ReserveSeatTable.Cols.PRICE, log.getPrice());

        return cv;

    }

}
