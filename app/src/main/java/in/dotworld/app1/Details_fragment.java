package in.dotworld.app1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Details_fragment extends Fragment {
        private AppCompatTextView name,lastname,mail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_details_fragment, container, false);
        name=(AppCompatTextView)view.findViewById(R.id.firstname);
        lastname=(AppCompatTextView)view.findViewById(R.id.lastname);
        mail=(AppCompatTextView)view.findViewById(R.id.mail);

       Bundle bundle=this.getArguments();
        String Name=bundle.getString("name").toString();
        String Lastname=bundle.getString("lastname").toString();
        String Mail=bundle.getString("mail").toString();

        name.setText("First Name :"+Name);
        lastname.setText("Last Name :"+Lastname);
        mail.setText("Mail :"+Mail);
    return view;
    }


}
