package org.campusdual;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    // ***************************************** VARIABLES *************************************************************
    public static final int MAX_RACE = 10;
    private String name;
    private int numRaces;
    private List<Garage> garageList;
    private List<ScoreCar> participants;
    private List<Race> raceList;
    protected static int tournamentId = 0;
    protected int id = 0;


    // **************************************** CONSTRUCTOR ************************************************************
    public Tournament(String name, int numRaces){
        this.name = name;
        this.numRaces = numRaces;
        this.participants = new ArrayList<>();
        this.raceList = new ArrayList<>(numRaces);
        createId();
    }
    public Tournament(String name){
        this.name = name;
        this.numRaces = MAX_RACE;
        this.participants = new ArrayList<>();
        this.raceList = new ArrayList<>(MAX_RACE);
        createId();
    }

    // ***************************************** TO STRING *************************************************************
    @Override
    public String toString() {
        return "Tournament{" +
                "name='" + name + '\'' +
                ", numRaces=" + numRaces +
                ", garageList=" + garageList +
                ", participants=" + participants +
                ", raceList=" + raceList +
                ", id=" + id +
                '}';
    }

    // ****************************************** GETTERS **************************************************************

    public String getName() {
        return name;
    }
    public int getNumRaces() {
        return numRaces;
    }
    public List<Garage> getGarageList() {
        return garageList;
    }
    public List<ScoreCar> getParticipants() {
        return participants;
    }
    public List<Race> getRaceList() {
        return raceList;
    }
    public int getId() {
        return id;
    }


    // ****************************************** SETTERS **************************************************************
    public void setName(String name) {
        this.name = name;
    }
    public void setNumRaces(int numRaces) {
        this.numRaces = numRaces;
    }
    public void setGarageList(List<Garage> garageList) {
        this.garageList = garageList;
    }
    public void setParticipants(List<ScoreCar> participants) {
        this.participants = participants;
    }
    public void setRaceList(List<Race> raceList) {
        this.raceList = raceList;
    }
    public void setId(int id) {
        this.id = id;
    }


    // ****************************************** METHODS **************************************************************
    protected void createId(){
        tournamentId++;
        this.id = tournamentId;
    }

    public void addRace(Race race){
        raceList.add(race);
    }

    /*public void addParticipants(){
        int garageParticipants = getGarageNameList().size();
        if (garageParticipants == 1){
            Garage garageOne = getGarageNameList().get(0);
            List<ScoreCar> aux;
            aux = garageOne.getCarList();
            for (ScoreCar sc : aux) {
                sc.restartScoreCar();
                raceParticipants.add(sc);
            }
        } else if (garageParticipants > 1) {
            for (Garage g : getGarageNameList()) {
                if (!g.getCarList().isEmpty()){
                    ScoreCar aux = g.randomScoreCar();
                    aux.restartScoreCar();
                    raceParticipants.add(aux);
                }
            }
        }else {
            System.out.println("No hay garajes seleccionados. ");
        }
    }*/
    // ******************************************* MAIN ****************************************************************
}
