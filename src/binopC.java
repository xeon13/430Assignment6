
public class binopC extends ExprC {
   private String opName;
   private ExprC left;
   private ExprC right;
   
   public binopC(String opName, ExprC left, ExprC right) {
      this.opName = opName;
      this.left = left;
      this.right = right;
   }

   public String getOpName() {
      return opName;
   }

   public ExprC getLeft() {
      return left;
   }

   public ExprC getRight() {
      return right;
   }
}
