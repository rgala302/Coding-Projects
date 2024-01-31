import java.util.Scanner;

/**

   This program is meant to allow the user to input their computer specifications and choose a resolution, and recieve a recommended recommended graphics quality and performance score.
   
   
   ***
   Currently Not Working
      Must Finish
   ***
   

*/

public class HardwareLastname {
    private double gpuClockSpeed;
    private double cpuClockSpeed;
    private int numCpuCores;
    private int monitorResolution;

    public HardwareLastname() {
        gpuClockSpeed = 0.0;
        cpuClockSpeed = 0.0;
        numCpuCores = 0;
        monitorResolution = 0;
    }

    public HardwareLastname(double gpuClockSpeed, double cpuClockSpeed, int numCpuCores, int monitorResolution) {
        this.gpuClockSpeed = gpuClockSpeed;
        this.cpuClockSpeed = cpuClockSpeed;
        this.numCpuCores = numCpuCores;
        this.monitorResolution = monitorResolution;
    }

    public void setGpuClockSpeed(double gpuClockSpeed) {
        this.gpuClockSpeed = gpuClockSpeed;
    }

    public void setCpuClockSpeed(double cpuClockSpeed) {
        this.cpuClockSpeed = cpuClockSpeed;
    }

    public void setNumCpuCores(int numCpuCores) {
        this.numCpuCores = numCpuCores;
    }

    public void setMonitorResolution(int monitorResolution) {
        this.monitorResolution = monitorResolution;
    }

    public String getResolutionString(int userRes) {
        String systemRes = "";
        switch(userRes) {
            case 1:
                systemRes = "1280 x 720";
                break;
            case 2:
                systemRes = "1920 x 1080";
                break;
            case 3:
                systemRes = "2560 x 1440";
                break;
            case 4:
                systemRes = "3840 x 2160";
                break;
            default:
                System.out.println("Invalid input. Defaulting to 1920 x 1080");
                systemRes = "1920 x 1080";
                break;
        }
        return systemRes;
    }

    public double getMultiplierValue(int userRes) {
        double multiplierValue = 1.0;
        if(userRes == 1) {
            multiplierValue = 0.5;
        } else if(userRes == 2) {
            multiplierValue = 1.0;
        } else if(userRes == 3) {
            multiplierValue = 1.5;
        } else if(userRes == 4) {
            multiplierValue = 2.0;
        } else {
            System.out.println("Invalid resolution. Defaulting to 1920 x 1080");
        }
        return multiplierValue * gpuClockSpeed * cpuClockSpeed * numCpuCores;
    }

    public double calculatePerformanceScore(double gpuClockSpeed, double cpuClockSpeed, int numCpuCores, double scoreMultiplier) {
        double performanceScore = 0.0;
        if(monitorResolution == 0) {
            System.out.println("Invalid monitor resolution. Defaulting to 1920 x 1080");
            monitorResolution = 1080;
        }
        performanceScore = scoreMultiplier / monitorResolution;
        return performanceScore;
    }

    public String getRecommendedQuality(double performanceScore) {
        if (performanceScore >= 500) {
            return "High";
        } else if (performanceScore >= 250) {
            return "Medium";
        } else {
            return "Low";
        }
    }

    public void displayInformation() {
        System.out.println("GPU clock speed: " + gpuClockSpeed);
        System.out.println("CPU clock speed: " + cpuClockSpeed);
        System.out.println("Number of CPU cores: " + numCpuCores);
        System.out.println("Monitor resolution: " + monitorResolution);
        System.out.println("Recommended graphics quality: " + getRecommendedQuality());
    }
    
    
      /// MAIN \\\
    public static void main(String[] args)
     {
 
  double gpuMhz, cpuMhz, score;
  int cpuCores,userRes;
  int scoreMultiplier =1;
  String systemRes ="";                   //All variables used through out the program
    double minScore = Double.MAX_VALUE;
    double maxScore = Double.MIN_VALUE;
  Scanner keyboard = new Scanner(System.in);


                                    /// 'INTRO' \\\
  System.out.println("Please enter the number of computers:");
  int numOfComputers = keyboard.nextInt();
    displayTitle();

  if(numOfComputers < 0)                                             //Introduction to program.
  {
     System.out.println("Invalid input. Please enter a positive number:");
     numOfComputers = keyboard.nextInt();
  }

                            /// ASKING FOR SPECS OF PC(S) \\\
  for(int i = 1; i <= numOfComputers; i++)
  {
     System.out.println( "\nPlease enter the clock speed (in Megahertz) of your graphics card for computer " + i);
     gpuMhz = keyboard.nextDouble();
      if(gpuMhz < 800 || gpuMhz > 2000)
       {
        System.out.println("Invalid input. GPU clock speed should be between 800 and 2000 MHz");      //Requesting Gpu clock speed.
        gpuMhz = keyboard.nextDouble();
       }
       ////////////////////////////////////////////////////////////////////////
     
     System.out.println( "Please enter the clock speed (in Megahertz) of your processor for computer " + i);
     cpuMhz = keyboard.nextDouble();
      if(cpuMhz < 1000 || cpuMhz > 5500) 
       {
        System.out.println("Invalid input. CPU clock speed should be between 1000 and 5500 MHz");     //Requesting Cpu clock speed.
        cpuMhz = keyboard.nextDouble();
       }
       ////////////////////////////////////////////////////////////////////////
       
     System.out.println( "Please enter the number of cores of your processor for computer " + i);
     cpuCores = keyboard.nextInt();  
       if(cpuCores < 1 || cpuCores > 16) 
       {
        System.out.println("Invalid input. Number of cores should be between 1 and 16");              //Requesting number of cpu cores.
        cpuCores = keyboard.nextInt();
       }
         System.out.println( "What is the resolution of your monitor?");
         System.out.println("\t 1. 1280 x 720" + "\n \t 2. 1920 x 1080"
                          + "\n \t 3. 2560 x 1440" + "\n \t 4. 3840 x 2160"                           //Ask user wanted resolution.
                          + "\nPlease select from the options above:");
         userRes = keyboard.nextInt();
      //////////////////////////////////////////////////////////////////////////////

       
                           /// METHOD(S) \\\
systemRes = getResolutionString(userRes, systemRes); // (METHOD 1)

scoreMultiplier = getMultiplierValue(userRes, scoreMultiplier); // (METHOD 3)

score = calculatePerformanceScore(gpuMhz, cpuMhz, cpuCores, scoreMultiplier); // (METHOD 4)

  
getRecommendedQuality(score); // (METHOD 5)
displayInformation(gpuMhz, cpuMhz, cpuCores, systemRes,score); // (METHOD 6)


        if (score < minScore) {
            minScore = score;       //Assigning highest & lowest scores.
        }
        if (score > maxScore) {
            maxScore = score;
        }
     
  }
  
    System.out.println("\nThe highest performance score is: " + maxScore);    //Output of highest performance score & lowest score.
    System.out.println("The lowest performance score is: " + minScore);

}
} 
    
    
    
   
