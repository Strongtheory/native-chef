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

import java.util.Map;
import java.util.logging.Logger;

/**
 * <h1>{@link io.chefhub.common.StandardOperation}</h1>
 *
 * Contains method stubs and definitions
 * for each standard REST operation
 * for all domain nodes. (i.e Persisting
 * Object, creating object, retrieving object,
 * execute cypher query)
 * <p>
 *
 * @author  NativeChef
 * @version 0.0.1
 * @since   0.0.1
 */
public class StandardOperation {

	// Class Logger
	private final Logger LOGGER = Logger.
			getLogger(StandardOperation.class.getName());

	/**
	 * Retrieve node object by referencing id and class.
	 * <p>
	 * 
	 * @param domainMap - map object with passed in domain id and class
	 * @return			- node that is referenced
	 */
	public static DomainObject getNodeObject(Map<String, Object> domainMap) {
		return null;
	}
}
