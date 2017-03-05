package com.example.harshil.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

/**
 * Created by Harshil on 02/03/2017.
 */

public class GalleryAndroidActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);
        np.setMinValue(10);
        np.setMaxValue(20);

        Gallery g = (Gallery) findViewById(R.id.gallery);

        g.setAdapter(new ImageAdapter(this));

        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v,
                                    int position, long id) {
                Toast.makeText(GalleryAndroidActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;
        private Integer[] mImageIds = {R.drawable.spinosaure, R.drawable.triceratops, R.drawable.tyrannosaure};

        private ImageAdapter(Context c) {
            mContext = c;
            TypedArray a = mContext.obtainStyledAttributes(R.styleable.GalleryAndroid);
            mGalleryItemBackground = a.getResourceId(R.styleable.GalleryAndroid_android_galleryItemBackground, 5);
            a.recycle();
        }

        public int getCount() {
            return mImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);
            i.setImageResource(mImageIds[position]);
            i.setLayoutParams(new Gallery.LayoutParams(300, 340));
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            i.setBackgroundResource(mGalleryItemBackground);
            return i;
        }
    }
}