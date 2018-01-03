package com.example.demo.service;

import com.example.demo.api.ChargerController;
import com.example.demo.mapper.ChargerMapper;
import com.example.demo.model.Charger;
import com.example.demo.model.TaskResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Joana on 18/1/2.
 */
@Service
public class ChargerService {

    @Autowired
    private ChargerMapper chargerMapper;

    private static Logger logger = LoggerFactory.getLogger(ChargerService.class);

    private enum State{
        USE("add",1),
        DELETE("close",0);
        private int value;
        private String description;

        State(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
    @Transactional
    public TaskResponse searchCharger(Float latitude,Float longitude){
        TaskResponse taskResponse = new TaskResponse();
        try{

//TODO

            taskResponse.setCode(200);
            taskResponse.setMessage("successful operation");
        }catch (Exception e){
            taskResponse.setCode(500);
            taskResponse.setMessage("failed");
            e.printStackTrace();
        }
        return taskResponse;
    }
    @Transactional
    public TaskResponse addCharger(Charger charger){
        TaskResponse taskResponse = new TaskResponse();
        Charger old = chargerMapper.selectByPrimaryKey(charger);
        if (old != null){
            taskResponse.setCode(405);
            taskResponse.setMessage("Charger exist,Invalid input");
            return taskResponse;
        }
        chargerMapper.insert(charger);
        taskResponse.setMessage("successful operation");
        taskResponse.setCode(200);
        return taskResponse;
    }
    //TODO 405啥子时候出现？？？
    @Transactional
    public TaskResponse updateCharger(Charger charger){
        TaskResponse taskResponse = new TaskResponse();

        Charger old = chargerMapper.selectByPrimaryKey(charger.getDeviceid());
        if (old == null){
            taskResponse.setCode(400);
            taskResponse.setMessage("charger not found,Invalid ID supplied");
            return taskResponse;
        }
        try {
            chargerMapper.insert(charger);
            taskResponse.setCode(200);
            taskResponse.setMessage("successful operation");
        }catch (Exception e){
            taskResponse.setCode(500);
            taskResponse.setMessage("server error");
        }
        return taskResponse;
    }
    @Transactional
    public TaskResponse getChargerById(String id){
        TaskResponse taskResponse = new TaskResponse();
        if(id == null || id.trim().equals("")){
            taskResponse.setCode(400);
            taskResponse.setMessage("Invalid ID supplied");
            return taskResponse;
        }
        Charger charger = chargerMapper.selectByPrimaryKey(id);
        if (charger == null){
            taskResponse.setCode(404);
            taskResponse.setMessage("charger not found");
            return taskResponse;
        }
        taskResponse.setCode(200);
        taskResponse.setMessage("successful operation");
        taskResponse.setData(charger);
        return taskResponse;
    }
    @Transactional
    public TaskResponse updateChargerById(String id,Charger charger){
        TaskResponse taskResponse = new TaskResponse();
        if(id == null || id.trim().equals("")){
            taskResponse.setCode(405);
            taskResponse.setMessage("Invalid ID supplied");
            return taskResponse;
        }
        if (charger.getDeviceid() != null)
            chargerMapper.insert(charger);
        chargerMapper.updateByPrimaryKeySelective(charger);
        taskResponse.setCode(200);
        taskResponse.setMessage("successful operation");
        return taskResponse;
    }
    @Transactional
    public TaskResponse deleteCharger(String id){
        TaskResponse taskResponse = new TaskResponse();
        if(id == null || id.trim().equals("")){
            taskResponse.setCode(400);
            taskResponse.setMessage("Invalid ID supplied");
            return taskResponse;
        }
        Charger charger = new Charger();
        charger.setDeviceid(id);
        charger.setState(State.USE.getValue());
        Charger old  = chargerMapper.selectOne(charger);
        if (old == null){
            taskResponse.setCode(404);
            taskResponse.setMessage("charger not found");
            return taskResponse;
        }
        charger.setState(State.DELETE.getValue());
        chargerMapper.insert(charger);
        taskResponse.setCode(200);
        taskResponse.setMessage("successful operation");
        return taskResponse;
    }
}
