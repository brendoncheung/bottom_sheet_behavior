package alephreach.com.bottom_sheet_behavior;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentAdapter.Listener {

    CoordinatorLayout mLinearLayout;
    BottomSheetBehavior mBottomSheetBehavior;
    RecyclerView mRecyclerView;
    Toolbar mToolbar;

    TextView mStudentName, mStudentAge, mStudentHobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStudentName = findViewById(R.id.bottom_sheet_name);
        mStudentAge = findViewById(R.id.bottom_sheet_age);
        mStudentHobbies = findViewById(R.id.bottom_sheet_hobbies);

        mLinearLayout = findViewById(R.id.bottom_sheet);
        mRecyclerView = findViewById(R.id.recycler_view);

        mBottomSheetBehavior = BottomSheetBehavior.from(mLinearLayout);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);

        StudentAdapter adapter = new StudentAdapter();

        adapter.bindData(getStudentList());
        adapter.setListener(this);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                Log.d("Activity", "onStateChanged called");
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                Log.d("Activity", "onSlide called");
            }
        });
    }

    private List<Student> getStudentList() {

        List<Student> s = new ArrayList<>();

        Student s1 = new Student();
        s1.setAge("12");
        s1.setName("James Smith");
        s1.setHobbies("Basketball");

        Student s2 = new Student();
        s2.setAge("34");
        s2.setName("Roger Kent");
        s2.setHobbies("Fishing");

        Student s3 = new Student();
        s3.setAge("23");
        s3.setName("Tom Beak");
        s3.setHobbies("Bowling");

        Student s4 = new Student();
        s4.setAge("55");
        s4.setName("Beth McKenzie");
        s4.setHobbies("Reading");

        Student s5 = new Student();
        s5.setAge("77");
        s5.setName("Agnes Waltz");
        s5.setHobbies("Knitting");

        Student s6 = new Student();
        s6.setAge("15");
        s6.setName("Chuck Beef");
        s6.setHobbies("Drawing");


        Student s7 = new Student();
        s7.setAge("34");
        s7.setName("Michael Bay");
        s7.setHobbies("Filming");


        Student s8 = new Student();
        s8.setAge("76");
        s8.setName("Josh Wharling");
        s8.setHobbies("Coding");


        Student s9 = new Student();
        s9.setAge("2");
        s9.setName("Ken Lu");
        s9.setHobbies("eating");


        Student s10 = new Student();
        s10.setAge("78");
        s10.setName("Chuck Beef");
        s10.setHobbies("Drawing");


        s.add(s1);
        s.add(s2);
        s.add(s3);
        s.add(s4);
        s.add(s5);
        s.add(s6);
        s.add(s7);
        s.add(s8);
        s.add(s9);
        s.add(s10);

        s.add(s1);
        s.add(s2);
        s.add(s3);
        s.add(s4);
        s.add(s5);
        s.add(s6);
        s.add(s7);
        s.add(s8);
        s.add(s9);
        s.add(s10);


        return s;
    }

    @Override
    public void onItemClicked(Student s) {

        if(mBottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }

        mStudentName.setText("Name: " + s.getName());
        mStudentAge.setText("Age: " + s.getAge());
        mStudentHobbies.setText("Hobbies: " + s.getHobbies());

    }
}
