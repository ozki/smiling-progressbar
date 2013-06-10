package com.tiemenschut.tutorials.compoundcontrol;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SmilingProgressBar extends LinearLayout {

    private final TextView smileView;
    private final ProgressBar progressBar;
    private int progress = 0;
    private final Context context;

    public SmilingProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.smiling_progressbar, this);

        loadProgressFromAttributes(attrs);

        smileView = (TextView) findViewById(R.id.smile);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        update();
    }

    private void loadProgressFromAttributes(AttributeSet attrs) {
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SmilingProgressBar, 0, 0);
        progress = a.getInt(R.styleable.SmilingProgressBar_progress, 0);
        a.recycle();
    }

    private void update() {
        progressBar.setProgress(progress);
        updateSmile();
    }

    private void updateSmile() {
        if (progress < 25) {
            smileView.setText(context.getString(R.string.smile_sad));
        } else if (progress < 50) {
            smileView.setText(context.getString(R.string.smile_neutral));
        } else if (progress < 75) {
            smileView.setText(context.getString(R.string.smile_happy));
        } else {
            smileView.setText(context.getString(R.string.smile_yay));
        }
    }
}
