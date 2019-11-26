package in.dotworld.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

        private RecyclerView recyclerView;
        private UserAdapter userAdapter;
        private APIInterface apiInterface;
        private List<Datum>data;
        ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        apiInterface=APIClient.getClient().create(APIInterface.class);
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        loaddata();
    }

    private void loaddata() {
        Call<Datumlist>call=apiInterface.getdatalist();
        call.enqueue(new Callback<Datumlist>() {
            @Override
            public void onResponse(Call<Datumlist> call, Response<Datumlist> response) {
                progressDoalog.dismiss();
                if(response.isSuccessful()){
                    data=response.body().getData();
                    userAdapter=new UserAdapter(data,getApplicationContext());
                    recyclerView.setAdapter(userAdapter);
                   // recyclerView.setAdapter(new UserAdapter(data,getApplicationContext()));
                }

            }

            @Override
            public void onFailure(Call<Datumlist> call, Throwable t) {
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }



}

