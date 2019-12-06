package org.ssm.dufy.service.impl;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.placepoint.PLACEPOINTINFO;
import org.ssm.cxf.struct.placepoint.PLACEPOINTINFOREQ;
import org.ssm.cxf.struct.placepoint.PLACEPOINTINFORESP;
import org.ssm.dufy.dao.IPlacePointDao;
import org.ssm.dufy.entity.cerppojo.PlacePoint;
import org.ssm.dufy.service.IPlacePointService;

@Service("placePointService")
public class IPlacePointServiceImpl implements IPlacePointService {

	@Autowired
	public IPlacePointDao placePointdao;
	
	
	@Override
	public String getPlacePoint(String entryid, String xmldata) {
		PLACEPOINTINFOREQ placepintinfo_req = JAXBUtil.unmarshToObjBinding(PLACEPOINTINFOREQ.class, xmldata, "UTF-8");
		String placepoint = placepintinfo_req.getPLACEPOINTID();
		String ym = placepintinfo_req.getYM();		
		if(StringUtil.isEmpty(ym) || !StringUtil.isNumeric(ym)) ym = "1";
		
		String retxml = "";		
		List<PlacePoint> placepointlist = (List<PlacePoint>) placePointdao.getPlacePointByParam(entryid, placepoint, Integer.valueOf(ym));
		PLACEPOINTINFORESP placepointinforesp = new PLACEPOINTINFORESP();
		List<PLACEPOINTINFO> placepointinfolist = placepointinforesp.getPLACEPOINTINFO();
		
		for(PlacePoint p : placepointlist) {
			PLACEPOINTINFO placepointinfo = new PLACEPOINTINFO();
			placepointinfo.setPLACEPOINTID(p.getPlacepointid());
			placepointinfo.setPLACEPOINTNAME(p.getPlacepointname());
			placepointinfo.setTEL(p.getTel());
			placepointinfo.setADDRESS(p.getAddress());
			placepointinfolist.add(placepointinfo);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(PLACEPOINTINFORESP.class, placepointinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return retxml;
	}


}
