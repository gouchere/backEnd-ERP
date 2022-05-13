package com.erp.lymytz.api.model;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface YvsAlias {
	String name() default "";
}
