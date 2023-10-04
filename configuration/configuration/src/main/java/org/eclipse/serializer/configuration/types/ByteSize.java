package org.eclipse.serializer.configuration.types;

/*-
 * #%L
 * Eclipse Serializer Configuration
 * %%
 * Copyright (C) 2023 MicroStream Software
 * %%
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * #L%
 */

import static org.eclipse.serializer.math.XMath.notNegative;
import static org.eclipse.serializer.util.X.notNull;

import org.eclipse.serializer.math.XMath;


/**
 * Compound object which carries an amount paired with a {@link ByteUnit}.
 *
 */
public interface ByteSize extends Comparable<ByteSize>
{
	/**
	 * Gets the amount of this {@link ByteSize}.
	 * 
	 * @return the amount
	 */
	public double amount();
	
	/**
	 * Gets the unit of this {@link ByteSize}.
	 * 
	 * @return the unit
	 */
	public ByteUnit unit();
	
	/**
	 * 
	 * @return the total number of bytes which {@link #amount()} and {@link #unit()} yield
	 * @see ByteUnit#toBytes(double)
	 */
	public long bytes();
	
	/**
	 * Returns the amount followed by the unit, e.g 1.2MB.
	 * 
	 * @return a String representation of this byte size, which can be understood by {@link ByteSizeParser#parse(String)}
	 * 
	 * @see #New(String)
	 */
	@Override
	public String toString();

	
	/**
	 * Pseudo-constructor method which creates a new {@link ByteSize} object
	 * by calling {@link ByteSizeParser#parse(String)}.
	 * 
	 * @param value the String value wich can be understood by {@link ByteSizeParser#parse(String)}
	 * @return a newly created {@link ByteSize} object with the given value
	 * 
	 * @see ByteSizeParser
	 * @see ByteSizeParser#parse(String)
	 */
	public static ByteSize New(
		final String value
	)
	{
		return ByteSizeParser.New().parse(value);
	}
	
	/**
	 * Pseudo-constructor method which creates a new {@link ByteSize} object.
	 * 
	 * @param amount the amount
	 * @param unit the unit
	 * @return a newly created {@link ByteSize} object with the given values
	 */
	public static ByteSize New(
		final double   amount,
		final ByteUnit unit
	)
	{
		return new Default(
			notNegative(amount),
			notNull(unit)
		);
	}
	
	
	public static class Default implements ByteSize
	{
		private final double   amount;
		private final ByteUnit unit  ;
		private final long     bytes ;
		
		Default(
			final double   amount,
			final ByteUnit unit
		)
		{
			super();
			this.amount = amount              ;
			this.unit   = unit                ;
			this.bytes  = unit.toBytes(amount);
		}
		
		@Override
		public double amount()
		{
			return this.amount;
		}
		
		@Override
		public ByteUnit unit()
		{
			return this.unit;
		}
		
		@Override
		public long bytes()
		{
			return this.bytes;
		}
		
		@Override
		public int compareTo(
			final ByteSize other
		)
		{
			return Long.compare(this.bytes, other.bytes());
		}
		
		@Override
		public int hashCode()
		{
			return Long.hashCode(this.bytes);
		}
		
		@Override
		public boolean equals(
			final Object obj
		)
		{
			if(obj == this)
			{
				return true;
			}
			
			if(!(obj instanceof ByteSize))
			{
				return false;
			}
			
			final ByteSize other = (ByteSize)obj;
			return this.bytes == other.bytes();
		}
		
		@Override
		public String toString()
		{
			return XMath.isMathematicalInteger(this.amount)
				? Long.toString((long)this.amount) + this.unit.name()
				: Double.toString(this.amount)     + this.unit.name()
			;
		}
		
	}
	
}
