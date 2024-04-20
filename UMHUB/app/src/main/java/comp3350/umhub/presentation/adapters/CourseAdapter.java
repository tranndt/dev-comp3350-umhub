package comp3350.umhub.presentation.adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.objects.Course;

public class CourseAdapter extends BaseAdapter {
    List<Course> courseList;
    LayoutInflater inflater;

    public CourseAdapter(Context context, List<Course> courseReviews) {
        courseList = courseReviews;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int position) {
        return courseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        if (convertView == null) {
            row = inflater.inflate(R.layout.activity_view_record, parent, false);
        } else {
            row = convertView;
        }
        Course course = courseList.get(position);
        TextView id = (TextView) row.findViewById(R.id.id1);
        TextView name = (TextView) row.findViewById(R.id.title1);
        TextView desc = (TextView) row.findViewById(R.id.desc1);

        name.setText(course.getName());
        desc.setText(course.getDescription());
        desc.setTextSize(16);
        id.setText(course.getId());
        id.setTextSize(16);
        id.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        switch (course.getYear()){
            case 2:
            case 4:
                row.setBackgroundColor(Color.parseColor("#facc4d"));
                break;
            default:
                row.setBackgroundColor(Color.parseColor("#fff9e8"));
        }

        return row;
    }
}
