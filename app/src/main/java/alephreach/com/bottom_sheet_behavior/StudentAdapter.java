package alephreach.com.bottom_sheet_behavior;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> mStudentList;
    private Listener mListener;

    public void setListener (Listener listener) {
        this.mListener = listener;
    }

    public void bindData(List<Student> s) {
        this.mStudentList = s;
    }

    public interface Listener {
        void onItemClicked(Student s);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_list, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.mStudentName.setText(mStudentList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        Log.d("Activity", Integer.toString(mStudentList.size()));
        return mStudentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mStudentName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mStudentName = itemView.findViewById(R.id.student_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(mStudentList.get(getAdapterPosition()));
                }
            });

        }
    }
}
