package com.geology_quiz_and_guide.mineralogy.ui.quiz;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


import com.geology_quiz_and_guide.mineralogy.QuizGame;
import com.geology_quiz_and_guide.mineralogy.R;
import com.geology_quiz_and_guide.mineralogy.databinding.FragmentQuizBinding;

import java.util.Locale;
import java.util.UUID;


public class QuizFragment extends Fragment {

    private FragmentQuizBinding binding;
    private boolean tipo, clase, formula, sistema, ambientes, habito, color, diafanidad, brillo, raya,
            dureza, densidad, exfoliacion, silicatos, nosilicatos;
    private static final int RC_SIGN_IN = 9001;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String isTablet = isTablet(getActivity());
        String theme = sharedPreferences.getString("theme", "light");
        String sizeText = sharedPreferences.getString("sizeText", "medium");
        String language = sharedPreferences.getString("language", Locale.getDefault().getLanguage());
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());
        binding = FragmentQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        CheckBox checkTipo = binding.checkboxTipo;
        CheckBox checkClase = binding.checkboxClase;
        CheckBox checkFormula = binding.checkboxFormula;
        CheckBox checkSistema = binding.checkboxSistema;
        CheckBox checkAmbientes = binding.checkboxAmbientes;
        CheckBox checkHabito = binding.checkboxHabito;
        CheckBox checkColor = binding.checkboxColor;
        CheckBox checkDiafanidad = binding.checkboxDiafanidad;
        CheckBox checkBrillo = binding.checkboxBrillo;
        CheckBox checkRaya = binding.checkboxRaya;
        CheckBox checkDureza = binding.checkboxDureza;
        CheckBox checkDensidad = binding.checkboxDensidad;
        CheckBox checkExfoliacion = binding.checkboxExfoliacion;
        CheckBox checkSilicatos = binding.checkboxSilicatos;
        CheckBox checkNoSilicatos = binding.checkboxNoSilicatos;
        checkTipo.setChecked(true);
        checkSilicatos.setChecked(true);
        checkNoSilicatos.setChecked(true);
        Button btnEmpezar = binding.buttonEmpezar;
        ScrollView screen = binding.layout;
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
        if (theme.equals("darck")) {
            checkTipo.setTextColor(getResources().getColor(R.color.white));
            checkClase.setTextColor(getResources().getColor(R.color.white));
            checkFormula.setTextColor(getResources().getColor(R.color.white));
            checkSistema.setTextColor(getResources().getColor(R.color.white));
            checkAmbientes.setTextColor(getResources().getColor(R.color.white));
            checkHabito.setTextColor(getResources().getColor(R.color.white));
            checkColor.setTextColor(getResources().getColor(R.color.white));
            checkDiafanidad.setTextColor(getResources().getColor(R.color.white));
            checkBrillo.setTextColor(getResources().getColor(R.color.white));
            checkRaya.setTextColor(getResources().getColor(R.color.white));
            checkDureza.setTextColor(getResources().getColor(R.color.white));
            checkDensidad.setTextColor(getResources().getColor(R.color.white));
            checkSilicatos.setTextColor(getResources().getColor(R.color.white));
            checkExfoliacion.setTextColor(getResources().getColor(R.color.white));
            checkNoSilicatos.setTextColor(getResources().getColor(R.color.white));
        } else {
            checkTipo.setTextColor(getResources().getColor(R.color.black));
            checkClase.setTextColor(getResources().getColor(R.color.black));
            checkFormula.setTextColor(getResources().getColor(R.color.black));
            checkSistema.setTextColor(getResources().getColor(R.color.black));
            checkAmbientes.setTextColor(getResources().getColor(R.color.black));
            checkHabito.setTextColor(getResources().getColor(R.color.black));
            checkColor.setTextColor(getResources().getColor(R.color.black));
            checkDiafanidad.setTextColor(getResources().getColor(R.color.black));
            checkBrillo.setTextColor(getResources().getColor(R.color.black));
            checkRaya.setTextColor(getResources().getColor(R.color.black));
            checkDureza.setTextColor(getResources().getColor(R.color.black));
            checkDensidad.setTextColor(getResources().getColor(R.color.black));
            checkExfoliacion.setTextColor(getResources().getColor(R.color.black));
            checkSilicatos.setTextColor(getResources().getColor(R.color.black));
            checkNoSilicatos.setTextColor(getResources().getColor(R.color.black));
        }
        switch (sizeText) {
            case "very big":
                if (isTablet.equals("Phone")) {
                    btnEmpezar.setTextSize(18);
                    checkTipo.setTextSize(18);
                    checkClase.setTextSize(18);
                    checkFormula.setTextSize(18);
                    checkSistema.setTextSize(18);
                    checkAmbientes.setTextSize(18);
                    checkHabito.setTextSize(18);
                    checkColor.setTextSize(18);
                    checkDiafanidad.setTextSize(18);
                    checkBrillo.setTextSize(18);
                    checkRaya.setTextSize(18);
                    checkDureza.setTextSize(18);
                    checkDensidad.setTextSize(18);
                    checkExfoliacion.setTextSize(18);
                    checkSilicatos.setTextSize(18);
                    checkNoSilicatos.setTextSize(18);
                } else if (isTablet.equals("Tablet7")) {
                    btnEmpezar.setTextSize(24);
                    checkTipo.setTextSize(24);
                    checkClase.setTextSize(24);
                    checkFormula.setTextSize(24);
                    checkSistema.setTextSize(24);
                    checkAmbientes.setTextSize(24);
                    checkHabito.setTextSize(24);
                    checkColor.setTextSize(24);
                    checkDiafanidad.setTextSize(24);
                    checkBrillo.setTextSize(24);
                    checkRaya.setTextSize(24);
                    checkDureza.setTextSize(24);
                    checkDensidad.setTextSize(24);
                    checkExfoliacion.setTextSize(24);
                    checkSilicatos.setTextSize(24);
                    checkNoSilicatos.setTextSize(24);
                } else {
                    btnEmpezar.setTextSize(28);
                    checkTipo.setTextSize(28);
                    checkClase.setTextSize(28);
                    checkFormula.setTextSize(28);
                    checkSistema.setTextSize(28);
                    checkAmbientes.setTextSize(28);
                    checkHabito.setTextSize(28);
                    checkColor.setTextSize(28);
                    checkDiafanidad.setTextSize(28);
                    checkBrillo.setTextSize(28);
                    checkRaya.setTextSize(28);
                    checkDureza.setTextSize(28);
                    checkDensidad.setTextSize(28);
                    checkExfoliacion.setTextSize(28);
                    checkSilicatos.setTextSize(28);
                    checkNoSilicatos.setTextSize(28);
                }
                break;
            case "big":
                if (isTablet.equals("Phone")) {
                    btnEmpezar.setTextSize(16);
                    checkTipo.setTextSize(16);
                    checkClase.setTextSize(16);
                    checkFormula.setTextSize(16);
                    checkSistema.setTextSize(16);
                    checkAmbientes.setTextSize(16);
                    checkHabito.setTextSize(16);
                    checkColor.setTextSize(16);
                    checkDiafanidad.setTextSize(16);
                    checkBrillo.setTextSize(16);
                    checkRaya.setTextSize(16);
                    checkDureza.setTextSize(16);
                    checkDensidad.setTextSize(16);
                    checkExfoliacion.setTextSize(16);
                    checkSilicatos.setTextSize(16);
                    checkNoSilicatos.setTextSize(16);
                } else if (isTablet.equals("Tablet7")) {
                    btnEmpezar.setTextSize(22);
                    checkTipo.setTextSize(22);
                    checkClase.setTextSize(22);
                    checkFormula.setTextSize(22);
                    checkSistema.setTextSize(22);
                    checkAmbientes.setTextSize(22);
                    checkHabito.setTextSize(22);
                    checkColor.setTextSize(22);
                    checkDiafanidad.setTextSize(22);
                    checkBrillo.setTextSize(22);
                    checkRaya.setTextSize(22);
                    checkDureza.setTextSize(22);
                    checkDensidad.setTextSize(22);
                    checkExfoliacion.setTextSize(22);
                    checkSilicatos.setTextSize(22);
                    checkNoSilicatos.setTextSize(22);
                } else {
                    btnEmpezar.setTextSize(26);
                    checkTipo.setTextSize(26);
                    checkClase.setTextSize(26);
                    checkFormula.setTextSize(26);
                    checkSistema.setTextSize(26);
                    checkAmbientes.setTextSize(26);
                    checkHabito.setTextSize(26);
                    checkColor.setTextSize(26);
                    checkDiafanidad.setTextSize(26);
                    checkBrillo.setTextSize(26);
                    checkRaya.setTextSize(26);
                    checkDureza.setTextSize(26);
                    checkDensidad.setTextSize(26);
                    checkExfoliacion.setTextSize(26);
                    checkSilicatos.setTextSize(26);
                    checkNoSilicatos.setTextSize(26);
                }
                break;
            case "medium":
                if (isTablet.equals("Phone")) {
                    btnEmpezar.setTextSize(14);
                    checkTipo.setTextSize(14);
                    checkClase.setTextSize(14);
                    checkFormula.setTextSize(14);
                    checkSistema.setTextSize(14);
                    checkAmbientes.setTextSize(14);
                    checkHabito.setTextSize(14);
                    checkColor.setTextSize(14);
                    checkDiafanidad.setTextSize(14);
                    checkBrillo.setTextSize(14);
                    checkRaya.setTextSize(14);
                    checkDureza.setTextSize(14);
                    checkDensidad.setTextSize(14);
                    checkExfoliacion.setTextSize(14);
                    checkSilicatos.setTextSize(14);
                    checkNoSilicatos.setTextSize(14);
                } else if (isTablet.equals("Tablet7")) {
                    btnEmpezar.setTextSize(20);
                    checkTipo.setTextSize(20);
                    checkClase.setTextSize(20);
                    checkFormula.setTextSize(20);
                    checkSistema.setTextSize(20);
                    checkAmbientes.setTextSize(20);
                    checkHabito.setTextSize(20);
                    checkColor.setTextSize(20);
                    checkDiafanidad.setTextSize(20);
                    checkBrillo.setTextSize(20);
                    checkRaya.setTextSize(20);
                    checkDureza.setTextSize(20);
                    checkDensidad.setTextSize(20);
                    checkExfoliacion.setTextSize(20);
                    checkSilicatos.setTextSize(20);
                    checkNoSilicatos.setTextSize(20);
                } else {
                    btnEmpezar.setTextSize(24);
                    checkTipo.setTextSize(24);
                    checkClase.setTextSize(24);
                    checkFormula.setTextSize(24);
                    checkSistema.setTextSize(24);
                    checkAmbientes.setTextSize(24);
                    checkHabito.setTextSize(24);
                    checkColor.setTextSize(24);
                    checkDiafanidad.setTextSize(24);
                    checkBrillo.setTextSize(24);
                    checkRaya.setTextSize(24);
                    checkDureza.setTextSize(24);
                    checkDensidad.setTextSize(24);
                    checkExfoliacion.setTextSize(24);
                    checkSilicatos.setTextSize(24);
                    checkNoSilicatos.setTextSize(24);
                }
                break;
            case "small":
                if (isTablet.equals("Phone")) {
                    btnEmpezar.setTextSize(12);
                    checkTipo.setTextSize(12);
                    checkClase.setTextSize(12);
                    checkFormula.setTextSize(12);
                    checkSistema.setTextSize(12);
                    checkAmbientes.setTextSize(12);
                    checkHabito.setTextSize(12);
                    checkColor.setTextSize(12);
                    checkDiafanidad.setTextSize(12);
                    checkBrillo.setTextSize(12);
                    checkRaya.setTextSize(12);
                    checkDureza.setTextSize(12);
                    checkDensidad.setTextSize(12);
                    checkExfoliacion.setTextSize(12);
                    checkSilicatos.setTextSize(12);
                    checkNoSilicatos.setTextSize(12);
                } else if (isTablet.equals("Tablet7")) {
                    btnEmpezar.setTextSize(18);
                    checkTipo.setTextSize(18);
                    checkClase.setTextSize(18);
                    checkFormula.setTextSize(18);
                    checkSistema.setTextSize(18);
                    checkAmbientes.setTextSize(18);
                    checkHabito.setTextSize(18);
                    checkColor.setTextSize(18);
                    checkDiafanidad.setTextSize(18);
                    checkBrillo.setTextSize(18);
                    checkRaya.setTextSize(18);
                    checkDureza.setTextSize(18);
                    checkDensidad.setTextSize(18);
                    checkExfoliacion.setTextSize(18);
                    checkSilicatos.setTextSize(18);
                    checkNoSilicatos.setTextSize(18);
                } else {
                    btnEmpezar.setTextSize(22);
                    checkTipo.setTextSize(22);
                    checkClase.setTextSize(22);
                    checkFormula.setTextSize(22);
                    checkSistema.setTextSize(22);
                    checkAmbientes.setTextSize(22);
                    checkHabito.setTextSize(22);
                    checkColor.setTextSize(22);
                    checkDiafanidad.setTextSize(22);
                    checkBrillo.setTextSize(22);
                    checkRaya.setTextSize(22);
                    checkDureza.setTextSize(22);
                    checkDensidad.setTextSize(22);
                    checkExfoliacion.setTextSize(22);
                    checkSilicatos.setTextSize(22);
                    checkNoSilicatos.setTextSize(22);
                }
                break;
            default:
                if (isTablet.equals("Phone")) {
                    btnEmpezar.setTextSize(10);
                    checkTipo.setTextSize(10);
                    checkClase.setTextSize(10);
                    checkFormula.setTextSize(10);
                    checkSistema.setTextSize(10);
                    checkAmbientes.setTextSize(10);
                    checkHabito.setTextSize(10);
                    checkColor.setTextSize(10);
                    checkDiafanidad.setTextSize(10);
                    checkBrillo.setTextSize(10);
                    checkRaya.setTextSize(10);
                    checkDureza.setTextSize(10);
                    checkDensidad.setTextSize(10);
                    checkExfoliacion.setTextSize(10);
                    checkSilicatos.setTextSize(10);
                    checkNoSilicatos.setTextSize(10);
                } else if (isTablet.equals("Tablet7")) {
                    btnEmpezar.setTextSize(16);
                    checkTipo.setTextSize(16);
                    checkClase.setTextSize(16);
                    checkFormula.setTextSize(16);
                    checkSistema.setTextSize(16);
                    checkAmbientes.setTextSize(16);
                    checkHabito.setTextSize(16);
                    checkColor.setTextSize(16);
                    checkDiafanidad.setTextSize(16);
                    checkBrillo.setTextSize(16);
                    checkRaya.setTextSize(16);
                    checkDureza.setTextSize(16);
                    checkDensidad.setTextSize(16);
                    checkExfoliacion.setTextSize(16);
                    checkSilicatos.setTextSize(16);
                    checkNoSilicatos.setTextSize(16);
                } else {
                    btnEmpezar.setTextSize(20);
                    checkTipo.setTextSize(20);
                    checkClase.setTextSize(20);
                    checkFormula.setTextSize(20);
                    checkSistema.setTextSize(20);
                    checkAmbientes.setTextSize(20);
                    checkHabito.setTextSize(20);
                    checkColor.setTextSize(20);
                    checkDiafanidad.setTextSize(20);
                    checkBrillo.setTextSize(20);
                    checkRaya.setTextSize(20);
                    checkDureza.setTextSize(20);
                    checkDensidad.setTextSize(20);
                    checkExfoliacion.setTextSize(20);
                    checkSilicatos.setTextSize(20);
                    checkNoSilicatos.setTextSize(20);
                }
                break;
        }
        tipo = false;
        clase = false;
        formula = false;
        sistema = false;
        ambientes = false;
        habito = false;
        color = false;
        diafanidad = false;
        brillo = false;
        raya = false;
        dureza = false;
        densidad = false;
        exfoliacion = false;
        silicatos = false;
        nosilicatos = false;
        btnEmpezar.setTextColor(getResources().getColor(R.color.black));
        switch (theme) {
            case "light":
                btnEmpezar.setBackground(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.redondeo_light));
                btnEmpezar.setTextColor(getResources().getColor(R.color.black));
                break;
            case "darck":
                btnEmpezar.setBackground(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.redondeo_darck));
                btnEmpezar.setTextColor(getResources().getColor(R.color.white));
                break;
            case "green":
                btnEmpezar.setBackground(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.redondeo_green));
                btnEmpezar.setTextColor(getResources().getColor(R.color.white));
                break;
            default:
                btnEmpezar.setBackground(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.redondeo_blue));
                btnEmpezar.setTextColor(getResources().getColor(R.color.white));
                break;
        }
        btnEmpezar.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), QuizGame.class);
            tipo = checkTipo.isChecked();
            clase = checkClase.isChecked();
            formula = checkFormula.isChecked();
            sistema = checkSistema.isChecked();
            ambientes = checkAmbientes.isChecked();
            habito = checkHabito.isChecked();
            color = checkColor.isChecked();
            diafanidad = checkDiafanidad.isChecked();
            brillo = checkBrillo.isChecked();
            raya = checkRaya.isChecked();
            dureza = checkDureza.isChecked();
            densidad = checkDensidad.isChecked();
            exfoliacion = checkExfoliacion.isChecked();
            silicatos = checkSilicatos.isChecked();
            nosilicatos = checkNoSilicatos.isChecked();

            intent.putExtra("tipo", tipo );
            intent.putExtra("clase", clase );
            intent.putExtra("formula", formula );
            intent.putExtra("sistema", sistema );
            intent.putExtra("ambientes", ambientes );
            intent.putExtra("habito", habito );
            intent.putExtra("color", color );
            intent.putExtra("diafanidad", diafanidad );
            intent.putExtra("brillo", brillo );
            intent.putExtra("raya", raya );
            intent.putExtra("dureza", dureza );
            intent.putExtra("densidad", densidad );
            intent.putExtra("exfoliacion", exfoliacion );
            intent.putExtra("silicatos", silicatos );
            intent.putExtra("nosilicatos", nosilicatos );

            if (!checkTipo.isChecked()&&!checkClase.isChecked()&&!checkFormula.isChecked()&&!checkSistema.isChecked()&&!checkAmbientes.isChecked()&&!checkHabito.isChecked()&&!checkColor.isChecked()&&!checkDiafanidad.isChecked()&&!checkBrillo.isChecked()&&!checkRaya.isChecked()&&!checkDureza.isChecked()&&!checkDensidad.isChecked()&&!checkExfoliacion.isChecked()) {
                Toast toast = Toast.makeText(getActivity(), this.getString(R.string.seleccione_un_tipo_de_pregunta), Toast.LENGTH_SHORT);
                toast.show();
            } else if (!checkSilicatos.isChecked()&&!checkNoSilicatos.isChecked()) {
                Toast toast = Toast.makeText(getActivity(), this.getString(R.string.seleccione_un_grupo), Toast.LENGTH_SHORT);
                toast.show();
            } else if (checkSilicatos.isChecked()&&!checkNoSilicatos.isChecked()&&checkTipo.isChecked()) {
                Toast toast = Toast.makeText(getActivity(), this.getString(R.string.no_se_puede_examinar_de_un_solo_tipo), Toast.LENGTH_SHORT);
                toast.show();
            } else if (!checkSilicatos.isChecked()&&checkNoSilicatos.isChecked()&&checkTipo.isChecked()) {
                Toast toast = Toast.makeText(getActivity(), this.getString(R.string.no_se_puede_examinar_de_un_solo_tipo), Toast.LENGTH_SHORT);
                toast.show();
            } else {
                startActivity(intent);
            }
        });
        //Button btnLogin = binding.btnLogin;
        //btnLogin.setOnClickListener(view -> signIn());
        return root;
    }
    /*private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, get user's Google ID
            String googleId = account.getId();
            String email = account.getEmail();
            Toast.makeText(getActivity(), "Email: " + email, Toast.LENGTH_LONG).show();
            Log.i("email",email);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            e.printStackTrace();
        }
    }*/
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
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onResume() {
        super.onResume();
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}