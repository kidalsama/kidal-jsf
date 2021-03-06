package com.openjdl.jsf.settings.annotation;

import com.openjdl.jsf.settings.InjectSettingsValueProvider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created at 2020-09-10 14:17:24
 *
 * @author kidal
 * @since 0.3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SettingsInjectValue {
  /**
   *
   */
  String storageId() default "";

  /**
   *
   */
  String key() default "";

  /**
   *
   */
  boolean required() default true;

  /**
   *
   */
  boolean applyDefaultsResolver() default true;

  /**
   *
   */
  Class<? extends InjectSettingsValueProvider> providerType() default InjectSettingsValueProvider.class;
}
