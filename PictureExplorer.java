import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;//rg added
import java.io.File;             //rg added
import java.util.*;
import java.util.Stack;          //rg added
/*
Taken from Fauxtoshoppe
*/

public class PictureExplorer implements MouseMotionListener, ActionListener, MouseListener
{
   // current indicies
/** row index */
   private int rowIndex = 0; 
/** column index */
   private int colIndex = 0;

// main GUI
/** window to hold GUI */
   private JFrame pictureFrame;
/** window that allows the user to scroll to see a large picture */
   private JScrollPane scrollPane;
	
   private JPanel sub_panel;
   private JPanel panel;
   
    // menu components
/** menu bar */
   private JMenuBar menuBar;
/** zoom menu */
   private JMenu zoomMenu;
/** 25% zoom level */
   private JMenuItem twentyFive;
/** 50% zoom level */
   private JMenuItem fifty;
/** 75% zoom level */
   private JMenuItem seventyFive;
/** 100% zoom level */
   private JMenuItem hundred;
/** 150% zoom level */
   private JMenuItem hundredFifty;
/** 200% zoom level */
   private JMenuItem twoHundred;
/** 500% zoom level */
   private JMenuItem fiveHundred;
   
   // picture coordinates for select tool - rg added
   private int x_Upper_Left;
   private int y_Upper_Left;
   private int x_Lower_Right;
   private int y_Lower_Right; 	
 
/** The picture being explored */
   private DigitalPicture picture;
   
/** The stack that holds picture changes - rg added */
   private Stack <DigitalPicture> pictureStack;   
	
/** The unaltered picture when the picture is first loaded - rg added */
   private DigitalPicture orig;	

/** The image icon used to display the picture */
   private ImageIcon scrollImageIcon;

/** The image display */
   private ImageDisplay imageDisplay;

/** the zoom factor (amount to zoom) */
   private double zoomFactor;

/** the number system to use, 0 means starting at 0, 1 means starting at 1 */
   private int numberBase=0;
   
   
/**
* Public constructor 
* @param picture the picture to explore
*/
   public PictureExplorer(DigitalPicture picture)
   {
   // set the fields
      this.picture=picture;
      orig=picture;
      zoomFactor=1;
   
   // create the window and set things up
      createWindow();
   
   //adds orig picture to stack - rg added   
      pictureStack = new Stack<DigitalPicture>();
      pictureStack.push(orig);
      
      File origFile = new File(picture.getFileName());
      changePicture(origFile);
       
   }
   
   public PictureExplorer()
   {
      this.picture = null;
      orig = null;
      zoomFactor=1;
   
   // create the window and set things up
      createWindow();
   
   //adds orig picture to stack - rg added   
      pictureStack = new Stack<DigitalPicture>();
      pictureStack.push(orig);
      
      File origFile = new File(picture.getFileName());
      changePicture(origFile);
       
   }
   
   /**
* Set the title of the frame
*@param title the title to use in the JFrame
*/
   public void setTitle(String title)
   {
      pictureFrame.setTitle(title);
   }
	
/**
* Method to create and initialize the picture frame
*/
   private void createAndInitPictureFrame()
   {
      pictureFrame = new JFrame();        // create the JFrame
      pictureFrame.setResizable(true);    // allow the user to resize it
      pictureFrame.getContentPane().setLayout(new BorderLayout());   // use border layout
      pictureFrame.setVisible(true);      //rg added
      pictureFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // when close stop
      pictureFrame.setTitle(picture.getTitle());
   }
   
