package in.planet.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import in.planet.retrofitexample.model.User;
import in.planet.retrofitexample.rest.Api;
import in.planet.retrofitexample.rest.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data=findViewById(R.id.data);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();
        Api service = RetrofitClient.getInstance().create(Api.class);
        Call<List<User>> call = service.getAllUser();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                progressDialog.dismiss();
                showData(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void showData(List<User> user)
    {
     for(User u : user)
     {
         String context ="";

         context+="Id : "+u.getId()+"\n";
         context+="Name : "+u.getName()+"\n";
         context+="UserName : "+u.getUserName()+"\n";
         context+="Email : "+u.getEmail()+"\n";
         context+="Address : "+u.getAddress().getStreet()+" "+u.getAddress().getSuite()+" "+u.getAddress().getCity()+" "+u.getAddress().getZipCode()+" "+u.getAddress().getGeo().getLat()+" "+u.getAddress().getGeo().getLng()+"\n";
         context+="Phone : "+u.getPhone()+"\n";
         context+="Website : "+u.getWebsite()+"\n";
         context+="CompanyName : "+u.getCompany().getName()+"\n";
         context+="CatchPhrase : "+u.getCompany().getCatchPhrase()+"\n";
         context+="Bs : "+u.getCompany().getBs()+"\n\n";
         data.append(context);
     }
    }
}