package com.sapient.trading.controllers;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.sapient.trading.models.BlockForOrderManagement;
import com.sapient.trading.models.Order;
import com.sapient.trading.repos.BlockCreationRepo;
import com.sapient.trading.repos.OrderCreationRepo;
import com.sapient.trading.repos.PortfolioRetrieveRepo;
import com.sapient.trading.repos.UserSession;

@Controller
public class OrderManagementController {

	Random rand = new Random();
    //CompanyReceiver compReceiver;
    private int orderID = 0;
    private int blockID = 0;
    Order order;
    BlockForOrderManagement block;
    private String manager="";
    boolean res = false;
    String orderid;
    String blockid;
    String blockName;
    List<Order> listOfOrders;
    List<String> portfolioList;
    @Autowired
    UserSession session;
    
    @RequestMapping(path="/createOrder",method=RequestMethod.GET)
    public String receive(Model model, 
    @RequestParam("company")String companyName,
    @RequestParam("price")String companyPrice, 
    @RequestParam("ticker")String companyTicker) {
    manager =session.getUser().getUserId();
    PortfolioRetrieveRepo prr = new PortfolioRetrieveRepo();
    portfolioList = prr.retrieveList(manager);
    String[] portfolioArray = portfolioList.toArray(new String[0]);
    model.addAttribute("portfolioArray", portfolioArray);
    model.addAttribute("cname", companyName);
        model.addAttribute("price", companyPrice);
        model.addAttribute("ticker", companyTicker);
        model.addAttribute("isOrdersPage", false);
        model.addAttribute("activeTab", 1);
        blockName = companyName;
        //model.addAttribute("profileType", session.getAuthorities().getAccountType());
        //model.addAttribute("name", session.getUser().getUsername());

        return "CreateOrder";
    }
    @RequestMapping(path="/createOrder",method=RequestMethod.POST)
    public String createOrder(Model model, 
            @RequestParam("portfolioID")String portfolioID,
            //@RequestParam("company")Company company,
            @RequestParam("ticker")String ticker,
            @RequestParam("compName")String compName,
            @RequestParam("Buy/Sell")String side,
            @RequestParam("type")String type,
            @RequestParam("totalQuantity")int totalQuantity,
            @RequestParam("currentPrice")float limitPrice,
            @RequestParam("stopPrice")float stopPrice) {
        
    manager =session.getUser().getUserId();
    Date timeCreated = new Date(System.currentTimeMillis());
        blockid = Math.abs(rand.nextInt(1000))+"";
        

        OrderCreationRepo ocr = new OrderCreationRepo();
        ArrayList<Order> listOfOrders = new ArrayList<>();
        manager = session.getUser().getUserId();
        if(totalQuantity>10000) {
            
            int num= totalQuantity/10000;
            int quant = totalQuantity%10000;
            if(totalQuantity%10000>0)
                num++;
            for(int i =0;i<num;i++) {
                orderid= Integer.toString(Math.abs(rand.nextInt())).substring(0, 3);
                if(i==num-1) {
                    quant = totalQuantity%10000;
               
                }else {
                    quant = 10000;
                }
                order = new Order(orderid, ticker, side, type, quant, compName, 
                        manager, portfolioID, 0, limitPrice, timeCreated, limitPrice, stopPrice);
                res = ocr.saveOrder(order);
                listOfOrders.add(order);
                orderID++;
                
            }

           
            block = new BlockForOrderManagement(blockid,blockName,listOfOrders);
            
            BlockCreationRepo bcr = new BlockCreationRepo();
            res = bcr.updateBlockOrder(block);
            res = bcr.updateBlockDetails(block);
            
        } else {
        	
            orderid= Integer.toString(Math.abs(rand.nextInt())).substring(0, 3);

            order = new Order(orderid, ticker, side, type, totalQuantity, compName, 
                    manager, portfolioID, 0, limitPrice, timeCreated, limitPrice, stopPrice);
            res = ocr.saveOrder(order);
            
            System.out.println("result from create " + res);
            
          
        }
        
      
        
        
        
        
        
        return "redirect:/mvc/Homepage";
    }
    
    
}



