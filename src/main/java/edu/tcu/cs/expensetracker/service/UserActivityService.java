package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.UserActivityDao;
import edu.tcu.cs.expensetracker.domain.UserActivity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserActivityService {
    private UserActivityDao userActivityDao;
    private int n=6;
    public UserActivityService(UserActivityDao userActivityDao) {
        this.userActivityDao = userActivityDao;
    }

    public void update(String id, UserActivity updatedUserActivity) {
        updatedUserActivity.setId(id);
        userActivityDao.save(updatedUserActivity);
    }

    public void save(UserActivity newUserActivity) {

        newUserActivity.setId(n++ + "");
        userActivityDao.save(newUserActivity);
    }

    public List<UserActivity> findAll(){
        return userActivityDao.findAll();
    }

    public UserActivity findById(String id){
        return userActivityDao.findById(id).get();
    }

    public void delete(String id) {
         userActivityDao.deleteById(id);
    }
}
