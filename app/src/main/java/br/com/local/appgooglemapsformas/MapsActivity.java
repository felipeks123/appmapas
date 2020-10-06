package br.com.local.appgooglemapsformas;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

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


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);




        final LatLng casa = new LatLng(-23.6755248, -46.7517092);


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Double latitude, longitude;

                latitude = latLng.latitude;
                longitude = latLng.longitude;

              Toast.makeText(getApplicationContext(),
                        "Latitude: " + latitude + "\n" +
                                "Longitude: " + longitude,
                        Toast.LENGTH_SHORT).show();



                mMap.addMarker(
                        new MarkerOptions()
                                .position(latLng)
                                .title("Local atual")
                                .snippet("Local de clique atual!!!")
                                .icon(
                                        BitmapDescriptorFactory.fromResource(R.drawable.onibus)
                                )
                );
            }
        });
        final Marker minha_casa = mMap.addMarker(
                new MarkerOptions()
                        .position(casa)
                        .title("minha casa")
                        .icon(
                                BitmapDescriptorFactory.fromResource(R.drawable.casa)
                        )

        );
        //o zoom da camera é de 2 até 21
        mMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(casa, 13));
    }
}