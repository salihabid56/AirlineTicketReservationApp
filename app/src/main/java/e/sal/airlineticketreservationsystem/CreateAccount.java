package e.sal.airlineticketreservationsystem;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Patterns;

import java.util.regex.Pattern;

import e.sal.airlineticketreservationsystem.Database.AtrsHelper;
import e.sal.airlineticketreservationsystem.Database.AtrsSchema;

public class CreateAccount extends AppCompatActivity {
    public static final String TAG = "AirLine_Reservation";

    private static final Pattern USERNAME_PATTERN;

    static {
        USERNAME_PATTERN = Pattern.compile("^" +
                "(?=(.*[a-zA-Z]){3,})" +
                "(?=(.*[0-9]){1,})" +
                ".{4,}" +
                "$");
    }
    TextView CreateAccount;
    String transactionType =  " new Account";

    EditText Username;
    EditText Password;
    Button LOGIN;
    int click = 0;
    String usernameInput;



//    StringBuilder sb = new StringBuilder();


    AirlineTicketReservationSystem atrs;
    LogUsername logUsername;
    long rowID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

         atrs = AirlineTicketReservationSystem.get(this.getApplicationContext());
        //logUsername = new LogUsername();

        //String usernameInput = Username.getEditableText().toString().trim();


        Username = findViewById(R.id.userName_et);
        Password = findViewById(R.id.password_et);
        LOGIN = findViewById(R.id.login_Btn);
        CreateAccount = findViewById(R.id.createAccount_tv);



        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!validatePassword() || !validateUsername()) {
//
                    AlertDialogTwo();
                    return;
                }
                else if (usernameInput.contentEquals(getLogUsernameFromDisplay().getUsername()) || usernameInput.contentEquals(accountAlreadyExists().getUsername())) {
                    showAlertDialog3();
                    return;

                }else{

                    showAlertDialog();
                    //logUsername = new LogUsername();
                    logUsername = getLogUsernameFromDisplay();
                   // Log.i(TAG, "logUsername" + logUsername.toString());
                    atrs.addLogUsername(logUsername);

                }



            }
       });


    }

    public void showAlertDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(CreateAccount.this);
            alert.setTitle("CREATE ACCOUNT");
            alert.setMessage("Account created successfully");
            alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(CreateAccount.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(CreateAccount.this, "Thank you for creating account with us",Toast.LENGTH_SHORT).show();
                }
            });
                    alert.create().show();
        }

   public void AlertDialogTwo(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(CreateAccount.this);
        alert.setTitle("CREATE ACCOUNT");
        alert.setMessage("Account Failed! Either username or password requirement not met");
        alert.setNegativeButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(CreateAccount.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(CreateAccount.this, "Sorry! see you again", Toast.LENGTH_SHORT).show();

            }
        });
            alert.create().show();

   }


    public void showAlertDialog3(){
        AlertDialog.Builder alert = new AlertDialog.Builder(CreateAccount.this);
        alert.setTitle("CREATE ACCOUNT");
        alert.setMessage("Account Failed! Account with name " + usernameInput + " already exist");
        alert.setNegativeButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(CreateAccount.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(CreateAccount.this, "Sorry! see you again",Toast.LENGTH_SHORT).show();
            }
        });
        alert.create().show();
    }

    private boolean validateUsername() {
        //String Username =
        usernameInput = Username.getEditableText().toString().trim();


        if (usernameInput.isEmpty()) {
            Username.setError("Field cant be empty");
            return false;
        } else if (!USERNAME_PATTERN.matcher(usernameInput).matches()) {
            Username.setError("Username requirement not met");
            return false;
        } else if (usernameInput.equals("admin2")) {
            Username.setError("admin2 reserved for admin");
            return false;
        } else {
            Username.setError(null);
            return true;
        }

    }

    private boolean validatePassword() {

        String passwordInput = Password.getEditableText().toString().trim();

        if (passwordInput.isEmpty()) {
            Password.setError("Field cant be empty");
            return false;
        } else if (!USERNAME_PATTERN.matcher(passwordInput).matches()) {
            Password.setError("Password requirement not met");
            return false;
        } else {
            Username.setError(null);
            return true;
        }
    }

    private LogUsername getLogUsernameFromDisplay(){

        String username = Username.getEditableText().toString();
        String password = Password.getEditableText().toString();


        LogUsername log = new LogUsername();

        log.setUsername(username);
        log.setPassword(password);
        log.setTransactionType(transactionType);

        atrs.getLogStringUsername();


        return log;

    }

    private LogUsername accountAlreadyExists(){
        LogUsername log = new LogUsername();
        log.setUsername("chris21");
        log.setUsername("alice5");
        log.setUsername("brian77");

        atrs.getLogStringUsername();

        return log;
    }


}



