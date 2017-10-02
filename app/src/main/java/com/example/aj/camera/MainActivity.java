package com.example.aj.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//By the help of android startActivityForResult() method, we can get result from another activity.

//By the help of android startActivityForResult() method, we can send information from one activity to another and vice-versa. The android startActivityForResult method, requires a result from the second activity (activity to be invoked).

  //      In such case, we need to override the onActivityResult method that is invoked automatically when second activity returns result.

//The Bitmap (android.graphics.Bitmap) class represents a bitmap image. You create bitmaps via the BitmapFactory (android.graphics.BitmapFactory) class. Using a BitmapFactory, you can create bitmaps in three common ways: from a resource, a file, or an InputStream.
public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) this.findViewById(R.id.imageView1);
        Button photoButton = (Button) this.findViewById(R.id.button1);

        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera, CAMERA_REQUEST);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
}
