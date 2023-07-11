package com.example.saloon_version_0.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.saloon_version_0.fragment.CartFragment;
import com.example.saloon_version_0.pojo.Products;

import java.util.ArrayList;
import java.util.List;

public class cartItemsDB extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_Name ="cart_DB";
    public cartItemsDB(@Nullable Context context) {
        super(context, DB_Name,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE cart(product_Id TEXT, product_Name TEXT, price DOUBLE, gender TEXT,description TEXT )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void additem(Products products){
        Log.e("cartDB","from cartDB "+products);
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("product_Id",products.getProduct_Id());
        values.put("product_Name",products.getProduct_Name());
        values.put("price",products.getPrice());
        values.put("gender",products.getGender());
        values.put("description",products.getDescription());
        db.insert("cart",null,values);

    }
    public List<Products> getAllItems(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("cart",null,null,null,null,null,null);
        List<Products> plist = new ArrayList<>();
        while (cursor.moveToNext())
       {
            Products p = new Products();
            p.setProduct_Id(cursor.getString(0));
            p.setProduct_Name(cursor.getString(1));
            p.setPrice(cursor.getDouble(2));
            p.setGender(cursor.getString(3));
            p.setDescription(cursor.getString(4));
            plist.add(p);
        }
        Log.e("fromDB","DB list"+plist);
        return plist;
    }
    public  void deleteitem(String Id){
        Log.e("cartItemDB","Item ID "+Id);
        SQLiteDatabase db = this.getWritableDatabase();
      int num =  db.delete("cart","product_Id=?",new String[]{Id});
        db.close();
    }
}
