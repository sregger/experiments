package java14;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * https://www.baeldung.com/java-13-new-features
 */
public class NewFeatures {
    @ParameterizedTest(name = "{arguments}")
    @ValueSource(strings = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"})
    public void releasedSwitch(String day) {
        boolean isTodayHoliday;
        switch (day) {
            case "MONDAY":
            case "TUESDAY":
            case "WEDNESDAY":
            case "THURSDAY":
            case "FRIDAY":
                isTodayHoliday = false;
                break;
            case "SATURDAY":
            case "SUNDAY":
                isTodayHoliday = true;
                break;
            default:
                throw new IllegalArgumentException("What's a " + day);
        }

        // versus

        isTodayHoliday = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
            case "SATURDAY", "SUNDAY" -> true;
            default -> throw new IllegalArgumentException("What's a " + day);
        };

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

    @Test
    public void exception() {
        int[] arr = null;
        try {
            arr[0] = 1;
        }
        catch(NullPointerException e) {
            // Prints java.lang.NullPointerException: Cannot store to int array because "arr" is null
            e.printStackTrace();
        }
    }
}
