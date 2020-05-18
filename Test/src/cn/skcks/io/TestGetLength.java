package cn.skcks.io;

import java.io.File;
import java.util.Objects;

/*
    遍历文件夹 核心方法
    封装为独立方法类
 */
public class TestGetLength {
    private long length = 0;
    File file;
    private String path = "";
    private long fileNum = 0;
    private long dirNum = 0;

    public TestGetLength(File file) {
        this.file = file;
        this.path = file.getAbsolutePath();

        if (file.isFile()) {
            fileNum = 1;
            length = file.length();
        } else if (file.isDirectory()) {
            dirNum += 1;
            for (File dir : Objects.requireNonNull(file.listFiles())) {
                TestGetLength info = new TestGetLength(dir);
                dirNum += info.getDirNum();
                length += info.getLength();
                fileNum += info.getFileNum();
            }
        }
    }

    public long getLength() {
        return length;
    }

    public long getFileNum() {
        return fileNum;
    }

    public long getDirNum() {
        return dirNum;
    }

    public String getPath() {
        return path;
    }

    public String getSize(long size){
        String[] unit = {"B","K","M","G","T"};
        int i;

        for (i=0;i<unit.length;i++)
        {
            if(size >= 1024)
            {
                size /= 1024;
            }
            else{
                break;
            }
        }

        return size + " " + unit[i];

    }

    @Override
    public String toString() {
        if (file.isFile()) {
            return "文  件大小：" + getSize(length) + "\t 路径：" + path;
        } else if (file.isDirectory()) {
            return "文件夹大小：" + getSize(length) + "\t 文件夹数量：" + dirNum + "\t 文件数量：" + fileNum + "\t 路径：" + path;
        } else {
            return null;
        }

    }
}
