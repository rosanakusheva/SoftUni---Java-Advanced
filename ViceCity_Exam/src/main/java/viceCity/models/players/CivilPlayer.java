package viceCity.models.players;

public class CivilPlayer extends BasePlayer{
    private static final int CIVIL_START_HEALTH = 50;
    public CivilPlayer(String name) {
        super(name, CIVIL_START_HEALTH);
    }

}
