package com.appxperts.customviewstudy;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by gufran on 11/9/15.
 */
public class ColorOptionsLinearLayout extends LinearLayout {

    private View mValue;
    private ImageView mImage;

    public ColorOptionsLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ColorOptionsLinearLayout, 0, 0);
        String titleText = typedArray.getString(R.styleable.ColorOptionsLinearLayout_titleText);
        int valueColor = typedArray.getColor(R.styleable.ColorOptionsLinearLayout_valueColor,
                getResources().getColor(android.R.color.holo_blue_light));

        typedArray.recycle();


        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_color_options, this, true);

        TextView title = (TextView) getChildAt(0);
        title.setText(titleText);

        mValue = getChildAt(1);
        mValue.setBackgroundColor(valueColor);

        mImage = (ImageView) getChildAt(2);

    }

    public ColorOptionsLinearLayout(Context context) {
        super(context);
    }

    public void setValueColor(int color) {
        mValue.setBackgroundColor(color);
    }

    public void setImageVisible(boolean visible) {
        mImage.setVisibility(visible ? View.VISIBLE : View.GONE);
    }


}
