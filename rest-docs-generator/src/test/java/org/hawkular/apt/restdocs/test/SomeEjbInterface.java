/*
 * RHQ Management Platform
 * Copyright (C) 2005-2012 Red Hat, Inc.
 * All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.hawkular.apt.restdocs.test;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiError;
import com.wordnik.swagger.annotations.ApiErrors;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 * Another example of @Api* usage
 *
 * @author Heiko W. Rupp
 */
@Api(value = "My important business EJB", basePath = "http://localhost:9999/other_path")
@Local
@Produces({"application/json", "application/xml", "text/html"})
@Consumes({"application/json"})
@Path("/biz-ejb")
public interface SomeEjbInterface {

    @ApiOperation(value = "Gives the current status", responseClass = "com.acme.MyResponse", notes = "bla bla")
    @ApiErrors({
            @ApiError(code = 404, reason = "If there is no resource or group with the passed id "),
            @ApiError(code = 409, reason = " Resource type does not match the group one")
    })
    @GET
    @Path("/")
    Response getStatus(@Context HttpHeaders httpHeaders);

    @ApiOperation(value = "Returns hello world", notes = "<xml><simpara>This is XML</simpara></xml>")
    @GET
    @Path("/hello")
    public String helloWorld();

    @ApiOperation(value = "Returns hello world", notes = "<xml><simpara>This is XML</simpara></xml><xml>Bla</xml>")
    @GET
    @Path("/hello2")
    public String helloBogusWorld();

    @ApiOperation(value = "Returns hello world", notes = "<simpara>This is XML</simpara>")
    @GET
    @Path("/hello3")
    public String helloBogusWorld2();
}
