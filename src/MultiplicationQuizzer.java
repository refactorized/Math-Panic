import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: atolley
 * Date: May 21, 2010
 * Time: 1:40:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class MultiplicationQuizzer implements IQuizzer
{
   private int a, b, answer;
   Random rand = new Random();

   public void SetOperands(int a, int b)
   {
      this.a = a;
      this.b = b;
      this.answer = a * b;
   }

   public int getAnswer()
   {
      return this.answer;
   }

   public String getQuestion()
   {
      return a + " x " + b;
   }

   public int[] getFakes(int quantity)
   {
      int[] fakes = new int[quantity];

      for (int i = 0; i < fakes.length; i++)
      {
         fakes[i] = getFake();

      }

      return fakes;
   }

   public int getFake()
   {
      int fake = -1;
      switch (rand.nextInt(8))
      {
         case 0:
            fake = (a * b) + 1;
            break;
         case 1:
            fake = (a * b) - 1;
            break;
         case 2:
            fake = (a - 1) * b;
            break;
         case 3:
            fake = (a + 1) * b;
            break;
         case 4:
            fake = a * (b - 1);
            break;
         case 5:
            fake = a * (b + 1);
            break;
         case 6:
            fake = (a + 1) * b - 1;
            break;
         case 7:
            fake = (a - 1) * b + 1;
            break;
      }
      fake = (fake == a * b) ? fake + 1 : fake;
      return fake;
   }

}
