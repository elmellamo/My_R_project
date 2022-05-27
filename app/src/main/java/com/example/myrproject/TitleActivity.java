package com.example.myrproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class TitleActivity extends AppCompatActivity {
    ImageView door_1;
    ImageView door_2;

    Animation ani_1;
    Animation ani_2;

    //ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        //door_1 = (ImageView)findViewById(R.id.door1);
        //door_2 = (ImageView)findViewById(R.id.door2);
        //ani_1 = AnimationUtils.loadAnimation(this, R.anim.doormove);
        //ani_2 = AnimationUtils.loadAnimation(this, R.anim.doormove2);
        //door_1.startAnimation(ani_1);
        //door_2.startAnimation(ani_2);

        //pd = new ProgressDialog(this);
        //pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //pd.show();

        moveMain(1);
    }
    private void moveMain(int sec) {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                //new Intent(현재 context, 이동할 activity)
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);	//intent 에 명시된 액티비티로 이동

                finish();	//현재 액티비티 종료
            }
        }, 1000 * sec); // sec초 정도 딜레이를 준 후 시작
    }
}
