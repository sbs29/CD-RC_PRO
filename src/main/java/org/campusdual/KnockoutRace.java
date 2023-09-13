package org.campusdual;

public class KnockoutRace extends Race{

    // ***************************************** VARIABLES *************************************************************
    private int previousTime = 0;

    // **************************************** CONSTRUCTOR ************************************************************
    protected KnockoutRace(String raceName, int previousTime){
        super(raceName);
        this.previousTime = previousTime;
    }

    // ***************************************** TO STRING *************************************************************


    @Override
    public String toString() {
        return "KnockoutRace{" +
                "previousTime=" + previousTime +
                ", id=" + id +
                ", raceName='" + raceName + '\'' +
                ", garageNameList=" + garageNameList +
                ", raceParticipants=" + raceParticipants +
                ", podium=" + podium +
                '}';
    }

    // ****************************************** GETTERS **************************************************************
    public int getPreviousTime() {
        return previousTime;
    }


    // ****************************************** SETTERS **************************************************************
    public void setPreviousTime(int previousTime) {
        this.previousTime = previousTime;
    }


    public ScoreCar slowerScoreCar(){
        ScoreCar toRec = null;
        double route = Integer.MAX_VALUE;

        for (ScoreCar sc : raceParticipants) {
            if(sc.getDistance() < route){
                route = sc.getDistance();
                toRec = sc;
            }
        }
        raceParticipants.remove(toRec);
        return toRec;
    }

    @Override
    public void start() {
        ScoreCar third = null;
        ScoreCar second = null;
        ScoreCar first;
        ScoreCar actualCar;

        addRaceParticipants();

        for (int i = 0; i < previousTime; i++) {
            for (ScoreCar sc : raceParticipants) {
                sc.speedometerByCicle();
            }
        }

        do {
            for (ScoreCar sc : raceParticipants) {
                sc.speedometerByCicle();
            }

            actualCar = slowerScoreCar();

            if (raceParticipants.size()==3){
                third = actualCar;
            }else if (raceParticipants.size()==2){
                second = actualCar;
            }
            raceParticipants.remove(actualCar);
        }while (raceParticipants.size()>1);

        first = raceParticipants.get(0);
        setPodium(third,second,first);
        showPodium();
    }
}
