package se.lexicon.data;


import java.util.Optional;

public interface BaseDao<T, ID> {

    T create(T t);

    Optional<T> find(ID id);
}
