package mapbox1.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PluginDeviceInfo implements Parcelable {
    public String mModel;
    public int mProductId;
    public int mMinAppVersion;
    public String mName;
    public String mNameSmartConfig;
    public String mIconOn;
    public String mIconOff;
    public String mIconOffline;
    public String mIconSmartConfig;
    public String mIconLockScreenOn;
    public String mIconLockScreenOff;
    public String mIconBluetoothPair;
    public String mIconReal;
    public boolean mBindConfirm;
    public String mModelRegex;
    public String mDesc;
    public int mPid;
    public String mKuailianPasswd;
    public int mStatus;
    public String mBrandName;
    public String mCategoryName;
    public int mBluetoothBindStyle;
    public int mOfflineEnter;

    public int mSupportPermissionControl;
    public boolean mSupportWexinShare;
    public int mBluetoothMatch;
    public String mBluetoothRssi;
    public int mSCFailed;
    public int mSupportVoiceCtrl;
    public int mSupportBeingVoiceCtrlED;
    public int mSupportOpHistory;
    public int mIsBluetoothSecurityChip;
    public int mIsBluetoothGateway;
    public String mIcon336;

    public int mSubCategoryId;

    /**
     * 快连方式
     */
    public int mScType;

    /**
     * 快连状态:0代表未上线；1代表白名单可见；3代表已上线
     */
    public int mScStatus;

    /**
     * 快连状态
     */
    public List<Integer> mScTypeMore = new ArrayList<>();
    public List<Integer> mWifiSendWays = new ArrayList<>();

    public static final int WIFI_SEND_AP = 0;
    public static final int WIFI_SEND_BLE = 1;
    public static final int WIFI_SEND_QRCODE = 2;

    public boolean isSupport5G;

    public String mIconSmartConfigOff;
    public List<String> mRelations = new ArrayList<>();
    public int mRank;


    public static PluginDeviceInfo buildFromPref(JSONObject configJson) {
        PluginDeviceInfo deviceInfo = new PluginDeviceInfo();
        deviceInfo.mModel = "";
        deviceInfo.mProductId = configJson.optInt("product_id");
        deviceInfo.mMinAppVersion = configJson.optInt("min_app_version");
        deviceInfo.mName = configJson.optString("name");
        deviceInfo.mNameSmartConfig = configJson.optString("name_sc");
        deviceInfo.mIconOn = configJson.optString("icon_on");
        deviceInfo.mIconOff = configJson.optString("icon_off");
        deviceInfo.mIconOffline = configJson.optString("icon_offline");
        deviceInfo.mIconSmartConfig = configJson.optString("icon_sc");
        deviceInfo.mIconLockScreenOn = configJson.optString("icon_ls_on");
        deviceInfo.mIconLockScreenOff = configJson.optString("icon_ls_off");
        deviceInfo.mIconBluetoothPair = configJson.optString("icon_b_pair");
        deviceInfo.mIconReal = configJson.optString("icon_real");
        deviceInfo.mBindConfirm = configJson.optBoolean("bind_confirm");
        deviceInfo.mModelRegex = configJson.optString("model_regex");
        try {
            JSONObject object = new JSONObject(deviceInfo.mModelRegex);
            deviceInfo.mModelRegex = object.optString("ssid");
        } catch (JSONException e) {

        }
        deviceInfo.mDesc = configJson.optString("desc");
        deviceInfo.mPid = configJson.optInt("pid");
        deviceInfo.mKuailianPasswd = configJson.optString("smart_config_passwd");
        deviceInfo.mStatus = configJson.optInt("status");
        deviceInfo.mBrandName = configJson.optString("brand_name");
        deviceInfo.mCategoryName = configJson.optString("cate_name");
        deviceInfo.mBluetoothBindStyle = configJson.optInt("bt_bind_style");
        deviceInfo.mOfflineEnter = configJson.optInt("ct_offline_enter");
        deviceInfo.mSupportPermissionControl = configJson.optInt("permission_control");
        deviceInfo.mSupportWexinShare = configJson.optBoolean("wexin_share");
        deviceInfo.mBluetoothMatch = configJson.optInt("bt_match");
        deviceInfo.mBluetoothRssi = configJson.optString("bt_rssi");
        deviceInfo.mSCFailed = configJson.optInt("sc_failed");
        deviceInfo.mSupportVoiceCtrl = configJson.optInt("voice_control");
        deviceInfo.mSupportBeingVoiceCtrlED = configJson.optInt("voice_ctrl_ed");
        deviceInfo.mSupportOpHistory = configJson.optInt("op_history");
        deviceInfo.mScType = configJson.optInt("sc_type");
        deviceInfo.mScStatus = configJson.optInt("sc_status");
        JSONArray array = configJson.optJSONArray("sc_type_more");
        deviceInfo.mScTypeMore = new ArrayList<>();
        if (array != null) {
            for (int i = 0; i < array.length(); i++) {
                deviceInfo.mScTypeMore.add(array.optInt(i));
            }
        }
        deviceInfo.mIsBluetoothSecurityChip = configJson.optInt("bt_is_secure");
        deviceInfo.mIsBluetoothGateway = configJson.optInt("bt_gateway");
        deviceInfo.mIcon336 = configJson.optString("icon_336");

        JSONArray wifiSendWays = configJson.optJSONArray("sc_type_more_v2");
        deviceInfo.mWifiSendWays = new ArrayList<>();
        if (wifiSendWays != null) {
            for (int i = 0; i < wifiSendWays.length(); i++) {
                deviceInfo.mWifiSendWays.add(wifiSendWays.optInt(i));
            }
        }
        deviceInfo.isSupport5G = configJson.optBoolean("fiveG_wifi");
        deviceInfo.mSubCategoryId = configJson.optInt("subcategory_id");
        deviceInfo.mIconSmartConfigOff = configJson.optString("icon_smartconfig_off");
        deviceInfo.mRelations = new ArrayList<>();
        JSONArray relations = configJson.optJSONArray("relations");
        if (relations != null) {
            for (int i = 0; i < relations.length(); i++) {
                deviceInfo.mRelations.add(relations.optString(i));
            }
        }

        deviceInfo.mRank = configJson.optInt("rank");

        return deviceInfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mModel);
        dest.writeInt(this.mProductId);
        dest.writeInt(this.mMinAppVersion);
        dest.writeString(this.mName);
        dest.writeString(this.mNameSmartConfig);
        dest.writeString(this.mIconOn);
        dest.writeString(this.mIconOff);
        dest.writeString(this.mIconOffline);
        dest.writeString(this.mIconSmartConfig);
        dest.writeString(this.mIconLockScreenOn);
        dest.writeString(this.mIconLockScreenOff);
        dest.writeString(this.mIconBluetoothPair);
        dest.writeString(this.mIconReal);
        dest.writeByte(this.mBindConfirm ? (byte) 1 : (byte) 0);
        dest.writeString(this.mModelRegex);
        dest.writeString(this.mDesc);
        dest.writeInt(this.mPid);
        dest.writeString(this.mKuailianPasswd);
        dest.writeInt(this.mStatus);
        dest.writeString(this.mBrandName);
        dest.writeString(this.mCategoryName);
        dest.writeInt(this.mBluetoothBindStyle);
        dest.writeInt(this.mOfflineEnter);
        dest.writeInt(this.mSupportPermissionControl);
        dest.writeByte(this.mSupportWexinShare ? (byte) 1 : (byte) 0);
        dest.writeInt(this.mBluetoothMatch);
        dest.writeString(this.mBluetoothRssi);
        dest.writeInt(this.mSCFailed);
        dest.writeInt(this.mSupportVoiceCtrl);
        dest.writeInt(this.mSupportBeingVoiceCtrlED);
        dest.writeInt(this.mSupportOpHistory);
        dest.writeInt(this.mIsBluetoothSecurityChip);
        dest.writeInt(this.mIsBluetoothGateway);
        dest.writeString(this.mIcon336);
        dest.writeInt(this.mSubCategoryId);
        dest.writeInt(this.mScType);
        dest.writeInt(this.mScStatus);
//        dest.writeList(this.mScTypeMore);
//        dest.writeList(this.mWifiSendWays);
        dest.writeByte(this.isSupport5G ? (byte) 1 : (byte) 0);
        dest.writeString(this.mIconSmartConfigOff);
        dest.writeStringList(this.mRelations);
        dest.writeInt(this.mRank);
    }

    public PluginDeviceInfo() {
    }

    public static int count = 0;
    protected PluginDeviceInfo(Parcel in) {
        count++;
        this.mModel = in.readString();
        this.mProductId = in.readInt();
        this.mMinAppVersion = in.readInt();
        this.mName = in.readString();
        this.mNameSmartConfig = in.readString();
        this.mIconOn = in.readString();
        this.mIconOff = in.readString();
        this.mIconOffline = in.readString();
        this.mIconSmartConfig = in.readString();
        this.mIconLockScreenOn = in.readString();
        this.mIconLockScreenOff = in.readString();
        this.mIconBluetoothPair = in.readString();
        this.mIconReal = in.readString();
        this.mBindConfirm = in.readByte() != 0;
        this.mModelRegex = in.readString();
        this.mDesc = in.readString();
        this.mPid = in.readInt();
        this.mKuailianPasswd = in.readString();
        this.mStatus = in.readInt();
        this.mBrandName = in.readString();
        this.mCategoryName = in.readString();
        this.mBluetoothBindStyle = in.readInt();
        this.mOfflineEnter = in.readInt();
        this.mSupportPermissionControl = in.readInt();
        this.mSupportWexinShare = in.readByte() != 0;
        this.mBluetoothMatch = in.readInt();
        this.mBluetoothRssi = in.readString();
        this.mSCFailed = in.readInt();
        this.mSupportVoiceCtrl = in.readInt();
        this.mSupportBeingVoiceCtrlED = in.readInt();
        this.mSupportOpHistory = in.readInt();
        this.mIsBluetoothSecurityChip = in.readInt();
        this.mIsBluetoothGateway = in.readInt();
        this.mIcon336 = in.readString();
        this.mSubCategoryId = in.readInt();
        this.mScType = in.readInt();
        this.mScStatus = in.readInt();
        this.mScTypeMore = new ArrayList<Integer>();
//        in.readList(this.mScTypeMore, Integer.class.getClassLoader());
        this.mWifiSendWays = new ArrayList<Integer>();
//        in.readList(this.mWifiSendWays, Integer.class.getClassLoader());
        this.isSupport5G = in.readByte() != 0;
        this.mIconSmartConfigOff = in.readString();
        this.mRelations = in.createStringArrayList();
        this.mRank = in.readInt();
    }

    public static final Parcelable.Creator<PluginDeviceInfo> CREATOR = new Parcelable.Creator<PluginDeviceInfo>() {
        @Override
        public PluginDeviceInfo createFromParcel(Parcel source) {
            return new PluginDeviceInfo(source);
        }

        @Override
        public PluginDeviceInfo[] newArray(int size) {
            return new PluginDeviceInfo[size];
        }
    };
}
