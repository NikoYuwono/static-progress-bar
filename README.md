static-progress-bar
===================

[![alt text](https://img.shields.io/badge/Android%20Arsenal-static--progress--bar-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1214)

![alt text](http://i1094.photobucket.com/albums/i446/NAYOSO/static_progress_example_zpsadaw3xis.gif)

Custom static progress bar for Android where you can set your own shape and color.

#Usage

Just copy and use the CustomProgress.java
Example : 

```
    <yourpackage.CustomProgress
        android:id="@+id/customProgress"
        android:layout_centerHorizontal="true"
        android:layout_width="@dimen/custom_progress_width"
        android:layout_height="@dimen/custom_progress_height" />
```

and then set the progress

```
        CustomProgress customProgress = (CustomProgress) findViewById(R.id.customProgress);
        customProgress.setMaximumPercentage(0.75f);
```

To change the color of the progress just call `setProgressColor(int color)` or `setProgressBackgroundColor(int color)` for the background.
Example :

```
        customProgress.setProgressColor(res.getColor(R.color.purple_500));
        customProgressRoundedRectangle.setProgressBackgroundColor(res.getColor(R.color.purple_200));
```

You can also choose the shape of the progress between Rectangle (default) and Rounded Rectangle (with radius).
Example :

```
        customProgress.useRectangleShape(); //Rectangle
        customProgress.useRoundedRectangleShape(30.0f); //Rounded Rectangle
```

Because this is an progress bar you can still show the progress number if you want by calling `setShowingPercentage(boolean showingPercentage)`
Example :

```
        customProgress.setShowingPercentage(true);
```

And if you want to show your own text you can also do this

```
        customProgress.setShowingPercentage(false);
        customProgressText.setText("Rectangle");
        customProgressText.setTextSize(20);
        customProgressText.setTextColor(Color.WHITE);
        customProgressText.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        customProgressText.setPadding(50,0,0,0);
```

Because this view extends to TextView class, you can set the position of the text like what you usually done in TextView.

For anyone who have issues/feature request or want to contribute, please create an issue for issues/feature request and create a pull request if you want to contribute. Or you can contact me via niko.yuwono.91@gmail.com or my twitter @NAYOSO
