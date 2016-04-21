package com.lancefallon.scorecard.activities;

import android.app.ListActivity;
import android.os.Bundle;

import com.lancefallon.scorecard.adapters.HoleAdapter;
import com.lancefallon.scorecard.models.Hole;

public class ListViewActivity extends ListActivity {

    public static final int TOTAL_HOLES = 18;
    private static final String HOLES = "HOLES";

    private HoleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        adapter = new HoleAdapter(this, holes);

        setListAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArray(HOLES, adapter.getHoles());
    }
}
