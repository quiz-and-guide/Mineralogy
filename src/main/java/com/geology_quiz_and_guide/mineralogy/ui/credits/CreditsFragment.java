package com.geology_quiz_and_guide.mineralogy.ui.credits;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.geology_quiz_and_guide.mineralogy.R;
import com.geology_quiz_and_guide.mineralogy.databinding.FragmentCreditsBinding;

import java.net.URLEncoder;
import java.util.Locale;

public class CreditsFragment extends Fragment {


    private FragmentCreditsBinding binding;
    private SharedPreferences sharedPreferences;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedPreferences = getActivity().getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String isTablet = isTablet(getActivity());
        String theme = sharedPreferences.getString("theme", "light");
        String sizeText = sharedPreferences.getString("sizeText", "medium");
        String language = sharedPreferences.getString("language", Locale.getDefault().getLanguage());
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config,
                getActivity().getBaseContext().getResources().getDisplayMetrics());
        binding = FragmentCreditsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ScrollView screen = binding.screen;
        TextView textApp = binding.app;
        TextView textAuthors = binding.authors;
        TextView textManuel1 = binding.manuel1;
        TextView textManuel2 = binding.manuel2;
        TextView textManuel3 = binding.manuel3;
        TextView textManuel4 = binding.manuel4;
        TextView textManuel5 = binding.manuel5;
        TextView textManuel6 = binding.manuel6;
        TextView textPictures = binding.pictures;
        TextView textPictures1 = binding.fotos1;
        TextView textPictures2 = binding.fotos2;
        TextView textMariajose1 = binding.mariajose1;
        TextView textMariajose2 = binding.mariajose2;
        TextView textMariajose3 = binding.mariajose3;
        TextView textMariajose4 = binding.mariajose4;
        TextView textTranslations = binding.translations;
        TextView textArabian = binding.arabian;
        TextView textRussian = binding.russian;
        TextView textCatalan = binding.catalan;
        TextView textHamid1 = binding.hamid1;
        TextView textHamid2 = binding.hamid2;
        TextView textHamid3 = binding.hamid3;
        TextView textMerce1 = binding.mercedes1;
        TextView textMerce2 = binding.mercedes2;
        TextView textRaquel1 = binding.raquel1;
        TextView textRaquel2 = binding.raquel2;
        TextView textMiquel1 = binding.miquel1;
        TextView textMiquel2 = binding.miquel2;
        TextView textZhenia1 = binding.zhenia1;
        TextView textZhenia2 = binding.zhenia2;
        TextView textZhenia3 = binding.zhenia3;
        TextView textZhenia4 = binding.zhenia4;
        TextView textMax1 = binding.max1;
        TextView textMax2 = binding.max2;
        TextView textMax3 = binding.max3;
        TextView textMax4 = binding.max4;

        switch (theme) {
            case "darck":
                screen.setBackgroundColor(getResources().getColor(R.color.white));
                textAuthors.setBackgroundColor(getResources().getColor(R.color.darck_contrast));
                textPictures.setBackgroundColor(getResources().getColor(R.color.darck_contrast));
                textTranslations.setBackgroundColor(getResources().getColor(R.color.darck_contrast));
                textAuthors.setTextColor(getResources().getColor(R.color.white));
                textPictures.setTextColor(getResources().getColor(R.color.white));
                textTranslations.setTextColor(getResources().getColor(R.color.white));
                textArabian.setBackgroundColor(getResources().getColor(R.color.darck_contrast));
                textRussian.setBackgroundColor(getResources().getColor(R.color.darck_contrast));
                textCatalan.setBackgroundColor(getResources().getColor(R.color.darck_contrast));
                textAuthors.setTextColor(getResources().getColor(R.color.white));
                textPictures.setTextColor(getResources().getColor(R.color.white));
                textTranslations.setTextColor(getResources().getColor(R.color.white));
                textArabian.setTextColor(getResources().getColor(R.color.white));
                textRussian.setTextColor(getResources().getColor(R.color.white));
                textCatalan.setTextColor(getResources().getColor(R.color.white));
                break;
            case "light":
                screen.setBackgroundColor(getResources().getColor(R.color.white));
                textAuthors.setBackgroundColor(getResources().getColor(R.color.light_contrast));
                textPictures.setBackgroundColor(getResources().getColor(R.color.light_contrast));
                textTranslations.setBackgroundColor(getResources().getColor(R.color.light_contrast));
                textArabian.setBackgroundColor(getResources().getColor(R.color.light_contrast));
                textRussian.setBackgroundColor(getResources().getColor(R.color.light_contrast));
                textCatalan.setBackgroundColor(getResources().getColor(R.color.light_contrast));
                break;
            case "green":
                screen.setBackgroundColor(getResources().getColor(R.color.white));
                textAuthors.setBackgroundColor(getResources().getColor(R.color.green_contrast));
                textPictures.setBackgroundColor(getResources().getColor(R.color.green_contrast));
                textTranslations.setBackgroundColor(getResources().getColor(R.color.green_contrast));
                textAuthors.setTextColor(getResources().getColor(R.color.white));
                textPictures.setTextColor(getResources().getColor(R.color.white));
                textTranslations.setTextColor(getResources().getColor(R.color.white));
                textArabian.setBackgroundColor(getResources().getColor(R.color.green_contrast));
                textRussian.setBackgroundColor(getResources().getColor(R.color.green_contrast));
                textCatalan.setBackgroundColor(getResources().getColor(R.color.green_contrast));
                textAuthors.setTextColor(getResources().getColor(R.color.white));
                textPictures.setTextColor(getResources().getColor(R.color.white));
                textTranslations.setTextColor(getResources().getColor(R.color.white));
                textArabian.setTextColor(getResources().getColor(R.color.white));
                textRussian.setTextColor(getResources().getColor(R.color.white));
                textCatalan.setTextColor(getResources().getColor(R.color.white));
                break;
            case "blue":
                screen.setBackgroundColor(getResources().getColor(R.color.white));
                textAuthors.setBackgroundColor(getResources().getColor(R.color.blue_contrast));
                textPictures.setBackgroundColor(getResources().getColor(R.color.blue_contrast));
                textTranslations.setBackgroundColor(getResources().getColor(R.color.blue_contrast));
                textAuthors.setTextColor(getResources().getColor(R.color.white));
                textPictures.setTextColor(getResources().getColor(R.color.white));
                textTranslations.setTextColor(getResources().getColor(R.color.white));
                textArabian.setBackgroundColor(getResources().getColor(R.color.blue_contrast));
                textRussian.setBackgroundColor(getResources().getColor(R.color.blue_contrast));
                textCatalan.setBackgroundColor(getResources().getColor(R.color.blue_contrast));
                textAuthors.setTextColor(getResources().getColor(R.color.white));
                textPictures.setTextColor(getResources().getColor(R.color.white));
                textTranslations.setTextColor(getResources().getColor(R.color.white));
                textArabian.setTextColor(getResources().getColor(R.color.white));
                textRussian.setTextColor(getResources().getColor(R.color.white));
                textCatalan.setTextColor(getResources().getColor(R.color.white));
                break;
        }

        if (theme.equals("darck")) {
            textApp.setTextColor(getResources().getColor(R.color.white));
            textManuel1.setTextColor(getResources().getColor(R.color.white));
            textManuel2.setTextColor(getResources().getColor(R.color.white));
            textManuel3.setTextColor(getResources().getColor(R.color.white));
            textManuel4.setTextColor(getResources().getColor(R.color.blue_contrast));
            textManuel5.setTextColor(getResources().getColor(R.color.blue_contrast));
            textManuel6.setTextColor(getResources().getColor(R.color.blue_contrast));
            textMariajose1.setTextColor(getResources().getColor(R.color.white));
            textMariajose2.setTextColor(getResources().getColor(R.color.white));
            textMariajose3.setTextColor(getResources().getColor(R.color.white));
            textMariajose4.setTextColor(getResources().getColor(R.color.blue_contrast));
            textPictures1.setTextColor(getResources().getColor(R.color.white));
            textPictures2.setTextColor(getResources().getColor(R.color.white));
            textHamid1.setTextColor(getResources().getColor(R.color.white));
            textHamid2.setTextColor(getResources().getColor(R.color.white));
            textHamid3.setTextColor(getResources().getColor(R.color.blue_contrast));
            textMerce1.setTextColor(getResources().getColor(R.color.white));
            textMerce2.setTextColor(getResources().getColor(R.color.white));
            textRaquel1.setTextColor(getResources().getColor(R.color.white));
            textRaquel2.setTextColor(getResources().getColor(R.color.white));
            textMiquel1.setTextColor(getResources().getColor(R.color.white));
            textMiquel2.setTextColor(getResources().getColor(R.color.white));
            textZhenia1.setTextColor(getResources().getColor(R.color.white));
            textZhenia2.setTextColor(getResources().getColor(R.color.white));
            textZhenia3.setTextColor(getResources().getColor(R.color.blue_contrast));
            textZhenia4.setTextColor(getResources().getColor(R.color.blue_contrast));
            textMax1.setTextColor(getResources().getColor(R.color.white));
            textMax2.setTextColor(getResources().getColor(R.color.white));
            textMax3.setTextColor(getResources().getColor(R.color.blue_contrast));
            textMax4.setTextColor(getResources().getColor(R.color.blue_contrast));
        } else {
            textApp.setTextColor(getResources().getColor(R.color.black));
            textManuel1.setTextColor(getResources().getColor(R.color.black));
            textManuel2.setTextColor(getResources().getColor(R.color.black));
            textManuel3.setTextColor(getResources().getColor(R.color.black));
            textManuel4.setTextColor(getResources().getColor(R.color.blue_contrast));
            textManuel5.setTextColor(getResources().getColor(R.color.blue_contrast));
            textManuel6.setTextColor(getResources().getColor(R.color.blue_contrast));
            textMariajose1.setTextColor(getResources().getColor(R.color.black));
            textMariajose2.setTextColor(getResources().getColor(R.color.black));
            textMariajose3.setTextColor(getResources().getColor(R.color.black));
            textMariajose4.setTextColor(getResources().getColor(R.color.blue_contrast));
            textPictures1.setTextColor(getResources().getColor(R.color.black));
            textPictures2.setTextColor(getResources().getColor(R.color.black));
            textHamid1.setTextColor(getResources().getColor(R.color.black));
            textHamid2.setTextColor(getResources().getColor(R.color.black));
            textHamid3.setTextColor(getResources().getColor(R.color.blue_contrast));
            textMerce1.setTextColor(getResources().getColor(R.color.black));
            textMerce2.setTextColor(getResources().getColor(R.color.black));
            textRaquel1.setTextColor(getResources().getColor(R.color.black));
            textRaquel2.setTextColor(getResources().getColor(R.color.black));
            textMiquel1.setTextColor(getResources().getColor(R.color.black));
            textMiquel2.setTextColor(getResources().getColor(R.color.black));
            textZhenia1.setTextColor(getResources().getColor(R.color.black));
            textZhenia2.setTextColor(getResources().getColor(R.color.black));
            textZhenia3.setTextColor(getResources().getColor(R.color.blue_contrast));
            textZhenia4.setTextColor(getResources().getColor(R.color.blue_contrast));
            textMax1.setTextColor(getResources().getColor(R.color.black));
            textMax2.setTextColor(getResources().getColor(R.color.black));
            textMax3.setTextColor(getResources().getColor(R.color.blue_contrast));
            textMax4.setTextColor(getResources().getColor(R.color.blue_contrast));
        }
        switch (sizeText) {
            case "very big":
                if (isTablet.equals("Phone")) {
                    textApp.setTextSize(18);
                    textAuthors.setTextSize(22);
                    textManuel1.setTextSize(22);
                    textManuel2.setTextSize(18);
                    textManuel3.setTextSize(18);
                    textManuel4.setTextSize(18);
                    textManuel5.setTextSize(18);
                    textManuel6.setTextSize(18);
                    textMariajose1.setTextSize(22);
                    textMariajose2.setTextSize(18);
                    textMariajose3.setTextSize(18);
                    textMariajose4.setTextSize(18);
                    textPictures.setTextSize(22);
                    textPictures1.setTextSize(18);
                    textPictures2.setTextSize(18);
                    textTranslations.setTextSize(22);
                    textArabian.setTextSize(22);
                    textRussian.setTextSize(22);
                    textCatalan.setTextSize(22);
                    textHamid1.setTextSize(22);
                    textHamid2.setTextSize(18);
                    textHamid3.setTextSize(18);
                    textMerce1.setTextSize(18);
                    textMerce2.setTextSize(18);
                    textRaquel1.setTextSize(18);
                    textRaquel2.setTextSize(18);
                    textMiquel1.setTextSize(18);
                    textMiquel2.setTextSize(18);
                    textZhenia1.setTextSize(22);
                    textZhenia2.setTextSize(18);
                    textZhenia3.setTextSize(18);
                    textZhenia4.setTextSize(18);
                    textMax1.setTextSize(22);
                    textMax2.setTextSize(18);
                    textMax3.setTextSize(18);
                    textMax4.setTextSize(18);
                } else if (isTablet.equals("Tablet7")) {
                    textApp.setTextSize(24);
                    textAuthors.setTextSize(28);
                    textManuel1.setTextSize(28);
                    textManuel2.setTextSize(24);
                    textManuel3.setTextSize(24);
                    textManuel4.setTextSize(24);
                    textManuel5.setTextSize(24);
                    textManuel6.setTextSize(24);
                    textMariajose1.setTextSize(28);
                    textMariajose2.setTextSize(24);
                    textMariajose3.setTextSize(24);
                    textMariajose4.setTextSize(24);
                    textPictures.setTextSize(28);
                    textPictures1.setTextSize(24);
                    textPictures2.setTextSize(24);
                    textTranslations.setTextSize(28);
                    textArabian.setTextSize(28);
                    textRussian.setTextSize(28);
                    textCatalan.setTextSize(28);
                    textHamid1.setTextSize(28);
                    textHamid2.setTextSize(24);
                    textHamid3.setTextSize(24);
                    textMerce1.setTextSize(28);
                    textMerce2.setTextSize(24);
                    textRaquel1.setTextSize(28);
                    textRaquel2.setTextSize(24);
                    textMiquel1.setTextSize(28);
                    textMiquel2.setTextSize(24);
                    textZhenia1.setTextSize(28);
                    textZhenia2.setTextSize(24);
                    textZhenia3.setTextSize(24);
                    textZhenia4.setTextSize(24);
                    textMax1.setTextSize(28);
                    textMax2.setTextSize(24);
                    textMax3.setTextSize(24);
                    textMax4.setTextSize(24);
                } else {
                    textApp.setTextSize(28);
                    textAuthors.setTextSize(32);
                    textManuel1.setTextSize(32);
                    textManuel2.setTextSize(28);
                    textManuel3.setTextSize(28);
                    textManuel4.setTextSize(28);
                    textManuel5.setTextSize(28);
                    textManuel6.setTextSize(28);
                    textMariajose1.setTextSize(32);
                    textMariajose2.setTextSize(28);
                    textMariajose3.setTextSize(28);
                    textMariajose4.setTextSize(28);
                    textPictures.setTextSize(32);
                    textPictures1.setTextSize(28);
                    textPictures2.setTextSize(28);
                    textTranslations.setTextSize(32);
                    textArabian.setTextSize(32);
                    textRussian.setTextSize(32);
                    textCatalan.setTextSize(32);
                    textHamid1.setTextSize(32);
                    textHamid2.setTextSize(28);
                    textHamid3.setTextSize(28);
                    textMerce1.setTextSize(32);
                    textMerce2.setTextSize(28);
                    textRaquel1.setTextSize(32);
                    textRaquel2.setTextSize(28);
                    textMiquel1.setTextSize(32);
                    textMiquel2.setTextSize(28);
                    textZhenia1.setTextSize(32);
                    textZhenia2.setTextSize(28);
                    textZhenia3.setTextSize(28);
                    textZhenia4.setTextSize(28);
                    textMax1.setTextSize(32);
                    textMax2.setTextSize(28);
                    textMax3.setTextSize(28);
                    textMax4.setTextSize(28);
                }
                break;
            case "big":
                if (isTablet.equals("Phone")) {
                    textApp.setTextSize(16);
                    textAuthors.setTextSize(20);
                    textManuel1.setTextSize(20);
                    textManuel2.setTextSize(16);
                    textManuel3.setTextSize(16);
                    textManuel4.setTextSize(16);
                    textManuel5.setTextSize(16);
                    textManuel6.setTextSize(16);
                    textMariajose1.setTextSize(20);
                    textMariajose2.setTextSize(16);
                    textMariajose3.setTextSize(16);
                    textMariajose4.setTextSize(16);
                    textPictures.setTextSize(20);
                    textPictures1.setTextSize(16);
                    textPictures2.setTextSize(16);
                    textTranslations.setTextSize(20);
                    textArabian.setTextSize(20);
                    textRussian.setTextSize(20);
                    textCatalan.setTextSize(20);
                    textHamid1.setTextSize(20);
                    textHamid2.setTextSize(16);
                    textHamid3.setTextSize(16);
                    textMerce1.setTextSize(20);
                    textMerce2.setTextSize(16);
                    textRaquel1.setTextSize(20);
                    textRaquel2.setTextSize(16);
                    textMiquel1.setTextSize(20);
                    textMiquel2.setTextSize(16);
                    textZhenia1.setTextSize(20);
                    textZhenia2.setTextSize(16);
                    textZhenia3.setTextSize(16);
                    textZhenia4.setTextSize(16);
                    textMax1.setTextSize(20);
                    textMax2.setTextSize(16);
                    textMax3.setTextSize(16);
                    textMax4.setTextSize(16);
                } else if (isTablet.equals("Tablet7")) {
                    textApp.setTextSize(22);
                    textAuthors.setTextSize(26);
                    textManuel1.setTextSize(26);
                    textManuel2.setTextSize(22);
                    textManuel3.setTextSize(22);
                    textManuel4.setTextSize(22);
                    textManuel5.setTextSize(22);
                    textManuel6.setTextSize(22);
                    textMariajose1.setTextSize(26);
                    textMariajose2.setTextSize(22);
                    textMariajose3.setTextSize(22);
                    textMariajose4.setTextSize(22);
                    textPictures.setTextSize(26);
                    textPictures1.setTextSize(22);
                    textPictures2.setTextSize(22);
                    textTranslations.setTextSize(26);
                    textArabian.setTextSize(26);
                    textRussian.setTextSize(26);
                    textCatalan.setTextSize(26);
                    textHamid1.setTextSize(26);
                    textHamid2.setTextSize(22);
                    textHamid3.setTextSize(22);
                    textMerce1.setTextSize(26);
                    textMerce2.setTextSize(22);
                    textRaquel1.setTextSize(26);
                    textRaquel2.setTextSize(22);
                    textMiquel1.setTextSize(26);
                    textMiquel2.setTextSize(22);
                    textZhenia1.setTextSize(26);
                    textZhenia2.setTextSize(22);
                    textZhenia3.setTextSize(22);
                    textZhenia4.setTextSize(22);
                    textMax1.setTextSize(26);
                    textMax2.setTextSize(22);
                    textMax3.setTextSize(22);
                    textMax4.setTextSize(22);
                } else {
                    textApp.setTextSize(26);
                    textAuthors.setTextSize(30);
                    textManuel1.setTextSize(30);
                    textManuel2.setTextSize(26);
                    textManuel3.setTextSize(26);
                    textManuel4.setTextSize(26);
                    textManuel5.setTextSize(26);
                    textManuel6.setTextSize(26);
                    textMariajose1.setTextSize(30);
                    textMariajose2.setTextSize(26);
                    textMariajose3.setTextSize(26);
                    textMariajose4.setTextSize(26);
                    textPictures.setTextSize(30);
                    textPictures1.setTextSize(26);
                    textPictures2.setTextSize(26);
                    textTranslations.setTextSize(30);
                    textArabian.setTextSize(30);
                    textRussian.setTextSize(30);
                    textCatalan.setTextSize(30);
                    textHamid1.setTextSize(30);
                    textHamid2.setTextSize(26);
                    textHamid3.setTextSize(26);
                    textMerce1.setTextSize(30);
                    textMerce2.setTextSize(26);
                    textRaquel1.setTextSize(30);
                    textRaquel2.setTextSize(26);
                    textMiquel1.setTextSize(30);
                    textMiquel2.setTextSize(26);
                    textZhenia1.setTextSize(30);
                    textZhenia2.setTextSize(26);
                    textZhenia3.setTextSize(26);
                    textZhenia4.setTextSize(26);
                    textMax1.setTextSize(30);
                    textMax2.setTextSize(26);
                    textMax3.setTextSize(26);
                    textMax4.setTextSize(26);
                }
                break;
            case "medium":
                if (isTablet.equals("Phone")) {
                    textApp.setTextSize(14);
                    textAuthors.setTextSize(18);
                    textManuel1.setTextSize(18);
                    textManuel2.setTextSize(14);
                    textManuel3.setTextSize(14);
                    textManuel4.setTextSize(14);
                    textManuel5.setTextSize(14);
                    textManuel6.setTextSize(14);
                    textMariajose1.setTextSize(18);
                    textMariajose2.setTextSize(14);
                    textMariajose3.setTextSize(14);
                    textMariajose4.setTextSize(14);
                    textPictures.setTextSize(18);
                    textPictures1.setTextSize(14);
                    textPictures2.setTextSize(14);
                    textTranslations.setTextSize(18);
                    textArabian.setTextSize(18);
                    textRussian.setTextSize(18);
                    textCatalan.setTextSize(18);
                    textHamid1.setTextSize(18);
                    textHamid2.setTextSize(14);
                    textHamid3.setTextSize(14);
                    textMerce1.setTextSize(18);
                    textMerce2.setTextSize(14);
                    textRaquel1.setTextSize(18);
                    textRaquel2.setTextSize(14);
                    textMiquel1.setTextSize(18);
                    textMiquel2.setTextSize(14);
                    textZhenia1.setTextSize(18);
                    textZhenia2.setTextSize(14);
                    textZhenia3.setTextSize(14);
                    textZhenia4.setTextSize(14);
                    textMax1.setTextSize(18);
                    textMax2.setTextSize(14);
                    textMax3.setTextSize(14);
                    textMax4.setTextSize(14);
                } else if (isTablet.equals("Tablet7")) {
                    textApp.setTextSize(20);
                    textAuthors.setTextSize(24);
                    textManuel1.setTextSize(24);
                    textManuel2.setTextSize(20);
                    textManuel3.setTextSize(20);
                    textManuel4.setTextSize(20);
                    textManuel5.setTextSize(20);
                    textManuel6.setTextSize(20);
                    textMariajose1.setTextSize(24);
                    textMariajose2.setTextSize(20);
                    textMariajose3.setTextSize(20);
                    textMariajose4.setTextSize(20);
                    textPictures.setTextSize(24);
                    textPictures1.setTextSize(20);
                    textPictures2.setTextSize(20);
                    textTranslations.setTextSize(24);
                    textArabian.setTextSize(24);
                    textRussian.setTextSize(24);
                    textCatalan.setTextSize(24);
                    textHamid1.setTextSize(24);
                    textHamid2.setTextSize(20);
                    textHamid3.setTextSize(20);
                    textMerce1.setTextSize(24);
                    textMerce2.setTextSize(20);
                    textRaquel1.setTextSize(24);
                    textRaquel2.setTextSize(20);
                    textMiquel1.setTextSize(24);
                    textMiquel2.setTextSize(20);
                    textZhenia1.setTextSize(24);
                    textZhenia2.setTextSize(20);
                    textZhenia3.setTextSize(20);
                    textZhenia4.setTextSize(20);
                    textMax1.setTextSize(24);
                    textMax2.setTextSize(20);
                    textMax3.setTextSize(20);
                    textMax4.setTextSize(20);
                } else {
                    textApp.setTextSize(24);
                    textAuthors.setTextSize(28);
                    textManuel1.setTextSize(28);
                    textManuel2.setTextSize(24);
                    textManuel3.setTextSize(24);
                    textManuel4.setTextSize(24);
                    textManuel5.setTextSize(24);
                    textManuel6.setTextSize(24);
                    textMariajose1.setTextSize(28);
                    textMariajose2.setTextSize(24);
                    textMariajose3.setTextSize(24);
                    textMariajose4.setTextSize(24);
                    textPictures.setTextSize(28);
                    textPictures1.setTextSize(24);
                    textPictures2.setTextSize(24);
                    textTranslations.setTextSize(28);
                    textArabian.setTextSize(28);
                    textRussian.setTextSize(28);
                    textCatalan.setTextSize(28);
                    textHamid1.setTextSize(28);
                    textHamid2.setTextSize(24);
                    textHamid3.setTextSize(24);
                    textMerce1.setTextSize(28);
                    textMerce2.setTextSize(24);
                    textRaquel1.setTextSize(28);
                    textRaquel2.setTextSize(24);
                    textMiquel1.setTextSize(28);
                    textMiquel2.setTextSize(24);
                    textZhenia1.setTextSize(28);
                    textZhenia2.setTextSize(24);
                    textZhenia3.setTextSize(24);
                    textZhenia4.setTextSize(24);
                    textMax1.setTextSize(28);
                    textMax2.setTextSize(24);
                    textMax3.setTextSize(24);
                    textMax4.setTextSize(24);
                }
                break;
            case "small":
                if (isTablet.equals("Phone")) {
                    textApp.setTextSize(12);
                    textAuthors.setTextSize(16);
                    textManuel1.setTextSize(16);
                    textManuel2.setTextSize(12);
                    textManuel3.setTextSize(12);
                    textManuel4.setTextSize(12);
                    textManuel5.setTextSize(12);
                    textManuel6.setTextSize(12);
                    textMariajose1.setTextSize(16);
                    textMariajose2.setTextSize(12);
                    textMariajose3.setTextSize(12);
                    textMariajose4.setTextSize(12);
                    textPictures.setTextSize(16);
                    textPictures1.setTextSize(12);
                    textPictures2.setTextSize(12);
                    textTranslations.setTextSize(16);
                    textArabian.setTextSize(16);
                    textRussian.setTextSize(16);
                    textCatalan.setTextSize(16);
                    textHamid1.setTextSize(16);
                    textHamid2.setTextSize(12);
                    textHamid3.setTextSize(12);
                    textMerce1.setTextSize(16);
                    textMerce2.setTextSize(12);
                    textRaquel1.setTextSize(16);
                    textRaquel2.setTextSize(12);
                    textMiquel1.setTextSize(16);
                    textMiquel2.setTextSize(12);
                    textZhenia1.setTextSize(16);
                    textZhenia2.setTextSize(12);
                    textZhenia3.setTextSize(12);
                    textZhenia4.setTextSize(12);
                    textMax1.setTextSize(16);
                    textMax2.setTextSize(12);
                    textMax3.setTextSize(12);
                    textMax4.setTextSize(12);
                } else if (isTablet.equals("Tablet7")) {
                    textApp.setTextSize(28);
                    textAuthors.setTextSize(22);
                    textManuel1.setTextSize(22);
                    textManuel2.setTextSize(18);
                    textManuel3.setTextSize(18);
                    textManuel4.setTextSize(18);
                    textManuel5.setTextSize(18);
                    textManuel6.setTextSize(18);
                    textMariajose1.setTextSize(22);
                    textMariajose2.setTextSize(18);
                    textMariajose3.setTextSize(18);
                    textMariajose4.setTextSize(18);
                    textPictures.setTextSize(22);
                    textPictures1.setTextSize(18);
                    textPictures2.setTextSize(18);
                    textTranslations.setTextSize(22);
                    textArabian.setTextSize(22);
                    textRussian.setTextSize(22);
                    textCatalan.setTextSize(22);
                    textHamid1.setTextSize(22);
                    textHamid2.setTextSize(18);
                    textHamid3.setTextSize(18);
                    textMerce1.setTextSize(22);
                    textMerce2.setTextSize(18);
                    textRaquel1.setTextSize(22);
                    textRaquel2.setTextSize(18);
                    textMiquel1.setTextSize(22);
                    textMiquel2.setTextSize(18);
                    textZhenia1.setTextSize(22);
                    textZhenia2.setTextSize(18);
                    textZhenia3.setTextSize(18);
                    textZhenia4.setTextSize(18);
                    textMax1.setTextSize(22);
                    textMax2.setTextSize(18);
                    textMax3.setTextSize(18);
                    textMax4.setTextSize(18);
                } else {
                    textApp.setTextSize(22);
                    textAuthors.setTextSize(26);
                    textManuel1.setTextSize(26);
                    textManuel2.setTextSize(22);
                    textManuel3.setTextSize(22);
                    textManuel4.setTextSize(22);
                    textManuel5.setTextSize(22);
                    textManuel6.setTextSize(22);
                    textMariajose1.setTextSize(26);
                    textMariajose2.setTextSize(22);
                    textMariajose3.setTextSize(22);
                    textMariajose4.setTextSize(22);
                    textPictures.setTextSize(26);
                    textPictures1.setTextSize(22);
                    textPictures2.setTextSize(22);
                    textTranslations.setTextSize(26);
                    textArabian.setTextSize(26);
                    textRussian.setTextSize(26);
                    textCatalan.setTextSize(26);
                    textHamid1.setTextSize(26);
                    textHamid2.setTextSize(22);
                    textHamid3.setTextSize(22);
                    textMerce1.setTextSize(26);
                    textMerce2.setTextSize(22);
                    textRaquel1.setTextSize(26);
                    textRaquel2.setTextSize(22);
                    textMiquel1.setTextSize(26);
                    textMiquel2.setTextSize(22);
                    textZhenia1.setTextSize(26);
                    textZhenia2.setTextSize(22);
                    textZhenia3.setTextSize(22);
                    textZhenia4.setTextSize(22);
                    textMax1.setTextSize(26);
                    textMax2.setTextSize(22);
                    textMax3.setTextSize(22);
                    textMax4.setTextSize(22);
                }
                break;
            default:
                if (isTablet.equals("Phone")) {
                    textApp.setTextSize(10);
                    textAuthors.setTextSize(14);
                    textManuel1.setTextSize(14);
                    textManuel2.setTextSize(10);
                    textManuel3.setTextSize(10);
                    textManuel4.setTextSize(10);
                    textManuel5.setTextSize(10);
                    textManuel6.setTextSize(10);
                    textMariajose1.setTextSize(14);
                    textMariajose2.setTextSize(10);
                    textMariajose3.setTextSize(10);
                    textMariajose4.setTextSize(10);
                    textPictures.setTextSize(14);
                    textPictures1.setTextSize(10);
                    textPictures2.setTextSize(10);
                    textTranslations.setTextSize(14);
                    textArabian.setTextSize(14);
                    textRussian.setTextSize(14);
                    textCatalan.setTextSize(14);
                    textHamid1.setTextSize(14);
                    textHamid2.setTextSize(10);
                    textHamid3.setTextSize(10);
                    textMerce1.setTextSize(14);
                    textMerce2.setTextSize(10);
                    textRaquel1.setTextSize(14);
                    textRaquel2.setTextSize(10);
                    textMiquel1.setTextSize(14);
                    textMiquel2.setTextSize(10);
                    textZhenia1.setTextSize(14);
                    textZhenia2.setTextSize(10);
                    textZhenia3.setTextSize(10);
                    textZhenia4.setTextSize(10);
                    textMax1.setTextSize(14);
                    textMax2.setTextSize(10);
                    textMax3.setTextSize(10);
                    textMax4.setTextSize(10);
                } else if (isTablet.equals("Tablet7")) {
                    textApp.setTextSize(16);
                    textAuthors.setTextSize(20);
                    textManuel1.setTextSize(20);
                    textManuel2.setTextSize(16);
                    textManuel3.setTextSize(16);
                    textManuel4.setTextSize(16);
                    textManuel5.setTextSize(16);
                    textManuel6.setTextSize(16);
                    textMariajose1.setTextSize(20);
                    textMariajose2.setTextSize(16);
                    textMariajose3.setTextSize(16);
                    textMariajose4.setTextSize(16);
                    textPictures.setTextSize(20);
                    textPictures1.setTextSize(16);
                    textPictures2.setTextSize(16);
                    textTranslations.setTextSize(20);
                    textArabian.setTextSize(20);
                    textRussian.setTextSize(20);
                    textCatalan.setTextSize(20);
                    textHamid1.setTextSize(20);
                    textHamid2.setTextSize(16);
                    textHamid3.setTextSize(16);
                    textMerce1.setTextSize(20);
                    textMerce2.setTextSize(16);
                    textRaquel1.setTextSize(20);
                    textRaquel2.setTextSize(16);
                    textMiquel1.setTextSize(20);
                    textMiquel2.setTextSize(16);
                    textZhenia1.setTextSize(20);
                    textZhenia2.setTextSize(16);
                    textZhenia3.setTextSize(16);
                    textZhenia4.setTextSize(16);
                    textMax1.setTextSize(20);
                    textMax2.setTextSize(16);
                    textMax3.setTextSize(16);
                    textMax4.setTextSize(16);
                } else {
                    textApp.setTextSize(20);
                    textAuthors.setTextSize(24);
                    textManuel1.setTextSize(24);
                    textManuel2.setTextSize(20);
                    textManuel3.setTextSize(20);
                    textManuel4.setTextSize(20);
                    textManuel5.setTextSize(20);
                    textManuel6.setTextSize(20);
                    textMariajose1.setTextSize(24);
                    textMariajose2.setTextSize(20);
                    textMariajose3.setTextSize(20);
                    textMariajose4.setTextSize(20);
                    textPictures.setTextSize(24);
                    textPictures1.setTextSize(20);
                    textPictures2.setTextSize(20);
                    textTranslations.setTextSize(24);
                    textArabian.setTextSize(24);
                    textRussian.setTextSize(24);
                    textCatalan.setTextSize(24);
                    textHamid1.setTextSize(24);
                    textHamid2.setTextSize(20);
                    textHamid3.setTextSize(20);
                    textMerce1.setTextSize(24);
                    textMerce2.setTextSize(20);
                    textRaquel1.setTextSize(24);
                    textRaquel2.setTextSize(20);
                    textMiquel1.setTextSize(24);
                    textMiquel2.setTextSize(20);
                    textZhenia1.setTextSize(24);
                    textZhenia2.setTextSize(20);
                    textZhenia3.setTextSize(20);
                    textZhenia4.setTextSize(20);
                    textMax1.setTextSize(24);
                    textMax2.setTextSize(20);
                    textMax3.setTextSize(20);
                    textMax4.setTextSize(20);
                }
                break;
        }
        textManuel4.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=7157330435810114607"));
            startActivity(browserIntent);
        });
        textManuel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "+34619609028"; // Reemplaza con tu número de teléfono
                String message = "Hello, I am writing you because of your mineralogy application ..."; // Reemplaza con tu mensaje predefinido

                try {
                    String url = "https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + URLEncoder.encode(message, "UTF-8");
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();
                    // Si WhatsApp no está instalado o hay algún otro error, puedes manejarlo aquí
                    Toast.makeText(getContext(), "Error openning WhatsApp", Toast.LENGTH_SHORT).show();
                }

            }
        });
        textManuel6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "quizandguide@gmail.com", null));
                startActivity(Intent.createChooser(intent, "Send email"));
            }
        });
        textMariajose4.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://personal.unizar.es/mayayo/"));
            startActivity(browserIntent);
        });
        textHamid3.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/hamid.hasan.50159"));
            startActivity(browserIntent);
        });
        textZhenia3.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/12RZMTl5b1eopNLESw_l1ppiA8W8hTyvv/edit"));
            startActivity(browserIntent);
        });
        /*textZhenia4.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/evgesha-undefined-79688426b/"));
            startActivity(browserIntent);
        });*/
        textMax3.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/19YiRSlz7SpYZTnZTFnz9wiamvp0AmPNc/edit?usp=drivesdk&ouid=117121153330829076696&rtpof=true&sd=true"));
            startActivity(browserIntent);
        });
        textMax4.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/maxim-ivchin-24bb61263/"));
            startActivity(browserIntent);
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