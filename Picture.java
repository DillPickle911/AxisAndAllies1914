import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 * @author Ria Galanos (TJHSST), Doug Oberle (CGW)...
 */
public class Picture extends SimplePicture 
{
///////////////////// constructors ///////////////////////////////////**
/**
 * Constructor that takes no arguments 
 */
   public Picture ()
   {
   /* not needed but use it to show the implicit call to super()
   * child constructors always call a parent constructor 
   */
      super();  
   }

/**
* Constructor that takes a file name and creates the picture 
* @param fileName the name of the file to create the picture from
*/
   public Picture(String fileName)
   {
   // let the parent class handle this fileName
      super(fileName);
   }

/**
* Constructor that takes the width and height
* @param height the height of the desired picture
* @param width the width of the desired picture
*/
   public Picture(int height, int width)
   {
   // let the parent class handle this width and height
      super(width,height);
   }

/**
* Constructor that takes a picture and creates a 
* copy of that picture
* @param copyPicture the picture to copy
*/
   public Picture(Picture copyPicture)
   {
   // let the parent class do the copy
      super(copyPicture);
   }

/**
* Constructor that takes a buffered image
* @param image the buffered image to use
*/
   public Picture(BufferedImage image)
   {
      super(image);
   }

////////////////////// methods ///////////////////////////////////////

/**
 * Method to return the Picture from the Picture
 * @return the picture (this)
 */
   public Picture getPicture()
   {
      return this;
   }	

/**
* Method to return a string with information about this picture.
* @return a string with information about the picture such as fileName,
* height and width.
*/
   public String toString()
   {
      String output = "Picture, filename " + getFileName() + 
         " height " + getHeight() 
         + " width " + getWidth();
      return output;
   }

/** 
 * Method to set the red to 0  
 */
   public void zeroRed()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(0);
         }
      }
   }
   
/** 
 * Method to set the green to 0  
 */   
   public void zeroGreen()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setGreen(0);
         }
      }
   }	
   
/** 
 * Method to set the blue to 0  
 */
   public void zeroBlue()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setBlue(0);
         }
      }
   }	
   
/** 
* Method to keep just the red  
*/    
   public void keepOnlyRed()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setGreen(0);
            pixelObj.setBlue(0);
         }
      }
   } 
  
/** 
* Method to keep just the green  
*/    
   public void keepOnlyGreen()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(0);
            pixelObj.setBlue(0);
         }
      }
   }  

/** 
* Method to keep just the blue  
*/       
   public void keepOnlyBlue()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(0);
            pixelObj.setGreen(0);
         }
      }
   }  
   
/** 
 * Method to modify red by some percentage parameter between 0% and 200%
 * modifyRed(100) nets no change, modifyRed(50) decreases the red to 50% of its original value
 * modifyRed(200) increases the red by 100% 
 * @param x the percentage by which we want to modify the red pixels by
 */  
   public void modifyRed(int x)
   {
      double percent = x / 100.0;
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed((int)(pixelObj.getRed() * percent));
         }
      }
   }
   
/** 
 * Method to modify green by some percentage parameter between 0% and 200%
 * modifyGreen(100) nets no change, modifyGreen(50) decreases the green to 50% of its original value
 * modifyGreen(200) increases the green by 100% 
 * @param x the percentage by which we want to modify the blue pixels by
 * 
 */    
   public void modifyGreen(int x)
   {
      double percent = x / 100.0;
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setGreen((int)(pixelObj.getGreen() * percent));
         }
      }
   }
 
/** 
 * Method to modify blue by some percentage parameter between 0% and 200%
 * modifyBlue(100) nets no change, modifyBlue(50) decreases the blue to 50% of its original value
 * modifyBlue(200) increases the blue by 100% 
 * @param x the percentage by which we want to modify the blue pixels by 
 */   
   public void modifyBlue(int x)
   {
      double percent = x / 100.0;
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setBlue((int)(pixelObj.getBlue() * percent));
         }
      }
   }
   
/** 
 * Method to place a rainbow filter over the picture 
 */
   public void rainbowBar()
   {
      Pixel pixel = null;
      Pixel[][] pixels = this.getPixels2D();
      int numRows = pixels.length/6;
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            pixel = pixels[row][col];
            //red orange yellow green blue purple
            if (row<numRows)//red
            {
               pixel.setRed((pixel.getRed()+255)/2);
            }               
            else if (row<numRows*2)//orange
            {
               pixel.setRed((pixel.getRed()+255)/2);
               pixel.setGreen((pixel.getGreen()+127)/2);
               pixel.setBlue((pixel.getBlue()+44)/2);   
            }
            else if (row<numRows*3)//yellow
            {
               pixel.setRed((pixel.getRed()+255)/2);
               pixel.setGreen((pixel.getGreen()+255)/2);
            }
            else if (row<numRows*4)//green
            {
               pixel.setGreen((pixel.getGreen()+255)/2); 
            }
            else if (row<numRows*5)//blue
            {
               pixel.setBlue((pixel.getBlue()+255)/2); 
            }
            else //purple
            {
               pixel.setRed((pixel.getRed()+143)/2);
               pixel.setBlue((pixel.getBlue()+255)/2);
            }
         }
      }          
   }
   
