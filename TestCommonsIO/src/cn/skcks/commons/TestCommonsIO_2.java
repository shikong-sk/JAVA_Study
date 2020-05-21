package cn.skcks.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.*;

import java.io.File;
import java.util.Collection;

/*
    CommonsIO 库
    列出子孙级文件、目录
 */
public class TestCommonsIO_2 {
    public static void main(String[] args) {
//        Collection<File> fileCollections = FileUtils.listFilesAndDirs(new File("lib"), EmptyFileFilter.NOT_EMPTY, null);

//        // 遍历子孙级目录、文件
//        Collection<File> fileCollections = FileUtils.listFilesAndDirs(new File("./"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);

        // 过滤文件后缀
//        Collection<File> fileCollections = FileUtils.listFilesAndDirs(new File("./"), new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);

        // 过滤多个文件后缀
        Collection<File> fileCollections = FileUtils.listFilesAndDirs(
                new File("./"), FileFilterUtils.or(
                        new SuffixFileFilter("java"),
                        new SuffixFileFilter("class"),
                        EmptyFileFilter.NOT_EMPTY),
                DirectoryFileFilter.INSTANCE);

        for (File file : fileCollections
        ) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
