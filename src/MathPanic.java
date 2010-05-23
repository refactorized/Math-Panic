import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: atolley
 * Date: May 20, 2010
 * Time: 4:57:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class MathPanic implements ActionListener
{
   private JProgressBar progressBar;
   private JButton buttonAnswerA;
   private JButton buttonAnswerB;
   private JButton buttonAnswerC;
   private JButton buttonAnswerD;
   private JFormattedTextField textPaneQuestion;
   private JFormattedTextField textPaneStats;

   private JPanel mainPanel;

   int[] aOps = {2, 3, 4, 5, 6, 7, 8, 9};
   int[] bOps = {3, 4, 5, 6, 7, 8, 9};
   Random rand = new Random();
   int correctIndex = 0;

   JButton[] answerButtons = {buttonAnswerA, buttonAnswerB, buttonAnswerC, buttonAnswerD};

   public MathPanic()
   {
      for (int i = 0; i < answerButtons.length; i++)
      {
         answerButtons[i].addActionListener(this);
      }

      this.nextProblem();
   }

   public void nextProblem()
   {
      IQuizzer q = new MultiplicationQuizzer();

      q.SetOperands(aOps[rand.nextInt(aOps.length)], bOps[rand.nextInt(bOps.length)]);

      textPaneQuestion.setText(q.getQuestion());

      correctIndex = rand.nextInt(4);
      int[] fakes = q.getFakes(4); //one of these will be wasted for the sake of simpler code below

      for (int i = 0; i < 4; i++)
      {
         answerButtons[i].setText(String.valueOf(fakes[i]));
      }

      answerButtons[correctIndex].setText(String.valueOf(q.getAnswer()));
   }

   public void answerWith(int index)
   {
      if (index == this.correctIndex)
      {
         this.answeredCorrectly();
      }
      else
      {
         this.answeredIncorrectly();
      }

      this.nextProblem();
   }

   public void answeredCorrectly()
   {
      this.textPaneStats.setText("Correct!");
   }

   public void answeredIncorrectly()
   {
      this.textPaneStats.setText("Wrong!");
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame("MathPanic");
      frame.setContentPane(new MathPanic().mainPanel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }

   public void actionPerformed(ActionEvent e)
   {
      for (int i = 0; i < answerButtons.length; i++)
      {
         if (e.getSource() == answerButtons[i])
         {
            this.answerWith(i);
         }

      }
   }
}
