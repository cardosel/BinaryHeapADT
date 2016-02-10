import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class BarArrayDisplay
  extends JComponent
{
  public static final Color BAR_COLOR = Color.cyan;
  private Integer[] intArray;
  
  public BarArrayDisplay(Integer[] a)
  {
    this.intArray = a;
    repaint();
  }
  
  public void paint(Graphics g)
  {
    if (this.intArray != null)
    {
      int barWidth = getWidth() / this.intArray.length;
      for (int i = 0; i < this.intArray.length; i++) {
        drawBar(g, this.intArray[i].intValue(), barWidth, i * barWidth);
      }
    }
  }
  
  private void drawBar(Graphics g, int height, int width, int xValue)
  {
    g.setColor(BAR_COLOR);
    
    g.fillRect(xValue, getHeight() - height, width, height);
    
    g.setColor(Color.BLACK);
    
    g.drawRect(xValue, getHeight() - height, width, height);
    
    g.drawString(Integer.toString(height), xValue, getHeight() - height + 10);
  }
  
  public void setArray(Integer[] a)
  {
    this.intArray = a;
  }
}