/** 
* Method to negate the picture - change the color of every pixel to its inverse
* 
*/
   public void negate()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(255 - pixelObj.getRed());
            pixelObj.setGreen(255 - pixelObj.getGreen());
            pixelObj.setBlue(255 - pixelObj.getBlue());
         }
      }
   }            
 
/** 
* Method to grayscale the picture - change every pixel to its equvalently bright or dark shade of gray
      Gray = 0.299R + 0.587G + 0.114B
*/
   public void grayscale()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            double gray = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
            pixelObj.setRed((int)(gray));
            pixelObj.setGreen((int)(gray));
            pixelObj.setBlue((int)(gray));
         }
      }    
   }              
 
/** Method that mirrors the picture around a 
 * vertical mirror in the center of the picture
 * from left to right 
 * what was on the left is now on the right */
   public void mirrorVertical()
   {
      Pixel[][] pixels = this.getPixels2D();
      int max = pixels[0].length - 1;
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<=max / 2; col++)
         {
            pixels[row][max - col].setRed(pixels[row][col].getRed());
            pixels[row][max - col].setGreen(pixels[row][col].getGreen());
            pixels[row][max - col].setBlue(pixels[row][col].getBlue());
         }
      }
   }
 
/** Method that mirrors the picture around a 
 * vertical mirror in the center of the picture
 * from right to left 
 * what was on the right is now on the left */   
   public void mirrorVerticalRightToLeft()
   {
      Pixel[][] pixels = this.getPixels2D();
      int max = pixels[0].length - 1;
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<=max / 2; col++)
         {
            pixels[row][col].setRed(pixels[row][max - col].getRed());
            pixels[row][col].setGreen(pixels[row][max - col].getGreen());
            pixels[row][col].setBlue(pixels[row][max - col].getBlue());
         }
      }
   } 
   
/** Method that mirrors the picture around a 
 * horizontal mirror in the center of the picture
 * from top to bottom 
 * what was on the top is now on the bottom */   
   public void mirrorHorizontal()
   {
      Pixel[][] pixels = this.getPixels2D();
      int max = pixels.length - 1;
      for(int col = 0; col< pixels[0].length; col++)
      {
         for(int row = 0; row<=max / 2; row++)
         {
            pixels[max - row][col].setRed(pixels[row][col].getRed());
            pixels[max - row][col].setGreen(pixels[row][col].getGreen());
            pixels[max - row][col].setBlue(pixels[row][col].getBlue());
         }
      }
   }
  
/** Method that mirrors the picture around a 
 * horizontal mirror in the center of the picture
 * from bottom to top 
 * what was on the top is now on the bottom */   
   public void mirrorHorizontalBotToTop()
   {
      Pixel[][] pixels = this.getPixels2D();
      int max = pixels.length - 1;
      for(int col = 0; col< pixels[0].length; col++)
      {
         for(int row = 0; row<=max / 2; row++)
         {
            pixels[row][col].setRed(pixels[max - row][col].getRed());
            pixels[row][col].setGreen(pixels[max - row][col].getGreen());
            pixels[row][col].setBlue(pixels[max - row][col].getBlue());
         }
      }
   }
	
/** Method that mirrors the picture around a 
 * diagonal mirror from the upper-left corner
 * to the lower-right  
 * what was in the top right corner is now in the bottom left */   
   public void mirrorDiagonal()
   {
      Pixel[][] pixels = this.getPixels2D();
      int rMax = pixels.length - 1;
      int cMax = pixels[0].length - 1;
      int max;
      if(rMax <= cMax)
         max = rMax;
      else
         max = cMax;
      for(int row = 0; row<= max; row++)
      {
         for(int col = 0; col<= max - row; col++)
         {
            pixels[row][max - col].setRed(pixels[max - col][row].getRed());
            pixels[row][max - col].setGreen(pixels[max - col][row].getGreen());
            pixels[row][max - col].setBlue(pixels[max - col][row].getBlue());
         }
      }
   }
 
