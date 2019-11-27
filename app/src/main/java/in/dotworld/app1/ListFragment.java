package in.dotworld.app1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListFragment extends Fragment implements NameClickListener{

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private APIInterface apiInterface;
    private List<Datum> data;
    ProgressDialog progressDoalog;
    NameClickListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_list, container, false);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);


        /*listener = (v, position) -> {
            Toast.makeText(getContext(), "123", Toast.LENGTH_SHORT).show();
        };*/


        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        loaddata();
        return view;
    }

    private void loaddata() {
        Call<Datumlist> call = apiInterface.getdatalist();
        call.enqueue(new Callback<Datumlist>() {
            @Override
            public void onResponse(Call<Datumlist> call, Response<Datumlist> response) {
                progressDoalog.dismiss();
                if (response.isSuccessful()) {
                    data = response.body().getData();
                    userAdapter = new UserAdapter(data, getContext(), ListFragment.this::onClick);
                    recyclerView.setAdapter(userAdapter);
                    // recyclerView.setAdapter(new UserAdapter(data,getApplicationContext()));
                }

            }

            @Override
            public void onFailure(Call<Datumlist> call, Throwable t) {
                call.cancel();
            }
        });
    }


    @Override
    public void onClick(Datum datum) {
       // Log.d(ListFragment.class.getSimpleName(),"clicked"+ String.valueOf(position));
        Bundle bundle = new Bundle();
        bundle.putString("first_name", datum.getFirst_name());
        bundle.putString("last_name",datum.getLast_name());
        bundle.putString("email",datum.getEmail());
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            openFragment(new Details_fragment(),bundle);
        }else{

        }
    }

    private void openFragment(Fragment fragment,Bundle bundle){
        fragment.setArguments(bundle);
        FragmentManager fragmentManager=getActivity().getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
