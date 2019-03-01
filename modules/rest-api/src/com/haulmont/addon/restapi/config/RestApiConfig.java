/*
 * Copyright (c) 2008-2016 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.addon.restapi.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.DefaultBoolean;
import com.haulmont.cuba.core.config.type.CommaSeparatedStringListTypeFactory;
import com.haulmont.cuba.core.config.type.Factory;

import java.util.List;

/**
 * REST-API config.
 */
@Source(type = SourceType.APP)
public interface RestApiConfig extends Config {
    @Property("restapi.trustedClientPassword")
    String getTrustedClientPassword();

    /**
     * @return authorized rest client id
     */
    @Property("restapi.rest.client.id")
    String getRestClientId();

    @Property("restapi.rest.standardAuthenticationEnabled")
    @DefaultBoolean(true)
    boolean getStandardAuthenticationEnabled();

    /**
     * @return list of users that are not allowed to use external authentication. They can use only standard authentication.
     *         Empty list means that everyone is allowed to login using external authentication.
     */
    @Property("restapi.rest.standardAuthenticationUsers")
    @Factory(factory = CommaSeparatedStringListTypeFactory.class)
    List<String> getStandardAuthenticationUsers();

    /**
     * @return anonymous access to REST API is allowed
     */
    @Property("restapi.rest.anonymousEnabled")
    @DefaultBoolean(false)
    boolean getRestAnonymousEnabled();

    /**
     * @return token masking in application logs is enabled
     */
    @Property("restapi.rest.tokenMaskingEnabled")
    @DefaultBoolean(true)
    boolean getTokenMaskingEnabled();

    /**
     * @return whether the passed entities versions should be validated before entities are persisted
     */
    @Property("restapi.rest.optimisticLockingEnabled")
    @DefaultBoolean(false)
    boolean getOptimisticLockingEnabled();


    /**
     * @return Whether to use an login/password authentication on client
     * instead of login/password authentication on middleware.
     */
    @Property("restapi.checkPasswordOnClient")
    @DefaultBoolean(false)
    boolean getCheckPasswordOnClient();
}