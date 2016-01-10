package com.thoughtworks.learning.api;

import com.mongodb.util.JSON;
import com.thoughtworks.learning.core.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/receipt")
public class ItemsResource {

    @Inject
    private ItemsRepository itemsRepository;

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

    @Path("/receipt_info")
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public Response get_inputs_info(){
        Map receipt = new HashMap();
        Map caculate = new HashMap();
        List<ItemsInfo> inputsInfo = itemsRepository.findInputsInfo();
        List<ItemsInfo> giftsInfo = itemsRepository.findGiftInfo();
        Double caculateInputs = itemsRepository.caculateInputs();
        Double caculateGifts = itemsRepository.caculateGifts();

        caculate.put("Sum",caculateInputs-caculateGifts);
        caculate.put("gifts_price",caculateGifts);

        receipt.put("Order",inputsInfo);
        receipt.put("Gift",giftsInfo);
        receipt.put("Caculate",caculate);
        return Response.status(200).entity(receipt).build();
    }

//    @Path("/gifts_info")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
//    public Response get_gifts_info(){
//        List<ItemsInfo> giftsInfo = itemsRepository.findGiftInfo();
//
//        return Response.status(200).entity(giftsInfo).build();
//    }
//
//    @Path("/caculate")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
//    public Response get_caculate(){
//        Map caculate = new HashMap();
//        Double caculateInputs = itemsRepository.caculateInputs();
//        Double caculateGifts = itemsRepository.caculateGifts();
//        caculate.put("total",caculateInputs-caculateGifts);
//        caculate.put("saved",caculateGifts);
//        return Response.status(200).entity(caculate).build();
//    }
//    下列过程为在客户端js文件中计算时进行的数据传输
//    @Inject
//    private ItemsRepository itemsRepository;
//    @Path("/allitems")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
//    public Response get_allitems(){
//        List<Items> allitems = itemsRepository.findItems();
//
//        return Response.status(200).entity(allitems).build();
//    }
//
//    @Path("/promotions")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
//    public Response get_promotions(){
//        List<String> promotions=itemsRepository.findPromotions();
//        List result = new ArrayList();
//        Map newInstanceBean = new HashMap();
//
//        newInstanceBean.put("type", "BUY_TWO_GET_ONE_FREE");
//        newInstanceBean.put("barcodes",promotions);
//        result.add(newInstanceBean);
//
//        return Response.status(200).entity(result).build();
//    }
//
//    @Path("/inputs")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON+";charset=utf8")
//    public Response create(@FormParam("inputs") String inputs){
//        Map result = new HashMap();
//        Map newInstanceBean = new HashMap();
//        newInstanceBean.put("inputs", inputs);
//        itemsRepository.createInputsBarcode(newInstanceBean);
//
//        result.put("inputs",newInstanceBean.get("inputs"));
//        System.out.println(newInstanceBean.get("inputs"));
//        return Response.status(201).entity(result).build();
//    }
//
//    @Path("/inputs")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
//    public Response get_inpinputs(){
//        List<String> inputs=itemsRepository.findInputsBarcode();
//
//        return Response.status(200).entity(inputs).build();
//    }
}