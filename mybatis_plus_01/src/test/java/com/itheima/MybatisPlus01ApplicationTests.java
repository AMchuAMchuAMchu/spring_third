package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.AnimeInfoDao;
import com.itheima.pojo.AnimeInfo;
import com.itheima.pojo.querywrapper.QueryAnime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

import java.util.List;

@SpringBootTest
class MybatisPlus01ApplicationTests {


	@Autowired
	private AnimeInfoDao animeInfoDao;






	@Test
	void testSelectByAge(){

		LambdaQueryWrapper<AnimeInfo> lqw = new LambdaQueryWrapper<>();

		QueryAnime queryAnime = new QueryAnime();
		queryAnime.setReleaseTime(2018);
		queryAnime.setReleaseTime02(2020);

//		lqw.le(AnimeInfo::getReleaseTime,2020);
//		lqw.ge(AnimeInfo::getReleaseTime,2020);
//		lqw.ge(AnimeInfo::getReleaseTime,2010).le(AnimeInfo::getReleaseTime,2018);
//		lqw.le(AnimeInfo::getReleaseTime,2012).or().gt(AnimeInfo::getReleaseTime,2018);
		lqw.le(null!=queryAnime.getReleaseTime02(),AnimeInfo::getReleaseTime,queryAnime.getReleaseTime02()).or().gt(null!= queryAnime.getReleaseTime(),AnimeInfo::getReleaseTime,queryAnime.getReleaseTime());


		List<AnimeInfo> animeInfos = animeInfoDao.selectList(lqw);
		animeInfos.forEach(System.out::println);

	}

	@Test
	void testUpdate(){

		AnimeInfo animeInfo = new AnimeInfo();
		animeInfo.setName("刀剑神域Alicization");
		animeInfo.setReleaseTime(2018);
		animeInfo.setId(28);
		animeInfo.setCharacter01("Alici爱丽丝茅野爱衣");
		animeInfo.setCharacter02("Eugeo尤吉欧");
		int i = animeInfoDao.updateById(animeInfo);
		System.out.println(i>0?"true":"false");

	}

	@Test
	void testDelete(){

		int i = animeInfoDao.deleteById(180);

		System.out.println(i>0?"true":"false");

	}

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
