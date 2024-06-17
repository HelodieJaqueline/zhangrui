package com.zhangrui.study.script;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.io.File;

public class AutoAsktao {

    // 设置常量，例如NPC的图像路径
    private static final String[] NPC_IMAGES = {
            "C:\\dev\\project\\zhangrui\\src\\main\\resources\\pic\\han_zhong_li.png", "C:\\dev\\project\\zhangrui\\src\\main\\resources\\pic\\lan_cai_he.png"
    };
    private static final String FIGHT_BUTTON_IMAGE = "C:\\dev\\project\\zhangrui\\src\\main\\resources\\pic\\fight_option.png";
    private static final String TASK_LIST_IMAGE = "task_list.png";
    private static final String NEXT_NPC_IMAGE = "next_npc.png";
    private static final String BATTLE_END_IMAGE = "C:\\dev\\project\\zhangrui\\src\\main\\resources\\pic\\end.png";

    public static void main(String[] args) {
        Screen screen = new Screen();

        try {
            for (int i = 0; i < 5; i++) {
                for (String npcImage : NPC_IMAGES) {

                    // 找到并点击当前NPC
                    Match match = screen.exists(new Pattern(npcImage), 5);
                    if (match != null) {
                        screen.click(new Pattern(npcImage));

                        // 等待对话框出现
                        screen.wait(new Pattern(npcImage), 5);

                        // 选择战斗选项
                        if (screen.exists(new Pattern(FIGHT_BUTTON_IMAGE), 10) != null) {
                            screen.click(new Pattern(FIGHT_BUTTON_IMAGE));

                            // 等待战斗结束
                            screen.wait(new Pattern(BATTLE_END_IMAGE), 60);
                        }
                    }
                }
            }
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }


}
