package com.example.administrator.customviewcomponentsdemo.components.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.customviewcomponentsdemo.GlobalVariable;
import com.example.administrator.customviewcomponentsdemo.R;

public class PageSwitchingBarView extends LinearLayout implements View.OnClickListener {

    private Context context;
    private TypedArray attributesTypedArray;
    private ImageView songListImageView, exclusiveImageView, exploreImageView, moreImageView;
    private View songListTopView, exclusiveTopView, exploreTopView, moreTopView;
    private int songListImageResource, exclusiveImageResource, exploreImageResource, moreImageResource;

    public PageSwitchingBarView(Context context) {
        super(context);
        this.context = context;
        initView(context);
    }

    public PageSwitchingBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);
        attributesSettings(context, attrs);
        initializationOnClickListener();
    }

    public PageSwitchingBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.layout_page_switching_bar, this);
        songListImageView = findViewById(R.id.songListImageView);
        exclusiveImageView = findViewById(R.id.exclusiveImageView);
        exploreImageView = findViewById(R.id.exploreImageView);
        moreImageView = findViewById(R.id.moreImageView);
        songListTopView = findViewById(R.id.songListTopView);
        exclusiveTopView = findViewById(R.id.exclusiveTopView);
        exploreTopView = findViewById(R.id.exploreTopView);
        moreTopView = findViewById(R.id.moreTopView);
    }

    private void attributesSettings(Context context, AttributeSet attrs) {
        attributesTypedArray =
                context.obtainStyledAttributes(attrs, R.styleable.PageSwitchingBarView);
        songListImageResource =
                attributesTypedArray.getResourceId(R.styleable.PageSwitchingBarView_songListImageResource, -1);
        if (songListImageResource != -1) {
            songListImageView.setImageResource(songListImageResource);
        }
        exclusiveImageResource =
                attributesTypedArray.getResourceId(R.styleable.PageSwitchingBarView_exclusiveImageResource, -1);
        if (exclusiveImageResource != -1) {
            exclusiveImageView.setImageResource(exclusiveImageResource);
        }
        exploreImageResource =
                attributesTypedArray.getResourceId(R.styleable.PageSwitchingBarView_exploreImageResource, -1);
        if (exploreImageResource != -1) {
            exploreImageView.setImageResource(exploreImageResource);
        }
        moreImageResource =
                attributesTypedArray.getResourceId(R.styleable.PageSwitchingBarView_moreImageResource, -1);
        if (moreImageResource != -1) {
            moreImageView.setImageResource(moreImageResource);
        }
    }

    private void initializationOnClickListener() {
        songListImageView.setOnClickListener(this);
        exclusiveImageView.setOnClickListener(this);
        exploreImageView.setOnClickListener(this);
        moreImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.songListImageView:
                Toast.makeText(context, "Click song list", Toast.LENGTH_SHORT).show();
                GlobalVariable.songListAlreadyClick = true;
                GlobalVariable.exclusiveAlreadyClick = false;
                GlobalVariable.exploreAlreadyClick = false;
                GlobalVariable.moreAlreadyClick = false;
                synchronouslyUpdateUiStatus();
                break;
            case R.id.exclusiveImageView:
                Toast.makeText(context, "Click exclusive", Toast.LENGTH_SHORT).show();
                GlobalVariable.songListAlreadyClick = false;
                GlobalVariable.exclusiveAlreadyClick = true;
                GlobalVariable.exploreAlreadyClick = false;
                GlobalVariable.moreAlreadyClick = false;
                synchronouslyUpdateUiStatus();
                break;
            case R.id.exploreImageView:
                Toast.makeText(context, "Click explore", Toast.LENGTH_SHORT).show();
                GlobalVariable.songListAlreadyClick = false;
                GlobalVariable.exclusiveAlreadyClick = false;
                GlobalVariable.exploreAlreadyClick = true;
                GlobalVariable.moreAlreadyClick = false;
                synchronouslyUpdateUiStatus();
                break;
            case R.id.moreImageView:
                Toast.makeText(context, "Click more", Toast.LENGTH_SHORT).show();
                GlobalVariable.songListAlreadyClick = false;
                GlobalVariable.exclusiveAlreadyClick = false;
                GlobalVariable.exploreAlreadyClick = false;
                GlobalVariable.moreAlreadyClick = true;
                synchronouslyUpdateUiStatus();
                break;
        }
    }

    private void synchronouslyUpdateUiStatus() {
        if (GlobalVariable.songListAlreadyClick == true) {
            songListTopView.setVisibility(INVISIBLE);
        } else {
            songListTopView.setVisibility(VISIBLE);
        }
        if (GlobalVariable.exclusiveAlreadyClick == true) {
            exclusiveTopView.setVisibility(INVISIBLE);
        } else {
            exclusiveTopView.setVisibility(VISIBLE);
        }
        if (GlobalVariable.exploreAlreadyClick == true) {
            exploreTopView.setVisibility(INVISIBLE);
        } else {
            exploreTopView.setVisibility(VISIBLE);
        }
        if (GlobalVariable.moreAlreadyClick == true) {
            moreTopView.setVisibility(INVISIBLE);
        } else {
            moreTopView.setVisibility(VISIBLE);
        }
    }
}
