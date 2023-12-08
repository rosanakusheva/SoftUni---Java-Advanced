package handball.core;

import handball.common.ConstantMessages;
import handball.common.ExceptionMessages;
import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private Repository equipment;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay;
        if (gameplayType.equals("Outdoor")) {
            gameplay = new Outdoor(gameplayName);
        } else if (gameplayType.equals("Indoor")) {
            gameplay = new Indoor(gameplayType);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_GAMEPLAY_TYPE);
        }

        this.gameplays.add(gameplay);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipment1;
        if (equipmentType.equals("Kneepad")) {
            equipment1 = new Kneepad();

        } else if (equipmentType.equals("Elbowpad")) {
            equipment1 = new ElbowPad();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_EQUIPMENT_TYPE);
        }

        this.equipment.add(equipment1);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment equipment = this.equipment.findByType(equipmentType);
        if (equipment == null) {
            throw new IllegalArgumentException(ExceptionMessages.NO_EQUIPMENT_FOUND);
        }

        Gameplay gameplay = getGameplayByName(gameplayName);

        gameplay.addEquipment(equipment);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    private Gameplay getGameplayByName(String gameplayName) {
        Gameplay gameplay = this.gameplays.stream()
                .filter(game -> game.getName().equals(gameplayName))
                .findFirst()
                .orElse(null);
        return gameplay;
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team;

        Gameplay gameplay = getGameplayByName(gameplayName);

        if (teamType.equals("Bulgaria")) {
            team = new Bulgaria(teamName, country, advantage);
            if (gameplay.getClass().getSimpleName().equals("Outdoor")) {
                gameplay.addTeam(team);
            } else {
                return ConstantMessages.GAMEPLAY_NOT_SUITABLE;
            }
        } else if (teamType.equals("Germany")) {
            team = new Germany(teamName, country, advantage);
            if (gameplay.getClass().getSimpleName().equals("Indoor")) {
                gameplay.addTeam(team);
            } else {
                return ConstantMessages.GAMEPLAY_NOT_SUITABLE;
            }
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TEAM_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = getGameplayByName(gameplayName);
        gameplay.getTeam().forEach(team -> team.play());
        return String.format(ConstantMessages.TEAMS_PLAYED, gameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay gameplay = getGameplayByName(gameplayName);
        int advantageSum = gameplay.getTeam()
                .stream()
                .mapToInt(team -> team.getAdvantage())
                .sum();
        return String.format(ConstantMessages.ADVANTAGE_GAMEPLAY, gameplayName, advantageSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        gameplays.forEach(gameplay -> {
            sb.append(gameplay.toString())
                    .append(System.lineSeparator());
        });
        return sb.toString().trim();
    }
}
