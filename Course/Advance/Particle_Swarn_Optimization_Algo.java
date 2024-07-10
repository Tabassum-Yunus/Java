class Particle {
    double position;
    double velocity;
    double bestPosition;
    Particle(double position, double velocity) {
        this.position = position;
        this.velocity = velocity;
        this.bestPosition = position;
    }
}
public class Particle_Swarn_Optimization_Algo {
    private double globalBestPosition;
    private final int numberOfParticles, maxIterations;
    private final double inertiaWeight, cognitiveCoff, socialCoff;

    Particle_Swarn_Optimization_Algo(int numberOfParticles, int maxIterations, double inertiaWeight, double cognitiveCoff, double socialCoff) {
        this.numberOfParticles = numberOfParticles;
        this.maxIterations = maxIterations;
        this.inertiaWeight = inertiaWeight;     // Inertia weight
        this.cognitiveCoff = cognitiveCoff;     // Cognitive coefficient
        this.socialCoff = socialCoff;           // Social coefficient
    }
    public void psoAlgorithm() {
        Particle[] particles = new Particle[numberOfParticles];
        globalBestPosition = 12345;       
        for (int i = 0; i < numberOfParticles; i++) {       // Initialize particles
            double position = Math.random() * 20;           // Initialize position randomly between 0 and 10
            double velocity = Math.random();                // Random velocity between [0,1)
            particles[i] = new Particle(position, velocity);
        }
        for (int i = 0; i < maxIterations; i++) {
            for (Particle particle : particles) {
                updateVelocity(particle);
                updatePosition(particle);
                updatePersonalBest(particle);
                updateGlobalBest(particle);
            }
        }
        System.out.println("Optimized Solution: " + globalBestPosition);
        System.out.println("Fitness Value: " + fitnessFunction(globalBestPosition));
    }
    private void updateVelocity(Particle particle) {
        double r1 = Math.random(), r2 = Math.random();
        particle.velocity = inertiaWeight * particle.velocity
                + cognitiveCoff * r1 * (particle.bestPosition - particle.position)
                + socialCoff * r2 * (globalBestPosition - particle.position);
    }
    private void updatePosition(Particle particle) {
        particle.position += particle.velocity;
    }
    private void updatePersonalBest(Particle particle) {
        if (fitnessFunction(particle.position) < fitnessFunction(particle.bestPosition)) 
            particle.bestPosition = particle.position;
    }
    private void updateGlobalBest(Particle particle) {
        if (fitnessFunction(particle.position) < fitnessFunction(globalBestPosition)) 
            globalBestPosition = particle.position;
    }
    private double fitnessFunction(double position) {               //finding the minimum of f(x) = x^2
        return position * position;
    }
    public static void main(String[] args) {
        int numberOfParticles = 10, maxIterations = 5;
        double inertiaWeight = 0.5, cognitiveCoff = 2.0, socialCoff = 2.0;
        Particle_Swarn_Optimization_Algo pso = new Particle_Swarn_Optimization_Algo(numberOfParticles, maxIterations, inertiaWeight, cognitiveCoff, socialCoff);
        pso.psoAlgorithm();
    }
}



//class Particle {
//        double position;
//        double velocity;
//        double bestPosition;
//
//        Particle(double position, double velocity) {
//            this.position = position;
//            this.velocity = velocity;
//            this.bestPosition = position;
//        }
//    }
//
//public class Particle_Swarn_Optimization_Algo {
//
//    private double globalBestPosition;
//    private final int numberOfParticles;
//    private final int maxIterations;
//    private final double inertiaWeight;
//    private final double cognitiveCoff;
//    private final double socialCoff;
//
//    Particle_Swarn_Optimization_Algo(int numberOfParticles, int maxIterations, double inertiaWeight, double cognitiveCoff, double socialCoff) {
//        this.numberOfParticles = numberOfParticles;
//        this.maxIterations = maxIterations;
//        this.inertiaWeight = inertiaWeight;     // Inertia weight
//        this.cognitiveCoff = cognitiveCoff;     // Cognitive coefficient
//        this.socialCoff = socialCoff;           // Social coefficient
//    }
//
//    public void psoAlgorithm() {
//        Particle[] particles = new Particle[numberOfParticles];
//        globalBestPosition = 12345;
//        System.out.println("gBest: "+globalBestPosition);
//
//        // Initialize particles
//        System.out.println("Initialize Particles");
//        for (int i = 0; i < numberOfParticles; i++) {
//            double position = Math.random() * 10;       // Initialize position randomly between 0 and 10
//            double velocity = Math.random();            // Random velocity between 0 and 1
//            particles[i] = new Particle(position, velocity);
//            System.out.println("Particle["+i+"]: "+ particles[i].position+"  ,  "+ particles[i].velocity+"  ,  "+particles[i].bestPosition);
//            updatePersonalBest(particles[i]);
//        }
//
//        for (int i = 0; i < maxIterations; i++) {
//            System.out.println("\n"+i+" iteration");
//            for (Particle particle : particles) {
//                updateVelocity(particle);
//                updatePosition(particle);
//                updatePersonalBest(particle);
//                updateGlobalBest(particle);
//            }
//        }
//
//        System.out.println("Optimized Solution: " + globalBestPosition);
//        System.out.println("Fitness Value: " + fitnessFunction(globalBestPosition));
//    }
//
//    private void updateVelocity(Particle particle) {
//        double r1 = Math.random();
//        double r2 = Math.random();
//        System.out.println("\nr1 & r2: "+r1+" , "+r2);
//        particle.velocity = inertiaWeight * particle.velocity 
//                + cognitiveCoff * r1 * (particle.bestPosition - particle.position) 
//                + socialCoff * r2 * (globalBestPosition - particle.position);
//        System.out.println("Updated Velocity: "+ particle.velocity);
//    }
//
//    private void updatePosition(Particle particle) {
//        particle.position += particle.velocity;
//        System.out.println("Updated position: "+ particle.position);
//    }
//
//    private void updatePersonalBest(Particle particle) {
//        if (fitnessFunction(particle.position) < fitnessFunction(particle.bestPosition)) {
//            particle.bestPosition = particle.position;
//        System.out.println("Updated PersonalBestPosition: "+ particle.bestPosition);
//        }
//    }
//
//    private void updateGlobalBest(Particle particle) {
//        if (fitnessFunction(particle.position) < fitnessFunction(globalBestPosition)) {
//            globalBestPosition = particle.position;
//        System.out.println("Updated globalBestPosition: "+ globalBestPosition);
//        }
//    }
//
//    private double fitnessFunction(double position) {
//        return position * position;                 // finding the minimum of f(x) = x^2
//    }
//
//    public static void main(String[] args) {
//        int numberOfParticles = 10;
//        int maxIterations = 5;
//        double inertiaWeight = 0.5; 
//        double cognitiveCoff = 2.0; 
//        double socialCoff = 2.0; 
//
//        Particle_Swarn_Optimization_Algo pso = new Particle_Swarn_Optimization_Algo(numberOfParticles, maxIterations, inertiaWeight, cognitiveCoff, socialCoff);
//        pso.psoAlgorithm();
//    }
//}