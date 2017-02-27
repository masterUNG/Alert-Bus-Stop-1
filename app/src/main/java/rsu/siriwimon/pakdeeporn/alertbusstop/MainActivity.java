package rsu.siriwimon.pakdeeporn.alertbusstop;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
