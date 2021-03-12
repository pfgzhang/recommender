package top.qianxinyao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.qianxinyao.model.News;
import top.qianxinyao.model.Recommendations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecDao  {

    public List<News> findAllHOT() {
        List<News> NewsList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select DISTINCT news.id,title, url  from news join recommendations on news.id = recommendations.news_id limit 10";
            ps =conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                News news = new News();
                news.setId(resultSet.getLong("id"));
                news.setTitle(resultSet.getString("title"));
                news.setUrl(resultSet.getString("url"));
                NewsList.add(news);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return NewsList;
    }

    public List<News> findAllByUserId(Long uid) {
        List<News> NewsList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select DISTINCT news.id,title, url  from news join recommendations on news.id = recommendations.news_id where user_id = " + uid + " limit 10";
            ps =conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                News news = new News();
                news.setId(resultSet.getLong("id"));
                news.setTitle(resultSet.getString("title"));
                news.setUrl(resultSet.getString("url"));
                NewsList.add(news);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return NewsList;
    }


    //
    public List<News> flash(Long uid) {
        List<News> NewsList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * from news WHERE module_id in (SELECT DISTINCT module_id from news where id in (SELECT news_id FROM recommendations where user_id = "+uid+")) ORDER BY rand()  LIMIT 10; ";
            ps =conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                News news = new News();
                news.setId(resultSet.getLong("id"));
                news.setTitle(resultSet.getString("title"));
                news.setUrl(resultSet.getString("url"));
                NewsList.add(news);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return NewsList;
    }

    public void log(Long uid, Long nid) {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "INSERT INTO newslogs (news_id, user_id) VALUES ( "+nid +" , " +  uid +" )";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
