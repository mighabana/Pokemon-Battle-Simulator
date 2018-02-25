
import java.io.IOException;
import java.io.Serializable;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

/**
 * This class is used in replacement of BufferedImages in order for it to become serializable and passable within the Object Input/Output Streams
 *
 */
public class DMSRecord implements Serializable{

  private long          id;
  private String        name;
  private BufferedImage image;
  
  public DMSRecord()
  {
	  id = 0;
	  name = "";
	  image = null;
  }

  public long getId(){
	  return id;
	  }
  public void setId(long id){
	  this.id=id;
	  }

  public String getName(){
	  return name;
	  }
  
  public void setName(String str){
	  this.name=str;
	  }

  public BufferedImage getImage(){
	  return image;
	  }
  public void setImage(BufferedImage image){
	  this.image=image;
	  }


  private void writeObject(java.io.ObjectOutputStream out)throws IOException{
    out.writeObject(name);
    ImageIO.write(image,"png",ImageIO.createImageOutputStream(out));
  }

  private void readObject(java.io.ObjectInputStream in)throws IOException, ClassNotFoundException{
    name=(String)in.readObject();
    image=ImageIO.read(ImageIO.createImageInputStream(in));
  }
}