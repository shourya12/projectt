package firebase.google.com.homedroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

  EditText e1,e2;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
       e1=findViewById(R.id.editText);

       e2=findViewById(R.id.editText2);

        ImageView imageView=findViewById(R.id.imageView2);

        Button button=findViewById(R.id.button3);

        Button button1=findViewById(R.id.button4);

        auth=FirebaseAuth.getInstance();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,signin.class);
                startActivity(intent);
            }
        });
    }

    public void loginUser (View v)
    {
        if (e1.getText().toString().equals("") && e2.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Blank not Allowed",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String email=e1.getText().toString();
            String password=e2.getText().toString();
            auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                            Intent i =new Intent(Main2Activity.this,Main3Activity.class);
                            startActivity(i);
                            finish();
                        }
                            else {

                                Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

        }

    }




}
