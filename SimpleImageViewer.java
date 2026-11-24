/*
Taken from a tutorial online
https://www.javacodegeeks.com/a-simple-java-image-viewer.html
*/
public class SimpleImageViewer
{
   public SimpleImageViewer()
   {
      this.setTitle("Axis and Allies 1914");
      this.setSize();
   }
}

public class ImagePanel extends JPanel
{
   @Override
   protected void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      if(image == null) return;
      
      AffineTransform at = g2d.getTransform();
      
      // Apply image transformation matrix
      g2d.translate(offsetX, offsetY);
      g2d.scale(zoomFacter, zoomFacter);
      g2d.drawImage(image, 0, 0, null);
      
      g2d.setTransform(at);
   }
}