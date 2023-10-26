package com.geology_quiz_and_guide.mineralogy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class Ficha extends AppCompatActivity {
    private TextView autorFotoTV,nombreTV,tipo2TV,clase2TV,grupo2TV,formula2TV,sistema2TV,ambientes1TV,ambientes2TV,propiedadesTV,habito2TV,
            color2TV,diafanidad2TV,brillo2TV,raya2TV,densidad2TV,dureza2TV,exfoliacion2TV,otras2TV,toolbarTextView;
    private ScrollView screen;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor myEdit;
    private ImageView imagenTV;
    private String language;
    private int adLoadAttempts = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha);
        setSupportActionBar(findViewById(R.id.toolbar));


        //toolbarTextView = findViewById(R.id.toolbarTextView);
        screen = findViewById(R.id.screen);

        sharedPreferences = this.getSharedPreferences("UserPreferences", MODE_PRIVATE);
        myEdit = sharedPreferences.edit();
        String theme = sharedPreferences.getString("theme", "light");
        String sizeText = sharedPreferences.getString("sizeText", "medium");
        language = sharedPreferences.getString("language", Locale.getDefault().getLanguage());
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        String isTablet = isTablet(this);
        //restaCoins();
        /*if (sharedPreferences.getInt("coins",301)<0) {
            Context context = new ContextThemeWrapper(Ficha.this, R.style.Theme_MaterialComponents);
            MaterialAlertDialogBuilder alert = null;
            switch (theme) {
                case "darck":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(context, R.style.Dialog_darck_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(context, R.style.Dialog_darck_tablet);
                    }
                    break;
                case "light":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(context, R.style.Dialog_light_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(context, R.style.Dialog_light_tablet);
                    }
                    break;
                case "green":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(context, R.style.Dialog_green_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(context, R.style.Dialog_green_tablet);
                    }
                    break;
                case "blue":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(context, R.style.Dialog_blue_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(context, R.style.Dialog_blue_tablet);
                    }
                    break;
            }
            try {
                alert.setTitle(R.string.no_coins);
            } catch (Exception ignored) {
            }
            alert.setMessage(R.string.go_to_the_store_to_continue);
            alert.setPositiveButton(R.string.see_video,
                    (dialog, which) -> {
                        add300Coins();
                        dialog.cancel();
                    });
            alert.show();
        }*/

        switch (theme) {
            case "darck":
                screen.setBackgroundColor(getResources().getColor(R.color.darck));
                break;
            case "light":
                screen.setBackgroundColor(getResources().getColor(R.color.light));
                break;
            case "green":
                screen.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            case "blue":
                screen.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
        }
        nombreTV = findViewById(R.id.tv1);
        imagenTV = findViewById(R.id.imageView);
        TextView tipo1TV = findViewById(R.id.tv3);
        tipo2TV = findViewById(R.id.tv4);
        TextView clase1TV = findViewById(R.id.tv5);
        clase2TV = findViewById(R.id.tv6);
        TextView grupo1TV = findViewById(R.id.tv7);
        grupo2TV = findViewById(R.id.tv8);
        TextView formula1TV = findViewById(R.id.tv9);
        formula2TV = findViewById(R.id.tv10);
        TextView sistema1TV = findViewById(R.id.tv11);
        sistema2TV = findViewById(R.id.tv12);
        ambientes1TV = findViewById(R.id.tv13);
        ambientes2TV = findViewById(R.id.tv14);
        propiedadesTV = findViewById(R.id.tv15);
        TextView habito1TV = findViewById(R.id.tv16);
        habito2TV = findViewById(R.id.tv17);
        TextView color1TV = findViewById(R.id.tv18);
        color2TV = findViewById(R.id.tv19);
        TextView diafanidad1TV = findViewById(R.id.tv20);
        diafanidad2TV = findViewById(R.id.tv21);
        TextView brillo1TV = findViewById(R.id.tv22);
        brillo2TV = findViewById(R.id.tv23);
        TextView raya1TV = findViewById(R.id.tv24);
        raya2TV = findViewById(R.id.tv25);
        TextView dureza1TV = findViewById(R.id.tv26);
        dureza2TV = findViewById(R.id.tv27);
        TextView densidad1TV = findViewById(R.id.tv28);
        densidad2TV = findViewById(R.id.tv29);
        TextView exfoliacion1TV = findViewById(R.id.tv30);
        exfoliacion2TV = findViewById(R.id.tv31);
        TextView otras1TV = findViewById(R.id.tv32);
        otras2TV = findViewById(R.id.tv33);
        if (theme.equals("darck")) {
            nombreTV.setTextColor(getResources().getColor(R.color.black));
            tipo1TV.setTextColor(getResources().getColor(R.color.white));
            tipo2TV.setTextColor(getResources().getColor(R.color.white));
            clase1TV.setTextColor(getResources().getColor(R.color.white));
            clase2TV.setTextColor(getResources().getColor(R.color.white));
            grupo1TV.setTextColor(getResources().getColor(R.color.white));
            grupo2TV.setTextColor(getResources().getColor(R.color.white));
            formula1TV.setTextColor(getResources().getColor(R.color.white));
            formula2TV.setTextColor(getResources().getColor(R.color.white));
            sistema1TV.setTextColor(getResources().getColor(R.color.white));
            sistema2TV.setTextColor(getResources().getColor(R.color.white));
            ambientes1TV.setTextColor(getResources().getColor(R.color.black));
            ambientes2TV.setTextColor(getResources().getColor(R.color.white));
            propiedadesTV.setTextColor(getResources().getColor(R.color.black));
            habito1TV.setTextColor(getResources().getColor(R.color.white));
            habito2TV.setTextColor(getResources().getColor(R.color.white));
            color1TV.setTextColor(getResources().getColor(R.color.white));
            color2TV.setTextColor(getResources().getColor(R.color.white));
            diafanidad1TV.setTextColor(getResources().getColor(R.color.white));
            diafanidad2TV.setTextColor(getResources().getColor(R.color.white));
            brillo1TV.setTextColor(getResources().getColor(R.color.white));
            brillo2TV.setTextColor(getResources().getColor(R.color.white));
            raya1TV.setTextColor(getResources().getColor(R.color.white));
            raya2TV.setTextColor(getResources().getColor(R.color.white));
            dureza1TV.setTextColor(getResources().getColor(R.color.white));
            dureza2TV.setTextColor(getResources().getColor(R.color.white));
            densidad1TV.setTextColor(getResources().getColor(R.color.white));
            densidad2TV.setTextColor(getResources().getColor(R.color.white));
            exfoliacion1TV.setTextColor(getResources().getColor(R.color.white));
            exfoliacion2TV.setTextColor(getResources().getColor(R.color.white));
            otras1TV.setTextColor(getResources().getColor(R.color.white));
            otras2TV.setTextColor(getResources().getColor(R.color.white));
        } else {
            nombreTV.setTextColor(getResources().getColor(R.color.black));
            tipo1TV.setTextColor(getResources().getColor(R.color.black));
            tipo2TV.setTextColor(getResources().getColor(R.color.black));
            clase1TV.setTextColor(getResources().getColor(R.color.black));
            clase2TV.setTextColor(getResources().getColor(R.color.black));
            grupo1TV.setTextColor(getResources().getColor(R.color.black));
            grupo2TV.setTextColor(getResources().getColor(R.color.black));
            formula1TV.setTextColor(getResources().getColor(R.color.black));
            formula2TV.setTextColor(getResources().getColor(R.color.black));
            sistema1TV.setTextColor(getResources().getColor(R.color.black));
            sistema2TV.setTextColor(getResources().getColor(R.color.black));
            ambientes1TV.setTextColor(getResources().getColor(R.color.black));
            ambientes2TV.setTextColor(getResources().getColor(R.color.black));
            propiedadesTV.setTextColor(getResources().getColor(R.color.black));
            habito1TV.setTextColor(getResources().getColor(R.color.black));
            habito2TV.setTextColor(getResources().getColor(R.color.black));
            color1TV.setTextColor(getResources().getColor(R.color.black));
            color2TV.setTextColor(getResources().getColor(R.color.black));
            diafanidad1TV.setTextColor(getResources().getColor(R.color.black));
            diafanidad2TV.setTextColor(getResources().getColor(R.color.black));
            brillo1TV.setTextColor(getResources().getColor(R.color.black));
            brillo2TV.setTextColor(getResources().getColor(R.color.black));
            raya1TV.setTextColor(getResources().getColor(R.color.black));
            raya2TV.setTextColor(getResources().getColor(R.color.black));
            dureza1TV.setTextColor(getResources().getColor(R.color.black));
            dureza2TV.setTextColor(getResources().getColor(R.color.black));
            densidad1TV.setTextColor(getResources().getColor(R.color.black));
            densidad2TV.setTextColor(getResources().getColor(R.color.black));
            exfoliacion1TV.setTextColor(getResources().getColor(R.color.black));
            exfoliacion2TV.setTextColor(getResources().getColor(R.color.black));
            otras1TV.setTextColor(getResources().getColor(R.color.black));
            otras2TV.setTextColor(getResources().getColor(R.color.black));
        }
        /*switch (isTablet) {
            case "Phone":
                toolbarTextView.setTextSize(18);
                break;
            case "Tablet7":
                toolbarTextView.setTextSize(22);
                break;
            case "Tablet10":
                toolbarTextView.setTextSize(26);
                break;
        }*/
        switch (sizeText) {
            case "very big":
                if (isTablet.equals("Phone")) {
                    nombreTV.setTextSize(24);
                    ambientes1TV.setTextSize(24);
                    propiedadesTV.setTextSize(24);
                    tipo1TV.setTextSize(18);
                    tipo2TV.setTextSize(18);
                    clase1TV.setTextSize(18);
                    clase2TV.setTextSize(18);
                    grupo1TV.setTextSize(18);
                    grupo2TV.setTextSize(18);
                    formula1TV.setTextSize(18);
                    formula2TV.setTextSize(18);
                    sistema1TV.setTextSize(18);
                    sistema2TV.setTextSize(18);
                    ambientes2TV.setTextSize(18);
                    habito1TV.setTextSize(18);
                    habito2TV.setTextSize(18);
                    color1TV.setTextSize(18);
                    color2TV.setTextSize(18);
                    diafanidad1TV.setTextSize(18);
                    diafanidad2TV.setTextSize(18);
                    brillo1TV.setTextSize(18);
                    brillo2TV.setTextSize(18);
                    raya1TV.setTextSize(18);
                    raya2TV.setTextSize(18);
                    dureza1TV.setTextSize(18);
                    dureza2TV.setTextSize(18);
                    densidad1TV.setTextSize(18);
                    densidad2TV.setTextSize(18);
                    exfoliacion1TV.setTextSize(18);
                    exfoliacion2TV.setTextSize(18);
                    otras1TV.setTextSize(18);
                    otras2TV.setTextSize(18);
                } else if (isTablet.equals("Tablet7")) {
                    nombreTV.setTextSize(30);
                    ambientes1TV.setTextSize(30);
                    propiedadesTV.setTextSize(30);
                    tipo1TV.setTextSize(24);
                    tipo2TV.setTextSize(24);
                    clase1TV.setTextSize(24);
                    clase2TV.setTextSize(24);
                    grupo1TV.setTextSize(24);
                    grupo2TV.setTextSize(24);
                    formula1TV.setTextSize(24);
                    formula2TV.setTextSize(24);
                    sistema1TV.setTextSize(24);
                    sistema2TV.setTextSize(24);
                    ambientes2TV.setTextSize(24);
                    habito1TV.setTextSize(24);
                    habito2TV.setTextSize(24);
                    color1TV.setTextSize(24);
                    color2TV.setTextSize(24);
                    diafanidad1TV.setTextSize(24);
                    diafanidad2TV.setTextSize(24);
                    brillo1TV.setTextSize(24);
                    brillo2TV.setTextSize(24);
                    raya1TV.setTextSize(24);
                    raya2TV.setTextSize(24);
                    dureza1TV.setTextSize(24);
                    dureza2TV.setTextSize(24);
                    densidad1TV.setTextSize(24);
                    densidad2TV.setTextSize(24);
                    exfoliacion1TV.setTextSize(24);
                    exfoliacion2TV.setTextSize(24);
                    otras1TV.setTextSize(24);
                    otras2TV.setTextSize(24);
                } else {
                    nombreTV.setTextSize(34);
                    ambientes1TV.setTextSize(34);
                    propiedadesTV.setTextSize(34);
                    tipo1TV.setTextSize(28);
                    tipo2TV.setTextSize(28);
                    clase1TV.setTextSize(28);
                    clase2TV.setTextSize(28);
                    grupo1TV.setTextSize(28);
                    grupo2TV.setTextSize(28);
                    formula1TV.setTextSize(28);
                    formula2TV.setTextSize(28);
                    sistema1TV.setTextSize(28);
                    sistema2TV.setTextSize(28);
                    ambientes2TV.setTextSize(28);
                    habito1TV.setTextSize(28);
                    habito2TV.setTextSize(28);
                    color1TV.setTextSize(28);
                    color2TV.setTextSize(28);
                    diafanidad1TV.setTextSize(28);
                    diafanidad2TV.setTextSize(28);
                    brillo1TV.setTextSize(28);
                    brillo2TV.setTextSize(28);
                    raya1TV.setTextSize(28);
                    raya2TV.setTextSize(28);
                    dureza1TV.setTextSize(28);
                    dureza2TV.setTextSize(28);
                    densidad1TV.setTextSize(28);
                    densidad2TV.setTextSize(28);
                    exfoliacion1TV.setTextSize(28);
                    exfoliacion2TV.setTextSize(28);
                    otras1TV.setTextSize(28);
                    otras2TV.setTextSize(28);
                }
                break;
            case "big":
                if (isTablet.equals("Phone")) {
                    nombreTV.setTextSize(22);
                    ambientes1TV.setTextSize(22);
                    propiedadesTV.setTextSize(22);
                    tipo1TV.setTextSize(16);
                    tipo2TV.setTextSize(16);
                    clase1TV.setTextSize(16);
                    clase2TV.setTextSize(16);
                    grupo1TV.setTextSize(16);
                    grupo2TV.setTextSize(16);
                    formula1TV.setTextSize(16);
                    formula2TV.setTextSize(16);
                    sistema1TV.setTextSize(16);
                    sistema2TV.setTextSize(16);
                    ambientes2TV.setTextSize(16);
                    habito1TV.setTextSize(16);
                    habito2TV.setTextSize(16);
                    color1TV.setTextSize(16);
                    color2TV.setTextSize(16);
                    diafanidad1TV.setTextSize(16);
                    diafanidad2TV.setTextSize(16);
                    brillo1TV.setTextSize(16);
                    brillo2TV.setTextSize(16);
                    raya1TV.setTextSize(16);
                    raya2TV.setTextSize(16);
                    dureza1TV.setTextSize(16);
                    dureza2TV.setTextSize(16);
                    densidad1TV.setTextSize(16);
                    densidad2TV.setTextSize(16);
                    exfoliacion1TV.setTextSize(16);
                    exfoliacion2TV.setTextSize(16);
                    otras1TV.setTextSize(16);
                    otras2TV.setTextSize(16);
                } else if (isTablet.equals("Tablet7")) {
                    nombreTV.setTextSize(28);
                    ambientes1TV.setTextSize(28);
                    propiedadesTV.setTextSize(28);
                    tipo1TV.setTextSize(22);
                    tipo2TV.setTextSize(22);
                    clase1TV.setTextSize(22);
                    clase2TV.setTextSize(22);
                    grupo1TV.setTextSize(22);
                    grupo2TV.setTextSize(22);
                    formula1TV.setTextSize(22);
                    formula2TV.setTextSize(22);
                    sistema1TV.setTextSize(22);
                    sistema2TV.setTextSize(22);
                    ambientes2TV.setTextSize(22);
                    habito1TV.setTextSize(22);
                    habito2TV.setTextSize(22);
                    color1TV.setTextSize(22);
                    color2TV.setTextSize(22);
                    diafanidad1TV.setTextSize(22);
                    diafanidad2TV.setTextSize(22);
                    brillo1TV.setTextSize(22);
                    brillo2TV.setTextSize(22);
                    raya1TV.setTextSize(22);
                    raya2TV.setTextSize(22);
                    dureza1TV.setTextSize(22);
                    dureza2TV.setTextSize(22);
                    densidad1TV.setTextSize(22);
                    densidad2TV.setTextSize(22);
                    exfoliacion1TV.setTextSize(22);
                    exfoliacion2TV.setTextSize(22);
                    otras1TV.setTextSize(22);
                    otras2TV.setTextSize(22);
                } else {
                    nombreTV.setTextSize(32);
                    ambientes1TV.setTextSize(32);
                    propiedadesTV.setTextSize(32);
                    tipo1TV.setTextSize(26);
                    tipo2TV.setTextSize(26);
                    clase1TV.setTextSize(26);
                    clase2TV.setTextSize(26);
                    grupo1TV.setTextSize(26);
                    grupo2TV.setTextSize(26);
                    formula1TV.setTextSize(26);
                    formula2TV.setTextSize(26);
                    sistema1TV.setTextSize(26);
                    sistema2TV.setTextSize(26);
                    ambientes2TV.setTextSize(26);
                    habito1TV.setTextSize(26);
                    habito2TV.setTextSize(26);
                    color1TV.setTextSize(26);
                    color2TV.setTextSize(26);
                    diafanidad1TV.setTextSize(26);
                    diafanidad2TV.setTextSize(26);
                    brillo1TV.setTextSize(26);
                    brillo2TV.setTextSize(26);
                    raya1TV.setTextSize(26);
                    raya2TV.setTextSize(26);
                    dureza1TV.setTextSize(26);
                    dureza2TV.setTextSize(26);
                    densidad1TV.setTextSize(26);
                    densidad2TV.setTextSize(26);
                    exfoliacion1TV.setTextSize(26);
                    exfoliacion2TV.setTextSize(26);
                    otras1TV.setTextSize(26);
                    otras2TV.setTextSize(26);
                }
                break;
            case "medium":
                if (isTablet.equals("Phone")) {
                    nombreTV.setTextSize(20);
                    ambientes1TV.setTextSize(20);
                    propiedadesTV.setTextSize(20);
                    tipo1TV.setTextSize(14);
                    tipo2TV.setTextSize(14);
                    clase1TV.setTextSize(14);
                    clase2TV.setTextSize(14);
                    grupo1TV.setTextSize(14);
                    grupo2TV.setTextSize(14);
                    formula1TV.setTextSize(14);
                    formula2TV.setTextSize(14);
                    sistema1TV.setTextSize(14);
                    sistema2TV.setTextSize(14);
                    ambientes2TV.setTextSize(14);
                    habito1TV.setTextSize(14);
                    habito2TV.setTextSize(14);
                    color1TV.setTextSize(14);
                    color2TV.setTextSize(14);
                    diafanidad1TV.setTextSize(14);
                    diafanidad2TV.setTextSize(14);
                    brillo1TV.setTextSize(14);
                    brillo2TV.setTextSize(14);
                    raya1TV.setTextSize(14);
                    raya2TV.setTextSize(14);
                    dureza1TV.setTextSize(14);
                    dureza2TV.setTextSize(14);
                    densidad1TV.setTextSize(14);
                    densidad2TV.setTextSize(14);
                    exfoliacion1TV.setTextSize(14);
                    exfoliacion2TV.setTextSize(14);
                    otras1TV.setTextSize(14);
                    otras2TV.setTextSize(14);
                } else if (isTablet.equals("Tablet7")) {
                    nombreTV.setTextSize(26);
                    ambientes1TV.setTextSize(26);
                    propiedadesTV.setTextSize(26);
                    tipo1TV.setTextSize(20);
                    tipo2TV.setTextSize(20);
                    clase1TV.setTextSize(20);
                    clase2TV.setTextSize(20);
                    grupo1TV.setTextSize(20);
                    grupo2TV.setTextSize(20);
                    formula1TV.setTextSize(20);
                    formula2TV.setTextSize(20);
                    sistema1TV.setTextSize(20);
                    sistema2TV.setTextSize(20);
                    ambientes2TV.setTextSize(20);
                    habito1TV.setTextSize(20);
                    habito2TV.setTextSize(20);
                    color1TV.setTextSize(20);
                    color2TV.setTextSize(20);
                    diafanidad1TV.setTextSize(20);
                    diafanidad2TV.setTextSize(20);
                    brillo1TV.setTextSize(20);
                    brillo2TV.setTextSize(20);
                    raya1TV.setTextSize(20);
                    raya2TV.setTextSize(20);
                    dureza1TV.setTextSize(20);
                    dureza2TV.setTextSize(20);
                    densidad1TV.setTextSize(20);
                    densidad2TV.setTextSize(20);
                    exfoliacion1TV.setTextSize(20);
                    exfoliacion2TV.setTextSize(20);
                    otras1TV.setTextSize(20);
                    otras2TV.setTextSize(20);
                } else {
                    nombreTV.setTextSize(30);
                    ambientes1TV.setTextSize(30);
                    propiedadesTV.setTextSize(30);
                    tipo1TV.setTextSize(24);
                    tipo2TV.setTextSize(24);
                    clase1TV.setTextSize(24);
                    clase2TV.setTextSize(24);
                    grupo1TV.setTextSize(24);
                    grupo2TV.setTextSize(24);
                    formula1TV.setTextSize(24);
                    formula2TV.setTextSize(24);
                    sistema1TV.setTextSize(24);
                    sistema2TV.setTextSize(24);
                    ambientes2TV.setTextSize(24);
                    habito1TV.setTextSize(24);
                    habito2TV.setTextSize(24);
                    color1TV.setTextSize(24);
                    color2TV.setTextSize(24);
                    diafanidad1TV.setTextSize(24);
                    diafanidad2TV.setTextSize(24);
                    brillo1TV.setTextSize(24);
                    brillo2TV.setTextSize(24);
                    raya1TV.setTextSize(24);
                    raya2TV.setTextSize(24);
                    dureza1TV.setTextSize(24);
                    dureza2TV.setTextSize(24);
                    densidad1TV.setTextSize(24);
                    densidad2TV.setTextSize(24);
                    exfoliacion1TV.setTextSize(24);
                    exfoliacion2TV.setTextSize(24);
                    otras1TV.setTextSize(24);
                    otras2TV.setTextSize(24);
                }
                break;
            case "small":
                if (isTablet.equals("Phone")) {
                    nombreTV.setTextSize(18);
                    ambientes1TV.setTextSize(18);
                    propiedadesTV.setTextSize(18);
                    tipo1TV.setTextSize(12);
                    tipo2TV.setTextSize(12);
                    clase1TV.setTextSize(12);
                    clase2TV.setTextSize(12);
                    grupo1TV.setTextSize(12);
                    grupo2TV.setTextSize(12);
                    formula1TV.setTextSize(12);
                    formula2TV.setTextSize(12);
                    sistema1TV.setTextSize(12);
                    sistema2TV.setTextSize(12);
                    ambientes2TV.setTextSize(12);
                    habito1TV.setTextSize(12);
                    habito2TV.setTextSize(12);
                    color1TV.setTextSize(12);
                    color2TV.setTextSize(12);
                    diafanidad1TV.setTextSize(12);
                    diafanidad2TV.setTextSize(12);
                    brillo1TV.setTextSize(12);
                    brillo2TV.setTextSize(12);
                    raya1TV.setTextSize(12);
                    raya2TV.setTextSize(12);
                    dureza1TV.setTextSize(12);
                    dureza2TV.setTextSize(12);
                    densidad1TV.setTextSize(12);
                    densidad2TV.setTextSize(12);
                    exfoliacion1TV.setTextSize(12);
                    exfoliacion2TV.setTextSize(12);
                    otras1TV.setTextSize(12);
                    otras2TV.setTextSize(12);
                } else if (isTablet.equals("Tablet7")) {
                    nombreTV.setTextSize(24);
                    ambientes1TV.setTextSize(24);
                    propiedadesTV.setTextSize(24);
                    tipo1TV.setTextSize(18);
                    tipo2TV.setTextSize(18);
                    clase1TV.setTextSize(18);
                    clase2TV.setTextSize(18);
                    grupo1TV.setTextSize(18);
                    grupo2TV.setTextSize(18);
                    formula1TV.setTextSize(18);
                    formula2TV.setTextSize(18);
                    sistema1TV.setTextSize(18);
                    sistema2TV.setTextSize(18);
                    ambientes2TV.setTextSize(18);
                    habito1TV.setTextSize(18);
                    habito2TV.setTextSize(18);
                    color1TV.setTextSize(18);
                    color2TV.setTextSize(18);
                    diafanidad1TV.setTextSize(18);
                    diafanidad2TV.setTextSize(18);
                    brillo1TV.setTextSize(18);
                    brillo2TV.setTextSize(18);
                    raya1TV.setTextSize(18);
                    raya2TV.setTextSize(18);
                    dureza1TV.setTextSize(18);
                    dureza2TV.setTextSize(18);
                    densidad1TV.setTextSize(18);
                    densidad2TV.setTextSize(18);
                    exfoliacion1TV.setTextSize(18);
                    exfoliacion2TV.setTextSize(18);
                    otras1TV.setTextSize(18);
                    otras2TV.setTextSize(18);
                } else {
                    nombreTV.setTextSize(28);
                    ambientes1TV.setTextSize(28);
                    propiedadesTV.setTextSize(28);
                    tipo1TV.setTextSize(22);
                    tipo2TV.setTextSize(22);
                    clase1TV.setTextSize(22);
                    clase2TV.setTextSize(22);
                    grupo1TV.setTextSize(22);
                    grupo2TV.setTextSize(22);
                    formula1TV.setTextSize(22);
                    formula2TV.setTextSize(22);
                    sistema1TV.setTextSize(22);
                    sistema2TV.setTextSize(22);
                    ambientes2TV.setTextSize(22);
                    habito1TV.setTextSize(22);
                    habito2TV.setTextSize(22);
                    color1TV.setTextSize(22);
                    color2TV.setTextSize(22);
                    diafanidad1TV.setTextSize(22);
                    diafanidad2TV.setTextSize(22);
                    brillo1TV.setTextSize(22);
                    brillo2TV.setTextSize(22);
                    raya1TV.setTextSize(22);
                    raya2TV.setTextSize(22);
                    dureza1TV.setTextSize(22);
                    dureza2TV.setTextSize(22);
                    densidad1TV.setTextSize(22);
                    densidad2TV.setTextSize(22);
                    exfoliacion1TV.setTextSize(22);
                    exfoliacion2TV.setTextSize(22);
                    otras1TV.setTextSize(22);
                    otras2TV.setTextSize(22);
                }
                break;
            default:
                if (isTablet.equals("Phone")) {
                    nombreTV.setTextSize(16);
                    ambientes1TV.setTextSize(16);
                    propiedadesTV.setTextSize(16);
                    tipo1TV.setTextSize(10);
                    tipo2TV.setTextSize(10);
                    clase1TV.setTextSize(10);
                    clase2TV.setTextSize(10);
                    grupo1TV.setTextSize(10);
                    grupo2TV.setTextSize(10);
                    formula1TV.setTextSize(10);
                    formula2TV.setTextSize(10);
                    sistema1TV.setTextSize(10);
                    sistema2TV.setTextSize(10);
                    ambientes2TV.setTextSize(10);
                    habito1TV.setTextSize(10);
                    habito2TV.setTextSize(10);
                    color1TV.setTextSize(10);
                    color2TV.setTextSize(10);
                    diafanidad1TV.setTextSize(10);
                    diafanidad2TV.setTextSize(10);
                    brillo1TV.setTextSize(10);
                    brillo2TV.setTextSize(10);
                    raya1TV.setTextSize(10);
                    raya2TV.setTextSize(10);
                    dureza1TV.setTextSize(10);
                    dureza2TV.setTextSize(10);
                    densidad1TV.setTextSize(10);
                    densidad2TV.setTextSize(10);
                    exfoliacion1TV.setTextSize(10);
                    exfoliacion2TV.setTextSize(10);
                    otras1TV.setTextSize(10);
                    otras2TV.setTextSize(10);
                } else if (isTablet.equals("Tablet7")) {
                    nombreTV.setTextSize(22);
                    ambientes1TV.setTextSize(22);
                    propiedadesTV.setTextSize(22);
                    tipo1TV.setTextSize(16);
                    tipo2TV.setTextSize(16);
                    clase1TV.setTextSize(16);
                    clase2TV.setTextSize(16);
                    grupo1TV.setTextSize(16);
                    grupo2TV.setTextSize(16);
                    formula1TV.setTextSize(16);
                    formula2TV.setTextSize(16);
                    sistema1TV.setTextSize(16);
                    sistema2TV.setTextSize(16);
                    ambientes2TV.setTextSize(16);
                    habito1TV.setTextSize(16);
                    habito2TV.setTextSize(16);
                    color1TV.setTextSize(16);
                    color2TV.setTextSize(16);
                    diafanidad1TV.setTextSize(16);
                    diafanidad2TV.setTextSize(16);
                    brillo1TV.setTextSize(16);
                    brillo2TV.setTextSize(16);
                    raya1TV.setTextSize(16);
                    raya2TV.setTextSize(16);
                    dureza1TV.setTextSize(16);
                    dureza2TV.setTextSize(16);
                    densidad1TV.setTextSize(16);
                    densidad2TV.setTextSize(16);
                    exfoliacion1TV.setTextSize(16);
                    exfoliacion2TV.setTextSize(16);
                    otras1TV.setTextSize(16);
                    otras2TV.setTextSize(16);
                } else {
                    nombreTV.setTextSize(26);
                    ambientes1TV.setTextSize(26);
                    propiedadesTV.setTextSize(26);
                    tipo1TV.setTextSize(20);
                    tipo2TV.setTextSize(20);
                    clase1TV.setTextSize(20);
                    clase2TV.setTextSize(20);
                    grupo1TV.setTextSize(20);
                    grupo2TV.setTextSize(20);
                    formula1TV.setTextSize(20);
                    formula2TV.setTextSize(20);
                    sistema1TV.setTextSize(20);
                    sistema2TV.setTextSize(20);
                    ambientes2TV.setTextSize(20);
                    habito1TV.setTextSize(20);
                    habito2TV.setTextSize(20);
                    color1TV.setTextSize(20);
                    color2TV.setTextSize(20);
                    diafanidad1TV.setTextSize(20);
                    diafanidad2TV.setTextSize(20);
                    brillo1TV.setTextSize(20);
                    brillo2TV.setTextSize(20);
                    raya1TV.setTextSize(20);
                    raya2TV.setTextSize(20);
                    dureza1TV.setTextSize(20);
                    dureza2TV.setTextSize(20);
                    densidad1TV.setTextSize(20);
                    densidad2TV.setTextSize(20);
                    exfoliacion1TV.setTextSize(20);
                    exfoliacion2TV.setTextSize(20);
                    otras1TV.setTextSize(20);
                    otras2TV.setTextSize(20);
                }
                break;
        }
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        rellenaFicha(id);

    }
    public void rellenaFicha(String id) {
        screen.smoothScrollTo(0,0);
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralAll(id);
        while (cursor.moveToNext()) {
            String nombre = cursor.getString(1);
            String imagen = cursor.getString(2);
            String tipo = cursor.getString(3);
            String clase = cursor.getString(4);
            String grupo = cursor.getString(5);
            String formula = cursor.getString(6);
            String sistema = cursor.getString(7);
            String ambiente1Mine = cursor.getString(8);
            String ambiente2Mine = cursor.getString(9);
            String ambiente3Mine = cursor.getString(10);
            String ambiente4Mine = cursor.getString(11);
            String ambiente5Mine = cursor.getString(12);
            String ambiente6Mine = cursor.getString(13);
            String ambiente7Mine = cursor.getString(14);
            String ambiente8Mine = cursor.getString(15);
            String habito = cursor.getString(16);
            if (habito.equals("-")) {
                habito = "---";
            }
            String color = cursor.getString(18);
            if (color.equals("-")) {
                color = "---";
            }
            String diafanidad = cursor.getString(20);
            if (diafanidad.equals("-")) {
                diafanidad = "---";
            }
            String brillo = cursor.getString(22);
            if (brillo.equals("-")) {
                brillo = "---";
            }
            String raya = cursor.getString(24);
            if (raya.equals("-")) {
                raya = "---";
            }
            String dureza = cursor.getString(26);
            if (dureza.equals("-")) {
                dureza = "---";
            }
            String densidad = cursor.getString(28);
            if (densidad.equals("-")) {
                densidad = "---";
            }
            String exfoliacion = cursor.getString(30);
            if (exfoliacion.equals("-")) {
                exfoliacion = "---";
            }
            String otras = cursor.getString(32);
            if (otras.equals("-")) {
                otras = "---";
            }
            int id2 = 0;
            if (imagen.equals("-")) {
                id2 = getResources().getIdentifier("com.geology_quiz_and_guide.mineralogy:drawable/no", null, null);
            } else {
                id2 = getResources().getIdentifier("com.geology_quiz_and_guide.mineralogy:drawable/" + imagen, null, null);
            }

            try {
                imagenTV.setImageResource(id2);
            } catch (Exception exc) {
            }

            nombreTV.append(nombre.toUpperCase());
            tipo2TV.append(tipo + ".");
            grupo2TV.append(grupo + ".");
            clase2TV.append(clase + ".");
            formula2TV.append(Html.fromHtml(formula));
            if (language.equals("ar")) {
                formula2TV.setGravity(Gravity.RIGHT);
            }
            sistema2TV.append(sistema + ".");
            ambientes2TV.append(Html.fromHtml("<b>" + ambiente1Mine.toUpperCase() + ": </b>" + ambiente2Mine  + "." + "\n"));
            ambientes2TV.append("\n");
            if (!habito.equals("---")) {
                habito2TV.append(habito.substring(0, 1).toUpperCase() + habito.substring(1) + ".");
            } else {
                habito2TV.append(habito);
            }
            if (!color.equals("---")) {
                color2TV.append(color + ".");
            } else {
                color2TV.append(color);
            }
            if (!diafanidad.equals("---")) {
                diafanidad2TV.append(diafanidad + ".");
            } else {
                diafanidad2TV.append(diafanidad);
            }
            if (!brillo.equals("---")) {
                brillo2TV.append(brillo + ".");
            } else {
                brillo2TV.append(brillo);
            }
            if (!raya.equals("---")) {
                raya2TV.append(raya + ".");
            } else {
                raya2TV.append(raya);
            }
            dureza2TV.append(dureza + ".");
            if (language.equals("ar")) {
                dureza2TV.setGravity(Gravity.RIGHT);
            }
            String densidadHTML = densidad + " " + "g/cm<sup><small>3</small></sup>";
            densidad2TV.append(Html.fromHtml(densidadHTML));
            if (language.equals("ar")) {
                densidad2TV.setGravity(Gravity.RIGHT);
            }
            if (!exfoliacion.equals("---")) {
                exfoliacion2TV.append(exfoliacion + ".");
            } else {
                exfoliacion2TV.append(exfoliacion);
            }
            if (!otras.equals("---")) {
                otras2TV.append(otras + ".");
            } else {
                otras2TV.append(otras);
            }
            if (!ambiente3Mine.equals("-")) {
                ambientes2TV.append(Html.fromHtml("<br><b>" + ambiente3Mine.toUpperCase() + ": </b>" + ambiente4Mine  + "." + "\n"));
                if (!ambiente5Mine.equals("-")) {
                    ambientes2TV.append("\n");
                }
            }
            if (!ambiente5Mine.equals("-")) {
                ambientes2TV.append(Html.fromHtml("<br><b>" + ambiente5Mine.toUpperCase() + ": </b>" + ambiente6Mine  + "." + "\n"));
                if (!ambiente7Mine.equals("-")) {
                    ambientes2TV.append("\n");
                }
            }
            if (!ambiente7Mine.equals("-")) {
                ambientes2TV.append(Html.fromHtml("<br><b>" + ambiente7Mine.toUpperCase() + ": </b>" + ambiente8Mine  + "." + "\n"));
            }
            switch (clase) {
                case "Elementos nativos":
                case "Native elements":
                case "Éléments natifs":
                case "Elements nadius":
                case "Самородки":
                case "العناصر الأصلية":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_natives));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_natives));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_natives));
                    break;
                case "Sulfuros y sulfosales":
                case "Sulfides and sulfosalts":
                case "Sulfures et sulfosels":
                case "Sulfurs i sulfosals":
                case "Сульфиды и сульфосоли":
                case "الكبريتيدات والسلفوسالت":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_sulfures));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_sulfures));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_sulfures));
                    break;
                case "Óxidos e hidróxidos":
                case "Oxides and hydroxides":
                case "Oxydes et hydroxydes":
                case "Òxids i hidròxids":
                case "Оксиды и гидроксиды":
                case "الأكاسيد والهيدروكسيدات":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_oxides));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_oxides));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_oxides));
                    break;
                case "Haluros":
                case "Halides":
                case "Halogénures":
                case "Halurs":
                case "Галогениды":
                case "الهاليدات":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_halides));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_halides));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_halides));
                    break;
                case "Carbonatos, nitratos y boratos":
                case "Carbonates, nitrates and borates":
                case "Carbonates, nitrates et borates":
                case "Carbonats, nitrats i borats":
                case "Карбонаты, нитраты и бораты":
                case "الكربونات والنترات والبورات":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_carbonates));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_carbonates));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_carbonates));
                    break;
                case "Sulfatos, cromatos y seleniatos":
                case "Sulfates, chromates and selenates":
                case "Sulfates, chromates et séléniates":
                case "Sulfats, cromats i seleniats":
                case "Сульфаты, хроматы и селенаты":
                case "الكبريتات والكرومات والسيلينات":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_sulfates));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_sulfates));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_sulfates));
                    break;
                case "Fosfatos, arseniatos y vanadatos":
                case "Phosphates, arsenates and vanadates":
                case "Phosphates, arséniates et vanadates":
                case "Fosfats, arseniats i vanadats":
                case "Фосфаты, арсенаты и ванадаты":
                case "الفوسفات والزرنيخات والفانادات":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_fosfates));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_fosfates));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_fosfates));
                    break;
                case "Nesosilicatos":
                case "Nesosilicates":
                case "Nésosilicates":
                case "Nesosilicats":
                case "Ортосиликаты":
                case "نيسوسيليكات":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_nesosilicates));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_nesosilicates));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_nesosilicates));
                    break;
                case "Sorosilicatos":
                case "Sorosilicates":
                case "Sorosilicats":
                case "Соросиликаты":
                case "سوروسيليكات":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_sorosilicates));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_sorosilicates));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_sorosilicates));
                    break;
                case "Ciclosilicatos":
                case "Cyclosilicates":
                case "Ciclosilicats":
                case "Кольцевые силикаты":
                case "السيكلوسيليكات":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_ciclosilicates));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_ciclosilicates));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_ciclosilicates));
                    break;
                case "Inosilicatos":
                case "Inosilicates":
                case "Inosilicats":
                case "Ленточные силикаты":
                case "اينوسيليكات":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_inosilicates));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_inosilicates));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_inosilicates));
                    break;
                case "Filosilicatos":
                case "Phyllosilicates":
                case "Fil·losilicats":
                case "Филлосиликаты":
                case "فيلوسيليكات":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_filosilicates));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_filosilicates));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_filosilicates));
                    break;
                case "Tectosilicatos":
                case "Tectosilicates":
                case "Tectosilicats":
                case "Каркасные силикаты":
                case "التكتوسيليكات":
                    nombreTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_tectosilicates));
                    ambientes1TV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_tectosilicates));
                    propiedadesTV.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_tectosilicates));
                    break;
            }
        }
        cursor.close();
        myDb.closeDatabase();
    }
    public void restaCoins() {
        int newCoins = sharedPreferences.getInt("coins",301) - 1;
        myEdit.putInt("coins",newCoins);
        myEdit.apply();
        toolbarTextView.setText(String.valueOf(newCoins));
    }
    public void add300Coins() {
        myEdit.putInt("coins",300);
        myEdit.apply();
        toolbarTextView.setText(String.valueOf(300));
    }
    public String isTablet(Context context) {
        boolean xlarge = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE);
        boolean large = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE);
        if (xlarge) {
            return "Tablet10";
        } else if (large) {
            return "Tablet7";
        }
        return "Phone";
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_back) {
            finish();
            return true;
        }
        if (item.getItemId() == R.id.item_share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Mineralogy: Quiz and Guide. Download free https://play.google.com/store/apps/details?id=com.geologyapplications.minerals");
            startActivity(Intent.createChooser(sharingIntent,"Share using"));
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_coins, menu);
        return true;
    }
}