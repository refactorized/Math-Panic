/**
 * Created by IntelliJ IDEA.
 * User: atolley
 * Date: May 21, 2010
 * Time: 1:03:39 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IQuizzer
{
   public void SetOperands(int a, int b);

   public int getAnswer();

   public String getQuestion();

   public int[] getFakes(int quantity);
}

