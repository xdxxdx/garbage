package com.xdx.garbage;

import com.xdx.garbage.common.util.EncryptionUtil;
import com.xdx.garbage.dao.TAdminMapper;
import com.xdx.garbage.entity.TAdmin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@RestController
@SpringBootApplication
@Slf4j
@MapperScan({"com.xdx.garbage.dao"})
public class GarbageApplication {
    @Autowired
    private TAdminMapper adminMapper;


    public static void main(String[] args) {
        SpringApplication.run(GarbageApplication.class, args);
    }

    @RequestMapping("hello")
    public String helloGarbage(){
        TAdmin admin=new TAdmin();
        admin.setUserName("xdx");
        admin.setPwd(EncryptionUtil.encrypt("123456"));
        adminMapper.insertSelective(admin);
        return "hello garbage";
    }
}
