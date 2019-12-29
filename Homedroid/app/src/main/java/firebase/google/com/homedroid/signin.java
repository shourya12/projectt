package firebase.google.com.homedroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
    EditText e1,e2;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        getSupportActionBar().hide();
         e1=(EditText) findViewById(R.id.editText5);
        e2=(EditText) findViewById(R.id.editText6);

        Button button=findViewById(R.id.button6);

        auth=FirebaseAuth.getInstance();



    }
    public void createuser (View v)
    {
        if (e1.getText().toString().equals("") && e2.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Blank not Allowed",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String email=e1.getText().toString();
            String password=e2.getText().toString();
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful())
                      {
                          Toast.makeText(getApplicationContext(),"User Created Successfully",Toast.LENGTH_SHORT).show();
                      }
                      else
                      {
                          Toast.makeText(getApplicationContext(),"User could not be created",Toast.LENGTH_SHORT).show();
                      }
                    }
                });
        }

    }
}
