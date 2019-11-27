package action;

import enums.ExperimentalPlaneClassificationLevel;
import enums.ExperimentalPlaneType;
import enums.MilitaryPlaneType;
import model.airport.Airport;
import model.plane.ExperimentalPlane;
import model.plane.MilitaryPlane;
import model.plane.PassengerPlane;
import model.plane.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportCreator {
    private static List<Plane> planes = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 300, 482, 555, ExperimentalPlaneType.HIGH_ALTITUDE, ExperimentalPlaneClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ExperimentalPlaneClassificationLevel.TOP_SECRET),
            new PassengerPlane("Boeing-737", 900, 15000, 58300, 190),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),

            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 500, 13200, 61000, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT)
    );

    public static Airport createAirportWithCredentials() {
        return new Airport(planes);
    }
}
