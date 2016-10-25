package com.example.gallerytest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Gallery gallery;
    ImageView ImgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery=(Gallery)findViewById(R.id.gallery_1);
        ImgMain = (ImageView)findViewById(R.id.imgv_main);
    }

    public class MyGalleryAdapter extends BaseAdapter {

        Context context;
        int[] postarIDs={R.drawable.movie01,R.drawable.movie02,R.drawable.movie03,
                         R.drawable.movie04,R.drawable.movie05,R.drawable.movie06};

        public MyGalleryAdapter(Context context) {
            this.context = context;
        }

        public int getCount() {

            return postarIDs.length;
        }

        public View getView(int posistion, View convertView, ViewGroup parent) {
            ImageView imgV = new ImageView(context);
            imgV.setLayoutParams(new Gallery.LayoutParams(100,150));
            imgV.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgV.setImageResource(postarIDs[posistion]);

            final int pos = posistion;
            imgV.setOnTouchListener(new View.OnTouchListener() {
             public boolean onTouch(View v, MotionEvent event) {
                 ImgMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
                 ImgMain.setImageResource(postarIDs[pos]);
                 return false;
            }
        });

            return imgV;
        }


        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}