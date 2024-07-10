import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrimeNo_using_Genetic_Algo {

    static final int POPULATION_SIZE = 10;      // Number of individuals in each generation 
    static final int CHROMOSOME_LENGTH = 10;    // Number of genes a chromosome can have
    static final double MUTATION_RATE = 0.1;    // how frequently mutation occurs in individual
    static final int TARGET = 97;               // target prime number.
    static final int MAX_GENERATIONS = 5;       

    static Random random = new Random();
    
    public static void main(String[] args) {
        geneticAlgorithm();
        
    }

    public static void geneticAlgorithm() {
        List<String> population = initializePopulation();

        int generation = 0;
        while (generation < MAX_GENERATIONS) 
        {
            List<String> newPopulation = new ArrayList<>();

            for (int i = 0; i < POPULATION_SIZE; i += 2) {

//                String parent1 = select(population);         // Selection using Roulette wheel
//                String parent2 = select(population);

                String parent1 = tournamentSelection(population,5);         // Selection using Tournament
                String parent2 = tournamentSelection(population, 5);
                
                List<String> children = crossover(parent1, parent2);    // Crossover
                newPopulation.add(children.get(0));
                newPopulation.add(children.get(1));
            }

            for (int i = 0; i < POPULATION_SIZE; i++) {       // Mutation
                newPopulation.set(i, mutate(newPopulation.get(i)));
            }

            population = newPopulation;
            generation++;
            //System.out.println("gene: "+generation);

            for (String individual : population) {
                int number = binaryToDecimal(individual);           
                if (isPrime(number)) {                                          // Check for a prime number in the population
                    System.out.println("Prime number found: " + number + " in generation " + generation);
                    return;
                }
            }
        }
        System.out.println("No prime number found within the generation limit.");
    }

    private static List<String> initializePopulation() {
        List<String> population = new ArrayList<>();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            population.add(generateRandomChromosome());
        }
        return population;
    }

    private static String generateRandomChromosome() {
        StringBuilder chromosome = new StringBuilder();
        for (int i = 0; i < CHROMOSOME_LENGTH; i++) {
            chromosome.append(random.nextBoolean() ? "1" : "0");
        }
        return chromosome.toString();
    }

    
//    private static String select(List<String> population) {         // Roulette wheel selection based on fitness
//        
//        double totalFitness = population.stream().mapToDouble(W10Q2_GA::calculateFitness).sum(); 
//        double rouletteWheelPosition = random.nextDouble() * totalFitness;
//        double position = 0;
//        for (String individual : population) {
//            position += calculateFitness(individual);
//            if (position >= rouletteWheelPosition) return individual;
//        }
//        return population.get(0); 
//    }

        
        public static String tournamentSelection(List<String> population, int tournamentSize) {
            
        // Create a tournament pool and randomly select chromosomes based on their fitness
        List<String> tournament = new ArrayList<>(tournamentSize);
        for (int i = 0; i < tournamentSize; i++) {
            int randomIndex = random.nextInt(population.size());
            tournament.add(population.get(randomIndex));
        }

        String fittest = tournament.get(0);        // Find the fittest chromosome in the tournament
        for (String individual : tournament) {
            if (calculateFitness(individual) > calculateFitness(fittest)) {
                fittest = individual;
            }
        }
        return fittest;
    }
        
        
    private static double calculateFitness(String chromosome) {
        int number = binaryToDecimal(chromosome);
        if (number <= 1) return 0;                      // Exclude non-positive numbers
        if (isPrime(number)) return Double.MAX_VALUE;   // Maximum fitness for primes
        return 1.0 / (TARGET - number);                 // My Custom fitness for non primes
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    private static List<String> crossover(String parent1, String parent2) {
        int crossoverPoint = random.nextInt(CHROMOSOME_LENGTH);                     // One-point crossover
        String child1 = parent1.substring(0, crossoverPoint) + parent2.substring(crossoverPoint);
        String child2 = parent2.substring(0, crossoverPoint) + parent1.substring(crossoverPoint);
        List<String> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        System.out.println(children);
        return children;
    }

    private static String mutate(String chromosome) {
        StringBuilder mutatedChromosome = new StringBuilder(chromosome);
        for (int i = 0; i < CHROMOSOME_LENGTH; i++) {
            if (random.nextDouble() < MUTATION_RATE) {
                mutatedChromosome.setCharAt(i, mutatedChromosome.charAt(i) == '0' ? '1' : '0');
            }
        }
        return mutatedChromosome.toString();
    }
}





