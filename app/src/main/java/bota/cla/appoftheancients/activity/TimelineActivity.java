package bota.cla.appoftheancients.activity;

import android.app.ListActivity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import bota.cla.appoftheancients.R;

public class TimelineActivity extends ListActivity {

    private boolean isSearching = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        FloatingActionButton button = new FloatingActionButton(this);
        addContentView(button, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        button.setImageDrawable(getResources().getDrawable(R.drawable.tw__ic_logo_blue));

        ColorStateList colors = getResources().getColorStateList(R.color.button_colors);
        button.setBackgroundTintList(colors);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isSearching){
                    setTimelineAdapter();
                } else {
                    setSearchAdapter();
                }
                isSearching = !isSearching;
            }
        });

        //default view
        setSearchAdapter();
    }

    private void setTimelineAdapter(){
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("antedreymon")
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