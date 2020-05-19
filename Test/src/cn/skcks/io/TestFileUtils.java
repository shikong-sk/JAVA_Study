package cn.skcks.io;

import java.io.*;

/*
    封装 文件操作 类
 */
public class TestFileUtils {
    public static void main(String[] args) {

        byte[] data = new byte[0];

        // 文件到文件
        try {
            InputStream src = new FileInputStream("io/TestStream_copy");
            OutputStream dest = new FileOutputStream("io/TestFileUtils");

            copy(src, dest);

            System.out.println("文件\t\t => \t\t文件\t\t操作成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 文件到字节数组
        try {
            InputStream src = new FileInputStream("io/TestStream_copy");
//            OutputStream dest = new ByteArrayOutputStream();
            ByteArrayOutputStream dest = new ByteArrayOutputStream();

            copy(src, dest);

//            data = ((ByteArrayOutputStream) dest).toByteArray();
            data = dest.toByteArray();

            System.out.println("文件\t\t => \t\t字节数组\t操作成功");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 字节数组到文件
        try {
            InputStream src = new ByteArrayInputStream(data);
            OutputStream dest = new FileOutputStream("io/TestFileUtils");

            copy(src, dest);

            System.out.println("字节数组\t => \t\t文件\t\t操作成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 操作 输入、输出流
    public static void copy(InputStream inputStream, OutputStream outputStream) {
//        try {
//            byte[] flush = new byte[1024 / 2];
//            int len;
//
//            while ((len = inputStream.read(flush)) != -1) {
//                outputStream.write(flush, 0, len);
//            }
//
//            // 刷新缓冲区
//            outputStream.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            close(inputStream,outputStream);
//        }

        // JDK1.9之前版本 不支持直接使用 需要重新声明
        try(InputStream input = inputStream;OutputStream output = outputStream) {
            byte[] flush = new byte[1024 / 2];
            int len;

            while ((len = input.read(flush)) != -1) {
                output.write(flush, 0, len);
            }

            // 刷新缓冲区
            output.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static void close(InputStream inputStream, OutputStream outputStream) {
//        try {
//            outputStream.close();
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    // 封装close方法 通过可变参数 批量释放资源
//    private static void close(Closeable... streams){
//        for(Closeable stream:streams)
//        {
//            if(stream != null)
//            {
//                try {
//                    stream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

}
