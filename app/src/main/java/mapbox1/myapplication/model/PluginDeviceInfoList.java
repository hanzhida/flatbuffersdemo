package mapbox1.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class PluginDeviceInfoList implements Parcelable {
    public List<PluginDeviceInfo> mList = new ArrayList<>();
    public int value1;
    public int value2;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(value1);
        dest.writeInt(value2);
        dest.writeTypedList(this.mList);
    }

    public PluginDeviceInfoList() {
    }

    public PluginDeviceInfoList(Parcel in) {
//        in.readTypedList(mList, PluginDeviceInfo.CREATOR);
        value1 = in.readInt();
        value2 = in.readInt();
        this.mList = in.createTypedArrayList(PluginDeviceInfo.CREATOR);
    }

    public static final Parcelable.Creator<PluginDeviceInfoList> CREATOR = new Parcelable.Creator<PluginDeviceInfoList>() {
        @Override
        public PluginDeviceInfoList createFromParcel(Parcel source) {
            return new PluginDeviceInfoList(source);
        }

        @Override
        public PluginDeviceInfoList[] newArray(int size) {
            return new PluginDeviceInfoList[size];
        }
    };
}
