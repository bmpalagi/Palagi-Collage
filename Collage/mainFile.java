public class mainFile
{
    
    public static void main(String[] args)
    {
        Picture pic = new Picture("canvas.jpg");
               
        Picture two = new Picture("porsche.jpg");
        two.tripleFlip();
        pic.copy(two,1280,0);
        
        Picture three = new Picture("porsche.jpg");
        three.Neapolitan();
        pic.copy(three,2560,0);
        
        pic.copy("porsche.jpg",0,720);
        pic.recursive(9);
        
        pic.copyOnTop("porsche.jpg","lambo.jpg",1280,720);
        
        pic.copyOnTopMyWay("porsche.jpg","lambo.jpg",2560,720);
        
        Picture okay = new Picture("porsche.jpg");
        okay.gray();
        pic.flip(okay,0,1440);
        
        pic.blue("porsche.jpg",1280,1440);
        pic.green("porsche.jpg",2560,1440);
        
        pic.copy("porsche.jpg",0,0);
        
        pic.explore();
        
        pic.write("finalcollege.jpg");
    }
}