   /**
* Method to create the menu bar, menus, and menu items
*/
   private void setUpMenuBar()
   {
     //create menu
      menuBar = new JMenuBar();
      zoomMenu = new JMenu("Zoom");
      twentyFive = new JMenuItem("25%");
      fifty = new JMenuItem("50%");
      seventyFive = new JMenuItem("75%");
      hundred = new JMenuItem("100%");
      hundred.setEnabled(false);
      hundredFifty = new JMenuItem("150%");
      twoHundred = new JMenuItem("200%");
      fiveHundred = new JMenuItem("500%");
   
   // add the action listeners
      twentyFive.addActionListener(this);
      fifty.addActionListener(this);
      seventyFive.addActionListener(this);
      hundred.addActionListener(this);
      hundredFifty.addActionListener(this);
      twoHundred.addActionListener(this);
      fiveHundred.addActionListener(this);
   
   // add the menu items to the menus
      zoomMenu.add(twentyFive);
      zoomMenu.add(fifty);
      zoomMenu.add(seventyFive);
      zoomMenu.add(hundred);
      zoomMenu.add(hundredFifty);
      zoomMenu.add(twoHundred);
      zoomMenu.add(fiveHundred);
      menuBar.add(zoomMenu);
   	
            
   // set the menu bar to this menu
      pictureFrame.setJMenuBar(menuBar);
   }

//Ria added from Barb's shape stuff
/** An inner class for handling the mouse listener interface */
   private class MyMouseAdapter extends MouseAdapter
   {
   /** Method to handle when the user presses down the button */
      public void mousePressed(MouseEvent e)
      {
         x_Upper_Left = e.getX();
         y_Upper_Left = e.getY();
      }
   /** Method to handle when the user releases the mouse */
      public void mouseReleased(MouseEvent e)
      {
         x_Lower_Right = e.getX();
         y_Lower_Right = e.getY();
        
      }
   }
   
   //rg added
   private void updatePicture ()
   {
      BufferedImage bimg = picture.getBufferedImage();
      imageDisplay.setImage(bimg);
      imageDisplay.revalidate();
      checkScroll();        
      repaint();
   }  
//rg added	 
   private void changePicture (File file)
   {
      DigitalPicture newPic = new Picture(file.getAbsolutePath());
      this.picture=newPic;
      this.orig=newPic;
      pictureFrame.setTitle(file.getName());
      repaint();
      BufferedImage bimg = picture.getBufferedImage();
      imageDisplay.setImage(bimg);
      imageDisplay.revalidate();
      checkScroll(); 
      pictureStack.push(newPic);       
   }	
   
   /**
* Create and initialize the scrolling image
*/
   private void createAndInitScrollingImage()
   {
      scrollPane = new JScrollPane();
   
      BufferedImage bimg = picture.getBufferedImage();
      imageDisplay = new ImageDisplay(bimg);
      imageDisplay.addMouseMotionListener(this);
      imageDisplay.addMouseListener(this);
      scrollPane.setViewportView(imageDisplay);
      pictureFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
   }
   
   /**
* Creates the JFrame and sets everything up
*/
   private void createWindow()
   {
   // create the picture frame and initialize it
      createAndInitPictureFrame();
   
   // set up the menu bar
      setUpMenuBar();
   
   //creates the scrollpane for the picture
      createAndInitScrollingImage();
   
   // show the picture in the frame at the size it needs to be
      pictureFrame.pack();
      pictureFrame.setVisible(true);
   }
   
   /**
* Method to check that the current position is in the viewing area and if
* not scroll to center the current position if possible
*/
   public void checkScroll()
   {
   // get the x and y position in pixels
      int xPos = (int) (colIndex * zoomFactor); 
      int yPos = (int) (rowIndex * zoomFactor); 
   
   // only do this if the image is larger than normal
      if (zoomFactor > 1) {
      
      // get the rectangle that defines the current view
         JViewport viewport = scrollPane.getViewport();
         Rectangle rect = viewport.getViewRect();
         int rectMinX = (int) rect.getX();
         int rectWidth = (int) rect.getWidth();
         int rectMaxX = rectMinX + rectWidth - 1;
         int rectMinY = (int) rect.getY();
         int rectHeight = (int) rect.getHeight();
         int rectMaxY = rectMinY + rectHeight - 1;
      
      // get the maximum possible x and y index
         int macolIndexX = (int) (picture.getWidth() * zoomFactor) - rectWidth - 1;
         int macolIndexY = (int) (picture.getHeight() * zoomFactor) - rectHeight - 1;
      
      // calculate how to position the current position in the middle of the viewing
      // area
         int viewX = xPos - (int) (rectWidth / 2);
         int viewY = yPos - (int) (rectHeight / 2);
      
      // reposition the viewX and viewY if outside allowed values
         if (viewX < 0)
            viewX = 0;
         else if (viewX > macolIndexX)
            viewX = macolIndexX;
         if (viewY < 0)
            viewY = 0;
         else if (viewY > macolIndexY)
            viewY = macolIndexY;
      
      // move the viewport upper left point
         viewport.scrollRectToVisible(new Rectangle(viewX,viewY,rectWidth,rectHeight));
      }
   }
   
