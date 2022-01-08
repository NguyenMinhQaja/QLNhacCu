package com.example.qlnhaccu.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.qlnhaccu.database.database;
import com.example.qlnhaccu.model.NSX;

import java.util.ArrayList;
import java.util.List;

public class NSXDAO {

    private database database;
    public NSXDAO(Context context){
        database = new database(context);
    }
    //lấy tất cả nhà sản xuất
    public List<NSX> getAllNSX(){

        String sqlSelect ="SELECT * FROM NSX ";
        List<NSX> listNSX = new ArrayList<NSX>();
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlSelect,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int masv = cursor.getInt(0);
            String hoten = cursor.getString(1);
            NSX nsx = new NSX(masv,hoten);
            listNSX.add(nsx);
            cursor.moveToNext();
        }
        return  listNSX;
    }
    //thêm nhà sản xuất
    public void AddNSX(NSX nsx){
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenNSX",nsx.getTenNSX());
        db.insert("NSX",null,values);
        db.close();

    }
    //cập nhật nhà sản xuất
    public void UpdateNSX(NSX nsx){
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenNSX",nsx.getTenNSX());
        String masv = String.valueOf(nsx.getIdNSX());
        db.update("NSX",values,"MaNSX=?",new String[]{masv});
    }
    //Xoá nhà sản xuất
    public void DeleteNSX(NSX nsx){
        SQLiteDatabase db = database.getWritableDatabase();
        String masv = String.valueOf(nsx.getIdNSX());
        db.delete("NSX","MaNSX=?",new String[]{masv});
    }
}
