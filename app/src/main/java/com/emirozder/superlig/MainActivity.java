package com.emirozder.superlig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] teams = {"Galatasaray","Fenerbahçe","Beşiktaş","Adana Demirspor","Trabzonspor","Medipol Başakşehir","Yukatel Kayserispor","arabam.com Konyaspor",
            "Vavacars Fatih Karagümrük","Fraport TAV Antalyaspor","Corendon Alanyaspor","Demir Grup Sivasspor","Kasımpaşa","Gaziantep Futbol Kulübü",
            "MKE Ankaragücü","İstanbulspor","Bitexen Giresunspor","Atakaş Hatayspor","HangiKredi Ümraniyespor"};
    private int[] badges = {R.drawable.gs,R.drawable.fb,R.drawable.bjk,R.drawable.ads,R.drawable.ts,R.drawable.basak,R.drawable.kayseri,R.drawable.konya,
            R.drawable.kgumruk,R.drawable.antalya,R.drawable.alanya,R.drawable.sivas,R.drawable.kpasa,R.drawable.gantep,R.drawable.agucu,
            R.drawable.istanbul,R.drawable.giresun,R.drawable.hatay,R.drawable.umraniye};

    private TeamAdapter teamAdapter;

    private void init(ArrayList<SuperLig> points){
        mListView = (ListView)findViewById(R.id.listView1);
        teamAdapter = new TeamAdapter(teams,badges,points,this);
        mListView.setAdapter(teamAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        setRetrofitSettings();
    }

    private void setRetrofitSettings(){
        Gson gson = new GsonBuilder().setLenient().create();
        String baseUrl = "https://apiv3.apifootball.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        SuperLigApi superLigApi;
        superLigApi = retrofit.create(SuperLigApi.class);
        Call<List<SuperLig>> call = superLigApi.GetSuperLig();
        call.enqueue(new Callback<List<SuperLig>>() {
            @Override
            public void onResponse(Call<List<SuperLig>> call, Response<List<SuperLig>> response) {
                if (response.isSuccessful()){
                    ArrayList<SuperLig> points = new ArrayList<>();
                    points = (ArrayList<SuperLig>) response.body();
                    init(points);
                }
            }

            @Override
            public void onFailure(Call<List<SuperLig>> call, Throwable t) {
                System.out.println(t.toString());
            }
        });
    }

}