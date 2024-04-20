package comp3350.umhub.presentation.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.objects.CourseReview;


public class ReviewAdapter extends BaseAdapter {
    List<CourseReview> courseReviewList;
    LayoutInflater inflater;

    public ReviewAdapter(Context context, List<CourseReview> courseReviews) {
        courseReviewList = courseReviews;
        inflater = LayoutInflater.from(context);
    }

    public ReviewAdapter(Context context, List<CourseReview> courseReviews, int itemLimit) {
        List<CourseReview> sublist = courseReviews.subList(0,Math.min(itemLimit,getCount()));
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return courseReviewList.size();
    }

    @Override
    public Object getItem(int position) {
        return courseReviewList.get(position);
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
        CourseReview courseReview = courseReviewList.get(position);
        TextView reviewScore = (TextView) row.findViewById(R.id.id1);
        TextView username = (TextView) row.findViewById(R.id.title1);
        TextView review = (TextView) row.findViewById(R.id.desc1);

        username.setText(courseReview.getUser());
        review.setText(courseReview.getReview());
        reviewScore.setText(String.valueOf(courseReview.getScore()));
        reviewScore.setTextSize(20);
        reviewScore.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        return row;
    }
}

