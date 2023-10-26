package com.geology_quiz_and_guide.mineralogy;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.geology_quiz_and_guide.mineralogy.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor myEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.geology_quiz_and_guide.mineralogy.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_guide, R.id.nav_quiz, R.id.nav_settings, R.id.nav_moreapps, R.id.nav_contribute, R.id.nav_blog, R.id.nav_credits)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        sharedPreferences = this.getSharedPreferences("UserPreferences", MODE_PRIVATE);
        myEdit = sharedPreferences.edit();
        String language = sharedPreferences.getString("language", Locale.getDefault().getLanguage());
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.activity_main_drawer);
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            String mineral = "";
            if (query.equalsIgnoreCase("alita")) {
                mineral = "halita";
            } else if (query.equalsIgnoreCase("goetita")) {
                mineral = "goethita";
            } else if (query.equalsIgnoreCase("ematites")) {
                mineral = "hematites";
            } else if (query.equalsIgnoreCase("orn blenda") || query.equalsIgnoreCase("horn blenda") || query.equalsIgnoreCase("or blenda")|| query.equalsIgnoreCase("orblenda")|| query.equalsIgnoreCase("or glenda")|| query.equalsIgnoreCase("orblenda")|| query.equalsIgnoreCase("orglenda")|| query.equalsIgnoreCase("orlenda")) {
                mineral = "hornblenda";
            } else if (query.equalsIgnoreCase("mont morillonita") || query.equalsIgnoreCase("mon morillonita")|| query.equalsIgnoreCase("monmorillonita")|| query.equalsIgnoreCase("monmorillonita")) {
                mineral = "montmorillonita";
            } else if (query.equalsIgnoreCase("eulandita")|| query.equalsIgnoreCase("eulantita")) {
                mineral = "heulandita";
            } else if (query.equalsIgnoreCase("glauverita")) {
                mineral = "glauberita";
            } else if (query.equalsIgnoreCase("varita")) {
                mineral = "barita";
            } else if (query.equalsIgnoreCase("fallalita")) {
                mineral = "fayalita";
            } else if (query.equalsIgnoreCase("silimanita")) {
                mineral = "sillimanita";
            } else if (query.equalsIgnoreCase("ilita")|| query.equalsIgnoreCase("higuita")|| query.equalsIgnoreCase("y lita")) {
                mineral = "illita";
            } else {
                mineral = query.toLowerCase();
            }
            Database db = new Database(this);
            boolean isMineral = db.isMineral(mineral);
            if (isMineral) {
                doMySearch(mineral);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.no_se_encuentra_el_mineral), Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    public void doMySearch(String mineral) {
        Database myDb = new Database(this);
        Cursor cursor = myDb.getIdFromQuery(mineral);
        String id = "";
        while (cursor.moveToNext()) {
            id = cursor.getString(0);
        }
        cursor.close();
        myDb.closeDatabase();
        Intent intent = new Intent(MainActivity.this,Ficha.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setSubmitButtonEnabled(true);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    @Override
    protected void onResume() {
        super.onResume();

    }
}