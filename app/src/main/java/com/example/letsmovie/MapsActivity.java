package com.example.letsmovie;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMinZoomPreference(11);

        // Add a marker in Sydney and move the camera
        LatLng cineplex = new LatLng(43.775658, -79.255701);


        MarkerOptions markerOptions = new MarkerOptions();
          mMap.addMarker(new MarkerOptions().position(cineplex).title("Cineplex Odiean").snippet("Movie theater || 300 Borough Drive")
                  .icon(BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_BLUE)));

//        mMap.position(cineplex)
//                .title("Cineplex Odiean")
//                .snippet("Snoqualmie Falls is located 25 miles east of Seattle.")
//                .icon(BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_BLUE));
//
//

        mMap.moveCamera(CameraUpdateFactory.newLatLng(cineplex));
      //  mMap.addMarker(new MarkerOptions().position(cineplex).title("Cineplex Odiean"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(cineplex));
    }
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Info window clicked",
                Toast.LENGTH_SHORT).show();
    }
}
