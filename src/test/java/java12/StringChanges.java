package java12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.baeldung.com/java-12-new-features
 */
public class StringChanges {
    @Test
    public void indent() {
        String text = "Hello Baeldung!\nThis is Java 12 article.";

        text = text.indent(4);
        System.out.println(text);

        text = text.indent(-10);
        System.out.println(text);
    }

    @Test
    public void transform() {
        String text = "Baeldung";
        String transformed = text.transform(value ->
                new StringBuilder(value).reverse().toString()
        );

        assertEquals("gnudleaB", transformed);
    }
}
