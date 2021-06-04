package com.example.soundoutput;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
    소리 출력 방법
    1) SoundPool 객체의 load 메서드를 이용하여 음원 파일을 미리 준비하여 재생
    2) AudioManager 객체의 playSoundEffect 메서드를 사용하여 시스템에서 제공하는 소리를 재생

    SoundPool 객체
    - 효과음이나 음악을 메모리에 적재하고 실행하는 방식
    - 여러 개의 효과음을 메모리에 적재해놓고 사용 가능

    AudioManager 객체
    - 출력 장비와 오디오들을 관리하는 역할
    - 별도의 효과음 파일을 준비하지 않고도 시스템에서 제공하는 오디오 파일 사용 가능
 */
public class MainActivity extends AppCompatActivity {

    SoundPool mPool;
    int mDing;
    AudioManager mAm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0); //스트림 갯수, 스트림 타입, 음질(default 0)
        mDing = mPool.load(this, R.raw.rain, 1); //Context, 파일 리소스 ID, 우선순위
        mAm = (AudioManager)getSystemService(AUDIO_SERVICE); //안드로이드 프레임워크에서 제공되는 시스템 레벨의 서비스 핸들 생성

        findViewById(R.id.beep1).setOnClickListener(mClickListener);
        findViewById(R.id.beep2).setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            MediaPlayer player;

            switch(v.getId()){
                case R.id.beep1:
                    mPool.play(mDing, 1, 1, 0, 0, 1); //사운드(효과음), 왼쪽 볼륨, 오른쪽 볼륨, 우선순위, 반복횟수, 재생속도
                    break;
                case R.id.beep2:
                    mAm.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD); //효과음 종류(정수형)
                    break;
            }
        }
    };
}