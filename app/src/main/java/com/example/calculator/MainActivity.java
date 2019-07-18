package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNumber0, btnNUmber1, btnNUmber2, btnNUmber3, btnNUmber4, btnNUmber5, btnNUmber6, btnNUmber7, btnNUmber8, btnNUmber9;
    private Button btnCong, btnTru, btnNhan, btnChia, btnPhantram, btnAC, btnDaodau, btnCham, btnBang;
    private TextView txtHienthi, txtKetqua;
    private final String cong = "+", tru = "-", nhan = "*", chia = "/", bang = "=", phantram = "%", daodau = "+/-";
    private String action;
    private float res1 = Float.NaN, res2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setEventClick();
    }

    private void setEventClick() {
        btnNumber0.setOnClickListener(this);
        btnNUmber1.setOnClickListener(this);
        btnNUmber2.setOnClickListener(this);
        btnNUmber3.setOnClickListener(this);
        btnNUmber4.setOnClickListener(this);
        btnNUmber5.setOnClickListener(this);
        btnNUmber6.setOnClickListener(this);
        btnNUmber7.setOnClickListener(this);
        btnNUmber8.setOnClickListener(this);
        btnNUmber9.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnBang.setOnClickListener(this);

        btnAC.setOnClickListener(this);
        btnDaodau.setOnClickListener(this);
        btnCham.setOnClickListener(this);
        btnPhantram.setOnClickListener(this);
    }

    private void initView() {
        txtHienthi = (TextView) findViewById(R.id.textviewhienthi);
        txtKetqua = (TextView) findViewById(R.id.textviewketqua);

        btnNumber0 = (Button) findViewById(R.id.button0);
        btnNUmber1 = (Button) findViewById(R.id.button1);
        btnNUmber2 = (Button) findViewById(R.id.button2);
        btnNUmber3 = (Button) findViewById(R.id.button3);
        btnNUmber4 = (Button) findViewById(R.id.button4);
        btnNUmber5 = (Button) findViewById(R.id.button5);
        btnNUmber6 = (Button) findViewById(R.id.button6);
        btnNUmber7 = (Button) findViewById(R.id.button7);
        btnNUmber8 = (Button) findViewById(R.id.button8);
        btnNUmber9 = (Button) findViewById(R.id.button9);

        btnCong = (Button) findViewById(R.id.buttoncong);
        btnTru = (Button) findViewById(R.id.buttontru);
        btnNhan = (Button) findViewById(R.id.buttonnhan);
        btnChia = (Button) findViewById(R.id.buttonchia);
        btnBang = (Button) findViewById(R.id.buttonbang);

        btnAC = (Button) findViewById(R.id.buttonAC);
        btnDaodau = (Button) findViewById(R.id.buttondaodau);
        btnPhantram = (Button) findViewById(R.id.buttonphantram);
        btnCham = (Button) findViewById(R.id.buttoncham);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                txtHienthi.append("0");
                break;
            case R.id.button1:
                txtHienthi.append("1");
                break;
            case R.id.button2:
                txtHienthi.append("2");
                break;
            case R.id.button3:
                txtHienthi.append("3");
                break;
            case R.id.button4:
                txtHienthi.append("4");
                break;
            case R.id.button5:
                txtHienthi.append("5");
                break;
            case R.id.button6:
                txtHienthi.append("6");
                break;
            case R.id.button7:
                txtHienthi.append("7");
                break;
            case R.id.button8:
                txtHienthi.append("8");
                break;
            case R.id.button9:
                txtHienthi.append("9");
                break;
            case R.id.buttoncong:
                if (txtHienthi.getText().toString() != "") {
                    compute();
                    action = cong;
                    txtKetqua.setText(String.valueOf(res1));
                    txtHienthi.setText(null);
                }
                break;
            case R.id.buttontru:
                if (txtHienthi.getText().toString() != "") {
                    compute();
                    action = tru;
                    txtKetqua.setText(String.valueOf(res1));
                    txtHienthi.setText(null);
                }
                break;
            case R.id.buttonnhan:
                if (txtHienthi.getText().toString() != "") {
                    compute();
                    action = nhan;
                    txtKetqua.setText(String.valueOf(res1));
                    txtHienthi.setText(null);
                }
                break;
            case R.id.buttonchia:
                if (txtHienthi.getText().toString() != "") {
                    compute();
                    action = chia;
                    txtKetqua.setText(String.valueOf(res1));
                    txtHienthi.setText(null);
                }
                break;
            case R.id.buttonphantram:
                if (txtHienthi.getText().toString() != "") {
                    Float percent = Float.parseFloat(txtHienthi.getText().toString());
                    txtHienthi.setText(String.valueOf(percent/100));
                }
                break;
            case R.id.buttoncham:
                if (!txtHienthi.getText().toString().contains(".") && txtHienthi.getText().toString() != "") {
                    txtHienthi.append(".");
                }
                break;
            case R.id.buttonAC:
                res1 = Float.NaN;
                res2 = Float.NaN;
                txtHienthi.setText("");
                txtKetqua.setText("");
                break;
            case R.id.buttondaodau:
//                BaseInputConnection inputConnection = new BaseInputConnection(txtHienthi, true);
//                inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
//                String newNumber = deleteNumber(txtHienthi.getText().toString());
//                txtHienthi.setText(newNumber);
                String currentString = txtHienthi.getText().toString();
                if (currentString != "") {
                    Float opposite = Float.parseFloat(currentString);
                    if (opposite > 0) {
                        txtHienthi.setText("-" + currentString);
                    } else {
                        txtHienthi.setText(currentString.replaceFirst("-", ""));
                    }
                }
                break;
            case R.id.buttonbang:
                if (txtHienthi.getText().toString() != "") {
                    compute();
                    action = bang;
                    txtKetqua.setText(String.valueOf(res1));
                    txtHienthi.setText(null);
                }
                break;
        }
    }
//    public String deleteNumber(String number) {
//        String result = number.substring(0, number.length() - 1);
//        return result;
//    }
    public void compute() {
        if (!Float.isNaN(res1)) {
            res2 = Float.parseFloat(txtHienthi.getText().toString());
            switch (action) {
                case cong:
                    res1 += res2;
                    break;
                case tru:
                    res1 -= res2;
                    break;
                case nhan:
                    res1 *= res2;
                    break;
                case chia:
                    res1 /= res2;
                    break;
                case bang:
                    break;
            }
        } else {
            res1 = Float.parseFloat(txtHienthi.getText().toString());
        }
    }
}
