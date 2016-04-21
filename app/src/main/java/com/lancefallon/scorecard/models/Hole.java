package com.lancefallon.scorecard.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Hole implements Parcelable{
    private int score;
    private int hole;

    public Hole(){}

    public Hole(int score, int hole) {
        this.score = score;
        this.hole = hole;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHole() {
        return hole;
    }

    public void setHole(int hole) {
        this.hole = hole;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(hole);
        dest.writeInt(score);
    }

    private static Creator<Hole> CREATOR = new Creator<Hole>() {
        @Override
        public Hole createFromParcel(Parcel source) {
            Hole hole = new Hole();
            hole.setHole(source.readInt());
            hole.setScore(source.readInt());
            return hole;
        }

        @Override
        public Hole[] newArray(int size) {
            return new Hole[size];
        }
    };
}
