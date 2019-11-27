package in.dotworld.app1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<Datum> data;
    private Context mContext;
    private NameClickListener listener;


    public UserAdapter(List<Datum> data, Context mContext, NameClickListener l) {
        this.data = data;
        this.mContext = mContext;
        this.listener = l;
    }

    public UserAdapter(NameClickListener l) {
        this.listener = l;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, final int position) {
        Datum datalist = data.get(position);
        holder.firstname.setText(datalist.getFirst_name());
        holder.firstname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(datalist);
            }
        });

        //Toast.makeText(mContext, ""+Integer.toString(position+1), Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView firstname, lastname, mail;
        private NameClickListener clickListener;

        public ViewHolder(@NonNull View itemView, NameClickListener clickListener) {

            super(itemView);
            this.clickListener = clickListener;
            firstname = (AppCompatTextView) itemView.findViewById(R.id.firstname);
            lastname = (AppCompatTextView) itemView.findViewById(R.id.lastname);
            mail = (AppCompatTextView) itemView.findViewById(R.id.mail);
//            itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View v) {
//            Log.d("Tag", "position" + getAdapterPosition());
//            //clickListener.onClick(v,getAdapterPosition());
//            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
//        }


    }


}

