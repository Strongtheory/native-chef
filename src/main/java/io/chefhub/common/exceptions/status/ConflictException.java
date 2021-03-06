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
package io.chefhub.common.exceptions.status;

/**
 * <h1>{@link io.chefhub.common.exceptions.status.ConflictException}</h1>
 *
 * Custom exception for HTTP status 409.
 * <p>
 *
 * @author  NativeChef
 * @version 0.0.1
 * @since   0.0.1
 */
public final class ConflictException extends RuntimeException {

	// Default Constructor
	public ConflictException() {
		super();
	}

	// Message Constructor
	public ConflictException(final String message) {
		super(message);
	}

	// throw cause
	public ConflictException(final Throwable cause) {
		super(cause);
	}

	// Message, Cause
	public ConflictException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
