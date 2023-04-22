package com.emirozder.superlig;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TeamAdapter extends ArrayAdapter<String> {
    private String[] teams;
    private int[] badges;
    private Context context;
    private TextView teamName, teamPoint;
    private ImageView teamBadge;
    private ArrayList<SuperLig> points;

    public TeamAdapter(String[] teams, int[] badges, ArrayList<SuperLig> points, Context context){
        super(context, R.layout.team_item,teams);
        this.teams = teams;
        this.badges = badges;
        this.points = points;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.team_item, null);
        if (view != null){
            teamName = (TextView) view.findViewById(R.id.txt_teamName);
            teamPoint = (TextView) view.findViewById(R.id.txt_teamPoint);
            teamBadge = (ImageView) view.findViewById(R.id.team_badge);

            teamName.setText(teams[position]);
            teamPoint.setText(points.get(position).getOverallLeaguePTS());
            teamBadge.setBackgroundResource(badges[position]);
        }
        return view;
    }
}
