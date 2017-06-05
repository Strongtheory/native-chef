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

import org.neo4j.driver.v1.Driver;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.transaction.Transaction;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>{@link GenericOperation}</h1>
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
public class GenericOperation {

	// Class Logger
	private static final Logger LOGGER = Logger.
			getLogger(GenericOperation.class.getName());

	/**
	 * Retrieve node object by referencing id and class.
	 * Load node class and id through transaction.
	 * <p>
	 * 
	 * @param domainMap - map object with passed in domain id and class
	 * @return			- node that is referenced
	 */
	public static DomainObject getNodeObject(Map<String, Object> domainMap) {
		Long id = (Long) domainMap.get("id");
		@SuppressWarnings("unchecked")
		Class<DomainObject> domainClass = (Class<DomainObject>) domainMap.get("class");
		// Start Class Transaction
		Transaction tx = null;
		DomainObject objectNode = null;
		Session sess;
		try {
			sess = ConnectionDriver.getSessionInstance();
			LOGGER.log(Level.INFO, "Obtain and open session instance.");
			tx = sess.beginTransaction();
			LOGGER.log(Level.INFO, "Begin session transaction");
			objectNode = sess.load(domainClass, id);
			LOGGER.log(Level.INFO, "Load node class and node id");
			tx.commit();
			LOGGER.log(Level.INFO, "Explicitly commit the transaction instance.");
		} catch (Exception e) {
			// TODO: Handle custom exception.
			if (tx != null)
				tx.rollback();
			LOGGER.log(Level.SEVERE, "Could not load class: " + domainClass.toString(), e);
		} finally {
			if (tx != null)
				tx.close();
			LOGGER.log(Level.INFO, "Close transaction instance.");
		}
		return objectNode;
	}

	/**
	 * Create node transaction with session and persist (save) node.
	 * <p>
	 *
	 * @param objectNode - node being persisted through transaction
	 * @return			 - true: Create transaction and save node
	 * 					   false: exception caught in session
	 */
	public static boolean persistObject(DomainObject objectNode) {
		// Start Class Transaction
		Session sess;
		Transaction tx = null;
		try {
			sess = ConnectionDriver.getSessionInstance();
			LOGGER.log(Level.INFO, "Obtain and open session instance.");
			tx = sess.beginTransaction();
			LOGGER.log(Level.INFO, "Begin session transaction.");
			sess.save(objectNode);
			LOGGER.log(Level.INFO, "Saving node");
			tx.commit();
			LOGGER.log(Level.INFO, "Explicitly commit transaction instance.");
			return true;
		} catch (Exception e) {
			// TODO: Handle custom exception.
			if (tx != null)
				tx.rollback();
			LOGGER.log(Level.SEVERE, "Failed to save object instance. Rollback transaction.");
		} finally {
			if (tx != null)
				tx.close();
			LOGGER.log(Level.INFO, "Close transaction instance.");
		}
		return false;
	}

	/**
	 * Run cypher query and write or read from database.
	 * <p>
	 * TODO: Require read/write permissions before issuing
	 * statement!
	 * <p>
	 *
	 * @param cypherQuery - Cypher query statement
	 * @return			  - true: successful query
	 * 					  - false: exception, session failed to run
	 */
	public static boolean executeQuery(String cypherQuery) throws IllegalAccessException {
		Driver driver;
		org.neo4j.driver.v1.Session sess = null;
		try {
			driver = ConnectionDriver.getDriverConnectionInstance();
			LOGGER.log(Level.INFO, "Obtain driver instance and establish connection.");
			sess = driver.session();
			LOGGER.log(Level.INFO, "Obtain driver session instance.");
			sess.run(cypherQuery);
			LOGGER.log(Level.INFO, "Run Query: " + cypherQuery);
			return true;
		} catch (Exception e) {
			// TODO: Handle custom exception.
			LOGGER.log(Level.SEVERE, "Failed to create driver instance.", e);
		} finally {
			if (sess != null)
				sess.close();
			LOGGER.log(Level.INFO, "Close session instance.");
			ConnectionDriver.closeDriverConnection();
			LOGGER.log(Level.INFO, "Close driver connection.");
		}
		return false;
	}

	/**
	 * Create object transaction with session and delete node.
	 * <p>
	 *
	 * @param objectNode - node to delete
	 * @return			 - true: delete object node
	 * 					 - false: exception, session failed to run
	 */
	public static boolean deleteObject(DomainObject objectNode) {

		return false;
	}
}
