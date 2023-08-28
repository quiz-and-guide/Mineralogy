package com.geology_quiz_and_guide.mineralogy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class QuizGame extends AppCompatActivity {
    private Button pri, seg, ter, cua;
    private List<Boolean> clasePreguntas;
    private boolean tipo, clase, formula, sistema, ambientes, habito, color, diafanidad, brillo, raya, dureza,
            densidad, exfoliacion, silicatos, nosilicatos;
    private List<Integer> myList;
    private int numGrupos, numCorrectas, randomClase;
    private String claseCorrecta, claseIncorrecta, nombreCorrecto, nombreIncorrecto, tipoCorrecto, tipoIncorrecto, formulaCorrecta,
            sistemaCorrecto, sistemaIncorrecto, ambienteCorrecto, habitoCorrecto, habitoIncorrecto, colorCorrecto,
            colorIncorrecto, diafanidadCorrecta, diafanidadIncorrecta, brilloCorrecto, brilloIncorrecto, rayaCorrecta, rayaIncorrecta,
            durezaCorrecta, durezaMediaCorrecta, durezaIncorrecta, durezaMediaIncorrecta, densidadCorrecta, densidadMediaCorrecta,
            densidadIncorrecta, densidadMediaIncorrecta, exfoliacionCorrecta, exfoliacionIncorrecta, envCorrecto,
            isTablet, theme, typeQuestion, currentTime;
    private ArrayList<String> minerales, envs;
    private TextView txtQuestion, txt11, txt12, txt21, txt22, txt31, txt32, txt41, txt42, toolbarTextView;
    private List<MineralesAdapter.Minerales> mines;
    private LinearLayout linearMines;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor myEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);
        setSupportActionBar(findViewById(R.id.toolbar));

        sharedPreferences = this.getSharedPreferences("UserPreferences", MODE_PRIVATE);
        myEdit = sharedPreferences.edit();
        isTablet = isTablet(this);
        theme = sharedPreferences.getString("theme", "light");
        String sizeText = sharedPreferences.getString("sizeText", "medium");
        String language = sharedPreferences.getString("language", Locale.getDefault().getLanguage());
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        //toolbarTextView = findViewById(R.id.toolbarTextView);
        int coins = sharedPreferences.getInt("coins",301);
        //toolbarTextView.setText(String.valueOf(coins));
        numCorrectas = 0;
        minerales = new ArrayList<>();
        Intent intent = getIntent();

        Button btnSiguiente = findViewById(R.id.btnSiguiente);
        Button btnFinalizar = findViewById(R.id.btnFinalizar);
        txtQuestion = findViewById(R.id.txtQuestion);

        linearMines = findViewById(R.id.linearMinesTotal);
        LinearLayout linearQuestion = findViewById(R.id.linearQuestion);


        linearMines.setVisibility(View.INVISIBLE);
        pri = findViewById(R.id.responderUno);
        seg = findViewById(R.id.responderDos);
        ter = findViewById(R.id.responderTres);
        cua = findViewById(R.id.responderCuatro);
        pri.setTextColor(getResources().getColor(R.color.black));
        seg.setTextColor(getResources().getColor(R.color.black));
        ter.setTextColor(getResources().getColor(R.color.black));
        cua.setTextColor(getResources().getColor(R.color.black));

        txt11 = findViewById(R.id.tv11);
        txt12 = findViewById(R.id.tv12);
        txt21 = findViewById(R.id.tv21);
        txt22 = findViewById(R.id.tv22);
        txt31 = findViewById(R.id.tv31);
        txt32 = findViewById(R.id.tv32);
        txt41 = findViewById(R.id.tv41);
        txt42 = findViewById(R.id.tv42);
        int factor = (int) txt11.getContext().getResources().getDisplayMetrics().density;
        switch (isTablet) {
            case "Phone":
                //toolbarTextView.setTextSize(18);
                break;
            case "Tablet7": {
                //toolbarTextView.setTextSize(22);
                ViewGroup.LayoutParams lpQuestion = txtQuestion.getLayoutParams();
                lpQuestion.width = ViewGroup.LayoutParams.MATCH_PARENT;
                lpQuestion.height = 220 * factor;
                txtQuestion.setLayoutParams(lpQuestion);
                ViewGroup.LayoutParams lpListView = txt11.getLayoutParams();
                lpListView.height = 80 * factor;
                txt11.setLayoutParams(lpListView);
                txt12.setLayoutParams(lpListView);
                txt21.setLayoutParams(lpListView);
                txt22.setLayoutParams(lpListView);
                txt31.setLayoutParams(lpListView);
                txt32.setLayoutParams(lpListView);
                txt41.setLayoutParams(lpListView);
                txt42.setLayoutParams(lpListView);
                ViewGroup.LayoutParams lpButton = btnSiguiente.getLayoutParams();
                lpButton.height = 80 * factor;
                btnSiguiente.setLayoutParams(lpButton);
                btnFinalizar.setLayoutParams(lpButton);
                ViewGroup.LayoutParams lpOptions = pri.getLayoutParams();
                lpOptions.height = 150 * factor;
                pri.setLayoutParams(lpOptions);
                seg.setLayoutParams(lpOptions);
                ter.setLayoutParams(lpOptions);
                cua.setLayoutParams(lpOptions);
                break;
            }
            case "Tablet10": {
                //toolbarTextView.setTextSize(26);
                ViewGroup.LayoutParams lpQuestion = txtQuestion.getLayoutParams();
                lpQuestion.width = ViewGroup.LayoutParams.MATCH_PARENT;
                lpQuestion.height = 350 * factor;
                txtQuestion.setLayoutParams(lpQuestion);
                ViewGroup.LayoutParams lpListView = txt11.getLayoutParams();
                lpListView.height = 100 * factor;
                txt11.setLayoutParams(lpListView);
                txt12.setLayoutParams(lpListView);
                txt21.setLayoutParams(lpListView);
                txt22.setLayoutParams(lpListView);
                txt31.setLayoutParams(lpListView);
                txt32.setLayoutParams(lpListView);
                txt41.setLayoutParams(lpListView);
                txt42.setLayoutParams(lpListView);
                ViewGroup.LayoutParams lpButton = btnSiguiente.getLayoutParams();
                lpButton.height = 100 * factor;
                btnSiguiente.setLayoutParams(lpButton);
                btnFinalizar.setLayoutParams(lpButton);
                ViewGroup.LayoutParams lpOptions = pri.getLayoutParams();
                lpOptions.height = 200 * factor;
                pri.setLayoutParams(lpOptions);
                seg.setLayoutParams(lpOptions);
                ter.setLayoutParams(lpOptions);
                cua.setLayoutParams(lpOptions);

                break;
            }
        }

        ScrollView screen = findViewById(R.id.screen);
        switch (theme) {
            case "light":
                screen.setBackgroundColor(getResources().getColor(R.color.light));
                linearQuestion.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_light));
                txtQuestion.setTextColor(getResources().getColor(R.color.black));
                btnSiguiente.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_light));
                btnFinalizar.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_light));
                btnSiguiente.setTextColor(getResources().getColor(R.color.black));
                btnFinalizar.setTextColor(getResources().getColor(R.color.black));
                break;
            case "darck":
                screen.setBackgroundColor(getResources().getColor(R.color.darck));
                linearQuestion.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_darck));
                txtQuestion.setTextColor(getResources().getColor(R.color.white));
                btnSiguiente.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_darck));
                btnFinalizar.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_darck));
                btnSiguiente.setTextColor(getResources().getColor(R.color.white));
                btnFinalizar.setTextColor(getResources().getColor(R.color.white));
                break;
            case "green":
                screen.setBackgroundColor(getResources().getColor(R.color.green));
                linearQuestion.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_green));
                txtQuestion.setTextColor(getResources().getColor(R.color.white));
                btnSiguiente.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_green));
                btnFinalizar.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_green));
                btnSiguiente.setTextColor(getResources().getColor(R.color.white));
                btnFinalizar.setTextColor(getResources().getColor(R.color.white));
                break;
            default:
                screen.setBackgroundColor(getResources().getColor(R.color.blue));
                linearQuestion.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_blue));
                txtQuestion.setTextColor(getResources().getColor(R.color.white));
                btnSiguiente.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_blue));
                btnFinalizar.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.redondeo_blue));
                btnSiguiente.setTextColor(getResources().getColor(R.color.white));
                btnFinalizar.setTextColor(getResources().getColor(R.color.white));
                break;
        }
        switch (sizeText) {
            case "very big":
                if (isTablet.equals("Phone")) {
                    txtQuestion.setTextSize(22);
                    pri.setTextSize(18);
                    seg.setTextSize(18);
                    ter.setTextSize(18);
                    cua.setTextSize(18);
                    btnSiguiente.setTextSize(22);
                    btnFinalizar.setTextSize(22);
                    txt11.setTextSize(16);
                    txt12.setTextSize(16);
                    txt21.setTextSize(16);
                    txt22.setTextSize(16);
                    txt31.setTextSize(16);
                    txt32.setTextSize(16);
                    txt41.setTextSize(16);
                    txt42.setTextSize(16);
                } else if (isTablet.equals("Tablet7")) {
                    txtQuestion.setTextSize(28);
                    pri.setTextSize(24);
                    seg.setTextSize(24);
                    ter.setTextSize(24);
                    cua.setTextSize(24);
                    btnSiguiente.setTextSize(28);
                    btnFinalizar.setTextSize(28);
                    txt11.setTextSize(20);
                    txt12.setTextSize(20);
                    txt21.setTextSize(20);
                    txt22.setTextSize(20);
                    txt31.setTextSize(20);
                    txt32.setTextSize(20);
                    txt41.setTextSize(20);
                    txt42.setTextSize(20);
                } else {
                    txtQuestion.setTextSize(32);
                    pri.setTextSize(28);
                    seg.setTextSize(28);
                    ter.setTextSize(28);
                    cua.setTextSize(28);
                    btnSiguiente.setTextSize(32);
                    btnFinalizar.setTextSize(32);
                    txt11.setTextSize(24);
                    txt12.setTextSize(24);
                    txt21.setTextSize(24);
                    txt22.setTextSize(24);
                    txt31.setTextSize(24);
                    txt32.setTextSize(24);
                    txt41.setTextSize(24);
                    txt42.setTextSize(24);
                }
                break;
            case "big":
                if (isTablet.equals("Phone")) {
                    txtQuestion.setTextSize(20);
                    pri.setTextSize(16);
                    seg.setTextSize(16);
                    ter.setTextSize(16);
                    cua.setTextSize(16);
                    btnSiguiente.setTextSize(20);
                    btnFinalizar.setTextSize(20);
                    txt11.setTextSize(16);
                    txt12.setTextSize(16);
                    txt21.setTextSize(16);
                    txt22.setTextSize(16);
                    txt31.setTextSize(16);
                    txt32.setTextSize(16);
                    txt41.setTextSize(16);
                    txt42.setTextSize(16);
                } else if (isTablet.equals("Tablet7")) {
                    txtQuestion.setTextSize(26);
                    pri.setTextSize(22);
                    seg.setTextSize(22);
                    ter.setTextSize(22);
                    cua.setTextSize(22);
                    btnSiguiente.setTextSize(26);
                    btnFinalizar.setTextSize(26);
                    txt11.setTextSize(20);
                    txt12.setTextSize(20);
                    txt21.setTextSize(20);
                    txt22.setTextSize(20);
                    txt31.setTextSize(20);
                    txt32.setTextSize(20);
                    txt41.setTextSize(20);
                    txt42.setTextSize(20);
                } else {
                    txtQuestion.setTextSize(30);
                    pri.setTextSize(26);
                    seg.setTextSize(26);
                    ter.setTextSize(26);
                    cua.setTextSize(26);
                    btnSiguiente.setTextSize(30);
                    btnFinalizar.setTextSize(30);
                    txt11.setTextSize(24);
                    txt12.setTextSize(24);
                    txt21.setTextSize(24);
                    txt22.setTextSize(24);
                    txt31.setTextSize(24);
                    txt32.setTextSize(24);
                    txt41.setTextSize(24);
                    txt42.setTextSize(24);
                }
                break;
            case "medium":
                if (isTablet.equals("Phone")) {
                    txtQuestion.setTextSize(18);
                    pri.setTextSize(14);
                    seg.setTextSize(14);
                    ter.setTextSize(14);
                    cua.setTextSize(14);
                    btnSiguiente.setTextSize(18);
                    btnFinalizar.setTextSize(18);
                    txt11.setTextSize(16);
                    txt12.setTextSize(16);
                    txt21.setTextSize(16);
                    txt22.setTextSize(16);
                    txt31.setTextSize(16);
                    txt32.setTextSize(16);
                    txt41.setTextSize(16);
                    txt42.setTextSize(16);
                } else if (isTablet.equals("Tablet7")) {
                    txtQuestion.setTextSize(24);
                    pri.setTextSize(20);
                    seg.setTextSize(20);
                    ter.setTextSize(20);
                    cua.setTextSize(20);
                    btnSiguiente.setTextSize(24);
                    btnFinalizar.setTextSize(24);
                    txt11.setTextSize(20);
                    txt12.setTextSize(20);
                    txt21.setTextSize(20);
                    txt22.setTextSize(20);
                    txt31.setTextSize(20);
                    txt32.setTextSize(20);
                    txt41.setTextSize(20);
                    txt42.setTextSize(20);
                } else {
                    txtQuestion.setTextSize(28);
                    pri.setTextSize(24);
                    seg.setTextSize(24);
                    ter.setTextSize(24);
                    cua.setTextSize(24);
                    btnSiguiente.setTextSize(28);
                    btnFinalizar.setTextSize(28);
                    txt11.setTextSize(24);
                    txt12.setTextSize(24);
                    txt21.setTextSize(24);
                    txt22.setTextSize(24);
                    txt31.setTextSize(24);
                    txt32.setTextSize(24);
                    txt41.setTextSize(24);
                    txt42.setTextSize(24);
                }
                break;
            case "small":
                if (isTablet.equals("Phone")) {
                    txtQuestion.setTextSize(16);
                    pri.setTextSize(12);
                    seg.setTextSize(12);
                    ter.setTextSize(12);
                    cua.setTextSize(12);
                    btnSiguiente.setTextSize(16);
                    btnFinalizar.setTextSize(16);
                    txt11.setTextSize(16);
                    txt12.setTextSize(16);
                    txt21.setTextSize(16);
                    txt22.setTextSize(16);
                    txt31.setTextSize(16);
                    txt32.setTextSize(16);
                    txt41.setTextSize(16);
                    txt42.setTextSize(16);
                } else if (isTablet.equals("Tablet7")) {
                    txtQuestion.setTextSize(22);
                    pri.setTextSize(18);
                    seg.setTextSize(18);
                    ter.setTextSize(18);
                    cua.setTextSize(18);
                    btnSiguiente.setTextSize(22);
                    btnFinalizar.setTextSize(22);
                    txt11.setTextSize(20);
                    txt12.setTextSize(20);
                    txt21.setTextSize(20);
                    txt22.setTextSize(20);
                    txt31.setTextSize(20);
                    txt32.setTextSize(20);
                    txt41.setTextSize(20);
                    txt42.setTextSize(20);
                } else {
                    txtQuestion.setTextSize(26);
                    pri.setTextSize(22);
                    seg.setTextSize(22);
                    ter.setTextSize(22);
                    cua.setTextSize(22);
                    txt11.setTextSize(24);
                    txt12.setTextSize(24);
                    txt21.setTextSize(24);
                    txt22.setTextSize(24);
                    txt31.setTextSize(24);
                    txt32.setTextSize(24);
                    txt41.setTextSize(24);
                    txt42.setTextSize(24);
                    btnSiguiente.setTextSize(26);
                    btnFinalizar.setTextSize(26);
                }
                break;
            default:
                if (isTablet.equals("Phone")) {
                    txtQuestion.setTextSize(14);
                    pri.setTextSize(10);
                    seg.setTextSize(10);
                    ter.setTextSize(10);
                    cua.setTextSize(10);
                    btnSiguiente.setTextSize(14);
                    btnFinalizar.setTextSize(14);
                    txt11.setTextSize(16);
                    txt12.setTextSize(16);
                    txt21.setTextSize(16);
                    txt22.setTextSize(16);
                    txt31.setTextSize(16);
                    txt32.setTextSize(16);
                    txt41.setTextSize(16);
                    txt42.setTextSize(16);
                } else if (isTablet.equals("Tablet7")) {
                    txtQuestion.setTextSize(20);
                    pri.setTextSize(16);
                    seg.setTextSize(16);
                    ter.setTextSize(16);
                    cua.setTextSize(16);
                    btnSiguiente.setTextSize(20);
                    btnFinalizar.setTextSize(20);
                    txt11.setTextSize(20);
                    txt12.setTextSize(20);
                    txt21.setTextSize(20);
                    txt22.setTextSize(20);
                    txt31.setTextSize(20);
                    txt32.setTextSize(20);
                    txt41.setTextSize(20);
                    txt42.setTextSize(20);
                } else {
                    txtQuestion.setTextSize(24);
                    pri.setTextSize(20);
                    seg.setTextSize(20);
                    ter.setTextSize(20);
                    cua.setTextSize(20);
                    txt11.setTextSize(24);
                    txt12.setTextSize(24);
                    txt21.setTextSize(24);
                    txt22.setTextSize(24);
                    txt31.setTextSize(24);
                    txt32.setTextSize(24);
                    txt41.setTextSize(24);
                    txt42.setTextSize(24);
                    btnSiguiente.setTextSize(24);
                    btnFinalizar.setTextSize(24);
                }
                break;
        }
        tipo = intent.getBooleanExtra("tipo", false);
        clase = intent.getBooleanExtra("clase", false);
        formula = intent.getBooleanExtra("formula", false);
        sistema = intent.getBooleanExtra("sistema", false);
        ambientes = intent.getBooleanExtra("ambientes", false);
        habito = intent.getBooleanExtra("habito", false);
        color = intent.getBooleanExtra("color", false);
        diafanidad = intent.getBooleanExtra("diafanidad", false);
        brillo = intent.getBooleanExtra("brillo", false);
        raya = intent.getBooleanExtra("raya", false);
        dureza = intent.getBooleanExtra("dureza", false);
        densidad = intent.getBooleanExtra("densidad", false);
        exfoliacion = intent.getBooleanExtra("exfoliacion", false);
        silicatos = intent.getBooleanExtra("silicatos", false);
        nosilicatos = intent.getBooleanExtra("nosilicatos", false);
        myList = new ArrayList<>();
        clasePreguntas = new ArrayList<>();
        btnSiguiente.setVisibility(View.INVISIBLE);
        btnFinalizar.setVisibility(View.INVISIBLE);
        final boolean[] marcada = {false};
        pri.setOnClickListener(v -> {
            if (!marcada[0]) {
                marcada[0] = true;
                btnSiguiente.setVisibility(View.VISIBLE);
                btnFinalizar.setVisibility(View.VISIBLE);
                if (pri.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                    numCorrectas = numCorrectas + 1;
                    pri.setBackgroundResource(R.drawable.roundcorner_green_options);
                    pri.setTextColor(getResources().getColor(R.color.white));
                } else {
                    pri.setBackgroundResource(R.drawable.roundcorner_red_options);
                    pri.setTextColor(getResources().getColor(R.color.white));
                    if (seg.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        seg.setBackgroundResource(R.drawable.roundcorner_green_options);
                        seg.setTextColor(getResources().getColor(R.color.white));
                    } else if (ter.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        ter.setBackgroundResource(R.drawable.roundcorner_green_options);
                        ter.setTextColor(getResources().getColor(R.color.white));
                    } else if (cua.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        cua.setBackgroundResource(R.drawable.roundcorner_green_options);
                        cua.setTextColor(getResources().getColor(R.color.white));
                    }
                }
                marcar();
            }
        });
        seg.setOnClickListener(v -> {
            if (!marcada[0]) {
                marcada[0] = true;
                btnSiguiente.setVisibility(View.VISIBLE);
                btnFinalizar.setVisibility(View.VISIBLE);
                if (seg.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                    numCorrectas = numCorrectas + 1;
                    seg.setBackgroundResource(R.drawable.roundcorner_green_options);
                    seg.setTextColor(getResources().getColor(R.color.white));
                } else {
                    seg.setBackgroundResource(R.drawable.roundcorner_red_options);
                    seg.setTextColor(getResources().getColor(R.color.white));
                    if (pri.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        pri.setBackgroundResource(R.drawable.roundcorner_green_options);
                        pri.setTextColor(getResources().getColor(R.color.white));
                    } else if (ter.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        ter.setBackgroundResource(R.drawable.roundcorner_green_options);
                        ter.setTextColor(getResources().getColor(R.color.white));
                    } else if (cua.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        cua.setBackgroundResource(R.drawable.roundcorner_green_options);
                        cua.setTextColor(getResources().getColor(R.color.white));
                    }
                }
                marcar();
            }
        });
        ter.setOnClickListener(v -> {
            if (!marcada[0]) {
                marcada[0] = true;
                btnSiguiente.setVisibility(View.VISIBLE);
                btnFinalizar.setVisibility(View.VISIBLE);
                if (ter.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                    numCorrectas = numCorrectas + 1;
                    ter.setBackgroundResource(R.drawable.roundcorner_green_options);
                    ter.setTextColor(getResources().getColor(R.color.white));
                } else {
                    ter.setBackgroundResource(R.drawable.roundcorner_red_options);
                    ter.setTextColor(getResources().getColor(R.color.white));
                    if (pri.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        pri.setBackgroundResource(R.drawable.roundcorner_green_options);
                        pri.setTextColor(getResources().getColor(R.color.white));
                    } else if (seg.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        seg.setBackgroundResource(R.drawable.roundcorner_green_options);
                        seg.setTextColor(getResources().getColor(R.color.white));
                    } else if (cua.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        cua.setBackgroundResource(R.drawable.roundcorner_green_options);
                        cua.setTextColor(getResources().getColor(R.color.white));
                    }
                }
                marcar();
            }
        });
        cua.setOnClickListener(v -> {
            if (!marcada[0]) {
                marcada[0] = true;
                btnSiguiente.setVisibility(View.VISIBLE);
                btnFinalizar.setVisibility(View.VISIBLE);
                if (cua.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                    numCorrectas = numCorrectas + 1;
                    cua.setBackgroundResource(R.drawable.roundcorner_green_options);
                    cua.setTextColor(getResources().getColor(R.color.white));
                } else {
                    cua.setBackgroundResource(R.drawable.roundcorner_red_options);
                    cua.setTextColor(getResources().getColor(R.color.white));
                    if (pri.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        pri.setBackgroundResource(R.drawable.roundcorner_green_options);
                        pri.setTextColor(getResources().getColor(R.color.white));
                    } else if (seg.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        seg.setBackgroundResource(R.drawable.roundcorner_green_options);
                        seg.setTextColor(getResources().getColor(R.color.white));
                    } else if (ter.getText().toString().equalsIgnoreCase(nombreCorrecto)) {
                        ter.setBackgroundResource(R.drawable.roundcorner_green_options);
                        ter.setTextColor(getResources().getColor(R.color.white));
                    }
                }
                marcar();
            }
        });
        txt11.setOnClickListener(v -> {
            String id = mines.get(0).getId();
            abreFichaMineral(id);
        });
        txt12.setOnClickListener(v -> {
            String id = mines.get(0).getId();
            abreFichaMineral(id);
        });
        txt21.setOnClickListener(v -> {
            String id = mines.get(1).getId();
            abreFichaMineral(id);
        });
        txt22.setOnClickListener(v -> {
            String id = mines.get(1).getId();
            abreFichaMineral(id);
        });
        txt31.setOnClickListener(v -> {
            String id = mines.get(2).getId();
            abreFichaMineral(id);
        });
        txt32.setOnClickListener(v -> {
            String id = mines.get(2).getId();
            abreFichaMineral(id);
        });
        txt41.setOnClickListener(v -> {
            String id = mines.get(3).getId();
            abreFichaMineral(id);
        });
        txt42.setOnClickListener(v -> {
            try {
                String id = mines.get(3).getId();
                abreFichaMineral(id);
            } catch (Exception exc) {
                Log.i("ERROR",exc.getMessage());
            }
        });
        btnSiguiente.setOnClickListener(v -> {
            calculaPreguntaYLanza();
            marcada[0] = false;
            pri.setBackgroundResource(R.drawable.roundcorner);
            seg.setBackgroundResource(R.drawable.roundcorner);
            ter.setBackgroundResource(R.drawable.roundcorner);
            cua.setBackgroundResource(R.drawable.roundcorner);
            btnSiguiente.setVisibility(View.INVISIBLE);
            btnFinalizar.setVisibility(View.INVISIBLE);
            mines.clear();
            linearMines.setVisibility(View.INVISIBLE);
            pri.setTextColor(getResources().getColor(R.color.black));
            seg.setTextColor(getResources().getColor(R.color.black));
            ter.setTextColor(getResources().getColor(R.color.black));
            cua.setTextColor(getResources().getColor(R.color.black));
            screen.smoothScrollTo(0,0);
            //restaCoins();
        });
        btnFinalizar.setOnClickListener(v -> {
            finish();
            //showFinalAlert();
        });
        generaPrimeraPregunta();
        //restaCoins();
    }

    public void abreFichaMineral(String id) {
        Intent intent = new Intent(QuizGame.this, Ficha.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void marcar() {
        mines = new ArrayList<>();
        String mineral1 = pri.getText().toString().toLowerCase();
        String mineral2 = seg.getText().toString().toLowerCase();
        String mineral3 = ter.getText().toString().toLowerCase();
        String mineral4 = cua.getText().toString().toLowerCase();
        Database myDb = new Database(this);
        Cursor cursor1 = myDb.getMineralesSimplificados(myDb.getId(mineral1));
        Cursor cursor2 = myDb.getMineralesSimplificados(myDb.getId(mineral2));
        Cursor cursor3 = myDb.getMineralesSimplificados(myDb.getId(mineral3));
        Cursor cursor4 = myDb.getMineralesSimplificados(myDb.getId(mineral4));
        while (cursor1.moveToNext()) {
            String id = cursor1.getString(0);
            String nombre = cursor1.getString(1);
            String clase = cursor1.getString(2);
            MineralesAdapter.Minerales minerales = new MineralesAdapter.Minerales(
                    id,
                    nombre,
                    clase
            );
            mines.add(minerales);
        }
        cursor1.close();
        while (cursor2.moveToNext()) {
            String id = cursor2.getString(0);
            String nombre = cursor2.getString(1);
            String clase = cursor2.getString(2);
            MineralesAdapter.Minerales minerales = new MineralesAdapter.Minerales(
                    id,
                    nombre,
                    clase
            );
            mines.add(minerales);
        }
        cursor2.close();
        while (cursor3.moveToNext()) {
            String id = cursor3.getString(0);
            String nombre = cursor3.getString(1);
            String clase = cursor3.getString(2);
            MineralesAdapter.Minerales minerales = new MineralesAdapter.Minerales(
                    id,
                    nombre,
                    clase
            );
            mines.add(minerales);
        }
        cursor3.close();
        while (cursor4.moveToNext()) {
            String id = cursor4.getString(0);
            String nombre = cursor4.getString(1);
            String clase = cursor4.getString(2);
            MineralesAdapter.Minerales minerales = new MineralesAdapter.Minerales(
                    id,
                    nombre,
                    clase
            );
            mines.add(minerales);
        }
        cursor4.close();
        myDb.closeDatabase();
        linearMines.setVisibility(View.VISIBLE);
        txt11.setText(mines.get(0).getNombre().toUpperCase());
        txt12.setText(mines.get(0).getTipo().toUpperCase());
        txt21.setText(mines.get(1).getNombre().toUpperCase());
        txt22.setText(mines.get(1).getTipo().toUpperCase());
        txt31.setText(mines.get(2).getNombre().toUpperCase());
        txt32.setText(mines.get(2).getTipo().toUpperCase());
        try {
            txt41.setText(mines.get(3).getNombre().toUpperCase());
            txt42.setText(mines.get(3).getTipo().toUpperCase());
        } catch (Exception exc) {
            Log.i("ERROR",exc.getMessage());
        }
        if (txt12.getText().toString().equalsIgnoreCase("elementos nativos") || txt12.getText().toString().equalsIgnoreCase("native elements") || txt12.getText().toString().equalsIgnoreCase("éléments natifs") || txt12.getText().toString().equalsIgnoreCase("elements nadius") || txt12.getText().toString().equalsIgnoreCase("Самородки") || txt12.getText().toString().equalsIgnoreCase("العناصر الأصلية")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_natives));
        } else if (txt12.getText().toString().equalsIgnoreCase("sulfuros y sulfosales") || txt12.getText().toString().equalsIgnoreCase("sulfides and sulfosalts") || txt12.getText().toString().equalsIgnoreCase("sulfures et sulfosels") || txt12.getText().toString().equalsIgnoreCase("sulfurs i sulfosals") || txt12.getText().toString().equalsIgnoreCase("Сульфиды и сульфосоли") || txt12.getText().toString().equalsIgnoreCase("الكبريتيدات والسلفوسالت")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sulfures));
        } else if (txt12.getText().toString().equalsIgnoreCase("óxidos e hidróxidos") || txt12.getText().toString().equalsIgnoreCase("oxides and hydroxides") || txt12.getText().toString().equalsIgnoreCase("oxydes et hydroxydes") || txt12.getText().toString().equalsIgnoreCase("òxids i hidròxids") || txt12.getText().toString().equalsIgnoreCase("Оксиды и гидроксиды") || txt12.getText().toString().equalsIgnoreCase("الأكاسيد والهيدروكسيدات")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_oxides));
        } else if (txt12.getText().toString().equalsIgnoreCase("haluros") || txt12.getText().toString().equalsIgnoreCase("halides") || txt12.getText().toString().equalsIgnoreCase("halogénures") || txt12.getText().toString().equalsIgnoreCase("halurs") || txt12.getText().toString().equalsIgnoreCase("Галогениды") || txt12.getText().toString().equalsIgnoreCase("الهاليدات")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_halides));
        } else if (txt12.getText().toString().equalsIgnoreCase("carbonatos, nitratos y boratos") || txt12.getText().toString().equalsIgnoreCase("carbonates, nitrates and borates") || txt12.getText().toString().equalsIgnoreCase("carbonates, nitrates et borates") || txt12.getText().toString().equalsIgnoreCase("carbonats, nitrats i borats") || txt12.getText().toString().equalsIgnoreCase("Карбонаты, нитраты и бораты") || txt12.getText().toString().equalsIgnoreCase("الكربونات والنترات والبورات")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_carbonates));
        } else if (txt12.getText().toString().equalsIgnoreCase("sulfatos, cromatos y seleniatos") || txt12.getText().toString().equalsIgnoreCase("sulfates, chromates and selenates") || txt12.getText().toString().equalsIgnoreCase("sulfates, chromates et séléniates") || txt12.getText().toString().equalsIgnoreCase("sulfats, cromats i seleniats") || txt12.getText().toString().equalsIgnoreCase("Сульфаты, хроматы и селенаты") || txt12.getText().toString().equalsIgnoreCase("الكبريتات والكرومات والسيلينات")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sulfates));
        } else if (txt12.getText().toString().equalsIgnoreCase("fosfatos, arseniatos y vanadatos") || txt12.getText().toString().equalsIgnoreCase("phosphates, arsenates and vanadates") || txt12.getText().toString().equalsIgnoreCase("phosphates, arséniates et vanadates") || txt12.getText().toString().equalsIgnoreCase("fosfats, arseniats i vanadats") || txt12.getText().toString().equalsIgnoreCase("Фосфаты, арсенаты и ванадаты") || txt12.getText().toString().equalsIgnoreCase("الفوسفات والزرنيخات والفانادات")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_fosfates));
        } else if (txt12.getText().toString().equalsIgnoreCase("nesosilicatos") || txt12.getText().toString().equalsIgnoreCase("nesosilicates") || txt12.getText().toString().equalsIgnoreCase("nésosilicates") || txt12.getText().toString().equalsIgnoreCase("nesosilicats") || txt12.getText().toString().equalsIgnoreCase("Ортосиликаты") || txt12.getText().toString().equalsIgnoreCase("نيسوسيليكات")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_nesosilicates));
        } else if (txt12.getText().toString().equalsIgnoreCase("sorosilicatos") || txt12.getText().toString().equalsIgnoreCase("sorosilicates") || txt12.getText().toString().equalsIgnoreCase("sorosilicates") || txt12.getText().toString().equalsIgnoreCase("sorosilicats") || txt12.getText().toString().equalsIgnoreCase("Соросиликаты") || txt12.getText().toString().equalsIgnoreCase("سوروسيليكات")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sorosilicates));
        } else if (txt12.getText().toString().equalsIgnoreCase("ciclosilicatos") || txt12.getText().toString().equalsIgnoreCase("cyclosilicates") || txt12.getText().toString().equalsIgnoreCase("cyclosilicates") || txt12.getText().toString().equalsIgnoreCase("ciclosilicats") || txt12.getText().toString().equalsIgnoreCase("Кольцевые силикаты") || txt12.getText().toString().equalsIgnoreCase("السيكلوسيليكات")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_ciclosilicates));
        } else if (txt12.getText().toString().equalsIgnoreCase("inosilicatos") || txt12.getText().toString().equalsIgnoreCase("inosilicates") || txt12.getText().toString().equalsIgnoreCase("inosilicates") || txt12.getText().toString().equalsIgnoreCase("inosilicats") || txt12.getText().toString().equalsIgnoreCase("Ленточные силикаты") || txt12.getText().toString().equalsIgnoreCase("اينوسيليكات")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_inosilicates));
        } else if (txt12.getText().toString().equalsIgnoreCase("filosilicatos") || txt12.getText().toString().equalsIgnoreCase("phyllosilicates") || txt12.getText().toString().equalsIgnoreCase("phyllosilicates") || txt12.getText().toString().equalsIgnoreCase("fil·losilicats") || txt12.getText().toString().equalsIgnoreCase("Филлосиликаты") || txt12.getText().toString().equalsIgnoreCase("فيلوسيليكات")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_filosilicates));
        } else if (txt12.getText().toString().equalsIgnoreCase("tectosilicatos") || txt12.getText().toString().equalsIgnoreCase("tectosilicates") || txt12.getText().toString().equalsIgnoreCase("tectosilicates") || txt12.getText().toString().equalsIgnoreCase("tectosilicats") || txt12.getText().toString().equalsIgnoreCase("Каркасные силикаты") || txt12.getText().toString().equalsIgnoreCase("التكتوسيليكات")) {
            txt12.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_tectosilicates));
        }

        if (txt22.getText().toString().equalsIgnoreCase("elementos nativos") || txt22.getText().toString().equalsIgnoreCase("native elements") || txt22.getText().toString().equalsIgnoreCase("éléments natifs") || txt22.getText().toString().equalsIgnoreCase("elements nadius") || txt22.getText().toString().equalsIgnoreCase("Самородки") || txt22.getText().toString().equalsIgnoreCase("العناصر الأصلية")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_natives));
        } else if (txt22.getText().toString().equalsIgnoreCase("sulfuros y sulfosales") || txt22.getText().toString().equalsIgnoreCase("sulfides and sulfosalts") || txt22.getText().toString().equalsIgnoreCase("sulfures et sulfosels") || txt22.getText().toString().equalsIgnoreCase("sulfurs i sulfosals") || txt22.getText().toString().equalsIgnoreCase("Сульфиды и сульфосоли") || txt22.getText().toString().equalsIgnoreCase("الكبريتيدات والسلفوسالت")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sulfures));
        } else if (txt22.getText().toString().equalsIgnoreCase("óxidos e hidróxidos") || txt22.getText().toString().equalsIgnoreCase("oxides and hydroxides") || txt22.getText().toString().equalsIgnoreCase("oxydes et hydroxydes") || txt22.getText().toString().equalsIgnoreCase("òxids i hidròxids") || txt22.getText().toString().equalsIgnoreCase("Оксиды и гидроксиды") || txt22.getText().toString().equalsIgnoreCase("الأكاسيد والهيدروكسيدات")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_oxides));
        } else if (txt22.getText().toString().equalsIgnoreCase("haluros") || txt22.getText().toString().equalsIgnoreCase("halides") || txt22.getText().toString().equalsIgnoreCase("halogénures") || txt22.getText().toString().equalsIgnoreCase("halurs") || txt22.getText().toString().equalsIgnoreCase("Галогениды") || txt22.getText().toString().equalsIgnoreCase("الهاليدات")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_halides));
        } else if (txt22.getText().toString().equalsIgnoreCase("carbonatos, nitratos y boratos") || txt22.getText().toString().equalsIgnoreCase("carbonates, nitrates and borates") || txt22.getText().toString().equalsIgnoreCase("carbonates, nitrates et borates") || txt22.getText().toString().equalsIgnoreCase("carbonats, nitrats i borats") || txt22.getText().toString().equalsIgnoreCase("Карбонаты, нитраты и бораты") || txt22.getText().toString().equalsIgnoreCase("الكربونات والنترات والبورات")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_carbonates));
        } else if (txt22.getText().toString().equalsIgnoreCase("sulfatos, cromatos y seleniatos") || txt22.getText().toString().equalsIgnoreCase("sulfates, chromates and selenates") || txt22.getText().toString().equalsIgnoreCase("sulfates, chromates et séléniates") || txt22.getText().toString().equalsIgnoreCase("sulfats, cromats i seleniats") || txt22.getText().toString().equalsIgnoreCase("Сульфаты, хроматы и селенаты") || txt22.getText().toString().equalsIgnoreCase("الكبريتات والكرومات والسيلينات")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sulfates));
        } else if (txt22.getText().toString().equalsIgnoreCase("fosfatos, arseniatos y vanadatos") || txt22.getText().toString().equalsIgnoreCase("phosphates, arsenates and vanadates") || txt22.getText().toString().equalsIgnoreCase("phosphates, arséniates et vanadates") || txt22.getText().toString().equalsIgnoreCase("fosfats, arseniats i vanadats") || txt22.getText().toString().equalsIgnoreCase("Фосфаты, арсенаты и ванадаты") || txt12.getText().toString().equalsIgnoreCase("الفوسفات والزرنيخات والفانادات")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_fosfates));
        } else if (txt22.getText().toString().equalsIgnoreCase("nesosilicatos") || txt22.getText().toString().equalsIgnoreCase("nesosilicates") || txt22.getText().toString().equalsIgnoreCase("nésosilicates") || txt22.getText().toString().equalsIgnoreCase("nesosilicats") || txt22.getText().toString().equalsIgnoreCase("Ортосиликаты") || txt22.getText().toString().equalsIgnoreCase("نيسوسيليكات")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_nesosilicates));
        } else if (txt22.getText().toString().equalsIgnoreCase("sorosilicatos") || txt22.getText().toString().equalsIgnoreCase("sorosilicates") || txt22.getText().toString().equalsIgnoreCase("sorosilicates") || txt22.getText().toString().equalsIgnoreCase("sorosilicats") || txt22.getText().toString().equalsIgnoreCase("Соросиликаты") || txt22.getText().toString().equalsIgnoreCase("سوروسيليكات")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sorosilicates));
        } else if (txt22.getText().toString().equalsIgnoreCase("ciclosilicatos") || txt22.getText().toString().equalsIgnoreCase("cyclosilicates") || txt22.getText().toString().equalsIgnoreCase("cyclosilicates") || txt22.getText().toString().equalsIgnoreCase("ciclosilicats") || txt22.getText().toString().equalsIgnoreCase("Кольцевые силикаты") || txt22.getText().toString().equalsIgnoreCase("السيكلوسيليكات")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_ciclosilicates));
        } else if (txt22.getText().toString().equalsIgnoreCase("inosilicatos") || txt22.getText().toString().equalsIgnoreCase("inosilicates") || txt22.getText().toString().equalsIgnoreCase("inosilicates") || txt22.getText().toString().equalsIgnoreCase("inosilicats") || txt22.getText().toString().equalsIgnoreCase("Ленточные силикаты") || txt22.getText().toString().equalsIgnoreCase("اينوسيليكات")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_inosilicates));
        } else if (txt22.getText().toString().equalsIgnoreCase("filosilicatos") || txt22.getText().toString().equalsIgnoreCase("phyllosilicates") || txt22.getText().toString().equalsIgnoreCase("phyllosilicates") || txt22.getText().toString().equalsIgnoreCase("fil·losilicats") || txt22.getText().toString().equalsIgnoreCase("Филлосиликаты") || txt22.getText().toString().equalsIgnoreCase("فيلوسيليكات")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_filosilicates));
        } else if (txt22.getText().toString().equalsIgnoreCase("tectosilicatos") || txt22.getText().toString().equalsIgnoreCase("tectosilicates") || txt22.getText().toString().equalsIgnoreCase("tectosilicates") || txt22.getText().toString().equalsIgnoreCase("tectosilicats") || txt22.getText().toString().equalsIgnoreCase("Каркасные силикаты") || txt22.getText().toString().equalsIgnoreCase("التكتوسيليكات")) {
            txt22.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_tectosilicates));
        }

        if (txt32.getText().toString().equalsIgnoreCase("elementos nativos") || txt32.getText().toString().equalsIgnoreCase("native elements") || txt32.getText().toString().equalsIgnoreCase("éléments natifs") || txt32.getText().toString().equalsIgnoreCase("elements nadius") || txt32.getText().toString().equalsIgnoreCase("Самородки") || txt32.getText().toString().equalsIgnoreCase("العناصر الأصلية")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_natives));
        } else if (txt32.getText().toString().equalsIgnoreCase("sulfuros y sulfosales") || txt32.getText().toString().equalsIgnoreCase("sulfides and sulfosalts") || txt32.getText().toString().equalsIgnoreCase("sulfures et sulfosels") || txt32.getText().toString().equalsIgnoreCase("sulfurs i sulfosals") || txt32.getText().toString().equalsIgnoreCase("Сульфиды и сульфосоли") || txt32.getText().toString().equalsIgnoreCase("الكبريتيدات والسلفوسالت")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sulfures));
        } else if (txt32.getText().toString().equalsIgnoreCase("óxidos e hidróxidos") || txt32.getText().toString().equalsIgnoreCase("oxides and hydroxides") || txt32.getText().toString().equalsIgnoreCase("oxydes et hydroxydes") || txt32.getText().toString().equalsIgnoreCase("òxids i hidròxids") || txt32.getText().toString().equalsIgnoreCase("Оксиды и гидроксиды") || txt32.getText().toString().equalsIgnoreCase("الأكاسيد والهيدروكسيدات")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_oxides));
        } else if (txt32.getText().toString().equalsIgnoreCase("haluros") || txt32.getText().toString().equalsIgnoreCase("halides") || txt32.getText().toString().equalsIgnoreCase("halogénures") || txt32.getText().toString().equalsIgnoreCase("halurs") || txt32.getText().toString().equalsIgnoreCase("Галогениды") || txt32.getText().toString().equalsIgnoreCase("الهاليدات")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_halides));
        } else if (txt32.getText().toString().equalsIgnoreCase("carbonatos, nitratos y boratos") || txt32.getText().toString().equalsIgnoreCase("carbonates, nitrates and borates") || txt32.getText().toString().equalsIgnoreCase("carbonates, nitrates et borates") || txt32.getText().toString().equalsIgnoreCase("carbonats, nitrats i borats") || txt32.getText().toString().equalsIgnoreCase("Карбонаты, нитраты и бораты") || txt32.getText().toString().equalsIgnoreCase("الكربونات والنترات والبورات")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_carbonates));
        } else if (txt32.getText().toString().equalsIgnoreCase("sulfatos, cromatos y seleniatos") || txt32.getText().toString().equalsIgnoreCase("sulfates, chromates and selenates") || txt32.getText().toString().equalsIgnoreCase("sulfates, chromates et séléniates") || txt32.getText().toString().equalsIgnoreCase("sulfats, cromats i seleniats") || txt32.getText().toString().equalsIgnoreCase("Сульфаты, хроматы и селенаты") || txt32.getText().toString().equalsIgnoreCase("الكبريتات والكرومات والسيلينات")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sulfates));
        } else if (txt32.getText().toString().equalsIgnoreCase("fosfatos, arseniatos y vanadatos") || txt32.getText().toString().equalsIgnoreCase("phosphates, arsenates and vanadates") || txt32.getText().toString().equalsIgnoreCase("phosphates, arséniates et vanadates") || txt32.getText().toString().equalsIgnoreCase("fosfats, arseniats i vanadats") || txt32.getText().toString().equalsIgnoreCase("Фосфаты, арсенаты и ванадаты") || txt32.getText().toString().equalsIgnoreCase("الفوسفات والزرنيخات والفانادات")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_fosfates));
        } else if (txt32.getText().toString().equalsIgnoreCase("nesosilicatos") || txt32.getText().toString().equalsIgnoreCase("nesosilicates") || txt32.getText().toString().equalsIgnoreCase("nésosilicates") || txt32.getText().toString().equalsIgnoreCase("nesosilicats") || txt32.getText().toString().equalsIgnoreCase("Ортосиликаты") || txt32.getText().toString().equalsIgnoreCase("نيسوسيليكات")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_nesosilicates));
        } else if (txt32.getText().toString().equalsIgnoreCase("sorosilicatos") || txt32.getText().toString().equalsIgnoreCase("sorosilicates") || txt32.getText().toString().equalsIgnoreCase("sorosilicates") || txt32.getText().toString().equalsIgnoreCase("sorosilicats") || txt32.getText().toString().equalsIgnoreCase("Соросиликаты") || txt32.getText().toString().equalsIgnoreCase("سوروسيليكات")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sorosilicates));
        } else if (txt32.getText().toString().equalsIgnoreCase("ciclosilicatos") || txt32.getText().toString().equalsIgnoreCase("cyclosilicates") || txt32.getText().toString().equalsIgnoreCase("cyclosilicates") || txt32.getText().toString().equalsIgnoreCase("ciclosilicats") || txt32.getText().toString().equalsIgnoreCase("Кольцевые силикаты") || txt32.getText().toString().equalsIgnoreCase("السيكلوسيليكات")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_ciclosilicates));
        } else if (txt32.getText().toString().equalsIgnoreCase("inosilicatos") || txt32.getText().toString().equalsIgnoreCase("inosilicates") || txt32.getText().toString().equalsIgnoreCase("inosilicates") || txt32.getText().toString().equalsIgnoreCase("inosilicats") || txt32.getText().toString().equalsIgnoreCase("Ленточные силикаты") || txt32.getText().toString().equalsIgnoreCase("اينوسيليكات")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_inosilicates));
        } else if (txt32.getText().toString().equalsIgnoreCase("filosilicatos") || txt32.getText().toString().equalsIgnoreCase("phyllosilicates") || txt32.getText().toString().equalsIgnoreCase("phyllosilicates") || txt32.getText().toString().equalsIgnoreCase("fil·losilicats") || txt32.getText().toString().equalsIgnoreCase("Филлосиликаты") || txt32.getText().toString().equalsIgnoreCase("فيلوسيليكات")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_filosilicates));
        } else if (txt32.getText().toString().equalsIgnoreCase("tectosilicatos") || txt32.getText().toString().equalsIgnoreCase("tectosilicates") || txt32.getText().toString().equalsIgnoreCase("tectosilicates") || txt32.getText().toString().equalsIgnoreCase("tectosilicats") || txt32.getText().toString().equalsIgnoreCase("Каркасные силикаты") || txt32.getText().toString().equalsIgnoreCase("التكتوسيليكات")) {
            txt32.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_tectosilicates));
        }
        if (txt42.getText().toString().equalsIgnoreCase("elementos nativos") || txt42.getText().toString().equalsIgnoreCase("native elements") || txt42.getText().toString().equalsIgnoreCase("éléments natifs") || txt42.getText().toString().equalsIgnoreCase("elements nadius") || txt42.getText().toString().equalsIgnoreCase("Самородки") || txt42.getText().toString().equalsIgnoreCase("العناصر الأصلية")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_natives));
        } else if (txt42.getText().toString().equalsIgnoreCase("sulfuros y sulfosales") || txt42.getText().toString().equalsIgnoreCase("sulfides and sulfosalts") || txt42.getText().toString().equalsIgnoreCase("sulfures et sulfosels") || txt42.getText().toString().equalsIgnoreCase("sulfurs i sulfosals") || txt42.getText().toString().equalsIgnoreCase("Сульфиды и сульфосоли") || txt42.getText().toString().equalsIgnoreCase("الكبريتيدات والسلفوسالت")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sulfures));
        } else if (txt42.getText().toString().equalsIgnoreCase("óxidos e hidróxidos") || txt42.getText().toString().equalsIgnoreCase("oxides and hydroxides") || txt42.getText().toString().equalsIgnoreCase("oxydes et hydroxydes") || txt42.getText().toString().equalsIgnoreCase("òxids i hidròxids") || txt42.getText().toString().equalsIgnoreCase("Оксиды и гидроксиды") || txt42.getText().toString().equalsIgnoreCase("الأكاسيد والهيدروكسيدات")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_oxides));
        } else if (txt42.getText().toString().equalsIgnoreCase("haluros") || txt42.getText().toString().equalsIgnoreCase("halides") || txt42.getText().toString().equalsIgnoreCase("halogénures") || txt42.getText().toString().equalsIgnoreCase("halurs") || txt42.getText().toString().equalsIgnoreCase("Галогениды") || txt42.getText().toString().equalsIgnoreCase("الهاليدات")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_halides));
        } else if (txt42.getText().toString().equalsIgnoreCase("carbonatos, nitratos y boratos") || txt42.getText().toString().equalsIgnoreCase("carbonates, nitrates and borates") || txt42.getText().toString().equalsIgnoreCase("carbonates, nitrates et borates") || txt42.getText().toString().equalsIgnoreCase("carbonats, nitrats i borats") || txt42.getText().toString().equalsIgnoreCase("Карбонаты, нитраты и бораты") || txt42.getText().toString().equalsIgnoreCase("الكربونات والنترات والبورات")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_carbonates));
        } else if (txt42.getText().toString().equalsIgnoreCase("sulfatos, cromatos y seleniatos") || txt42.getText().toString().equalsIgnoreCase("sulfates, chromates and selenates") || txt42.getText().toString().equalsIgnoreCase("sulfates, chromates et séléniates") || txt42.getText().toString().equalsIgnoreCase("sulfats, cromats i seleniats") || txt42.getText().toString().equalsIgnoreCase("Сульфаты, хроматы и селенаты") || txt42.getText().toString().equalsIgnoreCase("الكبريتات والكرومات والسيلينات")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sulfates));
        } else if (txt42.getText().toString().equalsIgnoreCase("fosfatos, arseniatos y vanadatos") || txt42.getText().toString().equalsIgnoreCase("phosphates, arsenates and vanadates") || txt42.getText().toString().equalsIgnoreCase("phosphates, arséniates et vanadates") || txt42.getText().toString().equalsIgnoreCase("fosfats, arseniats i vanadats") || txt42.getText().toString().equalsIgnoreCase("Фосфаты, арсенаты и ванадаты") || txt42.getText().toString().equalsIgnoreCase("الفوسفات والزرنيخات والفانادات")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_fosfates));
        } else if (txt42.getText().toString().equalsIgnoreCase("nesosilicatos") || txt42.getText().toString().equalsIgnoreCase("nesosilicates") || txt42.getText().toString().equalsIgnoreCase("nésosilicates") || txt42.getText().toString().equalsIgnoreCase("nesosilicats") || txt42.getText().toString().equalsIgnoreCase("Ортосиликаты") || txt42.getText().toString().equalsIgnoreCase("نيسوسيليكات")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_nesosilicates));
        } else if (txt42.getText().toString().equalsIgnoreCase("sorosilicatos") || txt42.getText().toString().equalsIgnoreCase("sorosilicates") || txt42.getText().toString().equalsIgnoreCase("sorosilicates") || txt42.getText().toString().equalsIgnoreCase("sorosilicats") || txt42.getText().toString().equalsIgnoreCase("Соросиликаты") || txt42.getText().toString().equalsIgnoreCase("سوروسيليكات")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_sorosilicates));
        } else if (txt42.getText().toString().equalsIgnoreCase("ciclosilicatos") || txt42.getText().toString().equalsIgnoreCase("cyclosilicates") || txt42.getText().toString().equalsIgnoreCase("cyclosilicates") || txt42.getText().toString().equalsIgnoreCase("ciclosilicats") || txt42.getText().toString().equalsIgnoreCase("Кольцевые силикаты") || txt42.getText().toString().equalsIgnoreCase("السيكلوسيليكات")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_ciclosilicates));
        } else if (txt42.getText().toString().equalsIgnoreCase("inosilicatos") || txt42.getText().toString().equalsIgnoreCase("inosilicates") || txt42.getText().toString().equalsIgnoreCase("inosilicates") || txt42.getText().toString().equalsIgnoreCase("inosilicats") || txt42.getText().toString().equalsIgnoreCase("Ленточные силикаты") || txt42.getText().toString().equalsIgnoreCase("اينوسيليكات")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_inosilicates));
        } else if (txt42.getText().toString().equalsIgnoreCase("filosilicatos") || txt42.getText().toString().equalsIgnoreCase("phyllosilicates") || txt42.getText().toString().equalsIgnoreCase("phyllosilicates") || txt42.getText().toString().equalsIgnoreCase("fil·losilicats") || txt42.getText().toString().equalsIgnoreCase("Филлосиликаты") || txt42.getText().toString().equalsIgnoreCase("فيلوسيليكات")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_filosilicates));
        } else if (txt42.getText().toString().equalsIgnoreCase("tectosilicatos") || txt42.getText().toString().equalsIgnoreCase("tectosilicates") || txt42.getText().toString().equalsIgnoreCase("tectosilicates") || txt42.getText().toString().equalsIgnoreCase("tectosilicats") || txt42.getText().toString().equalsIgnoreCase("Каркасные силикаты") || txt42.getText().toString().equalsIgnoreCase("التكتوسيليكات")) {
            txt42.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.redondeo_tectosilicates));
        }
    }
    public void generaPrimeraPregunta() {
        clasePreguntas.add(tipo);
        clasePreguntas.add(clase);
        clasePreguntas.add(formula);
        clasePreguntas.add(sistema);
        clasePreguntas.add(ambientes);
        clasePreguntas.add(habito);
        clasePreguntas.add(color);
        clasePreguntas.add(diafanidad);
        clasePreguntas.add(brillo);
        clasePreguntas.add(raya);
        clasePreguntas.add(dureza);
        clasePreguntas.add(densidad);
        clasePreguntas.add(exfoliacion);
        for (int i = 0; i < clasePreguntas.size(); ++i) {
            if (clasePreguntas.get(i)) {
                myList.add(i);
            }
        }
        numGrupos = myList.size();
        calculaPreguntaYLanza();
    }

    public void calculaPreguntaYLanza() {
        Random random = new Random();

        if (numGrupos == 1) {
            randomClase = 0;
        } else {
            randomClase = random.nextInt((numGrupos));
        }
        if (myList.get(randomClase) == 0) {
            generaPreguntaTipo();
            typeQuestion = "TYPE";
        } else if (myList.get(randomClase) == 1) {
            generaPreguntaClase();
            typeQuestion = "CLASS";
        } else if (myList.get(randomClase) == 2) {
            generaPreguntaFormula();
            typeQuestion = "FORMULA";
        } else if (myList.get(randomClase) == 3) {
            generaPreguntaSistema();
            typeQuestion = "SYSTEM";
        } else if (myList.get(randomClase) == 4) {
            generaPreguntaAmbientes();
            typeQuestion = "ENVS";
        } else if (myList.get(randomClase) == 5) {
            generaPreguntaHabito();
            typeQuestion = "HABIT";
        } else if (myList.get(randomClase) == 6) {
            generaPreguntaColor();
            typeQuestion = "COLOR";
        } else if (myList.get(randomClase) == 7) {
            generaPreguntaDiafanidad();
            typeQuestion = "DIAPHANEITY";
        } else if (myList.get(randomClase) == 8) {
            generaPreguntaBrillo();
            typeQuestion = "LUSTER";
        } else if (myList.get(randomClase) == 9) {
            generaPreguntaRaya();
            typeQuestion = "STREAK";
        } else if (myList.get(randomClase) == 10) {
            generaPreguntaDureza();
            typeQuestion = "HARDNESS";
        } else if (myList.get(randomClase) == 11) {
            generaPreguntaDensidad();
            typeQuestion = "DENSITY";
        } else if (myList.get(randomClase) == 12) {
            generaPreguntaExfoliacion();
            typeQuestion = "CLEAVAGE";
        }
    }

    public void generaPreguntaTipo() {
        Random random = new Random();
        int id = random.nextInt(60) + 1;

        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYTipo(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            tipoCorrecto = cursor.getString(1).toLowerCase();
        }
        cursor.close();
        myDb.closeDatabase();
        minerales.add(nombreCorrecto);
        while (minerales.size() < 4) {
            anyadeMineralIncorrectoTipo(id);
        }
        Collections.shuffle(minerales);
        String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
        String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
        String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
        String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
        pri.setText(texto1);
        seg.setText(texto2);
        ter.setText(texto3);
        cua.setText(texto4);
        minerales.clear();
        String encabezado = this.getString(R.string.encabezado_pregunta_tipo);
        String pie = "?";
        String textoPregunta = encabezado + tipoCorrecto.toLowerCase() + pie;
        txtQuestion.setText(textoPregunta);
    }
    public void generaPreguntaClase() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYClase(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            claseCorrecta = cursor.getString(1).toLowerCase();
        }
        cursor.close();
        myDb.closeDatabase();
        minerales.add(nombreCorrecto);
        while (minerales.size() < 4) {
            anyadeMineralIncorrectoClase();
        }
        Collections.shuffle(minerales);
        String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
        String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
        String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
        String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
        pri.setText(texto1);
        seg.setText(texto2);
        ter.setText(texto3);
        cua.setText(texto4);
        minerales.clear();
        String encabezado = this.getString(R.string.encabezado_pregunta_clase);
        String pie = "?";
        String textoPregunta = encabezado + claseCorrecta.toLowerCase() + pie;
        txtQuestion.setText(textoPregunta);
    }
    public void generaPreguntaFormula() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYFormula(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            formulaCorrecta = cursor.getString(1);
        }
        cursor.close();
        myDb.closeDatabase();
        minerales.add(nombreCorrecto);
        while (minerales.size() < 4) {
            anyadeMineralIncorrectoFormula();
        }
        Collections.shuffle(minerales);
        String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
        String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
        String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
        String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
        pri.setText(texto1);
        seg.setText(texto2);
        ter.setText(texto3);
        cua.setText(texto4);
        minerales.clear();
        String encabezado = this.getString(R.string.encabezado_pregunta_formula);
        String pie = "?";
        String textoPregunta = encabezado + formulaCorrecta + pie;
        txtQuestion.setText(Html.fromHtml(textoPregunta));
    }

    public void generaPreguntaSistema() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYSistema(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            sistemaCorrecto = cursor.getString(1).toLowerCase();
        }
        cursor.close();
        myDb.closeDatabase();
        minerales.add(nombreCorrecto);
        while (minerales.size() < 4) {
            anyadeMineralIncorrectoSistema();
        }
        Collections.shuffle(minerales);
        String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
        String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
        String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
        String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
        pri.setText(texto1);
        seg.setText(texto2);
        ter.setText(texto3);
        cua.setText(texto4);
        minerales.clear();
        String encabezado = this.getString(R.string.encabezado_pregunta_sistema);
        String pie = "?";
        String textoPregunta = encabezado + sistemaCorrecto.toLowerCase() + pie;
        txtQuestion.setText(textoPregunta);
    }
    public void generaPreguntaAmbientes() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYAmbientes(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            String env1 = cursor.getString(1);
            String envDesc1 = cursor.getString(2);
            String env2 = cursor.getString(3);
            String envDesc2 = cursor.getString(4);
            String env3 = cursor.getString(5);
            String envDesc3 = cursor.getString(6);
            String env4 = cursor.getString(7);
            String envDesc4 = cursor.getString(8);
            int numAmbientes = 0;
            if (env2.equals("-")) {
                numAmbientes = 1;
            } else if (env3.equals("-")) {
                numAmbientes = 2;
            } else if (env4.equals("-")) {
                numAmbientes = 3;
            } else {
                numAmbientes = 4;
            }
            Random random2 = new Random();
            int randomAmbiente = random2.nextInt(numAmbientes) + 1;
            if (randomAmbiente == 1) {
                envCorrecto = env1;
                ambienteCorrecto = env1.toLowerCase() + " " + envDesc1;
            } else if (randomAmbiente == 2) {
                envCorrecto = env2;
                ambienteCorrecto = env2.toLowerCase() + " " + envDesc2;
            } else if (randomAmbiente == 3) {
                envCorrecto = env3;
                ambienteCorrecto = env3.toLowerCase() + " " + envDesc3;
            } else {
                envCorrecto = env4;
                ambienteCorrecto = env4.toLowerCase() + " " + envDesc4;
            }
        }
        cursor.close();
        myDb.closeDatabase();
        minerales.add(nombreCorrecto);
        while (minerales.size() < 4) {
            anyadeMineralIncorrectoAmbiente();
        }
        Collections.shuffle(minerales);
        String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
        String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
        String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
        String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
        pri.setText(texto1);
        seg.setText(texto2);
        ter.setText(texto3);
        cua.setText(texto4);
        minerales.clear();
        String encabezado = this.getString(R.string.encabezado_pregunta_ambiente);
        String pie = "?";
        String textoPregunta = encabezado + ambienteCorrecto + pie;
        txtQuestion.setText(textoPregunta);
    }

    public void generaPreguntaHabito() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYHabito(String.valueOf(id));
        Cursor cursor2 = myDb.getMineralYClase(String.valueOf(id));
        String quiz = "";
        String clase = "";
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            habitoCorrecto = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        while (cursor2.moveToNext()) {
            clase = cursor2.getString(1);
        }
        cursor.close();
        cursor2.close();
        myDb.closeDatabase();
        if (quiz.equals("1")) {
            minerales.add(nombreCorrecto);
            while (minerales.size() < 4) {
                anyadeMineralIncorrectoHabito(clase);
            }
            Collections.shuffle(minerales);
            String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
            String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
            String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
            String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
            pri.setText(texto1);
            seg.setText(texto2);
            ter.setText(texto3);
            cua.setText(texto4);
            minerales.clear();
            String encabezado = this.getString(R.string.encabezado_pregunta_habito);
            String pie = "?";
            String textoPregunta = encabezado + habitoCorrecto + pie;
            txtQuestion.setText(textoPregunta);
        } else {
            generaPreguntaHabito();
        }
    }

    public void generaPreguntaColor() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYColor(String.valueOf(id));
        String quiz = "";
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            colorCorrecto = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (quiz.equals("1")) {
            minerales.add(nombreCorrecto);
            while (minerales.size() < 4) {
                anyadeMineralIncorrectoColor();
            }
            Collections.shuffle(minerales);
            String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
            String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
            String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
            String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
            pri.setText(texto1);
            seg.setText(texto2);
            ter.setText(texto3);
            cua.setText(texto4);
            minerales.clear();
            String encabezado = this.getString(R.string.encabezado_pregunta_color);
            String pie = "?";
            String textoPregunta = encabezado + colorCorrecto.toLowerCase() + pie;
            if (colorCorrecto.equalsIgnoreCase("incoloro")) {
                txtQuestion.setText(R.string.sin_color);
            } else {
                txtQuestion.setText(textoPregunta);
            }
        } else {
            generaPreguntaColor();
        }
    }

    public void generaPreguntaDiafanidad() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYDiafanidad(String.valueOf(id));
        String quiz = "";
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            diafanidadCorrecta = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (quiz.equals("1")) {
            minerales.add(nombreCorrecto);
            while (minerales.size() < 4) {
                anyadeMineralIncorrectoDiafanidad();
            }
            Collections.shuffle(minerales);
            String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
            String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
            String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
            String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
            pri.setText(texto1);
            seg.setText(texto2);
            ter.setText(texto3);
            cua.setText(texto4);
            minerales.clear();
            String encabezado = this.getString(R.string.encabezado_pregunta_diafanidad);
            String pie = "?";
            String textoPregunta = encabezado + diafanidadCorrecta.toLowerCase() + pie;
            if (diafanidadCorrecta.equalsIgnoreCase("opaco")) {
                txtQuestion.setText(R.string.opacos);
            } else {
                txtQuestion.setText(textoPregunta);
            }
        } else {
            generaPreguntaDiafanidad();
        }
    }

    public void generaPreguntaBrillo() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYBrillo(String.valueOf(id));
        String quiz = "";
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            brilloCorrecto = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (quiz.equals("1")) {
            minerales.add(nombreCorrecto);
            while (minerales.size() < 4) {
                anyadeMineralIncorrectoBrillo();
            }
            Collections.shuffle(minerales);
            String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
            String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
            String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
            String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
            pri.setText(texto1);
            seg.setText(texto2);
            ter.setText(texto3);
            cua.setText(texto4);
            minerales.clear();
            String encabezado = this.getString(R.string.encabezado_pregunta_brillo);
            String pie = "?";
            String textoPregunta = encabezado + brilloCorrecto.toLowerCase() + pie;
            txtQuestion.setText(textoPregunta);
        } else {
            generaPreguntaBrillo();
        }
    }
    public void generaPreguntaRaya() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYRaya(String.valueOf(id));
        String quiz = "";
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            rayaCorrecta = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (quiz.equals("1")) {
            minerales.add(nombreCorrecto);
            while (minerales.size() < 4) {
                anyadeMineralIncorrectoRaya();
            }
            Collections.shuffle(minerales);
            String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
            String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
            String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
            String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
            pri.setText(texto1);
            seg.setText(texto2);
            ter.setText(texto3);
            cua.setText(texto4);
            minerales.clear();
            String encabezado = this.getString(R.string.encabezado_pregunta_raya);
            String pie = "?";
            String textoPregunta = encabezado + rayaCorrecta.toLowerCase() + pie;
            txtQuestion.setText(textoPregunta);
        } else {
            generaPreguntaRaya();
        }
    }
    public void generaPreguntaDureza() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYDureza(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            durezaCorrecta = cursor.getString(1);
            durezaMediaCorrecta = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (!durezaCorrecta.equals("-")) {
            minerales.add(nombreCorrecto);
            while (minerales.size() < 4) {
                anyadeMineralIncorrectoDureza();
            }
            Collections.shuffle(minerales);
            String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
            String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
            String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
            String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
            pri.setText(texto1);
            seg.setText(texto2);
            ter.setText(texto3);
            cua.setText(texto4);
            minerales.clear();
            String encabezado = this.getString(R.string.encabezado_pregunta_dureza);
            String pie = "?";
            String textoPregunta = encabezado + durezaCorrecta + pie;
            txtQuestion.setText(textoPregunta);
        } else {
            generaPreguntaDureza();
        }
    }

    public void generaPreguntaDensidad() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYDensidad(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            densidadCorrecta = cursor.getString(1);
            densidadMediaCorrecta = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (!densidadCorrecta.equals("-")) {
            minerales.add(nombreCorrecto);
            while (minerales.size() < 4) {
                anyadeMineralIncorrectoDensidad();
            }
            Collections.shuffle(minerales);
            String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
            String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
            String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
            String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
            pri.setText(texto1);
            seg.setText(texto2);
            ter.setText(texto3);
            cua.setText(texto4);
            minerales.clear();
            String encabezado = this.getString(R.string.encabezado_pregunta_densidad);
            String pie = "?";
            String textoPregunta = encabezado + densidadCorrecta + " g/cm<sup><small>3</small></sup>" + pie;
            txtQuestion.setText(Html.fromHtml(textoPregunta));
        } else {
            generaPreguntaDensidad();
        }
    }

    public void generaPreguntaExfoliacion() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYExfoliacion(String.valueOf(id));
        String quiz = "";
        while (cursor.moveToNext()) {
            nombreCorrecto = cursor.getString(0);
            exfoliacionCorrecta = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (quiz.equals("1")) {
            minerales.add(nombreCorrecto);
            while (minerales.size() < 4) {
                anyadeMineralIncorrectoExfoliacion();
            }
            Collections.shuffle(minerales);
            String texto1 = minerales.get(0).substring(0, 1).toUpperCase() + minerales.get(0).substring(1);
            String texto2 = minerales.get(1).substring(0, 1).toUpperCase() + minerales.get(1).substring(1);
            String texto3 = minerales.get(2).substring(0, 1).toUpperCase() + minerales.get(2).substring(1);
            String texto4 = minerales.get(3).substring(0, 1).toUpperCase() + minerales.get(3).substring(1);
            pri.setText(texto1);
            seg.setText(texto2);
            ter.setText(texto3);
            cua.setText(texto4);
            minerales.clear();
            String encabezado = this.getString(R.string.encabezado_pregunta_exfoliacion);
            String pie = "?";
            String textoPregunta = encabezado + exfoliacionCorrecta.toLowerCase() + pie;
            if (exfoliacionCorrecta.equalsIgnoreCase("sin exfoliación")) {
                txtQuestion.setText(getResources().getString(R.string.sin_exfoliacion));
            } else {
                txtQuestion.setText(textoPregunta);
            }
        } else {
            generaPreguntaExfoliacion();
        }
    }


    public void anyadeMineralIncorrectoTipo(int id) {
        Random random = new Random();
        int id2;
        if (id>29) {
            id2 = random.nextInt(29) + 1;
        } else {
            id2 = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYTipo(String.valueOf(id2));
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            tipoIncorrecto = cursor.getString(1).toLowerCase();
        }
        cursor.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto) && !tipoIncorrecto.equals(tipoCorrecto)) {
            minerales.add(nombreIncorrecto);
        }
    }

    public void anyadeMineralIncorrectoClase() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYClase(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            claseIncorrecta = cursor.getString(1).toLowerCase();
        }
        cursor.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto) && !claseIncorrecta.equals(claseCorrecta)) {
            minerales.add(nombreIncorrecto);
        }
    }
    public void anyadeMineralIncorrectoFormula() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYFormula(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
        }
        cursor.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto)) {
            minerales.add(nombreIncorrecto);
        }
    }
    public void anyadeMineralIncorrectoSistema() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYSistema(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            sistemaIncorrecto = cursor.getString(1).toLowerCase();
        }
        cursor.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto) && !sistemaIncorrecto.equals(sistemaCorrecto)) {
            minerales.add(nombreIncorrecto);
        }
    }
    public void anyadeMineralIncorrectoAmbiente() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYAmbientes(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            String envIn1 = cursor.getString(1);
            String envIn2 = cursor.getString(3);
            String envIn3 = cursor.getString(5);
            String envIn4 = cursor.getString(7);
            envs = new ArrayList<>();
            envs.add(envIn1);
            envs.add(envIn2);
            envs.add(envIn3);
            envs.add(envIn4);
        }
        cursor.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto) && !envs.contains(envCorrecto)) {
            minerales.add(nombreIncorrecto);
        }
    }

    public void anyadeMineralIncorrectoHabito(String clase) {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYHabito(String.valueOf(id));
        Cursor cursor2 = myDb.getMineralYClase(String.valueOf(id));
        String quiz = "";
        String claseIncorrecta = "";
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            habitoIncorrecto = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        while (cursor2.moveToNext()) {
            claseIncorrecta = cursor2.getString(1);
        }
        cursor.close();
        cursor2.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto) && !clase.equals(claseIncorrecta) && !habitoIncorrecto.equals("-") && !habitoIncorrecto.equals(habitoCorrecto) && quiz.equals("1")) {
            minerales.add(nombreIncorrecto);
        }
    }
    public void anyadeMineralIncorrectoColor() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYColor(String.valueOf(id));
        String quiz = "";
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            colorIncorrecto = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        cursor.close();
        if (!minerales.contains(nombreIncorrecto) && !colorIncorrecto.equals("-") && checkRepeated(colorCorrecto,colorIncorrecto)==0 && quiz.equals("1")) {
            minerales.add(nombreIncorrecto);
        }
    }
    public void anyadeMineralIncorrectoDiafanidad() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYDiafanidad(String.valueOf(id));
        String quiz = "";
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            diafanidadIncorrecta = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto) && !diafanidadIncorrecta.equals("-") && checkRepeated(diafanidadCorrecta,diafanidadIncorrecta)==0 && quiz.equals("1")) {
            minerales.add(nombreIncorrecto);
        }
    }
    public void anyadeMineralIncorrectoBrillo() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYBrillo(String.valueOf(id));
        String quiz = "";
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            brilloIncorrecto = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto) && !brilloIncorrecto.equals("-") && checkRepeated(brilloIncorrecto,brilloCorrecto)==0 && quiz.equals("1")) {
            minerales.add(nombreIncorrecto);
        }
    }
    public void anyadeMineralIncorrectoRaya() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYRaya(String.valueOf(id));
        String quiz = "";
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            rayaIncorrecta = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto) && !rayaIncorrecta.equals("-") && checkRepeated(rayaCorrecta,rayaIncorrecta)==0 && quiz.equals("1")) {
            minerales.add(nombreIncorrecto);
        }
    }

    public void anyadeMineralIncorrectoDureza() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYDureza(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            durezaIncorrecta = cursor.getString(1);
            durezaMediaIncorrecta = cursor.getString(2);
        }
        Log.i("dureza", durezaMediaIncorrecta);
        cursor.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto) && !durezaIncorrecta.equals("-") && Math.abs(Float.parseFloat(durezaMediaCorrecta)-Float.parseFloat(durezaMediaIncorrecta))>1) {
            minerales.add(nombreIncorrecto);
        }
    }
    public void anyadeMineralIncorrectoDensidad() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYDensidad(String.valueOf(id));
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            densidadIncorrecta = cursor.getString(1);
            densidadMediaIncorrecta = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto) && !densidadIncorrecta.equals("-") && Math.abs(Float.parseFloat(densidadMediaCorrecta)-Float.parseFloat(densidadMediaIncorrecta))>1) {
            minerales.add(nombreIncorrecto);
        }
    }
    public void anyadeMineralIncorrectoExfoliacion() {
        Random random = new Random();
        int id = 0;
        if (silicatos&&nosilicatos) {
            id = random.nextInt(60) + 1;
        } else if (nosilicatos) {
            id = random.nextInt(29) + 1;
        } else {
            id = random.nextInt(31) + 30;
        }
        Database myDb = new Database(this);
        Cursor cursor = myDb.getMineralYExfoliacion(String.valueOf(id));
        String quiz = "";
        while (cursor.moveToNext()) {
            nombreIncorrecto = cursor.getString(0);
            exfoliacionIncorrecta = cursor.getString(1).toLowerCase();
            quiz = cursor.getString(2);
        }
        cursor.close();
        myDb.closeDatabase();
        if (!minerales.contains(nombreIncorrecto) && !exfoliacionIncorrecta.equals("-") && !exfoliacionIncorrecta.equals(exfoliacionCorrecta)) {
            minerales.add(nombreIncorrecto);
        }
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
    public static int checkRepeated(String str1, String str2) {
        int repeated = 0;
        String replace1 = str1.replace("{", "").replace("}", "").replace(",", "").replace(".", "").replace(";", "").replace("-", " ").replace("/", " ");
        String[] words1 = replace1.split(" ");
        String replace2 = str2.replace("{", "").replace("}", "").replace(",", "").replace(".", "").replace(";", "").replace("-", " ").replace("/", " ");
        String[] words2 = replace2.split(" ");
        for (String word1 : words1) {
            for (String word2 : words2) {
                if (word1.equalsIgnoreCase(word2)) {
                    if (word1.length()>3) {
                        repeated += 1;
                    }
                }
            }
        }
        return repeated;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        //showFinalAlert();
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_back) {
            //showFinalAlert();
            finish(); //Debe hacer finish al pulsar aceptar
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

