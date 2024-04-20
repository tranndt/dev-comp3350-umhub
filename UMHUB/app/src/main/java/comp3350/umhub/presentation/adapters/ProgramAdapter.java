package comp3350.umhub.presentation.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Program;

public class ProgramAdapter extends BaseAdapter {
    List<Program> programList;
    LayoutInflater inflater;

    public ProgramAdapter(Context context, List<Program> programs) {
        programList = programs;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return programList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return programList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if (convertView == null) {
            row = inflater.inflate(R.layout.activity_view_record, parent,false);
        } else {
            row = convertView;
        }
        Program program = programList.get(position);
        TextView name = (TextView) row.findViewById(R.id.title1);
        TextView desc = (TextView) row.findViewById(R.id.desc1);

        name.setText(program.getName());
        desc.setText(program.getMajor());

        if (Services.getAccessCourses().getCoursesByProgram(program).isEmpty()){
            name.setTextColor(Color.parseColor("#9e9e9e"));
            desc.setTextColor(Color.parseColor("#9e9e9e"));
        }
        return row;

    }
}
