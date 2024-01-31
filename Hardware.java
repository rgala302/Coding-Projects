import java.util.Scanner;

public class Hardware 
{
                           /// TITLE ||| METHOD 1 \\\
      public static void displayTitle()
      {
         System.out.println("\nComputer Hardware Graphics Quality Recommendation Tool\n"); // This method creates a String object in memory to hold the text “Computer Hardware Graphics Quality Recommendation Tool” and displays it
      }
      //////////////////////////////////////////////////////////////////////////////
      
                        /// RESOLUTION ||| METHOD 2  \\\
      public static String getResolutionString(int userRes, String systemRes)
       {
 
          if(userRes == 1)
           {
              systemRes = "1280 x 720";
           }
            else if(userRes == 2) 
           {
              systemRes = "1920 x 1080";         // This method accepts an integer value (1, 2, 3, or 4) and denotes the monitor resolution based on the interger value. 
           } 
           else if(userRes == 3)
           {
             systemRes = "2560 x 1440";
           } 
           else if(userRes == 4)
           {
             systemRes = "3840 x 2160";
           } 
           else
           {
             systemRes = "Improper resolution chosen.";
           }
    return systemRes;
      }
      //////////////////////////////////////////////////////////////////////////////
      
      
                  /// RESOLUTION SCORE ||| METHOD 3  \\\
      public static int getMultiplierValue(int userRes, int scoreMultiplier)
      {
      
      if(userRes == 1)
           {
              scoreMultiplier = 200;
           }
            else if(userRes == 2) 
           {
              scoreMultiplier = 300;      //This method accepts an integer value (1, 2, 3, or 4) and denotes the monitor resolution, and returns the appropriate “multiplier” value based on the resolution chosen. 
           } 
           else if(userRes == 3)
           {
             scoreMultiplier = 400;
           } 
           else if(userRes == 4)
           {
             scoreMultiplier = 500;
           } 

      return scoreMultiplier;
      }
     //////////////////////////////////////////////////////////////////////////////

   
   
                      /// PERFORMANCE SCORE CALC ||| METHOD 4 \\\
      public static double calculatePerformanceScore(double gpuMhz, double cpuMhz, int cpuCores, int scoreMultiplier)
        {
            double score = (gpuMhz / 1000) * (cpuMhz / 2000) * Math.sqrt(cpuCores) * scoreMultiplier;    //This method accepts the GPU clock speed, CPU clock speed, the number of cores, and the multiplier value, and calculates and returns a performance score. 
            score = Math.round(score * 100) / 100;
            return score;
        }
      //////////////////////////////////////////////////////////////////////////////


                      /// RECOMMENDATION QUALITY ||| METHOD 5 \\\  
      public static void getRecommendedQuality(double score)
      {
      
      if(score >= 8)
    {
        System.out.println("Recommended Graphics Quality: Ultra");
    }
    else if(score >= 6)
    {
        System.out.println("Recommended Graphics Quality: High");    //This method accepts a performance score as an argument and returns the recommended graphics quality.
    }
    else if(score >= 4)
    {
        System.out.println("Recommended Graphics Quality: Medium");
    }
    else
    {
        System.out.println("Recommended Graphics Quality: Low");
    }
    
      }
      //////////////////////////////////////////////////////////////////////////////
     
     
                      /// SYSTEM INFORMATION ||| METHOD 6 \\\ 
     public static void displayInformation(double gpuMhz, double cpuMhz, int cpuCores, String systemRes, double score)
     {
        System.out.println( "\nGPU clock speed " +gpuMhz +"Mhz" );
        System.out.println( "CPU clock speed " +cpuMhz +"Mhz" );
        System.out.println( "Number of cores " + cpuCores );
        System.out.println( "Monitor Resolution: " +systemRes);      // This method prints out the information for a single computer based on the users input.
        System.out.println( "Performance Score:" +score);
     }
     
     //////////////////////////////////////////////////////////////////////////////

     
     


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