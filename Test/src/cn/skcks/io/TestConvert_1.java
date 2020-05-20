package cn.skcks.io;

import java.io.*;

/*
    转换流
    字节流转换为字符流
    InputStreamWriter InputStreamReader
    以字符集形式操作字节流
    可以指定字符集
    使用缓冲流提升效率
 */
public class TestConvert_1 {
    public static void main(String[] args) {
        try (
                BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter outputStreamWriter = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {

            String input = "";

            while (!input.equals("quit"))
            {
                input = inputStreamReader.readLine();
                outputStreamWriter.write(input);
                outputStreamWriter.newLine();

                outputStreamWriter.flush();             // 强制刷新缓存
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
