package com.lancefallon.scorecard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lancefallon.scorecard.R;
import com.lancefallon.scorecard.models.Hole;

public class HoleAdapter extends BaseAdapter {

    private Context mContext;
    private Hole[] mHoles;

    public HoleAdapter(Context context, Hole[] holes){
        this.mContext = context;
        this.mHoles = holes;
    }

    public Hole[] getHoles(){
        return mHoles;
    }

    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int position) {
        return mHoles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.scorecard_list_item, null);
            holder = new ViewHolder();
            holder.addButton = convertView.findViewById(R.id.activity_main_plusButton);
            holder.minusButton = convertView.findViewById(R.id.activity_main_minusButton);
            holder.holeNumber = (TextView) convertView.findViewById(R.id.activity_main_holeNumber);
            holder.score = (TextView) convertView.findViewById(R.id.activity_main_scoreText);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hole hole = mHoles[position];
                hole.setScore(hole.getScore() + 1);
                holder.score.setText(hole.getScore() + "");
            }
        });

        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hole hole = mHoles[position];
                hole.setScore(hole.getScore() == 0 ? 0 : (hole.getScore() - 1));
                holder.score.setText(hole.getScore() + "");
            }
        });

        Hole hole = mHoles[position];
        holder.score.setText(hole.getScore() + "");
        holder.holeNumber.setText("Hole " + hole.getHole());

        return convertView;
    }

    private static class ViewHolder{
        private View minusButton;
        private View addButton;
        private TextView holeNumber;
        private TextView score;
    }
}
