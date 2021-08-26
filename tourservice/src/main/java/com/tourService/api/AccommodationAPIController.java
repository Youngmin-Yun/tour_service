package com.tourService.api;

import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.tourService.service.AccommodationService;
import com.tourService.vo.AccommodationVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@RestController
public class AccommodationAPIController {
    @Autowired
    AccommodationService service;
    @GetMapping("/api/accommodation")
    public Map<String, Object> getAccommodationInfo()throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchStay"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=Qvh%2FPxBBmg3Pp64QitOr7PScIkH25vOjdehJK4Fr4N2ITDAoFZl7TONz6l%2Bovat%2BrMpoRgfFwWIXMssHOkAmVw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000000000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*(A=제목순,B=조회순,C=수정순,D=생성일순) 대표이미지가 반드시 있는 정렬 (O=제목순, P=조회순, Q=수정일순, R=생성일순)*/
        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록구분(Y=목록,N=개수)*/
        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*지역코드*/
        urlBuilder.append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시군구코드(areaCode 필수)*/
        urlBuilder.append("&" + URLEncoder.encode("hanOk","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*한옥 여부*/
        urlBuilder.append("&" + URLEncoder.encode("benikia","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*베니키아 여부*/
        urlBuilder.append("&" + URLEncoder.encode("goodStay","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*굿스테이 여부*/
        urlBuilder.append("&" + URLEncoder.encode("modifiedtime","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*콘텐츠 수정일*/
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
            AccommodationVO vo = new AccommodationVO();
            vo.setAddr1(getTagValue("addr1", elem));
            vo.setAddr2(getTagValue("addr2",elem));
            vo.setAreacode(getTagValue("areacode",elem));
            vo.setBenikia(getTagValue("benikia",elem));
            vo.setCat1(getTagValue("cat1",elem));
            vo.setCat2(getTagValue("cat2",elem));
            vo.setCat3(getTagValue("cat3",elem));
            vo.setContentid(getTagValue("contentid",elem));
            vo.setContenttypeid(getTagValue("contenttypeid",elem));
            vo.setCreatedtime(getTagValue("createdtime",elem));
            vo.setFirstimage(getTagValue("firstimage",elem));
            vo.setFirstimage2(getTagValue("firstimage2",elem));
            vo.setGoodStay(getTagValue("goodStay",elem));
            vo.setHanok(getTagValue("hanok",elem));
            vo.setMapx(getTagValue("mapx",elem));
            vo.setMapy(getTagValue("mapy",elem));
            vo.setMlevel(getTagValue("mlevel",elem));
            vo.setModifiedtime(getTagValue("modifiedtime",elem));
            vo.setReadcount(getTagValue("readcount",elem));
            vo.setSigungucode(getTagValue("sigungucode",elem));
            vo.setTel(getTagValue("tel",elem));
            vo.setTitle(getTagValue("title",elem));
            service.insertAccommodationInfo(vo);
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

    @GetMapping("/api/accommodation/search")
    public void searchAccommodation(){}
    
    @GetMapping("/api/accommodation/result")
    public Map<String, Object> resultAccommodation(@RequestParam @Nullable String type, @RequestParam String region){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        type = "%"+type+"%";
        region = region+"%";
        List<AccommodationVO> list = service.selectAccommodation(type, region);
        resultMap.put("list", list);
        return resultMap;
    }
        
}
