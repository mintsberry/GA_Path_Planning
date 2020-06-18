package GeneticAlgorithm;

import MapObjects.Depot;
import MapObjects.Vehicle;

import java.io.IOException;
import java.util.List;

/**
 * Main method for GeneticAlgorithm
 * GeneticAlgorithm contains one Population.
 * Population contains n Solutions. n = populationSize
 * Sends all necessary data about GA/population to Main
 */
public class GeneticAlgorithm {

    // Parameters
    private final int populationSize = 70; // 20-100 dependent on problem
    private final double crossOverRate = 0.8; // 80%-95%
    private final double mutationRate = 0.08; // 0.5%-1%.
    private final int tournamentSize = 3; // Number of members in tournament selection
    private final int numberOfChildren = populationSize/3; // Rate of children to produce each generation
    private final int numberOfParentsToSave = populationSize/20; // Number of parents to save in filtering
    private final int durationPenaltyRate = 20; // Penalty for over duration
    private final int timePenaltyRate = 20; // Penalty for over Time
    private final int loadPenaltyRate = 20; // Penalty for over load
    private final boolean elitism = true; // Elitism keeps the best parents from last generation
    private final int k = 3; // Number of splits in parents before doing crossOver

    private Population population;

    /**
     * Creates initial population
     * @param depots
     */
    public GeneticAlgorithm(List<Depot> depots) {
        population = new Population(depots,
                populationSize,
                crossOverRate,
                mutationRate,
                tournamentSize,
                numberOfChildren,
                numberOfParentsToSave,
                durationPenaltyRate,
                loadPenaltyRate,
                timePenaltyRate,
                elitism,
                k);
    }

    /**
     * Functionality loop
     * One loop = one generation
     * population.tick() loops through all solutions
     */
    public void tick() {
        population.tick();
    }


    public void render() {
        renderAlphaSolution();
    }


    private void renderAlphaSolution() {
        Individual alphaIndividual = getAlphaSolution();

        if (alphaIndividual != null) {
            for (Vehicle vehicle : alphaIndividual.getVehicles()) {

            }
        }
    }

    /**
     * Get best duration of Population
     */
    public double getAlphaDuration() {
        return population.getAlphaDuration();
    }

    public double getAlphaFitness() {
        return population.getAlphaFitness();
    }

    public boolean isAlphaValid() {
        return population.isAlphaValid();
    }

    public double getAverageFitness() { return population.getAverageFitness(); }

    /**
     * Get best Individual (Individual with best fitness) of Population
     */
    public Individual getAlphaSolution() {
        return population.getAlphaIndividual();
    }

    public int getGeneration() {
        return population.getGeneration();
    }

    public void saveAlphaSolutionToFile() throws IOException {
        getAlphaSolution().saveToFile();
    }

    public void saveAlphaRoutesToFile() throws IOException {
        getAlphaSolution().saveRoute();
    }

    public void calAns() {
        getAlphaSolution().getAns();
    }
}
