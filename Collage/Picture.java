//Brad Palagi
//Picture Project
//Collage

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
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
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
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
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

  public void gray() 
  {
    //copies all the pixels into an array; not the best way because it uses much memory
      Pixel[] pixelArray = this.getPixels();

      int avg;

        for (Pixel p : pixelArray)
        {
            int r = p.getRed();
            int g = p.getGreen();
            int b = p.getBlue();

            avg = ((r+g+b)/3);

            p.setColor(new Color(avg,avg,avg)); // by averaging the pixels rgb values it makes it gray
      }

  }

  public void copy(String fileName, int tx, int ty)
  {
      String sourceFile = fileName;
      Picture sourcePicture = new Picture(sourceFile);

      Pixel sourcePixel = null;
      Pixel targetPixel = null;
      for(int sourceX = 0, targetX = tx;sourceX<sourcePicture.getWidth();sourceX++,targetX++)
      {
          for (int sourceY = 0, targetY=ty; sourceY < sourcePicture.getHeight(); sourceY++,targetY++)
          {
              sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
              targetPixel = this.getPixel(targetX,targetY);
              targetPixel.setColor(sourcePixel.getColor()); //run through every pixel in the source file and transfer them onto the taget image
          }
      }
      
    }
    
  public void copy(Picture sourcePicture, int tx, int ty)
  {
      Pixel sourcePixel = null;
      Pixel targetPixel = null;
      for(int sourceX = 0, targetX = tx;sourceX<sourcePicture.getWidth();sourceX++,targetX++)
      {
          for (int sourceY = 0, targetY=ty; sourceY < sourcePicture.getHeight(); sourceY++,targetY++)
          {
              sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
              targetPixel = this.getPixel(targetX,targetY);
              targetPixel.setColor(sourcePixel.getColor()); // same as the other copy but this one takes a Picture object rather than string
          }
      }
      
    }

  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }
  
  //Mirror around a vertical line in the middle of the picture based on the width
  public void mirrorVertical()
  {
      int width = this.getWidth();
      int mirrorPoint = width/2;
      
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      
      //Loop through all the rows
      for(int y =0;y<getHeight();y++)
      {
          for(int x = 0; x<mirrorPoint; x++)
          {
              leftPixel = getPixel(x,y);
              rightPixel = getPixel(width-1-x,y);
              rightPixel.setColor(leftPixel.getColor()); // puts the left side on the right side
            }
        }
      
    }
  
  public void mirrorHorizontal()
  {
    int height = this.getHeight();
    int mirrorPoint = height/2;
    
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    for(int x = 0; x < getWidth();x++)
    {
        for(int y = 0; y<mirrorPoint;y++)
        {
            topPixel = getPixel(x,y);
            bottomPixel = getPixel(x,height-1-y);
            bottomPixel.setColor(topPixel.getColor()); // puts the top on the bottom as well
        }
    }
    }
  
  public void invertColors()
  {
      for (int x = 0; x < getWidth();x++)
      {
          for (int y = 0; y<getHeight();y++)
          {
              Pixel p = getPixel(x,y);
              p.setColor(new Color(Math.abs(255-p.getRed()),Math.abs(255-p.getGreen()),Math.abs(255-p.getBlue()))); // absolute value of 355 minus the rgb values
            }
        }
      
    }
  
  public void tripleFlip()
  {
      this.mirrorVertical();
      this.mirrorHorizontal();
      this.invertColors(); 
      //can call one method to call these three
    }
    
  public void Neapolitan()//Loops go through one third of the image to change the color
  {
      for (int x = 0; x< (getWidth() / 3); x++)
      {
          for (int y = 0; y<getHeight();y++)
          {
              Pixel p = getPixel(x,y);
              if (x%3==0)
              {
                  p.setColor(new Color(255,0,0));
                }
            }
        }
      
        for (int x = (getWidth() / 3); x< 2*(getWidth() / 3); x++)
      {
          for (int y = 0; y<getHeight();y++)
          {
              Pixel p = getPixel(x,y);
              if (x%3==0)
              {
                  p.setColor(new Color(165,42,42));
                }
            }
        }
      
      for (int x = 2*(getWidth() / 3); x< getWidth(); x++)
      {
          for (int y = 0; y<getHeight();y++)
          {
              Pixel p = getPixel(x,y);
              if (x%3==0)
              {
                  p.setColor(new Color(243, 229, 171));
                }
            }
        }
    }
  
  public void copySmall(Picture sourcePicture, int tx, int ty, int scale)
  {
      Pixel sourcePixel = null;
      Pixel targetPixel = null;
      for(int sourceX = 200, targetX = tx;sourceX<1000;sourceX+=scale,targetX++)
      {
          for (int sourceY = 200, targetY=ty; sourceY < 500; sourceY+=scale,targetY++)
          {
              sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
              targetPixel = this.getPixel(targetX,targetY);
              targetPixel.setColor(sourcePixel.getColor());
          }
      }
      
      //used in my recursive method to crop the image and scale it down
    }
  
  public void recursive(int scale)
  {
      if (scale==0)
      {
          return;
        }
      recursive(scale-1);
      
      Picture plz = new Picture("porsche.jpg");
      
      copySmall(plz,0,720,scale); // calls the copySmall method with a smaller scale each time
    }
  
  public void copyOnTop(String fileName, String fileName2, int tx, int ty)
  {
      String sourceFile = fileName;
      String sourceFile2 = fileName2;
      Picture sourcePicture = new Picture(sourceFile);
      Picture sourcePicture2 = new Picture(sourceFile2);
      
      Pixel sourcePixel = null;
      Pixel sourcePixel2 = null;
      Pixel targetPixel = null;
      for(int sourceX = 0, targetX = tx;sourceX<sourcePicture.getWidth();sourceX++,targetX++)
      {
          for (int sourceY = 0, targetY=ty; sourceY < sourcePicture.getHeight(); sourceY++,targetY++)
          {
              sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
              sourcePixel2 = sourcePicture2.getPixel(sourceX,sourceY);
              targetPixel = this.getPixel(targetX,targetY);
              targetPixel.setColor(new Color( (sourcePixel.getRed() + sourcePixel2.getRed())/2, (sourcePixel.getGreen()+sourcePixel2.getGreen())/2, (sourcePixel.getBlue()+sourcePixel2.getBlue())/2));
          }
      }
      //your copy on top idea
    }
    
  public void copyOnTopMyWay(String fileName, String fileName2, int tx, int ty)
  {
      String sourceFile = fileName;
      String sourceFile2 = fileName2;
      Picture sourcePicture = new Picture(sourceFile);
      Picture sourcePicture2 = new Picture(sourceFile2);
      
      Pixel sourcePixel = null;
      Pixel sourcePixel2 = null;
      Pixel targetPixel = null;
      for(int sourceX = 0, targetX = tx;sourceX<sourcePicture.getWidth();sourceX++,targetX++)
      {
          for (int sourceY = 0, targetY=ty; sourceY < sourcePicture.getHeight(); sourceY++,targetY++)
          {
              sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
              sourcePixel2 = sourcePicture2.getPixel(sourceX,sourceY);
              targetPixel = this.getPixel(targetX,targetY);
              
              if (targetX%4==0)
                    targetPixel.setColor(sourcePixel.getColor());
              else
                    targetPixel.setColor(sourcePixel2.getColor());
          }
      }
      //my copy on top idea
    }
    
    public void flip(Picture sourcePicture, int tx, int ty)
  {
      Pixel sourcePixel = null;
      Pixel targetPixel = null;
      Pixel temp = null;
      
      for(int sourceX = 0, targetX = tx, backX = sourcePicture.getWidth()-1;sourceX<sourcePicture.getWidth();sourceX++,targetX++,backX--)
      {
          for (int sourceY = 0, targetY=ty, backY = sourcePicture.getHeight()-1; sourceY < sourcePicture.getHeight(); sourceY++,targetY++,backY--)
          {
              sourcePixel = sourcePicture.getPixel(backX,backY);
              temp = sourcePicture.getPixel(sourceX,sourceY);
              targetPixel = this.getPixel(targetX,targetY);
              targetPixel.setColor(sourcePixel.getColor());
              
              sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
              targetPixel = this.getPixel(backX,backY);
              targetPixel.setColor(sourcePixel.getColor());
          }
      }
      //180 degree rotation
    }
  
  public void blue(String fileName, int tx, int ty)
  {
      String sourceFile = fileName;
      Picture sourcePicture = new Picture(sourceFile);

      Pixel sourcePixel = null;
      Pixel targetPixel = null;
      for(int sourceX = 0, targetX = tx;sourceX<sourcePicture.getWidth();sourceX++,targetX++)
      {
          for (int sourceY = 0, targetY=ty; sourceY < sourcePicture.getHeight(); sourceY++,targetY++)
          {
              sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
              targetPixel = this.getPixel(targetX,targetY);
              targetPixel.setColor(new Color(sourcePixel.getRed(),sourcePixel.getGreen(),255));
          }
      }
      //make blue 255
    }
  
    public void green(String fileName, int tx, int ty)
  {
      String sourceFile = fileName;
      Picture sourcePicture = new Picture(sourceFile);

      Pixel sourcePixel = null;
      Pixel targetPixel = null;
      for(int sourceX = 0, targetX = tx;sourceX<sourcePicture.getWidth();sourceX++,targetX++)
      {
          for (int sourceY = 0, targetY=ty; sourceY < sourcePicture.getHeight(); sourceY++,targetY++)
          {
              sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
              targetPixel = this.getPixel(targetX,targetY);
              targetPixel.setColor(new Color(sourcePixel.getRed(),255,sourcePixel.getBlue()));
          }
      }
      //make green 255
    }
} // this } is the end of class Picture, put all new methods before this