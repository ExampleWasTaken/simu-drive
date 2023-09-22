package nz.ewt.simvar;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SimvarRecord {
    private final Instant instant;
    private final SimvarName simvarName;
    private final Object value;

    public SimvarRecord(SimvarName simvarName, Object value) {
        this.instant = Instant.now();
        this.simvarName = simvarName;
        this.value = value;
    }

    /**
     * @return The instant when this record was created.
     */
    public Instant getInstant() {
        return instant;
    }

    public SimvarName getSimvarName() {
        return simvarName;
    }

    public Object getValue() {
        return value;
    }

    /**
     * @return The record in the following format: {@code [<local time format>] <simvar name>: <simvar value>}
     */
    @Override
    public String toString() {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime localTime = instant.atZone(zoneId);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
        String formattedTimeString = localTime.format(formatter);

        return "[" + formattedTimeString + "] " + simvarName + ": " + value;
    }
}
