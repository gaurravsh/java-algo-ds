package com.gshar.dsalgo.memorymgmt;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class UseMXBean {

    // Learned via pluralsight
    // https://app.pluralsight.com/course-player?clipId=ca0f8687-a0a2-48a0-82a2-30c6d7929bbf
    public static void main(String[] args){
        List<GarbageCollectorMXBean> gcBeansList = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean gcBean : gcBeansList){
            System.out.println("Bean Name : "+gcBean.getName());
            System.out.println("Number of Collections : "+gcBean.getCollectionCount());
            System.out.println("Collection Time : "+gcBean.getCollectionTime()+" ms");
            System.out.println("Is Valid? : "+gcBean.isValid());

            for (String poolname : gcBean.getMemoryPoolNames()) {
                System.out.println("Poolname : " + poolname);
            }
            System.out.println();
        }

        // I tried creating an increasing array list to test if GC is called.
        // Throws out of memory exception for : long size = 1000_000_000;
        // I did not bother to tune the heap size with VM arguments
        // Works well for long size = 100_000_000;
        long size = 100_000_000;
        List<Integer> list = new ArrayList<>();
        for(long i=0;i<size;i++){
            list.add(0);
        }

        for(GarbageCollectorMXBean gcBean : gcBeansList){
            System.out.println("Bean Name : "+gcBean.getName());
            System.out.println("Number of Collections : "+gcBean.getCollectionCount());
            System.out.println("Collection Time : "+gcBean.getCollectionTime()+" ms");
            System.out.println("Is Valid? : "+gcBean.isValid());

            for (String poolname : gcBean.getMemoryPoolNames()) {
                System.out.println("Poolname : " + poolname);
            }
            System.out.println();
        }
    }

}
