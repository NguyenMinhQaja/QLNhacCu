package com.example.qlnhaccu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_Nsx,btn_SP, btn_Thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Nsx = findViewById(R.id.btn_nsx);
        btn_SP = findViewById(R.id.btn_sp);
        btn_Thoat = findViewById(R.id.btn_thoat);


        btn_Nsx.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view){
                //chuyển qua activity nhà sản xuất
                Intent intent = new Intent(MainActivity.this,activity_nsx.class);
                startActivity(intent);
            }
        });
        btn_SP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển qua activity nhạc cụ
                Intent intent = new Intent(MainActivity.this,activity_sp.class);
                startActivity(intent);
            }
        });
        //click thoát app
        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogExit();
            }
        });

    }

    //Hàm hiển thị dialog thoát
    private void DialogExit(){
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialogexit);

        //tắt click ngoài là thoát
        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialog.findViewById(R.id.btn_yes);
        Button btnNo = dialog.findViewById(R.id.btn_no);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);

                //thoát
                Intent intent1 = new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
            }
        });

        //click no thì đóng cửa sổ
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}