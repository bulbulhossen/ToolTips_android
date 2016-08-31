package com.bulbulhossen.tooltips_android;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.tooltip.Tooltip;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Typeface type = Typeface.createFromAsset(getAssets(),"fonts/benhandwriting.ttf");


        Button button = (Button) findViewById(R.id.buttonclick);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Tooltip.Builder builder = new Tooltip.Builder(v, R.style.Tooltip2)
                        .setCancelable(true)
                        .setDismissOnClick(false)
                        .setCornerRadius(20f)
                        .setTypeface(type)

                        .setText(R.string.texttips);
                builder.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        if (getSupportActionBar() != null) {
            MenuItem menuItem = menu.findItem(R.id.action_test2);
            Tooltip.Builder builder = new Tooltip.Builder(getSupportActionBar().getThemedContext(), menuItem)
                    .setCornerRadius(10f)
                    .setGravity(Gravity.BOTTOM)
                    .setText("I`m on the bottom of menu item");
            builder.show();
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_test:
                new Tooltip.Builder(findViewById(R.id.action_test), R.style.Tooltip)
                        .setCancelable(true)
                        .setDismissOnClick(true)
                        .setGravity(Gravity.BOTTOM)
                        .setText("I`m on the bottom of first menu item and showing dynamically on menu item click")
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}