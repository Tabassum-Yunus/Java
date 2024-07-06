
//public class Memory_Handling {
//    public static void main(String[] args) {
//        Runtime runtime = Runtime.getRuntime();
//        System.out.println("Maximum memory can be used by JVM: "+runtime.maxMemory());
//        System.out.println("Total Memory currently in available to JVM: "+ runtime.totalMemory());
//                                                                    //current size of the heap (include both free and used m/m)
//        System.out.println("Amount of free memory in JVM: "+ runtime.freeMemory());
//            long usedMemory = runtime.totalMemory()-runtime.freeMemory();   
//        System.out.println("Memory currently used by JVM(out of the total memory): "+ usedMemory);  //portion of total m/m
//            long availableMemory = runtime.totalMemory()-runtime.freeMemory();
//        System.out.println("Available memory for the creation of new objects: "+availableMemory);
//
//
//    }
//}



public class Memory_Handling {

    private static final long MEMORY_THRESHOLD = 110 * 1024 * 1024; // 110 MB

    public static void main(String[] args) {
        try {
            InfiniteObjectCreation();
        } catch (Throwable e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void InfiniteObjectCreation() {
        Runtime currentRuntime = Runtime.getRuntime();

        while (true) 
        {
            long memoryAvailable = currentRuntime.freeMemory();
            System.out.println("Available memory: "+memoryAvailable/(1024*1024)+ " MB");
            if (memoryAvailable < MEMORY_THRESHOLD) {
                System.out.println("Memory is low, stopping the allocation to prevent OutOfMemoryError.");
                break;
            }
            try {
                Integer[] arr = new Integer[1024*1024]; 
                System.out.println("Assigned memory: "+ ((arr.length*4.0)/(1024*1024))+" MB");
                System.out.println("Memory left: " +(memoryAvailable-(arr.length*4))/(1024*1024)+ " MB\n");
            } catch (OutOfMemoryError e) {
                System.err.println("Caught OutOfMemoryError, stopping operation: " + e.getMessage());
            }
        }
    }
}


