
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
   
   public boolean equals(Object other) {
      boolean opEquals = this.opName.equals(((binopC) other).getOpName());
      boolean leftEquals = this.left.equals(((binopC) other).getLeft());
      boolean rightEquals = this.right.equals(((binopC) other).getRight());
      
      if (opEquals && leftEquals && rightEquals) {
         return true;
      }
      
      return false;
   }
}
