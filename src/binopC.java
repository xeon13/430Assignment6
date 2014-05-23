
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
   
   public boolean equals(binopC other) {
      boolean opEquals = this.opName.equals(other.getOpName());
      boolean leftEquals = this.left.equals(other.getLeft());
      boolean rightEquals = this.right.equals(other.getRight());
      
      if (opEquals && leftEquals && rightEquals) {
         return true;
      }
      
      return false;
   }
}
