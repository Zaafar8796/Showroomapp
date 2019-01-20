package com.example.hp.showroom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    Button account;
    EditText editName, editEmail, editNumber, editPassword, editConfirmPassword, editLatitude, editLongitude;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    private StorageTask mUploadTask;


//    String editname = editName.getText().toString();
//    String editemail = editEmail.getText().toString();
//    String editnumber = editNumber.getText().toString();
//    String editpassword = editPassword.getText().toString();
//    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

//    String editconfirmpassword = editConfirmPassword.getText().toString();
//    String editlatitude = editLatitude.getText().toString();
//    String editlongitude = editLongitude.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        account = findViewById(R.id.account);
        account.setOnClickListener(this);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editNumber = findViewById(R.id.editNumber);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);
        editLatitude = findViewById(R.id.editLatitude);
        editLongitude = findViewById(R.id.editLongitude);

        mStorageRef = FirebaseStorage.getInstance().getReference("Users");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Users");


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.account:
                String editname = editName.getText().toString();
                String editemail = editEmail.getText().toString();
                String editnumber = editNumber.getText().toString();
                String editpassword = editPassword.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                String editconfirmpassword = editConfirmPassword.getText().toString();
                String editlatitude = editLatitude.getText().toString();
                String editlongitude = editLongitude.getText().toString();


                if (editname.isEmpty()) {
                    //Toast.makeText(this, "Name Required", Toast.LENGTH_SHORT).show();
                    editName.requestFocus();
                    editName.setError("Name Required");
                } else if (editemail.isEmpty()) {
                    editEmail.requestFocus();
                    editEmail.setError("Email Required");
                } else if (!editemail.matches(emailPattern)) {
                    editEmail.requestFocus();
                    editEmail.setError("Invalid Email");
                } else if (editnumber.isEmpty()) {
                    editNumber.requestFocus();
                    editNumber.setError("Number Required");
                } else if (editnumber.length() < 11) {
                    editNumber.requestFocus();
                    editNumber.setError("Invalid Number");
                } else if (editpassword.isEmpty()) {
                    editPassword.requestFocus();
                    editPassword.setError("Password Required");
                } else if (!editconfirmpassword.matches(editpassword)) {
                    editConfirmPassword.requestFocus();
                    editConfirmPassword.setError("Password not matched");
                } else if (editlatitude.isEmpty()) {
                    editLatitude.requestFocus();
                    editLatitude.setError("Enter Coordinates");
                } else if (editlongitude.isEmpty()) {
                    editLongitude.requestFocus();
                    editLongitude.setError("Enter Coordinates");
                    return;
                } else {

                    UserUpload userupload = new UserUpload(editname,editemail,editnumber,editpassword,editconfirmpassword,editlatitude,editlongitude);
                    mDatabaseRef.child(userupload.getUsername()).setValue(userupload);

                    Intent intent = new Intent(this,CarListActivity.class);
                    startActivity(intent);

                    finish();



//                    if (mUploadTask != null && mUploadTask.isInProgress()) {
//                        Toast.makeText(this, "Upload in progress", Toast.LENGTH_SHORT).show();
//                    } else {
//                        uploadFile();
//                    }

                //    User user = new User(editname,editemail,editnumber,editpassword,editconfirmpassword,editlatitude,editlongitude);
//                    user.setName("" + editname);
//                    user.setEmail("" + editemail);
//                    user.setNumber("" + editnumber);
//                    user.setPassword("" + editpassword);
//                    user.setConfirmpassword("" + editconfirmpassword);
//                    user.setLatitude("" + editlatitude);
//                    user.setLongitude("" + editlongitude);
                //    user.save();

//                    SharedPreferences mySharedPreferences;
//                    SharedPreferences.Editor myEditor;
//                    mySharedPreferences = getSharedPreferences("MyPreferences_001", 0);
//                    myEditor = mySharedPreferences.edit();
//                    myEditor.putString("email", editemail);
//                    myEditor.putBoolean("islogin", true);
//                    myEditor.commit(); //very imp.
//
//                    startActivity(new Intent(getApplicationContext(), CarListActivity.class));
//                    finish();
                }


                break;
            //Intent intent = new Intent(this, )
        }

    }


//    private void uploadFile() {
//        if (mImageUri != null) {
//            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()+ getFileExtension(editname));
//           //         + "." + getFileExtension(mImageUri));
//
//            mUploadTask = fileReference.putFile(mImageUri)
//                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            Handler handler = new Handler();
//                            handler.postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    mProgressBar.setProgress(0);
//                                }
//                            }, 500);
//
//                            Toast.makeText(getApplicationContext(), "Upload successful", Toast.LENGTH_LONG).show();
//                            User user = new User(editname,editemail,editnumber,editpassword,editconfirmpassword,editlatitude,editlongitude);
//                            String uploadId = mDatabaseRef.push().getKey();
//                            mDatabaseRef.child(uploadId).setValue(user);
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
//    //                        mProgressBar.setProgress((int) progress);
//                        }
//                    });
//        } else {
//            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
//        }
//    }
}
