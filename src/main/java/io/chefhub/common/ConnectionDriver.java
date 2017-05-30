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

import java.net.URISyntaxException;
import java.sql.SQLException;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import io.chefhub.common.environment.Dotenv;
import io.chefhub.common.environment.EnvironmentInstance;
import io.chefhub.common.exceptions.DotenvException;

import java.net.URISyntaxException;

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
	private ConnectionDriver() throws DotenvException, ClassNotFoundException,
			IllegalAccessException, InstantiationException, URISyntaxException {}

	/**
	 * Sets a connection to the BOLT
	 * Graphene database hosted on heroku.
	 * <p>
	 *
	 * @throws URISyntaxException     - URI syntax invalid
	 * @throws IllegalAccessException - Unauthorized access
	 * @throws InstantiationException - Could not load access
	 * @throws ClassNotFoundException - Could not find bolt driver
	 * @throws DotenvException        - failed to retrieve var from .env file
	 * @return driver                 - Established connection to the bolt database URI.
	 */
	private Driver createConnection() throws DotenvException, URISyntaxException,
			ClassNotFoundException, InstantiationException, IllegalAccessException {
		// Prepare an environment instance
		dotenvInstance = EnvironmentInstance.createDotenvInstance();
		// Set Variables
		String graphenedbURL  = EnvironmentInstance.retrieveBoltUrl(dotenvInstance);
		String graphenedbUser = EnvironmentInstance.retrieveBoltUser(dotenvInstance);
		String graphenedbPass = EnvironmentInstance.retrieveBoltPassword(dotenvInstance);
		// Return GraphDatabase driver instance
		return GraphDatabase.driver(graphenedbURL, AuthTokens.basic(graphenedbUser, graphenedbPass));
	}
	
	/**
	 * Create driver and establish connection by calling
	 * createConnection() method.
	 * <p>
	 *
	 * @throws URISyntaxException     - URI syntax invalid
	 * @throws IllegalAccessException - Unauthorized access
	 * @throws InstantiationException - Could not load access
	 * @throws ClassNotFoundException - Could not find bolt driver
	 * @throws DotenvException        - failed to retrieve var from .env file
	 * @return driver                 - connected driver instance
	 */
	public static Driver getDriverInstance() throws DotenvException, URISyntaxException,
			ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (_driver == null) _driver = new ConnectionDriver();
		return _driver.createConnection();
	}
	
	/**
	 * Opens an active session to the database.
	 * <p>
	 * 
	 * @throws DotenvException - failed to retrieve variable to .env file
	 * @return sessionFactory  - opens a new database session with SessionFactory
	 */
	public static Session getSessionFactory() throws DotenvException {
		
		return null;
	}
}
