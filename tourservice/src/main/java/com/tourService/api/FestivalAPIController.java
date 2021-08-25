package com.tourService.api;

import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import com.tourService.service.FestivalService;
import com.tourService.vo.FestivalVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@RestController
public class FestivalAPIController {
    @Autowired
    FestivalService service;
    @GetMapping("/api/festival")
    public Map<String, Object> insertFestivalInfo()throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=Qvh%2FPxBBmg3Pp64QitOr7PScIkH25vOjdehJK4Fr4N2ITDAoFZl7TONz6l%2Bovat%2BrMpoRgfFwWIXMssHOkAmVw%3D%3D"); /*Service Key*/
        // urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("인증키 (URL- Encode)", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("c", "UTF-8")); /*시작연월(yyyyMM)*/
        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*시작연월(yyyyMM)*/
        urlBuilder.append("&" + URLEncoder.encode("eventStartDate","UTF-8") + "=" + URLEncoder.encode("20200101", "UTF-8")); /*시작연월(yyyyMM)*/
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(urlBuilder.toString());

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("item");
        if(nList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message", "데이터가 없습니다.");
            return resultMap;
        }
        for(int i = 0; i < nList.getLength(); i++){
            Node node = nList.item(i);
            Element elem = (Element) node;
            FestivalVO vo = new FestivalVO();
            vo.setAddr1(getTagValue("addr1", elem));
            vo.setAddr2(getTagValue("addr2", elem));
            vo.setAreacode(getTagValue("areacode", elem));
            vo.setCat1(getTagValue("cat1", elem));
            vo.setCat2(getTagValue("cat2", elem));
            vo.setCat3(getTagValue("cat3", elem));
            vo.setContentid(getTagValue("contentid", elem));
            vo.setContenttypeid(getTagValue("contenttypeid", elem));
            vo.setCreatedtime(getTagValue("createdtime", elem));
            vo.setEventenddate(getTagValue("eventenddate", elem));
            vo.setEventstartdate(getTagValue("eventstartdate", elem));
            vo.setFirstimage(getTagValue("firstimage", elem));
            vo.setFirstimage(getTagValue("firstimage", elem));
            vo.setFirstimage2(getTagValue("firstimage2", elem));
            vo.setMapx(getTagValue("mapx", elem));
            vo.setMapy(getTagValue("mapy", elem));
            vo.setMlevel(getTagValue("mlevel", elem));
            vo.setModifiedtime(getTagValue("modifiedtime", elem));
            vo.setReadcount(getTagValue("readcount", elem));
            vo.setSigungucode(getTagValue("sigungucode", elem));
            vo.setTel(getTagValue("tel", elem));
            vo.setTitle(getTagValue("title", elem));
            service.insertFetivalInfo(vo);
        }
        resultMap.put("status", true);
        resultMap.put("message", "데이터가 입력되었습니다.");
        return resultMap;
    }
    public static String getTagValue(String tag, Element elem){
        if(elem.getElementsByTagName(tag).item(0) == null) return null;
        NodeList nlList = elem.getElementsByTagName(tag).item(0).getChildNodes();
        if(nlList == null) return null;
        Node node = (Node) nlList.item(0);
        if(node == null) return null;
        return node.getNodeValue();
    }
}
