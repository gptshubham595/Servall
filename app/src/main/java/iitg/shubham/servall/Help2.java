package iitg.shubham.servall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Help2 extends AppCompatActivity {
    RecyclerView recyclerView1;
    UserAdapter1 adapter;
    List<User1> productList;

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
                new User1(
                        1,
                        "Driller Machine",
                        "Contact no. 7896657541",
                        "Siang hostel",
                        "For rent INR 50 for 1 day",
                        R.drawable.drill));

        productList.add(
                new User1(
                        1,
                        "Hot Glue Gun",
                        "Contact no. 7896657541",
                        "Siang hostel",
                        "For rent INR 20 for 1 day",
                        R.drawable.glue));

        productList.add(
                new User1(
                        1,
                        "CS External Course Materials",
                        "Contact no. 7896657541",
                        "Siang hostel",
                        "Buy at INR 20 for 1 course",
                        R.drawable.cse));
        productList.add(
                new User1(
                        1,
                        "HotStar Account ",
                        "Contact no. 7896657541",
                        "Siang hostel",
                        "Buy at INR 100 for 1 year",
                        R.drawable.hotstar));

        productList.add(
                new User1(
                        1,
                        "Hammer",
                        "Contact 7896657541",
                        "Siang hostel",
                        "For rent INR 60 for 1 day",
                        R.drawable.hammer));
        productList.add(
                new User1(
                        1,
                        "Soldering Machine",
                        "Contact 7896657541",
                        "Siang hostel",
                        "For rent INR 20 for 1 day",
                        R.drawable.solder));

        productList.add(
                new User1(
                        1,
                        "Wire Cutter",
                        "Contact 7896657541",
                        "Siang hostel",
                        "For rent INR 20 for 1 day",
                        R.drawable.wirecutter));
        productList.add(
                new User1(
                        1,
                        "Cycle Pump",
                        "Contact 7896657541",
                        "Siang hostel",
                        "For rent INR 10 for 1 day",
                        R.drawable.pump));


        //creating recyclerview adapter
        UserAdapter1 adapter = new UserAdapter1(this, productList);

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
                Intent a =new Intent(getApplicationContext(), About.class);
                startActivity(a);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}