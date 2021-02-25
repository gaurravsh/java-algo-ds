package com.gshar.dsalgo.memorymgmt;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class UseMXBean {

    // Learned via pluralsight
    // https://app.pluralsight.com/course-player?clipId=ca0f8687-a0a2-48a0-82a2-30c6d7929bbf
    public static void main(String[] args){
        List<GarbageCollectorMXBean> gcBeansList = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean gcBean : gcBeansList){
            System.out.println("Bean Name : "+gcBean.getName());
            System.out.println("Number of Collections : "+gcBean.getCollectionCount());
            System.out.println("Collection Time : "+gcBean.getCollectionTime());

            for (String poolname : gcBean.getMemoryPoolNames()) {
                System.out.println("Poolname : " + poolname);
            }
            System.out.println();


        }
    }

}
