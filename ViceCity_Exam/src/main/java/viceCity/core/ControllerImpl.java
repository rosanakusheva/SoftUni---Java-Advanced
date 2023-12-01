package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.BaseGun;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.FIGHT_HAPPENED;

public class ControllerImpl implements Controller {
    private static final int TOMMY_MAX_HEALTH = 100;
    private static final int CIVIL_MAX_HEALTH = 50;
    private Player tommyVercetti;
    private Map<String, Player> civilPlayers;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        tommyVercetti = new MainPlayer();
        civilPlayers = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player playerToAdd = new CivilPlayer(name);
        civilPlayers.put(name, playerToAdd);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Rifle":
                gun = new Rifle(name);
                break;
            case "Pistol":
                gun = new Pistol(name);
                break;
            default:
                return String.format(ConstantMessages.GUN_TYPE_INVALID);
        }
        guns.offer(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String playerName) {
        Gun gunToAdd = guns.poll();
        if (gunToAdd == null) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }

        if (playerName.equals("Vercetti")) {
            tommyVercetti.getGunRepository().add(gunToAdd);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gunToAdd.getName(), tommyVercetti.getName());
        }

        Player civilPlayer = civilPlayers.get(playerName);
        if (civilPlayer == null) {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        civilPlayer.getGunRepository().add(gunToAdd);
        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gunToAdd.getName(), playerName);

    }

    @Override
    public String fight() {
        neighbourhood.action(tommyVercetti, civilPlayers.values());
        if (tommyVercetti.getLifePoints() == TOMMY_MAX_HEALTH) {
            boolean everyoneIsAtMaxHealth = true;
            for (Player civilPlayer : civilPlayers.values()) {
                if (civilPlayer.getLifePoints() < 50) {
                    everyoneIsAtMaxHealth = false;
                }
            }
            if (everyoneIsAtMaxHealth) {
                return ConstantMessages.FIGHT_HOT_HAPPENED;
            }
        }

        List<Player> deadPlayers = civilPlayers.values()
                .stream()
                .filter(player -> !player.isAlive())
                .collect(Collectors.toList());


        StringBuilder sb = new StringBuilder(FIGHT_HAPPENED)
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, tommyVercetti.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size() - deadPlayers.size()));

        for (Player deadPlayer : deadPlayers) {
            civilPlayers.remove(deadPlayer.getName());
        }
        return sb.toString();

    }
}
