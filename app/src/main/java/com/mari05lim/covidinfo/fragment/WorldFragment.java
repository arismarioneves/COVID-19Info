package com.mari05lim.covidinfo.fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mari05lim.covidinfo.R;
import com.mari05lim.covidinfo.viewmodel.WorldViewModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorldFragment extends Fragment {

    private ProgressDialog mProgressApp;

    @SuppressLint("SimpleDateFormat")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_world, container, false);

        mProgressApp = new ProgressDialog(getActivity());
        mProgressApp.setTitle(getResources().getString(R.string.loading_title));
        mProgressApp.setCancelable(false);
        mProgressApp.setMessage(getResources().getString(R.string.loading_message));
        mProgressApp.show();

        PieChart pieChart = view.findViewById(R.id.worldSummaryPie);
        WorldViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(WorldViewModel.class);
        viewModel.setWorldData();
        viewModel.getWorldData().observe(this, worldModel -> {
            mProgressApp.dismiss();
            List<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(worldModel.getConfirmed().getValue(), getResources().getString(R.string.confirmed)));
            entries.add(new PieEntry(worldModel.getRecovered().getValue(), getResources().getString(R.string.recovered)));
            entries.add(new PieEntry(worldModel.getDeaths().getValue(), getResources().getString(R.string.deaths)));

            PieDataSet pieDataSet = new PieDataSet(entries, getResources().getString(R.string.corona));
            pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
            pieDataSet.setValueTextColor(Color.WHITE);
            pieDataSet.setValueTextSize(14);

            Description description = new Description();

            Date data = null;
            try {
                data = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(worldModel.getLastUpdate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String formattedDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);

            description.setText(getResources().getString(R.string.last_update) + " : " + formattedDate);
            description.setTextColor(Color.BLACK);
            description.setTextSize(12);

            Legend legend = pieChart.getLegend();
            legend.setTextColor(Color.BLACK);
            legend.setTextSize(12);
            legend.setForm(Legend.LegendForm.SQUARE);

            PieData pieData = new PieData(pieDataSet);
            pieChart.setVisibility(View.VISIBLE);
            pieChart.animateXY(2000, 2000);
            pieChart.setDescription(description);
            pieChart.setHoleColor(Color.TRANSPARENT);
            pieChart.setHoleRadius(60);
            pieChart.setRotationAngle(320);
            pieChart.setData(pieData);
        });
        return view;
    }

}
