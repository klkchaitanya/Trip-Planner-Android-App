package com.appdroid.com.tripplanner;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Personal on 09-04-2017.
 */
public class GetPlaceDetails  extends AsyncTask<Object, String, String>
{

    String googlePlacesData;
    String url;
    Context c;


    public GetPlaceDetails(Context context)
    {
        c=context;
    }


    @Override
    protected String doInBackground(Object... params) {
        try {
            Log.d("GetPlaceDetails", "doInBackground entered");
            url = (String) params[0];
            DownloadUrl downloadUrl = new DownloadUrl();
            googlePlacesData = downloadUrl.readUrl(url);
            Log.d("GooglePlacesReadTask", "doInBackground Exit");
        } catch (Exception e) {
            Log.d("GooglePlacesReadTask", e.toString());
        }
        return googlePlacesData;
    }

    protected void onPostExecute(String result) {
        Log.d("GooglePlacesReadTask", "onPostExecute Entered");
        parseDetails(result);
       // ShowNearbyPlaces(nearbyPlacesList);
        Log.d("GooglePlacesReadTask", "onPostExecute Exit");
    }


    public void parseDetails(String jsonData)
    {
        JSONArray jsonArray = null;
        JSONObject jsonObject, jsonObject2;

        try {
            Log.d("Places", "parse");
            jsonObject = new JSONObject((String) jsonData);
            jsonObject2 = new JSONObject(jsonObject.getString("result"));
           // jsonArray = jsonObject.getJSONArray("result");
           // JSONObject googlePlace=(JSONObject)jsonArray.get(0);
           // String rating = googlePlace.toString();
            //Toast.makeText(c,jsonObject2.toString(),Toast.LENGTH_SHORT).show();
            JSONObject openingHours = new JSONObject(jsonObject2.getString("opening_hours"));
            String is_open_now;
            if(openingHours.getString("open_now").equals("true"))
                is_open_now="Open Now";
            else
                is_open_now="Closed Now";
            JSONArray periods = openingHours.getJSONArray("periods");
            String res="";
            for(int i=0;i<periods.length();i++)
            {
               // Toast.makeText(c,String.valueOf(periods.length()),Toast.LENGTH_SHORT).show();
                JSONObject element = (JSONObject) periods.get(i);
                JSONObject close = new JSONObject(element.getString("close"));
                JSONObject open = new JSONObject(element.getString("open"));
                String day="";
                if(open.getString("day").equals("0")){day="Sun";}
                else if(open.getString("day").equals("1")){day="Mon";}
                else if(open.getString("day").equals("2")){day="Tue";}
                else if(open.getString("day").equals("3")){day="Wed";}
                else if(open.getString("day").equals("4")){day="Thu";}
                else if(open.getString("day").equals("5")){day="Fri";}
                else if(open.getString("day").equals("6")){day="Sat";}


                res=res+day+" : "+open.getString("time")+"-"+close.getString("time")+"\t";
            }

            JSONArray photo= new JSONArray(jsonObject2.getString("photos"));
            JSONObject pic1= (JSONObject)(photo.get(0));

            Toast.makeText(c,"Period: "+res
                    ,Toast.LENGTH_SHORT).show();
            Toast.makeText(c,"Photos: "+pic1.getString("photo_reference"),Toast.LENGTH_SHORT).show();

            String s = jsonObject2.getString("name")
                       +"\n"+jsonObject2.getString("rating")
                       +"\n"+jsonObject2.getString("international_phone_number")
                       +"\n"+is_open_now
                       +"\n"+res
                       +"\n"+pic1.getString("photo_reference")
                       +"\n"+jsonObject2.getString("formatted_address")
                       +"\n"+jsonObject2.getString("website");

            Intent in = new Intent(c,PlaceDetails.class);
            in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            in.putExtra("data",s);
            c.startActivity(in);

        } catch (Exception e) {
            Log.d("Places", "parse error");
            e.printStackTrace();
        }
    }


}
