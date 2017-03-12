package rsu.siriwimon.pakdeeporn.alertbusstop;

/**
 * Created by ADMIN on 12/3/2560.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity  extends AppCompatActivity {
    //ตัวแปรของ View
    private EditText txtNameBusStop, textPathBusStop, textLat, textlng,  textDestination ;
    private Button btnEdit;

    //ตัวแปรไว้เก็บว่าข้อมูลที่จะแก้ไข id เป็นอะไร
    private int id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //เชื่อม View
        txtNameBusStop = (EditText)findViewById(R.id.txtNameBusStop);
        textPathBusStop = (EditText)findViewById(R.id.textPathBusStop);
        textLat = (EditText)findViewById(R.id.textLat);


        btnEdit = (Button)findViewById(R.id.btnEdit);

        //รับค่าจาก MainActivity มาแสดงข้อมูลเพื่อทำการแก้ไข
        this.id = getIntent().getExtras().getInt("keyId");
        txtNameBusStop.setText(getIntent().getExtras().getString("keyNameBusStop"));
        textPathBusStop.setText(getIntent().getExtras().getString("keyPathBusStop"));

        //***** ในการส่งค่าและรับค่า ส่งเป็นตัวแปรชนิดไหน ต้องรับเป็นตัวแปรชนิดนั้น *****//

        //สร้าง Event ให้ปุ่มแก้ไขข้อมูล
        btnEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();

                //ตั้งค่าผลลัพธ์การทำงานว่า RESULT_OK
                setResult(RESULT_OK,i);

                //ส่งข้อมูลกลับไปให้ MainActivity ทำการแก้ไขข้อมูลให้
                i.putExtra("keyId", id);
                i.putExtra("keyName", txtName.getText().toString());
                i.putExtra("keySurname", txtSurname.getText().toString());
                i.putExtra("keyAge", Integer.parseInt(txtAge.getText().toString()));
                //***** ในการส่งค่าและรับค่า ส่งเป็นตัวแปรชนิดไหน ต้องรับเป็นตัวแปรชนิดนั้น *****//

                finish();
            }
        });
}
