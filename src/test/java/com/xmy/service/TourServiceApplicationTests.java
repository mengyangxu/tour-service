package com.xmy.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.xmy.bean.bean.Article;
import com.xmy.bean.vo.ArticleInfo;
import com.xmy.bean.vo.ArticleSearch;
import com.xmy.service.dao.ArticleDao;
import com.xmy.service.dao.UserDao;
import com.xmy.service.service.ArticleService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourServiceApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleService articleService;

	@Test
	public void contextLoads() {
       // List<ArticleInfo> list = articleService.getArticleInfo();
        //com.xmy.bean.bean.User user = userDao.getByUsernameAndPassword("umy","111");
        //articleService.addArticle(new Article());
        //articleDao.insert(null,null,null,null,null,null);
        //com.xmy.bean.bean.User user = new com.xmy.bean.bean.User();
        //user.setEmail("160694");
        //userDao.update(1,"大哥哥",user.getSex(),user.getEmail(),"3435345");

        ArticleSearch as = new ArticleSearch();
        as.setCurrentResult(0);
        as.setPageSize(10);
        as.setNowdays("month");
        List<ArticleInfo> list = articleService.getArticleBySearch(as);

	}


    public static void create(){
        int width = 300;
        int height = 300;
        String format = "png";
        String content = "http://120.79.211.240:8080/";
        //定义二维码的参数
        HashMap map = new HashMap();
        //设置编码
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //设置纠错等级
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        map.put(EncodeHintType.MARGIN, 2);

        try {
            //生成二维码
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
            Path file = new File("F:/qrcode.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
