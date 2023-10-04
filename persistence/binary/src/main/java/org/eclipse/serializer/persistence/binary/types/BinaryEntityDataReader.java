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

import java.nio.ByteBuffer;

public interface BinaryEntityDataReader
{
	/**
	 * Expects a raw memory address pointing to the location of an entity raw binary data, starting with its header.
	 *
	 * @param entitiesData the buffer to read from
	 */
	public void readBinaryEntities(ByteBuffer entitiesData);
}
