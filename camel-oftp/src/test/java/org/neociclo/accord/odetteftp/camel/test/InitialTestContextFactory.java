/**
 * Neociclo Accord, Open Source B2B Integration Suite

 * Copyright (C) 2005-2010 Neociclo, http://www.neociclo.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * $Id$
 */
package org.neociclo.accord.odetteftp.camel.test;

import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.camel.util.jndi.CamelInitialContextFactory;

public class InitialTestContextFactory extends CamelInitialContextFactory {

	private static Hashtable<String, Object> beans = new Hashtable<String, Object>();

	public static void addBean(String name, Object bean) {
		beans.put(name, bean);
	}

	@Override
	public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
		Context initialContext = super.getInitialContext(environment);

		for (Map.Entry<String, Object> e : beans.entrySet()) {
			initialContext.bind(e.getKey(), e.getValue());
		}

		return initialContext;
	}
}
