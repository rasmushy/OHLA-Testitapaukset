package timeUtils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
class TimeUtilsTest {

    @ParameterizedTest(name = "Aika {0} muodostaa sekunnit {1}")
    @CsvSource({
            "0:00:00, 0",
            "0:00:01, 1",
            "0:00:59, 59",
            "0:01:00, 60",
            "0:01:01, 61",
            "0:59:59, 3599",
            "1:00:00, 3600",
            "1:01:01, 3661",
            "24:00:00, 86400",
            "25:00:00, -1",
            "-1:00:00, -1",
    })
    void timeToSec( String timeString,int expectedSec ) {
        int actualSec = TimeUtils.timeToSec(timeString);
        assertEquals(expectedSec, actualSec, "Sekunnit laskettu väärin");
    }

    @ParameterizedTest(name = "Sekunnit {0} muodostavat ajan {1}")
    @CsvSource({
            "0, 0:00:00",
            "1, 0:00:01",
            "59, 0:00:59",
            "60, 0:01:00",
            "61, 0:01:01",
            "3599, 0:59:59",
            "3600, 1:00:00",
            "3661, 1:01:01",
            "86400, 24:00:00",
            "90000, -1",
            "-1, -1"
    })
    void secToTime(int seconds, String expectedTime) {
        String actualTime = TimeUtils.secToTime(seconds);
        assertEquals(expectedTime, actualTime, "Aika laskettu väärin");
    }
}
