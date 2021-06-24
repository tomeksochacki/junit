import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public final class Clock implements Serializable {
    public static Clock of(final int hours, final int minutes) {
        if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60)
            throw new IllegalArgumentException("Invalid time specification");
        return new Clock(hours, minutes);
    }

    public int getHours() {
        return time / 60;
    }

    public int getMinutes() {
        return time % 60;
    }

    public Clock add(final int minutes) {
        if (minutes < 0) throw new IllegalArgumentException("Cannot go back in time");
        return new Clock((short) ((time + minutes) % MINUTES_PER_HOUR));
    }

    public Clock add(final Clock rightSide) {
        if (rightSide == null)
            throw new IllegalArgumentException("Can not add null clock");
        return new Clock((short) ((time + rightSide.time) % MINUTES_PER_HOUR));
    }

    private Clock(final short time) {
        this.time = time;
    }

    private Clock(final int hours, final int minutes) {
        time = (short) (hours * 60 + minutes);
    }

    private static final int MINUTES_PER_HOUR = (int) TimeUnit.HOURS.toMinutes(24);
    private final short time;
}
