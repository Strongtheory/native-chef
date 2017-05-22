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

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.exception.ExceptionUtils;

import io.chefhub.common.exceptions.DotenvException;

/**
 * <h1>DotenvDriver</h1>
 *
 * Driver class for loading
 * and validating value pairs
 * from a local or remote .env
 * file
 * <p>
 *
 * @author  NativeChef
 * @version 0.0.1
 * @since   0.0.1
 */
public class DotenvDriver implements Dotenv {

	// Class Logger
	private final Logger LOGGER = Logger.getLogger(DotenvDriver.class.getName());

	// .env location
	private String location;

	// key,value pairs in the .env location
	private Map<String, String> variables;

	// Constructor
	public DotenvDriver(String location) {
		setLocation(location);
	}

	/**
	 *
	 * @param location - the location to set
	 */
	private void setLocation(String location) {
		this.location = location;
	}

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
	@Override
	public void validateFileIntegrity() throws DotenvException {
		variables = new HashMap<>();
		try {
			String fileContent = new String(Files.
					readAllBytes(Paths.get(location + "/native-chef.env")));
			String[] lineContent = fileContent.split("\n");
			for (String line : lineContent) {
				String[] lineProp = line.split("=");
				// Invalid Format
				if (lineProp.length != 2) {
					LOGGER.log(Level.SEVERE, "Improper format entry");
					throw new DotenvException("Incorrect format entry");
				}
				LOGGER.log(Level.INFO, "Put key: " +
						lineProp[0] + ", value: " + lineProp[1]);
				variables.put(lineProp[0], lineProp[1]);
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					ExceptionUtils.getStackTrace(e));
			throw new DotenvException(e);
		}
	}

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
	@Override
	public String retrieveVariable(String envVar) throws DotenvException {
		if (variables == null)
			validateFileIntegrity();
		String value = variables.get(envVar);
		if (value == null) {
			LOGGER.log(Level.SEVERE, "Key value not found in .env file.");
			throw new DotenvException("Key value not found in .env file.");
		} else {
			LOGGER.log(Level.INFO, "Key value loaded from .env file. " + value);
		}
		return value;
	}

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
	@Override
	public String updateVariable(String key) throws DotenvException {
		// TODO Auto-generated method stub
		return null;
	}
}
