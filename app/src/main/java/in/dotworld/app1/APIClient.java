package in.dotworld.app1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofit = null;

    static Retrofit getClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        return retrofit;
}}
