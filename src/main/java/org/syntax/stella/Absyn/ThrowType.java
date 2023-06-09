// File generated by the BNF Converter (bnfc 2.9.4.1).

package org.syntax.stella.Absyn;

public abstract class ThrowType implements java.io.Serializable {
  public abstract <R,A> R accept(Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(NoThrowType p, A arg);
    public R visit(SomeThrowType p, A arg);

  }

}
