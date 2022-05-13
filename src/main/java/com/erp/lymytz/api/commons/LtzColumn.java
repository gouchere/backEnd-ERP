package com.erp.lymytz.api.commons;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**Anotation défini pour indiquer les collonnes qui sont par défaut récupérer par jdbc**/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LtzColumn{
    boolean main() default true;
	
}
