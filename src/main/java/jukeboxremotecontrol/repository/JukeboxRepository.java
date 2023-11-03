package jukeboxremotecontrol.repository;

import jukeboxremotecontrol.model.Jukebox;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JukeboxRepository extends CrudRepository<Jukebox, Long>{}
