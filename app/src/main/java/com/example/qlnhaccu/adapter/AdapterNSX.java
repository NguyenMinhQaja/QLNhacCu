package com.example.qlnhaccu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.qlnhaccu.R;
import com.example.qlnhaccu.activity_nsx;
import com.example.qlnhaccu.model.NSX;

import java.util.ArrayList;
import java.util.List;

public class AdapterNSX extends BaseAdapter {
    private Context context;
    private List<NSX> listNSX;

    public AdapterNSX(Context context, List<NSX> listNSX) {
        this.context = context;
        this.listNSX = listNSX;
    }

    @Override
    public int getCount() {

        return listNSX.size();
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            //convert resoure to view
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item_nsx,null);
            //ánh xạ
            viewHolder.tvMaNSX = convertView.findViewById(R.id.tv_mansx);
            viewHolder.tvTenNSX = convertView.findViewById(R.id.tv_tennsx);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NSX nsx = listNSX.get(position);
        viewHolder.tvMaNSX.setText("Mã NSX: "+ nsx.getIdNSX());
        viewHolder.tvTenNSX.setText("Tên NSX: "+ nsx.getTenNSX());
        return convertView;

    }

    class ViewHolder{
        TextView tvMaNSX, tvTenNSX;
    }
}
