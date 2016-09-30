package keyValuePair1;
/**
 * Project: Lab Key Value Pair
 * Name: Mick Zeller 
 * Date: 4/17/2015.
 */
class KeyValuePair<Key,Value>
{
   private Key k;
   private Value v;

   public Key getK() {
      return k;
   }

   public void setK(Key k) {
      this.k = k;
   }

   public KeyValuePair(Key k,Value v)
   {
      this.k = k;
      this.v = v;
   
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) 
         return true;
      if (!(o instanceof KeyValuePair)) 
         return false;
   
      KeyValuePair<?, ?> that = (KeyValuePair<?, ?>) o;
   
      if (k != null ? !k.equals(that.k) : that.k != null) 
         return false;
      return !(v != null ? !v.equals(that.v) : that.v != null);
   
   }

   @Override
   public int hashCode() {
      int result = k != null ? k.hashCode() : 0;
      result = 31 * result + (v != null ? v.hashCode() : 0);
      return result;
   }

   @Override
   public String toString() {
      return "(" + k + ", " + v + ")";
   }
}
