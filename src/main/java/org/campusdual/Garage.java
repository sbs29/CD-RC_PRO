package org.campusdual;

import org.campusdual.util.Input;
import org.campusdual.util.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class Garage {

    // **************************************** VARIABLES **************************************************************
    private static int garageId = 0;
    protected int id = 0;
    private String garageName;
    protected final List<ScoreCar> carList = new LinkedList<>();


    // **************************************** CONSTRUCTOR ************************************************************
    public Garage(String garageName) {
        createGarageId();
        this.garageName = garageName;
    }

    public Garage(JSONObject garage){
        this.importGarage(garage);
    }

    public Garage(){}


    // ***************************************** TO STRING *************************************************************
    @Override
    public String toString() {
        return "Garage {" +
                "ID = " + id +
                ", Nombre = '" + garageName + '\'' +
                '}';
    }


    // ****************************************** GETTERS **************************************************************
    public static int getGarageId() {
        return garageId;
    }
    public int getId() {
        return id;
    }
    public String getGarageName() {
        return garageName;
    }
    public List<ScoreCar> getCarList() {
        return carList;
    }


    // ****************************************** SETTERS **************************************************************
    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    // ****************************************** METHODS **************************************************************
    //------------------------------------------------------------------------------------------------------------------
    // ****************************************** CREAR ID *************************************************************
    private void createGarageId(){
        garageId++;
        this.id = garageId;
    }
    // *********************************** AÑADIR COCHE A LA LISTA *****************************************************
    private void addScoreCar(ScoreCar sc){
        ((LinkedList)this.getCarList()).addFirst(sc);
    }

    // *********************************** COCHE AlLEATORIO A LISTA ****************************************************
    protected ScoreCar randomScoreCar(){
        int aux = Utils.getRandomNumberInRange(0,carList.size());
        return carList.get(aux);
    }

    public void showDetails(){
        System.out.println("Garage " + this.garageName);
        Utils.showFromList(this.carList,false);
    }

    public JSONObject exportGarage(){
        JSONObject garage = new JSONObject();
        garage.put("garageName", this.garageName);
        return garage;
    }

    public JSONObject exportGarageWithScoreCar(){
        JSONObject garage = new JSONObject();
        garage.put("garageName", this.garageName);
        JSONArray ScoreCarArray = new JSONArray();
        for (ScoreCar sc : this.carList) {
            ScoreCarArray.add(sc.exportScoreCar());
        }
        garage.put("carList",ScoreCarArray);
        return garage;
    }

    public void importGarage(JSONObject parse){
        String garageName = parse.get("garageName").toString();
        this.setGarageName(garageName);
        JSONArray cars = (JSONArray) parse.get("carList");
        for (int i = 0; i < cars.size(); i++) {
            JSONObject car = (JSONObject) cars.get(i);
            this.addScoreCar(ScoreCar.importScoreCar(car));
        }
    }


    // ******************************************* MAIN ****************************************************************
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        Garage g = null;
        try {
            JSONObject garages = (JSONObject) parser.parse(new FileReader("Garages.json"));
            g.importGarage(garages);
        }catch (Exception e){
            e.printStackTrace();
        }

        /*Garage g = new Garage("Garaje Martinez");
        ScoreCar sc01 = new ScoreCar("Seat","Ibiza");
        sc01.setGarageName(g.getGarageName());
        garageMartinez.addScoreCar(sc01);
        ScoreCar sc02 = new ScoreCar("Seat","Leon");
        sc02.setGarageName(g.getGarageName());
        garageMartinez.addScoreCar(sc02);
        System.out.println(g.toString());
        Utils.showFromList(g.getCarList(),false);*/

        g.showDetails();
        JSONObject exportedGarage = g.exportGarageWithScoreCar();
        try(FileWriter fw = new FileWriter("Garages.json")){
            fw.write(exportedGarage.toJSONString());
            fw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
