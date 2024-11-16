package org.example;


import lombok.SneakyThrows;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу https://codeforces.com/contest/356/problem/A
     */
    @SneakyThrows
    public void championship(InputStream in, OutputStream out) {
            try (var sc = new Scanner(in); var pw = new PrintWriter(out)) {
                int n = sc.nextInt();
                int m = sc.nextInt();

                int[] resultArr = new int[n + 1];
                TreeSet<Integer> knights = new TreeSet<>();
                for (int i = 1; i <= n; i++) {
                    knights.add(i);
                }

                for (int i = 0; i < m; i++) {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    int x = sc.nextInt();

                    var participants = knights.subSet(l, true, r, true);

                    List<Integer> toRemove = new ArrayList<>();
                    for (int knight : participants) {
                        if (knight != x) {
                            resultArr[knight] = x;
                            toRemove.add(knight);
                        }
                    }

                    toRemove.forEach(knights::remove);
            }

            for (int i = 1; i <= n; i++) {
                pw.print(resultArr[i]);
                if (i < n) pw.print(" ");
            }
        }

    }

}
