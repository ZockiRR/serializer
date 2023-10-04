package org.eclipse.serializer.collections.types;

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

import org.eclipse.serializer.collections.interfaces.ReleasingCollection;


public interface XPuttingSet<E> extends XPuttingCollection<E>, XAddingSet<E>, ReleasingCollection<E>
{
	public interface Creator<E> extends XPuttingCollection.Creator<E>, XAddingSet.Creator<E>
	{
		@Override
		public XPuttingSet<E> newInstance();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * In this implementation it overwrites equal, already contained elements.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public XPuttingSet<E> putAll(E... elements);

	/**
	 * {@inheritDoc}
	 * <p>
	 * In this implementation it overwrites equal, already contained elements.
	 */
	@Override
	public XPuttingSet<E> putAll(E[] elements, int srcStartIndex, int srcLength);

	/**
	 * {@inheritDoc}
	 * <p>
	 * In this implementation it overwrites equal, already contained elements.
	 */
	@Override
	public XPuttingSet<E> putAll(XGettingCollection<? extends E> elements);

	@SuppressWarnings("unchecked")
	@Override
	public XPuttingSet<E> addAll(E... elements);

	@Override
	public XPuttingSet<E> addAll(E[] elements, int srcStartIndex, int srcLength);

	@Override
	public XPuttingSet<E> addAll(XGettingCollection<? extends E> elements);

}
