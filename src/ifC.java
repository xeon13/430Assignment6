
public class ifC extends ExprC {
   private ExprC cas;
   private ExprC trueCase;
   private ExprC falseCase;
   
   public ifC(ExprC cas, ExprC trueCase, ExprC falseCase) {
      this.cas = cas;
      this.trueCase = trueCase;
      this.falseCase = falseCase;
   }
   
   public ExprC getCase() {
      return this.cas;
   }
   
   public ExprC getTrue() {
      return this.trueCase;
   }
   
   public ExprC getFalse() {
      return this.falseCase;
   }
   
   public boolean equals(ifC other) {
      boolean casEqual = this.cas.equals(other.getCase());
      boolean trueEqual = this.trueCase.equals(other.getTrue());
      boolean falseEqual = this.falseCase.equals(other.getFalse());
      
      if (casEqual && trueEqual && falseEqual) {
         return true;
      }
      
      return false;
   }
}
