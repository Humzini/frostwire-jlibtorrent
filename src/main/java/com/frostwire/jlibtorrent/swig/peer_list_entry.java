/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.frostwire.jlibtorrent.swig;

public class peer_list_entry {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected peer_list_entry(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(peer_list_entry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_peer_list_entry(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setIp(tcp_endpoint value) {
    libtorrent_jni.peer_list_entry_ip_set(swigCPtr, this, tcp_endpoint.getCPtr(value), value);
  }

  public tcp_endpoint getIp() {
    long cPtr = libtorrent_jni.peer_list_entry_ip_get(swigCPtr, this);
    return (cPtr == 0) ? null : new tcp_endpoint(cPtr, false);
  }

  public void setFlags(int value) {
    libtorrent_jni.peer_list_entry_flags_set(swigCPtr, this, value);
  }

  public int getFlags() {
    return libtorrent_jni.peer_list_entry_flags_get(swigCPtr, this);
  }

  public void setFailcount(short value) {
    libtorrent_jni.peer_list_entry_failcount_set(swigCPtr, this, value);
  }

  public short getFailcount() {
    return libtorrent_jni.peer_list_entry_failcount_get(swigCPtr, this);
  }

  public void setSource(short value) {
    libtorrent_jni.peer_list_entry_source_set(swigCPtr, this, value);
  }

  public short getSource() {
    return libtorrent_jni.peer_list_entry_source_get(swigCPtr, this);
  }

  public peer_list_entry() {
    this(libtorrent_jni.new_peer_list_entry(), true);
  }

  public final static class flags_t {
    public final static peer_list_entry.flags_t banned = new peer_list_entry.flags_t("banned", libtorrent_jni.peer_list_entry_banned_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static flags_t swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + flags_t.class + " with value " + swigValue);
    }

    private flags_t(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private flags_t(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private flags_t(String swigName, flags_t swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static flags_t[] swigValues = { banned };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
