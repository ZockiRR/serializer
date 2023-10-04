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



public interface XInsertingSequence<E> extends XExtendingSequence<E>
{
	public interface Creator<E> extends XExtendingSequence.Creator<E>
	{
		@Override
		public XInsertingSequence<E> newInstance();
	}



	public boolean insert(long index, E element);

	public boolean nullInsert(long index);

	@SuppressWarnings("unchecked")
	public long insertAll(long index, E... elements);

	public long insertAll(long index, E[] elements, int offset, int length);

	public long insertAll(long index, XGettingCollection<? extends E> elements);



	@SuppressWarnings("unchecked")
	@Override
	public XInsertingSequence<E> addAll(E... elements);

	@Override
	public XInsertingSequence<E> addAll(E[] elements, int srcStartIndex, int srcLength);

	@Override
	public XInsertingSequence<E> addAll(XGettingCollection<? extends E> elements);

	@SuppressWarnings("unchecked")
	@Override
	public XInsertingSequence<E> prependAll(E... elements);

	@Override
	public XInsertingSequence<E> prependAll(E[] elements, int srcStartIndex, int srcLength);

	@Override
	public XInsertingSequence<E> prependAll(XGettingCollection<? extends E> elements);

}
