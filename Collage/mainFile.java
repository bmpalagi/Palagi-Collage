//Brad Palagi
//Main file

public class mainFile
{
    
    public static void main(String[] args)
    {
        //Make the canvas picture
        Picture pic = new Picture("canvas.jpg");
        
        //Creates the top middle image
        Picture two = new Picture("porsche.jpg");
        two.tripleFlip();
        pic.copy(two,1280,0);
        
        //Neapolitan
        Picture three = new Picture("porsche.jpg");
        three.Neapolitan();
        pic.copy(three,2560,0);
        
        //Runs the recursive method
        pic.copy("porsche.jpg",0,720);
        pic.recursive(9);
        
        //Average pixel values method
        pic.copyOnTop("porsche.jpg","lambo.jpg",1280,720);
        
        //Alternate image pixels method
        pic.copyOnTopMyWay("porsche.jpg","lambo.jpg",2560,720);
        
        //Rotate 180 degrees and grayscale
        Picture okay = new Picture("porsche.jpg");
        okay.gray();
        pic.flip(okay,0,1440);
        
        //Set Blue/Green values of each pixel to 255
        pic.blue("porsche.jpg",1280,1440);
        pic.green("porsche.jpg",2560,1440);
        
        //Put the base image in the top left
        pic.copy("porsche.jpg",0,0);
        
        //Display the collage
        pic.explore();
        
        //Save as an image file
        pic.write("images\\finalImage.jpg");
    }
}
