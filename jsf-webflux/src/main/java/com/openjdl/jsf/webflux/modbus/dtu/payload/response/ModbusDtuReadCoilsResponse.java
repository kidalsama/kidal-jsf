package com.openjdl.jsf.webflux.modbus.dtu.payload.response;

import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created at 2020-12-07 22:17:40
 *
 * @author kidal
 * @since 0.5
 */
public class ModbusDtuReadCoilsResponse implements ModbusDtuResponse {
  /**
   * log
   */
  protected static final Logger log = LoggerFactory.getLogger(ModbusDtuReadCoilsResponse.class);

  /**
   * 创建
   */
  @Nullable
  public static ModbusDtuReadCoilsResponse of(@NotNull ByteBuf in) {
    if (in.readableBytes() < 1) {
      log.trace("Data not enough: {} < {}", in.readableBytes(), 1);
      return null;
    }

    short byteCount = in.readUnsignedByte();

    if (in.readableBytes() < byteCount + 2) {
      log.trace("Data not enough: {} < {}", in.readableBytes(), byteCount + 2);
      return null;
    }

    int[] values = new int[byteCount];
    for (int i = 0; i < byteCount; i += 2) {
      values[i / 2] = in.readUnsignedShort();
    }

    return new ModbusDtuReadCoilsResponse(byteCount, values);
  }

  /**
   * 字节数
   */
  private final short byteCount;

  /**
   * 数据值
   */
  private final int[] values;

  /**
   *
   */
  public ModbusDtuReadCoilsResponse(short byteCount, int[] values) {
    this.byteCount = byteCount;
    this.values = values;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "ModbusDtuReadCoilsResponse{" +
      "fc=" + getFc() +
      "byteCount=" + getByteCount() +
      ", values=" + Arrays.toString(getValues()) +
      '}';
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public short getFc() {
    return 0x01;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public short getByteCount() {
    return byteCount;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @NotNull
  public int[] getValues() {
    return values;
  }
}