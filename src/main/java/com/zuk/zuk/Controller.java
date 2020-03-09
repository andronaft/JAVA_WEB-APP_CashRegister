package com.zuk.zuk;

import com.zuk.zuk.service.impl.GoodServiceImpl;
import com.zuk.zuk.service.impl.TransactionServiceImpl;
import com.zuk.zuk.service.impl.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
}
