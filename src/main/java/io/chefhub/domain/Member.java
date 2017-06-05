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
package io.chefhub.domain;

import java.util.Properties;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import io.chefhub.common.DomainObject;

/**
 * <h1>{@link io.chefhub.domain.m
 * }</h1>
 *
 * Member node class with respective properties.
 * <p>
 * Extends {@link DomainObject} containing
 * the base methods for comparison and debugging.
 * <p>
 *
 * @author  NativeChef
 * @version 0.0.1
 * @since   0.0.1
 */
@NodeEntity
public class Member extends DomainObject {
	
	// Annotated Member Properties
	@GraphId
	private Long id;

	// Non-recycable id
	@Property
	private Long memberId;
	
	@Property
	private String email;
	
	@Property(name="password")
	private String encrypted_password;
	
	@Property(name="name")
	private String first_name;
	
	@Property(name="surname")
	private String last_name;
	
	@Property
	private String phone_number;
	
	@Property
	private int account_number;
	
	@Property
	private int routing_number;
	
	@Property
	private double account_balance;
	
	// Default Constructor
	public Member() {}
	
	// Properties Constructor
	public Member(Properties properties) {
	}


	/**
	 * @return id - id of the node
	 */
	@Override
	public Long getId() {
		return id;
	}
}