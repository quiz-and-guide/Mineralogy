package com.geology_quiz_and_guide.mineralogy;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import java.util.List;
public class ListViewAdapter extends BaseAdapter {
    private final Context context;
    private final List<MineralesAdapter.Minerales> items;
    public ListViewAdapter(Context context, List<MineralesAdapter.Minerales> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return this.items.size();
    }
    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            String isTablet = isTablet(this.context);
            switch (isTablet) {
                case "Phone":
                    rowView = inflater.inflate(R.layout.list_item_phone, parent, false);
                    break;
                case "Tablet7":
                    rowView = inflater.inflate(R.layout.list_item_tablet7, parent, false);
                    break;
                case "Tablet10":
                    rowView = inflater.inflate(R.layout.list_item_tablet7, parent, false);
                    break;
            }
        }
        TextView tvTitle = rowView.findViewById(R.id.tvw1);
        TextView tvTitle2 = rowView.findViewById(R.id.tw1);
        MineralesAdapter.Minerales item = this.items.get(position);
        tvTitle.setText(item.getNombre().toUpperCase());
        tvTitle2.setText(item.getTipo().toUpperCase());
        if (item.getTipo().equalsIgnoreCase("elementos nativos")||item.getTipo().equalsIgnoreCase("éléments natifs")||item.getTipo().equalsIgnoreCase("native elements")||item.getTipo().equalsIgnoreCase("elements nadius")||item.getTipo().equalsIgnoreCase("Самородки")||item.getTipo().equalsIgnoreCase("العناصر الأصلية")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_natives));
        } else if (item.getTipo().equalsIgnoreCase("sulfuros y sulfosales")||item.getTipo().equalsIgnoreCase("sulfures et sulfosels")||item.getTipo().equalsIgnoreCase("sulfides and sulfosalts")||item.getTipo().equalsIgnoreCase("sulfurs i sulfosals")||item.getTipo().equalsIgnoreCase("сульфиды и сульфосоли")||item.getTipo().equalsIgnoreCase("الكبريتيدات والسلفوسالت")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_sulfures));
        } else if (item.getTipo().equalsIgnoreCase("óxidos e hidróxidos")||item.getTipo().equalsIgnoreCase("oxydes et hydroxydes")||item.getTipo().equalsIgnoreCase("oxides and hydroxides")||item.getTipo().equalsIgnoreCase("òxids i hidròxids")||item.getTipo().equalsIgnoreCase("оксиды и гидроксиды")||item.getTipo().equalsIgnoreCase("الأكاسيد والهيدروكسيدات")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_oxides));
        } else if (item.getTipo().equalsIgnoreCase("haluros")||item.getTipo().equalsIgnoreCase("halogénures")||item.getTipo().equalsIgnoreCase("halides")||item.getTipo().equalsIgnoreCase("halurs")||item.getTipo().equalsIgnoreCase("галогениды")||item.getTipo().equalsIgnoreCase("الهاليدات")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_halides));
        } else if (item.getTipo().equalsIgnoreCase("carbonatos, nitratos y boratos")||item.getTipo().equalsIgnoreCase("carbonates, nitrates et borates")||item.getTipo().equalsIgnoreCase("carbonates, nitrates and borates")||item.getTipo().equalsIgnoreCase("carbonats, nitrats i borats")||item.getTipo().equalsIgnoreCase("карбонаты, нитраты и бораты")||item.getTipo().equalsIgnoreCase("الكربونات والنترات والبورات")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_carbonates));
        } else if (item.getTipo().equalsIgnoreCase("sulfatos, cromatos y seleniatos")||item.getTipo().equalsIgnoreCase("sulfates, chromates et séléniates")||item.getTipo().equalsIgnoreCase("sulfates, chromates and selenates")||item.getTipo().equalsIgnoreCase("sulfats, cromats i seleniats")||item.getTipo().equalsIgnoreCase("сульфаты, хроматы и селенаты")||item.getTipo().equalsIgnoreCase("الكبريتات والكرومات والسيلينات")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_sulfates));
        } else if (item.getTipo().equalsIgnoreCase("fosfatos, arseniatos y vanadatos")||item.getTipo().equalsIgnoreCase("phosphates, arséniates et vanadates")||item.getTipo().equalsIgnoreCase("phosphates, arsenates and vanadates")||item.getTipo().equalsIgnoreCase("fosfats, arseniats i vanadats")||item.getTipo().equalsIgnoreCase("Фосфаты, арсенаты и ванадаты")||item.getTipo().equalsIgnoreCase("الفوسفات والزرنيخات والفانادات")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_fosfates));
        } else if (item.getTipo().equalsIgnoreCase("nesosilicatos")||item.getTipo().equalsIgnoreCase("nésosilicates")||item.getTipo().equalsIgnoreCase("nesosilicates")||item.getTipo().equalsIgnoreCase("nesosilicats")||item.getTipo().equalsIgnoreCase("Ортосиликаты")||item.getTipo().equalsIgnoreCase("نيسوسيليكات")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_nesosilicates));
        } else if (item.getTipo().equalsIgnoreCase("sorosilicatos")||item.getTipo().equalsIgnoreCase("sorosilicates")||item.getTipo().equalsIgnoreCase("sorosilicats")||item.getTipo().equalsIgnoreCase("Соросиликаты")||item.getTipo().equalsIgnoreCase("سوروسيليكات")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_sorosilicates));
        } else if (item.getTipo().equalsIgnoreCase("ciclosilicatos")||item.getTipo().equalsIgnoreCase("cyclosilicates")||item.getTipo().equalsIgnoreCase("ciclosilicats")||item.getTipo().equalsIgnoreCase("Кольцевые силикаты")||item.getTipo().equalsIgnoreCase("السيكلوسيليكات")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_ciclosilicates));
        } else if (item.getTipo().equalsIgnoreCase("inosilicatos") || item.getTipo().equalsIgnoreCase("inosilicates") || item.getTipo().equalsIgnoreCase("inosilicats") || item.getTipo().equalsIgnoreCase("Ленточные силикаты") || item.getTipo().equalsIgnoreCase("اينوسيليكات")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_inosilicates));
        } else if (item.getTipo().equalsIgnoreCase("filosilicatos") || item.getTipo().equalsIgnoreCase("phyllosilicates") || item.getTipo().equalsIgnoreCase("fil·losilicats") || item.getTipo().equalsIgnoreCase("Филлосиликаты") || item.getTipo().equalsIgnoreCase("فيلوسيليكات")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_filosilicates));
        } else if (item.getTipo().equalsIgnoreCase("tectosilicatos") || item.getTipo().equalsIgnoreCase("tectosilicates") || item.getTipo().equalsIgnoreCase("tectosilicats") || item.getTipo().equalsIgnoreCase("Каркасные силикаты") || item.getTipo().equalsIgnoreCase("التكتوسيليكات")) {
            tvTitle2.setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.redondeo_tectosilicates));
        }

        return rowView;
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
}
