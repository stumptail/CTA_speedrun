public class CTAStopTimes{

    // ID realted Data
    private int tripID; // ID of the trip this is part of
    private int stopID; // ID of that we stop at
    private int stopSequence; // the stop number in a praticular route(ie. 1 means first stop, 2 means second)

    // time realted data
    private CTATime arrivalTime; // time train/bus arrives at stop
    private CTATime departureTime; // time train/bus leaves stop

    // probably useless data
    private String stopHeadsign; //what the bus headsign says
    private int pickupType; // no idea
    private int shapeDistTraveled // no idea what this is for
    /**
     * Constructs a CTAStopTimes object with all stop time information.
     *
     * @param trip_id the ID of the trip this stop time belongs to
     * @param arrival_time the scheduled arrival time at the stop
     * @param departure_time the scheduled departure time from the stop
     * @param stop_id the ID of the stop
     * @param stop_sequence the order of this stop within the trip
     * @param stop_headsign the text shown to riders describing the destination or direction
     * @param pickup_type the pickup type for this stop
     * @param shape_dist_traveled the distance traveled along the route shape to this stop
     */
    public void CTAStopTimes (int trip_id, CTATime arrival_time, CTATime departure_time, int stop_id, int stop_sequence, String stop_headsign, int pickup_type, int shape_dist_traveled){
        this.tripID = trip_id;
        this.stopID = stop_id;
        this.arrivalTime = arrival_time;
        this.departureTime = departure_time;
        this.stopID = stop_id;
        this.stopSequence = stop_sequence;
        this.stopHeadsign = stop_headsign;
        this.pickupType = pickup_type;
        this.shapeDistTraveled = shape_dist_traveled;
    }
    /**
     * Constructs a CTAStopTimes object with only the required stop time information.
     *
     * This constructor should be used when stop headsign, pickup type, and
     * shape distance traveled are not available.
     *
     * @param trip_id the ID of the trip this stop time belongs to
     * @param arrival_time the scheduled arrival time at the stop
     * @param departure_time the scheduled departure time from the stop
     * @param stop_id the ID of the stop
     * @param stop_sequence the order of this stop within the trip
     */
    public void CTAStopTimes (int trip_id, CTATime arrival_time, CTATime departure_time, int stop_id, int stop_sequence){
        this.tripID = trip_id;
        this.stopID = stop_id;
        this.arrivalTime = arrival_time;
        this.departureTime = departure_time;
        this.stopID = stop_id;
        this.stopSequence = stop_sequence;
    }
}