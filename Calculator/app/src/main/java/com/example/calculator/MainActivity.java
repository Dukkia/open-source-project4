/* **********************************************
 * 프로젝트명 :  CalculatorProject
 * 작성자 : 2017015041 조정동
 * 작성일 : 2023.04.02
 *프로그램 설명 :  계산기 프로그램
 ************************************************/

package com.example.calculator;

// 안드로이드 기본 라이브러리를 사용하기 위해 import를 선언합니다.
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 계산기의 두 개의 입력필드와 네 개의 연산 버튼, 결과를 출력할 텍스트뷰를 선언합니다.
    EditText etNum1, etNum2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;

    // 0부터 9까지의 숫자 버튼들을 배열과 버튼 아이디 배열로 선언합니다.
    Button[] btnNums = new Button[10];
    int[] btnNumsIds = {
            R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4,
            R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 선언한 입력필드, 연산 버튼, 텍스트뷰를 XML과 연결합니다.
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);

        // 0부터 9까지의 숫자 버튼을 XML과 연결합니다.
        for(int i = 0; i < btnNumsIds.length; i++) {
            btnNums[i] = findViewById(btnNumsIds[i]);
        }

        // 숫자 버튼을 클릭했을 때 이벤트를 처리하기 위해 OnClickListener를 선언합니다.
        for(int i = 0; i < btnNumsIds.length; i++) {
            final int index = i;

            btnNums[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 현재 포커스된 입력필드에 숫자를 추가합니다.
                    if(etNum1.isFocused()) {
                        etNum1.setText(etNum1.getText().toString() + btnNums[index].getText());
                    } else if(etNum2.isFocused()) {
                        etNum2.setText(etNum2.getText().toString() + btnNums[index].getText());
                    } else {
                        // 입력필드에 포커스가 없을 경우 에러 메시지를 출력합니다.
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        // 연산 버튼을 클릭했을 때 이벤트를 처리하기 위해 OnClickListener를 선언합니다.
        View.OnClickListener operatorListener = new View.OnClickListener() {
            // 클릭 이벤트 처리를 위한 onClick 메소드를 오버라이드합니다.
            @Override
            public void onClick(View v) {

                // 입력된 두 수의 길이가 0인 경우 에러 메시지를 띄우고 포커스를 해당 EditText에 맞춥니다.
                if(etNum1.length() == 0) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    etNum1.requestFocus();
                    return;
                } else if(etNum2.length() == 0) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    etNum2.requestFocus();
                    return;
                }

                // EditText에 입력된 두 수를 int 형으로 변환합니다.
                int num1 = Integer.parseInt(etNum1.getText().toString());
                int num2 = Integer.parseInt(etNum2.getText().toString());

                // 결과를 저장할 변수를 초기화합니다.
                int result = 0;

                // 클릭된 버튼의 id에 따라 각각의 연산을 수행합니다.
                switch(v.getId()) {
                    case R.id.btnAdd:
                        result = num1 + num2;
                        break;
                    case R.id.btnSub:
                        result = num1 - num2;
                        break;
                    case R.id.btnMul:
                        result = num1 * num2;
                        break;
                    case R.id.btnDiv:
                        // 나누기 연산인 경우, 0으로 나누는 에러를 처리합니다.
                        if(num1 == 0) {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        } else if(num2 == 0) {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }

                        result = num1 / num2;
                        break;
                }

                // 계산 결과를 TextView에 출력합니다.
                tvResult.setText("계산 결과 : " + result);
            }
        };

// 각 연산 버튼에 OnClickListener를 등록합니다.
        btnAdd.setOnClickListener(operatorListener);
        btnSub.setOnClickListener(operatorListener);
        btnMul.setOnClickListener(operatorListener);
        btnDiv.setOnClickListener(operatorListener);
    }
}