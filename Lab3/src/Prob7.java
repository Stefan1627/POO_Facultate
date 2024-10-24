class Route {
    String origin;
    String destination;

    public Route(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Route{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}

class ClockTime {
    int hour;
    int minute;

    public ClockTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "ClockTime{" +
                "hour=" + hour +
                ", minute=" + minute +
                '}';
    }
}

class Schedule {
    ClockTime departure;
    ClockTime arrival;

    public Schedule(ClockTime departure, ClockTime arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public int calculateTime (ClockTime departure, ClockTime arrival) {
        int result = 0;
        if (departure.hour > arrival.hour) {
            result = departure.hour - arrival.hour + 12;
        }
        else if (departure.hour < arrival.hour) {
            result = arrival.hour - departure.hour;
        }
        result *= 60;
        return 0;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "departure=" + departure +
                ", arrival=" + arrival +
                '}';
    }
}

class Train {
    Route r;
    Schedule s;
    boolean local;
    public Train(Route r, Schedule s, boolean local) {
        this.r = r;
        this.s = s;
        this.local = local;
    }

    @Override
    public String toString() {
        return "Train: " + local + " " + r.origin + "("
                + s.departure.hour + ":" + s.departure.minute + ") -> " + r.destination
                + "(" + s.arrival.hour + ":" + s.arrival.minute
                + ")";
    }
}

public class Prob7 {
    public static void main(String[] args) {
        ClockTime departure = new ClockTime(9, 0);
        ClockTime arrival = new ClockTime(11, 0);
        Route r = new Route("Bucuresti", "Pitesti");
        Schedule s = new Schedule(departure, arrival);
        Train a = new Train(r, s, true);
        System.out.println(a);
    }
}
