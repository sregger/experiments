package java13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://www.baeldung.com/java-13-new-features
 */
public class NewFeatures {
    @Test
    public void newSwitch() {
        var me = 4;
        var operation = "squareMe";
        var result = switch (operation) {
            case "doubleMe" -> me * 2;
            case "squareMe" -> me * me;
            default -> me;
        };

        assertEquals(16, result);
    }

    @Test
    public void textBlock() {
        String TEXT_BLOCK_JSON = """
{
    "name" : "Baeldung",
    "website" : "https://www.%s.com/"
}""";
        assertTrue(TEXT_BLOCK_JSON.contains("Baeldung"));
        assertTrue(TEXT_BLOCK_JSON.indexOf("www") > 0);
        assertTrue(TEXT_BLOCK_JSON.length() > 0);

        System.out.println(TEXT_BLOCK_JSON);
    }
}
