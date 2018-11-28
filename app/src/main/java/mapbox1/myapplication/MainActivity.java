package mapbox1.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcel;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import mapbox1.myapplication.model.Plugin;
import mapbox1.myapplication.model.PluginDeviceInfo;
import mapbox1.myapplication.model.PluginDeviceInfoList;
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
        findViewById(R.id.save_json_to_sp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        saveJsonToSP();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"done", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
            }
        });
        findViewById(R.id.save_json_to_parcel_file).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        saveJsonToParcel();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"done", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
            }
        });
        findViewById(R.id.convert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        convertJsonToFlatbuffer();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"done", Toast.LENGTH_SHORT).show();
                            }
                        });
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
                        final long delta = System.currentTimeMillis() - ts;
                        Log.d(TAG,"parse_json:"+delta);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"done:"+delta, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
            }
        });
        findViewById(R.id.parse_parcel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long ts = System.currentTimeMillis();
                        PluginDeviceInfo.count = 0;
                        PluginDeviceInfoList list = parseParcel();
                        final long delta = System.currentTimeMillis() - ts;
                        Log.d(TAG,"PluginDeviceInfo count="+PluginDeviceInfo.count);
                        Log.d(TAG,"parse_parcel:"+delta);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"done:"+delta, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
            }
        });
        findViewById(R.id.parse_json_from_sp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long ts = System.currentTimeMillis();
                        JSONArray ja = readDataFromSP();
                        List<PluginDeviceInfo> list = parseJSON(ja);
                        final long delta = System.currentTimeMillis() - ts;
                        Log.d(TAG,"parse_json_from_sp:"+delta);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"done:"+delta, Toast.LENGTH_SHORT).show();
                            }
                        });
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
                        final long delta = System.currentTimeMillis() - ts;
                        Log.d(TAG,"parse_flatbuffer:"+delta);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"done:"+delta, Toast.LENGTH_SHORT).show();
                            }
                        });
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
            info.mProductId = plugin.pdId();
            info.mStatus = plugin.status();
            info.mMinAppVersion = plugin.minAppVersion();
            info.mBindConfirm = plugin.bindConfirm() == 1 ? true : false;
            info.mPid = plugin.pid();
            info.mBluetoothBindStyle = plugin.btBindStyle();
            info.mSupportWexinShare = plugin.wexinShare() == 1 ? true : false;
            info.mSupportPermissionControl = plugin.permissionControl();
            info.mBluetoothMatch = plugin.btMatch();
            info.mSCFailed = plugin.scFailed();
            info.mSupportVoiceCtrl = plugin.voiceControl();
            info.mSupportBeingVoiceCtrlED = plugin.voiceCtrlEd();
            info.mSupportOpHistory = plugin.opHistory();
            info.mScType = plugin.scType();
            info.mScStatus = plugin.scStatus();
            info.mOfflineEnter = plugin.ctOfflineEnter();
            info.mScTypeMore = new ArrayList<>();
            info.mRelations = new ArrayList<>(); // todo
            info.mCategoryName = plugin.cateName();
            info.mIconOn = plugin.iconOn();
            info.mIconOff = plugin.iconOff();
            info.mIconOffline = plugin.iconOffline();
            info.mIconSmartConfig = plugin.iconSmartconfig();
            info.mIconLockScreenOn = plugin.iconLockScreenOn();
            info.mIconLockScreenOff = plugin.iconLockScreenOff();
            info.mSubCategoryId = TextUtils.isEmpty(plugin.subcategoryId()) ? 0 : Integer.valueOf(plugin.subcategoryId());
            info.mDesc = plugin.desc();
            info.mModel = plugin.model();
            info.mName = plugin.name();
            info.mModelRegex = plugin.modelRegex();
            info.mIconBluetoothPair = plugin.iconBluetoothPairing();
            info.mIconReal = plugin.iconReal();
            info.mNameSmartConfig = plugin.nameSmartconfig();
            info.mBrandName = plugin.brandName();
            info.mBluetoothRssi = plugin.btRssi();
            info.mIconSmartConfigOff = plugin.iconSmartconfigOff();

            info.mIcon336 = plugin.iconBluetoothPairing();
            info.mIsBluetoothGateway = plugin.bindConfirm();
            info.mIsBluetoothSecurityChip = plugin.bindConfirm();
            info.mKuailianPasswd = plugin.brandName();
            info.mRank = plugin.bindConfirm();
            info.mWifiSendWays = new ArrayList<>();
            list.add(info);
        }
        return list;
    }

    private ArrayList<PluginDeviceInfo> parseJSON(JSONArray ja) {
        if (ja == null || ja.length() <= 0) {
            return null;
        }
        ArrayList<PluginDeviceInfo> list = new ArrayList<>();
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
        int pluginOffset = 0;
        int len = list.size();
        int[] intArray = new int[len];
        for(int i = 0; i < len; i++) {
            PluginDeviceInfo info = list.get(i);
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
            pluginOffset = Plugin.createPlugin(builder,
                    info.mProductId,
                    info.mStatus,
                    info.mStatus,
                    info.mMinAppVersion,
                    info.mBindConfirm ? 1 : 0,
                    info.mPid,
                    info.mBluetoothBindStyle,
                    info.mSupportWexinShare ? 1 : 0,
                    info.mSupportPermissionControl,
                    info.mBluetoothMatch,
                    info.mSCFailed,
                    info.mSupportVoiceCtrl,
                    info.mSupportBeingVoiceCtrlED,
                    info.mSupportOpHistory,
                    info.mScType,
                    info.mScStatus,
                    info.mOfflineEnter,
                    1L,
                    sc_type_moreOffset,
                    sc_type_more_v2Offset,
                    relationOffset,
                    cate_nameOffset,
                    icon_onOffset,
                    icon_offOffset,
                    icon_offlineOffset,
                    icon_smartconfigOffset,
                    icon_lock_screen_onOffset,
                    icon_lock_screen_offOffset,
                    subcategory_idOffset,
                    descOffset,
                    modelOffset,
                    nameOffset,
                    model_regexOffset,
                    icon_bluetooth_pairingOffset,
                    icon_realOffset,
                    name_smartconfigOffset,
                    brand_nameOffset,
                    bt_rssiOffset,
                    icon_smartconfig_offOffset
                    );
            intArray[i] = pluginOffset;
        }
        int offset = Plugins.createPluginVector(builder, intArray);
        Plugins.startPlugins(builder);
        Plugins.addPlugin(builder, offset);
        Plugins.addMyType(builder, 54456);
        Plugins.addMyStatus(builder, 12345);
        len = Plugins.endPlugins(builder);
        builder.finish(len);
        ByteBuffer buffer = builder.dataBuffer();
        saveFlatBufferDataToFile(buffer);

//        Plugins plugins = Plugins.getRootAsPlugins(buffer);
//        Log.d(TAG, "rebuilt myStatus="+plugins.myStatus());
//        Log.d(TAG, "rebuilt myType="+plugins.myType());
//        Log.d(TAG, "rebuilt pluginLength="+plugins.pluginLength());
//        Plugin plugin = plugins.plugin(0);
//        if(plugin != null) {
//            Log.d(TAG, "plugin iconOn="+plugin.iconOn());
//        }

    }

    private void saveFlatBufferDataToFile(ByteBuffer data) {
        FileOutputStream fos = null;
        try {
//            data.rewind();
            File file = new File(getPluginFile());
            if(file.exists()) {
                file.delete();
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
//            data.flip();
//            channel.write(data);
            fos.write(data.array(), data.position(), data.remaining());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null) {
                try {
                    fos.close();
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
            File file = new File(getPluginFile());
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
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

    private void saveJsonToSP() {
        JSONArray ja = readData();
        if (ja == null) {
            return;
        }
        SharedPreferences sp = getSharedPreferences("plugin", Context.MODE_PRIVATE);
        sp.edit().putString("content", ja.toString()).commit();
    }

    private PluginDeviceInfoList parseParcel(){
        byte[] bytes = readParcelFromFile();
        if(bytes == null) {
            return null;
        }
        PluginDeviceInfoList list = ParcelableUtil.unmarshall(bytes, PluginDeviceInfoList.CREATOR);
        return list;
    }

    private byte[] readParcelFromFile(){
        File file = new File(getFilesDir()+File.separator+"plugin_parcel");
        if(!file.exists()) {
            return null;
        }
        try {
            FileInputStream in = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            in.read(bytes);
            in.close();
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void saveJsonToParcel() {
        JSONArray ja = readData();
        if (ja == null) {
            return;
        }
        ArrayList<PluginDeviceInfo> list = parseJSON(ja);
        PluginDeviceInfoList pluginDeviceInfoList = new PluginDeviceInfoList();
        Log.d(TAG,"PluginDeviceInfo list size = "+list.size());
        pluginDeviceInfoList.mList = list;
        pluginDeviceInfoList.value1 = 12344;
        pluginDeviceInfoList.value2 = 988;
        byte[] bytes = ParcelableUtil.marshall(pluginDeviceInfoList);

        File file = new File(getFilesDir()+File.separator+"plugin_parcel");
        if(file.exists()) {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONArray readDataFromSP() {
        SharedPreferences sp = getSharedPreferences("plugin", Context.MODE_PRIVATE);
        String s = sp.getString("content", "");
        try {
            return new JSONArray(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
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
