package com.emirozder.superlig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//https://apiv3.apifootball.com/?action=get_standings&league_id=322&APIkey=36dbf4d2ec126e7cc581de915792242ee81ce9186b0becda096499a196de205d
public interface SuperLigApi {
    @GET("?action=get_standings&league_id=322&APIkey=36dbf4d2ec126e7cc581de915792242ee81ce9186b0becda096499a196de205d")
    Call<List<SuperLig>> GetSuperLig();
}
