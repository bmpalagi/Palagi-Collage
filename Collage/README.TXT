Brad Palagi

Picture Collage Project // To see the final jpg image go to the Final Image folder
    I couldn't figure out how to write the image into the Collage folder and had to create a new one.

Top Left:

This is my starting image with nothing done to it.

Top Middle:

This one is called the triple flip. 

The first flip was when it gets mirrored vertically. The next flip is when it gets mirrored horizontally. 
The third flip is when the colors are inverted. The invertColors method has a double for loop which goes
through each pixel in a Picture and takes the absolute value of 255 minus each red, blue and green value
this causes the color of the image to be flipped.

Top Right:

This method is called Neapolitan because it is made to look like the Neapolitan ice cream because of the 
three colors representing straberry vanilla and chocolate being blended into the image of the porsche.

Middle Left:

This is my recursive method and starts with the normal image, although I have slightly modified this 
because when run with the basic image the recursive part only shows the pavement around the car. To
fix this issue I have cropped the image to single out just the car and not the background. Technically
the first image on top of the base image is the same size as the base it's just been cropped. After
that the recurive method begins. First the method checks to make sure the image is not too small and
unable to be seen. Then it runs the method with scale-1, it will shrink the image to the point that 
it is unable to be seen, then it begins to go back down the ladder and paint the images. The scale 
is used to decide how much the sourceX and sourceY go up each time through the loops.

Middle Middle:

This method is where I copy a picture of a lamborghini on top of my base picture. This one is down 
with your idea of taking the pixels of each image, and averging the red blue and green values. I
think this way looks really nice.

Middle Right:

This method is my own idea of how to put a picture in a picture. I alternated the pixels taking one
pixel from my base porsche image and then the next pixel from the lamborghini image. I think this way
makes more sense conceptually and I understand how it works more, but it doesn't look quite as good
because you can see the streaky lines.

Bottom Left:

This image is a 180 degree rotation or a vertical flip. I've done this by having a third pixel called
temp. In the for loops I have added the variables backX and backY which are used to have the indexs
of the opposite pixels so they can be switched with the first pixels. On top of that I applied the
gray method to take the color out of the image by averaging the red blue and green values for each 
pixel.

Bottom Middle:

This simple method just takes each pixel and sets the blue value to 255.

Bottom Right:

This simple method just takes each pixel and sets the green value to 255.
