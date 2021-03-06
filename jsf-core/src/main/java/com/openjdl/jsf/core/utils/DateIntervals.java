package com.openjdl.jsf.core.utils;

import org.jetbrains.annotations.NotNull;

/**
 * Created at 2020-08-04 17:30:00
 *
 * @author kidal
 * @since 0.1.0
 */
public class DateIntervals {
  private int days;
  private int hours;
  private int minutes;
  private int seconds;
  private int milliseconds;

  /**
   *
   */
  public DateIntervals() {
  }

  /**
   *
   */
  public DateIntervals(int days, int hours, int minutes, int seconds, int milliseconds) {
    this.days = days;
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
    this.milliseconds = milliseconds;
  }

  @Override
  public String toString() {
    return "DateIntervals{" +
      "days=" + days +
      ", hours=" + hours +
      ", minutes=" + minutes +
      ", seconds=" + seconds +
      ", milliseconds=" + milliseconds +
      '}';
  }

  @NotNull
  public String toDescriptionString(boolean withSeconds, boolean withMilliseconds) {
    StringBuilder builder = new StringBuilder();
    if (days > 0) {
      builder.append(days).append("天");
    }
    if (days > 0 || hours > 0) {
      builder.append(hours).append("小时");
    }
    if (days > 0 || hours > 0 || minutes > 0) {
      builder.append(minutes).append("分钟");
    }
    if (withSeconds && (days > 0 || hours > 0 || minutes > 0 || seconds > 0)) {
      builder.append(seconds).append("秒");
    }
    if (withSeconds && withMilliseconds && (days > 0 || hours > 0 || minutes > 0 || seconds > 0 || milliseconds > 0)) {
      builder.append(milliseconds).append("毫秒");
    }
    return builder.length() == 0
      ? "0分钟"
      : builder.toString();
  }

  @NotNull
  public String toDescriptionString() {
    return toDescriptionString(false, false);
  }

  //--------------------------------------------------------------------------
  //
  //--------------------------------------------------------------------------

  public int getDays() {
    return days;
  }

  public void setDays(int days) {
    this.days = days;
  }

  public int getHours() {
    return hours;
  }

  public void setHours(int hours) {
    this.hours = hours;
  }

  public int getMinutes() {
    return minutes;
  }

  public void setMinutes(int minutes) {
    this.minutes = minutes;
  }

  public int getSeconds() {
    return seconds;
  }

  public void setSeconds(int seconds) {
    this.seconds = seconds;
  }

  public int getMilliseconds() {
    return milliseconds;
  }

  public void setMilliseconds(int milliseconds) {
    this.milliseconds = milliseconds;
  }
}
