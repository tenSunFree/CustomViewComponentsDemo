package com.example.administrator.customviewcomponentsdemo.components.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.customviewcomponentsdemo.R;

public class TitleBarView extends LinearLayout implements View.OnClickListener {

    private Context context;
    private TypedArray attributesTypedArray;
    private ImageView otherMessageImageView, searchImageView;
    private int otherMessageImageResource, searchImageResource;

    public TitleBarView(Context context) {
        super(context);
        this.context = context;
        initView(context);
    }

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);
        attributesSettings(context, attrs);
        initializationOnClickListener();
    }

    public TitleBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.layout_title_bar, this);
        otherMessageImageView = findViewById(R.id.otherMessageImageView);
        searchImageView = findViewById(R.id.searchImageView);
    }

    private void attributesSettings(Context context, AttributeSet attrs) {
        attributesTypedArray =
                context.obtainStyledAttributes(attrs, R.styleable.TitleBarView);
        otherMessageImageResource =
                attributesTypedArray.getResourceId(R.styleable.TitleBarView_otherMessageImageResource, -1);
        if (otherMessageImageResource != -1) {
            otherMessageImageView.setImageResource(otherMessageImageResource);
        }
        searchImageResource =
                attributesTypedArray.getResourceId(R.styleable.TitleBarView_searchImageResource, -1);
        if (searchImageResource != -1) {
            searchImageView.setImageResource(searchImageResource);
        }
    }

    private void initializationOnClickListener() {
        otherMessageImageView.setOnClickListener(this);
        searchImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.otherMessageImageView:
                Toast.makeText(context, "Click other message", Toast.LENGTH_SHORT).show();
                break;
            case R.id.searchImageView:
                Toast.makeText(context, "Click search", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
