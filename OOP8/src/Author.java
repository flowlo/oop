import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Author(Authors.Dominik)
public @interface Author {
	Authors[] value();
}
