package comp3350.umhub.presentation;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessTutors;
import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.presentation.adapters.TutorAdapter;

public class TutorsActivity extends AppCompatActivity {
    private List<TutorEntry> tutorEntryList;
    private static TutorEntry tutorEntrySelected = null;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_emp_list);
        setTitle("Available Tutors");

        IAccessTutors accessTutors = Services.getAccessTutors();
        try{
            tutorEntryList = accessTutors.getTutorEntriesByCourse(CoursesActivity.getCourseSelected());

            listView = (ListView) findViewById(R.id.list_view);
            listView.setEmptyView(findViewById(R.id.empty));
            TutorAdapter adapter = new TutorAdapter(this, tutorEntryList);
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                    tutorEntrySelected = tutorEntryList.get(position);
                    Intent modify_intent = new Intent(getApplicationContext(), RateTutorsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(modify_intent);

                }
            });
        }
        catch (final NullPointerException e){
            Messages.fatalError(this,e.getMessage());
        }

    }

    public void buttonGoBack(View view){
        Intent coursesIntent = new Intent(TutorsActivity.this, CoursesActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        TutorsActivity.this.startActivity(coursesIntent);
    }

    public static TutorEntry getTutorEntrySelected(){
        return tutorEntrySelected;
    }



}
