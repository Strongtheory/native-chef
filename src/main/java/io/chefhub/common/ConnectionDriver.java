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

import io.chefhub.common.environment.Dotenv;
import io.chefhub.common.exceptions.DotenvException;
import org.neo4j.driver.v1.Driver;

/**
 * <h1>{@link io.chefhub.common.ConnectionDriver}</h1>
 *
 * GraphFactory class provides the necessary
 * connection methods to establish a link between
 * the neo4j chalk graphene database to the application
 * service context.
 * <p>
 *
 * @author  NativeChef
 * @version 0.0.1
 * @since   0.0.1
 */
class ConnectionDriver {

	// ConnectionDriver Instance
	private static ConnectionDriver _driver;

	// Dotenv Instance
	private static Dotenv dotenvInstance;

	// Constructor
	private ConnectionDriver() {}

	private Driver createConnection() throws DotenvException {
		return null;
	}
}
