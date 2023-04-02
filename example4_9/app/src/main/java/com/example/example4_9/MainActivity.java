/* **********************************************
 * 프로젝트명 :  SpinProject
 * 작성자 : 2017015041 조정동
 * 작성일 : 2023.04.02
 *프로그램 설명 :  버튼을 클릭하면 이미지가 10도씩 회전되는 프로그램
 ************************************************/


package com.example.example4_9;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView; // 회전시킬 이미지 뷰
    private Button mButton; // 회전 버튼
    private int mRotation = 0; // 현재 회전 각도를 저장하는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 레이아웃에서 ImageView와 Button을 찾아서 변수에 저장
        mImageView = findViewById(R.id.imageView3);
        mButton = findViewById(R.id.button);

        // Button에 OnClickListener 등록
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRotation += 10; // 회전 각도를 10도씩 증가
                mImageView.setRotation(mRotation); // ImageView를 회전 각도만큼 회전
            }
        });
    }
}
