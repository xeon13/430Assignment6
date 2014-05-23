
public class boolC extends ExprC {
   private String cas;
   
   public boolC(String cas) {
      this.cas = cas;
   }
   
   public String getCase() {
      return this.cas;
   }
   
   public boolean equals(Object other) {
      if (this.cas.equals(((boolC) other).getCase())) {
         return true;
      }
      
      return false;
   }
}
