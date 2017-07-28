package com.shreyanshvit.quietclass;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.polyak.iconswitch.IconSwitch;

public class MainActivity extends AppCompatActivity {

    Button mStart, mStop;


    private TextView textView;
    private LocationManager locationManager;
    private LocationListener listener;
    private IconSwitch iconSwitch, iconSwitch1, iconSwitch2, iconSwitch3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);


        textView = (TextView) findViewById(R.id.textView);

        iconSwitch1 = (IconSwitch) findViewById(R.id.icon_switch_1);


        iconSwitch2 = (IconSwitch) findViewById(R.id.icon_switch_2);


        iconSwitch3 = (IconSwitch) findViewById(R.id.icon_switch_3);





        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if(iconSwitch1.getChecked() == IconSwitch.Checked.RIGHT) {
                    textView.append("\n " + location.getLongitude() + " " + location.getLatitude());
                    if (location.getLongitude() >= 79.163072 && location.getLongitude() <= 79.164640 && location.getLatitude() <= 12.971835 && location.getLatitude() >= 12.970227) {
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                    } else {
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

                    }
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };

        configure_button();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }


    void configure_button() {
        // first check for permissions
        if(iconSwitch1.getChecked() == IconSwitch.Checked.RIGHT){
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                            , 10);
                }
                return;
            }
        }
        locationManager.requestLocationUpdates("gps", 500, 0, listener);
        // this code won'textView execute IF permissions are not allowed, because in the line above there is return statement.

    }

}