package com.appdroid.com.tripplanner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class PlaceDetails extends ActionBarActivity {

    TextView tvPlaceName, tvPlaceRating, tvPlacePhone, tvNow, tvDays, tvWebsite, tvPlaceAddress;
    ImageView ivBig;
    Button btnAddRating;
    CheckBox cbVisited;

    String[] placeData;
    String PlaceName, PlaceRating, PlacePhone, PlaceNow, PlaceDays, PlacePhoto, PlaceUrl, PlaceAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        btnAddRating=(Button)findViewById(R.id.btnAddRating);
        cbVisited=(CheckBox)findViewById(R.id.cbVisited);


       //Retrieve visited status from database and based on that set cbVisited checked or not


        if (cbVisited.isChecked())
            btnAddRating.setEnabled(true);
        else
            btnAddRating.setEnabled(false);

        cbVisited.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    btnAddRating.setEnabled(true);
                else
                    btnAddRating.setEnabled(false);


            }
        });

        btnAddRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToReviewPage();
            }
        });

        tvPlaceName=(TextView)findViewById(R.id.tvPlaceName);
        tvPlaceAddress=(TextView)findViewById(R.id.tvPlaceAddress);
        tvPlaceRating=(TextView)findViewById(R.id.tvRatingTxt);
        tvPlacePhone=(TextView) findViewById(R.id.tvPhoneTxt);
        tvNow=(TextView) findViewById(R.id.tvNowTxt);
        tvDays=(TextView) findViewById(R.id.tvDaysTxt);
        ivBig=(ImageView)findViewById(R.id.ivBig);
        tvWebsite=(TextView)findViewById(R.id.tvWebsiteTxt);




        if(getIntent().getExtras()!=null) {
            String data = getIntent().getExtras().getString("data");
            placeData = data.split("\n");
            PlaceName = placeData[0];
            PlaceRating = placeData[1];
            PlacePhone = placeData[2];
            PlaceNow = placeData[3];
            PlaceDays = placeData[4];
            PlacePhoto = placeData[5];
            PlaceAddress = placeData[6];
            PlaceUrl = placeData[7];

           // PlaceIcon = placeData[3];
            Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
        }

        String url="";
        url = "https://maps.googleapis.com/maps/api/place/photo?";
        String key = "key=AIzaSyAeiNTUItTqvSC1c_sJheL-LkyVoRNW-nk";
        String sensor = "sensor=true";
        String maxWidth="maxwidth=" + 300;
        String maxHeight = "maxheight=" + 300;
        String photoReference = "photoreference="+PlacePhoto;
        url = url  + key + "&" + photoReference + "&"  + sensor + "&" + maxWidth + "&" + maxHeight;
        ImageDownloadTask idt = new ImageDownloadTask();
        //Toast.makeText(getApplicationContext(),url.toString(),Toast.LENGTH_SHORT).show();
        idt.execute(url);


        tvPlaceName.setText(PlaceName);
        tvPlaceAddress.setText(PlaceAddress);
        tvPlaceRating.setText(PlaceRating+"/5");
        tvPlacePhone.setText(PlacePhone);
        tvNow.setText(PlaceNow);
        tvDays.setText(PlaceDays);
        tvWebsite.setText(PlaceUrl);

       // ivBig.setScaleType(ImageView.ScaleType.CENTER_CROP);
      //  ivBig.setImageDrawable(LoadImageFromWebOperations(PlaceIcon));

    }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    private Bitmap downloadImage(String strUrl) throws IOException {
        Bitmap bitmap=null;
        InputStream iStream = null;
        try{
            URL url = new URL(strUrl);

            /** Creating an http connection to communcate with url */
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            /** Connecting to url */
            urlConnection.connect();

            /** Reading data from url */
            iStream = urlConnection.getInputStream();

            /** Creating a bitmap from the stream returned from the url */
            bitmap = BitmapFactory.decodeStream(iStream);
            iStream.close();

        }catch(Exception e){
            Log.d("Exception while downloading url", e.toString());
        }finally{
           // iStream.close();
        }
        return bitmap;
    }

    private class ImageDownloadTask extends AsyncTask<String, Integer, Bitmap> {
        Bitmap bitmap = null;
        @Override
        protected Bitmap doInBackground(String... url) {
            try{
                // Starting image download
                bitmap = downloadImage(url[0]);
            }catch(Exception e){
                Log.d("Background Task", e.toString());
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Creating an instance of ImageView to display the downloaded image
           // ImageView iView = new ImageView(getApplicationContext());

            // Setting the downloaded image in ImageView
           // iView.setImageBitmap(result);
            ivBig.setImageBitmap(result);
            // Adding the ImageView to ViewFlipper
            //mFlipper.addView(iView);

            // Showing download completion message
            Toast.makeText(getBaseContext(), "Image downloaded successfully", Toast.LENGTH_SHORT).show();
        }
    }


    public void goToReviewPage() {

    }


}
