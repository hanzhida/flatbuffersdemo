package mapbox1.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.flatbuffers.FlatBufferBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import mapbox1.myapplication.model.Plugin;
import mapbox1.myapplication.model.PluginDeviceInfo;
import mapbox1.myapplication.model.Plugins;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("mihome://home.mi.com/miloan?url=http://m.jr.mi.com/app?from=test&_external=false&referId=intro\\\\#!/intro/detail?url=http://118.24.168.131/xiaomi4.html&key=%E5%9F%BA%E9%87%91%E7%BB%8F%E7%90%86&title=%E9%87%91%E9%B9%B0%E6%B7%BB%E7%91%9E%E4%B8%AD%E7%9F%AD%E5%80%BAC&from=app&referId=intro"));
                intent.setAction(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        findViewById(R.id.convert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        convertJsonToFlatbuffer();
                    }
                }).start();
            }
        });
        findViewById(R.id.parse_json).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long ts = System.currentTimeMillis();
                        JSONArray ja = readData();
                        List<PluginDeviceInfo> list = parseJSON(ja);
                        long delta = System.currentTimeMillis() - ts;
                        Log.d(TAG,"parse_json:"+delta);
                    }
                }).start();
            }
        });
        findViewById(R.id.parse_flatbuffer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long ts = System.currentTimeMillis();
                        List<PluginDeviceInfo> list = parseFlatBuffer();
                        long delta = System.currentTimeMillis() - ts;
                        Log.d(TAG,"parse_flatbuffer:"+delta);
                    }
                }).start();
            }
        });
    }

    private List<PluginDeviceInfo> parseFlatBuffer() {
        ByteBuffer byteBuffer = readFlatBufferDataFromFile();
        if(byteBuffer == null) {
            return null;
        }
        Plugins plugins = Plugins.getRootAsPlugins(byteBuffer);
        int length = plugins.pluginLength();
        List<PluginDeviceInfo> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Plugin plugin = plugins.plugin(i);
            if(plugin == null) {
                continue;
            }
            PluginDeviceInfo info = new PluginDeviceInfo();
            info.mBindConfirm = plugin.bindConfirm() == 1 ? true : false;
            info.mBluetoothBindStyle = plugin.btBindStyle();
            info.mBluetoothMatch = plugin.btMatch();
            info.mBluetoothRssi = plugin.btRssi();
            info.mBrandName = plugin.brandName();
            info.mCategoryName = plugin.cateName();
            info.mDesc = plugin.desc();
            info.mIcon336 = plugin.iconBluetoothPairing();
            info.mIconBluetoothPair = plugin.iconBluetoothPairing();
            info.mIconLockScreenOff = plugin.iconLockScreenOff();
            info.mIconLockScreenOn = plugin.iconLockScreenOn();
            info.mIconOff = plugin.iconOff();
            info.mIconOffline = plugin.iconOffline();
            info.mIconOn = plugin.iconOn();
            info.mIconReal = plugin.iconReal();
            info.mIconSmartConfig = plugin.iconSmartconfig();
            info.mIconSmartConfigOff = plugin.iconSmartconfigOff();
            info.mIsBluetoothGateway = plugin.bindConfirm();
            info.mIsBluetoothSecurityChip = plugin.bindConfirm();
            info.mKuailianPasswd = plugin.brandName();
            info.mMinAppVersion = plugin.minAppVersion();
            info.mModel = plugin.model();
            info.mModelRegex = plugin.modelRegex();
            info.mName = plugin.name();
            info.mNameSmartConfig = plugin.nameSmartconfig();
            info.mOfflineEnter = plugin.ctOfflineEnter();
            info.mPid = plugin.pid();
            info.mProductId = plugin.pdId();
            info.mRank = plugin.bindConfirm();
            info.mRelations = new ArrayList<>(); // todo
            info.mSCFailed = plugin.scFailed();
            info.mScStatus = plugin.scStatus();
            info.mScType = plugin.scType();
            info.mScTypeMore = new ArrayList<>();
            info.mStatus = plugin.status();
            info.mSubCategoryId = TextUtils.isEmpty(plugin.subcategoryId()) ? 0 : Integer.valueOf(plugin.subcategoryId());
            info.mSupportBeingVoiceCtrlED = plugin.voiceCtrlEd();
            info.mSupportOpHistory = plugin.opHistory();
            info.mSupportPermissionControl = plugin.permissionControl();
            info.mSupportVoiceCtrl = plugin.voiceControl();
            info.mSupportWexinShare = plugin.wexinShare() == 1 ? true : false;
            info.mWifiSendWays = new ArrayList<>();
            list.add(info);
        }
        return list;
    }

    private List<PluginDeviceInfo> parseJSON(JSONArray ja) {
        if (ja.length() <= 0) {
            return null;
        }
        List<PluginDeviceInfo> list = new ArrayList<>();
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jo = ja.optJSONObject(i);
            PluginDeviceInfo info = PluginDeviceInfo.buildFromPref(jo);
            list.add(info);
        }
        return list;
    }

    private JSONArray readData() {
        InputStream inputStream = null;
        try {

            inputStream = getAssets().open("pluginconfig");
            int length = inputStream.available();
            byte[] buffer = new byte[length];
            inputStream.read(buffer);
            String s = new String(buffer, "utf8");
            try {
                return new JSONArray(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private void savePluginsToFlatBuffer(List<PluginDeviceInfo> list) {
        FlatBufferBuilder builder = new FlatBufferBuilder(1024);
//        Plugins.startPluginVector(builder, list.size());
        for(PluginDeviceInfo info : list) {
            int icon_onOffset = builder.createString(info.mIconOn);
            int icon_offOffset = builder.createString(info.mIconOff);
            int icon_offlineOffset = builder.createString(info.mIconOffline);
            int icon_smartconfigOffset = builder.createString(info.mIconSmartConfig);
            int icon_lock_screen_onOffset = builder.createString(info.mIconLockScreenOn);
            int icon_lock_screen_offOffset = builder.createString(info.mIconLockScreenOff);
            int modelOffset = builder.createString(info.mModel);
            int nameOffset = builder.createString(info.mName);
            int subcategory_idOffset = builder.createString(info.mSubCategoryId+"");
            int descOffset = builder.createString(info.mDesc);
            int model_regexOffset = builder.createString(info.mModelRegex);
            int icon_bluetooth_pairingOffset = builder.createString(info.mIconBluetoothPair);
            int icon_realOffset = builder.createString(info.mIconReal);
            int name_smartconfigOffset = builder.createString(info.mNameSmartConfig);
            int brand_nameOffset = builder.createString(info.mBrandName);
            int bt_rssiOffset = builder.createString(info.mBluetoothRssi);
            int sc_type_moreOffset = builder.createString(info.mScTypeMore + "");
            int sc_type_more_v2Offset = builder.createString(info.mScTypeMore + "");
            int icon_smartconfig_offOffset = builder.createString(info.mIconSmartConfigOff);
            int relationOffset = builder.createString("relations"); // todo list
            int cate_nameOffset = builder.createString(info.mCategoryName);
            int pluginOffset = Plugin.createPlugin(builder,
                    info.mProductId,
                    icon_onOffset,
                    icon_offOffset,
                    icon_offlineOffset,
                    icon_smartconfigOffset,
                    icon_lock_screen_onOffset,
                    icon_lock_screen_offOffset,
                    info.mStatus,
                    info.mStatus,
                    System.currentTimeMillis(),
                    info.mMinAppVersion,
                    info.mBindConfirm ? 1 : 0,modelOffset,
                    nameOffset,subcategory_idOffset,descOffset,
                    info.mPid,model_regexOffset,icon_bluetooth_pairingOffset,icon_realOffset,
                    name_smartconfigOffset,brand_nameOffset,info.mBluetoothBindStyle,
                    info.mSupportWexinShare ? 1 : 0,info.mSupportPermissionControl,info.mBluetoothMatch,bt_rssiOffset,
                    info.mSCFailed,info.mSupportVoiceCtrl,info.mSupportBeingVoiceCtrlED,info.mSupportOpHistory,info.mScType,
                    info.mScStatus,sc_type_moreOffset,sc_type_more_v2Offset,icon_smartconfig_offOffset,relationOffset,
                    info.mOfflineEnter,cate_nameOffset);
            Plugins.addPlugin(builder, pluginOffset);
        }
        Plugins.startPlugins(builder);
        int len = Plugins.endPlugins(builder);
        builder.finish(len);
        ByteBuffer buffer = builder.dataBuffer();
        saveFlatBufferDataToFile(buffer);
    }

    private void saveFlatBufferDataToFile(ByteBuffer data) {
        FileChannel channel = null;
        try {
            File file = new File(getPluginFile());
            if(file.exists()) {
                file.delete();
                file.createNewFile();
            }
            channel = new FileOutputStream(file).getChannel();
            channel.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private String getPluginFile(){
        return getFilesDir()+File.separator+"plugin";
    }

    private ByteBuffer readFlatBufferDataFromFile(){
        try {
            RandomAccessFile plugin = new RandomAccessFile(getPluginFile(), "rw");
            byte[] data = new byte[(int)plugin.length()];
            plugin.readFully(data);
            plugin.close();
            ByteBuffer bb = ByteBuffer.wrap(data);

            return bb;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void convertJsonToFlatbuffer() {
        JSONArray ja = readData();
        if (ja == null) {
            return;
        }
        List<PluginDeviceInfo> list = parseJSON(ja);
        if (list == null) {
            return;
        }
        savePluginsToFlatBuffer(list);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "" + requestCode + "," + resultCode, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
