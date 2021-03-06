/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.frostwire.jlibtorrent.swig;

public class bdecode_token {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected bdecode_token(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(bdecode_token obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_bdecode_token(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public bdecode_token(long off, bdecode_token.type_t t) {
    this(libtorrent_jni.new_bdecode_token__SWIG_0(off, t.swigValue()), true);
  }

  public bdecode_token(long off, long next, bdecode_token.type_t t, short header_size) {
    this(libtorrent_jni.new_bdecode_token__SWIG_1(off, next, t.swigValue(), header_size), true);
  }

  public bdecode_token(long off, long next, bdecode_token.type_t t) {
    this(libtorrent_jni.new_bdecode_token__SWIG_2(off, next, t.swigValue()), true);
  }

  public int start_offset() {
    return libtorrent_jni.bdecode_token_start_offset(swigCPtr, this);
  }

  public void setOffset(long value) {
    libtorrent_jni.bdecode_token_offset_set(swigCPtr, this, value);
  }

  public long getOffset() {
    return libtorrent_jni.bdecode_token_offset_get(swigCPtr, this);
  }

  public void setType(long value) {
    libtorrent_jni.bdecode_token_type_set(swigCPtr, this, value);
  }

  public long getType() {
    return libtorrent_jni.bdecode_token_type_get(swigCPtr, this);
  }

  public void setNext_item(long value) {
    libtorrent_jni.bdecode_token_next_item_set(swigCPtr, this, value);
  }

  public long getNext_item() {
    return libtorrent_jni.bdecode_token_next_item_get(swigCPtr, this);
  }

  public void setHeader(long value) {
    libtorrent_jni.bdecode_token_header_set(swigCPtr, this, value);
  }

  public long getHeader() {
    return libtorrent_jni.bdecode_token_header_get(swigCPtr, this);
  }

  public final static class type_t {
    public final static bdecode_token.type_t none = new bdecode_token.type_t("none");
    public final static bdecode_token.type_t dict = new bdecode_token.type_t("dict");
    public final static bdecode_token.type_t list = new bdecode_token.type_t("list");
    public final static bdecode_token.type_t string = new bdecode_token.type_t("string");
    public final static bdecode_token.type_t integer = new bdecode_token.type_t("integer");
    public final static bdecode_token.type_t end = new bdecode_token.type_t("end");

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static type_t swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + type_t.class + " with value " + swigValue);
    }

    private type_t(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private type_t(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private type_t(String swigName, type_t swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static type_t[] swigValues = { none, dict, list, string, integer, end };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class limits_t {
    public final static bdecode_token.limits_t max_offset = new bdecode_token.limits_t("max_offset", libtorrent_jni.bdecode_token_max_offset_get());
    public final static bdecode_token.limits_t max_next_item = new bdecode_token.limits_t("max_next_item", libtorrent_jni.bdecode_token_max_next_item_get());
    public final static bdecode_token.limits_t max_header = new bdecode_token.limits_t("max_header", libtorrent_jni.bdecode_token_max_header_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static limits_t swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + limits_t.class + " with value " + swigValue);
    }

    private limits_t(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private limits_t(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private limits_t(String swigName, limits_t swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static limits_t[] swigValues = { max_offset, max_next_item, max_header };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
