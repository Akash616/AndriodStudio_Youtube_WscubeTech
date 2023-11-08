package com.androidruntimepermission.runtimepermissiondialogbox;

import static android.Manifest.permission.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_request;
    private static final int REQ_CODE = 100;
    //final - value change na ho
    //static - kahi say bhi call kar saku, bina Object ko create kiya hua.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Permission Dialog Box
        /*koi bhi RESOURCES agar apko phone ka use karna hai, apni app say
          toh usko MANIFEST ka andar add karna hoga.
        -> 2 types of permission - non-risky and risky permission.
          non-risky: App install, automatically permission allowed. ex- INTERNET, etc
          risky: runtime mai permission dialog box show karna hoga. ex- READ_SMS, ACCESS_FINE_LOCATION, etc*/

        btn_request = findViewById(R.id.btn_request);

        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkPer()) {
                    Toast.makeText(MainActivity.this, "Permission Already Granted!", Toast.LENGTH_SHORT).show();
                    //permission milna ka baad jo bhi kaam karana hai, yaha karna hai.
                    //same code create method
                    nowCode();
                } else {
                    //Permission Dialog Box Through
                    //String[] permissions: One or multiple permission in single dialog box.
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{ACCESS_FINE_LOCATION, READ_SMS}, REQ_CODE); //dialog box open
                }

            }
        });

    }

    private void nowCode() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //permission grant hua ki nahi ya method batata hai, result.

        if (requestCode == REQ_CODE) {

            if (grantResults.length > 0) { //if per. granted then, length is > 0
                int loc = grantResults[0];
                int msg = grantResults[1];

                boolean checkLoc = loc == PackageManager.PERMISSION_GRANTED;
                boolean checkMsg = msg == PackageManager.PERMISSION_GRANTED;

                if (checkLoc && checkMsg){
                    Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show();
                    //permission milna ka baad jo bhi kaam karana hai, yaha karna hai.
                    //same code create method
                    nowCode();
                } else {
                    Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
                }

            }

        }

    }

    public boolean checkPer() {
        int resultLocation = ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION);
        int resultMsgRead = ActivityCompat.checkSelfPermission(this, READ_SMS);
        return resultLocation == PackageManager.PERMISSION_GRANTED && resultMsgRead == PackageManager.PERMISSION_GRANTED;
    }


}