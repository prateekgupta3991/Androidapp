package bitspilani.goa.letsPlay.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TemplateService {

    @GET("v1/user")
    Call<String> getUsers();

}
