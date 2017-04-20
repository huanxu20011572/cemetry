package com.topsuntech.gUnit.gEU_bzhhUtil.taglib;

import java.util.Map;

import com.topsuntech.gOS.gTaglib.html.KeyValueTag;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_util.entity.Dept;
import com.topsuntech.gUnit.gEU_util.entity.Region;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

public class BzhhParentDeptNameByDeptIdTag extends KeyValueTag {

	@Override
	public Object getValue(Object arg0, Map arg1) {
		if (arg0 == null || "".equals(arg0.toString())) {
			return null;
		}
		try {
				
				String deptShowName="";
				
				if(arg0.toString()!=null&&!arg0.toString().equals("")){
					
						Long userId=Long.parseLong(arg0.toString());
						Long deptId=null;
						Dept dept = Dicts.getDeptById(userId);
						Long levelid=dept.getLevelid();
						Long region=dept.getRegionid();
						deptId=dept.getId();
					
						String regionName="";
						String lastName="";
						Dept dept1=new Dept();
						//循环取公共部分
						while(true){
							dept1=Dicts.getDeptById(deptId);
							
								if(dept1==null||region.longValue()!=dept1.getRegionid().longValue()){
									break;
								}else{
									Region nowRegion=Dicts.getRegionById(dept1.getRegionid());
									if(nowRegion!=null){
										String nowRegionName=nowRegion.getName();
										
										if(dept1.getParentId().intValue()==0){
											break;
										}else{
											if(!lastName.equals(nowRegionName)&&!lastName.equals("")){
												regionName=regionName+nowRegionName;
											}else if(lastName.equals(nowRegionName)){
												if(!dept1.getName().trim().equals(nowRegionName.trim())){
													regionName=regionName+dept1.getName();
												}else{
													regionName=nowRegionName+regionName;
												}
											}
											
											lastName=nowRegionName;
											deptId=dept1.getParentId();
										}
									}else{
										break;
									}
								}
						}
						//市级用户部门显示:格式=上级部门+本级部门
						if(levelid.longValue()==1){
							//市级最高级用户直接显示所在部门；否则：上级部门+本级部门
							if(regionName.equals("")){
								deptShowName=dept.getName();
							}else{
								deptShowName=regionName+dept.getName();
							}
						}else if(levelid.longValue()==2){//区县用户部门显示：格式=区县行政区划+上级部门名称+本级部门名称
								//区县本级直接显示本级部门；否则：区县行政区划+上级部门名称+本级部门名称
								if(regionName.equals("")){
									deptShowName=dept.getName();
								}else{
									deptShowName=regionName+dept.getName();
								}
						}else if(levelid.longValue()==3){//街道用户部门显示：格式=区县行政区划+街道名称+上级部门名称+本级部门名称
							String parentRegionName=Dicts.getRegionById(dept1.getRegionid()).getName();
							//街道本级直接显示区县+部门名称；否则：区县行政区划+街道名称+上级部门名称+本级部门名称
							if(regionName.trim().equals(dept.getName().trim())||regionName.equals("")){
								deptShowName=parentRegionName+dept.getName();
							}else{
								deptShowName=parentRegionName+regionName+dept.getName();
							}
						}
				     }
				
			
				return deptShowName;
		} catch (TSDBException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		 }
		return null;
	}
	


}
