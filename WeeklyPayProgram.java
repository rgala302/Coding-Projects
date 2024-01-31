public class WeeklyPayProgram
{
   public static void main(String[] args)
   {
int payAmount = 250;
double raiseRate = .03;
double weeklyRaise = payAmount * raiseRate;
double weeklyPay = payAmount + weeklyRaise;
System.out.println("$" + weeklyPay);
   }
}