package rsu.siriwimon.pakdeeporn.alertbusstop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ADMIN on 1/11/2559.
 */

public class MyManage {
    //Explicit
    private Context context ;
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public MyManage(Context context) {
        this.context = context;
        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getReadableDatabase();
    }
} // main class
