package org.campusdual;

import java.util.List;

public class StandardRace extends Race{

    // **************************************** CONSTANT **************************************************************
    public final static int MAX_DURATION = 180;

    // ***************************************** VARIABLES *************************************************************
    private int duration = 0;

    // **************************************** CONSTRUCTOR ************************************************************
    public StandardRace(String raceName, int duration){
        super(raceName);
        this.duration = duration;
    }

    public StandardRace(String raceName){
        super(raceName);
        this.duration = MAX_DURATION;
    }

    // ***************************************** TO STRING *************************************************************


    @Override
    public String toString() {
        return "StandardRace{" +
                "duration=" + duration +
                ", id=" + id +
                ", raceName='" + raceName + '\'' +
                ", garageNameList=" + garageNameList +
                ", raceParticipants=" + raceParticipants +
                ", podium=" + podium +
                '}';
    }

    // ****************************************** GETTERS **************************************************************
    public int getPreviousTime() {
        return duration;
    }

    // ****************************************** SETTERS **************************************************************
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void givePodium(){
        List<ScoreCar> historico;
        ScoreCar third;
        ScoreCar second;
        ScoreCar first;

        historico = raceParticipants;

        first = fastestScoreCar();
        second = fastestScoreCar();
        third = fastestScoreCar();

        raceParticipants = historico;
        showPodium();
    }

    public ScoreCar fastestScoreCar(){
        ScoreCar toRec = null;
        double route = Integer.MIN_VALUE;

        for (ScoreCar sc : raceParticipants) {
            if(sc.getDistance() > route){
                route = sc.getDistance();
                toRec = sc;
            }
        }
        raceParticipants.remove(toRec);
        return toRec;
    }

    public void start(){
        ScoreCar third = null;
        ScoreCar second = null;
        ScoreCar first;

        addRaceParticipants();

        for (ScoreCar sc : raceParticipants) {
            sc.restartScoreCar();
        }

        for (int i = 0; i < duration; i++) {
            for (ScoreCar sc : raceParticipants) {
                sc.speedometerByCicle();
            }
        }
        givePodium();
    }
}
