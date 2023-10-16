package com.uploadimageusingcamera.getimagefromcameraexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Getting pictures from camera to app
    ImageView iv_imgCamera;
    Button btn_openCamera;
    private final int CAMERA_REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_imgCamera = findViewById(R.id.iv_imgCamera);
        btn_openCamera = findViewById(R.id.btn_openCamera);

        /*Now Button ka click pay camera wala App open karwana hai,
         * Use Implicit Intent passing - jab bhi apko Apna App say dusara App mai jana ho,
         * Yani particular (type) mention karna padaga Intent ka, ki is particular type ka Intent open karwana hai
         * toh Android kudh say Identify karaga ki is type ka Intent kaun open kar sakta hai.
         * Camera App Type - ACTION_IMAGE_CAPTURE -> MediaStore class
         * Agar aap (Intent Chooser) nahi lagata ho, toh default camera App will open.*/

        btn_openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //1 way to set Action directly
                //Is particular ACTION_IMAGE_CAPTURE ki jitni bhi Apps hai, woh is say open ho sakta hai
                //iCamera.setAction(MediaStore.ACTION_IMAGE_CAPTURE); //2 way to set Action

                //startActivity(iCamera); Nahi use karanga bec.,
                //Jab hum Implicit Intent passing karta hai, yani ak app say dusari app mai jara hai or agar,
                //dusari app say wapis jab apni app mai ata hu toh kuch Data lara hu, toh us case mai hamasa,
                //startActivityForResult(); use karunga.
                startActivityForResult(iCamera, CAMERA_REQ_CODE);

                //Data wapis la kar ara hu Apni App ka anadar, toh RE-ENTER (Activity)
                //onActivityResult(int requestCode, int resultCode, @Nullable Intent data){} say hoga.

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) { //not null, data is there

            //diff. request code ka leya if else-if
            if (requestCode == CAMERA_REQ_CODE) {
                //for camera
                //data convert -> bitmap -> set image on imageview
                //In Android, image ko handle karna ka leya jo DATATYPE hota hai -> Bitmap
                //Bitmap img = (Bitmap) data.getExtras().get("data"); //get return-type object?(kisi bhi type ka data ko handle kar sakta hai).
                Bundle bundle = data.getExtras();
                Bitmap img = (Bitmap) bundle.get("data");
                iv_imgCamera.setImageBitmap(img);
                Toast.makeText(this, "Request Code: "+requestCode, Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Result Code: "+resultCode, Toast.LENGTH_SHORT).show();
        }

    }


}