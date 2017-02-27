package rsu.siriwimon.pakdeeporn.alertbusstop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Explicit
    private ListView listView;
    private Button button;
    private MyManage myManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myManage = new MyManage(MainActivity.this);

        //Bind Widget การผูกตัวแปร
        listView = (ListView) findViewById(R.id.livBusStop);
        button = (Button) findViewById(R.id.button);

        //Create ListView
        createListView();

        //Button controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mySoundEfect(R.raw.add_bus1);
            }// onClick
        });
        // Long Click Button Controller
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d("31octV1","You Click Long"); //ควบคุมการคลิก

                startActivity(new Intent(MainActivity.this,AddBusStop.class));//เคลื่อนย้ายการทำงาน

                return true;

            } // onLongClick
        });

    }// Main Medthod

    @Override
    protected void onResume() {
        super.onResume();
        createListView();
    }

    private void createListView() {

        try {

            //Read All SQLite
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM busTABLE WHERE Destination = 1" , null);
            cursor.moveToFirst();
            int intCursor = cursor.getCount();
            Log.d("27febV2", "intCursor ==> " + intCursor);

            String[] nameStrings = new String[intCursor];
            for (int i=0;i<intCursor;i++) {

                nameStrings[i] = cursor.getString(1);
                cursor.moveToNext();

            }   // for

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                    android.R.layout.simple_list_item_1, nameStrings);
            listView.setAdapter(stringArrayAdapter);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }   // createListView

    private void mySoundEfect(int intSound) {
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),intSound);
        mediaPlayer.start(); //ทำการร้อง

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release(); // คืนหน่วยความจำ
            }
        });
    } // mySoundEfect
}// Main class
