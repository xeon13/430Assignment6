
public class numC extends ExprC {
   private double n;
   
   public numC(double n) {
      this.n = n;
   }
   
   public double getNumber() {
      return this.n;
   }
   
   public boolean equals(Object other) {
      return this.n == ((numC) other).getNumber();
   }
}
