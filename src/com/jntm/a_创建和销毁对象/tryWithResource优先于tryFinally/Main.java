package com.jntm.a_创建和销毁对象.tryWithResource优先于tryFinally;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    //❌
    //非简洁清晰  异常会覆盖，例如：br.close();的异常会覆盖bw.append(str);的异常
    public static void readFalse(String inputPath, String outputPath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputPath));
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
            List<String> strings = br.lines().collect(Collectors.toList());
            for (String str : strings) {
                bw.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    //⭕️
    //简洁 清晰  异常不会覆盖
    public static void readTrue(String inputPath, String outputPath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
            List<String> strings = br.lines().collect(Collectors.toList());
            for (String str : strings) {
                bw.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
