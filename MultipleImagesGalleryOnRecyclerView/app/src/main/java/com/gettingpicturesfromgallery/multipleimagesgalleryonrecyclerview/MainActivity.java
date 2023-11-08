package com.gettingpicturesfromgallery.multipleimagesgalleryonrecyclerview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.Manifest;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    TextView textView;
    Button button;
    ArrayList<Uri> list;
    RecyclerAdaptor adaptor;
    String colum[]={
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    final int GALLERY_REQ_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //https://www.c-sharpcorner.com/article/how-to-select-multiple-images-from-gallery-and-display-on-recyclerview-in-androi/

        /*Select multiple images from our gallery and display them on recyclerview
        To achieve this, we need the user's permission to open the mobile gallery and
        design our layout. We also need an adaptor class for the recyclerview.
        */

        list=new ArrayList<>();
        recyclerView=findViewById(R.id.recycler);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);

        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        adaptor=new RecyclerAdaptor(list);
        recyclerView.setAdapter(adaptor);

        button.setOnClickListener(this);

        if ((ActivityCompat.checkSelfPermission(
                this, colum[0]) != PackageManager.PERMISSION_GRANTED) &&
                (ActivityCompat.checkSelfPermission(
                        this, colum[1]) != PackageManager.PERMISSION_GRANTED)){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(colum, GALLERY_REQ_CODE);
            }
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button){
            openGalley();
        }
    }

    private void openGalley() {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),GALLERY_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY_REQ_CODE && resultCode==RESULT_OK){
            // Get the Image from data
            if(data.getClipData()!=null){
                int count=data.getClipData().getItemCount();
                for(int i=0;i<count;i++){
                    // adding imageuri in array
                    list.add(data.getClipData().getItemAt(i).getUri());
                }
                adaptor.notifyDataSetChanged();
                textView.setText("Image("+list.size()+")");
            }else if(data.getData()!=null){
                String imgurl=data.getData().getPath();
                list.add(Uri.parse(imgurl));
            }
        }
    }

}