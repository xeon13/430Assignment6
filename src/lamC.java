import java.util.List;


public class lamC extends ExprC {
   private List<String> params;
   private ExprC body;
   
   public lamC(List<String> params, ExprC body) {
      this.params = params;
      this.body = body;
   }
   
   public List<String> getParams() {
      return this.params;
   }
   
   private ExprC getBody() {
      return this.body;
   }
}
