import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class Particle {
    double[] position;      // Represents triangle sides (each position contain threee values (sides))
    double[] velocity;      // Change in position in each iteration
    double fitness;
    double[] bestPosition;
    double bestFitness;

    Particle(double[] position, double[] velocity, double fitness) {
        this.position = position;           // Rrepresent the triangle sides
        this.velocity = velocity;
        this.fitness = fitness;
        this.bestPosition = position;       // Best solution particle has achieved
        this.bestFitness = fitness;         // Fitness of best solution
    }
}

public class PSO-GA_for_Triangle_Classification {

    static final int numberOfParticles = 10;
    static final int maxIterations = 20;
    static final double inertiaWeight = 0.5;        // Inertia weight
    static final double cognitiveComponent = 1.4;   // Cognitive coefficient
    static final double socialComponent = 1.4;      // Social coefficient
    static final double crossoverRate = 0.8;
    static final double mutationRate = 0.1;
    
    static final Random random = new Random();
    
    public static void main(String[] args) {
        hybridPSOGAAlgorithm();
    }

    static void hybridPSOGAAlgorithm() {
        Particle[] particles = new Particle[numberOfParticles];
        double[] globalBestPosition = new double[3];
        double globalBestFitness = Double.MIN_VALUE;
        
        // Initialize particles
        for (int i = 0; i < numberOfParticles; i++) {
            double[] position = {10 * random.nextDouble(), 10 * random.nextDouble(), 10 * random.nextDouble()};
            double[] velocity = {random.nextDouble(), random.nextDouble(), random.nextDouble()};
            double fitness = calculateFitness(position);
            particles[i] = new Particle(position, velocity, fitness);

            if (fitness > globalBestFitness) {
                globalBestPosition = position;
                globalBestFitness = fitness;
            }
        }

        //  PSO and GA Operations
        for (int iteration = 0; iteration < maxIterations; iteration++) {
            for (Particle particle : particles) {
                // Update velocity
                for (int i = 0; i < particle.velocity.length; i++) {
                    double r1 = random.nextDouble();
                    double r2 = random.nextDouble();
                    particle.velocity[i] = inertiaWeight * particle.velocity[i]
                            + cognitiveComponent * r1 * (particle.bestPosition[i] - particle.position[i])
                            + socialComponent * r2 * (globalBestPosition[i] - particle.position[i]);
                }

                // Update position
                for (int i = 0; i < particle.position.length; i++) {
                    particle.position[i] += particle.velocity[i];
                    // Ensure the new position is within bounds
                    particle.position[i] = Math.max(0, Math.min(particle.position[i], 10));
                }

                // Update fitness
                double fitness = calculateFitness(particle.position);
                particle.fitness = fitness;

                // Update personal best
                if (fitness > particle.bestFitness) {
                    particle.bestPosition = particle.position;
                    particle.bestFitness = fitness;
                }

                // Update global best
                if (fitness > globalBestFitness) {
                    globalBestPosition = particle.position;
                    globalBestFitness = fitness;
                }
            }

            // GA operations every 5 iterations
            if (iteration % 5 == 0) {
                Arrays.sort(particles, Comparator.comparingDouble(p -> -p.fitness)); // Sort by fitness
                for (int i = numberOfParticles / 2; i < numberOfParticles; i++) {
                    if (random.nextDouble() < crossoverRate) {
                        int partnerIndex = random.nextInt(numberOfParticles / 2);
                        particles[i].position = crossover(particles[i].position, particles[partnerIndex].position);
                    }
                    if (random.nextDouble() < mutationRate) {
                        mutate(particles[i].position);
                    }
                    particles[i].fitness = calculateFitness(particles[i].position);
                }
            }
        }

        // Print test cases
        System.out.println("Generated Test Cases:");
        for (Particle particle : particles) {
            System.out.println(Arrays.toString(particle.position) + " - " + classifyTriangle(particle.position) );
        }   
    }

    static boolean isValidTriangle(double[] sides) {
        Arrays.sort(sides);
        return sides[0] + sides[1] > sides[2];      // Increasing order
    }
        
    static String classifyTriangle(double[] sides) {
        if (!isValidTriangle(sides)) {
            return "Not a triangle";
        }
        long distinctSides = Arrays.stream(sides).distinct().count();
        return distinctSides == 1 ? "Equilateral" : distinctSides == 2 ? "Isosceles" : "Scalene";
    }
        
    
    
    
    
    static void mutate(double[] position) {
        int index = random.nextInt(3);
        position[index] = 1 + 9 * random.nextDouble(); // Ensure mutation results in a valid side length
    }
    
    static double[] crossover(double[] parent1, double[] parent2) {
        double[] offspring = new double[3];
        int point = 1 ; // 1 or 2
        System.arraycopy(parent1, 0, offspring, 0, point);
        System.arraycopy(parent2, point, offspring, point, 3 - point);
        return offspring;
    }
        
        
        
        
        
        
        
    static double calculateFitness(double[] position) {
        return isValidTriangle(position) ? 1.0 / (1.0 + variance(position)) : 0.0;
    }

    static double variance(double[] sides) {
        double mean = Arrays.stream(sides).average().orElse(0.0);
        return Arrays.stream(sides).map(side -> (side - mean) * (side - mean)).average().orElse(0.0);
    }
}
