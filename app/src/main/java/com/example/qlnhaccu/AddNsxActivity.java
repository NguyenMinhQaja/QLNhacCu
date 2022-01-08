package com.example.qlnhaccu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlnhaccu.dao.NSXDAO;
import com.example.qlnhaccu.database.database;
import com.example.qlnhaccu.model.NSX;

import javax.security.auth.Subject;

public class AddNsxActivity extends AppCompatActivity {
    private Button btnThemNSX;
    private EditText edtTenNSX;
    private NSXDAO nsxdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nsx);

        //ánh xạ
        AnhXa();
        nsxdao = new NSXDAO(AddNsxActivity.this);
        btnThemNSX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                DialogAdd();

            }
        });
    }
    private void AnhXa(){
        edtTenNSX = (EditText) findViewById(R.id.edt_tennsx);
        btnThemNSX =(Button) findViewById(R.id.btn_themnsx);
    }
    private void DialogAdd(){
        Dialog dialog = new Dialog(this);

        //nạp layout vào dialog
        dialog.setContentView(R.layout.dialogadd);

        //tắt click ngoài là thoát
        dialog.setCanceledOnTouchOutside(false);
        Button btnyes = dialog.findViewById(R.id.btn_yes);
        Button btnno = dialog.findViewById(R.id.btn_no);

        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tennsx = edtTenNSX.getText().toString().trim();

                //nếu chưa nhập dữ liệu đầy đủ
                if(tennsx.equals("")){
                    Toast.makeText(AddNsxActivity.this,"Chưa nhập đủ thông tin",Toast.LENGTH_LONG).show();
                }
                else{

                    NSX nsx = CreateNSX();

                    Intent intent = new Intent(AddNsxActivity.this,activity_nsx.class);
                    startActivity(intent);

                    Toast.makeText(AddNsxActivity.this,"Thành công",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
    private NSX CreateNSX(){
        String tennsx = edtTenNSX.getText().toString();
        NSX nsx = new NSX(tennsx);
        nsxdao.AddNSX(nsx);
        return nsx;
    }
}