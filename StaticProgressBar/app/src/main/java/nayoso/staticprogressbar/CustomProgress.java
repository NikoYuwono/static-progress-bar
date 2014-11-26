package nayoso.staticprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.Arrays;

public class CustomProgress extends RelativeLayout {

    private final static int SHAPE_RECTANGLE = 0;
    private final static int SHAPE_ROUNDED_RECTANGLE = 1;

	private ShapeDrawable progressDrawable;
	private int width = 0;
    private int maxWidth = 0;
    private int progressColor;
    private int progressBackgroundColor;
    private int progressShape = SHAPE_RECTANGLE;
    private float percentage = 0.0f;
    private float cornerRadius = 25.0f;

    //Constructor

	public CustomProgress(Context context) {
		super(context);
        setDefaultValue();
	}

    public CustomProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDefaultValue();
    }

    public CustomProgress(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setDefaultValue();
    }

    private void setDefaultValue() {
        // default color
        progressColor = getResources().getColor(R.color.experience_color);
        progressBackgroundColor = getResources().getColor(R.color.experience_grey);
    }

    //View Lifecycle

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if(changed) {
            initView();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        progressDrawable.setBounds(0, 0, width, this.getHeight());
        progressDrawable.draw(canvas);
        if(width<maxWidth) {
            width+=5;
            postInvalidate();
        }
    }

    private void initView() {
        Shape progressShapeDrawable = null;
        Shape backgroundProgressShapeDrawable = null;
        switch (progressShape) {
            case SHAPE_RECTANGLE:
                progressShapeDrawable = new RectShape();
                backgroundProgressShapeDrawable = new RectShape();
                break;
            case SHAPE_ROUNDED_RECTANGLE:
                float[] outerRadius = new float[8];
                Arrays.fill(outerRadius, cornerRadius);
                progressShapeDrawable = new RoundRectShape(outerRadius, null, null);
                backgroundProgressShapeDrawable = new RoundRectShape(outerRadius, null, null);
                break;
        }
        //Progress
        progressDrawable = new ShapeDrawable(progressShapeDrawable);
        progressDrawable.getPaint().setColor(progressColor);
        //Background
        ShapeDrawable backgroundDrawable = new ShapeDrawable(backgroundProgressShapeDrawable);
        backgroundDrawable.getPaint().setColor(progressBackgroundColor);
        backgroundDrawable.setBounds(0, 0, this.getWidth(), this.getHeight());
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.setBackground(backgroundDrawable);
        } else {
            this.setBackgroundDrawable(backgroundDrawable);
        }

        this.maxWidth = (int) (this.getWidth() * percentage);
    }

    //Helper

    public void setProgressColor(int color) {
        this.progressColor = color;
    }

    public void setProgressBackgroundColor(int color) {
        this.progressBackgroundColor = color;
    }

    public void resetWidth() {
        width = 0;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public boolean isPercentageChanging(float percentage) {
        return this.percentage != percentage;
    }

    public void useRectangleShape(int progressShape) {
        this.progressShape = progressShape;
    }

    public void useRoundedRectangleShape(float cornerRadius) {
        this.progressShape = SHAPE_ROUNDED_RECTANGLE;
        this.cornerRadius = cornerRadius;
    }
}