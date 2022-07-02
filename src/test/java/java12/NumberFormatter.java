package java12;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberFormatter {
    @Test
    public void shortFormat() {
        NumberFormat compactNumber =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        compactNumber.setMaximumFractionDigits(2);
        assertEquals("2.59K", compactNumber.format(2592));

        assertEquals("6.1M", compactNumber.format(6_100_560));
        assertEquals("6.13M", compactNumber.format(6_125_560));
    }

    @Test
    public void longFormat() {
        NumberFormat compactNumber =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        compactNumber.setMaximumFractionDigits(2);
        assertEquals("2.59 thousand", compactNumber.format(2592));

        assertEquals("6.1 million", compactNumber.format(6_100_560));
        assertEquals("6.13 million", compactNumber.format(6_125_560));
    }

    @Test
    public void percentage() {
        NumberFormat percentage = NumberFormat.getPercentInstance();
        assertEquals("1%", percentage.format(.01));
        assertEquals("99%", percentage.format(.99));
        assertEquals("100%", percentage.format(1));
        assertEquals("200%", percentage.format(2));
        assertEquals("10,000%", percentage.format(100));

        assertEquals("259,200%", percentage.format(2592));

        assertEquals("610,056,000%", percentage.format(6_100_560));
        assertEquals("612,556,000%", percentage.format(6_125_560));
    }
}
