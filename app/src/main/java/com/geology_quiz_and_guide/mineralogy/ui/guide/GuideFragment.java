package com.geology_quiz_and_guide.mineralogy.ui.guide;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geology_quiz_and_guide.mineralogy.Database;
import com.geology_quiz_and_guide.mineralogy.Ficha;
import com.geology_quiz_and_guide.mineralogy.ListViewAdapter;
import com.geology_quiz_and_guide.mineralogy.R;
import com.geology_quiz_and_guide.mineralogy.databinding.FragmentGuideBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GuideFragment extends Fragment {

    private FragmentGuideBinding binding;
    private Cursor cursor;
    private List<MineralesAdapter2.Minerales> mines;
    private ListViewAdapter2 adapter;
    private ArrayList<String> mineNombres;
    private ArrayAdapter<String> adapterBusqueda;
    private SearchView searchView;
    private SharedPreferences sharedPreferences;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGuideBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
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
        final ListView listView = binding.listView;
        mines = new ArrayList<>();
        adapter = new ListViewAdapter2(getActivity(), mines);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String posicion = mines.get(position).getId();
            searchView.setQuery("",false);
            Intent intent = new Intent(getActivity(), Ficha.class);
            intent.putExtra("id",posicion);
            startActivity(intent);
        });

        rellenaTodos();
        final ListView listViewS = binding.listViewSearch;
        mineNombres = new ArrayList<>();
        adapterBusqueda = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,
                mineNombres);
        listViewS.setAdapter(adapterBusqueda);
        listViewS.setOnItemClickListener((parent, view, position, id) -> {
            String nombreMineral = mineNombres.get(position);
            Database myDb = new Database(getActivity());
            Cursor cursor = myDb.getIdFromMineral(nombreMineral);
            String idMine = "";
            while (cursor.moveToNext()) {
                idMine = cursor.getString(0);
            }
            cursor.close();
            myDb.closeDatabase();
            mineNombres.clear();
            adapterBusqueda.notifyDataSetChanged();
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            Intent intent = new Intent(getActivity(), Ficha.class);
            intent.putExtra("id",idMine);
            searchView.setQuery("",false);
            startActivity(intent);
        });

        return root;
    }
    public void rellenaTodos() {
        Database myDb = new Database(getActivity());
        Cursor cursor = myDb.getMinerals();
        mines.clear();
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            String id = cursor.getString(0);
            String nombre = cursor.getString(1);
            String tipo = cursor.getString(4);
            MineralesAdapter2.Minerales minerales = new MineralesAdapter2.Minerales(
                    id,
                    nombre,
                    tipo
            );
            mines.add(minerales);
            adapter.notifyDataSetChanged();
        }
        cursor.close();
        myDb.closeDatabase();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); // It's important here
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                if (newText.length() == 0) {
                    mineNombres.clear();
                    adapterBusqueda.notifyDataSetChanged();
                }
                Database myDb = new Database(getActivity());
                Cursor cursor = myDb.getNombres();
                if (newText.length() != 0) {
                    mineNombres.clear();
                    adapterBusqueda.notifyDataSetChanged();
                    int chars = newText.length();
                    while (cursor.moveToNext()) {
                        String nombre = cursor.getString(0).toLowerCase();
                        String subNombre = "";
                        try {
                            subNombre = nombre.substring(0, chars);
                        } catch (Exception exc) {
                            subNombre = nombre.substring(0, nombre.length() - 1);
                        }
                        boolean yaNombre = false;
                        for (int h = 0; h < mineNombres.size(); h++) {
                            if (nombre.equals(mineNombres.get(h))) {
                                yaNombre = true;
                            }
                        }

                        if (newText.equals(subNombre) && (!yaNombre)) {
                            mineNombres.add(nombre);
                            adapterBusqueda.notifyDataSetChanged();
                        }
                    }
                    cursor.close();
                }
                myDb.closeDatabase();
                return true;
            }
        });

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