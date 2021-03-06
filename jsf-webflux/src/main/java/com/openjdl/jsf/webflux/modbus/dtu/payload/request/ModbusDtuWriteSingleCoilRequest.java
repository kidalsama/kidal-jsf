package com.openjdl.jsf.webflux.modbus.dtu.payload.request;

import com.openjdl.jsf.webflux.modbus.dtu.ModbusDtuFc;
import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

/**
 * Created at 2020-12-14 15:43:32
 *
 * @author kidal
 * @since 0.5
 */
public class ModbusDtuWriteSingleCoilRequest implements ModbusDtuRequest {
  /**
   * 地址
   */
  private final int address;

  /**
   * 值
   */
  private final boolean flag;

  /**
   *
   */
  public ModbusDtuWriteSingleCoilRequest(int address, boolean flag) {
    if (address < 0 || address > 0xFFFF) { // [0, 65535]
      throw new IllegalArgumentException("Invalid addr: " + address);
    }
    this.address = address;
    this.flag = flag;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "ModbusDtuWriteSingleCoilRequest{" +
      "fc=" + getFc() +
      ", byteCount=" + getByteCount() +
      ", address=" + getAddress() +
      ", flag=" + isFlag() +
      '}';
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public short getFc() {
    return ModbusDtuFc.WRITE_SINGLE_COIL.getCode();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public short getByteCount() {
    return 5;
  }

  /**
   * 地址
   */
  public int getAddress() {
    return address;
  }

  /**
   * 值
   */
  public boolean isFlag() {
    return flag;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void write(@NotNull ByteBuf out) {
    out.writeByte(getFc()); // 0
    out.writeShort(getAddress()); // 1-2
    out.writeShort(isFlag() ? 0xFF00 : 0x0000); // 3-4
  }
}