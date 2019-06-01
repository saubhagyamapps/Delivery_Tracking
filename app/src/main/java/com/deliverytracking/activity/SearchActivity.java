package com.deliverytracking.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.constant.AvoidType;
import com.akexorcist.googledirection.constant.TransportMode;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.model.Route;
import com.akexorcist.googledirection.util.DirectionConverter;
import com.deliverytracking.R;
import com.deliverytracking.adepter.PlaceArrayAdapter;
import com.deliverytracking.adepter.PlaceArrayAdapterFrom;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.*;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks, DirectionCallback {
    private static final String TAG = "SearchActivity";
    private static final int GOOGLE_API_CLIENT_ID = 0;
    private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(new LatLng(22.9028759, 72.4541115), new LatLng(23.1378156, 72.7053737));
    int FLAG = 1;
    ImageView imageViewLocation;

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private PlaceArrayAdapter mPlaceArrayAdapter;
    private PlaceArrayAdapterFrom mPlaceArrayAdapterFrom;
    private AutoCompleteTextView mAutocompleteTextViewTo, mAutocompleteTextViewFrom;
    private double mStartlatitude, mStartlongitude;
    private double mEndlatitude, mEndlongitude;
    private String mSelectMapView;
    LatLng start = new LatLng(23.076921, 72.508146);
    LatLng end = new LatLng(23.039783, 72.561054);
    private String serverKey = "AIzaSyA1mDdfrmMitr2FDwXahYNDkU-IqbYMceA";

    private List<Polyline> polylines;
    private static final int[] COLORS = new int[]{R.color.colorPrimaryDark, R.color.colorAccent, R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimary};


    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallbackfrom
            = new ResultCallback<PlaceBuffer>() {
        @Override
        public void onResult(PlaceBuffer places) {
            if (!places.getStatus().isSuccess()) {
                Log.e("Location", "Place query did not complete. Error: " +
                        places.getStatus().toString());
                return;
            }
            // Selecting the first object buffer.
            final Place place = places.get(0);
            mEndlatitude = place.getLatLng().latitude;
            mEndlongitude = place.getLatLng().longitude;

            Log.i("name", place.getName().toString());
            Log.i("coordinates", place.getLatLng().toString());
        }
    };
    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallbackto
            = new ResultCallback<PlaceBuffer>() {
        @Override
        public void onResult(PlaceBuffer places) {
            if (!places.getStatus().isSuccess()) {
                Log.e("Location", "Place query did not complete. Error: " +
                        places.getStatus().toString());
                return;
            }
            // Selecting the first object buffer.
            final Place place = places.get(0);
            if (FLAG == 1) {
                mStartlatitude = place.getLatLng().latitude;
                mStartlongitude = place.getLatLng().longitude;
            }
            Log.i("name", place.getName().toString());
            Log.i("coordinates", place.getLatLng().toString());
        }
    };
    private AdapterView.OnItemClickListener mAutocompleteClickListenerTo
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final PlaceArrayAdapter.PlaceAutocomplete item = mPlaceArrayAdapter.getItem(position);
            final String placeId = String.valueOf(item.placeId);
            Log.i("Location", "Selected: " + item.description);
            PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
                    .getPlaceById(mGoogleApiClient, placeId);
            placeResult.setResultCallback(mUpdatePlaceDetailsCallbackto);
            Log.i("Location", "Fetching details for ID: " + item.placeId);
        }
    };
    private AdapterView.OnItemClickListener mAutocompleteClickListenerFrom
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final PlaceArrayAdapterFrom.PlaceAutocomplete item = mPlaceArrayAdapterFrom.getItem(position);
            final String placeId = String.valueOf(item.placeId);
            Log.i("Location", "Selected: " + item.description);
            PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
                    .getPlaceById(mGoogleApiClient, placeId);
            placeResult.setResultCallback(mUpdatePlaceDetailsCallbackfrom);
            Log.i("Location", "Fetching details for ID: " + item.placeId);
        }
    };

    public void getAddress(Context context, double LATITUDE, double LONGITUDE) {

        //Set Address
        try {
            Geocoder geocoder = new Geocoder(context, Locale.ENGLISH);
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null && addresses.size() > 0) {


                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();
                String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

                Log.d(TAG, "getAddress:  address" + address);
                Log.d(TAG, "getAddress:  city" + city);
                Log.d(TAG, "getAddress:  state" + state);
                Log.d(TAG, "getAddress:  postalCode" + postalCode);
                Log.d(TAG, "getAddress:  knownName" + knownName);
                mAutocompleteTextViewTo.setText(address);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        initialization();
        requestLocationUpdates();

    }

    private void initialization() {
        polylines = new ArrayList<>();


        mGoogleApiClient = new GoogleApiClient.Builder(SearchActivity.this)
                .addApi(Places.GEO_DATA_API)
                .enableAutoManage(this, GOOGLE_API_CLIENT_ID, this)
                .addConnectionCallbacks(this)
                .build();

        mAutocompleteTextViewTo = findViewById(R.id.autoCompleteTextViewTO);
        mAutocompleteTextViewFrom = findViewById(R.id.autoCompleteTextViewFrom);

        imageViewLocation = findViewById(R.id.imgLocation);
        mAutocompleteTextViewTo.setThreshold(0);
        mAutocompleteTextViewTo.setOnItemClickListener(mAutocompleteClickListenerTo);
        mPlaceArrayAdapter = new PlaceArrayAdapter(this, R.layout.list_view, BOUNDS_MOUNTAIN_VIEW, null, R.drawable.marker_a);
        mAutocompleteTextViewTo.setAdapter(mPlaceArrayAdapter);

        mAutocompleteTextViewFrom.setThreshold(0);
        mAutocompleteTextViewFrom.setOnItemClickListener(mAutocompleteClickListenerFrom);
        mPlaceArrayAdapterFrom = new PlaceArrayAdapterFrom(this, android.R.layout.simple_list_item_1, BOUNDS_MOUNTAIN_VIEW, null);
        mAutocompleteTextViewFrom.setAdapter(mPlaceArrayAdapterFrom);


        mAutocompleteTextViewTo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (mAutocompleteTextViewTo.getRight() - mAutocompleteTextViewTo.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        mAutocompleteTextViewTo.getText().clear();
                        return true;
                    }
                }
                return false;
            }
        });
    }


    private void requestLocationUpdates() {
        @SuppressLint("RestrictedApi") LocationRequest request = new LocationRequest();
        request.setInterval(100);
        request.setFastestInterval(100);
        FusedLocationProviderClient client = LocationServices.getFusedLocationProviderClient(this);
        int permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        if (permission == PackageManager.PERMISSION_GRANTED) {

            client.requestLocationUpdates(request, new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    final Location location = locationResult.getLastLocation();
                    if (location != null) {
                        Log.e(TAG, "location update " + location.getLongitude());
                        imageViewLocation.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                FLAG = 0;
                                mStartlatitude = location.getLatitude();
                                mStartlongitude = location.getLongitude();
                                getAddress(getApplicationContext(), mStartlatitude, mStartlongitude);
                            }
                        });
                    }
                }
            }, null);
        }
    }


    @Override
    public void onConnected(Bundle bundle) {
        mPlaceArrayAdapter.setGoogleApiClient(mGoogleApiClient);
        mPlaceArrayAdapterFrom.setGoogleApiClient(mGoogleApiClient);
        Log.i("Location", "Google Places API connected.");

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.e("Location", "Google Places API connection failed with error code: "
                + connectionResult.getErrorCode());

        Toast.makeText(this,
                "Google Places API connection failed with error code:" +
                        connectionResult.getErrorCode(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int i) {
        mPlaceArrayAdapter.setGoogleApiClient(null);
        mPlaceArrayAdapterFrom.setGoogleApiClient(null);
        Log.e("Location", "Google Places API connection suspended.");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        GoogleDirection.withServerKey(serverKey)
                .from(start)
                .to(end)
                .transportMode(TransportMode.DRIVING)
                .execute(this);

    }


    @Override
    public void onDirectionSuccess(Direction direction, String rawBody) {
        if (direction.isOK()) {
            Route route = direction.getRouteList().get(0);

            Log.e(TAG, "onDirectionSuccess: " + direction.getRouteList().get(0).getLegList().get(0).getDistance().getText().toString());
            mMap.addMarker(new MarkerOptions().position(start));
            mMap.addMarker(new MarkerOptions().position(end));

            ArrayList<LatLng> directionPositionList = route.getLegList().get(0).getDirectionPoint();

            Toast.makeText(this, route.getLegList().get(0).getDistance().getText(), Toast.LENGTH_SHORT).show();
            Log.e(TAG, "onDirectionSuccess: " +route.getLegList().get(0).getDuration().getText());
            mMap.addPolyline(DirectionConverter.createPolyline(this, directionPositionList, 5, Color.BLUE));
        //    setCameraWithCoordinationBounds(route);
            CameraUpdate center=
                    CameraUpdateFactory.newLatLng(start);
            CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);

            mMap.moveCamera(center);
            mMap.animateCamera(zoom);

        } else {
        }
    }

    @Override
    public void onDirectionFailure(Throwable t) {
    }

    private void setCameraWithCoordinationBounds(Route route) {
        LatLng southwest = route.getBound().getSouthwestCoordination().getCoordination();
        LatLng northeast = route.getBound().getNortheastCoordination().getCoordination();
        LatLngBounds bounds = new LatLngBounds(southwest, northeast);
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 35));
    }

}

