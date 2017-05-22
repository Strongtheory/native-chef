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

/**
 * <h1>Variables</h1>
 *
 * Enum class of all the key, value pairs
 * in the .env file. Loaded through
 * custom .env instace.
 * <p>
 *
 * @author  NativeChef
 * @version 0.0.1
 * @since   0.0.1
 */
public enum Variables {
	URI("URI"),
	DRIVER("driver"),
	USERNAME("username"),
	PASSWORD("password");

	private String val;

	Variables(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}
}
