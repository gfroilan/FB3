package com.example.gillien.feelsbook3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewStats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats);
        AnyChartView anyChartView = findViewById(R.id.any_chart_view);

        Pie pie = AnyChart.pie();

        ArrayList<String> emotionList = EmotionRecorded.userData;
        int love_count = Collections.frequency(emotionList, "love");
        int anger_count = Collections.frequency(emotionList, "anger");
        int joy_count = Collections.frequency(emotionList, "joy");
        int fear_count = Collections.frequency(emotionList, "fear");
        int surprise_count = Collections.frequency(emotionList, "surprise");
        int sadness_count = Collections.frequency(emotionList, "sadness");

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Love", love_count));
        data.add(new ValueDataEntry("Anger", anger_count));
        data.add(new ValueDataEntry("Joy", joy_count));
        data.add(new ValueDataEntry("Fear", fear_count));
        data.add(new ValueDataEntry("Surprise", surprise_count));
        data.add(new ValueDataEntry("Sadness", sadness_count));

        pie.data(data);

        anyChartView.setChart(pie);

    }

    public static Intent makeStatsIntent(Context context) {
        return new Intent(context, ViewStats.class);
    }
}
