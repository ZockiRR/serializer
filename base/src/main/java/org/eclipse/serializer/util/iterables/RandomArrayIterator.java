package org.eclipse.serializer.util.iterables;

/*-
 * #%L
 * Eclipse Serializer Base
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

import org.eclipse.serializer.math.XMath;

import java.util.Iterator;


/**
 * {@link Iterator} implementation of a random array element retrieval generator.
 * <p>
 * Usage example:<pre><code>
 * for(final Integer i : random(10, array(1,3,5,7,9)))
 * {
 *     System.out.println(i);
 * }</code></pre>
 * prints (for example):<br>
 * 7<br>
 * 3<br>
 * 1<br>
 * 3<br>
 * 3<br>
 * 3<br>
 * 9<br>
 * 7<br>
 * 1<br>
 * 7<br>
 *
 * 
 *
 */
public final class RandomArrayIterator<E> implements Iterator<E>
{
	///////////////////////////////////////////////////////////////////////////
	// static methods //
	///////////////////

	public static <E> Factory<E> random(final int count, final E[] array)
	{
		return new Factory<>(array, count);
	}



	///////////////////////////////////////////////////////////////////////////
	// instance fields //
	////////////////////

	private final E[] array;
	private final int length;
	private int count;
	private int c;



	///////////////////////////////////////////////////////////////////////////
	// constructors //
	/////////////////

	public RandomArrayIterator(final E[] array, final int count)
	{
		super();
		this.array = array;
		this.length = array.length;
		this.count = count;
		this.c = 0;
	}



	///////////////////////////////////////////////////////////////////////////
	// getters //
	////////////

	public int getCount()
	{
		return this.count;
	}



	///////////////////////////////////////////////////////////////////////////
	// setters //
	////////////

	public RandomArrayIterator<E> setCount(final int count)
	{
		this.count = count;
		return this;
	}



	///////////////////////////////////////////////////////////////////////////
	// declared methods //
	/////////////////////

	public RandomArrayIterator<E> incrementCount(final int amount)
	{
		this.count += amount;
		return this;
	}

	public RandomArrayIterator<E> decrementCount(final int amount)
	{
		this.count -= amount;
		return this;
	}

	/**
	 * Aborts the random iteration and returns the iteration count this {@link RandomArrayIterator}
	 * has produced until now.
	 *
	 * @see #getIterationCount()
	 * @return the current iteration count.
	 */
	public int abort()
	{
		final int c = this.c;
		this.c = this.count;
		return c;
	}

	/**
	 * Returns the iteration count this {@link RandomArrayIterator} has produced until now.
	 *
	 * @see #abort()
	 * @return the current iteration count.
	 */
	public int getIterationCount()
	{
		return this.c;
	}



	///////////////////////////////////////////////////////////////////////////
	// override methods //
	/////////////////////

	/**
	 * @see Iterator#hasNext()
	 */
	@Override
	public boolean hasNext()
	{
		return this.c < this.count;
	}


	/**
	 * @see Iterator#next()
	 */
	@Override
	public E next()
	{
		final E e = this.array[XMath.random(this.length)];
		this.c++;
		return e;
	}

	/**
	 *
	 * @throws UnsupportedOperationException because this operation is not supported
	 * @see Iterator#remove()
	 */
	@Override
	public void remove() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}


	public static final class Factory<E> implements Iterable<E>
	{
		///////////////////////////////////////////////////////////////////////////
		// instance fields //
		////////////////////

		private final E[] array;
		private int count;



		///////////////////////////////////////////////////////////////////////////
		// constructors //
		/////////////////

		public Factory(final E[] array, final int count)
		{
			super();
			this.array = array;
			this.count = count;
		}



		///////////////////////////////////////////////////////////////////////////
		// getters //
		////////////

		public int getCount()
		{
			return this.count;
		}



		///////////////////////////////////////////////////////////////////////////
		// setters //
		////////////

		public Factory<E> setCount(final int count)
		{
			this.count = count;
			return this;
		}



		///////////////////////////////////////////////////////////////////////////
		// declared methods //
		/////////////////////

		public Factory<E> incrementCount(final int amount)
		{
			this.count += amount;
			return this;
		}

		public Factory<E> decrementCount(final int amount)
		{
			this.count -= amount;
			return this;
		}



		///////////////////////////////////////////////////////////////////////////
		// methods //
		////////////

		/**
		 * @see Iterable#iterator()
		 */
		@Override
		public RandomArrayIterator<E> iterator()
		{
			return new RandomArrayIterator<>(this.array, this.count);
		}

	}

}
