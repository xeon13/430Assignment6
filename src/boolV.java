
public class boolV extends Value {
   private String cas;
   
   public boolV(String cas) {
      this.cas = cas;
   }
   
   public String toString() {
      return this.cas;
   }
   
   public boolean equals(Object other) {
      if(this.cas.equals(other.toString())) {
         return true;
      }
      
      return false;
   }
}
