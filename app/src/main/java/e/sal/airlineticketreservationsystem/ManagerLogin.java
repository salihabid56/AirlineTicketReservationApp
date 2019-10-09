package e.sal.airlineticketreservationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import e.sal.airlineticketreservationsystem.Database.AtrsHelper;

public class ManagerLogin extends AppCompatActivity {

    public static final String TAG = "AirLine_Reservation";
    AirlineTicketReservationSystem atrs;
    EditText Username;
    EditText Password;
    Button LOGIN;
   // long rowID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_login);

        Username = findViewById(R.id.mUserName_et);
        Password = findViewById(R.id.mPassword_et);
        LOGIN = findViewById(R.id.mlogin_et);


        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatePassword() | !validateUsername()) {
                    return;
                }
                Intent startIntent = new Intent(getApplicationContext(),ManageSystem.class);

               startActivity(startIntent);
            }
        });

    }

    private boolean validateUsername() {
        //String Username =
        String usernameInput =Username.getEditableText().toString().trim();

        if (usernameInput.isEmpty()) {
            Username.setError("Field cant be empty");
            return false;
        } else if (!(usernameInput.equals("admin2"))) {
            Username.setError("Incorrect username");
            return false;
        } else {
            return true;
        }

    }

    private boolean validatePassword() {
        //String Username =
        String passwordInput = Password.getEditableText().toString().trim();

        if (passwordInput.isEmpty()) {
            Password.setError("Field cant be empty");
            return false;
        } else if (!(passwordInput.equals("admin2"))) {
            Password.setError("Incorrect Password");
            return false;
        } else {
            return true;
        }
    }
}

