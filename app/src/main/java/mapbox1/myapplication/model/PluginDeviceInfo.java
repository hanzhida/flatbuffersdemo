package mapbox1.myapplication.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PluginDeviceInfo {
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
    public List<Integer> mScTypeMore;
    public List<Integer> mWifiSendWays;

    public static final int WIFI_SEND_AP = 0;
    public static final int WIFI_SEND_BLE = 1;
    public static final int WIFI_SEND_QRCODE = 2;

    public boolean isSupport5G;

    public String mIconSmartConfigOff;
    public List<String> mRelations;
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
}
