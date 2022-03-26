package com.nickboomboom.tv.main;

import java.util.ArrayList;
import java.util.List;

public class ChannelList {
	public static List<ChannelBean> setup() {
		List list = new ArrayList<>();

		String[] titles = {
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用测试用测试用测试用",
				"测试用",
		};
		String[] urls = {
				"http://39.134.115.163:8080/PLTV/88888910/224/3221225618/index.m3u8"
		};

		for (int i = 0; i < titles.length; i++) {
			ChannelBean item = new ChannelBean(titles[i], urls);
			list.add(item);
		}

		return list;
	}
}
