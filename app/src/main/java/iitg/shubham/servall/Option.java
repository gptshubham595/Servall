package iitg.shubham.servall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Option extends AppCompatActivity {
Button b1,b2;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        mauth=FirebaseAuth.getInstance();
        b1=(Button)findViewById(R.id.help);

        b2=(Button)findViewById(R.id.buy);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(),Help2.class);
                startActivity(a);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(),Help.class);
                startActivity(a);
            }
        });
        


}



    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser cu=mauth.getCurrentUser();
        if(cu == null){
            Logout();
        }
    }

    private void Logout() {
        Intent i = new Intent(getApplicationContext(),Start.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);

        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        // Associate searchable configuration with the SearchView
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "Home Settings Click", Toast.LENGTH_SHORT).show();
                Intent i4 =new Intent(getApplicationContext(), Settings.class);
                startActivity(i4);

                return true;


            case R.id.logout:
                mauth.signOut();
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                Logout();
                return true;
            case R.id.about:
                Intent a =new Intent(getApplicationContext(), About.class);
                startActivity(a);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

