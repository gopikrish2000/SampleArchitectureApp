package com.gopi.architecture.sample.samplearchitectureapp.testPackage;

import android.os.Parcel;
import android.os.Parcelable;

public class TestParcelableClass implements Parcelable {

    int a;
    String string;
    double aDouble;

    protected TestParcelableClass(Parcel in) {
        a = in.readInt();
        string = in.readString();
        aDouble = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(a);
        dest.writeString(string);
        dest.writeDouble(aDouble);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TestParcelableClass> CREATOR = new Creator<TestParcelableClass>() {
        @Override
        public TestParcelableClass createFromParcel(Parcel in) {
            return new TestParcelableClass(in);
        }

        @Override
        public TestParcelableClass[] newArray(int size) {
            return new TestParcelableClass[size];
        }
    };
}
