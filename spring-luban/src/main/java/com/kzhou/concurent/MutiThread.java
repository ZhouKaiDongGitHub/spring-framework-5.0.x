package com.kzhou.concurent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * JMX类查看程序运行的线程
 */
public class MutiThread {
	public static void main(String[] args) {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true,true);
		for(ThreadInfo threadInfo: threadInfos){
			System.out.println("["+threadInfo.getThreadId()+"] "+threadInfo.getThreadName());
		}
	}
}
