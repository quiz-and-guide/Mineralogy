package com.geology_quiz_and_guide.mineralogy.ui.contribute;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.geology_quiz_and_guide.mineralogy.R;
import com.geology_quiz_and_guide.mineralogy.databinding.FragmentContributeBinding;

import java.util.Locale;


public class ContributeFragment extends Fragment {


    private FragmentContributeBinding binding;
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

        binding = FragmentContributeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ScrollView screen = binding.screen;

        //fetchDataFromGoogleSheet();
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

        return root;
    }
    /*private void fetchDataFromGoogleSheet() {
        String SHEETS_API_ENDPOINT = "https://sheets.googleapis.com/v4/spreadsheets/1XPOAKVrvuPygBZgedVaGK98yNEuUqZbE30ko31Ueo6k/values/blog!A1:A2?key=AIzaSyCpVfdGP-qS06NEDCQ10Iwub7LQCEzUJtQ";


        RequestQueue queue = Volley.newRequestQueue(requireContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, SHEETS_API_ENDPOINT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray values = jsonObject.getJSONArray("values");
                            if (values.length() > 0) {
                                JSONArray firstRow = values.getJSONArray(0);
                                entry1.setText(firstRow.getString(0));
                                Log.i("texto1", entry1.getText().toString());
                                if (values.length() > 1) {
                                    JSONArray secondRow = values.getJSONArray(1);
                                    entry2.setText(secondRow.getString(0));
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
            }
        });

        queue.add(stringRequest);
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