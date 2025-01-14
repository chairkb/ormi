package biz.stech.reflect;

import biz.stech.db.relational.SortOrder;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface ReflectIndex {
	public String indexName() default "";
	public boolean isUnique() default false;
	public int indexNo() default 0;
	public SortOrder indexOrder() default SortOrder.ASC;
}
