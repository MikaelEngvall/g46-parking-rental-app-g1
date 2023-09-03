package se.lexicon.data;

import se.lexicon.model.Reservation;

import java.util.Optional;

public interface ReservationDao extends BaseDao<Reservation, String> {

     Reservation create(Reservation t);

     Optional<Reservation> find(String id);


}
