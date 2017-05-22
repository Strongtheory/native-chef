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

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.exception.ExceptionUtils;

import io.chefhub.common.exceptions.DotenvException;
import io.chefhub.common.Variables;

/**
 * <h1>NativeChefInstance</h1>
 *
 * Helper class that creates a
 * {@link io.chefhub.common.environment.DotenvDriver}
 * instance. Provides helper methods to retrieve each
 * key values.
 * <p>
 *
 * @author  NativeChef
 * @version 0.0.1
 * @since   0.0.1
 */
public class EnvironmentInstance {

	// Class Logger
	private final static Logger LOGGER = Logger.
			getLogger(EnvironmentInstance.class.getName());

	// Default
	public EnvironmentInstance() {}

	/**
	 * Creates a DotenvDriver instance with the correct
	 * location of the .env file.
	 * <p>
	 *
	 * @return dotenv - configured instance of DotenvDriver
	 */
	public static Dotenv createDotenvInstance() {
		try {
			LOGGER.log(Level.INFO, "Create Dotenv instance "
					+ "with location of nativechef.env file.");
			return new DotenvInstance().
					envLocation("src/main/resources").
					createInstance();
		} catch (DotenvException e) {
			LOGGER.log(Level.SEVERE, "Did not file",
					ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *
	 * @param env              - configured Dotenv instance
	 * @return                 - URI
	 * @throws DotenvException - invalid value
	 */
	public static String retrieveURI(Dotenv env) throws DotenvException {
		return env.retrieveVariable(Variables.URI.getVal());
	}

	/**
	 *
	 * @param env              - configured Dotenv instance
	 * @return                 - driver
	 * @throws DotenvException - invalid value
	 */
	public static String retrieveDRIVER(Dotenv env) throws DotenvException {
		return env.retrieveVariable(Variables.DRIVER.getVal());
	}

	/**
	 *
	 * @param env              - configured Dotenv instance
	 * @return                 - driver
	 * @throws DotenvException - invalid value
	 */
	public static String retrieveUSERNAME(Dotenv env) throws DotenvException {
		return env.retrieveVariable(Variables.USERNAME.getVal());
	}
}
