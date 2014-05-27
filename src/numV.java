
public class numV extends Value {
   private double n;
   
   public numV(double n) {
      this.n = n;
   }
   
   public String toString() {
      return "" + this.n;
   }
   
   public double getNumber() {
       return n;
   }
   
   public boolean equals(Object other) {
      if (this.toString().equals(other.toString())) {
         return true;
      }
      
      return false;
   }
}
