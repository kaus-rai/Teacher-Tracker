package com.dexter.TeacherTracker;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class Login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,View.OnClickListener {
    SignInButton signin;
    TextView text;
    String name;
    GoogleApiClient mGoogle;
    private static final String TAG="SignIn Activity";
    private static final int sign=9001;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestEmail()
                .build();
        mGoogle = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        text = (TextView) findViewById(R.id.text);
        signin = (SignInButton) findViewById(R.id.signin);
        signin.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signin:
                signIn();
                break;
        }
    }
    private void signIn(){
        Intent signInIntent= Auth.GoogleSignInApi.getSignInIntent(mGoogle);
        startActivityForResult(signInIntent,sign);
    }
    public void onActivityResult(int requestcode, int resultcode, Intent data)
    {
        super.onActivityResult(requestcode,resultcode,data);
        if(requestcode==sign)
        {
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    private void handleSignInResult(GoogleSignInResult result)
    {
        Log.d(TAG,"handleSignInResult:"+result.isSuccess());
        if(result.isSuccess())
        {
            GoogleSignInAccount acc=result.getSignInAccount();
            Intent i=new Intent(getApplicationContext(),branches.class);
            name=acc.getDisplayName();
//            i.putExtra("name",name);
            Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }

    }
    public void onConnectionFailed(ConnectionResult ConnectionResult){
        Log.d(TAG, "onConnectionFailed:"+ ConnectionResult);
    }

}