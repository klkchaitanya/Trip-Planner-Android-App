package com.appdroid.com.tripplanner;

import android.widget.ListView;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Personal on 01-05-2017.
 */
public class SearchResultsUTest extends TestCase
{
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    public void testcheckLists_true()
    {

        ArrayList<String> list1=new ArrayList<String>(Arrays.asList("1","2"));
        ArrayList<String> list2=new ArrayList<String>(Arrays.asList("a","b"));

        SearchResults sr=new SearchResults();
        boolean res=sr.checkLists(list1, list2);
        assertEquals(true,res);
    }

    public void testcheckLists_false1()
    {

        ArrayList<String> list1=new ArrayList<String>(Arrays.asList("1","2","3"));
        ArrayList<String> list2=new ArrayList<String>(Arrays.asList("a","b"));

        SearchResults sr=new SearchResults();
        boolean res=sr.checkLists(list1,list2);
        assertEquals(false,res);
    }

    public void testcheckLists_false2()
    {

        ArrayList<String> list1=new ArrayList<String>();
        ArrayList<String> list2=new ArrayList<String>();

        SearchResults sr=new SearchResults();
        boolean res=sr.checkLists(list1,list2);
        assertEquals(false,res);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
