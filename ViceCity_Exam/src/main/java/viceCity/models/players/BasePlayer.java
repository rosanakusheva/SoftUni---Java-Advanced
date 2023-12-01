package viceCity.models.players;

import viceCity.common.ExceptionMessages;
import viceCity.models.guns.Gun;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

public abstract class BasePlayer implements Player{
    private String name;
    private int livePoints;
    private Repository<Gun> gunRepository;

    public BasePlayer(String name, int livePoints) {
        this.setName(name);
        this.setLivePoints(livePoints);
        this.gunRepository = new GunRepository();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.NAME_NULL);
        }
        this.name = name;
    }

    private void setLivePoints(int livePoints) {
        if (livePoints < 0){
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.livePoints = livePoints;
    }

    @Override
    public boolean isAlive(){
        return this.livePoints > 0;
    }

    @Override
    public void takeLifePoints(int points){
        this.livePoints = this.livePoints - points;
        if (this.livePoints < 0){
            this.livePoints = 0;
        }
//        this.livePoints = Math.max(0, this.livePoints - points);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLifePoints() {
        return livePoints;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return gunRepository;
    }
}
