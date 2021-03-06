// automatically generated by the FlatBuffers compiler, do not modify

package mapbox1.myapplication.model;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Plugin extends Table {
  public static Plugin getRootAsPlugin(ByteBuffer _bb) { return getRootAsPlugin(_bb, new Plugin()); }
  public static Plugin getRootAsPlugin(ByteBuffer _bb, Plugin obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public Plugin __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int pdId() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int status() { int o = __offset(6); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int iosStatus() { int o = __offset(8); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int minAppVersion() { int o = __offset(10); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int bindConfirm() { int o = __offset(12); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int pid() { int o = __offset(14); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int btBindStyle() { int o = __offset(16); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int wexinShare() { int o = __offset(18); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int permissionControl() { int o = __offset(20); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int btMatch() { int o = __offset(22); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int scFailed() { int o = __offset(24); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int voiceControl() { int o = __offset(26); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int voiceCtrlEd() { int o = __offset(28); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int opHistory() { int o = __offset(30); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int scType() { int o = __offset(32); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int scStatus() { int o = __offset(34); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int ctOfflineEnter() { int o = __offset(36); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public long changeTime() { int o = __offset(38); return o != 0 ? bb.getLong(o + bb_pos) : 0L; }
  public int scTypeMore(int j) { int o = __offset(40); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int scTypeMoreLength() { int o = __offset(40); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer scTypeMoreAsByteBuffer() { return __vector_as_bytebuffer(40, 4); }
  public ByteBuffer scTypeMoreInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 40, 4); }
  public int scTypeMoreV2(int j) { int o = __offset(42); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int scTypeMoreV2Length() { int o = __offset(42); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer scTypeMoreV2AsByteBuffer() { return __vector_as_bytebuffer(42, 4); }
  public ByteBuffer scTypeMoreV2InByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 42, 4); }
  public int relations(int j) { int o = __offset(44); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int relationsLength() { int o = __offset(44); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer relationsAsByteBuffer() { return __vector_as_bytebuffer(44, 4); }
  public ByteBuffer relationsInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 44, 4); }
  public String cateName() { int o = __offset(46); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer cateNameAsByteBuffer() { return __vector_as_bytebuffer(46, 1); }
  public ByteBuffer cateNameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 46, 1); }
  public String iconOn() { int o = __offset(48); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer iconOnAsByteBuffer() { return __vector_as_bytebuffer(48, 1); }
  public ByteBuffer iconOnInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 48, 1); }
  public String iconOff() { int o = __offset(50); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer iconOffAsByteBuffer() { return __vector_as_bytebuffer(50, 1); }
  public ByteBuffer iconOffInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 50, 1); }
  public String iconOffline() { int o = __offset(52); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer iconOfflineAsByteBuffer() { return __vector_as_bytebuffer(52, 1); }
  public ByteBuffer iconOfflineInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 52, 1); }
  public String iconSmartconfig() { int o = __offset(54); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer iconSmartconfigAsByteBuffer() { return __vector_as_bytebuffer(54, 1); }
  public ByteBuffer iconSmartconfigInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 54, 1); }
  public String iconLockScreenOn() { int o = __offset(56); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer iconLockScreenOnAsByteBuffer() { return __vector_as_bytebuffer(56, 1); }
  public ByteBuffer iconLockScreenOnInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 56, 1); }
  public String iconLockScreenOff() { int o = __offset(58); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer iconLockScreenOffAsByteBuffer() { return __vector_as_bytebuffer(58, 1); }
  public ByteBuffer iconLockScreenOffInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 58, 1); }
  public String subcategoryId() { int o = __offset(60); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer subcategoryIdAsByteBuffer() { return __vector_as_bytebuffer(60, 1); }
  public ByteBuffer subcategoryIdInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 60, 1); }
  public String desc() { int o = __offset(62); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer descAsByteBuffer() { return __vector_as_bytebuffer(62, 1); }
  public ByteBuffer descInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 62, 1); }
  public String model() { int o = __offset(64); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer modelAsByteBuffer() { return __vector_as_bytebuffer(64, 1); }
  public ByteBuffer modelInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 64, 1); }
  public String name() { int o = __offset(66); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(66, 1); }
  public ByteBuffer nameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 66, 1); }
  public String modelRegex() { int o = __offset(68); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer modelRegexAsByteBuffer() { return __vector_as_bytebuffer(68, 1); }
  public ByteBuffer modelRegexInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 68, 1); }
  public String iconBluetoothPairing() { int o = __offset(70); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer iconBluetoothPairingAsByteBuffer() { return __vector_as_bytebuffer(70, 1); }
  public ByteBuffer iconBluetoothPairingInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 70, 1); }
  public String iconReal() { int o = __offset(72); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer iconRealAsByteBuffer() { return __vector_as_bytebuffer(72, 1); }
  public ByteBuffer iconRealInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 72, 1); }
  public String nameSmartconfig() { int o = __offset(74); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameSmartconfigAsByteBuffer() { return __vector_as_bytebuffer(74, 1); }
  public ByteBuffer nameSmartconfigInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 74, 1); }
  public String brandName() { int o = __offset(76); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer brandNameAsByteBuffer() { return __vector_as_bytebuffer(76, 1); }
  public ByteBuffer brandNameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 76, 1); }
  public String btRssi() { int o = __offset(78); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer btRssiAsByteBuffer() { return __vector_as_bytebuffer(78, 1); }
  public ByteBuffer btRssiInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 78, 1); }
  public String iconSmartconfigOff() { int o = __offset(80); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer iconSmartconfigOffAsByteBuffer() { return __vector_as_bytebuffer(80, 1); }
  public ByteBuffer iconSmartconfigOffInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 80, 1); }

  public static int createPlugin(FlatBufferBuilder builder,
      int pd_id,
      int status,
      int ios_status,
      int min_app_version,
      int bind_confirm,
      int pid,
      int bt_bind_style,
      int wexin_share,
      int permission_control,
      int bt_match,
      int sc_failed,
      int voice_control,
      int voice_ctrl_ed,
      int op_history,
      int sc_type,
      int sc_status,
      int ct_offline_enter,
      long change_time,
      int sc_type_moreOffset,
      int sc_type_more_v2Offset,
      int relationsOffset,
      int cate_nameOffset,
      int icon_onOffset,
      int icon_offOffset,
      int icon_offlineOffset,
      int icon_smartconfigOffset,
      int icon_lock_screen_onOffset,
      int icon_lock_screen_offOffset,
      int subcategory_idOffset,
      int descOffset,
      int modelOffset,
      int nameOffset,
      int model_regexOffset,
      int icon_bluetooth_pairingOffset,
      int icon_realOffset,
      int name_smartconfigOffset,
      int brand_nameOffset,
      int bt_rssiOffset,
      int icon_smartconfig_offOffset) {
    builder.startObject(39);
    Plugin.addChangeTime(builder, change_time);
    Plugin.addIconSmartconfigOff(builder, icon_smartconfig_offOffset);
    Plugin.addBtRssi(builder, bt_rssiOffset);
    Plugin.addBrandName(builder, brand_nameOffset);
    Plugin.addNameSmartconfig(builder, name_smartconfigOffset);
    Plugin.addIconReal(builder, icon_realOffset);
    Plugin.addIconBluetoothPairing(builder, icon_bluetooth_pairingOffset);
    Plugin.addModelRegex(builder, model_regexOffset);
    Plugin.addName(builder, nameOffset);
    Plugin.addModel(builder, modelOffset);
    Plugin.addDesc(builder, descOffset);
    Plugin.addSubcategoryId(builder, subcategory_idOffset);
    Plugin.addIconLockScreenOff(builder, icon_lock_screen_offOffset);
    Plugin.addIconLockScreenOn(builder, icon_lock_screen_onOffset);
    Plugin.addIconSmartconfig(builder, icon_smartconfigOffset);
    Plugin.addIconOffline(builder, icon_offlineOffset);
    Plugin.addIconOff(builder, icon_offOffset);
    Plugin.addIconOn(builder, icon_onOffset);
    Plugin.addCateName(builder, cate_nameOffset);
    Plugin.addRelations(builder, relationsOffset);
    Plugin.addScTypeMoreV2(builder, sc_type_more_v2Offset);
    Plugin.addScTypeMore(builder, sc_type_moreOffset);
    Plugin.addCtOfflineEnter(builder, ct_offline_enter);
    Plugin.addScStatus(builder, sc_status);
    Plugin.addScType(builder, sc_type);
    Plugin.addOpHistory(builder, op_history);
    Plugin.addVoiceCtrlEd(builder, voice_ctrl_ed);
    Plugin.addVoiceControl(builder, voice_control);
    Plugin.addScFailed(builder, sc_failed);
    Plugin.addBtMatch(builder, bt_match);
    Plugin.addPermissionControl(builder, permission_control);
    Plugin.addWexinShare(builder, wexin_share);
    Plugin.addBtBindStyle(builder, bt_bind_style);
    Plugin.addPid(builder, pid);
    Plugin.addBindConfirm(builder, bind_confirm);
    Plugin.addMinAppVersion(builder, min_app_version);
    Plugin.addIosStatus(builder, ios_status);
    Plugin.addStatus(builder, status);
    Plugin.addPdId(builder, pd_id);
    return Plugin.endPlugin(builder);
  }

  public static void startPlugin(FlatBufferBuilder builder) { builder.startObject(39); }
  public static void addPdId(FlatBufferBuilder builder, int pdId) { builder.addInt(0, pdId, 0); }
  public static void addStatus(FlatBufferBuilder builder, int status) { builder.addInt(1, status, 0); }
  public static void addIosStatus(FlatBufferBuilder builder, int iosStatus) { builder.addInt(2, iosStatus, 0); }
  public static void addMinAppVersion(FlatBufferBuilder builder, int minAppVersion) { builder.addInt(3, minAppVersion, 0); }
  public static void addBindConfirm(FlatBufferBuilder builder, int bindConfirm) { builder.addInt(4, bindConfirm, 0); }
  public static void addPid(FlatBufferBuilder builder, int pid) { builder.addInt(5, pid, 0); }
  public static void addBtBindStyle(FlatBufferBuilder builder, int btBindStyle) { builder.addInt(6, btBindStyle, 0); }
  public static void addWexinShare(FlatBufferBuilder builder, int wexinShare) { builder.addInt(7, wexinShare, 0); }
  public static void addPermissionControl(FlatBufferBuilder builder, int permissionControl) { builder.addInt(8, permissionControl, 0); }
  public static void addBtMatch(FlatBufferBuilder builder, int btMatch) { builder.addInt(9, btMatch, 0); }
  public static void addScFailed(FlatBufferBuilder builder, int scFailed) { builder.addInt(10, scFailed, 0); }
  public static void addVoiceControl(FlatBufferBuilder builder, int voiceControl) { builder.addInt(11, voiceControl, 0); }
  public static void addVoiceCtrlEd(FlatBufferBuilder builder, int voiceCtrlEd) { builder.addInt(12, voiceCtrlEd, 0); }
  public static void addOpHistory(FlatBufferBuilder builder, int opHistory) { builder.addInt(13, opHistory, 0); }
  public static void addScType(FlatBufferBuilder builder, int scType) { builder.addInt(14, scType, 0); }
  public static void addScStatus(FlatBufferBuilder builder, int scStatus) { builder.addInt(15, scStatus, 0); }
  public static void addCtOfflineEnter(FlatBufferBuilder builder, int ctOfflineEnter) { builder.addInt(16, ctOfflineEnter, 0); }
  public static void addChangeTime(FlatBufferBuilder builder, long changeTime) { builder.addLong(17, changeTime, 0L); }
  public static void addScTypeMore(FlatBufferBuilder builder, int scTypeMoreOffset) { builder.addOffset(18, scTypeMoreOffset, 0); }
  public static int createScTypeMoreVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startScTypeMoreVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addScTypeMoreV2(FlatBufferBuilder builder, int scTypeMoreV2Offset) { builder.addOffset(19, scTypeMoreV2Offset, 0); }
  public static int createScTypeMoreV2Vector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startScTypeMoreV2Vector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addRelations(FlatBufferBuilder builder, int relationsOffset) { builder.addOffset(20, relationsOffset, 0); }
  public static int createRelationsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startRelationsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addCateName(FlatBufferBuilder builder, int cateNameOffset) { builder.addOffset(21, cateNameOffset, 0); }
  public static void addIconOn(FlatBufferBuilder builder, int iconOnOffset) { builder.addOffset(22, iconOnOffset, 0); }
  public static void addIconOff(FlatBufferBuilder builder, int iconOffOffset) { builder.addOffset(23, iconOffOffset, 0); }
  public static void addIconOffline(FlatBufferBuilder builder, int iconOfflineOffset) { builder.addOffset(24, iconOfflineOffset, 0); }
  public static void addIconSmartconfig(FlatBufferBuilder builder, int iconSmartconfigOffset) { builder.addOffset(25, iconSmartconfigOffset, 0); }
  public static void addIconLockScreenOn(FlatBufferBuilder builder, int iconLockScreenOnOffset) { builder.addOffset(26, iconLockScreenOnOffset, 0); }
  public static void addIconLockScreenOff(FlatBufferBuilder builder, int iconLockScreenOffOffset) { builder.addOffset(27, iconLockScreenOffOffset, 0); }
  public static void addSubcategoryId(FlatBufferBuilder builder, int subcategoryIdOffset) { builder.addOffset(28, subcategoryIdOffset, 0); }
  public static void addDesc(FlatBufferBuilder builder, int descOffset) { builder.addOffset(29, descOffset, 0); }
  public static void addModel(FlatBufferBuilder builder, int modelOffset) { builder.addOffset(30, modelOffset, 0); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(31, nameOffset, 0); }
  public static void addModelRegex(FlatBufferBuilder builder, int modelRegexOffset) { builder.addOffset(32, modelRegexOffset, 0); }
  public static void addIconBluetoothPairing(FlatBufferBuilder builder, int iconBluetoothPairingOffset) { builder.addOffset(33, iconBluetoothPairingOffset, 0); }
  public static void addIconReal(FlatBufferBuilder builder, int iconRealOffset) { builder.addOffset(34, iconRealOffset, 0); }
  public static void addNameSmartconfig(FlatBufferBuilder builder, int nameSmartconfigOffset) { builder.addOffset(35, nameSmartconfigOffset, 0); }
  public static void addBrandName(FlatBufferBuilder builder, int brandNameOffset) { builder.addOffset(36, brandNameOffset, 0); }
  public static void addBtRssi(FlatBufferBuilder builder, int btRssiOffset) { builder.addOffset(37, btRssiOffset, 0); }
  public static void addIconSmartconfigOff(FlatBufferBuilder builder, int iconSmartconfigOffOffset) { builder.addOffset(38, iconSmartconfigOffOffset, 0); }
  public static int endPlugin(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}

