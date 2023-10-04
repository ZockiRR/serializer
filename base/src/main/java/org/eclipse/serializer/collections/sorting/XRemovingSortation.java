package org.eclipse.serializer.collections.sorting;

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

import org.eclipse.serializer.collections.types.XRemovingSequence;

public interface XRemovingSortation<E> extends XRemovingSequence<E>, Sorted<E>
{
	public interface Factory<E> extends XRemovingSequence.Factory<E>
	{
		@Override
		public XRemovingSortation<E> newInstance();
	}

}
