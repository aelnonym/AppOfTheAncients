package bota.cla.appoftheancients.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import bota.cla.appoftheancients.R;

public class TimelineActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        //default view
        setSearchAdapter();
    }

    private void setTimelineAdapter(){
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("fabric")
                .build();

        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter(this, userTimeline);
        setListAdapter(adapter);
    }

    private void setSearchAdapter() {
        SearchTimeline searchTimeline = new SearchTimeline.Builder().query("#dota2").build();

        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter(this, searchTimeline);
        setListAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_timeline){
            setTimelineAdapter();
        }
        if (id == R.id.action_busca){
            setSearchAdapter();
        }

        return super.onOptionsItemSelected(item);
    }

}