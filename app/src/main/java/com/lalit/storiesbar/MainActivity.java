package com.lalit.storiesbar;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lalit.storiesbar.framework.IAsyncWorkCompletedCallback;
import com.lalit.storiesbar.framework.ServiceCaller;
import com.lalit.storiesbar.model.Data;
import com.lalit.storiesbar.model.MyPojo;
import com.lalit.storiesbar.model.Stories;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.shts.android.storiesprogressview.StoriesProgressView;

public class MainActivity extends AppCompatActivity implements StoriesProgressView.StoriesListener {
    List<Stories> storiesList;
    private StoriesProgressView storiesProgressView;
    private ImageView image;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storiesList = new ArrayList<>();
        ServiceCaller serviceCaller = new ServiceCaller(MainActivity.this);
        serviceCaller.calStroiesService(new IAsyncWorkCompletedCallback() {
            @Override
            public void onDone(String workName, boolean isComplete) {
                if (isComplete) {
                    MyPojo myPojo = new Gson().fromJson(workName, MyPojo.class);
                    for (Data data : myPojo.getData()) {
                        for (Stories stories : data.getStories()) {
                            storiesList.addAll(Arrays.asList(stories));
                        }
                    }
                    setData();
//                    Toast.makeText(MainActivity.this, storiesList.size() + "", Toast.LENGTH_SHORT).show();
                }
            }
        });
        storiesProgressView = findViewById(R.id.stories);
        image = findViewById(R.id.image);
//        counter = 2;// move direct other stories section .
//        storiesProgressView.startStories(counter);

        // bind reverse view
        View reverse = findViewById(R.id.reverse);
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storiesProgressView.reverse();
            }
        });
        reverse.setOnTouchListener(onTouchListener);

        // bind skip view
        View skip = findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storiesProgressView.skip();
            }
        });
        skip.setOnTouchListener(onTouchListener);
    }

    private void setData() {
        storiesProgressView.setStoriesCount(1); // <- set stories
        storiesProgressView.setStoryDuration(5000L); // <- set a story duration
        storiesProgressView.setStoriesListener(this); // <- set listener
//        image.setImageURI(Uri.parse(storiesList.get(counter).getImage()));
        storiesProgressView.startStories(); // <- start progress
        if (!storiesList.get(counter).getImage().isEmpty()) {
            Picasso.get().load(storiesList.get(counter).getImage()).into(image);
        }
    }

    @Override
    public void onNext() {
//        image.setImageURI(Uri.parse(storiesList.get(++counter).getImage()));
    }

    @Override
    public void onPrev() {
//        if ((counter - 1) < 0) return;
//        image.setImageURI(Uri.parse(storiesList.get(--counter).getImage()));
    }

    @Override
    public void onComplete() {
        if (counter >= storiesList.size()) {
            counter = 0;
        } else {
            counter++;
        }
        setData();

    }


    @Override
    protected void onDestroy() {
        // Very important !
        storiesProgressView.destroy();
        super.onDestroy();
    }

    long pressTime = 0L;
    long limit = 500L;

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    pressTime = System.currentTimeMillis();
                    storiesProgressView.pause();
                    return false;
                case MotionEvent.ACTION_UP:
                    long now = System.currentTimeMillis();
                    storiesProgressView.resume();
                    return limit < now - pressTime;
            }
            return false;
        }
    };
}