package com.zhangrui.controller.jvm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模拟cpu飙高情况
 */
@Controller
public class DeadLoopController {

    @RequestMapping("/deadLoop")
    public void deadLoop() {
        for (; ; ) {
            System.out.println("dead loop!");
        }
    }
}
