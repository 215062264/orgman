package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private Set<Race> raceDB;
    private static RaceRepository raceRepository = null;

    private RaceRepositoryImpl() {
        this.raceDB = new HashSet<>();
    }

    public static RaceRepository getRaceRepository() {
        if (raceRepository == null) raceRepository = new RaceRepositoryImpl();
        return raceRepository;
    }

    //TODO: Implement body
    @Override
    public Race create(Race race) {
        this.raceDB.add(race);
        return race;
    }

    //TODO: Implement body
    @Override
    public Race read(String raceId) {
        for(Race race: this.raceDB){
            if(race.getRaceId().equals(raceId))
                return race;
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public Race update(Race race) {
        Race oldRace = read(race.getRaceId());
        if(oldRace != null){
            Race newRace = new Race.Builder().copy(oldRace).build();
            return newRace;
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String raceId) {
        this.raceDB.remove(read(raceId));
    }

    //TODO: Implement body
    @Override
    public Set<Race> getAll() {
        return this.raceDB;
    }
}
