package icons;
import javax.swing.Icon;
//Mick Zeller

public class Balloon {

  //declaring object of class size
  private Size size;
  private boolean helium;
  private Icon icon;

  //Overloaded constructor without icons
  public Balloon(Size s, boolean h){
    this.size = s;
    this.helium = h;
  }
  //second overloaded constructor with icons
  public Balloon(Size s, boolean h, Icon i){
    this.size = s;
    this.helium = h;
    this.icon = i;
  }
  public Size getSize() {
    return size;
  }
  public boolean isHelium() {
    return helium;
  }
  public Icon getIcon() {
    return icon;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (helium ? 1231 : 1327);
    result = prime * result + ((size == null) ? 0 : size.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o)
      return true;
    if(o == null)
      return false;
    if(!(o instanceof Balloon))
      return false;
    Balloon other = (Balloon)o;
    if(helium != other.helium)
        return false;
    if(size != other.size)
        return false;
      return true;
  }

    @Override
    public String toString() {
      return (helium ? "Helium" : "Air") + " " + size;
    }
}
