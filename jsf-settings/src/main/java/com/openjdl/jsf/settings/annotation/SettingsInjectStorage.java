package com.openjdl.jsf.settings.annotation;

import com.openjdl.jsf.settings.InjectSettingsStorageProvider;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created at 2020-09-10 14:15:11
 *
 * @author kidal
 * @since 0.3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SettingsInjectStorage {
  /**
   * {@link #storageId()}
   */
  @AliasFor("storageId")
  String value() default "";

  /**
   *
   */
  @AliasFor("value")
  String storageId() default "";

  /**
   *
   */
  boolean required() default true;

  /**
   *
   */
  Class<? extends InjectSettingsStorageProvider> providerType() default InjectSettingsStorageProvider.class;
}
