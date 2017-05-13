package com.pakoandrade.tourapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.pakoandrade.tourapp.utils.Utils;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

public class HomeActivity extends AppCompatActivity {

    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(HomeActivity.this, PREF_USER_FIRST_TIME, "true"));

        Intent introIntent = new Intent(HomeActivity.this, MainnActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);

        if (isUserFirstTime) {
            startActivity(introIntent);
        }

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,MainnActivity.class);
                startActivity(i);
            }
        });


        new MaterialTapTargetPrompt.Builder(HomeActivity.this)
                .setTarget(findViewById(R.id.button))
                .setPrimaryText("Ver de nuevo el tutorial")
                .setSecondaryText("Nos permite ver el tutorial de inicio aun despues de cerrado")
                .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener()
                {
                    @Override
                    public void onHidePrompt(MotionEvent event, boolean tappedTarget)
                    {
                        //Do something such as storing a value so that this prompt is never shown again
                    }

                    @Override
                    public void onHidePromptComplete()
                    {

                    }
                })
                .show();

        new MaterialTapTargetPrompt.Builder(HomeActivity.this)
                .setTarget(findViewById(R.id.textView))
                .setPrimaryText("Send your first email")
                .setSecondaryText("Tap the envelop to start composing your first email")
                .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener()
                {
                    @Override
                    public void onHidePrompt(MotionEvent event, boolean tappedTarget)
                    {
                        //Do something such as storing a value so that this prompt is never shown again
                    }

                    @Override
                    public void onHidePromptComplete()
                    {

                    }
                })
                .show();
    }
}
