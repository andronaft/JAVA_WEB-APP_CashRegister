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
        return goodService.findAll();
    }

    @RequestMapping("/findAllTransaction")
    @ResponseBody
    String findAllTransaction() {
        return transactionService.findAll();
    }

    @RequestMapping("/findAllWorker")
    @ResponseBody
    String findAllWorker() {
        return workerService.findAll();
    }

    @RequestMapping("/saveGood")
    @ResponseBody
    String saveGood(@RequestBody GoodEntity good){
        goodService.save(good);
        return "good";
    }

    @RequestMapping("/saveTransaction")
    @ResponseBody
    String saveTransaction(@RequestBody TransactionEntity transactionEntity){
        return transactionService.save(transactionEntity);
    }

    @RequestMapping("/saveWorker")
    @ResponseBody
    String saveWorker(@RequestBody WorkerEntity workerEntity){
        return workerService.save(workerEntity);
    }

    @RequestMapping("/findByLogin")
    @ResponseBody
    String findByLogin(@RequestParam String login){
        return  workerService.findByLogin(login);
    }

    @RequestMapping("/login")
    @ResponseBody
    String login(@RequestParam String login, @RequestParam String password) {
        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setLogin(login);
        workerEntity.setPassword(password);
        return  workerService.login(workerEntity);
    }

    @RequestMapping("/register")
    @ResponseBody
    String login(@RequestBody WorkerEntity workerEntity) {
        return  workerService.register(workerEntity);
    }
}
