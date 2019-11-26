package in.dotworld.app1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.ViewHolder> {
    List<Mail>maillist;

    public MailAdapter(List<Mail> maillist) {
        this.maillist = maillist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Mail mail=maillist.get(position);
            holder.header.setText(mail.getHeader());
            holder.subject.setText(mail.getSubject());
            holder.image.setImageResource(mail.getImage());
    }

    @Override
    public int getItemCount() {
        return maillist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView header,subject;
        CircularImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            header=(AppCompatTextView)itemView.findViewById(R.id.header);
            subject=(AppCompatTextView)itemView.findViewById(R.id.subject);
            image=(CircularImageView) itemView.findViewById(R.id.image);
        }
    }
}
