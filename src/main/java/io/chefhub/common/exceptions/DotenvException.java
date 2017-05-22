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
package io.chefhub.common.exceptions;

/**
 * <h1>DotenvException</h1>
 *
 * Custom exception for dotenv package
 * if environment file does not exist or
 * is not defined.
 * <p>
 *
 * @author  NativeChef
 * @version 0.0.1
 * @since   0.0.1
 */
public class DotenvException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 7680618946891216558L;

	/**
	 * Default Constructor
	 */
	public DotenvException() {
		super();
	}

	/**
	 * Exception Constructor
	 *
	 * @param e - Exception thrown
	 */
	public DotenvException(Exception e) {
		super(e);
	}

	/**
	 * Message Constructor
	 *
	 * @param message - exception message
	 */
	public DotenvException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return super.getMessage();
	}
}
