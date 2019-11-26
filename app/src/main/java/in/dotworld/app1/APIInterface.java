package in.dotworld.app1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/api/users?page=2")
    Call <Datumlist>getdatalist();
}
