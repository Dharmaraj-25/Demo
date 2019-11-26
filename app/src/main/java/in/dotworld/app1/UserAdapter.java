package in.dotworld.app1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<Datum>data;
    private Context mContext;

    public UserAdapter(List<Datum> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, final int position) {
        holder.firstname.setText(data.get(position).getFirst_name());
        holder.firstname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, ""+data.get(position).getEmail(), Toast.LENGTH_SHORT).show();
            }
        });
        //holder.lastname.setText(data.get(position).getLast_name());
        //holder.mail.setText(data.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        private AppCompatTextView firstname,lastname,mail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname=(AppCompatTextView)itemView.findViewById(R.id.firstname);
            lastname=(AppCompatTextView)itemView.findViewById(R.id.lastname);
            mail=(AppCompatTextView)itemView.findViewById(R.id.mail);
            //itemView.setOnClickListener(this);
        }

      /* @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Activity activity = (Activity) v.getContext();
            Details_fragment details_fragment=new Details_fragment();
           *//* Bundle bundle=new Bundle();
            bundle.putString("name",""+data.get(itemPosition).getFirstName());
            bundle.putString("lastname",""+data.get(itemPosition).getLastName());
            bundle.putString("mail",""+data.get(itemPosition).getEmail());
            details_fragment.setArguments(bundle);*//*
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,details_fragment).addToBackStack(null).commit();


            }*/
        }
    }

