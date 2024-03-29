package com.shreyanshvit.quietclass;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.polyak.iconswitch.IconSwitch;
import com.wang.avi.AVLoadingIndicatorView;

import vn.luongvo.widget.iosswitchview.SwitchView;

import static android.R.id.toggle;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {





    private LocationManager locationManager;
    private LocationListener listener;
    private SwitchView  iconSwitch1, iconSwitch2, iconSwitch3, iconSwitch4, iconSwitch5, iconSwitch6, iconSwitch7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        final AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);



        iconSwitch1 = (SwitchView) findViewById(R.id.icon_switch_1);
        iconSwitch2 = (SwitchView) findViewById(R.id.icon_switch_2);
        iconSwitch3 = (SwitchView) findViewById(R.id.icon_switch_3);
        iconSwitch4 = (SwitchView) findViewById(R.id.icon_switch_4);
        iconSwitch5 = (SwitchView) findViewById(R.id.icon_switch_5);
        iconSwitch6 = (SwitchView) findViewById(R.id.icon_switch_6);
        iconSwitch7 = (SwitchView) findViewById(R.id.icon_switch_7);

        YoYo.with(Techniques.Pulse)
                .duration(1000)
                .playOn(findViewById(R.id.textView));


        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom);
        dialog.setCanceledOnTouchOutside(false);
        TextView text = (TextView) dialog.findViewById(R.id.custom_text);
        text.setText("Configuring...");
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        SharedPreferences sharedPreferences = getSharedPreferences("com.shreyanshvit.quietclass", MODE_PRIVATE);
        final SharedPreferences.Editor preferences = sharedPreferences.edit();
        iconSwitch1.setChecked(sharedPreferences.getBoolean("isChecked1",false));
        iconSwitch2.setChecked(sharedPreferences.getBoolean("isChecked2",false));
        iconSwitch3.setChecked(sharedPreferences.getBoolean("isChecked3",false));
        iconSwitch4.setChecked(sharedPreferences.getBoolean("isChecked4",false));
        iconSwitch5.setChecked(sharedPreferences.getBoolean("isChecked5",false));
        iconSwitch6.setChecked(sharedPreferences.getBoolean("isChecked6",false));
        iconSwitch7.setChecked(sharedPreferences.getBoolean("isChecked7",false));


        iconSwitch1.setOnCheckedChangeListener(new SwitchView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchView switchView, boolean b) {
                if(iconSwitch1.isChecked()){
                    preferences.putBoolean("isChecked1",true);
                }else {
                    preferences.putBoolean("isChecked1",false);
                }
                preferences.commit();
            }
        });

        iconSwitch2.setOnCheckedChangeListener(new SwitchView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchView switchView, boolean b) {
                if(iconSwitch2.isChecked()){
                    preferences.putBoolean("isChecked2",true);
                }else {
                    preferences.putBoolean("isChecked2",false);
                }
                preferences.commit();
            }
        });

        iconSwitch3.setOnCheckedChangeListener(new SwitchView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchView switchView, boolean b) {
                if(iconSwitch3.isChecked()){
                    preferences.putBoolean("isChecked3",true);
                }else {
                    preferences.putBoolean("isChecked3",false);
                }
                preferences.commit();
            }
        });

        iconSwitch4.setOnCheckedChangeListener(new SwitchView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchView switchView, boolean b) {
                if(iconSwitch4.isChecked()){
                    preferences.putBoolean("isChecked4",true);
                }else {
                    preferences.putBoolean("isChecked4",false);
                }
                preferences.commit();
            }
        });

        iconSwitch5.setOnCheckedChangeListener(new SwitchView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchView switchView, boolean b) {
                if(iconSwitch5.isChecked()){
                    preferences.putBoolean("isChecked5",true);
                }else {
                    preferences.putBoolean("isChecked5",false);
                }
                preferences.commit();
            }
        });

        iconSwitch6.setOnCheckedChangeListener(new SwitchView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchView switchView, boolean b) {
                if(iconSwitch6.isChecked()){
                    preferences.putBoolean("isChecked6",true);
                }else {
                    preferences.putBoolean("isChecked6",false);
                }
                preferences.commit();
            }
        });

        iconSwitch7.setOnCheckedChangeListener(new SwitchView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchView switchView, boolean b) {
                if(iconSwitch7.isChecked()){
                    preferences.putBoolean("isChecked7",true);
                }else {
                    preferences.putBoolean("isChecked7",false);
                }
                preferences.commit();
            }
        });

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                if(iconSwitch1.isChecked() || iconSwitch2.isChecked()|| iconSwitch3.isChecked() || iconSwitch4.isChecked() || iconSwitch5.isChecked()|| iconSwitch6.isChecked() || iconSwitch7.isChecked()){
                    if (location.getLongitude() >= 79.163072 && location.getLongitude() <= 79.164640 && location.getLatitude() <= 12.971835 && location.getLatitude() >= 12.970227) {
                        if(iconSwitch1.isChecked()) {
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        }
                        else{
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        }

                    }
                    else if (location.getLongitude() >= 79.158825 && location.getLongitude() <= 79.160177 && location.getLatitude() <= 12.971118 && location.getLatitude() >= 12.970156) {
                        if(iconSwitch2.isChecked()) {
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        }
                        else{
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        }
                    }
                    else if (location.getLongitude() >= 79.154427 && location.getLongitude() <= 79.155326 && location.getLatitude() <= 12.970405 && location.getLatitude() >= 12.969775) {
                        if(iconSwitch3.isChecked()) {
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        }
                        else{
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        }
                    }
                     else if (location.getLongitude() >= 79.156563 && location.getLongitude() <= 79.157107 && location.getLatitude() <= 12.969590 && location.getLatitude() >= 12.969088) {
                        if(iconSwitch4.isChecked()) {
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        }
                        else{
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        }
                    }
                    else if (location.getLongitude() >= 79.157228 && location.getLongitude() <= 79.158226 && location.getLatitude() <= 12.969616 && location.getLatitude() >= 12.968826) {
                        if(iconSwitch5.isChecked()) {
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        }
                        else{
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        }
                    }
                    else if (location.getLongitude() >= 79.155385 && location.getLongitude() <= 79.156439 && location.getLatitude() <= 12.969571 && location.getLatitude() >= 12.968847) {
                        if(iconSwitch6.isChecked()) {
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        }
                        else{
                            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        }
                    }
                    else {
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

                    }

                }

                dialog.dismiss();
                YoYo.with(Techniques.Pulse)
                        .duration(1000)
                        .repeat(5)
                        .playOn(findViewById(R.id.textView));
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
        dialog.show();
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

        locationManager.requestLocationUpdates("gps", 200, 0, listener);
        // this code won'textView execute IF permissions are not allowed, because in the line above there is return statement.

    }

}