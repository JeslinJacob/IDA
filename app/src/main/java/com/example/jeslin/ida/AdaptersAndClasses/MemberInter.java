package com.example.jeslin.ida.AdaptersAndClasses;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JeSLiN on 22-09-2017.
 */

public interface MemberInter {

    @GET("users/details/type/")
    Call<ArrayList<MemberClass>> getMyObjects();
}
