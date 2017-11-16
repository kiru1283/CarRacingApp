package joyiwendi.com.car2;

import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView birds;
    ImageView star1;
    ImageView star2;
    ImageView star3;
    ImageView backgroundOne;
    ImageView backgroundTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundOne = (ImageView) findViewById(R.id.background_one);
        backgroundTwo = (ImageView) findViewById(R.id.background_two);
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(4500L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress = (float) animation.getAnimatedValue();
                float height = backgroundOne.getHeight();
                float translationY = height * progress;
                backgroundOne.setTranslationY(translationY);
                backgroundTwo.setTranslationY(translationY - height);
            }
        });
        animator.start();



    }

    public void birds() {
        birds = (ImageView) findViewById(R.id.birds);
        birds.setBackgroundResource(R.drawable.flap);
        birds.setVisibility(ImageView.VISIBLE);
        birds.animate().translationX(-900f).setDuration(10000).translationY(700f).setStartDelay(100L);
        AnimationDrawable animation = (AnimationDrawable) birds.getBackground();

        animation.start();
    }


    public void onClickCar(View view) {

        birds();
         ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(1000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress = (float) animation.getAnimatedValue();
                float height = backgroundOne.getHeight();
                float translationY = height * progress;
                backgroundOne.setTranslationY(translationY);
                backgroundTwo.setTranslationY(translationY - height);
            }
        });
        animator.start();

    }
    public void stars(){

        star1 = findViewById(R.id.star);
        star2 = findViewById(R.id.star1);
        star3 = findViewById(R.id.star2);
        star1.setVisibility(ImageView.VISIBLE);
        star2.setVisibility(ImageView.VISIBLE);
        star3.setVisibility(ImageView.VISIBLE);
        star1.setTranslationY(100);
        star2.setTranslationY(200);
        star3.setTranslationY(300);
    }
}
