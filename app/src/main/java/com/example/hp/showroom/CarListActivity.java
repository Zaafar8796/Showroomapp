package com.example.hp.showroom;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class CarListActivity extends AppCompatActivity implements View.OnClickListener{

   // private FirebaseStorage mStorageRef;
    //private FirebaseDatabase mDatabaseRef;

    TextView nameCar;

    FirebaseDatabase database;
    DatabaseReference myRef ;
    List<CarUpload> list;

    private List<Car> carList = new ArrayList<>();
    private RecyclerView carRecycler;
    private CarAdapter mAdapter;

    //RecyclerView carRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);


//        nameCar = findViewById(R.id.nameCar);
//        nameCar.setOnClickListener(this);

        carRecycler = findViewById(R.id.carRecycler);

        mAdapter = new CarAdapter(carList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        carRecycler.setLayoutManager(mLayoutManager);
        carRecycler.setItemAnimator(new DefaultItemAnimator());
        carRecycler.setAdapter(mAdapter);

//        mStorageRef = FirebaseStorage.getInstance();
//        mDatabaseRef = FirebaseDatabase.getInstance();
////        myRef = database.getReference("Cars");

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                list = new ArrayList<CarUpload>();
//                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
//
//                    CarUpload value = dataSnapshot1.getValue(CarUpload.class);
//                    CarUpload car = new CarUpload();
//                    String name = value.getCarname();
//                    String price = value.getPrice();
//                    //String email = value.getEmail();
//                    car.setCarname(name);
//                    car.setPrice(price);
//                    //car.setAddress(address);
//                    list.add(car);
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("Hello", "Failed to read value.", error.toException());
//            }
//        });



        prepareCarData();


    }

    private void prepareCarData() {

        Car car = new Car("Honda City","Honda", "2012", "152351VF","VTR","Manual","50000Km","Lahore","Total Genuine","Hello", "Rs15,00,000");
        carList.add(car);

        car = new Car("Toyota Corolla","Toyota", "2012", "152351VF","VTR","Manual","50000Km","Lahore","Total Genuine","Hello", "Rs12,00,000");
        carList.add(car);

        car = new Car("Honda Freed","Honda", "2012", "152351VF","VTR","Manual","50000Km","Lahore","Total Genuine","Hello", "Rs15,50,000");
        carList.add(car);

        car = new Car("Honda Spike","Honda", "2010", "155451VF","VTR","Automatic","20000Km","Lahore","Total Genuine","Hello", "Rs14,00,000");
        carList.add(car);

        car = new Car("Toyota Corolla Gli","Toyota", "2012", "152351VF","VTR","Manual","50000Km","Lahore","Total Genuine","Hello", "Rs19,50,0000");
        carList.add(car);

        car = new Car("Toyota Corolla Xli","Toyota", "2012", "152351VF","VTR","Manual","50000Km","Lahore","Total Genuine","Hello", "Rs13,00,000");
        carList.add(car);

        car = new Car("Suzuki WagonR","Suzuki", "2012", "152351VF","VTR","Manual","50000Km","Lahore","Total Genuine","Hello", "Rs10,00,000");
        carList.add(car);

        car = new Car("Toyota Prius","Toyota", "2012", "152351VF","VTR","Manual","50000Km","Lahore","Total Genuine","Hello", "Rs13,00,000");
        carList.add(car);

        car = new Car("Suzuki Cultus","Suzuki", "2012", "152351VF","VTR","Manual","50000Km","Lahore","Total Genuine","Hello", "Rs15,00,000");
        carList.add(car);

        car = new Car("Toyota Corolla Altis","Toyota", "2012", "152351VF","VTR","Manual","50000Km","Lahore","Total Genuine","Hello", "Rs18,00,000");
        carList.add(car);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.myAccount:
                Intent intent1 = new Intent(this, ProfileActivity.class);
                startActivity(intent1);

                break;

            case R.id.about:
                Intent intent3 = new Intent(this, AboutActivity.class);
                startActivity(intent3);

                break;

            case R.id.record:
                Intent intent2 = new Intent(this, AddCarRecordActivity.class);
                startActivity(intent2);
                break;

            case R.id.facebook:
                facebookpage("297572154275335");

                break;
            case R.id.logout:
                SharedPreferences mySharedPreferences;
                SharedPreferences.Editor myEditor;
                mySharedPreferences = getSharedPreferences("MyPreferences_001", 0);
                myEditor = mySharedPreferences.edit();
                myEditor.putBoolean("islogin", false);
                myEditor.commit();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
        }
        return true;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.nameCar:

                Intent intent = new Intent(this, CarFragmentActivity.class);
                startActivity(intent);

                break;
        }


    }

    private  void facebookpage(String id){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"+id));
            startActivity(intent);
        }catch(ActivityNotFoundException e){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"+id));
            startActivity(intent);
        }
    }
}
