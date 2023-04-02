/* **********************************************
 * 프로젝트명 :  CheckboxProject
 * 작성자 : 2017015041 조정동
 * 작성일 : 2023.04.02
 *프로그램 설명 :  체크박스를 선택할 때마다, 버튼의 속성이 설정되는 프로그램
 ************************************************/


package com.example.example4_7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    private Button mButton; // 회전시킬 버튼
    private CheckBox mCheckBox; // 체크박스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 체크박스 1, 2를 불러와 속성 설정
        CheckBox checkBox1 = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        checkBox1.setEnabled(true); // 체크박스1에 enable 속성 설정
        checkBox2.setClickable(true); // 체크박스2에 clickable 속성 설정

        // 회전시킬 버튼과 체크박스를 불러와 클릭 이벤트 설정
        mButton = findViewById(R.id.button);
        mCheckBox = findViewById(R.id.checkBox3);
        mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckBox.isChecked()) {
                    mButton.setRotation(45f);
                } else {
                    mButton.setRotation(0f);
                }
            }
        });
    }
}
