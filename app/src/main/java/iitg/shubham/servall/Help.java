package iitg.shubham.servall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Help extends AppCompatActivity {
    RecyclerView recyclerView1;
    UserAdapter adapter;
    List<User> productList;

    private FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


        mauth=FirebaseAuth.getInstance();
        //getting the recyclerview from xml
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new User(
                        1,
                        "Shubham Kumar Gupta",
                        "Contact no. 6204553564",
                        "Siang hostel",
                        "Android App Develop.",
                        R.drawable.shubham));

        productList.add(
                new User(
                        1,
                        "Anish",
                        "Contact no. 8447876288",
                        "Siang hostel",
                        "Piano",
                        R.drawable.ashish));

        productList.add(
                new User(
                        1,
                        "Rahul Mala",
                        "Contact 9515215687",
                        "Siang hostel",
                        "Football",
                        R.drawable.mala));
        productList.add(
                new User(
                        1,
                        "Alay",
                        "Contact 9925001693",
                        "Siang hostel",
                        "TableTennis",
                        R.drawable.alay));

        productList.add(
                new User(
                        1,
                        "Ashish",
                        "Contact 7038691513",
                        "Siang hostel",
                        "Cricket",
                        R.drawable.ashish));

        //creating recyclerview adapter
        UserAdapter adapter = new UserAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView1.setAdapter(adapter);
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
                Intent a =new Intent(getApplicationContext(), iitg.shubham.servall.About.class);
                startActivity(a);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}