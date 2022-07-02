package java11;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.ListAssert.assertThatList;

/**
 * https://www.baeldung.com/java-11-new-features
 */
public class StringChanges {
    @Test
    public void changes() {
        String multilineString = "Baeldung helps \n \n developers \n explore Java.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
        assertThatList(lines).containsExactly("Baeldung helps", "developers", "explore Java.");
    }
}
