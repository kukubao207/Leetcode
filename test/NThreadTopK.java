package tx;

import java.io.File;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;

public class NThreadTopK {
    public static File[] filelist = new File[100000];   //存放文件
    public static int idx = 0;                          //统计总文件数量
    public static List<File> res = new ArrayList<>();   //存放结果
    public static int block = 10000;                    //拆分块的大小
    public static int k = 20;                           //找topK
    public static CountDownLatch latch;
    public static PriorityBlockingQueue<File> priorityBlockingQueue = new PriorityBlockingQueue<File>(k, new cmp());

    public static class cmp implements Comparator<File> {
        @Override
        public int compare(File f1, File f2) {
            if (f1.length() > f2.length()) {
                return -1;
            } else if (f1.length() == f2.length()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        //1.递归搜索文件目录找出所有文件
        getFileList("/Users/wjq/Desktop");

        //2.拆分文件成为num块，开num个线程去处理
        int num = idx / block;
        latch = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            int start = i * block, end = Math.min((i + 1) * block - 1, idx - 1);
            File[] tempF = new File[Math.min(block, end - start + 1)];
            for (int k = 0, j = start; j <= end; j++, k++) {
                tempF[k] = filelist[j];
            }
            Thread mythread = new MyThread(tempF, 0, 9999);
            mythread.start();
        }
        System.out.println("所有线程已经完成工作");
        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.输出结果
        for (int i = 0; i < k; i++) {
            File curFile = priorityBlockingQueue.poll();
            System.out.println(curFile.getName() + " : " + curFile.length());
        }
    }

    public static void getFileList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    getFileList(files[i].getAbsolutePath());
                } else {
                    filelist[idx++] = (files[i]);
                }
            }
        }
    }

    public static class MyThread extends Thread {
        private int lo;
        private int hi;
        private File[] file;

        public MyThread(File[] file, int lo, int hi) {
            this.file = file;
            this.lo = lo;
            this.hi = hi;
        }

        public void run() {
            try {
                while (lo < hi) {
                    int onePartition = partition(file, lo, hi);
                    if (onePartition == k) {
                        break;
                    } else if (onePartition > k) {
                        hi = onePartition - 1;
                    } else if (onePartition < k) {
                        lo = onePartition + 1;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                for (int i = 0; i < k; i++) {
                    priorityBlockingQueue.add(file[i]);
                }
                latch.countDown();
            }
        }

        public int partition(File[] nums, int start, int end) {
            int index = start;
            File endFile = nums[end];
            for (int i = start; i < end; i++) {
                if (nums[i].length() > nums[end].length()) {
                    //交换两个file的位置
                    File temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    index++;
                }
            }
            File temp = nums[index];
            nums[index] = endFile;
            nums[end] = temp;
            return index;
        }
    }
}