/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2010-2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.thoughtworks.learning.api;

import com.thoughtworks.learning.core.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("items")
public class ItemsResource {

    HashMap promotion = new HashMap();
    List promotions = new ArrayList();
    List promotions_barcode = new ArrayList();

    @Inject
    private ItemsRepository itemsRepository;
    @Path("/allitems")
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public Response get_allitems(){
        List<Items> allitems = itemsRepository.findItems();
        return Response.status(200).entity(allitems).build();
    }

    @Path("/promotions")
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=utf8")
    public Response get_promotions() {
        List<Promotions> promotions = itemsRepository.findPromotions();
        return Response.status(200).entity(promotions).build();
    }
}

//    HashMap items0 = new HashMap();
//    HashMap items1 = new HashMap();
//    HashMap items2 = new HashMap();
//    HashMap items3 = new HashMap();
//    HashMap items4 = new HashMap();
//    HashMap items5 = new HashMap();
//    List allitems = new ArrayList();
//    @Path("/allitems")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON+";charset=utf8")
//    public List get_allitems(){
//
//        items0.put("barcode", "ITEM000000");
//        items0.put("name", "可口可乐");
//        items0.put("unit", "瓶");
//        items0.put("price", 3.00);
//        allitems.add(items0);
//
//        items1.put("barcode", "ITEM000001");
//        items1.put("name", "雪碧");
//        items1.put("unit", "瓶");
//        items1.put("price", 3.00);
//        allitems.add(items1);
//
//        items2.put("barcode", "ITEM000002");
//        items2.put("name", "苹果");
//        items2.put("unit", "斤");
//        items2.put("price", 5.50);
//        allitems.add(items2);
//
//        items3.put("barcode", "ITEM000003");
//        items3.put("name", "荔枝");
//        items3.put("unit", "斤");
//        items3.put("price", 15.00);
//        allitems.add(items3);
//
//        items4.put("barcode", "ITEM000004");
//        items4.put("name", "电池");
//        items4.put("unit", "个");
//        items4.put("price", 2.00);
//        allitems.add(items4);
//
//        items5.put("barcode", "ITEM000005");
//        items5.put("name", "方便面");
//        items5.put("unit", "袋");
//        items5.put("price", 4.00);
//        allitems.add(items5);
//        return allitems;
//    }