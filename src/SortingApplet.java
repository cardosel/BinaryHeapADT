import java.awt.Container;
import javax.swing.JApplet;

public class SortingApplet
  extends JApplet
{
  public void init()
  {
    getContentPane().add(new SortingPanel());
  }
  
  public void destroy() {}
  
  public void start() {}
  
  public void stop() {}
}
