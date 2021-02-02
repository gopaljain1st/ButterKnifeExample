package in.planet.retrofitexample.rest;

import java.util.List;

import in.planet.retrofitexample.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api
{
    @GET("/users")
    Call<List<User>> getAllUser();
}
