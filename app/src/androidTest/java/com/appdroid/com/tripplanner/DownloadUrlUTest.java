package com.appdroid.com.tripplanner;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * Created by Personal on 01-05-2017.
 */
public class DownloadUrlUTest extends TestCase
{
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    @SmallTest
    public void testreadUrlInput_true() throws IOException {
        String nearbySearchUrl="https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
        DownloadUrl durl=new DownloadUrl();
        String res=durl.readUrl(nearbySearchUrl);
        assertTrue(!res.equals(""));

    }

    @SmallTest
    public void testreadUrlInput_false() throws IOException {
        String nearbySearchUrl="";
        DownloadUrl durl=new DownloadUrl();
        String res=durl.readUrl(nearbySearchUrl);
        assertTrue(res.equals(""));

    }




    @SmallTest
    public void testreadUrlOutput_true() throws IOException {
        String nearbySearchUrl="https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
        StringBuilder googlePlacesUrl = new StringBuilder(nearbySearchUrl);
        googlePlacesUrl.append("location=" + 34.0583995 + "," + -106.8914159);
        googlePlacesUrl.append("&radius=" + 10000);
        googlePlacesUrl.append("&type=" + "restaurant");
        googlePlacesUrl.append("&rankby=prominence");
        googlePlacesUrl.append("&sensor=false");
        googlePlacesUrl.append("&key=" + "AIzaSyAeiNTUItTqvSC1c_sJheL-LkyVoRNW-nk");
        DownloadUrl durl=new DownloadUrl();
        String res=durl.readUrl(googlePlacesUrl.toString());
        assertTrue(!res.equals(""));

    }

    @SmallTest
    public void testreadUrlOutput_false() throws IOException {
        String nearbySearchUrl="https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
        StringBuilder googlePlacesUrl = new StringBuilder(nearbySearchUrl);
        googlePlacesUrl.append("location=" + 34.0583995 + "," + -106.8914159);
        googlePlacesUrl.append("&radius=" + 10000);
        googlePlacesUrl.append("&type=" + "restaurant");
        googlePlacesUrl.append("&rankby=prominence");
        googlePlacesUrl.append("&sensor=false");
        googlePlacesUrl.append("&key=" + "AIzaSyAeiNTUItTqvSC1c_sJheL-LkyVoRNW-nk");
        DownloadUrl durl=new DownloadUrl();
        String res=durl.readUrl(googlePlacesUrl.toString());
        assertFalse(res.equals(""));

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
