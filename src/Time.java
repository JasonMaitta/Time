public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time() {
        this(0, 0, 0);
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void increment(int secondsToAdd) {
        int totalSeconds = this.hours * 3600 + this.minutes * 60 + this.seconds;
        totalSeconds += secondsToAdd;

        if (totalSeconds < 0) {
            totalSeconds += 24 * 3600;
        }

        this.hours = totalSeconds / 3600 % 24;
        this.minutes = (totalSeconds % 3600) / 60;
        this.seconds = totalSeconds % 60;
    }

    public void print(boolean military) {
        if (military) {
            System.out.printf("%02d:%02d:%02d%n", this.hours, this.minutes, this.seconds);
        } else {
            String period = (this.hours < 12) ? "AM" : "PM";
            int hours12 = (this.hours == 0 || this.hours == 12) ? 12 : this.hours % 12;
            System.out.printf("%d:%02d:%02d %s%n", hours12, this.minutes, this.seconds, period);
        }
    }

    public static Time fromString(String timeStr) {
        String[] parts = timeStr.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return new Time(hours, minutes, seconds);
    }
}