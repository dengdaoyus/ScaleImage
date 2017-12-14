package cn.ddy.scaleimagedemo;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.ddy.scaleimage.ImageSource;
import cn.ddy.scaleimage.RxScaleImageView;

import static cn.ddy.scaleimagedemo.R.id.imageView;
import static cn.ddy.scaleimagedemo.R.id.rxPinView;

public class ScaleImgActivity extends AppCompatActivity {
    private RxPinView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaleimg);
        imageView = (RxPinView) findViewById(rxPinView);
        isAdmin();


    }

    private void notAdmin() {

        imageView.setImage(ImageSource.asset("changtu.jpg"));
        imageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (imageView.isReady()) {
                    float maxScale = imageView.getMaxScale();
                    PointF center = new PointF(imageView.getSWidth(), 0);
                    imageView.setScaleAndCenter(maxScale, center);
                }
            }
        }, 300);
    }

    private void isAdmin() {
        imageView.setImage(ImageSource.asset("changtu.jpg"));
        imageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (imageView.isReady()) {
                    float maxScale = imageView.getMaxScale();
                    PointF center = new PointF(imageView.getSWidth(), 0);
                    RxScaleImageView.AnimationBuilder animationBuilder = imageView.animateScaleAndCenter(maxScale, center);
                    animationBuilder.withDuration(1000).withEasing(RxScaleImageView.EASE_OUT_QUAD).withInterruptible(false).start();
                }
            }
        }, 300);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        imageView.recycle();
    }
}
