package com.virtualbox.torchick.sitani.Network;

import com.virtualbox.torchick.sitani.Model.Image;
import com.virtualbox.torchick.sitani.Model.LinkDataForm;
import com.virtualbox.torchick.sitani.Model.Publikasi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Torchick on 27/03/2017.
 */

public interface ApiInterface {
    //Publikasi
    @GET("/trickster/index.php")
    Call<List<Publikasi>> getPublikasi(@Query("r") String address);

    @GET("/trickster/index.php")
    Call<List<Publikasi>> getPublikasiSearch(@Query("r") String address, @Query("id") String searchQuery);

    @GET("/trickster/index.php")
    Call<List<Publikasi>> getPublikasiOffset(@Query("r") String address, @Query("offset") String offset, @Query("limit") String limit);



    //Infografis
    @GET("/sisera/sisera.json")
    Call<List<Image>> getImages(@Query("r") String address);

    //Link Sultradata
    @GET("/project/SISERA_2/data/detailx")
    Call<List<LinkDataForm>> getLinkDataForm(@Query("id") String id);

    @GET("/project/SISERA_2/data/detailxy")
    Call<List<LinkDataForm>> getLinkDataFormSearch(@Query("id") String id);


}
