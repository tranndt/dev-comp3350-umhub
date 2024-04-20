package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourses;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Program;
import comp3350.umhub.presentation.adapters.CourseAdapter;

public class CoursesActivity extends AppCompatActivity {
    private ListView listView;
    private List<Course> courseList;
    private IAccessCourses accessCourses;
    private static Course courseSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        accessCourses = Services.getAccessCourses();
        Program program = ProgramsActivity.getProgramSelected();
        try {
            setTitle(String.format("Courses under %s", program.getName()));
        } catch (NullPointerException e) {
            setTitle("All Courses");
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Program information not available", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }

        if (program== null)
            if (MajorsActivity.getMajorSelected() == null)
                courseList = accessCourses.getAllCourses();
            else courseList = accessCourses.getCoursesByMajor(MajorsActivity.getMajorSelected());
        else
            courseList = accessCourses.getCoursesByProgram(program);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));
        CourseAdapter adapter = new CourseAdapter(this, courseList);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                setCourseSelected(courseList.get(position));
                Intent modify_intent = new Intent(getApplicationContext(), CourseReviewsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(modify_intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        ProgramsActivity.setProgramSelected(null);
        super.onBackPressed();
    }

    public static Course getCourseSelected() {
        return courseSelected;
    }

    public static void setCourseSelected(Course courseSelected) {
        CoursesActivity.courseSelected = courseSelected;
    }
}
