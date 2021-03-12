package top.qianxinyao.service;

import org.apache.avro.generic.GenericData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qianxinyao.dao.RecDao;
import top.qianxinyao.model.News;
import top.qianxinyao.model.Recommendations;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecService {



    public List<News> Rec(Long uid) {
        RecDao dao = new RecDao();
        return dao.findAllByUserId(uid);
    }

    public List<News> Rec() {
        RecDao dao = new RecDao();
        return dao.findAllHOT();
    }


    public List<News> flash(Long uid) {
        return new RecDao().flash(uid);
    }

    public void log(Long uid, Long nid) {
        new RecDao().log( uid,  nid);
    }
}


