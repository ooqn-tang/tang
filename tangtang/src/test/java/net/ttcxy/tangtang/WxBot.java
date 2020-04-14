package net.ttcxy.tangtang;


import cn.hutool.core.comparator.ComparatorChain;
import cn.hutool.core.util.PinyinUtil;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WxBot {

    public static void main(String[] args) {
        int start = Integer.parseInt("4e00", 16);
        int end = Integer.parseInt("9fa5", 16);
        StringBuilder sb = new StringBuilder();

        Set<String> ls = new HashSet<String>();

        for (int i = start; i <= end; i++) {
            sb.append((char) i);

            String[] strings = PinyinHelper.convertToPinyinArray((char) i);


            if (strings.length != 0){
                for (String s : strings){
                    ls.add(s);
                }

            }else{
                //System.out.println("----------------"+(char)i);
            }

        }
        ;
        System.out.println(ls.size());


        for (String s : ls){

            System.out.println();
        }


        ;
    }



}