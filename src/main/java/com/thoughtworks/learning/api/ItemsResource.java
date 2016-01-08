package com.thoughtworks.learning.api;

import com.mongodb.util.JSON;
import com.thoughtworks.learning.core.*;

import javax.inject.Inject;
import javax.ws.rs.*;
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
        System.out.println(allitems);
        return Response.status(200).entity(allitems).build();
    }

    @Path("/promotions")
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=utf8")
    public List get_promotions() {

        promotions_barcode.add("ITEM000000");
        promotions_barcode.add("ITEM000001");
        promotions_barcode.add("ITEM000005");
        promotion.put("type", "BUY_TWO_GET_ONE_FREE");
        promotion.put("barcodes", promotions_barcode);
        promotions.add(promotion);
        System.out.println(promotion);
        return promotions;
    }

    @Path("/inputs")
    @POST
    @Produces(MediaType.APPLICATION_JSON+";charset=utf8")
    public Response create(@FormParam("inputs") String inputs){
        Map result = new HashMap();
        Map newInstanceBean = new HashMap();
        newInstanceBean.put("inputs", inputs);

        itemsRepository.createInputsBarcode(newInstanceBean);

        result.put("inputs",newInstanceBean.get("inputs"));
        System.out.println(newInstanceBean.get("inputs"));
        return Response.status(201).entity(result).build();
    }

    @Path("/inputs")
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public Response get_inpinputs(){
        List<String> inputs=itemsRepository.findInputsBarcode();
        return Response.status(200).entity(inputs).build();
    }
}

//    @Path("/promotions")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON+";charset=utf8")
//    public Response get_promotions() {
//        List<Promotions> promotions = itemsRepository.findPromotions();
//        return Response.status(500).entity(promotions).build();
//    }