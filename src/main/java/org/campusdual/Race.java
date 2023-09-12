package org.campusdual;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Race {

    // ***************************************** VARIABLES *************************************************************
    private static int raceId = 0;
    protected int id = 0;
    protected String raceName;
    protected List<Garage> garageNameList = new ArrayList<>();
    protected List<ScoreCar> raceParticipants = new LinkedList<>();
    protected List<ScoreCar> podium = new LinkedList<>();

    // **************************************** CONSTRUCTOR ************************************************************
    public Race(String raceName){
        this.raceName=raceName;
        createRaceId();
    }

    // ****************************************** GETTERS **************************************************************
    public int getId() {
        return id;
    }
    public String getRaceName() {
        return raceName;
    }
    public List<Garage> getGarageNameList() {
        return garageNameList;
    }
    public List<ScoreCar> getRaceParticipants() {
        return raceParticipants;
    }
    public List<ScoreCar> getPodium() {
        return podium;
    }


    // ****************************************** SETTERS **************************************************************
    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }
    public void setGarageNameList(List<Garage> garageNameList) {
        this.garageNameList = garageNameList;
    }


    // ****************************************** METHODS **************************************************************
    //------------------------------------------------------------------------------------------------------------------
    // ****************************************** CREAR ID *************************************************************
    protected void createRaceId(){
        Race.raceId++;
        this.id = Race.raceId;
    }
    // ************************************* AÑADIR GARAJE A LA CARRERA ************************************************
    protected void addGarageToRace(Garage g){
        if (!g.getCarList().isEmpty()) {
            this.getGarageNameList().add(g);
        }
    }
    // ********************************* AÑADIR PARTICIPANTES A LA CARRERA *********************************************
    protected void addRaceParticipants(){
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
    }
    protected void setPodium(ScoreCar third, ScoreCar second, ScoreCar first){
        this.podium.add(third);
        this.podium.add(second);
        this.podium.add(first);
    }

    protected void showPodium(){
        int position = 3;
        System.out.println("**************** Podio " + getRaceName() + "**************");
        for (ScoreCar sc : getPodium()) {
            System.out.println(position + ". " + sc.getId() + " " + sc.getBrand() + " " + sc.getModel() + " del garaje: " + sc.getGarageName()
            + " valocidad alcanzada: " + sc.getSpeedometer() + " km/h y recorrio " +sc.getDistance());
            position--;
        }
        System.out.println("********************************************************");
    }

    public abstract void start();

}
