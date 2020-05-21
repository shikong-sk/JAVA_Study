package cn.skcks.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
    利用 RandomAccessFile
    实现 文件分块切割
 */
public class TestSplitFile_1 {
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

    public TestSplitFile_1(String src, String destDir){
        // 默认块大小 1024B * 4 = 4K
        this(src,destDir,1024 * 4);
    }

    public TestSplitFile_1(String src, String destDir, int blockSize){
        this.src = new File(src);
        this.destDir = destDir;
        this.blockSize = blockSize;

        this.destPath = new ArrayList<>();

        // 初始化
        init();
    }

    public TestSplitFile_1(File src, String destDir, int blockSize){
        this.src = src;
        this.destDir = destDir;
        this.blockSize = blockSize;

        this.destPath = new ArrayList<>();

        // 初始化
        init();
    }

    private void init(){
        // 文件总大小
        long len = this.src.length();
        // 文件分割块数
        this.size = (int)Math.ceil(len*1.0/this.blockSize);

        // 分割文件路径
        for (int i = 0; i < size; i++) {
            this.destPath.add(this.destDir + "/" + this.src.getName() + "." + i + ".block");
        }

    }

    // 文件分割
    // 计算每一块的起始位置 分割文件
    public void split(){
        long len = this.src.length();

        long beginPos = 0;

        // 切割大小
        long splitSize = (int)(blockSize>len?len:blockSize);

        File destDir = new File(this.destDir);

        if(!destDir.exists())
        {
            destDir.mkdirs();
        }
        else if(destDir.isFile())
        {
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
                split(i,beginPos,(int)splitSize);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("分块文件：" + this.destPath.get(i) + "\t 文件大小："+splitSize);
        }
    }

    private void split(int i,long beginPos, int size) throws IOException {
        RandomAccessFile splitFile = new RandomAccessFile(this.src,"r");
        RandomAccessFile outputFile = new RandomAccessFile(this.destPath.get(i),"rw");

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

    public static void main(String[] args) {
        // 源文件 目标路径 文件分块个每块的大小
        TestSplitFile_1 testSplitFile =  new TestSplitFile_1("io/TestStream_copy","io/TestSplitFile",8);
        testSplitFile.split();
    }
}
