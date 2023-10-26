package com.geology_quiz_and_guide.mineralogy;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.Locale;

public class Database extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "MINERALOGY.db";
    private static final int DATABASE_VERSION = 2;
    private final SQLiteDatabase db;
    private final String table;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
        db = getReadableDatabase();
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String language = sharedPreferences.getString("language", Locale.getDefault().getLanguage());
        switch (language) {
            case "es":
                table = "MINERALOGY_ES";
                break;
            case "fr":
                table = "MINERALOGY_FR";
                break;
            case "ca":
                table = "MINERALOGY_CA";
                break;
            case "ru":
                table = "MINERALOGY_RU";
                break;
            case "ar":
                table = "MINERALOGY_AR";
                break;
            default:
                table = "MINERALOGY_EN";
                break;
        }
    }
    public Cursor getMinerals() {
        return db.rawQuery("SELECT * FROM '"+table+"'", null);
    }
    public Cursor getMineralesSimplificados(String id) {
       return db.rawQuery("SELECT ID, MINERAL, CLASE   FROM '"+table+"' WHERE ID='"+id+"'", null);
    }

    public String getId(String mineral) {
        Cursor cursor = db.rawQuery("SELECT ID FROM '"+table+"' WHERE MINERAL='"+mineral+"'", null);
        String id = "";
        while (cursor.moveToNext()) {
            id = cursor.getString(0);
        }
        cursor.close();
        return id;
    }

    public Cursor getNombres() {
        return db.rawQuery("SELECT MINERAL FROM '"+table+"'", null);
    }
    public Cursor getMineralYTipo(String id) {
        return db.rawQuery("SELECT MINERAL, TIPO FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public String getMineralFromId(String id) {
        Cursor cursor = db.rawQuery("SELECT MINERAL FROM '"+table+"' WHERE ID="+id+"", null);
        String mineral = "";
        while (cursor.moveToNext()) {
            mineral = cursor.getString(0);
        }
        cursor.close();
        return mineral;
    }
    public Cursor getMineral(String id) {
        return db.rawQuery("SELECT MINERAL FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYClase(String id) {
        return db.rawQuery("SELECT MINERAL, CLASE FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYFormula(String id) {
        return db.rawQuery("SELECT MINERAL, FORMULA FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYSistema(String id) {
        return db.rawQuery("SELECT MINERAL, SISTEMA FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYAmbientes(String id) {
        return db.rawQuery("SELECT MINERAL, TAMB1, AMB1, TAMB2, AMB2, TAMB3, AMB3, TAMB4, AMB4 FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYHabito(String id) {
        return db.rawQuery("SELECT MINERAL, HABITO, QHABITO FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYColor(String id) {
        return db.rawQuery("SELECT MINERAL, COLOR, QCOLOR FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYDiafanidad(String id) {
        return db.rawQuery("SELECT MINERAL, DIAFANIDAD, QDIAFANIDAD FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYBrillo(String id) {
        return db.rawQuery("SELECT MINERAL, BRILLO, QBRILLO FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYRaya(String id) {
        return db.rawQuery("SELECT MINERAL, RAYA, QRAYA FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYDensidad(String id) {
        return db.rawQuery("SELECT MINERAL, DENSIDAD, DENSIDADMEDIA FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYDureza(String id) {
        return db.rawQuery("SELECT MINERAL, DUREZA, DUREZAMEDIA FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getMineralYExfoliacion(String id) {
        return db.rawQuery("SELECT MINERAL, EXFOLIACION, QEXFOLIACION FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public Cursor getTipoYClase(String mineral) {
        return db.rawQuery("SELECT TIPO, CLASE FROM '"+table+"' WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getIdFromQuery(String query) {
        return db.rawQuery("SELECT ID FROM '"+table+"' WHERE MINERAL='"+query+"'", null);
    }
    public Cursor getIdFromMineral(String mineral) {
        return db.rawQuery("SELECT ID FROM '"+table+"' WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getMineralAll(String id) {
        return db.rawQuery("SELECT * FROM '"+table+"' WHERE ID="+id+"", null);
    }
    public boolean isMineral(String texto) {
        Cursor cursor = db.rawQuery("SELECT MINERAL FROM '"+table+"'", null);
        while (cursor.moveToNext()) {
            String mineral = cursor.getString(0);
            if (texto.equals(mineral)) {
                cursor.close();
                return true;
            }
        }
        cursor.close();
        return false;
    }
    public String getClass(String id) {
        Cursor cursor = db.rawQuery("SELECT CLASE FROM '"+table+"' WHERE ID='"+id+"'", null);
        String clase = "";
        while (cursor.moveToNext()) {
            clase = cursor.getString(0);
        }
        cursor.close();
        return clase;
    }
    public String getType(String id) {
        Cursor cursor = db.rawQuery("SELECT TIPO FROM '"+table+"' WHERE ID='"+id+"'", null);
        String tipo = "";
        while (cursor.moveToNext()) {
            tipo = cursor.getString(0);
        }
        cursor.close();
        return tipo;
    }
    public void closeDatabase() {
        db.close();
    }
}
