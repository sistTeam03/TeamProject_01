package com.sist.dao;


import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ListManager {
	public void listData() {
		try {
			//3880page
			for(int k=1; k<3881; k++) {
				
			
			String url="https://www.10000recipe.com/recipe/list.html?order=reco&page=2";
			Document doc=Jsoup.connect(url).get();
			Elements title=doc.select("div.line2");
			Elements poster=doc.select("a.common_sp_link img");
			Elements chef_poster=doc.select("div.common_sp_caption_rv_name img");
			Elements chef=doc.select("div.common_sp_caption_rv_name a");
	
			Elements link=doc.select("div.common_sp_thumb a");
			Elements hit=doc.select("span.common_sp_caption_buyer");
			Elements rating=doc.select("div.common_sp_caption_rv");
			Elements count_review=doc.select("div.common_sp_caption_rv");
			for(int i=0; i<title.size(); i++) {
				
			//System.out.println(title.get(i).text());
				ListVO vo=new ListVO();
				ListDAO dao=new ListDAO();
				vo.setTitle(title.get(i).text());
			//System.out.println(poster.get(i).attr("src"));
				vo.setPoster(poster.get(i).attr("src"));
			//System.out.println(chef_poster.get(i).attr("src"));
				vo.setChef_poster(chef_poster.get(i).attr("src"));
			//System.out.println(chef.get(i).text());
				vo.setChef(chef.get(i).text());
			
			
			//System.out.println(strReview);
			//System.out.println("https://www.10000recipe.com"+link.get(i).attr("href"));
				vo.setLink("https://www.10000recipe.com"+link.get(i).attr("href"));
			String strHit=hit.get(i).text();
			strHit=strHit.substring(4);
			//System.out.println(strHit);
				vo.setHit(strHit);
				String strRating=rating.get(i).toString();
				System.out.println(strRating);
				StringTokenizer st=new StringTokenizer(strRating, ">");
				System.out.println(st.countTokens());
				int count=st.countTokens();			
				if(count==4){//개수로  재설정 평점이 없으면 4
								//평점이 없으면 리뷰 카운트도 없음
					count=0;
					vo.setRating(count);
					vo.setCount_review(count);
					System.out.println(count);
				}else {
					count=count-8;
					vo.setRating(count);
					String strReview=count_review.get(i).text();
					StringTokenizer stz=new StringTokenizer(strReview,")");
					
					
					strReview=stz.nextToken().replaceAll("[^0-9]", "");
					vo.setCount_review(Integer.parseInt(strReview));
					System.out.println(count);
					System.out.println(strReview);
				}

						
				dao.insertList(vo); 
				
				Thread.sleep(50);
				System.out.println("=======");
			}//1page-for
			
			}//총페이지for
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void countPage() {//페이지 갯수 구해보기
		int count=0;
		try {
			
			for(int i=1;i<10000; i++) {
				String url="https://www.10000recipe.com/recipe/list.html?order=reco&page="+i;
				Document doc=Jsoup.connect(url).get();
				if(doc!=null) {
					count++;
					System.out.println(count);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		ListManager m=new ListManager();
		
		m.listData();
		
	}
}
