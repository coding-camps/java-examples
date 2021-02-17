package tools;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

public class Files {

    private static FileFilter dirFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    };

    private static FileFilter fileFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.isFile();
        }
    };

    private static List<File> existingDirs = Lists.newLinkedList();
    private static List<File> currentDirs = Lists.newLinkedList();

    private static List<File> listDirs(File rootFile) {
        if (rootFile.isDirectory()) {
            existingDirs.add(rootFile);
            File[] dirs = rootFile.listFiles(dirFilter);
            if (dirs != null && dirs.length != 0) {
                currentDirs.addAll(List.of(dirs));
            }

            while (currentDirs.size() != 0) {
                File currDirFile = currentDirs.remove(0);
                listDirs(currDirFile);
            }
            return existingDirs;

        } else {
            return Lists.newArrayList();
        }
    }


    public static void main(String[] args) {
        String rootPath = "/Volumes/SD64G/";

        File rootFile = new File(rootPath);

        List<File> dirs = listDirs(rootFile);

        for (File dir : dirs) {
            System.out.println(dir);
            File[] files = dir.listFiles(fileFilter);
            if (files == null) {
                continue;
            }
            for (File file : files) {
                if (file.getName().startsWith("._")) {
                    System.out.println("\t" + file.getAbsolutePath());
                    file.deleteOnExit();
                }
            }
        }

    }

}
