package com.mrc.miniboot;

import com.mrc.miniboot.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MiniBootApplicationTests {
    @Test
    public void tt1(){
        LoginController l1 = new LoginController();
    }
}
