package org.eclipse.serializer.memory.android;

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

import org.eclipse.serializer.functional.DefaultInstantiator;
import org.eclipse.serializer.memory.DirectBufferDeallocator;
import org.eclipse.serializer.memory.MemoryAccessorGeneric;
import org.eclipse.serializer.memory.XMemory;


/**
 * Trivial setup wrapping class to simplify and document the different setup possibilities.
 *
 */
public final class AndroidAdapter
{
	
	/**
	 * Sets up the memory accessing logic to use {@link MemoryAccessorGeneric}.
	 * <p>
	 * {@link AndroidInstantiatorBlank} ist used as the {@link DefaultInstantiator} implementation.
	 * <p>
	 * {@link AndroidDirectBufferDeallocator} is used as the {@link DirectBufferDeallocator}.
	 * 
	 */
	public static final void setupFull()
	{
		XMemory.setMemoryAccessor(
			MemoryAccessorGeneric.New(
				AndroidInternals.InstantiatorBlank(),
				AndroidInternals.DirectBufferDeallocator()
			)
		);
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////
	// constructors //
	/////////////////

	/**
	 * Dummy constructor to prevent instantiation of this static-only utility class.
	 * 
	 * @throws UnsupportedOperationException when called
	 */
	private AndroidAdapter()
	{
		// static only
		throw new UnsupportedOperationException();
	}
	
}
