package top.qianxinyao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.qianxinyao.main.Main;
import top.qianxinyao.model.News;
import top.qianxinyao.service.RecService;

import java.util.List;

@Controller
public class RecomCtrl {
    @Autowired
    private RecService recService;

    @RequestMapping(value = {"/changeUser"})
    @ResponseBody
    public List<News> changeUser(Long uid, int sid){
        switch (sid){
            case 0:
                Main.main(false,false,false,uid);
                break;
            case 1:
                Main.main(false,true,false,uid);
                break;
            case 2:
                Main.main(true,false,false,uid);
                break;
            case 3:
                Main.main(true,true,false,uid);
                break;
        }
        return recService.Rec(uid);
    }

    @RequestMapping(value = {"/hotNews"})
    @ResponseBody
    public List<News> hotNews(){
        Main.main(false,false,true,1L);
        return recService.Rec();
    }

    @RequestMapping(value = {"/flash"})
    @ResponseBody
    public List<News> flash(Long uid){
        return recService.flash(uid);
    }

    @RequestMapping(value = {"/log"})
    @ResponseBody
    public String log(Long uid,Long nid){
        recService.log(uid,nid);
        return "ok";
    }
}
