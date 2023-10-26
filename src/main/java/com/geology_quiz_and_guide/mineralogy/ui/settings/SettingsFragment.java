package com.geology_quiz_and_guide.mineralogy.ui.settings;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.geology_quiz_and_guide.mineralogy.MainActivity;
import com.geology_quiz_and_guide.mineralogy.R;
import com.geology_quiz_and_guide.mineralogy.databinding.FragmentSettingsBinding;
import java.util.Locale;

public class SettingsFragment extends Fragment {
    private FragmentSettingsBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor myEdit;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        sharedPreferences = getActivity().getSharedPreferences("UserPreferences", MODE_PRIVATE);
        myEdit = sharedPreferences.edit();
        String theme = sharedPreferences.getString("theme", "light");
        String sizeText = sharedPreferences.getString("sizeText", "medium");
        String language = sharedPreferences.getString("language", Locale.getDefault().getLanguage());
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config,
                getActivity().getBaseContext().getResources().getDisplayMetrics());
        final ScrollView screen = binding.screen;
        final RadioButton rbDarck = binding.rbDarck;
        final RadioButton rbLight = binding.rbLight;
        final RadioButton rbGreen = binding.rbGreen;
        final RadioButton rbBlue = binding.rbBlue;
        final RadioButton rbVeryBig = binding.rbVeryBig;
        final RadioButton rbBig = binding.rbBig;
        final RadioButton rbMedium = binding.rbMedium;
        final RadioButton rbSmall = binding.rbSmall;
        final RadioButton rbVerySmall = binding.rbVerySmall;

        final TextView txtSettings = binding.settings;
        final TextView txtLanguaje = binding.languaje;
        final TextView txtTheme = binding.theme;
        final TextView txtTextSize = binding.textSize;
        final TextView txtPrivacy = binding.privacyPolicy;
        final TextView txtContact = binding.contact;

        String isTablet = isTablet(getActivity());

        if (theme.equals("darck")) {
            txtSettings.setTextColor(getResources().getColor(R.color.white));
            txtTheme.setTextColor(getResources().getColor(R.color.white));
            txtTextSize.setTextColor(getResources().getColor(R.color.white));
            txtLanguaje.setTextColor(getResources().getColor(R.color.white));
            rbDarck.setTextColor(getResources().getColor(R.color.white));
            rbLight.setTextColor(getResources().getColor(R.color.white));
            rbGreen.setTextColor(getResources().getColor(R.color.white));
            rbBlue.setTextColor(getResources().getColor(R.color.white));
            rbVeryBig.setTextColor(getResources().getColor(R.color.white));
            rbBig.setTextColor(getResources().getColor(R.color.white));
            rbMedium.setTextColor(getResources().getColor(R.color.white));
            rbSmall.setTextColor(getResources().getColor(R.color.white));
            rbVerySmall.setTextColor(getResources().getColor(R.color.white));
            txtPrivacy.setTextColor(getResources().getColor(R.color.white));
            txtContact.setTextColor(getResources().getColor(R.color.white));
        } else {
            txtSettings.setTextColor(getResources().getColor(R.color.black));
            txtTheme.setTextColor(getResources().getColor(R.color.black));
            txtTextSize.setTextColor(getResources().getColor(R.color.black));
            txtLanguaje.setTextColor(getResources().getColor(R.color.black));
            rbDarck.setTextColor(getResources().getColor(R.color.black));
            rbLight.setTextColor(getResources().getColor(R.color.black));
            rbGreen.setTextColor(getResources().getColor(R.color.black));
            rbBlue.setTextColor(getResources().getColor(R.color.black));
            rbVeryBig.setTextColor(getResources().getColor(R.color.black));
            rbBig.setTextColor(getResources().getColor(R.color.black));
            rbMedium.setTextColor(getResources().getColor(R.color.black));
            rbSmall.setTextColor(getResources().getColor(R.color.black));
            rbVerySmall.setTextColor(getResources().getColor(R.color.black));
            txtPrivacy.setTextColor(getResources().getColor(R.color.black));
            txtContact.setTextColor(getResources().getColor(R.color.black));
        }
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
            default:
                screen.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
        }
        switch (sizeText) {
            case "very big":
                if (isTablet.equals("Phone")) {
                    txtSettings.setTextSize(26);
                    txtTheme.setTextSize(22);
                    txtLanguaje.setTextSize(22);
                    txtTextSize.setTextSize(22);
                    rbDarck.setTextSize(18);
                    rbLight.setTextSize(18);
                    rbGreen.setTextSize(18);
                    rbBlue.setTextSize(18);
                    rbVeryBig.setTextSize(18);
                    rbBig.setTextSize(18);
                    rbMedium.setTextSize(18);
                    rbSmall.setTextSize(18);
                    rbVerySmall.setTextSize(18);
                    txtPrivacy.setTextSize(18);
                    txtContact.setTextSize(18);
                } else if (isTablet.equals("Tablet7")) {
                    txtSettings.setTextSize(32);
                    txtTheme.setTextSize(28);
                    txtLanguaje.setTextSize(28);
                    txtTextSize.setTextSize(28);
                    rbDarck.setTextSize(24);
                    rbLight.setTextSize(24);
                    rbGreen.setTextSize(24);
                    rbBlue.setTextSize(24);
                    rbVeryBig.setTextSize(20);
                    rbBig.setTextSize(24);
                    rbMedium.setTextSize(24);
                    rbSmall.setTextSize(24);
                    rbVerySmall.setTextSize(24);
                    txtPrivacy.setTextSize(24);
                    txtContact.setTextSize(24);
                } else {
                    txtSettings.setTextSize(36);
                    txtTheme.setTextSize(32);
                    txtLanguaje.setTextSize(32);
                    txtTextSize.setTextSize(32);
                    rbDarck.setTextSize(28);
                    rbLight.setTextSize(28);
                    rbGreen.setTextSize(28);
                    rbBlue.setTextSize(28);
                    rbVeryBig.setTextSize(28);
                    rbBig.setTextSize(28);
                    rbMedium.setTextSize(28);
                    rbSmall.setTextSize(28);
                    rbVerySmall.setTextSize(28);
                    txtPrivacy.setTextSize(28);
                    txtContact.setTextSize(28);
                }
                break;
            case "big":
                if (isTablet.equals("Phone")) {
                    txtSettings.setTextSize(24);
                    txtTheme.setTextSize(20);
                    txtLanguaje.setTextSize(20);
                    txtTextSize.setTextSize(20);
                    rbDarck.setTextSize(16);
                    rbLight.setTextSize(16);
                    rbGreen.setTextSize(16);
                    rbBlue.setTextSize(16);
                    rbVeryBig.setTextSize(16);
                    rbBig.setTextSize(16);
                    rbMedium.setTextSize(16);
                    rbSmall.setTextSize(16);
                    rbVerySmall.setTextSize(16);
                    txtPrivacy.setTextSize(16);
                    txtContact.setTextSize(16);
                } else if (isTablet.equals("Tablet7")) {
                    txtSettings.setTextSize(30);
                    txtTheme.setTextSize(26);
                    txtLanguaje.setTextSize(26);
                    txtTextSize.setTextSize(26);
                    rbDarck.setTextSize(22);
                    rbLight.setTextSize(22);
                    rbGreen.setTextSize(22);
                    rbBlue.setTextSize(22);
                    rbVeryBig.setTextSize(22);
                    rbBig.setTextSize(22);
                    rbMedium.setTextSize(22);
                    rbSmall.setTextSize(22);
                    rbVerySmall.setTextSize(22);
                    txtPrivacy.setTextSize(22);
                    txtContact.setTextSize(22);
                } else {
                    txtSettings.setTextSize(34);
                    txtTheme.setTextSize(30);
                    txtLanguaje.setTextSize(30);
                    txtTextSize.setTextSize(30);
                    rbDarck.setTextSize(26);
                    rbLight.setTextSize(26);
                    rbGreen.setTextSize(26);
                    rbBlue.setTextSize(26);
                    rbVeryBig.setTextSize(26);
                    rbBig.setTextSize(26);
                    rbMedium.setTextSize(26);
                    rbSmall.setTextSize(26);
                    rbVerySmall.setTextSize(26);
                    txtPrivacy.setTextSize(26);
                    txtContact.setTextSize(26);
                }
                break;
            case "medium":
                if (isTablet.equals("Phone")) {
                    txtSettings.setTextSize(22);
                    txtTheme.setTextSize(18);
                    txtLanguaje.setTextSize(18);
                    txtTextSize.setTextSize(18);
                    rbDarck.setTextSize(14);
                    rbLight.setTextSize(14);
                    rbGreen.setTextSize(14);
                    rbBlue.setTextSize(14);
                    rbVeryBig.setTextSize(14);
                    rbBig.setTextSize(14);
                    rbMedium.setTextSize(14);
                    rbSmall.setTextSize(14);
                    rbVerySmall.setTextSize(14);
                    txtPrivacy.setTextSize(14);
                    txtContact.setTextSize(14);
                } else if (isTablet.equals("Tablet7")) {
                    txtSettings.setTextSize(28);
                    txtTheme.setTextSize(24);
                    txtLanguaje.setTextSize(24);
                    txtTextSize.setTextSize(24);
                    rbDarck.setTextSize(20);
                    rbLight.setTextSize(20);
                    rbGreen.setTextSize(20);
                    rbBlue.setTextSize(20);
                    rbVeryBig.setTextSize(20);
                    rbBig.setTextSize(20);
                    rbMedium.setTextSize(20);
                    rbSmall.setTextSize(20);
                    rbVerySmall.setTextSize(20);
                    txtPrivacy.setTextSize(20);
                    txtContact.setTextSize(20);
                } else {
                    txtSettings.setTextSize(32);
                    txtTheme.setTextSize(28);
                    txtLanguaje.setTextSize(28);
                    txtTextSize.setTextSize(28);
                    rbDarck.setTextSize(24);
                    rbLight.setTextSize(24);
                    rbGreen.setTextSize(24);
                    rbBlue.setTextSize(24);
                    rbVeryBig.setTextSize(24);
                    rbBig.setTextSize(24);
                    rbMedium.setTextSize(24);
                    rbSmall.setTextSize(24);
                    rbVerySmall.setTextSize(24);
                    txtPrivacy.setTextSize(24);
                    txtContact.setTextSize(24);
                }
                break;
            case "small":
                if (isTablet.equals("Phone")) {
                    txtSettings.setTextSize(20);
                    txtTheme.setTextSize(16);
                    txtLanguaje.setTextSize(16);
                    txtTextSize.setTextSize(16);
                    rbDarck.setTextSize(12);
                    rbLight.setTextSize(12);
                    rbGreen.setTextSize(12);
                    rbBlue.setTextSize(12);
                    rbVeryBig.setTextSize(12);
                    rbBig.setTextSize(12);
                    rbMedium.setTextSize(12);
                    rbSmall.setTextSize(12);
                    rbVerySmall.setTextSize(12);
                    txtPrivacy.setTextSize(12);
                    txtContact.setTextSize(12);
                } else if (isTablet.equals("Tablet7")) {
                    txtSettings.setTextSize(26);
                    txtTheme.setTextSize(22);
                    txtLanguaje.setTextSize(22);
                    txtTextSize.setTextSize(22);
                    rbDarck.setTextSize(18);
                    rbLight.setTextSize(18);
                    rbGreen.setTextSize(18);
                    rbBlue.setTextSize(18);
                    rbVeryBig.setTextSize(18);
                    rbBig.setTextSize(18);
                    rbMedium.setTextSize(18);
                    rbSmall.setTextSize(18);
                    rbVerySmall.setTextSize(18);
                    txtPrivacy.setTextSize(18);
                    txtContact.setTextSize(18);
                } else {
                    txtSettings.setTextSize(30);
                    txtTheme.setTextSize(26);
                    txtLanguaje.setTextSize(26);
                    txtTextSize.setTextSize(26);
                    rbDarck.setTextSize(22);
                    rbLight.setTextSize(22);
                    rbGreen.setTextSize(22);
                    rbBlue.setTextSize(22);
                    rbVeryBig.setTextSize(22);
                    rbBig.setTextSize(22);
                    rbMedium.setTextSize(22);
                    rbSmall.setTextSize(22);
                    rbVerySmall.setTextSize(22);
                    txtPrivacy.setTextSize(22);
                    txtContact.setTextSize(22);
                }
                break;
            default:
                if (isTablet.equals("Phone")) {
                    txtSettings.setTextSize(18);
                    txtTheme.setTextSize(14);
                    txtLanguaje.setTextSize(14);
                    txtTextSize.setTextSize(14);
                    rbDarck.setTextSize(10);
                    rbLight.setTextSize(10);
                    rbGreen.setTextSize(10);
                    rbBlue.setTextSize(10);
                    rbVeryBig.setTextSize(10);
                    rbBig.setTextSize(10);
                    rbMedium.setTextSize(10);
                    rbSmall.setTextSize(10);
                    rbVerySmall.setTextSize(10);
                    txtPrivacy.setTextSize(10);
                    txtContact.setTextSize(10);
                } else if (isTablet.equals("Tablet7")) {
                    txtSettings.setTextSize(24);
                    txtTheme.setTextSize(20);
                    txtLanguaje.setTextSize(20);
                    txtTextSize.setTextSize(20);
                    rbDarck.setTextSize(16);
                    rbLight.setTextSize(16);
                    rbGreen.setTextSize(16);
                    rbBlue.setTextSize(16);
                    rbVeryBig.setTextSize(16);
                    rbBig.setTextSize(16);
                    rbMedium.setTextSize(16);
                    rbSmall.setTextSize(16);
                    rbVerySmall.setTextSize(16);
                    txtPrivacy.setTextSize(16);
                    txtContact.setTextSize(16);
                } else {
                    txtSettings.setTextSize(28);
                    txtTheme.setTextSize(24);
                    txtLanguaje.setTextSize(24);
                    txtTextSize.setTextSize(24);
                    rbDarck.setTextSize(20);
                    rbLight.setTextSize(20);
                    rbGreen.setTextSize(20);
                    rbBlue.setTextSize(20);
                    rbVeryBig.setTextSize(20);
                    rbBig.setTextSize(20);
                    rbMedium.setTextSize(20);
                    rbSmall.setTextSize(20);
                    rbVerySmall.setTextSize(20);
                    txtPrivacy.setTextSize(20);
                    txtContact.setTextSize(20);
                }
                break;
        }
        Spinner spinnerLanguage = binding.spinnerLanguage;
        ArrayAdapter<String> adapter0 = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.array_language));
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(adapter0);
        /*spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                if (position == 0) {
                    myEdit.putString("language", "en");
                    myEdit.apply();
                    String languageToLoad2  = "en"; // your language
                    Locale locale2 = new Locale(languageToLoad2);
                    Locale.setDefault(locale2);
                    Configuration config2 = new Configuration();
                    config2.locale = locale2;
                    getActivity().getBaseContext().getResources().updateConfiguration(config2,
                            getActivity().getBaseContext().getResources().getDisplayMetrics());
                } else if (position == 1){
                    myEdit.putString("language", "fr");
                    myEdit.apply();
                    String languageToLoad2  = "fr"; // your language
                    Locale locale2 = new Locale(languageToLoad2);
                    Locale.setDefault(locale2);
                    Configuration config2 = new Configuration();
                    config2.locale = locale2;
                    getActivity().getBaseContext().getResources().updateConfiguration(config2,
                            getActivity().getBaseContext().getResources().getDisplayMetrics());
                }
                else if (position == 2) {
                    myEdit.putString("language", "es");
                    myEdit.apply();
                    String languageToLoad3  = "es"; // your language
                    Locale locale3 = new Locale(languageToLoad3);
                    Locale.setDefault(locale3);
                    Configuration config3 = new Configuration();
                    config.locale = locale3;
                    getActivity().getBaseContext().getResources().updateConfiguration(config3,
                            getActivity().getBaseContext().getResources().getDisplayMetrics());
                } else if (position == 3) {
                    myEdit.putString("language", "ca");
                    myEdit.apply();
                    String languageToLoad3  = "ca"; // your language
                    Locale locale3 = new Locale(languageToLoad3);
                    Locale.setDefault(locale3);
                    Configuration config3 = new Configuration();
                    config.locale = locale3;
                    getActivity().getBaseContext().getResources().updateConfiguration(config3,
                            getActivity().getBaseContext().getResources().getDisplayMetrics());
                } else if (position == 4) {
                    myEdit.putString("language", "ru");
                    myEdit.apply();
                    String languageToLoad3  = "ru"; // your language
                    Locale locale3 = new Locale(languageToLoad3);
                    Locale.setDefault(locale3);
                    Configuration config3 = new Configuration();
                    config.locale = locale3;
                    getActivity().getBaseContext().getResources().updateConfiguration(config3,
                            getActivity().getBaseContext().getResources().getDisplayMetrics());
                } else if (position == 5) {
                    myEdit.putString("language", "ar");
                    myEdit.apply();
                    String languageToLoad3  = "ar"; // your language
                    Locale locale3 = new Locale(languageToLoad3);
                    Locale.setDefault(locale3);
                    Configuration config3 = new Configuration();
                    config.locale = locale3;
                    getActivity().getBaseContext().getResources().updateConfiguration(config3,
                            getActivity().getBaseContext().getResources().getDisplayMetrics());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });*/
        Button btnLanguage = binding.btnLanguage;
        switch (theme) {
            case "darck":
                btnLanguage.setBackgroundResource(R.drawable.redondeo_darck);
                break;
            case "light":
                btnLanguage.setBackgroundResource(R.drawable.redondeo_light);
                break;
            case "green":
                btnLanguage.setBackgroundResource(R.drawable.redondeo_green);
                break;
            case "blue":
                btnLanguage.setBackgroundResource(R.drawable.redondeo_blue);
                break;
        }
         btnLanguage.setOnClickListener(v -> {
            int posicion = spinnerLanguage.getSelectedItemPosition();
            if (posicion==0) {
                myEdit.putString("language", "en");
                myEdit.apply();
            } else if (posicion==1) {
                 myEdit.putString("language", "fr");
                 myEdit.apply();
             } else if (posicion==2) {
                 myEdit.putString("language", "es");
                 myEdit.apply();
             } else if (posicion==3) {
                 myEdit.putString("language", "ca");
                 myEdit.apply();
             } else if (posicion==4) {
                 myEdit.putString("language", "ru");
                 myEdit.apply();
             } else {
                 myEdit.putString("language", "ar");
                 myEdit.apply();
             }
            Intent refresh = new Intent(getActivity(), MainActivity.class);
            startActivity(refresh);
            getActivity().getFragmentManager().popBackStack();
        });
        switch (language) {
            case "en":
                spinnerLanguage.setSelection(0);
                break;
            case "fr":
                spinnerLanguage.setSelection(1);
                break;
            case "es":
                spinnerLanguage.setSelection(2);
                break;
            case "ca":
                spinnerLanguage.setSelection(3);
                break;
            case "ru":
                spinnerLanguage.setSelection(4);
                break;
            case "ar":
                spinnerLanguage.setSelection(5);
                break;

        }
        switch (theme) {
            case "darck":
                rbDarck.setChecked(true);
                break;
            case "light":
                rbLight.setChecked(true);
                break;
            case "green":
                rbGreen.setChecked(true);
                break;
            case "blue":
                rbBlue.setChecked(true);
                break;
        }
        rbDarck.setOnClickListener(v -> {
            myEdit.putString("theme", "darck");
            myEdit.apply();
            refreshFragment();
        });
        rbLight.setOnClickListener(v -> {
            myEdit.putString("theme", "light");
            myEdit.apply();
            refreshFragment();
        });
        rbGreen.setOnClickListener(v -> {
            myEdit.putString("theme", "green");
            myEdit.apply();
            refreshFragment();
        });
        rbBlue.setOnClickListener(v -> {
            myEdit.putString("theme", "blue");
            myEdit.apply();
            refreshFragment();
        });
        switch (sizeText) {
            case "very big":
                rbVeryBig.setChecked(true);
                break;
            case "big":
                rbBig.setChecked(true);
                break;
            case "medium":
                rbMedium.setChecked(true);
                break;
            case "small":
                rbSmall.setChecked(true);
                break;
            case "very small":
                rbVerySmall.setChecked(true);
                break;
        }
        rbVeryBig.setOnClickListener(v -> {
            myEdit.putString("sizeText", "very big");
            myEdit.apply();
            refreshFragment();
        });
        rbBig.setOnClickListener(v -> {
            myEdit.putString("sizeText", "big");
            myEdit.apply();
            refreshFragment();
        });
        rbMedium.setOnClickListener(v -> {
            myEdit.putString("sizeText", "medium");
            myEdit.apply();
            refreshFragment();
        });
        rbSmall.setOnClickListener(v -> {
            myEdit.putString("sizeText", "small");
            myEdit.apply();
            refreshFragment();
        });
        rbVerySmall.setOnClickListener(v -> {
            myEdit.putString("sizeText", "very small");
            myEdit.apply();
            refreshFragment();
        });
        /*userTXTView.setText(nick);
        linearUser.setOnClickListener(v -> {
            MaterialAlertDialogBuilder alert = null;
            switch (theme) {
                case "darck":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_darck_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_darck_tablet);
                    }
                    break;
                case "light":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_light_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_light_tablet);
                    }
                    break;
                case "green":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_green_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_green_tablet);
                    }
                    break;
                case "blue":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_blue_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_blue_tablet);
                    }
                    break;
            }
            final EditText editUser = new EditText(getActivity());
            if (theme.equals("light")) {
                editUser.setTextColor(getResources().getColor(R.color.black));
            } else {
                editUser.setTextColor(getResources().getColor(R.color.white));
            }
            InputFilter[] FilterArray = new InputFilter[1];
            FilterArray[0] = new InputFilter.LengthFilter(15);
            editUser.setFilters(FilterArray);
            alert.setView(editUser);
            alert.setTitle(getString(R.string.titulo_user));
            alert.setMessage(R.string.insert_user);

            alert.setPositiveButton(R.string.accept,
                    (dialog, which) -> {
                        final String userNick = editUser.getText().toString();
                        myEdit.putString("nick", userNick);
                        myEdit.apply();
                        userTXTView.setText(userNick);
                    });
            alert.setNegativeButton(R.string.cancel,
                    (dialog, which) -> dialog.cancel());
            alert.show();
        });*/
        /*chckSettings.setChecked(stats);
        chckSettings.setOnClickListener(v -> {
            if (chckSettings.isChecked()) {
                myEdit.putBoolean("stats", true);
                myEdit.apply();
            } else {
                myEdit.putBoolean("stats", false);
                myEdit.apply();
            }
        });*/
        /*chckServer.setChecked(server);
        chckServer.setOnClickListener(v -> {
            if (chckServer.isChecked()) {
                myEdit.putBoolean("server", true);
                myEdit.apply();
            } else {
                myEdit.putBoolean("server", false);
                myEdit.apply();
            }
        });
        txtWhatSettings.setOnClickListener(v -> {
            MaterialAlertDialogBuilder alert = null;
            switch (theme) {
                case "darck":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_darck_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_darck_tablet);
                    }
                    break;
                case "light":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_light_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_light_tablet);
                    }
                    break;
                case "green":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_green_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_green_tablet);
                    }
                    break;
                case "blue":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_blue_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_blue_tablet);
                    }
                    break;
            }
            alert.setMessage(R.string.what_settings);
            alert.setPositiveButton(R.string.accept,
                    (dialog, which) -> {
                        dialog.cancel();
                    });

            alert.show();
        });*/
        /*txtWhatServer.setOnClickListener(v -> {
            MaterialAlertDialogBuilder alert = null;
            switch (theme) {
                case "darck":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_darck_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_darck_tablet);
                    }
                    break;
                case "light":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_light_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_light_tablet);
                    }
                    break;
                case "green":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_green_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_green_tablet);
                    }
                    break;
                case "blue":
                    if (isTablet.equals("Phone")) {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_blue_phone);
                    } else {
                        alert = new MaterialAlertDialogBuilder(getActivity(), R.style.Dialog_blue_tablet);
                    }
                    break;
            }
            alert.setMessage(R.string.what_server);
            alert.setPositiveButton(R.string.accept,
                    (dialog, which) -> {
                        dialog.cancel();
                    });

            alert.show();
        });*/
        txtPrivacy.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://spwritefine.wordpress.com/2023/01/05/privacy-policy-mineralogy-quiz-and-guide/"));
            startActivity(browserIntent);
        });
        txtContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "quizandguide@gmail.com", null));
                startActivity(Intent.createChooser(intent, "Send email"));
            }
        });
        return root;
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
    public void refreshFragment() {
        getFragmentManager().beginTransaction().detach(this).commitNowAllowingStateLoss();
        getFragmentManager().beginTransaction().attach(this).commitAllowingStateLoss();
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