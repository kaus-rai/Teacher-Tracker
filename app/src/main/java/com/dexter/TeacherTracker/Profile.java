package com.dexter.TeacherTracker;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener, GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    TextView name;
    Spinner sp;
    GoogleApiClient mGoogleSignInClient;
    Button location;
    private LocationManager locationManager;
    private LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        location = findViewById(R.id.locations);
        location.setOnClickListener(this);
        name = findViewById(R.id.name);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestEmail()
                .build();

        mGoogleSignInClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        sp = findViewById(R.id.spinner);
        String[] status = {"Available", "Busy",};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, status);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);
        //  name=findViewById(R.id.name1);
        // String username=getIntent().getExtras().getString("name");
        //name.setText(username);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
        String item = (String) parent.getItemAtPosition(pos);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onClick(View v) {
        switch (v.getId()) {
            // ...
            case R.id.sign_out:
                // signOut();
                break;
            // ...
            case R.id.locations:
                locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        double latitude =location.getLatitude();
                        double longitude = location.getLongitude();
                        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
                        DatabaseReference mChildRef = mRootRef.child("locations");


                        Log.w("On location changed","On location changed");
                        Log.e("latitude",String.valueOf(latitude));
                        Log.e("longitude",String.valueOf(longitude));
                        //Log.w("On location changed","On location changed");
                      //  mChildRef.setValue(longitude);



                    }



                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {
                        Log.w("On Status changed","On status changed and now make the changes here");


                    }

                    @Override
                    public void onProviderEnabled(String s) {
                        Log.w("On ProviderEnabled ","On provider enabled");


                    }

                    @Override
                    public void onProviderDisabled(String s) {
                        Intent intent = new Intent (Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                        Log.w("On Providerdisabled ","On provider disabled");


                    }
                };
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.INTERNET}, 10);
                    return;
                } else {
                    configureButton();
                }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] grantResults) {
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    configureButton();

                return;

        }
    }


    private void configureButton() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates("gps", 5000, 10, locationListener);
        Log.w("Continue from here ","Continue from here");


    }





//    private void signOut() {
//       // mGoogleSignInClient.signOut.addOnCompleteListener(this, new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        // ...
//                    }
//                });
//    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
