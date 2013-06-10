package com.tiemenschut.tutorials.compoundcontrol;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class SmilingProgressBar extends LinearLayout {

    private final ImageView smileView;
    private final ProgressBar progressBar;
    private int progress = 0;

    public SmilingProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.smiling_progressbar, this);

        loadProgressFromAttributes(attrs);

        smileView = (ImageView) findViewById(R.id.smile);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        update();
    }

    private void update() {
        progressBar.setProgress(progress);
        updateSmile();
    }

    private void loadProgressFromAttributes(AttributeSet attrs) {
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SmilingProgressBar, 0, 0);
        progress = a.getInt(R.styleable.SmilingProgressBar_progress, 0);
        a.recycle();
    }

    private void updateSmile() {
        if (progress < 25) {
            smileView.setImageResource(R.drawable.sad);
        } else if (progress < 50) {
            smileView.setImageResource(R.drawable.neutral);
        } else if (progress < 75) {
            smileView.setImageResource(R.drawable.smile);
        } else {
            smileView.setImageResource(R.drawable.smile_big);
        }
    }
}
