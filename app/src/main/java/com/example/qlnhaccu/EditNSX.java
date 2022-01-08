package com.example.qlnhaccu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.qlnhaccu.dao.NSXDAO;
import com.example.qlnhaccu.model.NSX;

public class EditNSX extends AppCompatActivity {
    //ánh xa
    private EditText edtTenNSX;
    private Button btnSua, btnXoa;
    private NSXDAO nsxdao;
    private NSX nsx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nsx);
        nsxdao =new NSXDAO(EditNSX.this);
        //Lấy dữ liệu
        Intent intent = getIntent();
        NSX nsx = (NSX) intent.getSerializableExtra("DU LIEU");
        AnhXa();
        edtTenNSX.setText(nsx.getTenNSX());

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nsx.setTenNSX(edtTenNSX.getText().toString());
                nsxdao.UpdateNSX(nsx);
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete();
                nsxdao.DeleteNSX(nsx);
                Intent intent1 = new Intent(EditNSX.this,activity_nsx.class);
                startActivity(intent1);
            }
        });
    }

    private void AnhXa() {
        edtTenNSX =(EditText) findViewById(R.id.edt_tennsx);
        btnSua = (Button) findViewById(R.id.btn_suansx);
        btnXoa = (Button) findViewById(R.id.btn_xoansx);

    }
    public void delete(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogdelete_nsx);
        dialog.setCanceledOnTouchOutside(false);

        Button btnyes = (Button) findViewById(R.id.btn_yes);
        Button btnno = (Button) findViewById(R.id.btn_no);

        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nsxdao.DeleteNSX(nsx);
                Intent intent1 = new Intent(EditNSX.this,activity_nsx.class);
                startActivity(intent1);
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
}