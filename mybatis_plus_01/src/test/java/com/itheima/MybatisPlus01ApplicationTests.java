package com.itheima;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.AnimeInfoDao;
import com.itheima.pojo.AnimeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlus01ApplicationTests {


	@Autowired
	private AnimeInfoDao animeInfoDao;

	@Test
	void testPage(){

		Page<AnimeInfo> animeInfoPage = new Page<>(1, 4);

		Page<AnimeInfo> animeInfoPage1 = animeInfoDao.selectPage(animeInfoPage, null);

		animeInfoPage1.getRecords().forEach(System.out::println);

	}


	@Test
	void contextLoads() {

		List<AnimeInfo> animeInfos = animeInfoDao.selectList(null);
		animeInfos.forEach(System.out::println);

	}

}
