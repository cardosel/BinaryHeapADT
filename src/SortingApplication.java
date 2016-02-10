import java.awt.Container;
import javax.swing.JFrame;

public class SortingApplication
{
  public static void main(String[] args)
  {
    JFrame sortingFrame = new JFrame("Sorting");
    
    sortingFrame.getContentPane().add(new SortingPanel());
    sortingFrame.setSize(800, 400);
    sortingFrame.setDefaultCloseOperation(3);
    sortingFrame.setVisible(true);
  }
}
