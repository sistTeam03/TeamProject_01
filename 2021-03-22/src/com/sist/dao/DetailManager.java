package com.sist.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;



public class DetailManager {
	
	public void detailData() {
			DetailDAO dao=new DetailDAO();
		
		try {
			List<DetailVO> list=dao.linkList();
			int i=1;
			for(DetailVO vo:list) {
				
				String url=vo.getLiked();
				int no=vo.getNo();
				Document doc=Jsoup.connect(url).get();
				
				Elements title=doc.select("div.st3 h3");
				Elements poster=doc.select("div.centeredcrop img");
				Elements chef=doc.select("span.user_info2_name");
				Elements chef_poster=doc.select("div.user_info2 img"); 
				Elements info=doc.select("div.view2_summary_in "); //v-4000
				Elements info1=doc.select("span.view2_summary_info1"); //양
				Elements info2=doc.select("span.view2_summary_info2");	//시간
				Elements info3=doc.select("span.view2_summary_info3");	//난이도
				Elements ingre=doc.select("div.ready_ingre3 li");    //    보류+???
				Elements content=doc.select("div.view_step_cont"); //clob 보류+요리 이미지 생각+오래된 글 안긁힘
				
				Elements hit=doc.select("div.view_cate_num");
				Elements like=doc.select("div.st2 div.reply_tit #recipeCommentListCount");
				Elements regdate=doc.select("p.view_notice_date");
				Elements chef_msg=doc.select("p.cont_intro");
				Elements old_content=doc.select("div.view_cont_old");
				
				List<String> eList=new ArrayList<String>();
				//이미지 개수 세기
				Elements poster_count=doc.select("div.view_step_cont");
				String p_count=poster_count.toString();
				p_count=p_count.replaceAll("stepimg", "@");
				StringTokenizer st=new StringTokenizer(p_count,"@");//포스터 개수세기
				String content_poster="";
				for(int j=1; j<st.countTokens();j++) {
					String eList_e=doc.select("div#stepimg"+j+" img").attr("src");
					eList.add(eList_e);
					
				} 
				for(int j=0; j<st.countTokens()-1;j++) {
					
					
					content_poster=content_poster+eList.get(j).toString()+",";
				}
				content_poster=content_poster.substring(0,content_poster.lastIndexOf(","));
				String old_count=old_content.text();
				
					
				
				if(old_count.length()>0) { //old content이면 맨 처음으로
					System.out.println("old pass...");
					continue;
				}
				

				vo.setNo(no);
				//System.out.println(title.text());
				vo.setTitle(title.text());
				vo.setChef(chef.text());
				vo.setPoster(poster.attr("src"));
				//System.out.println(poster.attr("src"));
				//System.out.println(chef.text());
				//System.out.println(chef_poster.attr("src"));
				vo.setChef_poster(chef_poster.attr("src"));
				//System.out.println(info.text());
				vo.setInfo(info.text());
				vo.setInfo1(info1.text());
				vo.setInfo2(info2.text());
				vo.setInfo3(info3.text());
				//System.out.println(info1.text());
				//System.out.println(info2.text());
				//System.out.println(info3.text());
				vo.setIngre(ingre.text());
				vo.setContent(content.text());
				//System.out.println(ingre.text());
				//System.out.println(content.text());
				//System.out.println(content_poster);
				vo.setContent_poster(content_poster);
				//System.out.println(hit.text());
				vo.setHit(hit.text());
				//System.out.println(like.text());
				vo.setLiked(like.text());
				//System.out.println(regdate.text());
				vo.setRegdate(regdate.text());
				//System.out.println(chef_msg.text());
				vo.setChef_msg(chef_msg.text());
				System.out.println(no);
				System.out.println("============="+i+"번==================");
				i++;
				
				//dao.insertList(vo);
				Thread.sleep(100);
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}//detailData()
	public static void main(String[] args) {
		DetailManager dm=new DetailManager();
		dm.detailData();
	}
}//class
