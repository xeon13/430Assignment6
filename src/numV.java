
public class numV extends Value {
   private double n;
   
   public numV(double n) {
      this.n = n;
   }
   
   public String toString() {
      return "" + this.n;
   }
   
   public boolean equals(numV other) {
      if (this.toString().equals(other.toString())) {
         return true;
      }
      
      return false;
   }
}
