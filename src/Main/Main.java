package Main;

import GeneticAlgorithm.GeneticAlgorithm;
import Map.Map;
import MapObjects.Vehicle;
import Utils.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Map map;
    private static GeneticAlgorithm ga; // GeneticAlgorithm: Contains a Population, which contains Solutions
    private static HashMap<Integer, Double>   alphaSolutionFitnessData = new HashMap<>();
    private static HashMap<Integer, Double> populationFitnessData = new HashMap<>();;
    public static String fileName;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        /*方式1：读取file加载map*/
        System.out.println("Please Input MapFile Name:(p01~p23)");
        fileName = scan.next();//输入选择的map
        System.out.println("Please Input Stop Sriteria:(Steps with same fitness)");//出现2000次原值
        map = new Map(fileName); // Parse map file
        ga = new GeneticAlgorithm(map.getDepots());
        iteration();
    }

    private static void iteration(){
        int count = 0;

        double temp = 10000000000000.0;
        while (true) {
            tick();
            alphaSolutionFitnessData.put(ga.getGeneration(), ga.getAlphaFitness());
            populationFitnessData.put(ga.getGeneration(), ga.getAverageFitness());
            render();
            System.out.println(ga.getGeneration()+"--"+Utils.round(ga.getAlphaFitness(), 2));
            System.out.println(ga.isAlphaValid());
            if(Utils.round(ga.getAlphaFitness(), 2)<temp){
                temp =Utils.round(ga.getAlphaFitness(), 2);
                count=0;
            }else if(Utils.round(ga.getAlphaFitness(), 2)==temp){
                count++;
            }
            if(count>3000){
//                System.out.println("stop iterating");
//                try {
//                    ga.saveAlphaSolutionToFile();
//                    ga.saveAlphaRoutesToFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                ga.calAns();
                break;
            }
        }
        List<Vehicle> vehicles = ga.getAlphaSolution().getVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private static void tick() {
        ga.tick(); // Takes Population in GeneticAlgorithm to next generation
    }
    private static void render() {
        map.render(); // Renders depots and customers
        ga.render(); // Renders alphaSolution of Population in GeneticAlgorithm
    }
}
