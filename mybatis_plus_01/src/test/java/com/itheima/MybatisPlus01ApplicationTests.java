package com.itheima;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.AnimeInfoDao;
import com.itheima.pojo.AnimeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
class MybatisPlus01ApplicationTests {


	@Autowired
	private AnimeInfoDao animeInfoDao;

	@Test
	void insertOne(){

		AnimeInfo animeInfo = new AnimeInfo();
		animeInfo.setName("刀剑神域Alicization");
		animeInfo.setReleaseTime(2018);
		animeInfo.setId(28);
		animeInfo.setCharacter01("Alici爱丽丝");
		animeInfo.setCharacter02("Eugeo尤吉欧");
		int insert = animeInfoDao.insert(animeInfo);
		System.out.println(insert>0?"true":"false");
	}

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
