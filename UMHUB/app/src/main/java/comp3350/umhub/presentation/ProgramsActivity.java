package comp3350.umhub.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessPrograms;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.presentation.adapters.ProgramAdapter;

public class ProgramsActivity extends AppCompatActivity {

    private IAccessPrograms iAccessPrograms;
    private ListView listView;
    private List<Program> programList;
    private static Program programSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        iAccessPrograms = Services.getAccessPrograms();
        Major major = MajorsActivity.getMajorSelected();
        try {
            setTitle(String.format("Programs under %s", major.getName()));
        } catch (NullPointerException e) {
            setTitle("All Programs");
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No major selected", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }

        if (major== null)
            programList = iAccessPrograms.getAllPrograms();
        else
            programList = iAccessPrograms.getProgramsByMajor(major);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));
        ProgramAdapter adapter = new ProgramAdapter(this, programList);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                programSelected = programList.get(position);
                if (!Services.getAccessCourses().getCoursesByProgram(programSelected).isEmpty()) {
                    Intent modify_intent = new Intent(getApplicationContext(), CoursesActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(modify_intent);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Course information not available. Please try another option", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }

            }
        });

    }
    
    public void buttonCoursesOnClick(View view) {
        Intent majorsIntent = new Intent(ProgramsActivity.this, CoursesActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ProgramsActivity.this.startActivity(majorsIntent);
    }

    //DSO
    public static Program getProgramSelected(){
        return programSelected;
    }

    public static void setProgramSelected(Program programSelected) {
        ProgramsActivity.programSelected = programSelected;
    }

    @Override
    public void onBackPressed() {
        MajorsActivity.setMajorSelected(null);
        super.onBackPressed();
    }


}

