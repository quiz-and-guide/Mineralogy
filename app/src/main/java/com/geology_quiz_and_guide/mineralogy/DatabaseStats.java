package com.geology_quiz_and_guide.mineralogy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DatabaseStats extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "STATS.db";
    private static final int DATABASE_VERSION = 2;
    private SQLiteDatabase db;
    private Context context;
    public DatabaseStats(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        setForcedUpgrade();
        db = getWritableDatabase();
        context.deleteDatabase("STATS.db");
    }
    public ArrayList<String> getMonths(String year) {
        ArrayList<String> months = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT DATE FROM TYPE",null);
        while (cursor.moveToNext()) {
            if (cursor.getString(0).substring(0,4).equals(year)) {
                String month = cursor.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor.close();
        Cursor cursor2 = db.rawQuery("SELECT DATE FROM CLASS",null);
        while (cursor2.moveToNext()) {
            if (cursor2.getString(0).substring(0,4).equals(year)) {
                String month = cursor2.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor2.close();
        Cursor cursor3 = db.rawQuery("SELECT DATE FROM FORMULA",null);
        while (cursor3.moveToNext()) {
            if (cursor3.getString(0).substring(0,4).equals(year)) {
                String month = cursor3.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor3.close();
        Cursor cursor4 = db.rawQuery("SELECT DATE FROM SYSTEM",null);
        while (cursor4.moveToNext()) {
            if (cursor4.getString(0).substring(0,4).equals(year)) {
                String month = cursor4.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor4.close();
        Cursor cursor5 = db.rawQuery("SELECT DATE FROM ENVS",null);
        while (cursor5.moveToNext()) {
            if (cursor5.getString(0).substring(0,4).equals(year)) {
                String month = cursor5.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor5.close();
        Cursor cursor6 = db.rawQuery("SELECT DATE FROM HABIT",null);
        while (cursor6.moveToNext()) {
            if (cursor6.getString(0).substring(0,4).equals(year)) {
                String month = cursor6.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor6.close();
        Cursor cursor7 = db.rawQuery("SELECT DATE FROM COLOR",null);
        while (cursor7.moveToNext()) {
            if (cursor7.getString(0).substring(0,4).equals(year)) {
                String month = cursor7.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor7.close();
        Cursor cursor8 = db.rawQuery("SELECT DATE FROM LUSTER",null);
        while (cursor8.moveToNext()) {
            if (cursor8.getString(0).substring(0,4).equals(year)) {
                String month = cursor8.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor8.close();
        Cursor cursor9 = db.rawQuery("SELECT DATE FROM STREAK",null);
        while (cursor9.moveToNext()) {
            if (cursor9.getString(0).substring(0,4).equals(year)) {
                String month = cursor9.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor9.close();
        Cursor cursor10 = db.rawQuery("SELECT DATE FROM DIAPHANEITY",null);
        while (cursor10.moveToNext()) {
            if (cursor10.getString(0).substring(0,4).equals(year)) {
                String month = cursor10.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor10.close();
        Cursor cursor11 = db.rawQuery("SELECT DATE FROM HARDNESS",null);
        while (cursor11.moveToNext()) {
            if (cursor11.getString(0).substring(0,4).equals(year)) {
                String month = cursor11.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor11.close();
        Cursor cursor12 = db.rawQuery("SELECT DATE FROM DENSITY",null);
        while (cursor12.moveToNext()) {
            if (cursor12.getString(0).substring(0,4).equals(year)) {
                String month = cursor12.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor12.close();
        Cursor cursor13 = db.rawQuery("SELECT DATE FROM CLEAVAGE",null);
        while (cursor13.moveToNext()) {
            if (cursor13.getString(0).substring(0,4).equals(year)) {
                String month = cursor13.getString(0).substring(5, 7);
                months.add(month);
            }
        }
        cursor13.close();
        Set<String> set = new HashSet<>(months);
        months.clear();
        months.addAll(set);
        return months;
    }
    public ArrayList<String> getYears() {
        ArrayList<String> years = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT DATE FROM TYPE",null);
        while (cursor.moveToNext()) {
            String year = cursor.getString(0).substring(0,4);
            years.add(year);
        }
        cursor.close();
        Cursor cursor2 = db.rawQuery("SELECT DATE FROM CLASS",null);
        while (cursor2.moveToNext()) {
            String year = cursor2.getString(0).substring(0,4);
            years.add(year);
        }
        cursor2.close();
        Cursor cursor3 = db.rawQuery("SELECT DATE FROM FORMULA",null);
        while (cursor3.moveToNext()) {
            String year = cursor3.getString(0).substring(0,4);
            years.add(year);
        }
        cursor3.close();
        Cursor cursor4 = db.rawQuery("SELECT DATE FROM SYSTEM",null);
        while (cursor4.moveToNext()) {
            String year = cursor4.getString(0).substring(0,4);
            years.add(year);
        }
        cursor4.close();
        Cursor cursor5 = db.rawQuery("SELECT DATE FROM ENVS",null);
        while (cursor5.moveToNext()) {
            String year = cursor5.getString(0).substring(0,4);
            years.add(year);
        }
        cursor5.close();
        Cursor cursor6 = db.rawQuery("SELECT DATE FROM HABIT",null);
        while (cursor6.moveToNext()) {
            String year = cursor6.getString(0).substring(0,4);
            years.add(year);
        }
        cursor6.close();
        Cursor cursor7 = db.rawQuery("SELECT DATE FROM COLOR",null);
        while (cursor7.moveToNext()) {
            String year = cursor7.getString(0).substring(0,4);
            years.add(year);
        }
        cursor7.close();
        Cursor cursor8 = db.rawQuery("SELECT DATE FROM LUSTER",null);
        while (cursor8.moveToNext()) {
            String year = cursor8.getString(0).substring(0,4);
            years.add(year);
        }
        cursor8.close();
        Cursor cursor9 = db.rawQuery("SELECT DATE FROM STREAK",null);
        while (cursor9.moveToNext()) {
            String year = cursor9.getString(0).substring(0,4);
            years.add(year);
        }
        cursor9.close();
        Cursor cursor10 = db.rawQuery("SELECT DATE FROM DIAPHANEITY",null);
        while (cursor10.moveToNext()) {
            String year = cursor10.getString(0).substring(0,4);
            years.add(year);
        }
        cursor10.close();
        Cursor cursor11 = db.rawQuery("SELECT DATE FROM HARDNESS",null);
        while (cursor11.moveToNext()) {
            String year = cursor11.getString(0).substring(0,4);
            years.add(year);
        }
        cursor11.close();
        Cursor cursor12 = db.rawQuery("SELECT DATE FROM DENSITY",null);
        while (cursor12.moveToNext()) {
            String year = cursor12.getString(0).substring(0,4);
            years.add(year);
        }
        cursor12.close();
        Cursor cursor13 = db.rawQuery("SELECT DATE FROM CLEAVAGE",null);
        while (cursor13.moveToNext()) {
            String year = cursor13.getString(0).substring(0,4);
            years.add(year);
        }
        cursor13.close();
        Set<String> set = new HashSet<>(years);
        years.clear();
        years.addAll(set);
        return years;
    }
    public ArrayList<ArrayList<String>> getAllType() {
        Cursor cursor = db.rawQuery("SELECT * FROM TYPE", null);
        ArrayList<ArrayList<String>> type = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            type.add(entry);
        }
        cursor.close();
        return type;
    }
    public ArrayList<ArrayList<String>> getAllClass() {
        Cursor cursor = db.rawQuery("SELECT * FROM CLASS", null);
        ArrayList<ArrayList<String>> clase = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            clase.add(entry);
        }
        cursor.close();
        return clase;
    }
    public ArrayList<ArrayList<String>> getAllFormula() {
        Cursor cursor = db.rawQuery("SELECT * FROM FORMULA", null);
        ArrayList<ArrayList<String>> formula = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            formula.add(entry);
        }
        cursor.close();
        return formula;
    }
    public ArrayList<ArrayList<String>> getAllSystem() {
        Cursor cursor = db.rawQuery("SELECT * FROM SYSTEM", null);
        ArrayList<ArrayList<String>> system = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            system.add(entry);
        }
        cursor.close();
        return system;
    }
    public ArrayList<ArrayList<String>> getAllEnvs() {
        Cursor cursor = db.rawQuery("SELECT * FROM ENVS", null);
        ArrayList<ArrayList<String>> envs = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            envs.add(entry);
        }
        cursor.close();
        return envs;
    }
    public ArrayList<ArrayList<String>> getAllHabit() {
        Cursor cursor = db.rawQuery("SELECT * FROM HABIT", null);
        ArrayList<ArrayList<String>> habit = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            habit.add(entry);
        }
        cursor.close();
        return habit;
    }
    public ArrayList<ArrayList<String>> getAllColor() {
        Cursor cursor = db.rawQuery("SELECT * FROM COLOR", null);
        ArrayList<ArrayList<String>> color = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            color.add(entry);
        }
        cursor.close();
        return color;
    }
    public ArrayList<ArrayList<String>> getAllLuster() {
        Cursor cursor = db.rawQuery("SELECT * FROM LUSTER", null);
        ArrayList<ArrayList<String>> luster = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            luster.add(entry);
        }
        cursor.close();
        return luster;
    }
    public ArrayList<ArrayList<String>> getAllStreak() {
        Cursor cursor = db.rawQuery("SELECT * FROM STREAK", null);
        ArrayList<ArrayList<String>> streak = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            streak.add(entry);
        }
        cursor.close();
        return streak;
    }
    public ArrayList<ArrayList<String>> getAllDiaphaneity() {
        Cursor cursor = db.rawQuery("SELECT * FROM DIAPHANEITY", null);
        ArrayList<ArrayList<String>> diaphaneity = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            diaphaneity.add(entry);
        }
        cursor.close();
        return diaphaneity;
    }
    public ArrayList<ArrayList<String>> getAllHardness() {
        Cursor cursor = db.rawQuery("SELECT * FROM HARDNESS", null);
        ArrayList<ArrayList<String>> hardness = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            hardness.add(entry);
        }
        cursor.close();
        return hardness;
    }
    public ArrayList<ArrayList<String>> getAllDensity() {
        Cursor cursor = db.rawQuery("SELECT * FROM DENSITY", null);
        ArrayList<ArrayList<String>> density = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            density.add(entry);
        }
        cursor.close();
        return density;
    }
    public ArrayList<ArrayList<String>> getAllCleavage() {
        Cursor cursor = db.rawQuery("SELECT * FROM CLEAVAGE", null);
        ArrayList<ArrayList<String>> cleavage = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> entry = new ArrayList<>();
            entry.add(cursor.getString(0));
            entry.add(cursor.getString(1));
            entry.add(cursor.getString(2));
            cleavage.add(entry);
        }
        cursor.close();
        return cleavage;
    }

    public Cursor getAllTypeMineral(String mineral) {
        return db.rawQuery("SELECT * FROM TYPE WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllClassMineral(String mineral) {
        return db.rawQuery("SELECT * FROM CLASS WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllFormulaMineral(String mineral) {
        return db.rawQuery("SELECT * FROM FORMULA WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllSystemMineral(String mineral) {
        return db.rawQuery("SELECT * FROM SYSTEM WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllEnvsMineral(String mineral) {
        return db.rawQuery("SELECT * FROM ENVS WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllHabitMineral(String mineral) {
        return db.rawQuery("SELECT * FROM HABIT WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllColorMineral(String mineral) {
        return db.rawQuery("SELECT * FROM COLOR WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllLusterMineral(String mineral) {
        return db.rawQuery("SELECT * FROM LUSTER WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllStreakMineral(String mineral) {
        return db.rawQuery("SELECT * FROM STREAK WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllDiaphaneityMineral(String mineral) {
        return db.rawQuery("SELECT * FROM DIAPHANEITY WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllHardnessMineral(String mineral) {
        return db.rawQuery("SELECT * FROM HARDNESS WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllDensityMineral(String mineral) {
        return db.rawQuery("SELECT * FROM DENSITY WHERE MINERAL='"+mineral+"'", null);
    }
    public Cursor getAllCleavageMineral(String mineral) {
        return db.rawQuery("SELECT * FROM CLEAVAGE WHERE MINERAL='"+mineral+"'", null);
    }

    public void insertRandom(){
        ContentValues myValues = new ContentValues();
        Random random = new Random();
        int randomDay = random.nextInt(7);
        String day = "";
        if (randomDay==0) {
            day="Mon";
        } else if (randomDay==1) {
            day="Tue";
        } else if (randomDay==2) {
            day="Wed";
        } else if (randomDay==3) {
            day="Thu";
        } else if (randomDay==4) {
            day="Fri";
        } else if (randomDay==5) {
            day="Sat";
        } else {
            day="Sun";
        }
        String dayYear = "";
        int randomDayYear = random.nextInt(365);
        if (String.valueOf(randomDayYear+1).length()==1) {
            dayYear = "0"+String.valueOf(randomDayYear+1);
        } else {
            dayYear = String.valueOf(randomDayYear+1);
        }
        String dayMonth = "";
        int randomDayMonth = random.nextInt(31);
        if (String.valueOf(randomDayMonth+1).length()==1) {
            dayMonth = "0"+String.valueOf(randomDayMonth+1);
        } else {
            dayMonth = String.valueOf(randomDayMonth+1);
        }
        String month = "";
        int randomMonth = random.nextInt(12);
        if (String.valueOf(randomMonth+1).length()==1) {
            month = "0"+String.valueOf(randomMonth+1);
        } else {
            month = String.valueOf(randomMonth+1);
        }
        String year = "2023";
        String weekMonth = "";
        int randomWeekMonth = random.nextInt(5);
        weekMonth = "0"+String.valueOf(randomWeekMonth+1);
        String weekYear = "";
        int randomWeekYear = random.nextInt(52);
        if (String.valueOf(randomWeekYear+1).length()==1) {
            weekYear = "0"+String.valueOf(randomWeekYear+1);
        } else {
            weekYear = String.valueOf(randomWeekYear+1);
        }
        String hour = "";
        int randomHour = random.nextInt(24);
        if (String.valueOf(randomHour+1).length()==1) {
            hour = "0"+String.valueOf(randomHour+1);
        } else {
            hour = String.valueOf(randomHour+1);
        }
        String date = year + "_" + month + "_" + dayMonth + "_" + hour + "_" + day + "_" + weekMonth + "_" + weekYear;
        myValues.put("DATE",date);
        int randomCorrect = random.nextInt(60)+1;
        Database myDb = new Database(context);
        Cursor cursor = myDb.getMineral(String.valueOf(randomCorrect));
        String mineralCorrect = "";
        while (cursor.moveToNext()) {
            mineralCorrect = cursor.getString(0);
        }
        Database myDb2 = new Database(this.context);
        myValues.put("MINERALCORRECT",myDb2.getId(mineralCorrect));
        int randomType = random.nextInt(13);
        String typeQuestion = "";
        if (randomType==0) {
            typeQuestion = "TYPE";
        } else if (randomType==1) {
            typeQuestion = "CLASS";
        } else if (randomType==2) {
            typeQuestion = "FORMULA";
        } else if (randomType==3) {
            typeQuestion = "SYSTEM";
        } else if (randomType==4) {
            typeQuestion = "ENVS";
        } else if (randomType==5) {
            typeQuestion = "HABIT";
        } else if (randomType==6) {
            typeQuestion = "COLOR";
        } else if (randomType==7) {
            typeQuestion = "LUSTER";
        } else if (randomType==8) {
            typeQuestion = "STREAK";
        } else if (randomType==9) {
            typeQuestion = "DIAPHANEITY";
        } else if (randomType==10) {
            typeQuestion = "HARDNESS";
        } else if (randomType==11) {
            typeQuestion = "DENSITY";
        } else {
            typeQuestion = "CLEAVAGE";
        }
        int randomcorrect = random.nextInt(14);
        if (myDb.getClass(myDb2.getId(mineralCorrect)).equals("Elementos nativos")||myDb.getClass(myDb2.getId(mineralCorrect)).equals("Native Elements")) {
            if (randomcorrect>12) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equals("Sulfuros y sulfosales")||myDb.getClass(myDb2.getId(mineralCorrect)).equals("Sulfides and sulfosalts")) {
            if (randomcorrect>11) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("óxidos e hidróxidos")||myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("oxides and hydroxides")) {
            if (randomcorrect>10) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("haluros")||myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("halides")) {
            if (randomcorrect>9) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("carbonatos, nitratos y boratos")||myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("carbonates, nitrates and borates")) {
            if (randomcorrect>8) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("sulfatos, cromatos y seleniatos")||myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("sulfates, chromates and selenates")) {
            if (randomcorrect>7) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("fosfatos, arseniatos y vanadatos")||myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("phosphates, arsenates and vanadates")) {
            if (randomcorrect>6) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("nesosilicatos")||myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("nesosilicates")) {
            if (randomcorrect>5) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("sorosilicatos")||myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("sorosilicates")) {
            if (randomcorrect>4) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("ciclosilicatos")||myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("cyclosilicates")) {
            if (randomcorrect>3) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("inosilicatos")||myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("inosilicates")) {
            if (randomcorrect>2) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("filosilicatos")||myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("phyllosilicates")) {
            if (randomcorrect>1) {
                myValues.put("CORRECT", "0");
            } else {
                myValues.put("CORRECT","1");
            }
        } else if (myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("tectosilicatos")||myDb.getClass(myDb2.getId(mineralCorrect)).equalsIgnoreCase("tectosilicates")) {
            if (randomcorrect>0) {
                Log.i("Incorrect ", " ");
                myValues.put("CORRECT", "0");
            } else {
                Log.i("Correct ", " ");
                myValues.put("CORRECT","1");
            }
        } else {
            myValues.put("CORRECT","1");
        }
        db.insert(typeQuestion, null, myValues);
    }

    public void insertQuestion(String date, String mineralCorrect, String typeQuestion, String correct) {
        Database myDb = new Database(this.context);
        ContentValues myValues = new ContentValues();
        myValues.put("DATE",date);
        myValues.put("MINERALCORRECT",myDb.getId(mineralCorrect));
        myValues.put("CORRECT",correct);
        myDb.closeDatabase();
        db.insert(typeQuestion, null, myValues);
    }

    public void closeDatabase() {
        db.close();
    }
}