/** Method that mirrors the picture around a 
 * diagonal mirror from the upper-right corner
 * to the lower-left  
 * what was in the top left corner is now in the bottom right */   
   public void mirrorDiagonalOpposite()
   {
      Pixel[][] pixels = this.getPixels2D();
      int rMax = pixels.length - 1;
      int cMax = pixels[0].length - 1;
      int max;
      if(rMax <= cMax)
         max = rMax;
      else
         max = cMax;
      for(int row = 0; row<= max; row++)
      {
         for(int col = 0; col<= max - row; col++)
         {
            pixels[row][col].setRed(pixels[max - col][max - row].getRed());
            pixels[row][col].setGreen(pixels[max - col][max - row].getGreen());
            pixels[row][col].setBlue(pixels[max - col][max - row].getBlue());
         }
      }
   }	
    
/** copy from the passed fromPic to the
 * specified startRow and startCol in the
 * current picture
 * @param fromPic the picture to copy from
 * @param startRow the start row to copy to
 * @param startCol the start col to copy to
 */
   public void copy(Picture fromPic, int startRow, int startCol)
   {
      Pixel fromPixel = null;
      Pixel toPixel = null;
      Pixel[][] toPixels = this.getPixels2D();
      Pixel[][] fromPixels = fromPic.getPixels2D();
      for (int fromRow = 0, toRow = startRow; 
      fromRow < fromPixels.length &&
      toRow < toPixels.length; 
      fromRow++, toRow++)
      {
         for (int fromCol = 0, toCol = startCol; 
         fromCol < fromPixels[0].length &&
         toCol < toPixels[0].length;  
         fromCol++, toCol++)
         {
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
         }
      }   
   }
 
/** copy from the passed fromPic to the
 * specified startRow and startCol in the
 * current picture to a specific location
 * @param fromPic the picture to copy from
 * @param startRow the start row to copy
 * @param startCol the start col to copy
 * @param finRow the finish row to copy
 * @param finCol the finish col to copy
 * @param startToRow the start row location to copy to
 * @param startToCol the start col location to copy to
 */ 
   public void copySection(Picture fromPic, int startRow, int startCol, 
                           int finRow, int finCol, int startToRow, int startToCol)
   {
      Pixel fromPixel=null;
      Pixel toPixel=null;
      Pixel[][] toPixels = this.getPixels2D();
      Pixel[][] fromPixels = fromPic.getPixels2D();
      for( int fromRow = startRow, toRow = startToRow; fromRow < (finRow) 
                   && toRow < toPixels.length; fromRow ++,toRow++)
      {
         for(int fromCol = startCol, toCol = startToCol; fromCol < finCol
              &&  toCol < toPixels[0].length; fromCol++, toCol++)
         {
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
         }
      }
   }
      
/** 
* Method to sepia tone the picture
*/
   public void sepiatone()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            int red = pixelObj.getRed();
            int green = pixelObj.getGreen();
            int blue = pixelObj.getBlue();
            pixelObj.setRed((int)((red * .393) + (green *.769) + (blue * .189)));
            pixelObj.setGreen((int)((red * .349) + (green *.686) + (blue * .168)));
            pixelObj.setBlue((int)((red * .272) + (green *.534) + (blue * .131)));
         }
      }
   }	

/** Method to show large changes in color 
 * @param edgeDist the distance for finding edges
 */
   public void edgeDetection(int edgeDist)
   {
      Pixel[][] pixels = this.getPixels2D();
      
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[0].length - 1; col++)
         {
            double colorDistance = pixels[row][col].colorDistance(pixels[row][col + 1].getColor());
            String current = "white";
            if(colorDistance > edgeDist)
            {
               if(current.equals("black"))
               {
                  current = "white";
                  pixels[row][col].setRed(255);
                  pixels[row][col].setGreen(255);
                  pixels[row][col].setBlue(255);
               }
               else
               {
                  current = "black";
                  pixels[row][col].setRed(0);
                  pixels[row][col].setGreen(0);
                  pixels[row][col].setBlue(0);
               }
            }
            else
            {
               if(current.equals("black"))
               {
                  pixels[row][col].setRed(0);
                  pixels[row][col].setGreen(0);
                  pixels[row][col].setBlue(0);
               }
               else
               {
                  pixels[row][col].setRed(255);
                  pixels[row][col].setGreen(255);
                  pixels[row][col].setBlue(255);
               }
            }
         }
      }
   }
	
