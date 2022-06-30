package Programmers;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class _2016년 {
    public String solution(int a, int b) {
        return LocalDate.of(2016, a, b)
                .getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
    }
}
