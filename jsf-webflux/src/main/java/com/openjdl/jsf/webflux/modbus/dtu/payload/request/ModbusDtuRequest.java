package com.openjdl.jsf.webflux.modbus.dtu.payload.request;

import io.netty.buffer.ByteBuf;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Created at 2020-12-07 22:34:24
 *
 * @author kidal
 * @since 0.5
 */
public interface ModbusDtuRequest {
  /**
   * 空消息体
   */
  ModbusDtuRequest EMPTY = new ModbusDtuEmptyRequest();

  /**
   * 空消息体
   */
  class ModbusDtuEmptyRequest implements ModbusDtuRequest {
    @Override
    public String toString() {
      return "ModbusDtuEmptyRequest{}";
    }
  }

  /**
   * 功能码
   */
  default short getFc() {
    return 0;
  }

  /**
   * 字节数
   */
  default short getByteCount() {
    return 0;
  }

  /**
   * 值
   */
  @NotNull
  default byte[] getValues() {
    return ArrayUtils.EMPTY_BYTE_ARRAY;
  }

  /**
   * 写入
   */
  default void write(@NotNull ByteBuf out) {

  }
}