package com.geology_quiz_and_guide.mineralogy.ui.moreapps;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.geology_quiz_and_guide.mineralogy.R;
import com.geology_quiz_and_guide.mineralogy.databinding.FragmentMoreappsBinding;

import java.util.Locale;

public class MoreappsFragment extends Fragment {


    private FragmentMoreappsBinding binding;
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

        binding = FragmentMoreappsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ScrollView screen = binding.screen;
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
        if (theme.equals("light")) {
            //screen.setTextColor(getResources().getColor(R.color.black));
        } else {
            //nombreTV.setTextColor(getResources().getColor(R.color.white));
        }
        if (sizeText.equals("very big")) {
            if (isTablet.equals("Phone")) {
                //autorFotoTV.setTextSize(18);
            } else if (isTablet.equals("Tablet7")) {
                //autorFotoTV.setTextSize(24);
            } else {
                //autorFotoTV.setTextSize(28);
            }
        } else if (sizeText.equals("big")) {
            if (isTablet.equals("Phone")) {
                //autorFotoTV.setTextSize(16);
            } else if (isTablet.equals("Tablet7")) {
                //autorFotoTV.setTextSize(22);
            } else {
                //autorFotoTV.setTextSize(26);
            }
        } else if (sizeText.equals("medium")) {
            if (isTablet.equals("Phone")) {
                //autorFotoTV.setTextSize(14);
            } else if (isTablet.equals("Tablet7")) {
                //autorFotoTV.setTextSize(20);
            } else {
                //autorFotoTV.setTextSize(24);
            }
        } else if (sizeText.equals("small")) {
            if (isTablet.equals("Phone")) {
                //autorFotoTV.setTextSize(12);
            } else if (isTablet.equals("Tablet7")) {
                //autorFotoTV.setTextSize(18);
            } else {
                //autorFotoTV.setTextSize(22);
            }
        } else {
            if (isTablet.equals("Phone")) {
                //autorFotoTV.setTextSize(10);
            } else if (isTablet.equals("Tablet7")) {
                //autorFotoTV.setTextSize(16);
            } else {
                //autorFotoTV.setTextSize(20);
            }
        }
        ImageView imageMine180 = binding.imageMine180;
        imageMine180.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.geologyapplications.minerals"));
            startActivity(browserIntent);
        });
        TextView txtStack = binding.gotoES;
        txtStack.setTextColor(getResources().getColor(R.color.blue_contrast));
        txtStack.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://earthscience.stackexchange.com/"));
            startActivity(browserIntent);
        });
        TextView txtAd = binding.ad;
        txtAd.setText(Html.fromHtml("We are writing a free Earth Sciences wonderfull library of knowledge in the form of questions and answers and you are welcome to participate.<br><br>" +
                "You can post questions or start to answer. You can add images to the text. We do not identify minerals or rocks, but outcrops pictures are more than welcome."));



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