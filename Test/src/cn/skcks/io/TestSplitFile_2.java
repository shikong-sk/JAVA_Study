package cn.skcks.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
    利用 RandomAccessFile
    实现 文件分块切割
 */
public class TestSplitFile_2 {
    // 源文件
    private final File src;

    // 目标路径
    private final String destDir;

    // 目标文件列表
    private final List<String> destPath;

    // 每块大小
    private final int blockSize;

    // 文件分割块数
    private int size;

    public TestSplitFile_2(String src, String destDir) {
        // 默认块大小 1024B * 4 = 4K
        this(src, destDir, 1024 * 4);
    }

    public TestSplitFile_2(String src, String destDir, int blockSize) {
        this.src = new File(src);
        this.destDir = destDir;
        this.blockSize = blockSize;

        this.destPath = new ArrayList<>();

        // 初始化
        init();
    }

    public TestSplitFile_2(File src, String destDir, int blockSize) {
        this.src = src;
        this.destDir = destDir;
        this.blockSize = blockSize;

        this.destPath = new ArrayList<>();

        // 初始化
        init();
    }

    private void init() {
        // 文件总大小
        long len = this.src.length();
        // 文件分割块数
        this.size = (int) Math.ceil(len * 1.0 / this.blockSize);

        // 分割文件路径
        for (int i = 0; i < size; i++) {
            this.destPath.add(this.destDir + "/" + this.src.getName() + "." + i + ".block");
        }

    }

    // 文件分割
    // 计算每一块的起始位置 分割文件
    public void split() {
        long len = this.src.length();

        long beginPos = 0;

        // 切割大小
        long splitSize = (int) (blockSize > len ? len : blockSize);

        File destDir = new File(this.destDir);

        if (!destDir.exists()) {
            destDir.mkdirs();
        } else if (destDir.isFile()) {
            throw new RuntimeException("目标路径下已有同名文件存在,无法继续操作");
        }

        for (int i = 0; i < size; i++) {
            beginPos = i * blockSize;
            if (i == size - 1) {
                splitSize = (int) len;
            } else {
                splitSize = blockSize;
                len -= splitSize;    // 剩余量
            }

            try {
                split(i, beginPos, (int) splitSize);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("分块文件：" + this.destPath.get(i) + "\t 文件大小：" + splitSize);
        }
    }

    private void split(int i, long beginPos, int size) throws IOException {
        RandomAccessFile splitFile = new RandomAccessFile(this.src, "r");
        RandomAccessFile outputFile = new RandomAccessFile(this.destPath.get(i), "rw");

        splitFile.seek(beginPos);

        byte[] flush = new byte[blockSize];
        int len;
        while ((len = splitFile.read(flush)) != -1) {
            if (size > len) {
                outputFile.write(flush, 0, len);
                size -= len;
            } else {
                outputFile.write(flush, 0, size);
                break;
            }
        }
        splitFile.close();
        outputFile.close();
    }


    public void merge(String dest) {
        this.merge(dest, false);
    }

    // 分块文件的合并
    public void merge(String dest, boolean cover) {
        File destFile = new File(dest);
        if (destFile.exists()) {
            if (destFile.isDirectory()) {
                throw new RuntimeException("目标文件已存在同名文件夹,无法继续操作");
            }

            if (cover) {
                destFile.delete();
            } else {
                throw new RuntimeException("目标文件已存在,无法继续操作");
            }
        }

        try (
                OutputStream output = new BufferedOutputStream(new FileOutputStream(destFile, true));
        ) {

            Vector<InputStream> inputStreams = new Vector<>();

            for (String path : this.destPath) {
                inputStreams.add(new BufferedInputStream(new FileInputStream(path)));
            }

            // 序列流
            // 自动资源管理 自动关闭序列流
            try (SequenceInputStream inputStream = new SequenceInputStream(inputStreams.elements())) {
                byte[] flush = new byte[blockSize];
                int len;
                while ((len = inputStream.read(flush)) != -1) {
                    output.write(flush, 0, len);
                }
                output.flush();
            }

            System.out.println("文件块合并完成 \t 文件路径：" + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 源文件 目标路径 文件分块个每块的大小
        TestSplitFile_2 testSplitFile = new TestSplitFile_2("io/TestStream_copy", "io/TestSplitFile", 8);

        // 执行文件分割
        testSplitFile.split();

        // 分块文件合并
        // cover 是否覆盖已有文件
        testSplitFile.merge("io/TestSplitFile/TestSplitFile_merge", true);
    }
}
