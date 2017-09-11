package com.appdroid.com.tripplanner;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;

import junit.framework.TestCase;

/**
 * Created by Personal on 01-05-2017.
 */
public class SearchResultsITest extends ActivityInstrumentationTestCase2<SearchResults>
{
    public SearchResultsITest() {
        super(SearchResults.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testlistView_searchResults()
    {


    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
