package br.gov.sspba.security;

import javax.el.ELContext;
import javax.el.ValueExpression;




public class ValueExpressionWrapper extends ValueExpression {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private ValueExpression wrapped;
	
	public ValueExpressionWrapper(ValueExpression wrapped)
    {
        this.wrapped = wrapped;
    }
	

	
	@Override
	public Object getValue(ELContext context) {
		// TODO Auto-generated method stub
		return wrapped.getValue(context);
	}

	@Override
	public void setValue(ELContext context, Object value) {
		// TODO Auto-generated method stub
		wrapped.setValue(context, value);
	}

	@Override
	public boolean isReadOnly(ELContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Class<?> getType(ELContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getExpectedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExpressionString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isLiteralText() {
		// TODO Auto-generated method stub
		return false;
	}

}
