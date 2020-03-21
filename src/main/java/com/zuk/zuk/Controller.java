package com.zuk.zuk;

import com.zuk.zuk.entity.GoodEntity;
import com.zuk.zuk.entity.TransactionEntity;
import com.zuk.zuk.entity.WorkerEntity;
import com.zuk.zuk.service.impl.GoodServiceImpl;
import com.zuk.zuk.service.impl.TransactionServiceImpl;
import com.zuk.zuk.service.impl.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    private final GoodServiceImpl goodService;
    private final TransactionServiceImpl transactionService;
    private final WorkerServiceImpl workerService;

    @Autowired
    public Controller(@Qualifier("GoodServiceImpl") GoodServiceImpl goodService, @Qualifier("TransactionServiceImpl") TransactionServiceImpl transactionService, @Qualifier("WorkerServiceImpl") WorkerServiceImpl workerService){
        this.goodService = goodService;
        this.transactionService = transactionService;
        this.workerService = workerService;
    }

    @Autowired
    JsonStringMaker jsonStringMaker;

    @RequestMapping("/")
    @ResponseBody
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @RequestMapping("/findAllGood")
    @ResponseBody
    String findAllGood() {
        return jsonStringMaker.listToJson(goodService.findAll());
    }

    @RequestMapping("/findAllTransaction")
    @ResponseBody
    String findAllTransaction() {
        return jsonStringMaker.listToJson(transactionService.findAll());
    }

    @RequestMapping("/findAllWorker")
    @ResponseBody
    String findAllWorker() {
        return jsonStringMaker.listToJson(workerService.findAll());
    }

    @RequestMapping("/saveGood")
    @ResponseBody
    String saveGood(@RequestBody GoodEntity good){
        goodService.save(good);
        return "good";
    }

    @RequestMapping("/saveTransaction")
    @ResponseBody
    String saveTransaction()//@RequestBody TransactionEntity transactionEntity){
    {
        TransactionEntity  transactionEntity = new TransactionEntity();
        transactionService.save(transactionEntity);
        return "good";
    }

    @RequestMapping("/saveWorker")
    @ResponseBody
    String saveWorker(@RequestBody WorkerEntity workerEntity){
        workerService.save(workerEntity);
        return "good";
    }

    @RequestMapping("/findByLogin")
    @ResponseBody
    String findByLogin(@RequestParam String login)//@RequestBody WorkerEntity workerEntity){
    {
        return  workerService.findByLogin(login);
    }

}
