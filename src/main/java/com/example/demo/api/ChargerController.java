package com.example.demo.api;

import com.example.demo.model.Charger;
import com.example.demo.model.TaskResponse;
import com.example.demo.service.ChargerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Joana on 18/1/2.
 */
@Controller
@RequestMapping("/api/v1/charger")
public class ChargerController {
    @Autowired
    private ChargerService chargerService;

    private static Logger logger = LoggerFactory.getLogger(ChargerController.class);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public TaskResponse getCharger(@RequestParam(name = "latitude") Float latitude,
                                   @RequestParam(name = "longitude") Float longitude){

        return chargerService.searchCharger(latitude,longitude);
   }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
   public TaskResponse addCharger(@RequestBody  Charger charger){
        return chargerService.addCharger(charger);
   }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
   public TaskResponse updateCharger(@RequestBody Charger charger){
        return chargerService.updateCharger(charger);
   }
    @RequestMapping(value = "/{chargerId}/**", method = RequestMethod.GET)
    @ResponseBody
   public TaskResponse getChargerById(@PathVariable("id") String chargerId ){
        return chargerService.getChargerById(chargerId);

   }
    @RequestMapping(value = "/{chargerId}/**", method = RequestMethod.POST)
    @ResponseBody
    public TaskResponse updateChargerById(@PathVariable("id") String chargerId,
                                          @RequestBody Charger charger){
        return chargerService.updateChargerById(chargerId,charger);

    }
    @RequestMapping(value = "/{chargerId}/**", method = RequestMethod.DELETE)
    @ResponseBody
    public TaskResponse deleteCharger(@PathVariable("id") String chargerId){
        return chargerService.deleteCharger(chargerId);
    }
}
