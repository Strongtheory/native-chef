/**
 * Copyright {2017} NativeChef
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.chefhub.common;

import java.lang.reflect.Field;

import org.neo4j.ogm.annotation.GraphId;

/*
 * <h1>{@link io.chefhub.common.DomainObject}/h1>
 *
 * DomainObject class that implements
 * {@link io.chefhub.common.INode} node interface.
 * <p>
 * DomainObject is an abstract class that
 * contains the primary blueprint methods
 * for a standard POJO object.
 * <p>
 *
 *
 * @author  NativeChef
 * @version 0.0.1
 * @since   0.0.1
 */
public abstract class DomainObject implements INode {

	/**
	 * Custom Serial ID
	 */
	private static final long serialVersionUID = 913514459221724709L;

	@GraphId
	public Long id;

	/**
	 *
	 * @return true if object is of DomainNode
	 */
	@Override
	public boolean equals(Object o) {
		return this == o || !(o == null ||
				!(o instanceof INode)) &&
				this.compareTo((INode) o) == 0;
	}

	/**
	 * Compares this object with the specified object for order.  Returns a
	 * negative integer, zero, or a positive integer as this object is less
	 * than, equal to, or greater than the specified object.
	 * <p>
	 * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
	 * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
	 * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
	 * <tt>y.compareTo(x)</tt> throws an exception.)
	 * <p>
	 * <p>The implementor must also ensure that the relation is transitive:
	 * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
	 * <tt>x.compareTo(z)&gt;0</tt>.
	 * <p>
	 * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
	 * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
	 * all <tt>z</tt>.
	 * <p>
	 * <p>It is strongly recommended, but <i>not</i> strictly required that
	 * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
	 * class that implements the <tt>Comparable</tt> interface and violates
	 * this condition should clearly indicate this fact.  The recommended
	 * language is "Note: this class has a natural ordering that is
	 * inconsistent with equals."
	 * <p>
	 * <p>In the foregoing description, the notation
	 * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
	 * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
	 * <tt>0</tt>, or <tt>1</tt> according to whether the value of
	 * <i>expression</i> is negative, zero or positive.
	 *
	 * @param o the object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object
	 * is less than, equal to, or greater than the specified object.
	 * @throws NullPointerException if the specified object is null
	 * @throws ClassCastException   if the specified object's type prevents it
	 *                              from being compared to this object.
	 */
	private int compareTo(INode o) {
		return this.getId().compareTo(o.getId());
	}

	/**
	 * Used for debugging returning in this format:
	 *
	 * Var {
	 *   varName: value
	 *   ...
	 * }
	 * <p>
	 *
	 * @return result aggregated list of values of the class
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append(this.getClass().getName());
		result.append(" {");
		result.append(newLine);

		// Display class attributes of (this) class
		Field[] attributes = this.getClass().getDeclaredFields();

		// return attribute/value pairs
		for (Field field : attributes) {
			result.append("  ");
			try {
				result.append(field.getName());
				result.append(": ");
				// access private fields
				result.append(field.get(this));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			result.append(newLine);
		}
		result.append("}");
		return result.toString();
	}
}
