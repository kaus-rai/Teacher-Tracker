package com.dexter.TeacherTracker;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
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



public  class Profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener, GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    TextView name;
    Spinner sp;
    GoogleApiClient mGoogleSignInClient;
    Button sign_out, locations;
     LocationManager locationManager;
    LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        sign_out = findViewById(R.id.sign);
        sign_out.setOnClickListener(this);
        locations = findViewById(R.id.locations);
        locations.setOnClickListener(this);

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
        name = findViewById(R.id.name1);
        //String username = getIntent().getExtras().getString("name");
       // name.setText(username);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
        String item = (String) parent.getItemAtPosition(pos);


    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.sign_out:
                //signOut();
                break;

            case R.id.locations:
                locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location locations) {
                        double latitude = locations.getLatitude();
                        double longitude = locations.getLongitude();
                        Log.w("LAT", String.valueOf(latitude));
                        Log.w("LNG",String.valueOf(longitude));
                    }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {


                    }

                    @Override
                    public void onProviderEnabled(String s) {


                    }

                    @Override
                    public void onProviderDisabled(String s) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);


                    }

                };
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.INTERNET}, 10);
                    }
                } else {
                    configButton();
                }





break;
        }
    }

     @Override
     public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResults) {
         switch (requestCode) {
             case 10:
                 if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                     configButton();

         }
     }
    private void configButton() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;

        }
        locationManager.requestLocationUpdates("gps",5000,0,locationListener);
    }






    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


}
