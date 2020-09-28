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

        // Add a marker in Sydney and move the camera
        final LatLng etecia = new LatLng(-23.702723, -46.6914657);

        /*
        Criando Circulos
        CircleOptions circleOptions = new CircleOptions();

        circleOptions.center(etecia);
        circleOptions.fillColor(Color.argb(100,204, 0, 153));
        circleOptions.strokeWidth(10);
        circleOptions.strokeColor(Color.GREEN);
        //Medida em metros
        circleOptions.radius(500.00);
         mMap.addCircle(circleOptions);
        */


        /*Criando Poligonos

        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.add(new LatLng(-23.701221, -46.685091));
        polygonOptions.add(new LatLng(-23.706370, -46.688433));
        polygonOptions.add(new LatLng(-23.700058, -46.691930));
        polygonOptions.add(new LatLng(-23.702861, -46.701149));
        polygonOptions.strokeColor(Color.BLUE);
        polygonOptions.fillColor(Color.argb(100, 204, 0, 153));
        polygonOptions.strokeWidth(10);

        mMap.addPolygon(polygonOptions);*/


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Double latitude, longitude;

                latitude = latLng.latitude;
                longitude = latLng.longitude;

                /*Toast.makeText(getApplicationContext(),
                        "Latitude: " + latitude + "\n" +
                                "Longitude: " + longitude,
                        Toast.LENGTH_SHORT).show();*/

                /*Desenhando linhas com base em um ponto

                PolygonOptions polygonOptions = new PolygonOptions();
                polygonOptions.add(etecia);
                polygonOptions.add(latLng);
                polygonOptions.strokeColor(Color.BLUE);
                polygonOptions.strokeWidth(18);

                mMap.addPolygon(polygonOptions);*/

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
        mMap.addMarker(
                new MarkerOptions()
                        .position(etecia)
                        .title("Etec Irmã Agostina")
                        .icon(
                                BitmapDescriptorFactory.fromResource(R.drawable.escola)
                        )

        );
        mMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(etecia, 13));
    }
}