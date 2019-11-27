package in.dotworld.app1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;

import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Details_fragment extends Fragment implements NameClickListener{
        private AppCompatTextView name,lastname,mail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_details_fragment, container, false);
        name=(AppCompatTextView)view.findViewById(R.id.firstname);
        lastname=(AppCompatTextView)view.findViewById(R.id.lastname);
        mail=(AppCompatTextView)view.findViewById(R.id.mail);


        Bundle bundle= this.getArguments();
        if (bundle != null) {
            String Name = bundle.getString("first_name");
            String Lastname = bundle.getString("last_name");
            String Mail = bundle.getString("email");
            name.setText("First Name :"+Name);
            lastname.setText("Last Name :"+Lastname);
            mail.setText("Mail :"+Mail);
        }

    return view;
    }



    @Override
    public void onClick(Datum data) {
        name.setText("First Name :"+data.getFirst_name());
        lastname.setText("Last Name :"+data.getLast_name());
        mail.setText("Mail :"+data.getEmail());
    }
}
