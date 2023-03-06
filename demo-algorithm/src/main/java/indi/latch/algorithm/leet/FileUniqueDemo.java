package indi.latch.algorithm.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: FileUniqueDemo
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/3/3
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class FileUniqueDemo {

    public static void main(String[] args) {
        FileUniqueDemo fileUniqueDemo = new FileUniqueDemo();
        String[] names = new String[]{"gta","gta(1)","gta","avalon"};
        System.out.println(fileUniqueDemo.getFolderNames(names));
    }

    public String[] getFolderNames(String[] names) {
        Set<String> nameSet = new HashSet<>(names.length);

        for (int i = 0; i < names.length; i++) {
            int j = 1;
            String resContains = names[i];
            while (nameSet.contains(resContains)) {
                resContains = names[i] + "(" + j + ")";
                j++;
            }
            names[i] = resContains;
            nameSet.add(names[i]);
        }

        return names;
    }
}