/** 
* Method to pixelate the picture (low bit video game effect)
* @param resolution the block size that we simulate for each pixel
*/
   public void pixelate(int resolution)
   {
      Pixel[][] pixels = this.getPixels2D();
      
      for(int row = 0; row < pixels.length; row += resolution)
      {
         for(int col = 0; col < pixels[0].length; col += resolution)
         {
            int red = 0;
            int green = 0;
            int blue = 0;
            
            // prevents indexOutOfBounds errors
            int rMax = 0;
            if(row + resolution > pixels.length - 1)
               rMax = pixels.length - 1;
            else
               rMax = row + resolution;
            
            int cMax = 0;
            if(col + resolution > pixels[0].length - 1)
               cMax = pixels[0].length - 1;
            else
               cMax = col + resolution;
            
            // add all of the RGB of the pixels in this big pixel
            for(int r = row; r <= rMax; r++)
            {
               for(int c = col; c <= cMax; c++)
               {
                  red += pixels[r][c].getRed();
                  green += pixels[r][c].getGreen();
                  blue += pixels[r][c].getBlue();
               }
            }
            
            // average them all out and assign the averages to each pixel in the big pixel
            //System.out.println(rMax + ", " + row + ", " + cMax + ", " + col);
            for(int r = row; r < rMax; r++)
            {
               for(int c = col; c < cMax; c++)
               {
                  pixels[r][c].setRed(red / ((rMax - row) * (cMax - col)));
                  pixels[r][c].setGreen(green / ((rMax - row) * (cMax - col)));
                  pixels[r][c].setBlue(blue / ((rMax - row) * (cMax - col)));
               }
            }
         }
      }
   }
   
/** 
 * Method to blur the picture
 */
   public void blur()
   {
      Pixel[][] pixels = this.getPixels2D();
      Pixel[][] temp = this.getPixels2D();
      
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[0].length; col++)
         {
            int red = 0;
            int green = 0;
            int blue = 0;
            int reps = 0;
            
            // add up all of the color in this 3x3 zone
            for(int r = row - 1; r <= row + 1; r++)
            {
               for(int c = col - 1; c <= col + 1; c++)
               {
                  if(r < 0 || c < 0 || r >= pixels.length || c >= pixels[0].length)
                     continue;
                  red += pixels[r][c].getRed();
                  green += pixels[r][c].getGreen();
                  blue += pixels[r][c].getBlue();
                  reps++;
               }
            }
            
            // set the temp variable so the new color isnt used in future tests
            temp[row][col].setRed(red / reps);
            temp[row][col].setGreen(green / reps);
            temp[row][col].setBlue(blue / reps);            
         }  
      }
      
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[0].length; col++)
         {
            pixels[row][col] = temp[row][col];
         }
      }
   }

/** 
* Method to calculate the distance between two colors
* @param p the pixel we want to find the color distance from
* @param c the color we want to find the color distance from pixel
* @return the color distance between p and c
*/        
   public double distance(Pixel p, Color c)
   {
   
      return Math.sqrt( Math.pow ( Math.abs (p.getRed()-c.getRed() ),2 ) +
                   Math.pow ( Math.abs (p.getGreen()-c.getGreen() ),2 ) +
             		 Math.pow ( Math.abs (p.getBlue()-c.getBlue() ),2 ) );	
   }

/** 
* Method to posterize the picture - reduce to only 3-4 colors of your choice
*/
   public void posterize()
   {
      Pixel[][] pixels = this.getPixels2D();
      
      Color c1 = new Color(255, 100, 100);
      Color c2 = new Color(100, 255, 100);
      Color c3 = new Color(100, 100, 255);
      
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[0].length; col++)
         {
            double c1dist = pixels[row][col].colorDistance(c1);
            double c2dist = pixels[row][col].colorDistance(c2);
            double c3dist = pixels[row][col].colorDistance(c3);
            int edgeDist = 125;
            
            if(c1dist < edgeDist)
               pixels[row][col].setColor(c1);
            else if(c2dist < edgeDist)
               pixels[row][col].setColor(c2);
            else if(c3dist < edgeDist)
               pixels[row][col].setColor(c3);
            else
               pixels[row][col].setColor(new Color(100, 100, 100));
         }
      }
   }	

/**
* Method for copying the no-green pixels from left side of a picture (with green background) to the right side
*/  
   public void greenScreen()
   {
      Pixel[][] pixels = this.getPixels2D();
      int max = pixels[0].length - 1;
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<=max / 2; col++)
         {
            int red = pixels[row][col].getRed();
            int green = pixels[row][col].getGreen();
            int blue = pixels[row][col].getBlue();
            
            // if it isnt green
            if(!(green - red >= 150 && green - blue >= 150))
            {
               pixels[row][max - col].setRed(pixels[row][col].getRed());
               pixels[row][max - col].setGreen(pixels[row][col].getGreen());
               pixels[row][max - col].setBlue(pixels[row][col].getBlue());
            }
         }
      }
   }			

