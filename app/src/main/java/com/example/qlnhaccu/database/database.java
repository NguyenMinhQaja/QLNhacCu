package com.example.qlnhaccu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.qlnhaccu.model.NSX;

import javax.security.auth.Subject;

public class database extends SQLiteOpenHelper {

    public database(@Nullable Context context) {

        super(context, "QLNhacCu.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tạo bảng nhà sản xuất
        String SQLQuery = "CREATE TABLE IF NOT EXISTS " +
                "NSX(MaNSX INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TenNSX VARCHAR(100))";
        //Tạo bảng sản phẩm
        String SQLQuery1 = "CREATE TABLE IF NOT EXISTS " +
                "SP(MaSP INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TenSP VARCHAR(100)," +
                "SoLuong INTEGER," +
                "GiaNhap INTEGER," +
                "GiaBan INTEGER," +
                "MaNSX INTEGER, FOREIGN KEY (MaNSX) REFERENCES NSX (MaNSX))";

        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);

        String sq1 = "INSERT INTO NSX(TenNSX) VALUES ('SAM SUNG')";
        db.execSQL(sq1);
        String sq2 = "INSERT INTO NSX(TenNSX) VALUES ('SAM SUNG 1')";
        db.execSQL(sq2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
