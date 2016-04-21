package com.lancefallon.scorecard.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lancefallon.scorecard.R;
import com.lancefallon.scorecard.models.Hole;

public class HoleAdapterRecycler extends RecyclerView.Adapter<HoleAdapterRecycler.HoleViewHolder> {

    private Context mContext;
    private Hole[] mHoles;

    public HoleAdapterRecycler(Context context, Hole[] holes){
        this.mContext = context;
        this.mHoles = holes;
    }

    public Hole[] getHoles() {
        return mHoles;
    }

    @Override
    public HoleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.scorecard_list_item, parent, false);
        HoleViewHolder holder = new HoleViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HoleViewHolder holder, int position) {
        holder.bindHole(mHoles[position]);
    }

    @Override
    public int getItemCount() {
        return mHoles.length;
    }

    public class HoleViewHolder extends RecyclerView.ViewHolder {

        private View minusButton;
        private View addButton;
        private TextView holeNumber;
        private TextView score;
        
        public HoleViewHolder(View itemView) {
            super(itemView);

            addButton = itemView.findViewById(R.id.activity_main_plusButton);
            minusButton = itemView.findViewById(R.id.activity_main_minusButton);
            holeNumber = (TextView) itemView.findViewById(R.id.activity_main_holeNumber);
            score = (TextView) itemView.findViewById(R.id.activity_main_scoreText);
        }

        public void bindHole(final Hole hole){
            holeNumber.setText("Hole " + hole.getHole());
            score.setText(hole.getScore() + "");

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hole.setScore(hole.getScore() + 1);
                    score.setText(hole.getScore() + "");
                }
            });

            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hole.setScore(hole.getScore() == 0 ? 0 : (hole.getScore() - 1));
                    score.setText(hole.getScore() + "");
                }
            });
        }
    }
}
