package com.blue.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FeatureTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_test);

        // Add your buttons here

        //Example
        GenerateButton("Quit", new ButtonClick() {
            @Override
            public void click() {
                finishAffinity();
                System.exit(0);
            }
        });
    }


    private void GenerateButton(ButtonContent content) {
        final Button button = new Button(this);
        button.setText(content.buttonText());
        button.setOnClickListener(content);
        ((LinearLayout) findViewById(R.id.container)).addView(button);
    }

    private void GenerateButton(final String title, final ButtonClick click) {
        ButtonContent ctnt = new ButtonContent() {
            @Override
            public String buttonText() {
                return title;
            }

            @Override
            public void onClick(View v) {
                click.click();
            }
        };
        GenerateButton(ctnt);
    }

    private interface ButtonContent extends View.OnClickListener {
        String buttonText();
    }

    private interface ButtonClick {
        void click();
    }
}
