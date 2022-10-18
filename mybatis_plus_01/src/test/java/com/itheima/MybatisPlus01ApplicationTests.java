package com.itheima;

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
	void contextLoads() {

		List<AnimeInfo> animeInfos = animeInfoDao.selectList(null);
		animeInfos.forEach(System.out::println);

	}

}
