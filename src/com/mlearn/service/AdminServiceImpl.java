package com.mlearn.service;

import com.mlearn.entity.Admin;
import com.mlearn.mapper.AdminMapper;
import com.mlearn.util.EncryptUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    private Logger logger = Logger.getLogger(this.getClass());


    @Override
    public boolean login(Admin admin) {

        try {
            Admin realAdmin = adminMapper.selectByEmail(admin.getEmail());
            String password = EncryptUtil.encrypt(admin.getPassword(), realAdmin.getSalt());

          if (password.equals(realAdmin.getPassword())) {
                String salt = EncryptUtil.createSalt();
                adminMapper.updateSalt(admin.getId(), salt);
                adminMapper.updatePassword(realAdmin.getId(), password);
                return true;
            } else {
                logger.warn("failed ##");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
