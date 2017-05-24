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
package io.chefhub.common.environment;

import io.chefhub.common.exceptions.DotenvException;

/**
 * <h1>{@link io.chefhub.common.environment.Dotenv}</h1>
 *
 * Custom dotenv interface containing
 * method stubs and declarations for
 * .env file loading and validations.
 * <p>
 *
 * @author  NativeChef
 * @version 0.0.1
 * @since   0.0.1
 */
public interface Dotenv {

	/**
	 * Validates integrity of .env file.
	 * Make sure that the file exists and key-value
	 * pair entries are valid.
	 * <p>
	 * Add key,values to hashmap.
	 * <p>
	 *
	 * @throws DotenvException - .env file is corrupted or invalid
	 */
	void validateFileIntegrity() throws DotenvException;

	/**
	 * Load environment variable from .env file locally.
	 * <p>
	 * Environment variable file should not be committed
	 * to the repository!
	 * <p>
	 *
	 * @param envVar           - File environment variable name
	 * @return env             - environment variable value or null
	 * @throws DotenvException - Environment variable can't be loaded
	 */
	String retrieveVariable(String envVar) throws DotenvException;

	/**
	 * Update environment variable from .env file locally
	 * <p>
	 * Environment variable file should not be committed
	 * to the repository!
	 * <p>
	 *
	 * @param key              - File environment variable name
	 * @return env             - environment variable value or null
	 * @throws DotenvException - Environment variable can't be loaded
	 */
	String updateVariable(String key) throws DotenvException;
}
