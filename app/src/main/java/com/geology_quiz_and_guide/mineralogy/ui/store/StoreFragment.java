package com.geology_quiz_and_guide.mineralogy.ui.store;

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
import com.geology_quiz_and_guide.mineralogy.databinding.FragmentStoreBinding;

import java.util.Locale;

public class StoreFragment extends Fragment {
    private FragmentStoreBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor myEdit;
    private String language;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStoreBinding.inflate(inflater, container, false);
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