package org.itsallcode.openfasttrace.importer.specobject.handler;

/*-
 * #%L
 * OpenFastTrace Specobject Importer
 * %%
 * Copyright (C) 2016 - 2019 itsallcode.org
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import org.itsallcode.openfasttrace.api.core.SpecificationItemId.Builder;
import org.itsallcode.openfasttrace.api.importer.ImportEventListener;
import org.itsallcode.openfasttrace.importer.specobject.xml.tree.CallbackContentHandler;
import org.itsallcode.openfasttrace.importer.specobject.xml.tree.TreeContentHandler;

class ProvidesCoverageHandlerBuilder
{
    private final ImportEventListener listener;
    private final CallbackContentHandler handler;
    private Builder providesCoverageIdBuilder;

    ProvidesCoverageHandlerBuilder(final ImportEventListener listener)
    {
        this.listener = listener;
        this.handler = new CallbackContentHandler();
    }

    TreeContentHandler build()
    {
        this.handler.addElementListener("provcov",
                elem -> this.providesCoverageIdBuilder = new Builder(), //
                endElem -> {
                    this.listener.addCoveredId(this.providesCoverageIdBuilder.build());
                    this.providesCoverageIdBuilder = null;
                });

        this.handler.addCharacterDataListener("linksto",
                data -> this.providesCoverageIdBuilder.name(data));
        this.handler.addIntDataListener("dstversion",
                data -> this.providesCoverageIdBuilder.revision(data));

        return this.handler;
    }
}
