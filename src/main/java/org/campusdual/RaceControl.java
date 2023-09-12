package org.campusdual;

import org.campusdual.util.Input;
import org.campusdual.util.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class RaceControl {

    private final List<ScoreCar> raceControlScoreCar = new ArrayList<>();
    private final List<Garage> raceControlGarage = new ArrayList<>();
    private final List<Race> raceControlRace = new ArrayList<>();
    private final List<Tournament> raceControlTournament = new ArrayList<>();

    public static void main(String[] args) {
        RaceControl rc = new RaceControl();
        rc.dataRaceControl();
        rc.init();
    }

    public void dataRaceControl(){
        Garage garageJS = new Garage("Garaje JS");
        Garage garageSS = new Garage("Garaje SS");
        Garage garageSB = new Garage("Garaje SB");
        Garage garageYG = new Garage("Garaje YG");
        ScoreCar seatLeon = new ScoreCar("Seat","Leon");
        seatLeon.setGarageName(garageJS.getGarageName());
        ScoreCar seatIbiza = new ScoreCar("Seat","Ibiza");
        seatIbiza.setGarageName(garageSB.getGarageName());
        ScoreCar citroenXsara = new ScoreCar("Citroen","Xsara");
        citroenXsara.setGarageName(garageJS.getGarageName());
        ScoreCar citroenAmi = new ScoreCar("Citroen","Ami");
        citroenAmi.setGarageName(garageSS.getGarageName());
        ScoreCar citroenC4Cactus = new ScoreCar("Citroen","Cactus");
        citroenC4Cactus.setGarageName(garageYG.getGarageName());
        ScoreCar citroenC4Picasso = new ScoreCar("Citroen","Picasso");
        citroenC4Picasso.setGarageName(garageSB.getGarageName());
        ScoreCar bmwSerie3 = new ScoreCar("BMW","Serie3");
        bmwSerie3.setGarageName(garageJS.getGarageName());
        ScoreCar bmwSerie4Cabrio = new ScoreCar("BMW","Cabrio");
        bmwSerie4Cabrio.setGarageName(garageYG.getGarageName());
        ScoreCar audiTTRoadster = new ScoreCar("Audi","TT Roadster");
        audiTTRoadster.setGarageName(garageSS.getGarageName());
        ScoreCar audiA6 = new ScoreCar("Audi","A6");
        audiA6.setGarageName(garageYG.getGarageName());
        ScoreCar mercedesClaseA = new ScoreCar("Mercedes","Clase A");
        mercedesClaseA.setGarageName(garageYG.getGarageName());
        ScoreCar mercedesClaseB = new ScoreCar("Mercedes","Clase B");
        mercedesClaseB.setGarageName(garageJS.getGarageName());
        ScoreCar mercedesClaseC = new ScoreCar("Mercedes","Clase C");
        mercedesClaseC.setGarageName(garageSS.getGarageName());
        ScoreCar jeepAvenger = new ScoreCar("Jeep","Avenger");
        jeepAvenger.setGarageName(garageSB.getGarageName());
        ScoreCar jeepCherokee = new ScoreCar("Jeep","Cherokee");
        jeepCherokee.setGarageName(garageYG.getGarageName());
        ScoreCar jeepGladiator = new ScoreCar("Jeep","Gladiator");
        jeepGladiator.setGarageName(garageSS.getGarageName());
        this.raceControlGarage.add(garageJS);
        this.raceControlGarage.add(garageSS);
        this.raceControlGarage.add(garageSB);
        this.raceControlGarage.add(garageYG);
        this.raceControlScoreCar.add(seatLeon);
        this.raceControlScoreCar.add(seatIbiza);
        this.raceControlScoreCar.add(citroenXsara);
        this.raceControlScoreCar.add(citroenAmi);
        this.raceControlScoreCar.add(citroenC4Cactus);
        this.raceControlScoreCar.add(citroenC4Picasso);
        this.raceControlScoreCar.add(bmwSerie3);
        this.raceControlScoreCar.add(bmwSerie4Cabrio);
        this.raceControlScoreCar.add(audiTTRoadster);
        this.raceControlScoreCar.add(audiA6);
        this.raceControlScoreCar.add(mercedesClaseA);
        this.raceControlScoreCar.add(mercedesClaseB);
        this.raceControlScoreCar.add(mercedesClaseC);
        this.raceControlScoreCar.add(jeepAvenger);
        this.raceControlScoreCar.add(jeepCherokee);
        this.raceControlScoreCar.add(jeepGladiator);
    }

    public void init() {
        int opt;
        do {
            System.out.println("\n====================");
            System.out.println("=== Race Control ===");
            System.out.println("====================");
            System.out.println("1. Gestión *GARAJE*");
            System.out.println("1. Gestión *CARRERA*");
            System.out.println("3. Gestión *TORNEO*");
            System.out.println("0. Salir");
            opt = Input.integer("\nIntroduce la opción deseada: ");
            switch (opt) {
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                case 1:
                    optionsGarage();
                    break;
                case 2:
                    optionRace();
                    break;
                case 3:
                    optionTournament();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opt != 0);
    }

    public void optionsGarage() {
        int opt;
        do {
            System.out.println("\n======================");
            System.out.println("=== Gestion Garaje ===");
            System.out.println("======================");
            System.out.println("1. Añadir coche nuevo.");
            System.out.println("2. Añadir garaje nuevo.");
            System.out.println("3. Asignar coche a garaje.");
            System.out.println("4. Mostrar garajes registrados.");
            System.out.println("5. Mostrar coches registrados");
            System.out.println("6. Mostrar garajes con sus coches");
            System.out.println("0. Atrás.");
            opt = Input.integer("\nIntroduce la opción deseada: ");
            switch (opt) {
                case 0:
                    System.out.println("Atrás.");
                    break;
                case 1:
                    addScoreCar();
                    break;
                case 2:
                    addGarage();
                    break;
                case 3:
                    addScoreCarToGarage();
                    break;
                case 4:
                    showGarage();
                    break;
                case 5:
                    showScoreCar();
                    break;
                case 6:
                    showAllGarageWithTheirScoreCars();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opt != 0);
    }

    public void optionRace() {
        int opt;
        do {
            System.out.println("\n=======================");
            System.out.println("=== Gestion Carrera ===");
            System.out.println("=======================");
            System.out.println("1. Crear Carrera Knockout");
            System.out.println("2. Crear Carrera Standard");
            System.out.println("3. Historico de Carreras");
            System.out.println("4. Podio por Carrera");
            System.out.println("0. Atrás.");
            opt = Input.integer("\nIntroduce la opción deseada: ");
            switch (opt) {
                case 0:
                    System.out.println("Atrás.");
                    break;
                case 1:
                    createRaceKnockout();
                    break;
                case 2:
                    createRaceStandard();
                    break;
                case 3:
                    showRacingHistory();
                    break;
                case 4:
                    showPodium();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opt != 0);
    }

    public void optionTournament() {
        int opt;
        do {
            System.out.println("\n======================");
            System.out.println("=== Gestion Torneo ===");
            System.out.println("======================");
            System.out.println("1. Gestión *GARAJE*");
            System.out.println("1. Gestión *CARRERA*");
            System.out.println("2. Gestión *TORNEO*");
            System.out.println("0. Atrás.");
            opt = Input.integer("\nIntroduce la opción deseada: ");
            switch (opt) {
                case 0:
                    System.out.println("Atrás.");
                    break;
                case 1:
                    System.out.println("aasd");
                    break;
                case 2:
                    System.out.println("asdawd");
                    break;
                case 3:
                    System.out.println("asdaswd");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opt != 0);
    }

    private void addGarage(){
        String nameGarage = Input.string("Nombre del garaje: ");
        Garage garage = new Garage(nameGarage);
        this.raceControlGarage.add(garage);
    }

    private void addScoreCar(){
        String brand = Input.string("Marca del coche: ");
        String model = Input.string("Modelo del coche: ");
        ScoreCar sc = new ScoreCar(brand,model);
        this.raceControlScoreCar.add(sc);
    }

    /*private void addScoreCarToGarage(){
        Utils.showFromList(this.raceControlGarage,false);
        String nameGarage = Input.string("Nombre del garaje: ");
        for (int i = 0; i < this.raceControlGarage.size(); i++) {
            if (this.raceControlGarage.getGarageName().equals(nameGarage)){
                Utils.showFromList(this.raceControlScoreCar,false);
                int scId = Input.integer("Id del coche que quieres asiganar al garaje: "+nameGarage);
                for (int j = 0; j < this.raceControlScoreCar.size(); j++) {
                    if (this.raceControlScoreCar.get(j).id == scId){
                        this.raceControlGarage.get(i).getCarList().add(this.raceControlScoreCar.get(scId));
                    }else {
                        System.out.println("El id introducido no coincide con ningún coche");
                    }
                }
            }else {
                System.out.println("El nombre introducido no coincide con ningún garaje");
            }
        }
    }*/
    private void addScoreCarToGarage(){
        Utils.showFromList(this.raceControlGarage,false);
        int garageId = Input.integer("Escribe el ID del garage: ");
        Garage g = this.raceControlGarage.get(garageId-1);
        Utils.showFromList(this.raceControlScoreCar,false);
        int scId = Input.integer("Escribe el ID del coche: ");
        ScoreCar sc = this.raceControlScoreCar.get(scId-1);
        sc.setGarageName(g.getGarageName());
        g.getCarList().add(sc);
    }

    private void showGarage(){
        Utils.showFromList(this.raceControlGarage,false);
    }

    private void showScoreCar(){
        Utils.showFromList(this.raceControlScoreCar,false);
    }

    private void showAllGarageWithTheirScoreCars(){
        for (Garage g: this.raceControlGarage) {
            System.out.println(g.toString());
            for (ScoreCar sc: this.raceControlScoreCar) {
                if (sc.getGarageName().equals(g.getGarageName())){
                    System.out.println("\t" + sc.toString());
                }
            }
        }
    }

    // *********************************** EXPORTAR DATOS JSON *********************************************************
    /*public JSONArray exportCar(){
        JSONArray arrayScoreCar = new JSONArray();
        arrayScoreCar.addAll(this.raceControlScoreCar);
        return arrayScoreCar;
    }
    // ********************************** EXPORTAR JSON A FILE **********************************************************
    public static void exportJSONToFile(JSONArray objArray){
        try (FileWriter fw = new FileWriter("test.json")){
            for (int i = 0; i < objArray.size(); i++) {
                fw.write(objArray.get(i).toString());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //*********************************** IMPORTAR JSON DE FILE **********************************************************
    public static JSONObject importFromJSONFile(String fileName){
        try (FileReader fr = new FileReader(fileName)){
            JSONParser parser = new JSONParser();
            return (JSONObject)parser.parse(fr);
        } catch (Exception e){
            return null;
        }
    }
    // *********************************** IMPORTAR DATOS JSON *********************************************************
    public static void importCar(JSONArray arrayScoreCar){
        for (int i = 0; i < arrayScoreCar.size(); i++) {
            JSONObject obj = (JSONObject) arrayScoreCar.get(i);
            String model = (String) obj.get(ScoreCar.MODEL);
            String brand = (String) obj.get(ScoreCar.BRAND);
            String garageName = (String) obj.get(ScoreCar.GARAGE_NAME);
            ScoreCar sc = new ScoreCar(brand,model);
            sc.setGarageName(garageName);
        }
    }*/



    private void createRaceKnockout(){
        int opt;
        Race kRace = null;
        do {
            System.out.println("\n========================");
            System.out.println("=== Carrera Knockout ===");
            System.out.println("========================");
            System.out.println("1. Crear Carrera y Añadir Garajes");
            System.out.println("2. Sorteo Coches_X_Garaje");
            System.out.println("3. Iniciar Carrera");
            System.out.println("0. Atrás.");
            opt = Input.integer("\nIntroduce la opción deseada: ");
            switch (opt) {
                case 0:
                    System.out.println("Atrás.");
                    break;
                case 1:
                    kRace = null;
                    String nameRace = Input.string("Nombre de la carrera: ");
                    int previousTime = Input.integer("Tiempo previo para iniciar carrera: ");
                    kRace = new KnockoutRace(nameRace,previousTime);
                    int opti;
                    do {
                        System.out.println("1. Añadir Garage");
                        System.out.println("0. Atrás.");
                        opti = Input.integer("\nIntroduce la opción deseada: ");
                        switch (opti){
                            case 1:
                                showGarage();
                                String nameGarage = Input.string("Nombre del garaje a añadir: ");
                                for (Garage g : this.raceControlGarage) {
                                    if(g.getGarageName().equals(nameGarage)){
                                        kRace.addGarageToRace(g);
                                    }
                                }
                                break;
                            case 0:
                                System.out.println("Atrás.");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }while (opti != 0);

                    this.raceControlRace.add(kRace);
                    break;
                case 2:
                    kRace.addRaceParticipants();
                    break;
                case 3:
                    kRace.start();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opt != 0);
    }

    private void createRaceStandard(){
        int opt;
        Race sRace = null;
        do {
            System.out.println("\n========================");
            System.out.println("=== Carrera Standard ===");
            System.out.println("========================");
            System.out.println("1. Añadir Garage");
            System.out.println("2. Sorteo Coches_X_Garaje");
            System.out.println("3. Iniciar Carrera");
            System.out.println("0. Atrás.");
            opt = Input.integer("\nIntroduce la opción deseada: ");
            switch (opt) {
                case 0:
                    System.out.println("Atrás.");
                    break;
                case 1:
                    sRace = null;
                    String nameRace = Input.string("Nombre de la carrera: ");
                    int duration = Input.integer("Tiempo de duracion de la carrera (default 3 hours): ");
                    sRace = new StandardRace(nameRace,duration);
                    int opti;
                    do {
                        System.out.println("1. Añadir Garage");
                        System.out.println("0. Atrás.");
                        opti = Input.integer("\nIntroduce la opción deseada: ");
                        switch (opti){
                            case 1:
                                showGarage();
                                String nameGarage = Input.string("Nombre del garaje a añadir: ");
                                for (Garage g : this.raceControlGarage) {
                                    if(g.getGarageName().equals(nameGarage)){
                                        sRace.addGarageToRace(g);
                                    }
                                }
                                break;
                            case 0:
                                System.out.println("Atrás.");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }while (opti != 0);

                    this.raceControlRace.add(sRace);
                    break;
                case 2:
                    sRace.addRaceParticipants();
                    break;
                case 3:
                    sRace.start();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opt != 0);
    }

    private void showRacingHistory(){
        Utils.showFromList(this.raceControlRace,false);
    }

    private void showPodium(){
        for (Race r : this.raceControlRace) {
            r.showPodium();
        }
    }


}
