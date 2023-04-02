/* **********************************************
 * 프로젝트명 :  TextProject
 * 작성자 : 2017015041 조정동
 * 작성일 : 2023.04.02
 *프로그램 설명 :  에디트텍스트에 키가 눌릴 때마다, 바뀐 글자가 Toast 메시지로 나오는 프로그램
 ************************************************/



package com.example.example4_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editTextTextMultiLine);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 글자가 바뀔 때마다 호출되는 메소드
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
