package top.lrshuai.optimisticlock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lrshuai.optimisticlock.usr.entity.UserAccount;
import top.lrshuai.optimisticlock.usr.mapper.UserAccountMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptimisticLockApplicationTests {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Test
    public void contextLoads() throws Exception {
        UserAccount userAccount = userAccountMapper.getUserAccountByUserId(1l);
        System.out.println(userAccount.toString());
        System.out.println(userAccount.getBalance());
    }

}