   /**
* Zooms in the on picture by scaling the image.  
* It is extremely memory intensive.
* @param factor the amount to zoom by
*/
   public void zoom(double factor)
   {
   // save the current zoom factor
      zoomFactor = factor;
   
   // calculate the new width and height and get an image that size
      int width = (int) (picture.getWidth()*zoomFactor);
      int height = (int) (picture.getHeight()*zoomFactor);
      BufferedImage bimg = picture.getBufferedImage();
   
   // set the scroll image icon to the new image
      imageDisplay.setImage(bimg.getScaledInstance(width, height, Image.SCALE_DEFAULT));
      imageDisplay.setCurrentX((int) (colIndex * zoomFactor));
      imageDisplay.setCurrentY((int) (rowIndex * zoomFactor));
      imageDisplay.revalidate();
      checkScroll();  // check if need to reposition scroll
   }
   
   /**
* Repaints the image on the scrollpane.  
*/
   public void repaint()
   {
      pictureFrame.repaint();
   }
   
/**
* Called when the mouse is dragged (button held down and moved)
* @param e the mouse event
*/
   public void mouseDragged(MouseEvent e){}
   
   /**
* Method called when the mouse is moved with no buttons down
* @param e the mouse event
*/
   public void mouseMoved(MouseEvent e){}

/**
* Method called when the mouse is clicked
* @param e the mouse event
*/
   public void mouseClicked(MouseEvent e){}

/**
* Method called when the mouse button is pushed down
* @param e the mouse event
*/ 
   public void mousePressed(MouseEvent e){}

/**
* Method called when the mouse button is released
* @param e the mouse event
*/
   public void mouseReleased(MouseEvent e){}

/**
* Method called when the component is entered (mouse moves over it)
* @param e the mouse event
*/
   public void mouseEntered(MouseEvent e){}

/**
* Method called when the mouse moves over the component
* @param e the mouse event
*/
   public void mouseExited(MouseEvent e){}

/**
* Method to enable all menu commands
*/
   private void enableZoomItems()
   {
      twentyFive.setEnabled(true);
      fifty.setEnabled(true);
      seventyFive.setEnabled(true);
      hundred.setEnabled(true);
      hundredFifty.setEnabled(true);
      twoHundred.setEnabled(true);
      fiveHundred.setEnabled(true);
   }

/**
* Controls the zoom menu bar
*
* @param a the ActionEvent 
*/
   public void actionPerformed(ActionEvent a)
   {
      if(a.getActionCommand().equals("Update"))
      {
         this.repaint();
      }
      if(a.getActionCommand().equals("25%"))
      {
         this.zoom(.25);
         enableZoomItems();
         twentyFive.setEnabled(false);
      }
      if(a.getActionCommand().equals("50%"))
      {
         this.zoom(.50);
         enableZoomItems();
         fifty.setEnabled(false);
      }
      if(a.getActionCommand().equals("75%"))
      {
         this.zoom(.75);
         enableZoomItems();
         seventyFive.setEnabled(false);
      }
      if(a.getActionCommand().equals("100%"))
      {
         this.zoom(1.0);
         enableZoomItems();
         hundred.setEnabled(false);
      }
      if(a.getActionCommand().equals("150%"))
      {
         this.zoom(1.5);
         enableZoomItems();
         hundredFifty.setEnabled(false);
      }
      if(a.getActionCommand().equals("200%"))
      {
         this.zoom(2.0);
         enableZoomItems();
         twoHundred.setEnabled(false);
      }
      if(a.getActionCommand().equals("500%"))
      {
         this.zoom(5.0);
         enableZoomItems();
         fiveHundred.setEnabled(false);
      }
   }
   
   /**
* Test Main.  
*/
   public static void main( String args[])
   {
      //Picture pix = new Picture(); // rg - this doesn't open a picture
      Picture pix = new Picture("images/board.png"); //- rg this explores the 640x480 in the images directory
      pix.explore();
   }
}