package org.eclipse.serializer.persistence.binary.types;

/*-
 * #%L
 * Eclipse Serializer Persistence Binary
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

import org.eclipse.serializer.persistence.types.PersistenceStoreHandler;

public interface BinaryValueStorer
{
	public long storeValueFromMemory(
		Object                          source       ,
		long                            sourceOffset ,
		long                            targetAddress,
		PersistenceStoreHandler<Binary> persister
	);
}
