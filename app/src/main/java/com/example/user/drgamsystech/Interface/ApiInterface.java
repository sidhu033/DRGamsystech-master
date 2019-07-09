package com.example.user.drgamsystech.Interface;



import com.example.user.drgamsystech.pojo.ChangePinResPojo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface
{

    @POST("ChangePin")
    Call<ChangePinResPojo> getChangePinCall                                             //response class
            (
                    @Query("UserId") Integer UserId,
                    @Query("CurrentPin") String CurrentPin,
                    @Query("NewPin") String NewPin
            );

    //@POST("Login")
   // Call<ResponseBody> login(@Path("Login") String postfix, @Body RequestBody params);
}
