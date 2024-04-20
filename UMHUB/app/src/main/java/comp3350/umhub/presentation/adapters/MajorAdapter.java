package comp3350.umhub.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.objects.Major;

public class MajorAdapter extends BaseAdapter {
    List<Major> majorList;
    LayoutInflater inflater;

    public MajorAdapter(Context context, List<Major> majors) {
        majorList = majors;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return majorList.size();
    }

    @Override
    public Object getItem(int position) {
        return majorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        if (convertView == null) {
            row = inflater.inflate(R.layout.activity_view_record, parent, false);
        } else {
            row = convertView;
        }
        Major major = majorList.get(position);
        TextView name = (TextView) row.findViewById(R.id.title1);
        name.setText(major.getName());
        return row;
    }
}
