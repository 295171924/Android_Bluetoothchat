package com.prg.ming.kohlerremote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //+++++++++++++++ȡ������������ʾ
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //+++++++++++++++ȡ��״̬������ʾ
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        view = getLayoutInflater().from(this).inflate(R.layout.activity_main, null);
        /**main.setOnClickListener(new OnClickListener()
         {
         @Override
         public void onClick(View v)
         {
         //int i = main.getSystemUiVisibility();
         // if (i == View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
         //	 main.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
         // else if (i == View.SYSTEM_UI_FLAG_VISIBLE)
         //	 main.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
         //else if (i == View.SYSTEM_UI_FLAG_LOW_PROFILE)
         main.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
         }
         });  **/
        hideSystemUI(view);
        setContentView(view);
        //setContentView(R.layout.activity_main);

        ImageView iv=(ImageView)this.findViewById(R.id.logo_bg);
        //��ʾ�ɻҶ�10%--100%
        AlphaAnimation aa=new AlphaAnimation(0.1f,1.0f);
        //��ʾʱ��3��000��
        aa.setDuration(3000);
        iv.startAnimation(aa);
        //��Ӽ�����
        aa.setAnimationListener(new Animation.AnimationListener()
        {
            //���Ž���ʱ��������������
            @Override
            public void onAnimationEnd(Animation arg0) {
                // TODO Auto-generated method stub
                Intent it=new Intent(MainActivity.this,RemoteActivity.class);
                //intent����һ����������MainActivity
                startActivity(it);
                //���ٵ�ǰActivity���ͷ��ڴ�
                finish();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }
        });

    }

    public static void hideSystemUI(View view) {
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    public static void showSystemUI(View view) {
        view.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
