import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Authors(Author.Dominik)
public @interface Authors {
	Author[] value();
}
