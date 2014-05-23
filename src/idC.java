
public class idC extends ExprC {
   private String s;
   
   public idC(String s) {
      this.s = s;
   }
   
   public String getSymbol() {
      return this.s;
   }
   
   public boolean equals(Object other) {
      if (this.s.equals(((idC) other).getSymbol())) {
         return true;
      }
      
      return false;
   }
}
