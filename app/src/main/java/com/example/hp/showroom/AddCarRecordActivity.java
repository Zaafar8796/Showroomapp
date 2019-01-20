package com.example.hp.showroom;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import java.io.IOException;


public class AddCarRecordActivity extends AppCompatActivity implements View.OnClickListener {

    Button addImageButton, addRecordButton;
    ImageView carImage;
    EditText editCarName, editBrand, editModel, editVariant, editTransmission, editMileage, editCity, editDescription, editChasis, editPrice;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    private StorageTask mUploadTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_record);

        carImage = findViewById(R.id.carImage);
        addImageButton = findViewById(R.id.addImageButton);
        addImageButton.setOnClickListener(this);

        editCarName = findViewById(R.id.editCarName);
        editBrand = findViewById(R.id.editBrand);
        editModel = findViewById(R.id.editModel);
        editVariant = findViewById(R.id.editVariant);
        editTransmission = findViewById(R.id.editTransmission);
        editMileage = findViewById(R.id.editMileage);
        editCity = findViewById(R.id.editCity);
        editDescription = findViewById(R.id.editDescription);
        editChasis = findViewById(R.id.editChasis);
        editPrice = findViewById(R.id.editPrice);

        addRecordButton = findViewById(R.id.addRecordButton);
        addRecordButton.setOnClickListener(this);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Cars");
        mStorageRef = FirebaseStorage.getInstance().getReference("Cars");



    }

    public final static int PICK_PHOTO_CODE = 1046;

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.addImageButton:

                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, PICK_PHOTO_CODE);
                }

                break;

            case R.id.addRecordButton:

                String editcarname = editCarName.getText().toString();
                String editbrand = editBrand.getText().toString();
                String editmodel = editModel.getText().toString();
                String editchasis = editChasis.getText().toString();
                String editvariant = editVariant.getText().toString();
                String edittransmission = editMileage.getText().toString();
                String editmileage = editMileage.getText().toString();
                String editcity = editCity.getText().toString();
                String editprice = editPrice.getText().toString();
                String editdescription = editDescription.getText().toString();

                if (editcarname.isEmpty() || editbrand.isEmpty() || editmodel.isEmpty() || editchasis.isEmpty() || editvariant.isEmpty() || edittransmission.isEmpty() || editmileage.isEmpty() || editcity.isEmpty() || editprice.isEmpty() || editdescription.isEmpty()) {
                    Toast.makeText(this, "Fill all fields", Toast.LENGTH_LONG).show();
                } else {


                    CarUpload carupload = new CarUpload(editcarname,editbrand,editmodel,editchasis,editvariant,edittransmission,editmileage,editcity,editdescription,"image",editprice);
                    mDatabaseRef.child(carupload.getCarname()).setValue(carupload);


//                    Car car = new Car();
//                    car.setCarname("" + editcarname);
//                    car.setBrandname("" + editbrand);
//                    car.setModel("" + editmodel);
//                    car.setChasis("" + editchasis);
//                    car.setVariant("" + editvariant);
//                    car.setTransmission("" + edittransmission);
//                    car.setMileage("" + editmileage);
//                    car.setCity("" + editcity);
//                    car.setPrice("" + editprice);
//                    car.setDescription("" + editdescription);
//                    car.save();

                    Intent intent1 = new Intent(this,CarListActivity.class);
                    startActivity(intent1);
                }


        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Uri photoUri = data.getData();

            // Do something with the photo based on Uri
            Bitmap selectedImage = null;
            try {
                selectedImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoUri);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Load the selected image into a preview
            carImage.setImageBitmap(selectedImage);
        }
    }
}

