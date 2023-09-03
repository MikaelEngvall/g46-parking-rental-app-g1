package se.lexicon.data;

import se.lexicon.model.ParkingSpot;

public interface ParkingSpotDao extends BaseDao<ParkingSpot, Integer> {

    void occupyParkingSpot(int spotNumber); // True

    void vacateParkingSpot(int spotNumber); // /False
}