/** 
* Method to color splash a picture
* Keeps any pixel close to Color c, but casts all other pixels to its gray-scale equivalent
* @param c the color we want to keep
*/  	
   public void colorSplash(Color c)
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[0].length; col++)
         {
            double colorDistance = pixels[row][col].colorDistance(c);
            // if the color is different, grayscale it
            if(colorDistance > 150)
            {
               Pixel pixelObj = pixels[row][col];
               double gray = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
               pixelObj.setRed((int)(gray));
               pixelObj.setGreen((int)(gray));
               pixelObj.setBlue((int)(gray));
            }
         }
      }
   }	
     
 /** Hide a black and white message in the current
    * picture by changing the red to even and then
    * setting it to odd if the message pixel is black 
    * @param messagePict the picture with a message
    */
   public void encode(Picture messagePict)
   {
      // 2d arrays for **BOTH** pictures (ooh jazz hands)
      Pixel[][] original = this.getPixels2D();
      Pixel[][] message = messagePict.getPixels2D();
      
      // set row and column bounds
      int rMax = 0;
      if(original.length <= message.length)
         rMax = original.length;
      else
         rMax = message.length;
      
      int cMax = 0;
      if(original[0].length <= message[0].length)
         cMax = original[0].length;
      else
         cMax = message[0].length;
      
      // white = even red value, black = odd red value, 256 = 254
      for(int row = 0; row < rMax; row++)
      {
         for(int col = 0; col < cMax; col++)
         {
            int red = original[row][col].getRed();
            String messageColor = "white";
            if(message[row][col].getRed() < 30)
               messageColor = "black";
            
            // adjust red slightly sometimes
            if(messageColor.equals("white") && red % 2 != 0)
               red++;
            else if(messageColor.equals("black") && red % 2 == 0)
               red++;
            // if red would be 256, make it 254 instead
            if(red == 256)
               red = 254;
            
            // update the red value of the pixel
            original[row][col].setRed(red);
         }
      }
   }
   
 /**
   * Method to decode a message hidden in the
   * red value of the current picture
   * @return the picture with the hidden message (this)
   */
   public Picture decode()
   {
      // 2d arrays for **BOTH** pictures (ooh jazz hands)
      Pixel[][] original = this.getPixels2D();
      
      // even red value = white, odd red value = black
      for(int row = 0; row < original.length; row++)
      {
         for(int col = 0; col < original[0].length; col++)
         {
            int red = original[row][col].getRed();
            // if red is even, 255. if red is odd, 0
            int newColor = 255;
            if(red % 2 != 0)
               newColor = 0;
         
            
            // update the red pixel to reveal the secret message
            original[row][col].setRed(newColor);
            original[row][col].setGreen(newColor);
            original[row][col].setBlue(newColor);
         }
      }
      return this;
   }
   
 /**
   * Method to give half of the picture a random effect
   * and the other half of the picture another random effect
   * (negate, grayscale, sepia tone, blur, posterize, pixelate (resolution = 8), mirror LR, mirror TB, mirror diag, edge detector)
   */
   public void halfAndHalf()
   {
      Pixel[][] pixels = this.getPixels2D();
      Color[][] left = new Color[pixels.length][pixels[0].length];
      Color[][] right = new Color[pixels.length][pixels[0].length];
      
      // left and right will be copies of pixels
      for(int r = 0; r < pixels.length; r++)
      {
         for(int c = 0; c < pixels[0].length; c++)
         {
            left[r][c] = pixels[r][c].getColor();
            right[r][c] = pixels[r][c].getColor();
         }
      }
      //int l = (int)(Math.random() * 10);
      //int rr = (int)(Math.random() * 10);
      int l = 0;
      int rr = 6;
      
      if(l == 0) // negate
      {
         System.out.println("Left: Negate");
         for(int row = 0; row < left.length; row++)
         {
            for(int col = 0; col < left[0].length / 2; col++)
            {
               Color pixelObj = left[row][col];
               left[row][col] = new Color(255 - pixelObj.getRed(), 255 - pixelObj.getGreen(), 255 - pixelObj.getBlue());
            }
         }
      }
      else if(l == 1) // grayscale
      {
         System.out.println("Left: Grayscale");
         for(int row = 0; row < left.length; row++)
         {
            for(int col = 0; col < left[0].length / 2; col++)
            {
               Color pixelObj = left[row][col];
               double gray = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
               left[row][col] = new Color((int)gray, (int)gray, (int)gray);
            }
         } 
      }
      else if(l == 2) // sepia tone
      {
         System.out.println("Left: Sepia Tone");
         for(int row = 0; row < left.length; row++)
         {
            for(int col = 0; col < left[row].length / 2; col++)
            {
               Color pixelObj = left[row][col];
               int red = pixelObj.getRed();
               int green = pixelObj.getGreen();
               int blue = pixelObj.getBlue();
               
               int tempR = (int)((red * .393) + (green *.769) + (blue * .189));
               int tempG = (int)((red * .349) + (green *.686) + (blue * .168));
               int tempB = (int)((red * .272) + (green *.534) + (blue * .131));
               
               if(tempR > 255)
                  tempR = 255;
               if(tempG > 255)
                  tempG = 255;
               if(tempB > 255)
                  tempB = 255;
                  
               left[row][col] = new Color(tempR, tempG, tempB);
            }
         }
      }
      else if(l == 3) // blur
      {
         System.out.println("Left: Blur");
         Pixel[][] temp = this.getPixels2D();
      
         for(int row = 0; row < left.length; row++)
         {
            for(int col = 0; col < left[0].length / 2; col++)
            {
               int red = 0;
               int green = 0;
               int blue = 0;
               int reps = 0;
            
            // add up all of the color in this 3x3 zone
               for(int r = row - 1; r <= row + 1; r++)
               {
                  for(int c = col - 1; c <= col + 1; c++)
                  {
                     if(r < 0 || c < 0 || r >= left.length || c >= left[0].length)
                        continue;
                     red += left[r][c].getRed();
                     green += left[r][c].getGreen();
                     blue += left[r][c].getBlue();
                     reps++;
                  }
               }
            
            // set the temp variable so the new color isnt used in future tests
               temp[row][col].setRed(red / reps);
               temp[row][col].setGreen(green / reps);
               temp[row][col].setBlue(blue / reps);            
            }  
         }
      
         for(int row = 0; row < left.length; row++)
         {
            for(int col = 0; col < left[0].length; col++)
            {
               left[row][col] = temp[row][col].getColor();
            }
         }
      }
      else if(l == 4) // posterize
      {
         System.out.println("Left: Posterize");
         Color c1 = new Color(255, 100, 100);
         Color c2 = new Color(100, 255, 100);
         Color c3 = new Color(100, 100, 255);
      
         for(int row = 0; row < left.length; row++)
         {
            for(int col = 0; col < left[0].length / 2; col++)
            {
               double c1dist = pixels[row][col].colorDistance(c1);
               double c2dist = pixels[row][col].colorDistance(c2);
               double c3dist = pixels[row][col].colorDistance(c3);
               int edgeDist = 125;
            
               if(c1dist < edgeDist)
                  left[row][col] = c1;
               else if(c2dist < edgeDist)
                  left[row][col] = c2;
               else if(c3dist < edgeDist)
                  left[row][col] = c3;
               else
                  left[row][col] = new Color(100, 100, 100);
            }
         }
      }
      else if(l == 5) // pixelate
      {
         System.out.println("Left: Pixelate");
         int resolution = 8;
         
         for(int row = 0; row < left.length; row += resolution)
         {
            for(int col = 0; col < left[0].length / 2; col += resolution)
            {
               int red = 0;
               int green = 0;
               int blue = 0;
            
            // prevents indexOutOfBounds errors
               int rMax = 0;
               if(row + resolution > left.length - 1)
                  rMax = left.length - 1;
               else
                  rMax = row + resolution;
            
               int cMax = 0;
               if(col + resolution > left[0].length - 1)
                  cMax = left[0].length - 1;
               else
                  cMax = col + resolution;
            
            // add all of the RGB of the pixels in this big pixel
               for(int r = row; r <= rMax; r++)
               {
                  for(int c = col; c <= cMax; c++)
                  {
                     red += left[r][c].getRed();
                     green += left[r][c].getGreen();
                     blue += left[r][c].getBlue();
                  }
               }
            
            // average them all out and assign the averages to each pixel in the big pixel
               for(int r = row; r < rMax; r++)
               {
                  for(int c = col; c < cMax; c++)
                  {
                     int tempR = red / ((rMax - row) * (cMax - col));
                     int tempG = green / ((rMax - row) * (cMax - col));
                     int tempB = blue / ((rMax - row) * (cMax - col));
                     if(tempR > 255)
                        tempR = 255;
                     if(tempG > 255)
                        tempG = 255;
                     if(tempB > 255)
                        tempB = 255;
                     left[r][c] = new Color(tempR, tempG, tempB);
                  }
               }
            }
         }
      }
      else if(l == 6) // mirror RL
      {
         System.out.println("Left: Mirror (Right to Left)");
         int max = left[0].length - 1;
         for(int row = 0; row< left.length; row++)
         {
            for(int col = 0; col<=max / 2; col++)
            {
               left[row][col] = new Color((left[row][max - col].getRed()), (left[row][max - col].getGreen()), (left[row][max - col].getBlue()));
            }
         }
      }
      else if(l == 7) // mirror TB
      {
         System.out.println("Left: Mirror (Top to Bottom)");
         int max = left.length - 1;
         for(int col = 0; col< left[0].length / 2; col++)
         {
            for(int row = 0; row<=max / 2; row++)
            {
               left[max - row][col] = new Color((left[row][col].getRed()), (left[row][col].getGreen()), (left[row][col].getBlue()));
            }
         }
      }
      else if(l == 8) // mirror diag
      {
         System.out.println("Left: Mirror (Top Right to Bottom Left)");
         int rMax = pixels.length - 1;
         int cMax = pixels[0].length - 1;
         int max;
         if(rMax <= cMax)
            max = rMax;
         else
            max = cMax;
         for(int row = 0; row<= max; row++)
         {
            for(int col = 0; col<= max - row; col++)
            {
               left[row][max - col] = new Color(pixels[max - col][row].getRed(), pixels[max - col][row].getGreen(), pixels[max - col][row].getBlue());
            }
         }
      }
      else if(l == 9) // edge detector
      {
         System.out.println("Left: Edge Detector");
         for(int row = 0; row < left.length; row++)
         {
            for(int col = 0; col < (left[0].length - 1) / 2; col++)
            {
               double colorDistance = pixels[row][col].colorDistance(left[row][col + 1]);
               String current = "white";
               if(colorDistance > 10)
               {
                  if(current.equals("black"))
                  {
                     current = "white";
                     left[row][col] = new Color(255, 255, 255);
                  }
                  else
                  {
                     current = "black";
                     left[row][col] = new Color(0, 0, 0);
                  }
               }
               else
               {
                  if(current.equals("black"))
                  {
                     left[row][col] = new Color(0, 0, 0);
                  }
                  else
                  {
                     left[row][col] = new Color(255, 255, 255);
                  }
               }
            }
         }
      }
      
      // right half
      if(rr == 0) // negate
      {
         System.out.println("Right: Negate");
         for(int row = 0; row < right.length; row++)
         {
            for(int col = right[0].length / 2; col < right[0].length; col++)
            {
               Color pixelObj = right[row][col];
               right[row][col] = new Color(255 - pixelObj.getRed(), 255 - pixelObj.getGreen(), 255 - pixelObj.getBlue());
            }
         }
      }
      else if(rr == 1) // grayscale
      {
         System.out.println("Right: Grayscale");
         for(int row = 0; row < right.length; row++)
         {
            for(int col = right[0].length / 2; col < right[0].length; col++)
            {
               Color pixelObj = right[row][col];
               double gray = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
               right[row][col] = new Color((int)gray, (int)gray, (int)gray);
            }
         } 
      }
      else if(rr == 2) // sepia tone
      {
         System.out.println("Right: Sepia Tone");
         for(int row = 0; row < right.length; row++)
         {
            for(int col = right[0].length / 2; col < right[row].length; col++)
            {
               Color pixelObj = right[row][col];
               int red = pixelObj.getRed();
               int green = pixelObj.getGreen();
               int blue = pixelObj.getBlue();
               
               int tempR = (int)((red * .393) + (green *.769) + (blue * .189));
               int tempG = (int)((red * .349) + (green *.686) + (blue * .168));
               int tempB = (int)((red * .272) + (green *.534) + (blue * .131));
               
               if(tempR > 255)
                  tempR = 255;
               if(tempG > 255)
                  tempG = 255;
               if(tempB > 255)
                  tempB = 255;
                  
               right[row][col] = new Color(tempR, tempG, tempB);
            }
         }
      }
      else if(rr == 3) // blur
      {
         System.out.println("Right: Blur");
         Pixel[][] temp = this.getPixels2D();
      
         for(int row = 0; row < right.length; row++)
         {
            for(int col = right[0].length / 2; col < right[0].length; col++)
            {
               int red = 0;
               int green = 0;
               int blue = 0;
               int reps = 0;
            
            // add up all of the color in this 3x3 zone
               for(int r = row - 1; r <= row + 1; r++)
               {
                  for(int c = col - 1; c <= col + 1; c++)
                  {
                     if(r < 0 || c < 0 || r >= right.length || c >= right[0].length)
                        continue;
                     red += right[r][c].getRed();
                     green += right[r][c].getGreen();
                     blue += right[r][c].getBlue();
                     reps++;
                  }
               }
            
            // set the temp variable so the new color isnt used in future tests
               temp[row][col].setRed(red / reps);
               temp[row][col].setGreen(green / reps);
               temp[row][col].setBlue(blue / reps);            
            }  
         }
      
         for(int row = 0; row < right.length; row++)
         {
            for(int col = 0; col < right[0].length; col++)
            {
               right[row][col] = temp[row][col].getColor();
            }
         }
      }
      else if(rr == 4) // posterize
      {
         System.out.println("Right: Posterize");
         Color c1 = new Color(255, 100, 100);
         Color c2 = new Color(100, 255, 100);
         Color c3 = new Color(100, 100, 255);
      
         for(int row = 0; row < right.length; row++)
         {
            for(int col = right[0].length / 2; col < right[0].length; col++)
            {
               double c1dist = pixels[row][col].colorDistance(c1);
               double c2dist = pixels[row][col].colorDistance(c2);
               double c3dist = pixels[row][col].colorDistance(c3);
               int edgeDist = 125;
            
               if(c1dist < edgeDist)
                  right[row][col] = c1;
               else if(c2dist < edgeDist)
                  right[row][col] = c2;
               else if(c3dist < edgeDist)
                  right[row][col] = c3;
               else
                  right[row][col] = new Color(100, 100, 100);
            }
         }
      }
      else if(rr == 5) // pixelate
      {
         System.out.println("Right: Pixelate");
         int resolution = 8;
         
         for(int row = 0; row < right.length; row += resolution)
         {
            for(int col = right[0].length / 2; col < right[0].length; col += resolution)
            {
               int red = 0;
               int green = 0;
               int blue = 0;
            
            // prevents indexOutOfBounds errors
               int rMax = 0;
               if(row + resolution > right.length - 1)
                  rMax = left.length - 1;
               else
                  rMax = row + resolution;
            
               int cMax = 0;
               if(col + resolution > right[0].length - 1)
                  cMax = left[0].length - 1;
               else
                  cMax = col + resolution;
            
            // add all of the RGB of the pixels in this big pixel
               for(int r = row; r <= rMax; r++)
               {
                  for(int c = col; c <= cMax; c++)
                  {
                     red += right[r][c].getRed();
                     green += right[r][c].getGreen();
                     blue += right[r][c].getBlue();
                  }
               }
            
            // average them all out and assign the averages to each pixel in the big pixel
               for(int r = row; r < rMax; r++)
               {
                  for(int c = col; c < cMax; c++)
                  {
                     int tempR = red / ((rMax - row) * (cMax - col));
                     int tempG = green / ((rMax - row) * (cMax - col));
                     int tempB = blue / ((rMax - row) * (cMax - col));
                     if(tempR > 255)
                        tempR = 255;
                     if(tempG > 255)
                        tempG = 255;
                     if(tempB > 255)
                        tempB = 255;
                     right[r][c] = new Color(tempR, tempG, tempB);
                  }
               }
            }
         }
      }
      else if(rr == 6) // mirror RL
      {
         System.out.println("Right: Mirror (Right to Left)");
         int max = right[0].length - 1;
         for(int row = 0; row< right.length; row++)
         {
            for(int col = right[0].length / 2; col<=max / 2; col++)
            {
               right[row][col] = new Color((left[row][max - col].getRed()), (left[row][max - col].getGreen()), (left[row][max - col].getBlue()));
            }
         }
      }
      else if(rr == 7) // mirror TB
      {
         System.out.println("Right: Mirror (Top to Bottom)");
         int max = right.length - 1;
         for(int col = right[0].length / 2; col< right[0].length; col++)
         {
            for(int row = 0; row<=max / 2; row++)
            {
               right[max - row][col] = new Color((left[row][col].getRed()), (left[row][col].getGreen()), (left[row][col].getBlue()));
            }
         }
      }
      else if(rr == 8) // mirror diag
      {
         System.out.println("Right: Mirror (Top Left to Bottom Right)");
         int rMax = pixels.length - 1;
         int cMax = pixels[0].length - 1;
         int max;
         if(rMax <= cMax)
            max = rMax;
         else
            max = cMax;
         for(int row = 0; row<= max; row++)
         {
            for(int col = 0; col<= max - row; col++)
            {
               right[row][col] = new Color(pixels[max - col][max - row].getRed(), pixels[max - col][max - row].getGreen(), pixels[max - col][max - row].getBlue());
            }
         }
      }
      else if(rr == 9) // edge detector
      {
         System.out.println("Right: Edge Detector");
         for(int row = 0; row < right.length; row++)
         {
            for(int col = right[0].length / 2; col < right[0].length - 1; col++)
            {
               double colorDistance = pixels[row][col].colorDistance(left[row][col + 1]);
               String current = "white";
               if(colorDistance > 10)
               {
                  if(current.equals("black"))
                  {
                     current = "white";
                     right[row][col] = new Color(255, 255, 255);
                  }
                  else
                  {
                     current = "black";
                     right[row][col] = new Color(0, 0, 0);
                  }
               }
               else
               {
                  if(current.equals("black"))
                  {
                     right[row][col] = new Color(0, 0, 0);
                  }
                  else
                  {
                     right[row][col] = new Color(255, 255, 255);
                  }
               }
            }
         }
      }
      
      for(int r = 0; r < pixels.length; r++)
      {
         for(int c = 0; c < pixels[0].length; c++)
         {
            if(c < pixels[0].length / 2)
               pixels[r][c].setColor(left[r][c]);
            else
               pixels[r][c].setColor(right[r][c]);
         }
      }
      System.out.println();
   }
   
/** 
 * Main method for testing - each class in Java can have a main method
 * @param args 'cause, you know...we need this 
 */
   public static void main(String[] args) 
   {
      //Picture pix = new Picture(); // rg - this doesn't open a picture
      Picture pix = new Picture("640x480.jpg"); //- rg this explores the 640x480 in the images directory
      pix.explore();
   }

}
