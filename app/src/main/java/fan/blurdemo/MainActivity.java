package fan.blurdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class MainActivity extends AppCompatActivity {

    private android.widget.ImageView mImageView;
    private android.widget.SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.mImageView = (ImageView) findViewById(R.id.iv_img);

        //设置seekBar位置
        seekBar.setProgress(0);

        //设置seekBar改变监听
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //如果当前位置为0，则不进行模糊处理
                if( progress ==0 ){
                    Glide.with(MainActivity.this).load(R.drawable.bj)
                            .into(mImageView);
                }else{
                    Glide.with(MainActivity.this).load(R.drawable.bj)
                            //模糊处理图片，progress可以不写，模糊值默认为25，
                            .bitmapTransform(new BlurTransformation(MainActivity.this, progress))
                            .into(mImageView);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
