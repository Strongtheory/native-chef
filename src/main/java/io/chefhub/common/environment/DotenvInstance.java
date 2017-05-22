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
 * <h1>DotenvInstance</h1>
 *
 * Dotenv instance class that creates
 * the primary instance for reading
 * in the .env file from a local or
 * global location.
 * <p>
 *
 * @author  NativeChef
 * @version 0.0.1
 * @since   0.0.1
 */
public class DotenvInstance {

	// Root Folder
	private String location = System.getProperty("user.dir");

	// Default Constructor
	public DotenvInstance() {}

	/**
	 * Finds the location of the .env file
	 * in the directory starting from the root project.
	 * <p>
	 *
	 * @param location  - preset location
	 * @return location - location of .env file
	 */
	public DotenvInstance envLocation(String location) {
		if (!location.endsWith("/"))
			location += "/";
		setLocation(location);
		return this;
	}

	/**
	 * Creates a Dotenv instance to
	 * establish a relationship with the driver.
	 * <p>
	 *
	 * @return DotenvDriver instance - Provided object with methods to extract information.
	 * @throws DotenvException       - Invalid .env file or cannor access file.
	 */
	public Dotenv createInstance() throws DotenvException {
		return new DotenvDriver(location);
	}

	/**
	 *
	 * @param location - the location to set
	 */
	private void setLocation(String location) {
		this.location = location;
	}
}
