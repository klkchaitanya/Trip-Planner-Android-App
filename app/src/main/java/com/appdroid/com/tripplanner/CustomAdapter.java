package com.appdroid.com.tripplanner;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter{
    String [] result;
    String [] resultPlaceId;
    Context context;
    int [] imageId;

    Activity act;
    private static LayoutInflater inflater=null;
     int[] prgmImages;
    public CustomAdapter(SearchResults mainActivity,String[] placeNameList,String[] placeIdList) {
        // TODO Auto-generated constructor stub
        result=placeNameList;
        resultPlaceId=placeIdList;
        context=mainActivity.getApplicationContext();
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        act=mainActivity;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        //ImageView img;
    }

    private String getUrl(String placeId) {

        String Url="https://maps.googleapis.com/maps/api/place/details/json?";
        StringBuilder googlePlacesUrl = new StringBuilder(Url);
        googlePlacesUrl.append("placeid=" + placeId);
        googlePlacesUrl.append("&key=" + "AIzaSyAeiNTUItTqvSC1c_sJheL-LkyVoRNW-nk");
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        //holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv.setText(result[position]);
        //holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position]+" "+resultPlaceId[position], Toast.LENGTH_LONG).show();
                Object[] DataTransfer = new Object[1];
                String url=getUrl(resultPlaceId[position]);
                DataTransfer[0] = url;
                Log.d("onClick", url);
                GetPlaceDetails PlaceDetails = new GetPlaceDetails(act.getBaseContext());
                PlaceDetails.execute(DataTransfer);

                /*FragmentManager fragmentManager = MainActivity.getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, Fragment.instantiate(getActivity(), "com.appdroid.com.tripplanner.DetailedResult"))
                        .commit();*/
            }
        });
        return rowView;
    }

}