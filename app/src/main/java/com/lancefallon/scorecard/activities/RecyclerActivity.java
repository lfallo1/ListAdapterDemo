package com.lancefallon.scorecard.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lancefallon.scorecard.R;
import com.lancefallon.scorecard.adapters.HoleAdapter;
import com.lancefallon.scorecard.adapters.HoleAdapterRecycler;
import com.lancefallon.scorecard.models.Hole;

/**
 * Created by lancefallon on 4/21/16.
 */
public class RecyclerActivity extends AppCompatActivity {

    public static final int TOTAL_HOLES = 18;
    private static final String HOLES = "HOLES";

    private HoleAdapterRecycler adapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_activity_recyclerView);

        Hole[] holes;

        if(savedInstanceState != null){
            holes = (Hole[])savedInstanceState.getParcelableArray(HOLES);
        }
        else{
            holes = new Hole[TOTAL_HOLES];
            for (int i = 0; i < TOTAL_HOLES; i++){
                holes[i] = new Hole(0, (i+1));
            }
        }
        adapter = new HoleAdapterRecycler(this, holes);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArray(HOLES, adapter.getHoles());
    }
}
