package edu.uw.fmendoza.maplab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng fountain = new LatLng(47.653802, -122.307530);

        mMap.addMarker(new MarkerOptions().position(fountain).title("UW Fountain").snippet("ducks here have huskies as brothers")
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fountain));
        PolylineOptions w = new PolylineOptions();
        LatLng left = new LatLng(47.653851, -122.308306);
        w.add(left);
        LatLng leftDownCorner = new LatLng(47.653524, -122.307702);
        w.add(leftDownCorner);
        LatLng belly = new LatLng(47.653643, -122.307692);
        w.add(belly);
        LatLng rightDownCorner = new LatLng(47.653586, -122.307526);
        w.add(rightDownCorner);
        LatLng right = new LatLng(47.654076, -122.307619);
        w.add(right);

        w.color(R.color.purple);
        mMap.addPolyline(w);
    }
}
