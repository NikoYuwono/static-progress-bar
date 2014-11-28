package nayoso.staticprogressbar;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        Resources res = getResources();
        CustomProgress customProgressRectangle = (CustomProgress) findViewById(R.id.customProgressRectangle);
        customProgressRectangle.setPercentage(0.75f);
        customProgressRectangle.setProgressColor(res.getColor(R.color.red_500));
        customProgressRectangle.setProgressBackgroundColor(res.getColor(R.color.red_200));
        CustomProgress customProgressRoundedRectangle = (CustomProgress) findViewById(R.id.customProgressRoundedRectangle);
        customProgressRoundedRectangle.setPercentage(0.45f);
        customProgressRoundedRectangle.useRoundedRectangleShape(30.0f);
        customProgressRoundedRectangle.setProgressColor(res.getColor(R.color.purple_500));
        customProgressRoundedRectangle.setProgressBackgroundColor(res.getColor(R.color.purple_200));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
