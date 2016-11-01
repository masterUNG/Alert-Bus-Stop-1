package rsu.siriwimon.pakdeeporn.alertbusstop;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AddBusStop extends FragmentActivity implements OnMapReadyCallback {
    // Explicit
    private GoogleMap mMap;
    private EditText editText;
    private Button button;
    private String nameBusStopString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_addbusstop_layout);
        // Bind Widget
        editText = (EditText) findViewById(R.id.editText) ;
        button = (Button) findViewById(R.id.button2);

        // button controller ปุ่มคลิ๊ก
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

             // Get Value From EditText รับค่าจาก EditText
               nameBusStopString = editText.getText().toString().trim();

               // Check spece
                   if (nameBusStopString.equals("")) {
                       // Have Space
                        MyAlert myAlert = new MyAlert(AddBusStop.this,
                                R.drawable.doremon48,
                                getResources().getString(R.string.title_have_space),
                                getResources().getString(R.string.massage_have_space));
                       myAlert.myDialog();

                   } // if
           } // onClick
       });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    } // Main Method


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    } // onMapReady
} // Main Class
