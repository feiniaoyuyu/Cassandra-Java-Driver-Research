/*
 *      Copyright (C) 2012-2015 DataStax Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.datastax.driver.mapping.annotations;


import java.lang.annotation.ElementType;
import com.datastax.driver.mapping.Mapper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotates a "computed" field, which gets filled from a CQL expression in the SELECT query
 * used to retrieve an entity.
 * <p>
 * Note that such fields are only filled by default mapper operations ({@link Mapper#get(Object...)}),
 * they will be ignored in accessor queries and save operations.
 * <p>
 * As opposed to other mapper annotation, this one doesn't handle case sensitivity. If your expression
 * contains case-sensitive names, you'll need to quote them explicitly:
 * <pre>
 * {@code @Computed("\"caseSensitiveFunction\"(v)")}
 * </pre>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Computed {
    /**
     * The formula used to compute the field.
     * <p>
     * This is a CQL expression like you would use directly in a query, for instance
     * "writetime(v)".
     *
     * @return the formula.
     */
    String value();
}
