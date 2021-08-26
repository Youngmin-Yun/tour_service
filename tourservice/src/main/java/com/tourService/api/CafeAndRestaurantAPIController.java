package com.tourService.api;

import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.tourService.service.CafeAndRestaurantService;
import com.tourService.vo.CafeAndRestaurantVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@RestController
public class CafeAndRestaurantAPIController {
    @Autowired
    CafeAndRestaurantService service;
    @GetMapping("/api/cafeandrestaurant")
    public Map<String, Object> insertCafeAndRestaurantInfo()throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/DataLabService/tmapFoodTarItsBroDDList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=Qvh%2FPxBBmg3Pp64QitOr7PScIkH25vOjdehJK4Fr4N2ITDAoFZl7TONz6l%2Bovat%2BrMpoRgfFwWIXMssHOkAmVw%3D%3D"); /*Service Key*/
        // urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("인증키 (URL- Encode)", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("baseYm","UTF-8") + "=" + URLEncoder.encode("202106", "UTF-8")); /*시작연월(yyyyMM)*/
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
            CafeAndRestaurantVO vo = new CafeAndRestaurantVO();
            vo.setAreaCode(getTagValue("areaCode", elem));
            vo.setAreaNm(getTagValue("areaNm", elem));
            vo.setBaseYm(getTagValue("baseYm", elem));
            vo.setDtlAddrNm(getTagValue("dtlAddrNm", elem));
            vo.setItsBroNm(getTagValue("itsBroNm", elem));
            vo.setRk(getTagValue("rk", elem));
            vo.setSignguCode(getTagValue("signguCode", elem));
            vo.setSignguNm(getTagValue("signguNm", elem));
            vo.setTotlYn(getTagValue("totlYn", elem));
            service.insertCafeAndRestaurantInfo(vo);
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

    @GetMapping("/api/cafeAndRestaurant")
    public Map<String, Object> getCafeAndRestaurantInfo(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<CafeAndRestaurantVO> list = service.selectCafeAndRestaurantInfo();
        resultMap.put("data", list);
        return resultMap;
    }
}
