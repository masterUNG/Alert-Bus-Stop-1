package rsu.siriwimon.pakdeeporn.alertbusstop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ADMIN on 1/11/2559.
 */

public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    private Context context; //การเชื่อมต่อกัน
    public  static  final  String database_name = "BusStop.db";
    private  static  final  int database_version = 1 ;
    //คำสั่งในการสร้าง ตารางสำหรับเก็บข้อมูล
    private  static  final  String create_bus_table = "create table busTABLE (" +
            "_id integer primary key," +
            "NameBusStop text," +
            "PathBusStop text," +
            "Lat text," +
            "lng text, " +
            "Destination text);";

    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
        this.context = context;
    } // Contructer

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_bus_table); // ค่ารายละเอียดของคอลัม
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //พิมพ์ Log เพื่อให้เห็นว่ามีการ Upgrade Database
        Log.w(MyOpenHelper.class.getName(),
                "Upgread database version from version" + i + " to "
                        + i1+ ", which will destroy all old data");

        //ลบตาราง member ของเก่าทิ้ง
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS member");
        onCreate(sqLiteDatabase);

    }
} // Main Class
