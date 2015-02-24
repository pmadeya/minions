package project3.cmpt276.ca.minions;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MinionSplashActivity extends MinionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minion_splash);


        TextView logo1 = (TextView) findViewById(R.id.welcomeTitle);
        //set the font
        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/CODE Bold.otf");
        logo1.setTypeface(customFont);


        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo1.startAnimation(fade1);

        startAnimating();

    }





    /**
     * Helper method to start the animation on the splash screen
     */
    private void startAnimating() {
        // Fade in top title
        TextView logo1 = (TextView) findViewById(R.id.welcomeTitle);
        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo1.startAnimation(fade1);

        // Fade in bottom title after a built-in delay.
        TextView logo2 = (TextView) findViewById(R.id.authors);
        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        logo2.startAnimation(fade2);

        // Transition to Main Menu when bottom title finishes animating
        fade2.setAnimationListener(new Animation.AnimationListener() {

            public void onAnimationEnd(Animation animation) {
                // The animation has ended, transition to the Main Menu screen
                startActivity(new Intent(MinionSplashActivity.this, MinionMenuActivity.class));
                MinionSplashActivity.this.finish();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });

        // Load animations for all views within the TableLayout
        Animation spinin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController controller = new LayoutAnimationController(spinin);
        

//        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
//
//        for (int i = 0; i < table.getChildCount(); i++) {
//            TableRow row = (TableRow) table.getChildAt(i);
//            row.setLayoutAnimation(controller);
//        }
    }
}
