import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class SortingPanel
  extends JPanel
{
  private static String[] sortingAlgs = { "Selection", "Insertion", "Bubble", "Heapsort" };
  private Integer[] intArray;
  private BarArrayDisplay barDisplay;
  private JComboBox algList;
  
  public SortingPanel()
  {
    initGUI();
  }
  
  private void randomizeArray()
  {
    System.out.println("SortingPanel width: " + getWidth());
    this.intArray = randomIntegerArray(getHeight() / 50, this.barDisplay.getHeight(), this.barDisplay.getWidth() / 20);
    this.barDisplay.setArray(this.intArray);
    repaint();
  }
  
  public void initGUI()
  {
    setLayout(new BorderLayout());
    this.barDisplay = new BarArrayDisplay(this.intArray);
    add(initSortingAlgsCB(), "North");
    add(initButtonsPanel(), "South");
    add(this.barDisplay, "Center");
  }
  
  private JComboBox initSortingAlgsCB()
  {
    this.algList = new JComboBox(sortingAlgs);
    
    return this.algList;
  }
  
  private JPanel initButtonsPanel()
  {
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 2));
    
    buttonsPanel.add(initRandButton());
    
    buttonsPanel.add(initSortButton());
    
    return buttonsPanel;
  }
  
  private JButton initRandButton()
  {
    JButton randButton = new JButton("New random array");
    
    randButton.addActionListener(
    
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          SortingPanel.this.randomizeArray();
        }
      });
    return randButton;
  }
  
  private JButton initSortButton()
  {
    JButton sortButton = new JButton("Sort!");
    
    sortButton.addActionListener(
    
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          SortingPanel.this.sort();
        }
      });
    return sortButton;
  }
  
  private void sort()
  {
    if (this.intArray != null)
    {
      int selectedSortingAlg = this.algList.getSelectedIndex();
      System.out.println("selectedSortingAlg: " + selectedSortingAlg);
      switch (selectedSortingAlg)
      {
      case 0: 
        ArraySorter.selectionSort(this.intArray);
        break;
      case 1: 
        ArraySorter.insertionSort(this.intArray);
        break;
      case 2: 
        ArraySorter.bubbleSort(this.intArray);
        
        // displays new heapSort method
      case 3: 
          ArraySorter.heapSort(intArray);
      }
    	
      }
      this.barDisplay.repaint();
      repaint();
    }
  
  
  public static Integer[] randomIntegerArray(int lo, int hi, int length)
  {
    Integer[] a = new Integer[length];
    for (int i = 0; i < length; i++) {
      a[i] = new Integer((int)Math.floor(Math.random() * (hi - lo) + lo));
    }
    return a;
  }
}
