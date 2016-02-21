package com.movile.study.java8.stream.collecting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Collecting7 {

    public static void main(String[] args) {
        
        //long start = System.currentTimeMillis();
        for (int i = 0; i < 4; i++) {
            try (Stream<String> lines = Files.lines(Paths.get("portability.txt"))) {
                long start = System.currentTimeMillis();
                //long total = lines.count();
                
                Map<String, Long> portibilityByCarrier = lines.parallel()
                        .map((line) -> line.split(","))
                        .collect(Collectors.groupingByConcurrent((lineArr) ->  lineArr[1], Collectors.counting()));
                System.out.println(portibilityByCarrier);
                System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
               // System.out.println("total: " + total);
                
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
    }

}
