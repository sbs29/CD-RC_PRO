package org.campusdual;

import org.campusdual.util.Input;
import org.campusdual.util.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class ScoreCar implements Comparable<ScoreCar>{

    // **************************************** CONSTANT **************************************************************
    public static final String BRAND = "brand";
    public static final String MODEL = "model";
    public static final String GARAGE_NAME = "garageName";
    public final static int MAX_VELOCITY = 200;
    private static int ScoreCarId = 0;


    // **************************************** VARIABLES **************************************************************
    protected int id = 0;
    private String brand;
    private String model;
    private String garageName = "";
    private int speedometer = 0;
    private double distance = 0.0;


    // **************************************** CONSTRUCTOR ************************************************************
    public ScoreCar(){
        this.brand = Input.string("Marca del coche: ");
        this.model = Input.string("Modelo del coche: ");
    }
    public ScoreCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
        createScoreCarId();
    }


    // **************************************** TO STRING **************************************************************
    @Override
    public String toString() {
        return "Coche {" +
                "Id = '" + id + '\'' +
                ", Marca = '" + brand + '\'' +
                ", Modelo = '" + model + '\'' +
                ", Garaje asociado = '" + garageName + '\'' +
                '}';
    }


    // **************************************** GETTERS ****************************************************************
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public String getGarageName() {
        return garageName;
    }
    public int getSpeedometer() {
        return speedometer;
    }
    public double getDistance() {
        return distance;
    }
    public int getId() {
        return id;
    }

    // **************************************** SETTERS ****************************************************************
    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }
    public void setSpeedometer(int speedometer) {
        this.speedometer = speedometer;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }


    // *************************************** METHODS *****************************************************************
    //------------------------------------------------------------------------------------------------------------------
    // ***************************************** CREAR ID *************************************************************
    protected void createScoreCarId(){
        ScoreCarId++;
        this.id = ScoreCarId;
    }
    // *************************************** ACELERAR ****************************************************************
    protected void speedUp(){
        if(this.speedometer<ScoreCar.MAX_VELOCITY){
            speedometer+=10;
        }
    }
    // *************************************** FRENAR ******************************************************************
    protected void slowDown(){
        if(this.speedometer>0){
            speedometer-=10;
        }
    }
    // ****************************** ACELERA/FRENA RANDOM *************************************************************
    protected void speedometerByCicle(){
        int isAccelerating = Utils.getRandomNumberInRange(1,3);

        if (isAccelerating != 2){
            speedUp();
        } else {
            slowDown();
        }
        updateDistance();
    }
    // *************************************** FRENAR ******************************************************************
    protected void updateDistance(){
        distance += speedometer * 16.667;
    }
    // ********************************* COMPARAR DISTANCIAS ***********************************************************
    @Override
    public int compareTo(ScoreCar o) {
        if(this.getDistance() > o.getDistance()){
            return 1;
        } else if (this.getDistance() < o.getDistance()) {
            return -1;
        }else {
            return 0;
        }
    }
    // ********************************* REINICIAR PARAMETROS ***********************************************************
    public void restartScoreCar(){
        speedometer=0;
        distance=0.0;
    }

    public JSONObject exportScoreCar(){
        JSONObject sc = new JSONObject();
        sc.put("brand", this.brand);
        sc.put("model", this.model);
        sc.put("garageName", this.garageName);
        return sc;
    }

    public static ScoreCar importScoreCar(JSONObject parse){
        String brand = parse.get("brand").toString();
        String model = parse.get("model").toString();
        String garageName = parse.get("garageName").toString();
        ScoreCar sc = new ScoreCar(brand,model);
        sc.setGarageName(garageName);
        return sc;
    }



    // ****************************************** MAIN *****************************************************************
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        ScoreCar mySc = null;
        try{
            JSONObject parse = (JSONObject) parser.parse(new FileReader("ScoreCars.json"));
            mySc = importScoreCar(parse);
        }catch(Exception e){
            e.printStackTrace();
        }

        for (int i = 0; i < 12; i++) {
            mySc.speedometerByCicle();
        }


        ScoreCar sc01 = new ScoreCar("Seat","Ibiza");
        System.out.println(sc01);

        /*ScoreCar sc02 = new ScoreCar("Seat","Leon");
        System.out.println(sc02);

        for (int i = 0; i <120 ; i++){
            sc01.speedometerByCicle();
            sc02.speedometerByCicle();
        }

        System.out.println("Velocidad final tras 12 min: " + sc01.getSpeedometer() + " distancia " + Utils.formatLocalNumber(sc01.getDistance()));
        System.out.println("Velocidad final tras 12 min: " + sc02.getSpeedometer() + " distancia " + Utils.formatLocalNumber(sc02.getDistance()));

        System.out.println(sc01.compareTo(sc02));*/

        JSONObject exportedScoreCar = sc01.exportScoreCar();
        try(FileWriter fw = new FileWriter("ScoreCars.json")){
            fw.write(exportedScoreCar.toJSONString());
            fw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
