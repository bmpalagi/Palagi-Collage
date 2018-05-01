public class mainFile
{
    
    public static void main(String[] args)
    {
        Picture pic = new Picture("canvas.jpg");
        pic.copy("porsche.jpg",0,0);
        
        Picture two = new Picture("porsche.jpg");
        two.tripleFlip();
        pic.copy(two,1280,0);
        
        Picture three = new Picture("porsche.jpg");
        three.Neapolitan();
        pic.copy(three,2560,0);
        pic.copy("porsche.jpg",0,720);
        pic.copy("porsche.jpg",1280,720);
        pic.copy("porsche.jpg",2560,720);
        pic.copy("porsche.jpg",0,1440);
        pic.copy("porsche.jpg",1280,1440);
        pic.copy("porsche.jpg",2560,1440);
        pic.explore();
      
    }
}
