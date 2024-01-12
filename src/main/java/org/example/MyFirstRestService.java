/*
 *                C O P Y R I G H T  (c) 2022
 *                        DEDALUS SPA
 *                    All Rights Reserved
 *
 *
 *      THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
 *                        DEDALUS SPA
 *     The copyright notice above does not evidence any
 *    actual or intended publication of such source code.
 */
package org.example;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("public/family")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@RequestScoped
public class MyFirstRestService {

    @GET
    public String getWelcomeMessage() {
        return "Welcome";
    }

    @GET
    @Path("shalwin")
    public String getWelcomeMessageShalwin() {
        return "Welcome Shalwin";
    }

    @PUT
    @Path("new/family/member/{newmembername}")
    public String addNewFamilyMember (@PathParam ("newmembername") String newmembername) {
        return "Welcome "+newmembername;

    }

}
